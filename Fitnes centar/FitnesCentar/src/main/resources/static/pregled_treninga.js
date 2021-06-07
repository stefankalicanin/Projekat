$(document).on('click', '.prikazTabele', function ()
{
    $('#prikaz').hide();
    $('#sortiranjePoNazivu').hide();
      $('#sortiranjePoOpisu').hide();
        $('#sortiranjePoTipu').hide();
          $('#sortiranjePoTrajanju').hide();
            $('#sortiranjePoCeni').hide();
    $('#trening').show();
});
$(document).ready(function (){
  $('#sortiranjePoNazivu').hide();
       $('#sortiranjePoOpisu').hide();
         $('#sortiranjePoTipu').hide();
           $('#sortiranjePoTrajanju').hide();
           $('#sortiranjePoCeni').hide();
  $('#prikaz').hide();
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
                             row += "<td>" + trening.cena + "</td>";
                              row += "</tr>";
                              $('#trening').append(row);
                          }


        },
        error: function (response) {
            console.log("ERROR:\n", response);
        }

    });
});

$(document).on("submit","#pretraziPoNazivu", function (event) {
  event.preventDefault();
     let kljucnaRec = $("#naziv").val();
     let treningDiv = $("#trening");
         treningDiv.hide();
         let prikazDiv = $("#prikaz");
         prikazDiv.show();

   $.ajax({
           type: "GET",
           url: "http://localhost:8080/pretraziPoNazivu/" +kljucnaRec,
           dataType: "json",
           success: function (response) {
               console.log("SUCCESS:\n", response);
               for (let trening of response) {
                    let row = "<tr>";
                   row += "<td>" + trening.naziv + "</td>";
                   row += "<td>" + trening.opis + "</td>";
                  row += "<td>" + trening.tip_treninga + "</td>";
                  row += "<td>" + trening.trajanje + "</td>";
                  row += "<td>" + trening.cena + "</td>";
                   row += "</tr>";
                   $('#prikaz').append(row);
               }
           },
           error: function (response) {
               console.log("ERROR:\n", response);
           }
       });
   });
 $(document).on("submit","#pretraziPoOpisu", function (event) {
     event.preventDefault();
        let kljucnaRec = $("#opis").val();
         let treningDiv = $("#trening");
                 treningDiv.hide();
                 let prikazDiv = $("#prikaz");
                 prikazDiv.show();

      $.ajax({
              type: "GET",
              url: "http://localhost:8080/pretraziPoOpisu/" +kljucnaRec,
              dataType: "json",
              success: function (response) {
                  console.log("SUCCESS:\n", response);
                  for (let trening of response) {

                       let row = "<tr>";
                      row += "<td>" + trening.naziv + "</td>";
                      row += "<td>" + trening.opis + "</td>";
                     row += "<td>" + trening.tip_treninga + "</td>";
                     row += "<td>" + trening.trajanje + "</td>";
                     row += "<td>" + trening.cena + "</td>";
                      row += "</tr>";
                      $('#prikaz').append(row);
                  }


              },
              error: function (response) {
                  console.log("ERROR:\n", response);
              }
          });
      });
 $(document).on("submit","#pretraziPoTipuTreninga", function (event) {
      event.preventDefault();
         let kljucnaRec = $("#tip_treninga").val();
          let treningDiv = $("#trening");
                  treningDiv.hide();
                  let prikazDiv = $("#prikaz");
                  prikazDiv.show();

       $.ajax({
               type: "GET",
               url: "http://localhost:8080/pretraziPoTipuTreninga/" +kljucnaRec,
               dataType: "json",
               success: function (response) {
                   console.log("SUCCESS:\n", response);
                   for (let trening of response) {
                       let row = "<tr>";
                       row += "<td>" + trening.naziv + "</td>";
                       row += "<td>" + trening.opis + "</td>";
                      row += "<td>" + trening.tip_treninga + "</td>";
                      row += "<td>" + trening.trajanje + "</td>";
                      row += "<td>" + trening.cena + "</td>";
                       row += "</tr>";
                       $('#prikaz').append(row);
                   }

               },
               error: function (response) {
                   console.log("ERROR:\n", response);
               }
           });
       });
 $(document).on("submit","#pretraziPoTrajanju", function (event) {
      event.preventDefault();
         let kljucnaRec = $("#trajanje").val();
          let treningDiv = $("#trening");
                  treningDiv.hide();
                  let prikazDiv = $("#prikaz");
                  prikazDiv.show();

       $.ajax({
               type: "GET",
               url: "http://localhost:8080/pretraziPoTrajanju/" +kljucnaRec,
               dataType: "json",
               success: function (response) {
                   console.log("SUCCESS:\n", response);
                   for (let trening of response) {
                       let row = "<tr>";
                       row += "<td>" + trening.naziv + "</td>";
                       row += "<td>" + trening.opis + "</td>";
                      row += "<td>" + trening.tip_treninga + "</td>";
                      row += "<td>" + trening.trajanje + "</td>";
                      row += "<td>" + trening.cena + "</td>";
                       row += "</tr>";
                       $('#prikaz').append(row);
                   }

               },
               error: function (response) {
                   console.log("ERROR:\n", response);
               }
           });
       });
       $(document).on("submit","#pretraziPoCeni", function (event) {
             event.preventDefault();
                let kljucnaRec = $("#cena").val();
                 let treningDiv = $("#trening");
                         treningDiv.hide();
                         let prikazDiv = $("#prikaz");
                         prikazDiv.show();

              $.ajax({
                      type: "GET",
                      url: "http://localhost:8080/pretraziPoCeni/" +kljucnaRec,
                      dataType: "json",
                      success: function (response) {
                          console.log("SUCCESS:\n", response);
                          for (let trening of response) {
                              let row = "<tr>";
                              row += "<td>" + trening.naziv + "</td>";
                              row += "<td>" + trening.opis + "</td>";
                             row += "<td>" + trening.tip_treninga + "</td>";
                             row += "<td>" + trening.trajanje + "</td>";
                             row += "<td>" + trening.cena + "</td>";
                              row += "</tr>";
                              $('#prikaz').append(row);
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
                     $('#sortiranjePoCeni').hide();
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
                                    row += "<td>" + trening.cena + "</td>";
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
           $('#sortiranjePoCeni').hide();
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
                                       row += "<td>" + trening.cena + "</td>";
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

           $('#sortiranjePoCeni').hide();
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
                                        row += "<td>" + trening.cena + "</td>";
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

           $('#sortiranjePoCeni').hide();
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
                                         row += "<td>" + trening.cena + "</td>";
                                          row += "</tr>";
                                          $('#sortiranjePoTrajanju').append(row);
                                      }
                                  },
                                  error: function (response) {
                                      console.log("ERROR:\n", response);
                                  }
                              });
                          });
     $(document).on('click', '.sCena', function () {
     let treningDiv = $("#trening");
                                    treningDiv.hide();
$('#sortiranjePoNazivu').hide();
       $('#sortiranjePoOpisu').hide();
         $('#sortiranjePoTipu').hide();
           $('#sortiranjePoTrajanju').hide();

                                    let prikazDiv = $("#sortiranjePoCeni");
                                    prikazDiv.show();
              $.ajax({
                                 type: "GET",
                                 url: "http://localhost:8080/sortiraniPoCeni",
                                 dataType: "json",
                                 success: function (response) {
                                     console.log("SUCCESS:\n", response);
                                     for (let trening of response) {
                                         let row = "<tr>";
                                         row += "<td>" + trening.naziv + "</td>";
                                         row += "<td>" + trening.opis + "</td>";
                                        row += "<td>" + trening.tip_treninga + "</td>";
                                        row += "<td>" + trening.trajanje + "</td>";
                                        row += "<td>" + trening.cena + "</td>";
                                         row += "</tr>";
                                         $('#sortiranjePoCeni').append(row);
                                     }
                                 },
                                 error: function (response) {
                                     console.log("ERROR:\n", response);
                                 }
                             });
                         });