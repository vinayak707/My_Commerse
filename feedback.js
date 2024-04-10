document.addEventListener("DOMContentLoaded", function () {
  const feedbackForm = document.getElementById("feedbackForm");
  const responseElement = document.getElementById("response");

  feedbackForm.addEventListener("submit", function (event) {
    event.preventDefault();

    const formData = new FormData(this);
    const xhr = new XMLHttpRequest();
    xhr.open("POST", "submit-feedback.php");
    xhr.onload = function () {
      if (xhr.status === 200) {
        responseElement.textContent = "Feedback submitted successfully!";
      } else {
        responseElement.textContent = "Error submitting feedback.";
      }
    };
    xhr.send(formData);
  });
});
