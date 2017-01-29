function valid() {
    //noinspection JSJQueryEfficiency
    if(($("#sugar").val() != "Tak") && ($("#sugar").val() != "Nie")) {
        alert("W polu Cukier Puder musi być Tak lub Nie");
        return false;
    }
    //noinspection JSJQueryEfficiency
    if(($("#fruit").val() != "Tak") && ($("#fruit").val() != "Nie")) {
        alert("W polu Owoce musi być Tak lub Nie");
        return false;
    }
    //noinspection JSJQueryEfficiency
    if(($("#topping").val() != "Tak") && ($("#topping").val() != "Nie")) {
        alert("W polu Polewa musi być Tak lub Nie");
        return false;
    }
    //noinspection JSJQueryEfficiency
    if(($("#cream").val() != "Tak") && ($("#cream").val() != "Nie")) {
        alert("W polu Śmietana musi być Tak lub Nie");
        return false;
    }
    return true;
}