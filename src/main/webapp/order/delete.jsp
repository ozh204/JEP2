<%@page contentType="text/html;application/json" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<t:layout>
    <jsp:body>

        <h2>Usuń</h2>

        <input value="${order.id}" type="hidden" id="id">
        <input value="${order.waffles}" type="hidden" id="waffles">
        <input value="${order.price}" type="hidden" id="id">
        <input value="${order.date}" type="hidden" id="waffles">

        <div>
            <h4>Zamówienie</h4>
            <hr />
            <dl class="dl-horizontal">

                <dt>Cena</dt>
                <dd>${order.price}</dd>
                <dt>Data</dt>
                <dd>${order.date}</dd>
                <dt>Czy sprzedany</dt>
                <dd>
                    <input class="check-box" disabled="disabled" type="checkbox" <c:if test="${order.sold == true}"> checked="checked" </c:if> id="sold">
                </dd>
            </dl>
            <input type="button" value="Usuń" class="btn btn-default" id="deleteOrder"/>

        </div>
        <p>
            <a href="/TJE2/api/order" value="">Wróć do listy</a> |
        </p>

    </jsp:body>
</t:layout>