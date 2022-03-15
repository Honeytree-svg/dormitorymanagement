<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/page/include/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="${ctx}/layui/css/layui.css">
    <script>
        var ctx = "${ctx}";
    </script>
</head>
<body>
<form class="layui-form" style="width: 80%;" id="auf">

    <div class="layui-form-item">
        <label class="layui-form-label">晚归时间</label>
        <div class="layui-input-inline">
            <input type="text" id="wanguiTime" name="wanguiTime" class="layui-input"
                   lay-verify="required" placeholder="请输入晚归日期">
        </div>
    </div>


    <div class="layui-form-item">
        <label class="layui-form-label">宿舍名称</label>
        <div class="layui-input-block">
            <select name="dormitoryId" id="dormitoryId"
                    lay-filter="dormitoryFilter">
                <option value="">请选择</option>
                <c:forEach items="${dormitories}" var="d">
                    <option value="${d.dormitoryId}">${d.dormitoryNumber}</option>
                </c:forEach>
            </select>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">姓名</label>
        <div class="layui-input-block">
            <select name="studentId" id="studentId">
                <option value="">请选择</option>
                <c:forEach items="${students}" var="s">
                    <option value="${s.id}">${s.username}</option>
                </c:forEach>
            </select>
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-input-block">
            <button class="layui-btn" lay-submit="" lay-filter="addWangui">立即提交</button>
        </div>
    </div>
</form>

<script type="text/javascript" src="${ctx }/layui/layui.js"></script>
<script type="text/javascript" src="${ctx }/js/wangui/addWangui.js"></script>
<script type="text/javascript" src="${ctx }/js/pubilc.js"></script>

</body>
</html>