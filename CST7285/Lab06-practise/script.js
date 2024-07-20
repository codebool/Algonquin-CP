// Wait for the entire DOM to load before executing the script.
document.addEventListener("DOMContentLoaded", function () {
    // Get references to the elements in the DOM.
    const itemSelect = document.getElementById("item");  // Dropdown to select items.
    const priceInput = document.getElementById("price");  // Input field to display the price of the selected item.
    const discountInput = document.getElementById("discount");  // Input field to enter the discount.
    const totalInput = document.getElementById("total");  // Input field to display the total cost after discount.
    const addItemButtons = document.querySelectorAll(".addItemButton");  // Buttons to add items to the order.
    const modal = document.getElementById("modal");  // Modal dialog for adding an item to the order.
    const closeModalBtn = document.querySelector(".close");  // Button to close the modal dialog.

    // Inventory object with item prices.
    const inventory = {
        "item1": 10,
        "item2": 20,
        "item3": 30
    };

    // Function to update the price and total cost based on the selected item and discount.
    function updatePriceAndTotal() {
        const selectedItem = itemSelect.value;  // Get the selected item from the dropdown.
        const price = inventory[selectedItem];  // Get the price of the selected item from the inventory.
        priceInput.value = price;  // Set the price input field to the price of the selected item.

        const discount = parseFloat(discountInput.value) || 0;  // Get the discount value, defaulting to 0 if invalid.
        const total = price - (price * discount / 100);  // Calculate the total cost after discount.
        totalInput.value = total.toFixed(2);  // Set the total input field to the total cost, formatted to 2 decimal places.
    }

    // Event listener to update the price and total when the selected item changes.
    itemSelect.addEventListener("change", function () {
        discountInput.value = "";  // Clear the discount input field.
        updatePriceAndTotal();  // Update the price and total cost.
    });

    // Event listener to update the total when the discount value changes.
    discountInput.addEventListener("input", function () {
        discountInput.value = discountInput.value.replace(/[^0-9.]/g, '');  // Allow only numbers and decimal point.
        updatePriceAndTotal();  // Update the price and total cost.
    });

    // Event listeners for each add item button to show the modal dialog with the selected item.
    addItemButtons.forEach(button => {
        button.addEventListener("click", function () {
            const selectedItem = this.getAttribute("data-item");  // Get the item from the data attribute of the button.
            itemSelect.value = selectedItem;  // Set the selected item in the dropdown.
            itemSelect.dispatchEvent(new Event("change"));  // Trigger a change event on the dropdown to update the price and total.
            modal.style.display = "flex";  // Display the modal dialog.
        });
    });

    // Event listener to close the modal dialog when the close button is clicked.
    closeModalBtn.addEventListener("click", function () {
        modal.style.display = "none";  // Hide the modal dialog.
    });

    // Event listener to close the modal dialog when clicking outside of it.
    window.addEventListener("click", function (event) {
        if (event.target == modal) {
            modal.style.display = "none";  // Hide the modal dialog.
        }
    });

    // Trigger an initial change event to set the default values for price and total.
    itemSelect.dispatchEvent(new Event("change"));
});
