$(document).ready(function(){
    (function(){
        $.ajax({
            type : "GET",
            url : "/api/pacientes/",
            success: function(response){
              $.each(response, (i, paciente) => {
                let get_More_Info_Btn = '<button' +
                                            ' id=' + '\"' + 'btn_id_' + paciente.id + '\"' +
                                            ' type="button" class="btn btn-info btn_id">' +
                                            "Modificar" +
                                            '</button>';
                 let delete_Btn = '<button' +
                                                            ' id=' + '\"' + 'btn_id_' + paciente.id + '\"' +
                                                            ' type="button" class="btn  btn-danger ml-2">' +
                                                            "Eliminar" +
                                                            '</button>';
                let tr_id = 'tr_' + paciente.id;
                let pacienteRow = '<tr id=\"' + tr_id + "\"" + '>' +
                          '<td>' + paciente.id + '</td>' +
                          '<td class=\"td_first_name\">' + paciente.nombre.toUpperCase() + '</td>' +
                          '<td class=\"td_last_name\">' + paciente.apellido.toUpperCase() + '</td>' +
                          '<td class=\"td_dni\">' + paciente.dni + '</td>' +
                          '<td class=\"td_fecha\">' + paciente.fechaAlta + '</td>' +
                          '<td class=\"td_domicilio\">' + paciente.domicilio.calle + ' ' + paciente.domicilio.numero + ', ' + paciente.domicilio.provincia + '</td>' +
                          '<td>' + get_More_Info_Btn + '</td>' +
                          '<td>' + delete_Btn + '</td>' +
                          '</tr>';
                $('#pacienteTable tbody').append(pacienteRow);
              });
            },
            error : function(e) {
              alert("Ocurrió un error inesperado");
              console.log("ERROR: ", e);
            }
        });
    })();

    (function(){
        let pathname = window.location.pathname;
        if (pathname == "/pacientes.html") {
            $(".nav .nav-item a:last").addClass("active");
        }
    })();
});