<%@page contentType="text/html;application/json" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<t:layout>
  <jsp:body>

    <form action="create" method="POST">
      <div class="form-horizontal">
        <h4>Zamówienie</h4>
        <hr />

        <div class="form-group">
          <div class="col-md-offset-2 col-md-10">
            <input type="submit" value="Zaczynam zamawiać" class="btn btn-default" />
          </div>
        </div>
      </div>
    </form>

  </jsp:body>
</t:layout>