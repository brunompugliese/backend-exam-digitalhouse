$(document).ready(function(){

    $(document).on("click", "table button.ml-2", function(){
            let id_of_button = (event.srcElement.id);
            let pacienteId = id_of_button.split("_")[2];

            $.ajax({
                url: '/api/pacientes/' + pacienteId,
                type: 'DELETE',
                success: function(response) {
                    alert("El paciente con ID " + pacienteId + " se eliminó correctamente")
                    location.reload()
                },
                error: function(error){
                    console.log(error);
                    alert("No se encontró ningún paciente con id " + pacienteId);
                }
            });
        });
});