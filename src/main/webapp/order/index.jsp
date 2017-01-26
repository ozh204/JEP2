<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<t:layout>
  <jsp:body>

    <h2>Zamówienia</h2>
    <p>
      <a href="/TJE2/api/order/create" value="">Stwórz zamówienie</a>
    </p>
    <table class="table">
      <tr>
        <th>Cena</th>
        <th>Data</th>
        <th>Sprzedany</th>
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
              ${item.sold}
          </td>
          <td>
            <a href="/TJE2/api/order/edit/${item.id}" value="">Edytuj</a> |
            <a href="/TJE2/api/order/details/${item.id}" value="">Szczegóły</a> |
            <a href="/TJE2/api/order/delete/${item.id}" value="">Usuń</a>
          </td>
        </tr>
      </c:forEach>
    </table>

  </jsp:body>
</t:layout>