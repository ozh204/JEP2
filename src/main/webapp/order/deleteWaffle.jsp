<%@page contentType="text/html;application/json" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<t:layout>
    <jsp:body>

        <h2>Usuń Gofra z Zamówienia</h2>

        <div>
            <h4>Zamówienie</h4>
            <input value="${order.id}" type="hidden" id="orderId">
            <hr />
            <dl class="dl-horizontal">

                <dt>Cena</dt>
                <dd>${order.price}</dd>
                <dt>Data</dt>
                <dd>${order.date}</dd>
                <dt>Czy sprzedany</dt>
                <dd>${order.sold}</dd>

            </dl>
        </div>

        <div>
            <h4>Gofr</h4>
            <input type="hidden" value="${waffle.id}" id="id" />

            <hr />
            <dl class="dl-horizontal">

                <dt>Typ</dt>
                <dd>${waffle.type}</dd>
                <dt>Cena</dt>
                <dd>${waffle.price}</dd>
                <dt>Polewa</dt>
                <dd>${waffle.topping}</dd>
                <dt>Cukier puder</dt>
                <dd>${waffle.sugar}</dd>
                <dt>Śmietana</dt>
                <dd>${waffle.cream}</dd>
                <dt>Owoce</dt>
                <dd>${waffle.fruit}</dd>

            </dl>
        </div>
        <input type="button" value="Usuń" class="btn btn-default" id="deleteWaffleFromOrder"/>

        <p>
            <a href="/TJE2/api/order" value="">Wróć do listy</a> |
        </p>

    </jsp:body>
</t:layout>