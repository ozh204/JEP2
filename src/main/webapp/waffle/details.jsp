<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<t:layout>
  <jsp:body>

    <h2>Szczegóły</h2>
    <input type="hidden" value="${waffle.id}" id="id" />
    <input type="hidden" value="${waffle.price}" id="price" />
    <input type="hidden" value="${waffle.topping}" id="topping" />
    <input type="hidden" value="${waffle.sugar}" id="sugar" />
    <input type="hidden" value="${waffle.fruit}" id="fruit" />
    <input type="hidden" value="${waffle.cream}" id="cream" />

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
    <input type="button" value="Dodaj do koszyka" class="btn btn-default" id="add"/>

    <p>
      <a href="/TJE2/api/waffle/edit/${waffle.id}" value="">Edytuj</a> |
      <a href="/TJE2/api/waffle" value="">Wróć do listy</a> |
    </p>

    <script type="text/javascript">
      $("#add").click(function () {

        var myObject = new Object();

        myObject.id = $("#id").val();
        myObject.price = $("#price").val();
        myObject.topping = $("#topping").val();
        myObject.cream = $("#cream").val();
        myObject.fruit = $("#fruit").val();
        myObject.sugar = $("#sugar").val();

        var myString = JSON.stringify(myObject);

        $.ajax({
          type: "PUT",
          url: "/TJE2/api/waffle/details",
          data: myString,
          contentType: 'application/json',
          success: function() {alert('dodano');}
        });
      });
    </script>

  </jsp:body>
</t:layout>