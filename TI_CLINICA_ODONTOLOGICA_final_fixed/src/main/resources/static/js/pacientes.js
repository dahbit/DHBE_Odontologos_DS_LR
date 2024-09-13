
function get_pacientes() {
    fetch('/pacientes')
        .then(response => response.json())
        .then(pacientes => {
            let pacientesTable = document.getElementById('pacientesTable');
            pacientesTable.innerHTML = ''; // Clear table
            pacientes.forEach(paciente => {
                pacientesTable.innerHTML += `
                    <tr>
                        <td>${paciente.id}</td>
                        <td>${paciente.nombre}</td>
                        <td>${paciente.apellido}</td>
                        <td>${paciente.dni}</td>
                        <td>${paciente.fechaAlta}</td>
                        <td>
                            <button onclick="delete_paciente(${paciente.id})">Eliminar</button>
                        </td>
                    </tr>`;
            });
        });
}

function post_pacientes() {
    const pacienteData = {
        nombre: document.getElementById('nombre').value,
        apellido: document.getElementById('apellido').value,
        dni: document.getElementById('dni').value,
        fechaAlta: document.getElementById('fechaAlta').value
    };

    fetch('/pacientes', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(pacienteData)
    })
    .then(response => response.json())
    .then(data => {
        alert('Paciente agregado correctamente');
        get_pacientes();
    });
}

function delete_paciente(id) {
    fetch(`/pacientes/${id}`, {
        method: 'DELETE'
    })
    .then(() => {
        alert('Paciente eliminado correctamente');
        get_pacientes();
    });
}
