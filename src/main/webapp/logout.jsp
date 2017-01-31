<%@page contentType="text/html;application/json" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<t:layout>
    <jsp:body>

        <a href="${pageContext.request.contextPath}/login.jsp"><h2>Zaloguj ponownie</h2></a>

    </jsp:body>
</t:layout>
<%
    session.invalidate();
%>