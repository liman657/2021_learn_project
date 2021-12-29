
//ztree配置
var setting = {
    data: {
        simpleData: {
            //设置是否启用简单数据格式（zTree支持标准数据格式跟简单数据格式，上面例子中是标准数据格式）
            enable: true,
            //设置启用简单数据格式时id对应的属性名称
            idKey: "deptId",
            //设置启用简单数据格式时parentId对应的属性名称,ztree根据id及pid层级关系构建树结构
            pIdKey: "parentId",
            rootPId: -1
        },
        key: {
            url:"nourl"
        }
    }
};
var ztree;

//treeTable + treeGrid
var Dept = {
    id: "deptTable",
    table: null,
    layerIndex: -1
};


/**
 * 初始化表格的列
 */
Dept.initColumn = function () {
    var columns = [
        {field: 'selectItem', radio: true},
        {title: '部门ID', field: 'deptId', visible: false, align: 'center', valign: 'middle', width: '65px'},
        {title: '部门名称', field: 'name', align: 'center', valign: 'middle', sortable: true, width: '180px'},
        {title: '父级部门', field: 'parentName', align: 'center', valign: 'middle', sortable: true, width: '100px'},
        {title: '排序编号', field: 'orderNum', align: 'center', valign: 'middle', sortable: true, width: '100px'}]
    return columns;
};


function getDeptId () {
    var selected = $('#deptTable').bootstrapTreeTable('getSelections');
    if (selected.length == 0) {
        alert("请选择一条记录");
        return null;
    } else {
        return selected[0].id;
    }
}


$(function () {
    //获取顶级（第一级）部门的id，准备用于做tree table的铺展 - 并做tree table的相关字段的初始化
    $.get(baseURL + "sys/dept/info", function(r){
        var colunms = Dept.initColumn();
        var table = new TreeTable(Dept.id, baseURL + "sys/dept/list", colunms);

        //设置根节点code值----可指定根节点，默认为null,"",0,"0"
        table.setRootCodeValue(r.data.deptId);
        //在哪一列上面显示展开按钮,从0开始
        table.setExpandColumn(2);
        //设置记录返回的id值 ~ 选取记录返回的值
        table.setIdField("deptId");
        //设置记录分级的字段 ~ 用于设置父子关系
        table.setCodeField("deptId");
        //设置记录分级的父级字段 ~ 用于设置父子关系
        table.setParentCodeField("parentId");
        //是否展开
        table.setExpandAll(true);
        table.init();

        Dept.table = table;
    });
});




var vm = new Vue({
    el:'#pmpapp',
    data:{
        showList: true,
        title: null,

        dept:{
            parentName:null,
            parentId:0,
            orderNum:0
        }
    },
    methods: {

        //获取部门列表
        getDept: function(){
            //加载部门树
            $.get(baseURL + "sys/dept/select", function(r){
                ztree = $.fn.zTree.init($("#deptTree"), setting, r.data.deptList);
                var node = ztree.getNodeByParam("deptId", vm.dept.parentId);
                ztree.selectNode(node);

                vm.dept.parentName = node.name;
            })
        },

        //新增
        add: function(){
            vm.showList = false;
            vm.title = "新增";
            vm.dept = {parentName:null,parentId:0,orderNum:0};
            vm.getDept();
        },

        //更新
        update: function () {
            var deptId = getDeptId();
            if(deptId == null){
                return ;
            }

            $.get(baseURL + "sys/dept/detail/"+deptId, function(r){
                vm.showList = false;
                vm.title = "修改";
                vm.dept = r.data.dept;

                vm.getDept();
            });
        },

        //删除
        del: function () {
            var deptId = getDeptId();
            if(deptId == null){
                return ;
            }

            confirm('确定要删除选中的记录？', function(){
                $.ajax({
                    type: "POST",
                    url: baseURL + "sys/dept/delete",
                    data: "deptId=" + deptId,
                    success: function(r){
                        if(r.code === 0){
                            alert('操作成功', function(){
                                vm.reload();
                            });
                        }else{
                            alert(r.msg);
                        }
                    }
                });
            });
        },

        //保存
        saveOrUpdate: function (event) {
            var url = vm.dept.deptId == null ? "sys/dept/save" : "sys/dept/update";
            $.ajax({
                type: "POST",
                url: baseURL + url,
                contentType: "application/json",
                data: JSON.stringify(vm.dept),
                success: function(r){
                    if(r.code === 0){
                        alert('操作成功', function(){
                            vm.reload();
                        });
                    }else{
                        alert(r.msg);
                    }
                }
            });
        },

        //ztree打开事件
        deptTree: function(){
            layer.open({
                type: 1,
                offset: '30px',
                skin: 'layui-layer-molv',
                title: "选择部门",
                area: ['300px', '300px'],
                shade: 0,
                shadeClose: false,
                content: jQuery("#deptLayer"),
                btn: ['确定', '取消'],
                btn1: function (index) {
                    var node = ztree.getSelectedNodes();
                    //选择上级部门
                    vm.dept.parentId = node[0].deptId;
                    vm.dept.parentName = node[0].name;

                    layer.close(index);
                }
            });
        },

        //重新加载
        reload: function () {
            vm.showList = true;
            Dept.table.refresh();
        }
    }
});

