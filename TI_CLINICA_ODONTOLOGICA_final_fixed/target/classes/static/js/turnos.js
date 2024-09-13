
function get_turnos() {
    fetch('/turnos')
        .then(response => response.json())
        .then(turnos => {
            let turnosTable = document.getElementById('turnosTable');
            turnosTable.innerHTML = ''; // Clear table
            turnos.forEach(turno => {
                turnosTable.innerHTML += `
                    <tr>
                        <td>${turno.id}</td>
                        <td>${turno.paciente.nombre} ${turno.paciente.apellido}</td>
                        <td>${turno.odontologo.nombre} ${turno.odontologo.apellido}</td>
                        <td>${turno.fechaHora}</td>
                        <td>
                            <button onclick="delete_turno(${turno.id})">Eliminar</button>
                        </td>
                    </tr>`;
            });
        });
}

function post_turnos() {
    const turnoData = {
        pacienteId: document.getElementById('pacienteId').value,
        odontologoId: document.getElementById('odontologoId').value,
        fechaHora: document.getElementById('fechaHora').value
    };

    fetch('/turnos', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(turnoData)
    })
    .then(response => response.json())
    .then(data => {
        alert('Turno agregado correctamente');
        get_turnos();
    });
}

function delete_turno(id) {
    fetch(`/turnos/${id}`, {
        method: 'DELETE'
    })
    .then(() => {
        alert('Turno eliminado correctamente');
        get_turnos();
    });
}
