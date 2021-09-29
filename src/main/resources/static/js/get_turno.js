$(document).ready(function(){
    (function(){
        $.ajax({
            type : "GET",
            url : "/api/turnos/",
            success: function(response){
              $.each(response, (i, turno) => {
                let get_More_Info_Btn = '<button' +
                                            ' id=' + '\"' + 'btn_id_' + turno.id + '\"' +
                                            ' type="button" class="btn btn-info btn_id">' +
                                            "Modificar" +
                                            '</button>';
                 let delete_Btn = '<button' +
                                                            ' id=' + '\"' + 'btn_id_' + turno.id + '\"' +
                                                            ' type="button" class="btn  btn-danger ml-2">' +
                                                            "Eliminar" +
                                                            '</button>';
                let tr_id = 'tr_' + turno.id;
                let turnoRow = '<tr id=\"' + tr_id + "\"" + '>' +
                          '<td>' + turno.id + '</td>' +
                          '<td class=\"td_first_name\">' + turno.nombre.toUpperCase() + '</td>' +
                          '<td class=\"td_last_name\">' + turno.apellido + '</td>' +
                          '<td class=\"td_matricula\">' + turno.matricula + '</td>' +
                          '<td>' + get_More_Info_Btn + '</td>' +
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