$(document).ready(function(){

    $(document).on("click", "table button.ml-2", function(){
            let id_of_button = (event.srcElement.id);
            let turnoId = id_of_button.split("_")[2];

            $.ajax({
                url: '/api/turnos/' + turnoId,
                type: 'DELETE',
                success: function(response) {
                    alert("El turno con ID " + turnoId + " se eliminó correctamente")
                    location.reload()
                },
                error: function(error){
                    console.log(error);
                    alert("No se encontró ningún turno con id " + turnoId);
                }
            });
        });
});