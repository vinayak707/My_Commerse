document.addEventListener("DOMContentLoaded", function () {
  const registrationForm = document.getElementById("registrationForm");
  const responseElement = document.getElementById("response");

  registrationForm.addEventListener("submit", function (event) {
    event.preventDefault();

    const formData = new FormData(this);
    const password = formData.get("password");
    const confirmPassword = formData.get("confirmPassword");

    if (password !== confirmPassword) {
      responseElement.textContent = "Passwords do not match.";
      return;
    }

    const xhr = new XMLHttpRequest();
    xhr.open("POST", "register.php");
    xhr.onload = function () {
      if (xhr.status === 200) {
        responseElement.textContent = "Registration successful!";
      } else {
        responseElement.textContent = "Error registering user.";
      }
    };
    xhr.send(formData);
  });
});
