function sendBestilling() {
    const bestilling = {
        navn : $("#navn").val(),
        mobil : $("#mobil").val(),
        epost : $("#epost").val(),
        bord : $("#bord").val(),
        varer : $("#varer").val()
    };
    $.post("/ord2022.html/bestilling", bestilling);
}