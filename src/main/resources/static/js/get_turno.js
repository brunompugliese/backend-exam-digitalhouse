$(document).ready(function(){
    (function(){
        $.ajax({
            type : "GET",
            url : "/api/turnos/",
            success: function(response){
              $.each(response, (i, turno) => {
                
                 let delete_Btn = '<button' +
                                                            ' id=' + '\"' + 'btn_id_' + turno.id + '\"' +
                                                            ' type="button" class="btn  btn-danger ml-2">' +
                                                            "Eliminar" +
                                                            '</button>';
                let tr_id = 'tr_' + turno.id;
                let turnoRow = '<tr id=\"' + tr_id + "\"" + '>' +
                          '<td>' + turno.id + '</td>' +
                          '<td class=\"td_fecha\">' + turno.fecha + '</td>' +
                          '<td class=\"td_odontologo\">' + turno.odontologo.nombre + ' ' + turno.odontologo.apellido + '</td>' +
                          '<td class=\"td_paciente\">' + turno.paciente.nombre + ' ' + turno.paciente.apellido + '</td>' +
                          '<td>' + delete_Btn + '</td>' +
                          '</tr>';
                $('#turnoTable tbody').append(turnoRow);
              });
            },
            error : function(e) {
              alert("ERROR: ", e);
              console.log("ERROR: ", e);
            }
        });
    })();

    (function(){
        let pathname = window.location.pathname;
        if (pathname == "/turnos.html") {
            $(".nav .nav-item a:last").addClass("active");
        }
    })();
});