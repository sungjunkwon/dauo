// 저장 클릭시
$('#btnInsert').unbind().bind().on('click', function () {
    var param = {};

    param.boardWriter   = $('#boardWriter').val().trim();
    param.boardPhone    = $('#boardPhone').val();
    param.boardTitle    = $('#boardTitle').val().trim();
    param.boardEtc      = $('#boardEtc').val().trim();
    param.reg_dt        = $('#boardEtc').val().trim();

    if ($('#signupForm').parsley().validate()) {
        var isConfirm = confirm('등록하시겠습니까?');

        console.log(JSON.stringify(param));

        if (isConfirm) {
             $.ajax({
                type : 'POST',
                url  : '/board/insert',
                data : JSON.stringify(param),
                contentType : "application/json; charset=utf-8",
                success : function(result) {
                    alert("등록되었습니다.");
                    window.location.href = '/';
                },
                error : function(request, status, error) {
                    console.log(error)
                }
             })
        }

    } else {
        $('#signupForm').parsley();
    }
    return false;
});

$('#btnCancel').on('click', function () {
    window.history.back();
});

function goToDetail(id){
    location.href= '/board/detail/'+ id;
}

function searchFilter() {
     $('#type').val(2);
     $('#searchText').val($("#searchInput").val());
}


// 검색 버튼 클릭시
$("#searchResult").on("click",function() {
    searchFilter();
    goToPage(0);
});

// 검색 엔터 누를시
$('#searchInput').on('keypress',function (e) {
   if(e.which == 13){
       searchFilter();
       goToPage(0);
   }
});

if($('#type').val() != ""){

    $('select[name=selectType]').val($('#type').val());
    $('select[name=selectType]').parent().find(".select2-selection__rendered").empty().append($('#type').val());
}

if($('#searchText').val().length > 0){

    $('#searchInput, #searchText').val(getParameterByName('searchText'));
    $('#searchInput').prop('disabled', false);
}

if($('#type').val() != ''){
    $('select[name=selectType]').val($('#type').val());
    $('select[name=selectType]').parent().find('.select2-selection__rendered').empty().append($('select[name=selectType]').find('option:selected').text());
}

function goToPage(pageNo) {
    $("input[name=page]").val(pageNo);
    searchFilter();
    $("#paginationForm").submit();
}
