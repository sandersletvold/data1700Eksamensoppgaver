// Oppgave 3
function sendBestilling() {
    const bestilling = {
        navn : $("#navn").val(),
        mobil : $("#mobil").val(),
        epost : $("#epost").val(),
        bord : $("#bord").val(),
        varer : $("#varer").val()
    };

    const navnRegex = /^[A-Za-z]+$/;
    const mobilRegex = /^[0-9]{8}$/;
    const bordRegex = /^[0-9]/;
    const epostRegex = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/;

    let gyldig = true;

    if (!navnRegex.test(bestilling.navn)) {
        $("#feilNavn").html("Ugyldig input ved navn");
        gyldig = false;
    }
    if (!mobilRegex.test(bestilling.mobil)) {
        $("#feilMobil").html("Ugyldig input ved mobilnummer");
        gyldig = false;
    }
    if (!epostRegex.test(bestilling.epost)) {
        $("#feilEpost").html("Ugyldig input ved epostadresse");
        gyldig = false;
    }
    if (!bordRegex.test(bestilling.bord)) {
        $("#feilBord").html("Ugyldig input ved bord");
        gyldig = false;
    }
    if (!navnRegex.test(bestilling.varer)) {
        $("#feilVarer").html("Ugyldig input ved varer");
        gyldig = false;
    }

    if (gyldig) {
        $.post("/bestilling", bestilling, function () {
            $("#bestillinger").html("Bestilling sendt inn!");
            $("#navn").val("");
            $("#mobil").val("");
            $("#epost").val("");
            $("#bord").val("");
            $("#varer").val("");
        });
    }
}

// INNLOGGING
function logginnUtenKryptering(Bruker) {
    const Kunde = {
        NAVN : $("#NAVN").val(),
        PASSORD : $("#PASSORD").val()
    };
    $.get("/login", Kunde, function (OK){
        if (OK) {
            window.location.href = 'ord2022.html';
            $("#NAVN").val("");
            $("#PASSORD").val("");
        } else {
            $("#wrongUser").html("Feil brukernavn eller passord");
            $("#NAVN").val("");
            $("#PASSORD").val("");
        }
    });
}

// UTLOGGING
function logut() {
    $.get("/logut", function (){
        window.location.href = 'ord2022logginn.html';
        alert("Logget ut!");
    });
}