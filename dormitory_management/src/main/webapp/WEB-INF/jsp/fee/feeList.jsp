<%--
  Created by IntelliJ IDEA.
  User: A450j
  Date: 2020/5/31
  Time: 18:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/page/include/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="${ctx}/layui/css/layui.css">
    <link rel="stylesheet" href="${ctx }/css/font_eolqem241z66flxr.css"
          media="all" />
    <link rel="stylesheet" href="${ctx }/css/list.css" media="all" />

    <script >
        var ctx="${ctx}";
    </script>
</head>
<body class="childrenBody">
<blockquote class="layui-elem-quote list_search">
<%--    <div class="layui-inline">--%>
<%--        <a class="layui-btn layui-btn-normal cleanAdd_btn">--%>
<%--            <i class="layui-icon">&#xe608;</i>费用记录--%>
<%--        </a>--%>
<%--    </div>--%>
    <!--
        <div class="layui-inline">
            <a  class="layui-btn layui-btn-normal" id="exportexcel" title="导出excel表单">
                <i class="layui-icon layui-icon-add-circle x-icon-add"></i>导出excel表单
            </a>
        </div>
    -->

</blockquote>
<!--数据表格-->
<table id="feeList" class="feeList" lay-filter="feeList"></table>
<script type="text/javascript" src="${ctx }/layui/layui.js"></script>
<script type="text/javascript" src="${ctx }/js/fee/feeList.js"></script>
<script type="text/javascript" src="${ctx }/js/pubilc.js"></script>

<script type="text/html" id="barEdit">
    <a class="layui-btn layui-btn-sm" lay-event="edit">
        <i class="layui-icon">&#xe642;</i>
    </a>
</script>


</body>
</html>
