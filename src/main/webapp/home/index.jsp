<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<t:layout>
    <jsp:body>

        <div class="jumbotron">
            <h1>JAX-RS</h1>
            <p class="lead">Moja stronka zrobiona w języku JAVA ;)</p>
            <br />
            <p class="lead">Ogólnie jakiś tam opis</p>
            <%--<p><a href="~/Buy" class="btn btn-primary btn-lg">Przejdź do zamówienia ! &raquo;</a></p>--%>
        </div>

        <img src="${pageContext.request.contextPath}/images/gofr.jpg" alt="Gofr pyszny" style="width:100%" />

    </jsp:body>
</t:layout>