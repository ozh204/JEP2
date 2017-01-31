<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<t:layout>
  <jsp:body>

    <h2>Szczegóły</h2>

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
        <dt>Zamówienia</dt>
          <dd>
            <select id="id">
              <c:forEach items="${shop.orders}" var="item">
                <option value="${item.id}">${item.price}</option>
              </c:forEach>
            </select>
          </dd>

      </dl>
    </div>

    <p>
      <a href="/TJE2/api/shop/edit/${shop.id}" value="">Edytuj</a> |
      <a href="/TJE2/api/shop" value="">Wróć do listy</a> |
    </p>

  </jsp:body>
</t:layout>