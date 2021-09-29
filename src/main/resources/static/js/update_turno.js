$(document).ready(function(){
    $("#update_turno_form").submit(function(evt) {
        evt.preventDefault();
        try {
            let turnoId = $("#turno_id").val();

        let formData = {
            id: $("#turno_id").val(),
            nombre : $("#nombre").val(),
            apellido :  $("#apellido").val(),
            matricula: $("#matricula").val(),
        }

            $.ajax({
                url: '/api/turnos/',
                type: 'PUT',
                contentType : "application/json",
                data: JSON.stringify(formData),
                dataType : 'json',
                async: false,
                cache: false,
                success: function (response) {
                    let turno = response;

                    let successAlert = '<div class="alert alert-success alert-dismissible">' +
                                            '<button type="button" class="close" data-dismiss="alert">&times;</button>' +
                                            '<strong> El odontólogo se actualizó con éxito </strong></div>'


                    $("#tr_" + turnoId + " td.td_first_name").text(turno.nombre.toUpperCase());
                    $("#tr_" + turnoId + " td.td_last_name").text(turno.apellido.toUpperCase());
                    $("#tr_" + turnoId + " td.td_matricula").text(turno.matricula);

                    $("#response").empty();
                    $("#response").append(successAlert);
                    $("#response").css({"display": "block"});
                },

                error: function (response) {
                    let errorAlert = '<div class="alert alert-danger alert-dismissible">' +
                                        '<button type="button" class="close" data-dismiss="alert">&times;</button>' +
                                        '<strong> Ocurrió un error inesperado </strong></div>';

                    $("#response").empty();
                    $("#response").append(errorAlert);
                    $("#response").css({"display": "block"});
                }
            });
        } catch(error){
            console.log(error);
            alert(error);
        }
    });

    $(document).on("click", "table button.btn_id", function(){
        let id_of_button = (event.srcElement.id);
        let turnoId = id_of_button.split("_")[2];

        $.ajax({
            url: '/api/turnos/' + turnoId,
            type: 'GET',
            success: function(response) {
                let turno = response;
                $("#turno_id").val(turno.id);
                $("#nombre").val(turno.nombre);
                $("#apellido").val(turno.apellido);
                $("#matricula").val(turno.matricula);
                $("#div_turno_updating").css({"display": "block"});
            },
            error: function(error){
                console.log(error);
                alert("Error -> " + error);
            }
        });
    });
});