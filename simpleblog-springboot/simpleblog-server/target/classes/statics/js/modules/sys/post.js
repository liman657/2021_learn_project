$(function () {
    //初始化加载数据
    $("#jqGrid").jqGrid({
        url: baseURL + 'sys/post/list',
        datatype: "json",
        //数据字段一一绑定 <> 根据name
        colModel: [
            { label: 'Id', name: 'postId', index: "post_id", width: 45, key: true },
            { label: '岗位编码', name: 'postCode', index: "post_code", width: 75 },
            { label: '岗位名称', name: 'postName', index: "post_name", width: 75 },
            { label: '排序编号', name: 'orderNum', index: "order_num", width: 75 },
            { label: '备注', name: 'remark', width: 100 },
            { label: '状态', name: 'status', width: 60, formatter: function(value, options, row){
                return value === 0 ?
                    '<span class="label label-danger">禁用</span>' :
                    '<span class="label label-success">正常</span>';
            }},
            { label: '创建时间', name: 'createTime', index: "create_time", width: 85}
        ],
        viewrecords: true,
        height: 485,
        rowNum: 20,
        rowList : [20,40,60,80,100,120,200],
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

var vm = new Vue({
    el:'#pmpapp',
    data:{
        q:{
            postName: null
        },
        showList: true,
        title:null,
        postList:{},
        post:{
            postId:null,
            postCode:null,
            postName:null,
            orderNum:0,
            status:1,
            remark:null
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
                postData:{'search': vm.q.postName},
                page:page
            }).trigger("reloadGrid");
        },

        //重置
        reset: function () {
            window.location.href=baseURL+"modules/sys/post.html";
        },

        //进入新增
        add: function(){
            vm.showList = false;
            vm.title = "新增";
            vm.postList = {};
            vm.post = {postCode:null, postName:null, status:1, remark:null};
        },

        //进入修改
        update: function () {
            var id = getSelectedRow();
            if(id == null){
                return ;
            }

            vm.showList = false;
            vm.title = "修改";

            vm.getInfo(id);
        },

        //获取详情
        getInfo: function(id){
            $.get(baseURL + "sys/post/info/"+id, function(r){
                vm.post = r.data.post;
            });
        },

        //删除
        del: function () {
            var ids = getSelectedRows();
            if(ids == null){
                return ;
            }

            confirm('确定要删除选中的记录？', function(){
                var data=JSON.stringify(ids);
                $.ajax({
                    type: "POST",
                    url: baseURL + "sys/post/delete",
                    contentType: "application/json",
                    data: data,
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
            var url = vm.post.postId == null ? "sys/post/save" : "sys/post/update";
            $.ajax({
                type: "POST",
                url: baseURL + url,
                contentType: "application/json",
                data: JSON.stringify(vm.post),
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
        }

    }
});