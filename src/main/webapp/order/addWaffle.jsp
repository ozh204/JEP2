<%@page contentType="text/html;application/json" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<t:layout>
    <jsp:body>

        <h2>Dodaj gofra do zamówienia</h2>

        <table class="table">
            <tr>
                <th>Typ</th>
                <th>Cena</th>
                <th>Polewa</th>
                <th>Cukier puder</th>
                <th>Śmietana</th>
                <th>Owoce</th>
                <th></th>
            </tr>
            <c:forEach items="${waffle}" var="item">
                <tr>
                    <td>
                            ${item.type}
                    </td>
                    <td>
                            ${item.price}
                    </td>
                    <td>
                            ${item.topping}
                    </td>
                    <td>
                            ${item.sugar}
                    </td>
                    <td>
                            ${item.cream}
                    </td>
                    <td>
                            ${item.fruit}
                    </td>
                    <td>
                        <a href="/TJE2/api/order/${orderId}/waffle/${item.id}" value="">Dodaj</a>
                    </td>
                </tr>
            </c:forEach>
        </table>

    </jsp:body>
</t:layout>