let employeeName = document.querySelector(".name");

if (employeeName) {
  employeeName.setAttribute("id", "sanket");

  employeeName.addEventListener("click", function () {
    alert("You have clicked on the name");
  });
}