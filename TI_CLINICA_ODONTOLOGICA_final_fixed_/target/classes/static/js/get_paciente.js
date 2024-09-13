window.addEventListener('load', function () {

    // Obtener la lista de pacientes
    fetch('/pacientes')
        .then(response => response.json())
        .then(pacientes => {
            let pacienteTable = document.querySelector('#pacienteTableBody');
            pacienteTable.innerHTML = '';
            pacientes.forEach(paciente => {
                let row = pacienteTable.insertRow();
                row.innerHTML = `
                    <td>${paciente.id}</td>
                    <td>${paciente.nombre}</td>
                    <td>${paciente.apellido}</td>
                    <td>${paciente.dni}</td>
                    <td>
                        <button class="btn btn-info" onclick="modificarPaciente(${paciente.id})">Modificar</button>
                        <button class="btn btn-danger" onclick="eliminarPaciente(${paciente.id})">Eliminar</button>
                    </td>
                `;
            });
        });

    // Función para modificar paciente
    window.modificarPaciente = function(id) {
        fetch(`/pacientes/${id}`)
            .then(response => response.json())
            .then(paciente => {
                document.querySelector('#paciente_id').value = paciente.id;
                document.querySelector('#nombre').value = paciente.nombre;
                document.querySelector('#apellido').value = paciente.apellido;
                document.querySelector('#dni').value = paciente.dni;
                document.querySelector('#div_paciente_updating').style.display = "block";
            })
            .catch(error => console.error('Error al cargar el paciente para modificar:', error));
    };

    // Guardar cambios del paciente modificado
    const updateForm = document.querySelector('#update_paciente_form');
    updateForm.addEventListener('submit', function(event) {
        event.preventDefault();

        const id = document.querySelector('#paciente_id').value;
        const formData = {
            id: id,
            nombre: document.querySelector('#nombre').value,
            apellido: document.querySelector('#apellido').value,
            dni: document.querySelector('#dni').value
        };

        fetch(`/pacientes/${id}`, {
            method: 'PUT',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(formData)
        })
        .then(response => {
            if (!response.ok) {
                throw new Error('Error al modificar el paciente');
            }
            alert('Paciente modificado correctamente');
            window.location.reload();  // Recargar la página para ver los cambios
        })
        .catch(error => console.error('Error al modificar el paciente:', error));
    });

    // Función de eliminar paciente
    window.eliminarPaciente = function(id) {
        if (confirm('¿Estás seguro de que deseas eliminar este paciente?')) {
            fetch(`/pacientes/${id}`, {
                method: 'DELETE'
            })
            .then(response => {
                if (!response.ok) {
                    throw new Error('Error al eliminar el paciente');
                }
                alert('Paciente eliminado correctamente');
                window.location.reload();  // Recargar la página para reflejar los cambios
            })
            .catch(error => {
                console.error('Error al eliminar el paciente:', error);
                alert('Error al eliminar el paciente');
            });
        }
    };

    // Función de búsqueda
    document.getElementById('searchField').addEventListener('input', function () {
        const filter = this.value.toLowerCase();
        const rows = document.querySelectorAll('#pacienteTableBody tr');

        rows.forEach(row => {
            const cells = row.querySelectorAll('td');
            const name = cells[1].textContent.toLowerCase();
            const lastName = cells[2].textContent.toLowerCase();
            const dni = cells[3].textContent.toLowerCase();

            // Si la búsqueda coincide con el nombre, apellido o DNI
            if (name.includes(filter) || lastName.includes(filter) || dni.includes(filter)) {
                row.style.display = '';  // Mostrar fila
            } else {
                row.style.display = 'none';  // Ocultar fila
            }
        });
    });
});
