 const agreeCheck1 = document.getElementById("agreeCheck1");
      const agreeCheck2 = document.getElementById("agreeCheck2");
      const agreeCheck3 = document.getElementById("agreeCheck3");

      agreeCheck1.addEventListener("change", () => {
        const isChecked = agreeCheck1.checked;
        agreeCheck2.checked = isChecked;
        agreeCheck3.checked = isChecked;
      });


      function checkAgreement(form, event) {
          const isChecked2 = agreeCheck2.checked;
          const isChecked3 = agreeCheck3.checked;

          if (isChecked2 && isChecked3) {
        	document.forms['form'].submit();
            alert("리뷰가 성공적으로 등록되었습니다.");
            
          } else {
            alert("모든 필수 항목에 동의해야 리뷰를 등록할 수 있습니다.");
            event.preventDefault();
            return false;
          }
        }
       
      function previewImage() {
        const imageInput = document.getElementById("imageInput");
        const imagePreview = document.getElementById("imagePreview");

        if (imageInput.files && imageInput.files[0]) {
          const reader = new FileReader();

          reader.onload = (e) => {
            imagePreview.innerHTML = `<img src="${e.target.result}" alt="사진 미리보기" style="max-width: 100%; max-height: 100%;" />`;
          };

          reader.readAsDataURL(imageInput.files[0]);
        }
      }