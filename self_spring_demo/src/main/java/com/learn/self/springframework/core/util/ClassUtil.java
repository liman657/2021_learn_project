package com.learn.self.springframework.core.util;

import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.FileFilter;
import java.net.URL;
import java.util.HashSet;
import java.util.Set;

/**
 * autor:liman
 * createtime:2021/5/7
 * comment:
 */
@Slf4j
public class ClassUtil {

    public static final String FILE_PROTOCOL = "file";

    /**
     * 获取包名下的所有类集合
     * 需要做的事情
     * 1、获取到类的加载器
     * 2、通过类加载器获取到加载的资源信息
     * 3、依据不同的资源类型，采用不同的方式获取资源的集合
     * @param packageName
     */
    public static Set<Class<?>> extractPackageClass(String packageName){
        //1、获取到类的加载器
        ClassLoader classLoader = getClassLoader();
        //2、通过类加载器获取到加载的资源信息
        URL resource = classLoader.getResource(packageName.replace(".", "/"));
        if(null == resource){
            log.warn("unable to retrieve anything from package : {}",packageName);
            return null;
        }
        //3、依据不同的资源类型，采用不同的方式获取资源的集合
        Set<Class<?>> classSet = null;
        //过滤出文件类型的资源
        if(resource.getProtocol().equalsIgnoreCase(FILE_PROTOCOL)){
            classSet = new HashSet<>();
            File packageDirectory = new File(resource.getPath());
            extractClassFile(classSet,packageDirectory,packageName);
        }
        return classSet;
    }

    /**
     * 递归获取目标package里面的所有class文件(包括子package里的class文件)
     *
     * @return 类集合
     * @param emptyClassSet
     * @param fileSource
     * @param packageName
     */
    private static void extractClassFile(Set<Class<?>> emptyClassSet,File fileSource,String packageName){
        if(!fileSource.isDirectory()){//如果不是文件夹，则直接返回
            return;
        }

        //如果是一个文件夹，则调用其listFiles方法获取文件夹下的文件或文件夹
        File[] files = fileSource.listFiles(new FileFilter() {
            @Override
            public boolean accept(File file) {
                if (file.isDirectory()) {//如果是文件夹，则直接返回，放入待处理集合中
                    return true;
                } else {//如果是文件，则直接加入到类set中
                    String absoluteFilePath = file.getAbsolutePath();
                    if (absoluteFilePath.endsWith(".class")) {
                        add2ClassSet(absoluteFilePath);
                    }
                }
                return false;
            }

            //根据class文件的绝对值路径，获取并生成class对象，并放入classSet中
            private void add2ClassSet(String absoluteFilePath) {
                //1.从class文件的绝对值路径里提取出包含了package的类名
                //如/Users/baidu/imooc/springframework/sampleframework/target/classes/com/learn/entity/dto/MainPageInfoDTO.class
                //需要弄成com.learn.entity.dto.MainPageInfoDTO
                absoluteFilePath = absoluteFilePath.replace(File.separator, ".");
                String className = absoluteFilePath.substring(absoluteFilePath.indexOf(packageName));
                className = className.substring(0, className.lastIndexOf("."));
                //2.通过反射机制获取对应的Class对象并加入到classSet里
                Class targetClass = loadClass(className);
                emptyClassSet.add(targetClass);
            }
        });

        if(files!=null){
            for(File f:files){
                extractClassFile(emptyClassSet,f,packageName);//递归调用
            }
        }
    }

    /**
     * 获取Class对象
     *
     * @param className class全名=package + 类名
     * @return Class
     */
    public static Class<?> loadClass(String className){
        try {
            return Class.forName(className);
        } catch (ClassNotFoundException e) {
            log.error("load class error:", e);
            throw new RuntimeException(e);
        }
    }

    /**
     * 获取到类的加载器
     * @return
     */
    public static ClassLoader getClassLoader(){
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        return contextClassLoader;
    }

}
