
layui.config({
    base:ctx+"/js/"
}).use(['form','layer','jquery','excel','laypage','table'],function () {
        var form=layui.form,table=layui.table,
        layer=parent.layer===undefined?layui.layer:parent.layer,
        laypage=layui.laypage;
        $=layui.jquery;
        var excel=layui.excel;



    //数据表格
    table.render({
        id:'feeList',
        elem:'#feeList',
        url:ctx+"/fee/getFeeList", //数据接口
        cellMinWidth:80,
        //toolbar:true,
        //title:'打扫记录表',
        //totalRow:true,
        limit:10,//每页条数
        limits:[10,20,30,40],
        cols:[[ //表头
            {field:'dormitoryId',title:'ID',sort:true,align:'center',width:120},

            {field:'fee', title: '费用' ,align: 'center',templet : '<div>{{ d.fee}}</div>' },

            {field:'dormitoryNumber',title:'宿舍名称',align:'center',templet: '<div>{{d.dormitory.dormitoryNumber}}</div>'},
            {title:'操作',toolbar:'#barEdit',align:'center'}
        ]],
        page:true
    });
    //监听工具条
    table.on('tool(feeList)',function (obj) {
        var data=obj.data;
        if(obj.event=='edit')
        {
            layer.open({
                type:2,
                title:"修改水电费",
                area:['380px','600px'],
                content:ctx+"/fee/editFee/"+data.dormitoryId
            })
        }
    });

});

