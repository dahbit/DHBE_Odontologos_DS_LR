window.addEventListener('load', function () {
    (function(){

      const url = '/turnos';
      const settings = {
        method: 'GET'
      };

      fetch(url, settings)
      .then(response => response.json())
      .then(data => {
        console.log(data);
        for (turno of data) {
            console.log(turno);
            var table = document.getElementById("turnoTable");
            var turnoRow = table.insertRow();
            let tr_id = 'tr_' + turno.id;
            turnoRow.id = tr_id;

            turnoRow.innerHTML = '<td class=\"td_id\">' + turno.id + '</td>' +
                    '<td class=\"td_paciente\">' + turno.paciente.nombre.toUpperCase() + ' ' + turno.paciente.apellido.toUpperCase() + '</td>' +
                    '<td class=\"td_odontologo\">' + turno.odontologo.nombre.toUpperCase() + ' ' + turno.odontologo.apellido.toUpperCase() + '</td>' +
                    '<td class=\"td_fechaHora\">' + turno.fecha + '</td>';
        }
      });
    })();

    (function(){
      let pathname = window.location.pathname;
      if (pathname == "/turnoList.html") {
          document.querySelector(".nav .nav-item a:last").addClass("active");
      }
    })();
});
