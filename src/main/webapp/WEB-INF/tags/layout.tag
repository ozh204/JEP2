<%@tag description="Overall Page template" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/nav.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/validator.js"></script>
    <link href="${pageContext.request.contextPath}/css/bootstrap.css" rel="stylesheet" type="text/css">
    <link href="${pageContext.request.contextPath}/css/Site.css" rel="stylesheet" type="text/css">

    <title>Strona główna</title>
</head>
<body>
<div class="navbar navbar-inverse navbar-fixed-top">
    <div class="container">
        <div class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
                <li><a href="/TJE2/api" value="" class="navbar-brand" >Strona główna</a></li>
                <li><a href="/TJE2/api/waffle" value="">Gofry</a></li>
                <li><a href="/TJE2/api/order" value="">Zamówienia</a></li>
                <li><a href="/TJE2/api/order/cart" value="">Koszyk</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="${pageContext.request.contextPath}/login.jsp">Zaloguj</a></li>
                <li><a href="${pageContext.request.contextPath}/logout.jsp">Wyloguj</a></li>
            </ul>
        </div>
    </div>
</div>
<article class="container body-content">
    <jsp:doBody />
</article>
<footer class="container body-content">
    <p>&copy; Copyright Piotr Laskowski 235266</p>
</footer>
</body>
</html>

