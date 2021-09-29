$(document).ready(function(){

    $(document).on("click", "table button.ml-2", function(){
            let id_of_button = (event.srcElement.id);
            let odontologoId = id_of_button.split("_")[2];

            $.ajax({
                url: '/api/odontologos/' + odontologoId,
                type: 'DELETE',
                success: function(response) {
                    alert("El odontologo con ID " + odontologoId + " se eliminó correctamente")
                    location.reload()
                },
                error: function(error){
                    console.log(error);
                    alert("No se encontró ningún odontologo con id " + odontologoId);
                }
            });
        });
});