// 내작업
$(document).ready(function() {
    $('.modalButton').on('click', insertTask);
    $('#btnTaskMake').click(createTask);
});

// 작업추가 버튼 클릭시 액션 : 담당자를 받아옴 (현재 로그인 유저)
function insertTask() {
    console.log('insertTask');

    let tcharge = $('#tcharge');
    // console.log(charger.html());

    $.ajax({
        url: 'insertCharger' ,
        type: 'post' ,
        success: function (name) {
            console.log('담당자 이름: ', name);
            tcharge.html(name);

        } ,
        error: function(e) {
            JSON.stringify(e);
        }
    });
}

// 모달창 작업 생성 버튼 액션
function createTask() {

    if( !confirm('작업을 생성하시겠습니까?') ) {
        return;
    }

    // 날짜 유효성 체크
    if(checkDate() !== 1) {
        return;
    }

    let insertTaskByForm = $('#insertTaskByForm').serialize();
    console.log('폼내용:', insertTaskByForm);

    $.ajax({
        url: 'insertTask',
        type: 'post',
        date: insertTaskByForm ,
        success: function() {

        } ,
        error: function(e) {
            JSON.stringify(e);
        }
    });

}

// 작업 생성 모달창안의 날짜 체크
function checkDate() {
    let result = 1;

    let startDate = $('#starttime').val();              // 시작 날짜
    let endDate = $('#endtime').val();                  // 종료 날짜

    console.log('시작 날짜: ', startDate);

    if( startDate !== '' ) {

        // 종료 날짜가 시작날짜보다 전이면 반환
        if ( endDate !== '' && endDate < startDate ) {
            alert('종료일은 시작일의 다음날로 설정해주세요');
            $('#endtime').css('color', '#fb8500').select();
            result = 0;
        }

        console.log('날짜 유효성 반환값 0/1: ', result);
        return result;
    }

}