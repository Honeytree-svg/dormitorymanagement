
layui.use([ 'form','layer','jquery','table'], function() {
    var layer = layui.layer, $ = layui.jquery, form = layui.form, table = layui.table, laydate = layui.laydate;




    form.on("submit(updateFee)",function (data) {
        var index=top.layer.msg("数据提交中，请稍候",{icon:16,time:false,shade:0.2});
        // var index1=parent.layer.getFrameIndex(window.name); //这是获得的 学生列表 这个窗口？
        var msg;
        // var flag=false;
        var dormitoryId=$("#id").val();
        var fee=$("#fee").val();
        $.ajax({
            type:"post",
            async:false,
            url:ctx+"/fee/updateFee",
            data:data.field,
            //data:JSON.stringify({dormitoryId:dormitoryId},{fee:fee}),  //
            // Student.java 中 birthday属性前必须有
            // @DateTimeFormat(pattern = "yyyy-MM-dd") 很重要 必须加上 不然jsp中
            // 数据类型和这里绑定不了 ajax请求进入不了controller
            //createTime前也要有@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
            dataType:"json",
            success:function (d) {
                if(d.code==0)
                {
                    msg="余额更新成功";
                    // flag=true;
                }
                else
                {
                    msg=d.msg;
                }
            } ,
            error:function () {
                layer.msg("错误，请检查sql及输出",{icon:2});
                // layer.closeAll();
            }
        });
        setTimeout(function () {
            top.layer.msg(msg, { shift: -1, time: 2000 },function () {
                parent.location.reload();  //shift: -1表示提示信息不抖动 2秒后调用回调函数
            });
        },2000);  //在点击提交后2秒执行 setTimeout中的function函数
        return false;

    });


});



