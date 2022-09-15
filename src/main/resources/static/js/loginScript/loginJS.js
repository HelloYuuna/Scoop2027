$(document).ready(function () {
    $('#email').on('blur', idChk);
});

/*
 * 로그인 유효성 체크 *
 * 아이디 & 비밀번호 required 속성부여
 * 아이디 이메일 형식 확인
 * 비밀번호 형식 확인
 * 비밀번호는 8~ 10자리
 * sign in 누를때 ajax를 통해 동일한 이메일 주소가 있는지 확인
 */
function loginChk() {
    idChk();                                 // 아이디 중복체크
    return false;
}

function idChk() {
    let signupInfo = $('#signupForm');
    let email = $('#email').val();
    let password = $('#password').val();

    $.ajax({
        url:'idChk',
        type:'post',
        data: {email:email},
        success: function() {

        },
        error: function (e) {
            // 아이디가 중복일 경우 전체 내용 리셋 & 경고창
            console.log('확인실패');
            JSON.stringify(e);
        }
    });
}