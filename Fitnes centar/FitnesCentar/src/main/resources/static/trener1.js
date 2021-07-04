$(document).ready(function () {
let id1=$("#prikaz").hide();
let id2=$("#dodajTermin").hide();
let id3=$("#tIzmeniTermin").hide();
let id4=$("#izmeniTermin").hide();
let id5=$("#sala").hide();
let id6=$("#idTrenera").hide();
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
                 let btn1 = "<button class='izaberi'   data-id=" + ff.id+">Izaberi</button>";
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
$(document).on('click', '.izaberi', function ()
{
let idTrenera=$("#idTrenera").text();
let id1=$("#sala").show();
console.log(idTrenera);

let idF=this.dataset.id;
    $.ajax({
        type: "POST",
        url: "http://localhost:8080/dodajTreneraUFF/"+idF+"/"+idTrenera,
        dataType: "json",
        success: function (response) {
            console.log("SUCCESS:\n", response);
        },
        error: function (response) {
            console.log("ERROR:\n", response);
        }
    });
     $.ajax({
            type: "GET",
            url: "http://localhost:8080/sveSale/"+idF,
            dataType: "json",
            success: function (response) {
                console.log("SUCCESS:\n", response);

                for (let sala of response) {

                    let row = "<tr>";
                    row += "<td>" + sala.kapacitet + "</td>";
                    row += "<td>" + sala.oznaka_sale + "</td>";
                     let btn1 = "<button class='izaberiSalu'   data-id=" + sala.id+">Izaberi</button>";
                                    row += "<td>" + btn1 + "</td>";
                    row += "</tr>";

                    $('#sala').append(row);

                }
            },
            error: function (response) {
                console.log("ERROR:\n", response);
            }
        });
});
$(document).on('click', '.izaberiSalu', function (){

let id1=$("#prikaz").show();
let id2=$("#dodajTermin").hide();
let id3=$("#tIzmeniTermin").hide();
let id4=$("#izmeniTermin").hide();
let idSale=this.dataset.id;
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/sviTreninzi",
        dataType: "json",
        success: function (response) {
            console.log("SUCCESS:\n", response);

            for (let trening of response) {
                              let row = "<tr>";
                              row += "<td>" + trening.naziv + "</td>";
                              row += "<td>" + trening.opis + "</td>";
                             row += "<td>" + trening.tip_treninga + "</td>";
                             row += "<td>" + trening.trajanje + "</td>";
let btn1 = "<button class='dodajTermin'   data-id=" + trening.id+">Dodaj termin</button>";
row += "<td>" + btn1 + "</td>";
let btn2 = "<button class='izmeniTermin'   data-id=" + trening.id+">Izmeni termin</button>";
                                row += "<td>" + btn2 + "</td>";
                              row += "</tr>";
                              $('#prikaz').append(row);
                          }
        },
        error: function (response) {
            console.log("ERROR:\n", response);
        }

    });
    $(document).on('click', '.dodajTermin', function () {

    let idT=this.dataset.id;
    let idTrenera=$("#idTrenera").text();
    let id1=$("#dodajTermin").show();

    $(document).on("submit", "#dodajTermin", function (event) {
        event.preventDefault();


        let raspored_termina = $("#raspored").val();
        let broj_prijavljenih_clanova = 0;
        let cena = $("#cena").val();
        let trening_id=idT;
        let dodajTermin = {
          raspored_termina,
          broj_prijavljenih_clanova,
          cena,
          trening_id
        }


        $.ajax({
            type: "POST",
            url: "http://localhost:8080/dodajTermin/"+idTrenera+"/"+idSale,
            dataType: "json",
            contentType: "application/json",
            data: JSON.stringify(dodajTermin),
            success: function (response) {
                console.log(response);
location.reload(true);

            },
            error: function () {
                alert("Greška!");
            }
        });

    });
    });
});

$(document).on('click', '.izmeniTermin', function ()
{
let id3=$("#tIzmeniTermin").show();
let id1=$("#dodajTermin").hide();

let id=this.dataset.id;
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/sviTerminiT/"+id,
        dataType: "json",
        success: function (response) {
            console.log("SUCCESS:\n", response);

            for (let termin of response) {

                let row = "<tr>";
                row += "<td>" + termin.raspored_termina + "</td>";
                row += "<td>" + termin.cena + "</td>";
                 let btn1 = "<button class='izmeniTermin1'   data-id=" + termin.id+" data-raspored="+termin.raspored_termina+" data-cena="+termin.cena+">Izmeni termin</button>";
                                row += "<td>" + btn1 + "</td>";
                row += "</tr>";

                $('#tIzmeniTermin').append(row);

            }
        },
        error: function (response) {
            console.log("ERROR:\n", response);
        }
    });
});
$(document).on('click', '.izmeniTermin1', function () {
let id4=$("#izmeniTermin").show();
let id=this.dataset.id;
let raspored_termina=this.dataset.raspored;
let cena=this.dataset.cena;
$("#iraspored").val(raspored_termina);
$("#icena").val(cena);

$(document).on("submit", "#izmeniTermin", function (event) {
    event.preventDefault();


    let raspored_termina = $("#iraspored").val();
    let broj_prijavljenih_clanova=0;
    let cena = $("#icena").val();

    let izmeniTermin = {
      raspored_termina,
      broj_prijavljenih_clanova,
      cena
    }


    $.ajax({
        type: "POST",
        url: "http://localhost:8080/izmeniTermin/"+id,
        dataType: "json",
        contentType: "application/json",
        data: JSON.stringify(izmeniTermin),
        success: function (response) {
            console.log(response);
            location.reload(true);
        },
        error: function () {
            alert("Greška!");
        }
    });
});
});

