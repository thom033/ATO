document.addEventListener('DOMContentLoaded', function () {
    // Statistique en bâtons
    const barChartContainer = document.getElementById('barChartCanvas');
    if (!barChartContainer) {
        console.error('Bar chart container not found.');
        return;
    }
    const barCtx = barChartContainer.getContext('2d');
    const barChart = new Chart(barCtx, {
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


