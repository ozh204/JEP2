function valid() {
    //noinspection JSJQueryEfficiency
    if(($("#sugar").find('input').val() != "Tak") && ($("#sugar").find('input').val() != "Nie")) {
        alert("W polu Cukier Puder musi być Tak lub Nie");
        return false;
    }
    //noinspection JSJQueryEfficiency
    if(($("#fruit").find('input').val() != "Tak") && ($("#fruit").find('input').val() != "Nie")) {
        alert("W polu Owoce musi być Tak lub Nie");
        return false;
    }
    //noinspection JSJQueryEfficiency
    if(($("#topping").find('input').val() != "Tak") && ($("#topping").find('input').val() != "Nie")) {
        alert("W polu Polewa musi być Tak lub Nie");
        return false;
    }
    //noinspection JSJQueryEfficiency
    if(($("#cream").find('input').val() != "Tak") && ($("#cream").find('input').val() != "Nie")) {
        alert("W polu Śmietana musi być Tak lub Nie");
        return false;
    }
    return true;
}