// 저장 클릭시
$('#login').unbind().bind().on('click', function () {
    var param = {};

    param.adminId   = $('#inputId').val().trim();
    param.adminPw   = $('#inputPw').val();

    console.log(param);

     $.ajax({
        type : 'POST',
        url  : '/checkAdmin',
        data : JSON.stringify(param),
        contentType : "application/json; charset=utf-8",
        success : function(result) {
            if(result.code == '0000'){
                window.location.href = '/board/list';
            }else{
                alert(result.msg);
            }
        },
        error : function(request, status, error) {
            console.log(error)
        }
     })
});

$('input').on('keypress',function (e) {
   if(e.which == 13){
       $('#login').trigger('click');
   }
});