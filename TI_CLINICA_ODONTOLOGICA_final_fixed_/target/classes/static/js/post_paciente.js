document.getElementById("add_new_paciente").onsubmit = function(e) {
    e.preventDefault();
};

window.addEventListener('load', function () {
    const formulario = document.querySelector('#add_new_paciente');

    formulario.addEventListener('submit', function (event) {
        event.preventDefault();
        const formData = {
            nombre: document.querySelector('#nombre').value,
            apellido: document.querySelector('#apellido').value,
            dni: document.querySelector('#dni').value,
        };

        const url = '/pacientes';
        const settings = {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(formData)
        };

        fetch(url, settings)
            .then(response => response.json())
            .then(() => {
                let successAlert = '<div class="alert alert-success">Paciente agregado correctamente</div>';
                document.querySelector('#response').innerHTML = successAlert;
                document.querySelector('#response').style.display = "block";
                formulario.reset();
            })
            .catch(error => {
                let errorAlert = '<div class="alert alert-danger">Error al agregar el paciente</div>';
                document.querySelector('#response').innerHTML = errorAlert;
                document.querySelector('#response').style.display = "block";
            });
    });
});
