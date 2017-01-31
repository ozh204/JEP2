<%@page contentType="text/html;application/json" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<t:layout>
  <jsp:body>

    <h2>Stwórz sklep</h2>

    <div class="form-horizontal">
      <h4>Sklep</h4>
      <hr />

      <div class="form-group">
        <label class = "control-label col-md-2">
          Nazwa
        </label>
        <div class="col-md-10">
          <input class="form-control text-box single-line" value="" type="text" id="name">
        </div>
      </div>

      <div class="form-group">
        <label class = "control-label col-md-2">
          Kraj
        </label>
        <div class="col-md-10">
          <input class="form-control text-box single-line" value="" type="text" id="country">
        </div>
      </div>

      <div class="form-group">
        <label class = "control-label col-md-2">
          Miasto
        </label>
        <div class="col-md-10">
          <input class="form-control text-box single-line" value="" type="text" id="city">
        </div>
      </div>

      <div class="form-group">
        <label class = "control-label col-md-2">
          Ulica
        </label>
        <div class="col-md-10">
          <input class="form-control text-box single-line" value="" type="text" id="street">
        </div>
      </div>

      <div class="form-group">
        <label class = "control-label col-md-2">
          Numer domu/mieszkania
        </label>
        <div class="col-md-10">
          <input class="form-control text-box single-line" value="" type="text" id="houseNumber">
        </div>
      </div>

      <div class="form-group">
        <div class="col-md-offset-2 col-md-10">
          <input type="submit" value="Stwórz" class="btn btn-default" id="createShop"/>
        </div>
      </div>

    </div>

    <div>
      <a href="/TJE2/api/shop" value="">Wróć do listy</a>
    </div>

  </jsp:body>
</t:layout>