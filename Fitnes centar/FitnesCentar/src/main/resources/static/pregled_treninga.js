$(document).on('click', '.prikazTabele', function ()
{
    $('#prikaz').hide();
    $('#sortiranjePoNazivu').hide();
      $('#sortiranjePoOpisu').hide();
        $('#sortiranjePoTipu').hide();
          $('#sortiranjePoTrajanju').hide();

    $('#trening').show();
});
$(document).ready(function (){
  $('#sortiranjePoNazivu').hide();
       $('#sortiranjePoOpisu').hide();
         $('#sortiranjePoTipu').hide();
           $('#sortiranjePoTrajanju').hide();

  $('#prikaz').hide();
  $('#trening').hide();
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

                              row += "</tr>";
                              $('#trening').append(row);
                          }


        },
        error: function (response) {
            console.log("ERROR:\n", response);
        }

    });
});
      $(document).on('click', '.sNaziv', function () {
      let treningDiv = $("#trening");
                               treningDiv.hide();
      $('#sortiranjePoOpisu').hide();
        $('#sortiranjePoTipu').hide();
          $('#sortiranjePoTrajanju').hide();

                               let prikazDiv = $("#sortiranjePoNazivu");
                               prikazDiv.show();
          $.ajax({
                             type: "GET",
                             url: "http://localhost:8080/sortiraniPoNazivu",
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
                                     $('#sortiranjePoNazivu').append(row);
                                 }
                             },
                             error: function (response) {
                                 console.log("ERROR:\n", response);
                             }
                         });
                     });
    $(document).on('click', '.sOpis', function () {
    let treningDiv = $("#trening");
                                   treningDiv.hide();
$('#sortiranjePoNazivu').hide();

         $('#sortiranjePoTipu').hide();
           $('#sortiranjePoTrajanju').hide();

                                   let prikazDiv = $("#sortiranjePoOpisu");
                                   prikazDiv.show();
             $.ajax({
                                type: "GET",
                                url: "http://localhost:8080/sortiraniPoOpisu",
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
                                        $('#sortiranjePoOpisu').append(row);
                                    }
                                },
                                error: function (response) {
                                    console.log("ERROR:\n", response);
                                }
                            });
                        });
     $(document).on('click', '.sTip', function () {
     let treningDiv = $("#trening");
                                    treningDiv.hide();
$('#sortiranjePoNazivu').hide();
       $('#sortiranjePoOpisu').hide();
         $('#sortiranjePoTipu').hide();


                                    let prikazDiv = $("#sortiranjePoTrajanju");
                                    prikazDiv.show();
              $.ajax({
                                 type: "GET",
                                 url: "http://localhost:8080/sortiraniPoTipu",
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
                                         $('#sortiranjePoTipu').append(row);
                                     }
                                 },
                                 error: function (response) {
                                     console.log("ERROR:\n", response);
                                 }
                             });
                         });
      $(document).on('click', '.sTrajanje', function () {
      let treningDiv = $("#trening");
                                     treningDiv.hide();
$('#sortiranjePoNazivu').hide();
       $('#sortiranjePoOpisu').hide();
         $('#sortiranjePoTipu').hide();


                                     let prikazDiv = $("#sortiranjePoTrajanju");
                                     prikazDiv.show();
               $.ajax({
                                  type: "GET",
                                  url: "http://localhost:8080/sortiraniPoTrajanju",
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
                                          $('#sortiranjePoTrajanju').append(row);
                                      }
                                  },
                                  error: function (response) {
                                      console.log("ERROR:\n", response);
                                  }
                              });
                          });

   $(document).on("submit", "#pretrazi", function (event) {
          event.preventDefault();


         let kljucnaRec1=$("#naziv").val();
           let kljucnaRec2=$("#opis").val();
           let kljucnaRec3=$("#tip_treninga").val();
           let kljucnaRec4=$("#trajanje").val();


let data={
       kljucnaRec1: kljucnaRec1,
       kljucnaRec2: kljucnaRec2,
        kljucnaRec3: kljucnaRec3,
        kljucnaRec4:kljucnaRec4
    }

for (obrisi in data){
    if(data[obrisi]=="") delete data[obrisi];
}

          $.ajax({
              type: "GET",
              url: "http://localhost:8080/pretraziPoVise",
              data: data,
              dataType: "json",
              contentType: "application/json",
              success: function (response) {
                  console.log(response);
                 for(let trening of response)
                 {
                 let naziv=trening.naziv;
                 let opis=trening.opis;
                 let tip=trening.tip_treninga;
                 let trajanje=trening.trajanje;
                 alert("Naziv:"+naziv+"\n"+"Opis:"+opis+"\n"+"Tip:"+tip+"\n"+"Trajanje:"+trajanje);
                 }
              },
              error: function () {
                  alert("Greška!");
              }
          });

      });