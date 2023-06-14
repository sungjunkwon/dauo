// 저장 클릭시
$('#login').unbind().bind().on('click', function () {
    var param = {};

    param.adminId   = $('#inputId').val().trim();
    param.adminPw   = $('#inputPw').val();

    console.log(param);

     $.ajax({
        type : 'POST',
        url  : '/signin',
        data : JSON.stringify(param),
        contentType : "application/json; charset=utf-8",
        success : function(result) {
            console.log(result);

            if(result.code == '0000'){
                window.location.href = '/board/list';
            }else{
                alert(result.msg);
            }
        },
        error : function(request, status, error) {
            alert("해당 아이디가 존재하지 않거나 비밀번호가 틀립니다.")
            console.log(error)
            window.location.href = '/signin';
        }
     })
});

$('#btnCancel').on('click', function (e) {
    window.location.href = '/';
});

$('input').on('keypress',function (e) {
   if(e.which == 13){
       $('#login').trigger('click');
   }
});


// 저장 클릭시
$('#btnSuperSignup').unbind().bind().on('click', function () {
    var param = {};

    param.adminId   = $('#inputId').val().trim();
    param.adminPw   = $('#inputPw').val();
    param.adminNm   = $('#inputName').val();
    param.adminPhone  = $('#inputPhoneNum').val();

    console.log(param);

     if ($('#superSignupForm').parsley().validate()) {
         var isConfirm = confirm('등록하시겠습니까?');

         console.log(JSON.stringify(param));

         if (isConfirm) {
              $.ajax({
                 type : 'POST',
                 url  : '/signup-super',
                 data : JSON.stringify(param),
                 contentType : "application/json; charset=utf-8",
                 success : function(result) {
                     if(result.code == '0000'){
                         alert("가입이 완료되었습니다.");
                         window.location.href = '/';
                     }else{
                         alert(result.msg);
                     }
                 },
                 error : function(request, status, error) {
                     console.log(error)
                 }
              })
         }
     } else {
         $('#signupForm').parsley();
     }
});
