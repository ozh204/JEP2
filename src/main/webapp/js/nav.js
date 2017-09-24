var url = window.location.pathname;
var id = url.substring(url.lastIndexOf('/') + 1);

function addWafflee() {
    var myObject = new Object();

    myObject.id = id;
    myObject.type = "";
    myObject.price = "";
    myObject.topping = "";
    myObject.cream = "";
    myObject.fruit = "";
    myObject.sugar = "";

    var myString = JSON.stringify(myObject);

    $.ajax({
        type: "PUT",
        url: "/TJE2/api/waffle/addToCart",
        data: myString,
        contentType: 'application/json',
        success: function() {
            alert('Dodano do koszyka');
            window.location.href = "/TJE2/waffle";
        }
    });
};

function editWafflee() {

    if(valid()) {

        var myObject = new Object();

        myObject.id = id;
        myObject.type = $("#type").find('input').val();
        myObject.price = $("#price").find('input').val();
        myObject.topping = $("#topping").find('input').val();
        myObject.cream = $("#cream").find('input').val();
        myObject.fruit = $("#fruit").find('input').val();
        myObject.sugar = $("#sugar").find('input').val();

        var myString = JSON.stringify(myObject);

        $.ajax({
            type: "PUT",
            url: "/TJE2/api/waffle/",
            data: myString,
            contentType: 'application/json',
            success: function () {
                alert('Zmodyfikowano');
                window.location.href = "/TJE2/waffle";
            }
        });
    }

};

function deleteWaffle(idWaffle) {

    $.ajax({
        type: "DELETE",
        url: "/TJE2/api/waffle/" + idWaffle,
        contentType: 'application/json',
        success: function () {
            alert('Usunięto');
            window.location.href = "/TJE2/waffle";
        }
    });

};

$(document).ready(function() {

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
                window.location.href = "/TJE2/waffle";
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