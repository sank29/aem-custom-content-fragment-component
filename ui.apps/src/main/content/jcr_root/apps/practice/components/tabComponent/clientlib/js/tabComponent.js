const decodeHtml = (text) => {
  const txt = document.createElement("textarea");
  txt.innerHTML = text;
  return txt.value;
};

document.addEventListener("DOMContentLoaded", function () {
  const tabComponent = document.getElementById("tabComponent");
  const jsonData = tabComponent.getAttribute("data-json");
  const listOfNav = document.querySelectorAll(".card-header .nav-link");

  // ✅ Load default card (first tab)
  defaultCard(jsonData);

  // ✅ Add event listeners for each tab
  listOfNav.forEach((nav, index) => {
    nav.addEventListener("click", (event) => {
      event.preventDefault(); // Prevent link jump

      // ✅ Remove 'active' from all tabs
      listOfNav.forEach((n) => n.classList.remove("active"));

      // ✅ Add 'active' to clicked tab
      nav.classList.add("active");

      // ✅ Update card content
      renderCard(jsonData, index);
    });
  });
});

function renderCard(jsonData, index) {
  try {
    const data = JSON.parse(jsonData);
    const container = document.querySelector(".card-body");
    container.innerHTML = ""; // Clear old content

    const card = data[index];
    const title = decodeHtml(card.cardTitle);
    const desc = decodeHtml(card.cardDescription);
    const img = card.imageLocation;
    const path = card.path;

    const cardHtml = `
      <div class="tab-card">
        <img src="${img}" alt="Image" class="img-fluid" />
        <span class="tab-content"><h2 class="display-6">${desc}</h2>
        <a class="btn btn-primary" href="${path}" role="button">Explore</a>
      </div>
    `;

    container.innerHTML = cardHtml;
  } catch (e) {
    console.error("Error parsing JSON:", e);
  }
}

function defaultCard(jsonData) {
  // ✅ Render first card by default and mark first tab active
  renderCard(jsonData, 0);

  const firstTab = document.querySelector(".card-header .nav-link");
  if (firstTab) {
    firstTab.classList.add("active");
  }
}
