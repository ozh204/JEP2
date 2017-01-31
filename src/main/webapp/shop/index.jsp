<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<t:layout>
  <jsp:body>

    <h2>Sklep</h2>
  <p>
    <a href="/TJE2/api/shop/create" value="">Stwórz sklep</a>
  </p>
  <table class="table">
    <tr>
      <th>Nazwa</th>
      <th>Kraj</th>
      <th>Miasto</th>
      <th>Ulica</th>
      <th>Nr domu/mieszkania</th>
      <th></th>
    </tr>
    <c:forEach items="${shop}" var="item">
      <tr>
        <td>
            ${item.name}
        </td>
        <td>
            ${item.country}
        </td>
        <td>
            ${item.city}
        </td>
        <td>
            ${item.street}
        </td>
        <td>
            ${item.houseNumber}
        </td>
        <td>
          <a href="/TJE2/api/shop/edit/${item.id}" value="">Edytuj</a> |
          <a href="/TJE2/api/shop/details/${item.id}" value="">Szczegóły</a> |
          <a href="/TJE2/api/shop/delete/${item.id}" value="">Usuń</a> |
          <a href="/TJE2/api/shop/${item.id}/orders" value="">Zamówienia</a>
        </td>
      </tr>
    </c:forEach>
  </table>

  </jsp:body>
</t:layout>