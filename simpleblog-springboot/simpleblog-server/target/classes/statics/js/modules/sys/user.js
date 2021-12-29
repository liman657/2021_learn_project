$(function () {
    //初始化加载数据
    $("#jqGrid").jqGrid({
        url: baseURL + 'sys/user/list',
        datatype: "json",
        //数据字段一一绑定 <> 根据name
        colModel: [
            { label: '编号', name: 'userId', index: "user_id", width: 45, key: true },
            { label: '用户名', name: 'username', width: 75 },
            { label: '昵称', name: 'name', width: 75 },
            { label: '邮箱', name: 'email', width: 90 },
            { label: '身份类型', name: 'type', width: 90, formatter: function(value, options, row){
                return value === 0 ?
                    '<span class="label label-danger">普通大众</span>' :
                    '<span class="label label-success">后端管理人员</span>';
            }},
            { label: '状态', name: 'status', width: 60, formatter: function(value, options, row){
                return value === 0 ?
                    '<span class="label label-danger">禁用</span>' :
                    '<span class="label label-success">正常</span>';
            }},
            { label: '创建时间', name: 'createTime', index: "create_time", width: 85}
        ],
        viewrecords: true,
        height: 385,
        rowNum: 10,
        rowList : [10,20,30,40,50,60,100],
        rownumbers: true,
        rownumWidth: 25,
        autowidth:true,
        multiselect: true,
        pager: "#jqGridPager",
        //读取服务器返回的json数据并解析
        jsonReader : {
            root: "data.page.list",
            page: "data.page.currPage",
            total: "data.page.totalPage",
            records: "data.page.totalCount"
        },
        //设置jqGrid将要向服务端传递的参数名称
        prmNames : {
            page:"page",
            rows:"limit",
            order: "order"
        },
        gridComplete:function(){
            //隐藏grid底部滚动条
            $("#jqGrid").closest(".ui-jqgrid-bdiv").css({ "overflow-x" : "hidden" });
        }
    });
});

//设置自定义数据
var setting = {
    data: {
        simpleData: {
            enable: true,
            idKey: "deptId",
            pIdKey: "parentId",
            rootPId: -1
        },
        key: {
            url:"nourl"
        }
    }
};

//ztree-层级树
var ztree;

var vm = new Vue({
    el:'#pmpapp',
    data:{
        q:{
            username: null
        },
        showList: true,
        title:null,
        roleList:{},

        user:{
            status:1,
            roleIdList:[]
        }
    },

    //请求方法
    methods: {
        //查询
        query: function () {
            vm.reload();
        },

        //重新load数据时的请求方法
        reload: function () {
            vm.showList = true;
            var page = $("#jqGrid").jqGrid('getGridParam','page');
            $("#jqGrid").jqGrid('setGridParam',{
                postData:{'username': vm.q.username},
                page:page
            }).trigger("reloadGrid");
        },

        //重置
        reset: function () {
            window.location.href=baseURL+"modules/sys/user.html"
        },

        //进入新增
        add: function(){
            vm.showList = false;
            vm.title = "新增";
            vm.roleList = {};
            vm.user = {status:1, roleIdList:[]};

            this.getRoleList();
        },

        //获取角色列表
        getRoleList: function(){
            $.get(baseURL + "sys/role/select", function(r){
                vm.roleList = r.data.list;
            });
        },

        //进入修改
        update: function () {
            var userId = getSelectedRow();
            if(userId == null){
                return ;
            }

            vm.showList = false;
            vm.title = "修改";

            //详情
            vm.getInfo(userId);

            this.getRoleList();
        },

        //根据userId获取用户信息
        getInfo: function(userId){
            $.get(baseURL + "sys/user/info/"+userId, function(r){
                vm.user = r.data.user;
                vm.user.password = null;
            });
        },

        //删除
        del: function () {
            var userIds = getSelectedRows();
            if(userIds == null){
                return ;
            }

            confirm('确定要删除选中的记录？', function(){
                $.ajax({
                    type: "POST",
                    url: baseURL + "sys/user/delete",
                    contentType: "application/json",
                    data: JSON.stringify(userIds),
                    success: function(r){
                        if(r.code == 0){
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

        //保存-更新数据
        saveOrUpdate: function () {
            var url = vm.user.userId == null ? "sys/user/save" : "sys/user/update";
            $.ajax({
                type: "POST",
                url: baseURL + url,
                contentType: "application/json",
                data: JSON.stringify(vm.user),
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

        //重置密码：
        resetPsd:function () {
            var userIds = getSelectedRows();
            if(userIds == null){
                return ;
            }

            confirm('确定要重置选中的用户的密码？', function(){
                $.ajax({
                    type: "POST",
                    url: baseURL + "sys/user/psd/reset",
                    contentType: "application/json",
                    data: JSON.stringify(userIds),
                    success: function(r){
                        if(r.code == 0){
                            alert('操作成功', function(){
                                vm.reload();
                            });
                        }else{
                            alert(r.msg);
                        }
                    }
                });
            });
        }


    }
});



