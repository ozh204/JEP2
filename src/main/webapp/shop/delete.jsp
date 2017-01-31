<%@page contentType="text/html;application/json" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<t:layout>
    <jsp:body>
        <input type="hidden" value="${shop.id}" id="id"/>

        <h2>Usuń</h2>

        <div>
            <h4>Sklep</h4>
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

            </dl>
            <div class="form-group">
                <div class="col-md-offset-2 col-md-10">
                    <input type="button" value="Usuń" class="btn btn-default" id="deleteShop"/>
                </div>
            </div>
        </div>
        <p>
            <a href="/TJE2/api/shop" value="">Wróć do listy</a> |
        </p>

    </jsp:body>
</t:layout>