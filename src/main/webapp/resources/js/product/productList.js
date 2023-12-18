  const pageItems = document.querySelectorAll(".pagination .page-item");

      pageItems.forEach((item) => {
        item.addEventListener("click", () => {
          pageItems.forEach((pageItem) => {
            pageItem.classList.remove("active");
          });
          item.classList.add("active");
        });
      });