let timerInterval;
let startTime;

document.getElementById('startBtn').addEventListener('click', () => {
    startTime = new Date().getTime();
    timerInterval = setInterval(updateTimer, 1000);
});

document.getElementById('stopBtn').addEventListener('click', () => {
    clearInterval(timerInterval);
    const endTime = new Date().getTime();
    const duration = endTime - startTime;

    // Envoi au backend
    fetch(`/skills/${id}/add-time`, {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ duration: duration })
    }).then(response => alert("Temps enregistré !"));
});

function updateTimer() {
    const elapsed = new Date().getTime() - startTime;
    document.getElementById('timer').textContent = new Date(elapsed).toISOString().substr(11, 8);
}