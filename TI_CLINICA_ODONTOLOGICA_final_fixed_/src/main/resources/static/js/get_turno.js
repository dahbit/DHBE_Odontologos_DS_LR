window.addEventListener('load', function () {

    // Obtener la lista de turnos
    fetch('/turnos')
        .then(response => response.json())
        .then(turnos => {
            let turnoTable = document.querySelector('#turnoTableBody');
            turnoTable.innerHTML = '';
            turnos.forEach(turno => {
                let row = turnoTable.insertRow();
                row.innerHTML = `
                    <td>${turno.id}</td>
                    <td>${turno.fechaHora}</td>
                    <td>${turno.paciente.nombre} ${turno.paciente.apellido}</td>
                    <td>${turno.odontologo.nombre} ${turno.odontologo.apellido}</td>
                    <td>

                        <button class="btn btn-danger" onclick="eliminarTurno(${turno.id})">Eliminar</button>
                    </td>
                `;
            });
        });

    // Eliminar turno
    window.eliminarTurno = function(id) {
        const url = `/turnos/${id}`;
        fetch(url, { method: 'DELETE' })
            .then(() => {
                alert('Turno eliminado correctamente');
                window.location.reload();
            })
            .catch(error => console.error('Error:', error));
    };



});
