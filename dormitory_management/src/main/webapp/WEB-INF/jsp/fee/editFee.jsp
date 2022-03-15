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
<form class="layui-form" style="width: 80%;">
    <!--管理员id 这个必须要有 因为底层sql是根据id来更新的
    但是password和 status其他字段可有可无 但是类型和名称必须一样 不然会绑定错误
    ajax无法进去controller
    -->
    <input type="hidden" name="dormitoryId" value="${fee1.dormitoryId}" id="dormitoryId"/>




    <div class="layui-form-item">
        <label class="layui-form-label ">宿舍号</label>
        <div class="layui-input-block">
            <input type="text" id="dormitoryNumber" class="layui-input"
                   lay-verify="required"  name="dormitoryNumber" disabled="disabled" value="${fee1.dormitory.dormitoryNumber}">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label ">修改水电费</label>
        <div class="layui-input-block">
            <input type="text" id="fee" class="layui-input"
                   lay-verify="required" placeholder="请输入水电费" name="fee" value="${fee1.fee}">
        </div>
    </div>


    <div class="layui-form-item">
        <div class="layui-input-block">
            <button class="layui-btn" lay-submit="" lay-filter="updateFee">立即保存</button>
        </div>
    </div>
</form>
<script type="text/javascript" src="${ctx }/layui/layui.js"></script>
<script type="text/javascript" src="${ctx }/js/fee/editFee.js"></script>
<script type="text/javascript" src="${ctx }/js/pubilc.js"></script>
</body>
</html>















