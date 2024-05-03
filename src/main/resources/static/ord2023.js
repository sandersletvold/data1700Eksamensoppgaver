function registrer() {
    const tekstRegex = /^[A-Za-z]+$/;
    const fodselsdatoRegex = /^[0-9]+\.[0-9]+\.[0-9]{2,4}$/;
    const telefonnrRegex = /^[0-9]{8,12}$/;
    const personnrRegex = /^[0-9]{11}$/;
    const epostRegex = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/;

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
}