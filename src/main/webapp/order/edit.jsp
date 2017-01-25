<%@page contentType="text/html;application/json" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<t:layout>
    <jsp:body>

        <h2>Edytuj gofra</h2>

        <form action="edit" method="POST" name="json">
            <input type="hidden" name="_method" value="PUT" />

            <div class="form-horizontal">
                <h4>Zamówienie</h4>
                <hr />

                <div class="form-group">
                    <input value="${order.id}" type="hidden" name="id">

                    <label class = "control-label col-md-2">
                        Cena
                    </label>
                    <div class="col-md-10">
                        <input class="form-control text-box single-line" value="${order.price}" type="text" name="price">
                    </div>
                </div>

                <div class="form-group">
                    <label class = "control-label col-md-2">
                        Data
                    </label>
                    <div class="col-md-10">
                        <input class="form-control text-box single-line" value="${order.date}" type="text" name="date">
                    </div>
                </div>

                <div class="form-group">
                    <label class = "control-label col-md-2">
                        Czy sprzedany
                    </label>
                    <div class="col-md-10">
                        <input class="form-control text-box single-line" value="${order.sold}" type="text" name="sold">
                    </div>
                </div>

                <div class="form-group">
                    <div class="col-md-offset-2 col-md-10">
                        <input type="submit" value="edit" class="btn btn-default" />
                    </div>
                </div>

            </div>
        </form>

        <div>
            <a href="/TJE2/api/order" value="">Wróć do listy</a>
        </div>

    </jsp:body>
</t:layout>