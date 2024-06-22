function validateForm(step) {
    var form = document.getElementById('form-' + step);
    if (form.checkValidity()) {
        if (step < 3) {
            nextStep(step + 1);
        } else {
            document.getElementById('success-message').style.display = 'block';
        }
        return false; // Prevent the default form submission
    }
    return false; // Prevent the default form submission if form is invalid
}

function nextStep(step) {
    var currentStep = document.querySelector('.step-form.active');
    if (currentStep) {
        currentStep.classList.remove('active');
    }
    var nextStep = document.getElementById('step-' + step);
    if (nextStep) {
        nextStep.classList.add('active');
    }
}

document.addEventListener('DOMContentLoaded', function () {
    const ctx = document.getElementById('barChartCanvas').getContext('2d');
    const barChart = new Chart(ctx, {
        type: 'bar',
        data: {
            labels: ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun', 'Jul'],
            datasets: [{
                label: 'Statistique Bâton',
                data: [65, 59, 10, 81, 56, 55, 40],
                backgroundColor: 'rgba(255, 99, 132, 0.2)',
                borderColor: 'rgba(255, 99, 132, 1)',
                borderWidth: 1
            }]
        },
        options: {
            scales: {
                y: {
                    beginAtZero: true
                }
            }
        }
    });
});

var ctx = document.getElementById('myChart').getContext('2d');

// Définit les données pour le graphique (exemple)
var data = {
    labels: ['Statistique 1', 'Statistique 2', 'Statistique 3'],
    datasets: [{
        label: 'Mes Statistiques',
        data: [30, 50, 20], // Les valeurs correspondantes aux statistiques
        backgroundColor: [
            'rgba(255, 99, 132, 0.2)',
            'rgba(54, 162, 235, 0.2)',
            'rgba(255, 206, 86, 0.2)'
        ],
        borderColor: [
            'rgba(255, 99, 132, 1)',
            'rgba(54, 162, 235, 1)',
            'rgba(255, 206, 86, 1)'
        ],
        borderWidth: 1
    }]
};

// Configure et dessine le graphique
var myPieChart = new Chart(ctx, {
    type: 'pie',
    data: data,
    options: {
        // Ajoute des options supplémentaires ici si nécessaire
    }
});
