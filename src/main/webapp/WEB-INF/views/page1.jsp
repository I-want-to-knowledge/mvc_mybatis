<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: YanZhen
  Date: 2019/2/19 019
  Time: 15:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>首页</title>
</head>
<body>
<h1>hello word!</h1>
<c:forEach items="${userStates}" var="userState" >
    ${userState.id}
    ${userState.userId}
    ${userState.lastTime}
    <hr>
</c:forEach>
</body>
</html>
