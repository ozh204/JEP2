<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<t:layout>
    <jsp:body>

        <h2>Szczegóły</h2>

        <div>
            <h4>Twoje Zamówienie</h4>
            <hr />
            <dl class="dl-horizontal">

                <dt>Cena</dt>
                <dd>${order.price}</dd>
                <dt>Data</dt>
                <dd>${order.date}</dd>
                <dt>Czy sprzedany</dt>
                <dd>${order.sold}</dd>

            </dl>
            <a href="/TJE2/api/order/confirm" value="">Zatwierdź</a> |
        </div>
        <p>
            <a href="/TJE2/api/order/edit/${item.id}" value="">Edytuj</a> |
            <a href="/TJE2/api/order" value="">Wróć do listy</a> |
        </p>


    </jsp:body>
</t:layout>