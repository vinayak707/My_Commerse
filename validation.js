const loginForm = document.getElementById("loginForm");
loginForm.addEventListener("submit", validateLoginForm);

function validateLoginForm(event) {
  event.preventDefault();

  const email = document.getElementById("email");
  const password = document.getElementById("password");

  // Validate email
  if (!validateEmail(email.value)) {
    alert("Please enter a valid email address.");
    return;
  }

  // Validate password
  if (!validatePassword(password.value)) {
    alert("Please enter a valid password.");
    return;
  }

  // If all validations pass, submit the form
  alert("Login successful!");
}

function validateEmail(email) {
  // Use a regular expression to check if the email is valid
  const emailRegex = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;
  return emailRegex.test(email);
}

function validatePassword(password) {
  // Customize these rules to match your password requirements
  const minLength = 8;
  const hasUpperCase = /[A-Z]/.test(password);
  const hasLowerCase = /[a-z]/.test(password);
  const hasNumber = /\d/.test(password);

  return (
    password.length >= minLength && hasUpperCase && hasLowerCase && hasNumber
  );
}

<div id="errorMessages" style="color: red;"></div>;

function validateLoginForm(event) {
  event.preventDefault();

  const email = document.getElementById("email");
  const password = document.getElementById("password");
  const errorMessages = document.getElementById("errorMessages");

  errorMessages.innerHTML = "";

  // Validate email
  if (!validateEmail(email.value)) {
    errorMessages.innerHTML += "<p>Please enter a valid email address.</p>";
    return;
  }

  // Validate password
  if (!validatePassword(password.value)) {
    errorMessages.innerHTML += "<p>Please enter a valid password.</p>";
    return;
  }

  // If all validations pass, submit the form
  alert("Login successful!");
}
