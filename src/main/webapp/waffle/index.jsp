<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<t:layout>
  <jsp:body>

  <h2>Gofry</h2>
  <p>
    <a href="/TJE2/waffle/create" value="">Stwórz gofra</a>
  </p>
  <table class="table">
    <tr id="waffles">
      <th>Typ</th>
      <th>Cena</th>
      <th>Polewa</th>
      <th>Cukier puder</th>
      <th>Śmietana</th>
      <th>Owoce</th>
      <th></th>
    </tr>

  </table>

  </jsp:body>
</t:layout>

<script>
    findAll();
    function findAll() {
        $.ajax({
            type: 'GET',
            url: "http://localhost:8080/TJE2/api/waffle",
            contentType: 'application/json; charset=utf-8',
            dataType: "json",
            success: function (data) {
                for (var i = 0; i < data.length; i++) {
                    $('#waffles').after(
                            "<tr>"+
                            "<td>"+data[i].type+"</td>"+
                            "<td>"+data[i].price+"</td>"+
                            "<td>"+data[i].topping+"</td>"+
                            "<td>"+data[i].sugar+"</td>"+
                            "<td>"+data[i].cream+"</td>"+
                            "<td>"+data[i].fruit+"</td>"+
                            "<td>"+
                            "<a href='/TJE2/waffle/"+data[i].id+"' value=''> Szczegóły</a> |"+
                            "<a href='#' value='' onclick='deleteWaffle("+data[i].id+")'> Usuń</a> |"+
                            "<a href='/TJE2/api/waffle/ordersOfWaffle/"+data[i].id+"' value=''> Zamówienia</a> "+
                            "</td>"+
                            "</tr>"
                    );
                }
            }
        });
    }
</script>