const minPriceInput = document.getElementById("minPrice");
const maxPriceInput = document.getElementById("maxPrice");
const applyFilterButton = document.getElementById("applyFilter");
const productItems = document.querySelectorAll(".product-item"); // Replace with your selector

// Apply price filter
applyFilterButton.addEventListener("click", () => {
    const minPrice = parseFloat(minPriceInput.value);
    const maxPrice = parseFloat(maxPriceInput.value);

    // Loop through product items and hide/show based on price
    productItems.forEach(item => {
        const itemPrice = parseFloat(item.dataset.price); // Use the appropriate attribute
        if (itemPrice >= minPrice && itemPrice <= maxPrice) {
            item.style.display = "block";
        } else {
            item.style.display = "none";
        }
    });
});
