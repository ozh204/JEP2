<%@page contentType="text/html;application/json" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<t:layout>
    <jsp:body>

        <h2>Edytuj gofra</h2>

            <div class="form-horizontal">
                <h4>Gofr</h4>
                <hr />

                <div class="form-group">
                    <input value="${waffle.id}" type="hidden" id="id">

                    <label class = "control-label col-md-2">
                        Cena
                    </label>
                    <div class="col-md-10">
                        <input class="form-control text-box single-line" value="${waffle.price}" type="text" id="price">
                    </div>
                </div>

                <div class="form-group">
                    <label class = "control-label col-md-2">
                        Polewa
                    </label>
                    <div class="col-md-10">
                        <input class="form-control text-box single-line" value="${waffle.topping}" type="text" id="topping">
                    </div>
                </div>

                <div class="form-group">
                    <label class = "control-label col-md-2">
                        Cukier puder
                    </label>
                    <div class="col-md-10">
                        <input class="form-control text-box single-line" value="${waffle.sugar}" type="text" id="sugar">
                    </div>
                </div>

                <div class="form-group">
                    <label class = "control-label col-md-2">
                        Śmietana
                    </label>
                    <div class="col-md-10">
                        <input class="form-control text-box single-line" value="${waffle.cream}" type="text" id="cream">
                    </div>
                </div>

                <div class="form-group">
                    <label class = "control-label col-md-2">
                        Owoce
                    </label>
                    <div class="col-md-10">
                        <input class="form-control text-box single-line" value="${waffle.fruit}" type="text" id="fruit">
                    </div>
                </div>

                <div class="form-group">
                    <div class="col-md-offset-2 col-md-10">
                        <input type="button" value="Edytuj" class="btn btn-default" id="send"/>
                    </div>
                </div>

            </div>

        <div>
            <a href="/TJE2/api/waffle" value="">Wróć do listy</a>
        </div>

        <script type="text/javascript">
            $("#send").click(function () {

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
                    url: "/TJE2/api/waffle/edit",
                    data: myString,
                    contentType: 'application/json',
                    success: function() {alert('zmodyfikowano');}
                });
            });
        </script>
    </jsp:body>
</t:layout>