<%@page contentType="text/html;application/json" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<t:layout>
    <jsp:body>

        <h2>Dodaj zamówienie do sklepu</h2>

        <table class="table">
            <tr>
                <th>Cena</th>
                <th>Data</th>
                <th>Czy sprzedany</th>
                <th></th>
            </tr>
            <c:forEach items="${order}" var="item">
                <tr>
                    <td>
                            ${item.price}
                    </td>
                    <td>
                            ${item.date}
                    </td>
                    <td>
                        <input class="check-box" disabled="disabled" type="checkbox" <c:if test="${item.sold == true}"> checked="checked" </c:if> id="sold">
                    </td>
                    <td>
                        <a href="/TJE2/api/shop/${shopId}/order/${item.id}" value="">Dodaj</a>
                    </td>
                </tr>
            </c:forEach>
        </table>

    </jsp:body>
</t:layout>