$(document).ready(function() {
    $("#addWaffle").click(function () {

        var myObject = new Object();

        myObject.id = $("#id").val();
        myObject.type = $("#type").val();
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
            success: function() {
                alert('dodano');
                window.location.href = "/TJE2/api/waffle";
            }
        });
    });

    $("#editWaffle").click(function () {
        if(valid()) {
            var myObject = new Object();

            myObject.id = $("#id").val();
            myObject.type = $("#type").val();
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
                success: function () {
                    alert('Zmodyfikowano');
                    window.location.href = "/TJE2/api/waffle";
                }
            });
        }
    });

    $("#deleteWaffle").click(function () {

        $.ajax({
            type: "DELETE",
            url: "/TJE2/api/waffle/delete/"+$("#id").val(),
            contentType: 'application/json',
            success: function () {
                alert('Usunięto');
                window.location.href = "/TJE2/api/waffle";
            }
        });
    });

    $("#createWaffle").click(function () {
        var myObject = new Object();

        myObject.type = $("#type").val();
        myObject.price = $("#price").val();
        myObject.topping = $("#topping").val();
        myObject.cream = $("#cream").val();
        myObject.fruit = $("#fruit").val();
        myObject.sugar = $("#sugar").val();

        var myString = JSON.stringify(myObject);

        $.ajax({
            type: "POST",
            url: "/TJE2/api/waffle/create",
            data: myString,
            contentType: 'application/json',
            success: function () {
                alert('Dodano');
                window.location.href = "/TJE2/api/waffle";
            }
        });
    });

    $("#deleteOrder").click(function () {

        $.ajax({
            type: "DELETE",
            url: "/TJE2/api/order/delete/"+$("#id").val(),
            contentType: 'application/json',
            success: function () {
                alert('Usunięto');
                window.location.href = "/TJE2/api/order";
            }
        });

    });

    $("#editOrder").click(function () {
        var myObject = new Object();

        myObject.id = $("#id").val();
        if ($('#sold').is(":checked")) {
            myObject.sold = true;
        } else {
            myObject.sold = false;
        }

        var myString = JSON.stringify(myObject);

        $.ajax({
            type: "PUT",
            url: "/TJE2/api/order/edit",
            data: myString,
            contentType: 'application/json',
            success: function () {
                alert('Zmodyfikowano');
                window.location.href = "/TJE2/api/order";
            }
        });
    });

    $("#deleteWaffleFromOrder").click(function () {

        $.ajax({
            type: "DELETE",
            url: "/TJE2/api/order/" + $("#orderId").val() + "/waffle/" + $("#id").val() + "/delete",
            contentType: 'application/json',
            success: function () {
                alert('Usunięto');
                window.location.href = "/TJE2/api/order";
            }
        });
    });


    $("#addWaffleToOrder").click(function () {

        $.ajax({
            type: "PUT",
            url: "/TJE2/api/order/" + $("#orderId").val() + "/waffle/" + $("#id").val(),
            contentType: 'application/json',
            success: function () {
                alert('Dodano');
                window.location.href = "/TJE2/api/order";
            }
        });
    });

});