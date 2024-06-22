
var ctx = document.getElementById('myChart').getContext('2d');

var data = {
    labels: ['Jan', 'Fév', 'Mar', 'Avr', 'Mai', 'Jui'],
    datasets: [{
        label: 'Nombre de ventes mensuelles',
        data: [12, 19, 3, 5, 2, 3],
        backgroundColor: 'rgba(255, 99, 132, 0.2)',
        borderColor: 'rgba(255, 99, 132, 1)',
        borderWidth: 1
    }]
};

var options = {
    scales: {
        y: {
            beginAtZero: true
        }
    }
};

// Créer le graphique
var myChart = new Chart(ctx, {
    type: 'line', 
    data: data, 
    options: options
});