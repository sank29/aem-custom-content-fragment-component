document.addEventListener("DOMContentLoaded", function () {
  const imageTextTextImage = document.getElementById("imageTextTextImage");
  const jsonData = imageTextTextImage.getAttribute("data-json");
  const json02Data = imageTextTextImage.getAttribute("data02-json");

  try {
    const data = JSON.parse(jsonData);
    const data02 = JSON.parse(json02Data);

    console.log("Parsed data:", data);
    console.log("Parsed data:", data02);

    // First Card

    //Image
    let cardImgTopFirstContainer = document.getElementsByClassName(
      "card-img-top-firstContainer"
    )[0];
    cardImgTopFirstContainer.src = data["cardImage"];

    //Title
    let cardTitleFirstContainer = document.getElementsByClassName(
      "card-title-firstContainer"
    )[0];
    cardTitleFirstContainer.innerHTML = data["cardTitle"];

    //Description
    let cardTextFirstContainer = document.getElementsByClassName(
      "card-text-firstContainer"
    )[0];
    cardTextFirstContainer.innerHTML = data["cardDescription"];

    //Path
    let btnFirstContainer =
      document.getElementsByClassName("btn-firstContainer")[0];
    btnFirstContainer.href = data["path"];

    // Second Card

    //Image
    let cardImgTopSecondContainer = document.getElementsByClassName(
      "card-img-top-secondContainer"
    )[0];
    cardImgTopSecondContainer.src = data02["cardImage"];

    //Title
    let cardTitleSecondContainer = document.getElementsByClassName(
      "card-title-secondContainer"
    )[0];
    cardTitleSecondContainer.innerHTML = data02["cardTitle"];

    //Description
    let cardTextsecondContainer = document.getElementsByClassName(
      "card-text-secondContainer"
    )[0];
    cardTextsecondContainer.innerHTML = data02["cardDescription"];

    //Path
    let btnSecondContainer = document.getElementsByClassName(
      "btn-secondContainer"
    )[0];
    btnSecondContainer.href = data02["path"];
  } catch (e) {
    console.error("Error parsing JSON:", e);
  }
});
