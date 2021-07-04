$(document).ready(function () {
let idForme=$("#dodajSalu").hide();
let idForme1=$("#izmeniSalu").hide();
let idTabele=$("#salai").hide();
let idTabele1=$("#salao").hide();
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/sviFF",
        dataType: "json",
        success: function (response) {
            console.log("SUCCESS:\n", response);

            for (let ff of response) {
                let row = "<tr>";
                row += "<td>" + ff.naziv + "</td>";
                row += "<td>" + ff.adresa + "</td>";
                 row += "<td>" + ff.broj_telefona_centrale + "</td>";
                  row += "<td>" + ff.email + "</td>";
                 let btn1 = "<button class='dodaj'   data-id=" + ff.id+">Dodaj salu</button>";
                                row += "<td>" + btn1 + "</td>";
                 let btn2 = "<button class='izmeni'   data-id=" + ff.id+">Izmeni salu</button>";
                                                 row += "<td>" + btn2 + "</td>";
                 let btn3 = "<button class='obrisi'   data-id=" + ff.id+">Obrisi salu</button>";
                                                 row += "<td>" + btn3 + "</td>";
                row += "</tr>";

                $('#fitnescentar').append(row);

            }
        },
        error: function (response) {
            console.log("ERROR:\n", response);
        }
    });
});
$(document).on('click', '.dodaj', function () {
let ffId = this.dataset.id;
let idForme=$("#dodajSalu").show();
$(document).on("submit", "#dodajSalu", function (event) {
    event.preventDefault();

let oznaka = $("#oznaka").val();
    let kapacitet = $("#kapacitet").val();
    let ff_id=ffId;




    let novaSala = {
     oznaka,
        kapacitet,
       ff_id


    }


    $.ajax({
        type: "POST",
        url: "http://localhost:8080/dodajSalu",
        dataType: "json",
        contentType: "application/json",
        data: JSON.stringify(novaSala),
        success: function (response) {
            console.log(response);
            window.location.href = "pregled_sala.html";
        },
        error: function () {
            alert("Greška!");
        }
    });
});
});
$(document).on('click', '.izmeni', function ()
{
let idTabele=$("#salai").show();
let id=this.dataset.id;
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/sveSale/"+id,
        dataType: "json",
        success: function (response) {
            console.log("SUCCESS:\n", response);

            for (let sala of response) {

                let row = "<tr>";
                row += "<td>" + sala.kapacitet + "</td>";
                row += "<td>" + sala.oznaka_sale + "</td>";
                 let btn1 = "<button class='izmeni1'   data-id=" + sala.id+" data-kapacitet="+sala.kapacitet+" data-oznaka="+sala.oznaka_sale+">Izmeni salu</button>";
                                row += "<td>" + btn1 + "</td>";

                row += "</tr>";

                $('#salai').append(row);

            }
        },
        error: function (response) {
            console.log("ERROR:\n", response);
        }
    });
});
$(document).on('click', '.izmeni1', function () {
let id=this.dataset.id;
let kapacitet=this.dataset.kapacitet;
let oznaka=this.dataset.oznaka;
let ffId=$("#izmeniSalu").show();
let salaId=$("#salai").hide();

$("#ikapacitet").val(kapacitet);
$("#ioznaka").val(oznaka);

$(document).on("submit", "#izmeniSalu", function (event) {
    event.preventDefault();


    let kapacitet = $("#ikapacitet").val();
    let oznaka_sale = $("#ioznaka").val();

    let izmeniSalu = {
       kapacitet,
       oznaka_sale
    }


    $.ajax({
        type: "POST",
        url: "http://localhost:8080/izmeniSalu/"+id,
        dataType: "json",
        contentType: "application/json",
        data: JSON.stringify(izmeniSalu),
        success: function (response) {
            console.log(response);
            window.location.href = "pregled_sala.html";
        },
        error: function () {
            alert("Greška!");
        }
    });
});
});
$(document).on('click', '.obrisi', function ()
{
let idTabele=$("#salai").show();
let id=this.dataset.id;
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/sveSale/"+id,
        dataType: "json",
        success: function (response) {
            console.log("SUCCESS:\n", response);

            for (let sala of response) {

                let row = "<tr>";
                row += "<td>" + sala.kapacitet + "</td>";
                row += "<td>" + sala.oznaka_sale + "</td>";
                 let btn1 = "<button class='obrisi1'   data-id=" + sala.id+">Obrisi salu</button>";
                                row += "<td>" + btn1 + "</td>";

                row += "</tr>";

                $('#salai').append(row);

            }
        },
        error: function (response) {
            console.log("ERROR:\n", response);
        }
    });
});
$(document).on('click', '.obrisi1', function ()
{
let idTabele=$("#salai").show();
let id=this.dataset.id;
    $.ajax({
        type: "POST",
        url: "http://localhost:8080/obrisiSalu/"+id,
        dataType: "json",
        success: function (response) {
            console.log("SUCCESS:\n", response);


        },
        error: function (response) {
            console.log("ERROR:\n", response);
        }
    });
});


