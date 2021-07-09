$(document).ready(function () {
let id1=$("#idClana").hide();

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
   let btn1 = "<button class='izaberi'   data-id=" + trening.id+">Izaberi</button>";
   row += "<td>" + btn1 + "</td>";

                                 row += "</tr>";
                                 $('#prikazTreninga').append(row);
                             }
           },
           error: function (response) {
               console.log("ERROR:\n", response);
           }

       });
});
$(document).on('click', '.izaberi', function ()
{

let id3=$("#idClana").text();

let idTreninga=this.dataset.id;
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/sviTerminiT/"+idTreninga,
        dataType: "json",
        success: function (response) {
            console.log("SUCCESS:\n", response);

            for (let termin of response) {

                let row = "<tr>";
                row += "<td>" + termin.raspored_termina + "</td>";
                row += "<td>" + termin.cena + "</td>";
                 let btn1 = "<button class='prijava'   data-id=" + termin.id+">Prijavi se</button>";
                                row += "<td>" + btn1 + "</td>";
                row += "</tr>";

                $('#prikazTermina').append(row);

            }
        },
        error: function (response) {
            console.log("ERROR:\n", response);
        }
    });
    $(document).on('click', '.prijava', function ()
    {

    let idTermina=this.dataset.id;
    let idClana=$("#idClana").text();
        $.ajax({
            type: "POST",
            url: "http://localhost:8080/prijavaNaTermin/"+idTermina+"/"+idTreninga+"/"+idClana,
            dataType: "json",
            success: function (response) {
               let uspesno=response;
               if(uspesno)
               {
               alert("Uspesno ste se prijavili");
               location.reload(true);
                }
                else
                {
                alert("Broj mesta je popunjen");
                location.reload(true);
                }
            },
            error: function (response) {
                console.log("ERROR:\n", response);
            }
        });
    });
});

$(document).ready(function () {
let idClana=$("#idClana").text();
   $.ajax({
           type: "GET",
           url: "http://localhost:8080/sviPrijavljeniTreninzi/"+idClana,
           dataType: "json",
           success: function (response) {
               console.log("SUCCESS:\n", response);

               for (let trening of response) {
                                 let row = "<tr>";
                                 row += "<td>" + trening.naziv + "</td>";
                                 row += "<td>" + trening.opis + "</td>";
                                row += "<td>" + trening.tip_treninga + "</td>";
                                row += "<td>" + trening.trajanje + "</td>";
   let btn1 = "<button class='otkazi'   data-id=" + trening.id+">Otkazi prijavu</button>";
   row += "<td>" + btn1 + "</td>";
   let btn2 = "<button class='odradi'   data-id=" + trening.id+">Odradi trening</button>";
      row += "<td>" + btn2 + "</td>";
                                 row += "</tr>";
                                 $('#prikazPrijavljenihTreninga').append(row);
                             }
           },
           error: function (response) {
               console.log("ERROR:\n", response);
           }

       });
});

$(document).on('click', '.otkazi', function ()
{
let idTreninga=this.dataset.id;
let idClana=$("#idClana").text();
    $.ajax({
        type: "POST",
        url: "http://localhost:8080/otkaziTrening/"+idTreninga+"/"+idClana,
        dataType: "json",
        success: function (response) {
            console.log("SUCCESS:\n", response);
             location.reload(true);

        },
        error: function (response) {
            console.log("ERROR:\n", response);
        }
    });
});
$(document).on('click', '.odradi', function ()
{

let idTreninga=this.dataset.id;
let idClana=$("#idClana").text();
    $.ajax({
        type: "POST",
        url: "http://localhost:8080/odradiTrening/"+idTreninga+"/"+idClana,
        dataType: "json",
        success: function (response) {
            console.log("SUCCESS:\n", response);
             location.reload(true);

        },
        error: function (response) {
            console.log("ERROR:\n", response);
        }
    });
});
$(document).ready(function () {
let idClana=$("#idClana").text();
   $.ajax({
           type: "GET",
           url: "http://localhost:8080/sviOdradjeniTreninzi/"+idClana,
           dataType: "json",
           success: function (response) {
               console.log("SUCCESS:\n", response);

               for (let trening of response) {
                                 let row = "<tr>";
                                 row += "<td>" + trening.naziv + "</td>";
                                 row += "<td>" + trening.opis + "</td>";
                                row += "<td>" + trening.tip_treninga + "</td>";
                                row += "<td>" + trening.trajanje + "</td>";
   let btn1 = "<button class='oceni'   data-id=" + trening.id+">Oceni</button>";
   row += "<td>" + btn1 + "</td>";
                                 row += "</tr>";
                                 $('#prikazOdradjenihTreninga').append(row);
                             }
           },
           error: function (response) {
               console.log("ERROR:\n", response);
           }

       });
});
$(document).on('click', '.oceni', function ()
{
let ocena = prompt("Unesite ocenu(1 do 5):");
let idTreninga=this.dataset.id;
let idClana=$("#idClana").text();
    $.ajax({
        type: "POST",
        url: "http://localhost:8080/oceniTrening/"+idTreninga+"/"+idClana+"/"+ocena,
        dataType: "json",
        success: function (response) {
            console.log("SUCCESS:\n", response);
             location.reload(true);

        },
        error: function (response) {
            console.log("ERROR:\n", response);
        }
    });
});
$(document).ready(function () {
let idClana=$("#idClana").text();
   $.ajax({
           type: "GET",
           url: "http://localhost:8080/sviOcenjeniTreninzi/"+idClana,
           dataType: "json",
           success: function (response) {
               console.log("SUCCESS:\n", response);

               for (let trening of response) {
                                               let row = "<tr>";
                                               row += "<td>" + trening.naziv + "</td>";
                                               row += "<td>" + trening.opis + "</td>";
                                              row += "<td>" + trening.tip_treninga + "</td>";
                                              row += "<td>" + trening.trajanje + "</td>";

                                               row += "</tr>";
                                               $('#prikazOcenjenihTreninga').append(row);
                                           }
           },
           error: function (response) {
               console.log("ERROR:\n", response);
           }

       });
});