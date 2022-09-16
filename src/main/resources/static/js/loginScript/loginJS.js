$(document).ready(function () {
    $('#submit-btn').on('click', idChk);
});

// submit 버튼 비활성
function submitFalse() {
    return false;
}

function idChk() {
    let email = $('#email').val();
    console.log(email);

    $.ajax({
        url:'intsangbabo' ,
        type: 'post',
        data: { email:email } ,
        success: function() {
            console.log('왜 성공?');
            // console.log(result);

            // true: 아이디존재 -> 중복
            // if(result) {
            //     $('#idchk-msg').html('해당 아이디는 이미 존재합니다.')
            //         .select();
            // }

        } ,
        error: function(e) {
            alert('참고로 에러는 안떠요');
            JSON.stringify(e);
        }
    });
}