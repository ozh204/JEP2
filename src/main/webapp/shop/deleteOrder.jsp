<%@page contentType="text/html;application/json" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<t:layout>
    <jsp:body>

        <h2>Usuń Zamówienie ze Sklepu</h2>

        <div>
            <h4>Sklep</h4>
            <input value="${shop.id}" type="hidden" id="shopId">
            <hr />
            <dl class="dl-horizontal">

                <dt>Nazwa</dt>
                <dd>${shop.name}</dd>
                <dt>Kraj</dt>
                <dd>${shop.country}</dd>
                <dt>Miasto</dt>
                <dd>${shop.city}</dd>
                <dt>Ulica</dt>
                <dd>${shop.street}</dd>
                <dt>Nr domu/mieszkania</dt>
                <dd>${shop.houseNumber}</dd>
                <dt>Zamówienia</dt>
                <dd>
                    <select id="id">
                        <c:forEach items="${shop.orders}" var="item">
                            <option value="${item.id}">${item.price}</option>
                        </c:forEach>
                    </select>
                </dd>

            </dl>
        </div>

        <div>
            <h4>Zamówienie</h4>
            <input type="hidden" value="${order.id}" id="id" />

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
                <dt>Gofry</dt>
                <dd>
                    <select id="id">
                        <c:forEach items="${order.waffles}" var="item">
                            <option value="${item.id}">${item.type}</option>
                        </c:forEach>
                    </select>
                </dd>

            </dl>
        </div>
        <input type="button" value="Usuń" class="btn btn-default" id="deleteOrderFromShop"/>

        <p>
            <a href="/TJE2/api/shop" value="">Wróć do listy</a> |
        </p>

    </jsp:body>
</t:layout>