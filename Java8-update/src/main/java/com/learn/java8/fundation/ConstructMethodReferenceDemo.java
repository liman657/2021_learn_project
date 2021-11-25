package com.learn.java8.fundation;

import com.learn.java8.fundation.entity.Person;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * autor:liman
 * createtime:2021-11-23
 * comment:构造方法引用实例
 */
@Slf4j
public class ConstructMethodReferenceDemo {

    public static void main(String[] args) {
        List<String> names
                = Arrays.asList("Grace Hopper", "Barbara Liskov", "Ada Lovelace", "Karen Spärck Jones");

        List<Person> personList = names.stream().map(Person::new).collect(Collectors.toList());
        //原有方案
        //List<Person> personList = names.stream().map(t->new Person(t)).collect(Collectors.toList());
        System.out.println(personList);


        Person before = new Person("Grace Hopper");
        List<Person> people = Stream.of(before).collect(Collectors.toList());
        Person after = people.get(0);
        System.out.println(before == after);//TODO:这里的before和after指向同一地址
        before.setName("new user name");
        System.out.println(after.getName());

        //这里用新的构造函数，切断的原有的数据流和新的数据流的联系
        Person newBefore = new Person("new before");
        List<Person> newBeforeStream = Stream.of(newBefore).map(Person::new).collect(Collectors.toList());
        Person newAfterPerson = newBeforeStream.get(0);
        System.out.println(newBefore == newAfterPerson);

        List<String> nameArray = new ArrayList<>();
        nameArray.add("Grace");
        nameArray.add("Hopper");
        List<Person> result = nameArray.stream().map(t -> t.split(" ")).map(Person::new).collect(Collectors.toList());
        System.out.println(result);

        //直接利用Person[]的构造函数
        Person[] personArray = nameArray.stream().map(t -> t.split(" ")).map(Person::new).toArray(Person[]::new);
        for(Person person:personArray){
            System.out.println(person);
        }
    }

}
