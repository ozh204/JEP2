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

        <dt>Typ</dt>
          <dd id="type"></dd>
        <dt id="priceToHide">Cena</dt>
          <dd id="price"></dd>
        <dt>Polewa</dt>
          <dd id="topping"></dd>
        <dt>Cukier puder</dt>
          <dd id="sugar"></dd>
        <dt>Śmietana</dt>
          <dd id="cream"></dd>
        <dt>Owoce</dt>
          <dd id="fruit"></dd>

      </dl>
    </div>
    <input type="button" value="Dodaj do koszyka" class="btn btn-default" id="addWaffle" onclick="addWafflee()" />
    <input type="button" value="Edytuj" class="btn btn-default" id="editBtn" onclick="editWaffle()" />

    <p>
      <a href="/TJE2/waffle" value="">Wróć do listy</a> |
    </p>

  </jsp:body>
</t:layout>

<script>

  var url = window.location.pathname;
  var id = url.substring(url.lastIndexOf('/') + 1);

  details();

  function details() {

    $.ajax({
      type: 'GET',
      url: "http://localhost:8080/TJE2/api/waffle/" + id,
      contentType: 'application/json; charset=utf-8',
      dataType: "json",
      success: function (data) {
        $('#type').html(data.type);
        $('#price').show();
        $('#priceToHide').show();
        $('#price').html(data.price);
        $('#topping').html(data.topping);
        $('#sugar').html(data.sugar);
        $('#cream').html(data.cream);
        $('#fruit').html(data.fruit);
        $('#editBtn').prop("value", "Edytuj").attr("onclick", "editWaffle()");
        $('#addWaffle').prop("value", "Dodaj do koszyka").attr("onclick", "addWafflee()");

      }
    });
  }

  function editWaffle() {

    $.ajax({
      type: 'GET',
      url: "http://localhost:8080/TJE2/api/waffle/" + id,
      contentType: 'application/json; charset=utf-8',
      dataType: "json",
      success: function (data) {
        $('#type').html("<input class='form-control text-box single-line' value='"+data.type+"' type='text' >");
        $('#price').hide();
        $('#priceToHide').hide();
        $('#topping').html("<input class='form-control text-box single-line' value='"+data.topping+"' type='text' >");
        $('#sugar').html("<input class='form-control text-box single-line' value='"+data.sugar+"' type='text' >");
        $('#cream').html("<input class='form-control text-box single-line' value='"+data.cream+"' type='text' >");
        $('#fruit').html("<input class='form-control text-box single-line' value='"+data.fruit+"' type='text' >");
        $('#editBtn').prop('value', 'Szczegóły').attr('onclick', 'details()');
        $('#addWaffle').prop("value", "Zapisz").attr("onclick", "editWafflee()");

      }
    });

  }

</script>