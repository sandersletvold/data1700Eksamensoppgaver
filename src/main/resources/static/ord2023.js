function registrer() {
    // Validering med RegExp for alle input feltene
    const tekstRegex = /^[A-Za-z]+$/;
    const fodselsdatoRegex = /^[0-9]+\.[0-9]+\.[0-9]{2,4}$/;
    const telefonnrRegex = /^[0-9]{8,12}$/;
    const personnrRegex = /^[0-9]{11}$/;
    const epostRegex = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/;

    // Henter verdiene fra HTML og oppretter et objekt
    const person = {
        fornavn : $("#fornavn").val(),
        etternavn : $("#etternavn").val(),
        fodselsdato : $("#fodselsdato").val(),
        personnr : $("#personnr").val(),
        telefonnr : $("#telefonnr").val(),
        email : $("#email").val(),
        by : $("#by").val(),
        gatenavn : $("#gatenavn").val()
    }

    // Boolean for om alle feltene er gyldige
    let gyldigInputs = true;

    // Sjekker hvert av feltene for feil
    if (!tekstRegex.test(person.fornavn)) {
        $("#feilFornavn").html("Ugyldig input ved fornavn");
        gyldigInputs = false;
    }
    if (!tekstRegex.test(person.etternavn)) {
        $("#feilEtternavn").html("Ugyldig input ved etternavn");
        gyldigInputs = false;
    }
    if (!fodselsdatoRegex.test(person.fodselsdato)) {
        $("#feilFodselsdato").html("Ugyldig input ved fødselsdato");
        gyldigInputs = false;
    }
    if (!personnrRegex.test(person.personnr)) {
        $("#feilPersonnr").html("Ugyldig input ved personnummer");
        gyldigInputs = false;
    }
    if (!telefonnrRegex.test(person.telefonnr)) {
        $("#feilTelefonnr").html("Ugyldig input ved telefonnummer");
        gyldigInputs = false;
    }
    if (!epostRegex.test(person.email)) {
        $("#feilEpost").html("Ugyldig input ved epost");
        gyldigInputs = false;
    }
    if (!tekstRegex.test(person.by)) {
        $("#feilBy").html("Ugyldig input ved by");
        gyldigInputs = false;
    }
    if (!tekstRegex.test(person.gatenavn)) {
        $("#feilGatenavn").html("Ugyldig input ved gatenavn");
        gyldigInputs = false;
    }

    if (gyldigInputs) {
        $.post("/saveCitizen", person, function (){
            console.log("Sendt til server!");

            $("#fornavn").val("");
            $("#etternavn").val("");
            $("#fodselsdato").val("");
            $("#personnr").val("");
            $("#telefonnr").val("");
            $("#email").val("");
            $("#by").val("");
            $("#gatenavn").val("");

            $("#feilFornavn").html("");
            $("#feilEtternavn").html("");
            $("#feilFodselsdato").html("");
            $("#feilPersonnr").html("");
            $("#feilTelefonnr").html("");
            $("#feilEmail").html("");
            $("#feilBy").html("");
            $("#feilGatenavn").html("");
        });
    }
}