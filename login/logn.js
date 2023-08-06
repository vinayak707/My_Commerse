// Get a reference to the signup button element
var signupButton = document.getElementById("signup");
var loginButton = document.querySelector(".login-button");

let usercred = JSON.parse(localStorage.getItem("usercred")) || "";
// Add a click event listener to the button
signupButton.addEventListener("click", function () {
  // Redirect the user to the signup page
  console.log(usercred);
  window.location.href = "../signup/signup.html"; // Replace with your actual signup page URL
});

let userName = document.querySelector("#username");
let password = document.querySelector("#password");

loginButton.addEventListener("click", function (event) {
  event.preventDefault();
  if (
    usercred.email === userName.value &&
    usercred.password === password.value
  ) {
    window.location.href = "../dashboard/index.html";
  } else {
    alert("Invalid credentials");
  }
});
