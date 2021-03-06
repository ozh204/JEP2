<%@page contentType="text/html;application/json" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<t:layout>
  <jsp:body>

    <h2>Zamówienia</h2>
    <p>
      <a href="/TJE2/api/waffle/create" value="">Stwórz Gofra</a>
    </p>
    <table class="table">
      <tr>
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
            <a href="/TJE2/api/waffle/edit/${item.id}" value="">Edytuj</a> |
            <a href="/TJE2/api/waffle/details/${item.id}" value="">Szczegóły</a> |
            <a href="/TJE2/api/waffle/delete/${item.id}" value="">Usuń</a>
          </td>
        </tr>
      </c:forEach>
    </table>

  </jsp:body>
</t:layout>