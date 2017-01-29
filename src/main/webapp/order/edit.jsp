<%@page contentType="text/html;application/json" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<t:layout>
    <jsp:body>

        <h2>Edytuj Zamówienie</h2>

        <div class="form-horizontal">
            <hr />

            <div class="form-group">
                <input value="${order.id}" type="hidden" id="id">
                <input value="${order.waffles}" type="hidden" id="waffles">

                <label class = "control-label col-md-2">
                    Cena
                </label>
                <div class="col-md-10">
                    <input class="form-control text-box single-line" value="${order.price}" type="text" readonly id="price">
                </div>
            </div>

            <div class="form-group">
                <label class = "control-label col-md-2">
                    Data
                </label>
                <div class="col-md-10">
                    <input class="form-control text-box single-line" value="${order.date}" type="text" readonly id="date">
                </div>
            </div>

            <div class="form-group">
                <label class = "control-label col-md-2">
                    Czy sprzedany
                </label>
                <div class="col-md-10">
                    <input class="check-box" type="checkbox" <c:if test="${order.sold == true}"> checked="checked" </c:if> id="sold">
                </div>
            </div>

            <div class="form-group">
                <label class = "control-label col-md-2">
                    Gofry
                </label>
                <div class="col-md-10">
                    <a href="/TJE2/api/order/${order.id}/waffle" value="">Dodaj</a>
                    <dl class="dl-horizontal">
                        <c:forEach items="${order.waffles}" var="item">
                            <dt>${item.type}</dt>
                            <dd><a href="/TJE2/api/order/${order.id}/waffle/${item.id}/delete" value="">Usuń</a></dd>
                        </c:forEach>
                    </dl>
                </div>
            </div>

            <div class="form-group">
                <div class="col-md-offset-2 col-md-10">
                    <input type="button" value="Edytuj" class="btn btn-default" id="editOrder"/>
                </div>
            </div>

        </div>

        <div>
            <a href="/TJE2/api/order" value="">Wróć do listy</a>
        </div>

    </jsp:body>
</t:layout>