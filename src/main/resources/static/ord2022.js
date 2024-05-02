function sendBestilling() {
    const bestilling = {
        navn : $("#navn").val(),
        mobil : $("#mobil").val(),
        epost : $("#epost").val(),
        bord : $("#bord").val(),
        varer : $("#varer").val()
    };
    $.post("/ord2022.html/bestilling", bestilling, function () {
        $("#bestillinger").html("Bestilling sendt inn!");
        $("#navn").val("");
        $("#mobil").val("");
        $("#epost").val("");
        $("#bord").val("");
        $("#varer").val("");
    });
}