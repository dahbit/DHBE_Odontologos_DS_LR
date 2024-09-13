window.addEventListener('load', function () {

    // Obtener la lista de odontólogos
    fetch('/odontologos')
        .then(response => response.json())
        .then(odontologos => {
            let odontologoTable = document.querySelector('#odontologoTableBody');
            odontologoTable.innerHTML = '';
            odontologos.forEach(odontologo => {
                let row = odontologoTable.insertRow();
                row.innerHTML = `
                    <td>${odontologo.id}</td>
                    <td>${odontologo.nombre}</td>
                    <td>${odontologo.apellido}</td>
                    <td>${odontologo.matricula}</td>
                    <td>
                        <button class="btn btn-info" onclick="modificarOdontologo(${odontologo.id})">Modificar</button>
                        <button class="btn btn-danger" onclick="eliminarOdontologo(${odontologo.id})">Eliminar</button>
                    </td>
                `;
            });
        });

    // Función para modificar odontólogo
    window.modificarOdontologo = function(id) {
        fetch(`/odontologos/${id}`)
            .then(response => response.json())
            .then(odontologo => {
                document.querySelector('#odontologo_id').value = odontologo.id;
                document.querySelector('#nombre').value = odontologo.nombre;
                document.querySelector('#apellido').value = odontologo.apellido;
                document.querySelector('#matricula').value = odontologo.matricula;
                document.querySelector('#div_odontologo_updating').style.display = "block";
            })
            .catch(error => console.error('Error al cargar el odontólogo para modificar:', error));
    };

    // Guardar cambios del odontólogo modificado
    const updateForm = document.querySelector('#update_odontologo_form');
    updateForm.addEventListener('submit', function(event) {
        event.preventDefault();

        const id = document.querySelector('#odontologo_id').value;
        const formData = {
            id: id,
            nombre: document.querySelector('#nombre').value,
            apellido: document.querySelector('#apellido').value,
            matricula: document.querySelector('#matricula').value
        };

        fetch(`/odontologos/${id}`, {
            method: 'PUT',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(formData)
        })
        .then(response => {
            if (!response.ok) {
                throw new Error('Error al modificar el odontólogo');
            }
            alert('Odontólogo modificado correctamente');
            window.location.reload();  // Recargar la página para ver los cambios
        })
        .catch(error => console.error('Error al modificar el odontólogo:', error));
    });
     // Elimninar
    window.eliminarOdontologo = function(id) {
        if (confirm('¿Estás seguro de que deseas eliminar este odontólogo?')) {
            fetch(`/odontologos/${id}`, {
                method: 'DELETE'
            })
            .then(response => {
                if (!response.ok) {
                    throw new Error('Error al eliminar el odontólogo');
                }
                alert('Odontólogo eliminado correctamente');
                window.location.reload();  // Recargar la página para reflejar los cambios
            })
            .catch(error => {
                console.error('Error al eliminar el odontólogo:', error);
                alert('Error al eliminar el odontólogo');
            });
        }
    };
    //Buscar
    document.getElementById('searchField').addEventListener('input', function () {
        const filter = this.value.toLowerCase();
        const rows = document.querySelectorAll('#odontologoTableBody tr');

        rows.forEach(row => {
            const cells = row.querySelectorAll('td');
            const name = cells[1].textContent.toLowerCase();
            const lastName = cells[2].textContent.toLowerCase();
            const matricula = cells[3].textContent.toLowerCase();

            // Si la búsqueda coincide con el nombre, apellido o matrícula
            if (name.includes(filter) || lastName.includes(filter) || matricula.includes(filter)) {
                row.style.display = '';  // Mostrar fila
            } else {
                row.style.display = 'none';  // Ocultar fila
            }
        });
    });

});
