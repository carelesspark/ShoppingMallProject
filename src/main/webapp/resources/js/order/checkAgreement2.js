function checkAgreement2() {
 
    var changeAgreementDiv = document.getElementById('refund_agreement');


    var checkboxes = changeAgreementDiv.querySelectorAll('input[type="checkbox"]');

  
    var allChecked = true;
    checkboxes.forEach(function (checkbox) {
        if (!checkbox.checked) {
            allChecked = false;
        }
    });


    if (allChecked) {

        document.forms['form'].submit();
    } else {
        alert('모든 약관에 동의해야 합니다.');
    }
}