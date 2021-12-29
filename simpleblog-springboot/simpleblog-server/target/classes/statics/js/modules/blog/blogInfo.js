$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'sys/blog/list',
        datatype: "json",
        colModel: [
            { label: '编号', name: 'id', index: "id", width: 25,sortable:false, key: true },
            { label: '内容', name: 'content', sortable:false, width: 285},
            { label: '作者用户名', name: 'userName',sortable:false, width: 125},
            { label: '作者昵称', name: 'nickName',sortable:false, width: 100},

            { label: '评论数', name: 'commentTotal',sortable:false, width: 100},
            { label: '点赞数', name: 'praiseTotal',sortable:false, width: 100},
            { label: '收藏数', name: 'collectTotal',sortable:false, width: 100},

            { label: '类型', name: 'type', width: 100,sortable:false, formatter: function(value, options, row){
                return value === 1 ?
                    '<span class="label label-danger">自己发的</span>' :
                    '<span class="label label-success">转发他人的</span>';
            }},
            { label: '状态', name: 'isActive', width: 60,sortable:false, formatter: function(value, options, row){
                return value === 1 ?
                    '<span class="label label-danger">正常发布</span>' :
                    '<span class="label label-success">已被屏蔽</span>';
            }},
            { label: '发布日期', name: 'createTime', sortable:false, width:100 },
            { label: '备注', name: 'memoA', sortable:false, width: 85 }

        ],
		viewrecords: true,
        height: 445,
        rowNum: 20,
		rowList : [20,30,40,50,60,100],
        rownumbers: true,
        rownumWidth: 25,
        autowidth:true,
        multiselect: true,
        pager: "#jqGridPager",
        jsonReader : {
            root: "data.page.list",
            page: "data.page.currPage",
            total: "data.page.totalPage",
            records: "data.page.totalCount"
        },
        prmNames : {
            page:"page", 
            rows:"limit", 
            order: "order"
        },
        gridComplete:function(){
        	//隐藏grid底部滚动条
        	$("#jqGrid").closest(".ui-jqgrid-bdiv").css({ "overflow-x" : "hidden" }); 
        }

        //双击事件
        /*ondblClickRow:function(row){
            var rowData = $('#jqGrid').jqGrid('getRowData',row);
            var blogId=rowData.id;
            url=baseURL+'web/index/blog/article/'+blogId;
            window.open(url, "_blank");
        }*/

    });
    
});

var E;
var editor;

var vm = new Vue({
	el:'#pmpapp',
	data:{
        q:{
            userName: null,
            status:null,
            startDate:null,
            endDate:null
        },
        showList: true

	},
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
                postData:{'userName': vm.q.userName,'status': vm.q.status,'startDate': vm.q.startDate,'endDate': vm.q.endDate},
                page:page
            }).trigger("reloadGrid");
        },

        //重置
        reset: function () {
            window.location.href=baseURL+"modules/blog/blogInfo.html";
        },

        //删除
        del: function () {
            var ids = getSelectedRows();
            if(ids == null){
                return ;
            }

            confirm('确定要删除选中的微博？', function(){
                var data=JSON.stringify(ids);
                $.ajax({
                    type: "POST",
                    url: baseURL + "sys/blog/delete",
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

        //屏蔽-恢复
        active:function () {
            var ids = getSelectedRows();
            if(ids == null){
                return ;
            }

            confirm('确定要屏蔽/恢复选中的微博(其状态将变为相反)？', function(){
                var data=JSON.stringify(ids);
                $.ajax({
                    type: "POST",
                    url: baseURL + "sys/blog/active/unActive",
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
        }

    }
});


$(function () {
    //初始化InputMask控件
    //Date picker
    $('#daterange-btn').daterangepicker({
            ranges: {
                '今日': [moment().startOf('day'), moment()],
                '昨日': [moment().subtract('days', 1).startOf('day'), moment().subtract('days', 1).endOf('day')],
                '最近7日': [moment().subtract('days', 6), moment()],
                '最近30日': [moment().subtract('days', 29), moment()]
            },
            opens: 'left', //日期选择框的弹出位置
            buttonClasses: ['btn btn-default'],
            applyClass: 'btn-small btn-primary blue',
            cancelClass: 'btn-small',
            format: 'YYYY-MM-DD HH:mm:ss', //控件中from和to 显示的日期格式
            separator: ' to ',
            locale: {
                applyLabel: '确定',
                cancelLabel: '取消',
                fromLabel: '打卡起始时间',
                toLabel: '打卡结束时间',
                customRangeLabel: '手动选择',
                daysOfWeek: ['日', '一', '二', '三', '四', '五', '六'],
                monthNames: ['一月', '二月', '三月', '四月', '五月', '六月','七月', '八月', '九月', '十月', '十一月', '十二月'],
                firstDay: 1
            },

            startDate: moment(),
            endDate: moment().endOf('month')
        },
        function(start, end) {
            $('#daterange-btn span').html(start.format('YYYY-MM-DD') + ' 到 ' + end.format('YYYY-MM-DD'));

            vm.q.startDate=start.format('YYYY-MM-DD');
            vm.q.endDate=end.format('YYYY-MM-DD');
        }
    );

    vm.q.status=null;
});

//下拉框
$('#status').change(function () {
    var value=$(this).children("option:selected").val();
    vm.q.status=value;
});











