const pageItems = document.querySelectorAll(".pagination .page-item");

      pageItems.forEach((item) => {
        item.addEventListener("click", () => {
          pageItems.forEach((pageItem) => {
            pageItem.classList.remove("active");
          });
          item.classList.add("active");
        });
      });

      function incrementQuantity() {
        var quantityInput = document.getElementById("quantityInput");
        var currentValue = parseInt(quantityInput.value);
        if (!isNaN(currentValue)) {
          quantityInput.value = currentValue + 1;
        }
      }

      function decrementQuantity() {
        var quantityInput = document.getElementById("quantityInput");
        var currentValue = parseInt(quantityInput.value);
        if (!isNaN(currentValue) && currentValue > 1) {
          quantityInput.value = currentValue - 1;
        }
      }

      const productDetailTab = document.querySelector(
        ".product-tab:first-child a"
      );
      const productReviewTab = document.querySelector(
        ".product-tab:nth-child(2) a"
      );
      const productInquiryTab = document.querySelector(
        ".product-tab:nth-child(3) a"
      );
      const productDetailSection = document.getElementById("product-detail");
      const productReviewSection = document.getElementById("product-review");
      const productInquirySection = document.getElementById("product-inquiry");

      productDetailTab.addEventListener("click", (e) => {
        e.preventDefault();
        productDetailSection.scrollIntoView({ behavior: "smooth" });
      });

      productReviewTab.addEventListener("click", (e) => {
        e.preventDefault();
        productReviewSection.scrollIntoView({ behavior: "smooth" });
      });

      productInquiryTab.addEventListener("click", (e) => {
        e.preventDefault();
        productInquirySection.scrollIntoView({ behavior: "smooth" });
      });
      
      
      