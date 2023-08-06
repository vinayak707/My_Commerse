console.log("hellow");
let form = document.querySelector(".signup-form");
let signupBtn = document.querySelector(".signupBtn");
let checkPassword = true;
let email = form.querySelector("#email");
let mobileNumber = form.querySelector("#mobile");
let password = form.querySelector("#password");
let confirmpassword = form.querySelector("#confrmpwd");

signupBtn.addEventListener("click", function (event) {
  event.preventDefault();
  let username = form.querySelector("#username");
  console.log(username.value);
  let signupcred = {
    email: email.value,
    mobileNumber: mobileNumber.value,
    password: password.value,
    confirmpwd: confirmpassword.value,
  };
  console.log(signupcred);
  if (checkPassword) {
    alert("signup successfull");
    email.value = "";
    mobileNumber.value = "";
    password.value = "";
    confirmpassword.value = "";
    username.value = "";
    localStorage.setItem("usercred", JSON.stringify(signupcred));
  }
});

confirmpassword.addEventListener("change", function () {
  console.log(confirmpassword.value);
  if (confirmpassword.value !== password.value) {
    checkPassword = false;
    alert("confirm password doesn't match with password");
  } else {
    checkPassword = true;
  }
});
