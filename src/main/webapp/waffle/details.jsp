<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<t:layout>
  <jsp:body>

    <h2>Szczegóły</h2>

    <div>
      <h4>Gofr</h4>
      <hr />
      <dl class="dl-horizontal">

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
    </div>
    <p>
      <a href="/TJE2/api/waffle/edit/${item.id}" value="">Edytuj</a> |
      <a href="/TJE2/api/waffle" value="">Wróć do listy</a> |
    </p>


  </jsp:body>
</t:layout>