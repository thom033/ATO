<script>
    document.addEventListener('DOMContentLoaded', function () {
<<<<<<< HEAD
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
=======
        var message = "<%= request.getAttribute("error") != null ? request.getAttribute("error") : "" %>";
        if (message != "") {
            Swal.fire({
                title: 'Problème lors de la génération des données',
                text: message,
                icon: 'error',
                confirmButtonText: 'OK'
            });
        }

        var success = "<%= request.getAttribute("succes") != null ? request.getAttribute("succes") : "" %>";
        if (success) {
            Swal.fire({
                title: 'Insertion de données',
                text: success,
                icon: 'success',
                confirmButtonText: 'OK'
            });
        }
>>>>>>> 6ec5de43d74db76f175303a9debb3788f0d631d9
    });
</script>