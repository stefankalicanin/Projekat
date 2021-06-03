
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