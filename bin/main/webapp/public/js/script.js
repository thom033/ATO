<script>
    document.addEventListener('DOMContentLoaded', function () {
    var message = "<%= request.getAttribute("error") != null ? request.getAttribute("error") : ""%>";
    if (message) {
        Swal.fire({
            title: 'Problème lors de la génération des données',
            text: message,
            icon: 'error',
            confirmButtonText: 'OK'
        });
    }

    var success = "<%= request.getAttribute("succes") != null ? request.getAttribute("succes") :""%>";
    if (success) {
        Swal.fire({
            title: 'Insertion de données',
            text: success,
            icon: 'success',
            confirmButtonText: 'OK'
        });
    }
    });
</script>