
layui.use(['form','jquery','table','laydate'],function () {
    var layer=layui.layer;
     var $=layui.jquery;
    var form=layui.form;
    var table=layui.table;
    var laydate=layui.laydate;  //时间选择控件
    var nowTime=new Date().valueOf();//valueOf() 方法返回 Date 对象的原始值 如：1576645321921
    var max=null;
    active ={  //定义一个数组 点击查询的时候会用到
        search:function () {  //实际上就是点击查询调用的函数
           var username=$('#username');
           var sex=$('#sex option:selected');
           //var classId=$('#classId option:selected');
           var dormitoryId=$('#dormitoryId option:selected');

           var birthdayStart=$('#birthdayStart');
           var birthdayEnd=$('#birthdayEnd');

           table.reload('studentList',{
               page:{curr:1},
               where:{
                   username:username.val(),
                   sex:sex.val(),
                   //classId:classId.val(),
                   dormitoryId:dormitoryId.val(),
                //   status:status.val(),
                  // levelId:levelId.val(),
                   //下面四个也是表格加载的时候的查询条件 在最底层的sql语句中做了 判断
               //    createTimeStart:createTimeStart.val(),
                 //  createTimeEnd:createTimeEnd.val(),
                   birthdayStart:birthdayStart.val(),
                   birthdayEnd:birthdayEnd.val()
               }
           });
        }
    };
    $(".search_btn").click(function () {
        var type=$(this).data('type');//jsp 查询 按钮中  data-type="search" 所以这里var type=search
        active[type] ? active[type].call(this) : ''; //查看active中有没有 search数组 有的话就调用其函数
    });

    var birthdayS = laydate.render({
        elem : '#birthdayStart',
        max : nowTime,
        done : function(value, date) {
         //   endMax = createTimeE.config.max;
            birthdayE.config.min = date;
            birthdayE.config.min.month = date.month - 1;
        }
    });

    var birthdayE = laydate.render({
        elem : '#birthdayEnd',
        max : nowTime,
        done : function(value, date) {

            if ($.trim(value) == '') { //如果我们 点击清空以后 创造当前时间 不然birthdayS无法选择
                var curDate = new Date();
                date = {
                    'date' : curDate.getDate(),
                    'month' : curDate.getMonth() + 1,
                    'year' : curDate.getFullYear()
                };
            }

            birthdayS.config.max = date;
            birthdayS.config.max.month = date.month - 1;

        }
    });

    table.render({
        id:'studentList',
        elem:'#studentList',
        url:ctx+ "/student/getAllStudentList",
        limit:10,
        limits:[10,20,30,40],
        cols:[[
            {field:'id',title:'学生序号',align:'center',width:80},
            {field:'username',title:'学生姓名',align:'center',width:110},
            {field:'sex',title:'性别',align:'center',templet:'#sexTpl',width:60},
            {field:'birthday',title:'生日',align:'center',templet:'<div>{{ formatTime(d.birthday,"yyyy-MM-dd")}}</div>',width:110},
            {field:'phone',title:'电话',align:'center',width:120},
            { field: 'dormitoryNumber', title : '所属宿舍', width:120,templet: '<div>{{d.dormitory.dormitoryNumber}}</div>'},

            {field:'email',title:'E-mail',align:'center',width:180},
            {field:'address',title:'地址',align:'center',width:160},
            {field:'level',title:'职位',align:'center',width:110,templet:'#levelTpl'},
            {field:'note',title:'备注',align:'center',width:110},
            {title:'操作',align:'center',width:180,toolbar:"#barDemo"}  //注意！！！！
            // 宽度设置大一点 否则 删除图标显示不出来 然后会出现下拉符号 显示
            // 删除符号 但此时点击就不会有效果了 所以windth设大一点 都显示出来
        ]],
        page:true,
        loading:true

    });

    table.on('tool(studentList)',function (obj) {
        var data=obj.data;
        if(obj.event==='delete')
        {
            layer.confirm('确定要删除'+data.username+'么？',function (index) {
                $.ajax({
                    url:ctx+"/student/deleteStudentById",
                    type:"POST",
                    data:{"id":data.id},
                    success:function (d) {
                        if(d.code==0)
                        {
                            layer.msg("删除成功",{icon:1});
                            obj.del();//下面没有重新加载table
                            // 这里删除了不会自动刷新 但页面中 这一项没有了
                        }
                        else
                        {
                            layer.msg("权限不足，删除失败",{icon:5});
                        }
                    },
                    error:function () {
                        layer.msg("删除失败，检查sql及输出",{icon:5});
                    }
                })
                layer.close(index);
            });
        }
        else if(obj.event=='edit')
        {
            var editIndex=top.layer.open({
                type:2,
                title:"编辑用户",
                area:['450px','600px'],
                content:ctx+"/student/editStudent/"+data.id //controller中只是跳转jsp 所以这里不用success判断
            });
        }
    })

    $(".studentAdd_btn").click(function () {
        var addIndex=top.layer.open({
            title:"添加用户",
            type:2,
            area:['550px','590px'],
            content:ctx+"/student/addStudent"
        });
    });
});

// 格式化时间
function formatTime(datetime, fmt) {
    if (datetime == null || datetime == 0) {
        return "";
    }
    if (parseInt(datetime) == datetime) {
        if (datetime.length == 10) {
            datetime = parseInt(datetime) * 1000;
        } else if (datetime.length == 13) {
            datetime = parseInt(datetime);
        }
    }
    datetime = new Date(datetime);
    var o = {
        "M+" : datetime.getMonth() + 1, // 月份
        "d+" : datetime.getDate(), // 日
        "h+" : datetime.getHours(), // 小时
        "m+" : datetime.getMinutes(), // 分
        "s+" : datetime.getSeconds(), // 秒
        "q+" : Math.floor((datetime.getMonth() + 3) / 3), // 季度
        "S" : datetime.getMilliseconds()
        // 毫秒
    };
    if (/(y+)/.test(fmt))
        fmt = fmt.replace(RegExp.$1, (datetime.getFullYear() + "")
            .substr(4 - RegExp.$1.length));
    for ( var k in o)
        if (new RegExp("(" + k + ")").test(fmt))
            fmt = fmt.replace(RegExp.$1,
                (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k])
                    .substr(("" + o[k]).length)));
    return fmt;
}
