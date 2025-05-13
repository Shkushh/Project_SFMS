$(document).ready(function () {
  $('#loginForm').on('submit', function (e) {
    e.preventDefault();
    const studentId = $('#studentId').val().trim();

    if (studentId === "") {
      alert("Please enter your Student ID.");
      return;
    }

    // Simulated login
    window.location.href = 'feedback.html';
  });
});
