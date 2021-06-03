$(document).on("submit","#pretraziPoNazivu", function (event) {
  event.preventDefault();
     let kljucnaRec = $("#naziv").val();

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
                   $('#trening').append(row);
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
                      $('#trening').append(row);
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
                       $('#trening').append(row);
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
                       $('#trening').append(row);
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
                              $('#trening').append(row);
                          }
                      },
                      error: function (response) {
                          console.log("ERROR:\n", response);
                      }
                  });
              });