var data = {
    labels: ['Catégorie 1', 'Catégorie 2', 'Catégorie 3'],
    datasets: [{
        data: [30, 40, 30],
        backgroundColor: ['#ff6384', '#36a2eb', '#ffce56']
    }]
};

var options = {
    responsive: true,
    maintainAspectRatio: false
};

var ctx = document.getElementById('myPieChart').getContext('2d');

var myPieChart = new Chart(ctx, {
    type: 'pie',
    data: data,
    options: options
});