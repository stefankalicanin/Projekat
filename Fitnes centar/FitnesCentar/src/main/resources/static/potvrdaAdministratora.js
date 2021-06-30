$(document).ready(function () {
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/sviTreneri",
        dataType: "json",
        success: function (response) {
            console.log("SUCCESS:\n", response);

            for (let trener of response) {

                let row = "<tr id=id"+trener.id+">";
                row += "<td>" + trener.ime + "</td>";
                row += "<td>" + trener.prezime + "</td>";
                 let btn = "<button class='potvrda'   data-id=" + trener.id + ">Potvrdi</button>";
                                row += "<td>" + btn + "</td>";
                row += "</tr>";

                $('#treneri').append(row);

            }
        },
        error: function (response) {
            console.log("ERROR:\n", response);
        }
    });
});
$(document).on('click', '.potvrda', function () {


 let trenerId = this.dataset.id;
  $('#id'+trenerId).remove();

    $.ajax({
        type: "POST",
        url: "http://localhost:8080/izmeni/" + trenerId,
        dataType: "json",
        success: function (response) {

        },
        error: function (response) {
            console.log("ERROR:\n", response);

        }
    });
});
$(document).ready(function () {
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/sviTreneri1",
        dataType: "json",
        success: function (response) {
            console.log("SUCCESS:\n", response);

            for (let trener of response) {

                let row = "<tr id=id"+trener.id+">";
                row += "<td> " + trener.ime + "</td>";
                row += "<td>" + trener.prezime + "</td>";
                 let btn = "<button class='ukloni'   data-id=" + trener.id + ">Ukloni</button>";
                                row += "<td>" + btn + "</td>";
                row += "</tr>";

                $('#treneri1').append(row);

            }
        },
        error: function (response) {
            console.log("ERROR:\n", response);
        }
    });
});
$(document).on('click', '.ukloni', function () {


 let trenerId = this.dataset.id;
  $('#id'+trenerId).remove();

    $.ajax({
        type: "POST",
        url: "http://localhost:8080/izmeni1/" + trenerId,
        dataType: "json",
        success: function (response) {

        },
        error: function (response) {
            console.log("ERROR:\n", response);

        }
    });
});
$(document).ready(function () {
let ffId=$("#izmeniFitnesCentar").hide();
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/sviFF",
        dataType: "json",
        success: function (response) {
            console.log("SUCCESS:\n", response);

            for (let ff of response) {

                let row = "<tr id=id"+ff.id+">";
                row += "<td>" + ff.naziv + "</td>";
                row += "<td>" + ff.adresa + "</td>";
                 row += "<td>" + ff.broj_telefona_centrale + "</td>";
                  row += "<td>" + ff.email + "</td>";
                 let btn = "<button class='izmeni'   data-id=" + ff.id + " data-naziv="+ff.naziv+ " data-adresa="+ff.adresa+" data-broj="+ff.broj_telefona_centrale+" data-email="+ff.email+">Izmeni</button>";
                                row += "<td>" + btn + "</td>";
                  let btn1 = "<button class='obrisi'   data-id=" + ff.id + ">Obrisi</button>";
                                                 row += "<td>" + btn1 + "</td>";
                row += "</tr>";

                $('#ff').append(row);

            }
        },
        error: function (response) {
            console.log("ERROR:\n", response);
        }
    });
});
$(document).on('click', '.obrisi', function () {


 let ffId = this.dataset.id;
  $('#id'+ffId).remove();

    $.ajax({
        type: "POST",
        url: "http://localhost:8080/obrisi/" + ffId,
        dataType: "json",
        success: function (response) {

        },
        error: function (response) {
            console.log("ERROR:\n", response);

        }
    });
});
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
            window.location.href = "dodavanje_fitnes_centra.html";
        },
        error: function () {
            alert("Greška!");
        }
    });
});
$(document).on('click', '.izmeni', function () {
let id=this.dataset.id;
let naziv=this.dataset.naziv;
let adresa=this.dataset.adresa;
let broj=this.dataset.broj;
let email=this.dataset.email;
let ffId=$("#izmeniFitnesCentar").show();

$("#inaziv").val(naziv);
$("#iadresa").val(adresa);
$("#ibroj_telefona_centrale").val(broj);
$("#iemail").val(email);

$(document).on("submit", "#izmeniFitnesCentar", function (event) {
    event.preventDefault();


    let naziv = $("#inaziv").val();
    let adresa = $("#iadresa").val();
    let broj_telefona_centrale = $("#ibroj_telefona_centrale").val();
    let email=$("#iemail").val();

    let noviFitnesCentar = {
        naziv,
        adresa,
        broj_telefona_centrale,
             email
    }


    $.ajax({
        type: "POST",
        url: "http://localhost:8080/izmeniff/"+id,
        dataType: "json",
        contentType: "application/json",
        data: JSON.stringify(noviFitnesCentar),
        success: function (response) {
            console.log(response);
            window.location.href = "dodavanje_fitnes_centra.html";
        },
        error: function () {
            alert("Greška!");
        }
    });
});


});

