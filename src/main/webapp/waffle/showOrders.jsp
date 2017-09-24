<%@page contentType="text/html;application/json" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<t:layout>
  <jsp:body>

    <h2>Gofry</h2>
    <p>
      <a href="/TJE2/api/order/create" value="">Stwórz zamówienie</a>
    </p>
    <table class="table">
      <tr id="ordersOfWaffle">
        <th>Cena</th>
        <th>Data</th>
        <th>Sprzedany</th>
        <th></th>
      </tr>
    </table>

  </jsp:body>
</t:layout>

<script>

  var url = window.location.pathname;
  var id = url.substring(url.lastIndexOf('/') + 1);

  findOrdersOfWaffle();

  function findOrdersOfWaffle() {
    $.ajax({
      type: 'GET',
      url: "http://localhost:8080/TJE2/api/waffle/ordersOfWafflee/" + id,
      contentType: 'application/json; charset=utf-8',
      dataType: "json",
      success: function (data) {
        for (var i = 0; i < data.length; i++) {
          $('#ordersOfWaffle').after(
                  "<tr>"+
                  "<td>"+data[i].price+"</td>"+
                  "<td>"+data[i].date+"</td>"+
                  "<td>"+data[i].sold+"</td>"+
                  "<td>"+
                  "<a href='/TJE2/api/order/edit/"+data[i].id+"' value=''>Edytuj</a> |"+
                  "<a href='/TJE2/api/order/details/"+data[i].id+"' value=''> Szczegóły</a> |"+
                  "<a href='/TJE2/api/order/delete/"+data[i].id+"' value=''> Usuń</a> "+
                  "</td>"+
                  "</tr>"
          );
        }
      }
    });
  }
</script>