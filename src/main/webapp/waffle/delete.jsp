<%@page contentType="text/html;application/json" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<t:layout>
    <jsp:body>
        <input type="hidden" value="${waffle.id}" id="id"/>

        <h2>Usuń</h2>

        <div>
            <h4>Gofr</h4>
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
            <div class="form-group">
                <div class="col-md-offset-2 col-md-10">
                    <input type="button" value="Usuń" class="btn btn-default" id="deleteWaffle"/>
                </div>
            </div>
        </div>
        <p>
            <a href="/TJE2/api/waffle" value="">Wróć do listy</a> |
        </p>

    </jsp:body>
</t:layout>