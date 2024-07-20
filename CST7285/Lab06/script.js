document.addEventListener("DOMContentLoaded", function () {
    const selectElement = document.getElementById("newitem");
    const itemInput = document.getElementById("item");
    const retailInput = document.getElementById("retail");
    const discountInput = document.getElementById("discount");
    const totalInput = document.getElementById("total");

    selectElement.addEventListener("change", function () {
        const selectedIndex = selectElement.value;
        if (selectedIndex !== "none") {
            const selectedItem = inventory[selectedIndex];
            itemInput.value = selectedItem[0];
            retailInput.value = selectedItem[2];
            totalInput.value = selectedItem[2];
        } else {
            itemInput.value = "";
            retailInput.value = "";
            totalInput.value = "";
        }
    });

    discountInput.addEventListener("input", function () {
        const retail = parseFloat(retailInput.value);
        const discount = parseFloat(discountInput.value) / 100;
        const priceAfterDiscount = retail - (retail * discount);

        if (priceAfterDiscount <= inventory[selectElement.value][1]) {
            alert("Discounted price is less than the minimum");
            discountInput.value = "";
        }
        if (!isNaN(retail) && !isNaN(discount) && priceAfterDiscount > inventory[selectElement.value][1]) {
            totalInput.value = (retail - (retail * discount)).toFixed(2);
        } else {
            totalInput.value = retailInput.value;
        }
    });

    selectElement.dispatchEvent(new Event("change")); // Trigger the change event
});