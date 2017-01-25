<%@page contentType="text/html;application/json" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<t:layout>
  <jsp:body>

    <h2>Stwórz gofra</h2>

    <form action="create" method="POST" name="json">

    <div class="form-horizontal">
      <h4>Gofr</h4>
      <hr />

      <div class="form-group">
        <input value="" type="hidden" name="id">

        <label class = "control-label col-md-2">
          Cena
        </label>
        <div class="col-md-10">
          <input class="form-control text-box single-line" value="" type="text" name="price">
        </div>
      </div>

      <div class="form-group">
        <label class = "control-label col-md-2">
          Polewa
        </label>
        <div class="col-md-10">
          <input class="form-control text-box single-line" value="" type="text" name="topping">
        </div>
      </div>

      <div class="form-group">
        <label class = "control-label col-md-2">
          Cukier puder
        </label>
        <div class="col-md-10">
          <input class="form-control text-box single-line" value="" type="text" name="sugar">
        </div>
      </div>

      <div class="form-group">
        <label class = "control-label col-md-2">
          Śmietana
        </label>
        <div class="col-md-10">
          <input class="form-control text-box single-line" value="" type="text" name="cream">
        </div>
      </div>

      <div class="form-group">
        <label class = "control-label col-md-2">
          Owoce
        </label>
        <div class="col-md-10">
          <input class="form-control text-box single-line" value="" type="text" name="fruit">
        </div>
      </div>

      <div class="form-group">
        <div class="col-md-offset-2 col-md-10">
          <input type="submit" value="Stwórz" class="btn btn-default" />
        </div>
      </div>

    </div>
    </form>

    <div>
      <a href="/TJE2/api/waffle" value="">Wróć do listy</a>
    </div>

  </jsp:body>
</t:layout>