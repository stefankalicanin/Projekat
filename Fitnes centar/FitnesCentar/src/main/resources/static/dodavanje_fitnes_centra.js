$(document).on("submit", "#dodajFitnesCentar", function (event) {
    event.preventDefault();


    let naziv = $("#naziv").val();
    let adresa = $("#adresa").val();
    let broj_telefona_centrale = $("#broj_telefona_centrale").val();
    let email=$("#email").val();

    let noviFitnesCentar = {
        naziv,
        adresa,
        broj_telefona_centrale,
             email
    }


    $.ajax({
        type: "POST",
        url: "http://localhost:8080/dodajFitnesCentar",
        dataType: "json",
        contentType: "application/json",
        data: JSON.stringify(noviFitnesCentar),
        success: function (response) {
            console.log(response);
            window.location.href = "Admin.html";
        },
        error: function () {
            alert("Greška!");
        }
    });
});