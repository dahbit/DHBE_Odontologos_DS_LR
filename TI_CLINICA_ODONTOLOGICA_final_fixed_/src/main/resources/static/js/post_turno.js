document.getElementById("add_new_turno").onsubmit = function(e) {
    e.preventDefault();
};

window.addEventListener('load', function () {
    const formulario = document.querySelector('#add_new_turno');

    formulario.addEventListener('submit', function (event) {
        event.preventDefault();

        // Crear el JSON en el formato correcto
        const formData = {
            fechaHora: document.querySelector('#fechaHora').value,
            paciente: { id: document.querySelector('#paciente').value },
            odontologo: { id: document.querySelector('#odontologo').value }
        };

        const url = '/turnos';
        const settings = {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(formData)  // Convertir a JSON
        };

        fetch(url, settings)
            .then(response => {
                if (!response.ok) {
                    throw new Error('Error al crear el turno');
                }
                return response.json();
            })
            .then(data => {
                let successAlert = '<div class="alert alert-success">Turno agregado correctamente</div>';
                document.querySelector('#response').innerHTML = successAlert;
                document.querySelector('#response').style.display = "block";
                formulario.reset();  // Limpiar el formulario
            })
            .catch(error => {
                let errorAlert = '<div class="alert alert-danger">Error al agregar el turno</div>';
                document.querySelector('#response').innerHTML = errorAlert;
                document.querySelector('#response').style.display = "block";
                console.error('Error:', error);  // Mostrar el error en la consola
            });
    });
});
