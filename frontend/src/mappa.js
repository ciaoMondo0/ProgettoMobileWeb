function loadComuni() {
    $.ajax({
        type: "GET",
        url: "/api/comuni",
        success: function(response) {
            response.forEach(function(comune) {
                var marker = L.marker([comune.lat, comune.lng]).addTo(map)
                    .bindPopup("<b>" + comune.nome + "</b><br>"
                        + "<button onclick='deleteComune(" + comune.id + ")'>Delete</button>");
            });
        },
        error: function(err) {
            alert("Errore caricamento comunit" + err.responseJSON.message);
        }
    });
}

function deleteComune(id) {
    $.ajax({
        type: "DELETE",
        url: "/api/comuni/" + id,
        success: function(response) {
            alert("Comune cancellato con successo");
            location.reload();
        },
        error: function(err) {
            alert("Errore cancellazione comuni " + err.responseJSON.message);
        }
    });
}

$(document).ready(function() {
    loadComuni();
});