$(document).ready(function() {
    $("#createShop").click(function () {

        var myObject = new Object();

        myObject.name = $("#name").val();
        myObject.country = $("#country").val();
        myObject.city = $("#city").val();
        myObject.street = $("#street").val();
        myObject.houseNumber = $("#houseNumber").val();

        var myString = JSON.stringify(myObject);

        $.ajax({
            type: "POST",
            url: "/TJE2/api/shop/create",
            data: myString,
            contentType: 'application/json',
            success: function() {
                alert('dodano');
                window.location.href = "/TJE2/api/shop";
            },
            error: function() {
                alert('nie dodano');
                window.location.href = "/TJE2/api/shop/create";
            }
        });
    });

    $("#deleteShop").click(function () {

        $.ajax({
            type: "DELETE",
            url: "/TJE2/api/shop/delete/"+$("#id").val(),
            contentType: 'application/json',
            success: function () {
                alert('Usunięto');
                window.location.href = "/TJE2/api/shop";
            },
            error: function() {
                alert('nie usunięto');
                window.location.href = "/TJE2/api/shop";
            }
        });
    });

    $("#editShop").click(function () {

        var myObject = new Object();

        myObject.id = $("#id").val();
        myObject.name = $("#name").val();
        myObject.country = $("#country").val();
        myObject.city = $("#city").val();
        myObject.street = $("#street").val();
        myObject.houseNumber = $("#houseNumber").val();

        var myString = JSON.stringify(myObject);

        $.ajax({
            type: "PUT",
            url: "/TJE2/api/shop/edit/",
            data: myString,
            contentType: 'application/json',
            success: function() {
                alert('Zmodyfikowano');
                window.location.href = "/TJE2/api/shop";
            },
            error: function() {
                alert('nie Zmodyfikowano');
                window.location.href = "/TJE2/api/shop/edit/"+$("#id").val();
            }
        });
    });

    $("#deleteOrderFromShop").click(function () {

        $.ajax({
            type: "DELETE",
            url: "/TJE2/api/shop/" + $("#shopId").val() + "/order/" + $("#id").val() + "/delete",
            contentType: 'application/json',
            success: function () {
                alert('Usunięto');
                window.location.href = "/TJE2/api/shop";
            }
        });
    });


    $("#addOrderToShop").click(function () {

        $.ajax({
            type: "PUT",
            url: "/TJE2/api/shop/" + $("#shopId").val() + "/order/" + $("#id").val(),
            contentType: 'application/json',
            success: function () {
                alert('Dodano');
                window.location.href = "/TJE2/api/shop";
            }
        });
    });

    addOrderToShop

});