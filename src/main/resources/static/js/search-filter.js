if(document.location.href.indexOf('?') > -1){
    var originUrl = decodeURIComponent(document.location.href);
    var decodeUrl = originUrl.split("?");
    var searchUrl = decodeUrl[1].split('&');
    var array = [];
    var urlCheck = true;

    for(var i = 0; i < searchUrl.length; i++){
        array[i] = searchUrl[i].split('=');
    }

    for(var i = 0; i < array.length-1; i ++) {

        if(array[i][1] != $('#'+array[i][0]+'').val()){
            if(array[i][0] == 'start' || array[i][0] == 'end')
                array[i][1] = array[i][1].replace( /\+/gi, " ");

            urlCheck = false;
        }
    }
    if(urlCheck == false){
        for(var i = 0; i < array.length-1; i ++) {
            if(array[i][0] == 'start' || array[i][0] == 'end')
                $('#'+array[i][0]+'').val(moment(new Date(array[i][1])).format('YYYY-MM-DD'));
            else
                $('#'+array[i][0]+'').val(array[i][1]);

        }
    }
}
$('select[name=selectType]').select2({
    "minimumResultsForSearch": Infinity
}).on('change',function () {
    $('#searchInput').prop('disabled', false);
    if($('select[name=selectType]').val() == 1 || $('select[name=selectType]').val() == 2)
        $('#searchInput').attr('type', "number");
    else
        $('#searchInput').attr('type', "text");
});

$('select[name=selectCorporator], select[name=selectProgram]').select2();
$('select[name=selectStateCategory], select[name=selectCategory]').select2({
    "minimumResultsForSearch": Infinity
});

// 새로고침
$("#pageRefresh").on('click',function(){

    $('#searchText, #start, #end, #type, select').val("");
    $("select option:eq(0)").attr("selected", "selected");

    $("select").each(function(idx){
        $(this).parent().find(".select2-selection__rendered").empty().append($(this).find('option:selected').text());
    });

    $(":input[type=text], :input[type=number]").each(function(idx){
        $(this).val("");
    });

    $('#searchInput').prop("disabled", true);
});

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

// 시작일
$('#searchDtStart').datepicker({
    format: "yyyy-mm-dd",
    language:"ko",
    orientation: "bottom auto",
    autoclose: true,
    endDate : new Date(),
    clearBtn : true
}).on('changeDate', function () {
    $('#searchDtEnd').datepicker('setStartDate',$(this).val());
});

// 종료일
$('#searchDtEnd').datepicker({
    format: "yyyy-mm-dd",
    language:"ko",
    orientation: "bottom auto",
    autoclose: true,
    endDate : new Date(),
    clearBtn : true
}).on('changeDate',function () {
    $('#searchDtStart').datepicker('setEndDate', $(this).val());
});

function searchFilter() {

    if($('[name=selectType]').val() != null ) {
        if ($('#searchInput').val() == "") {
            $('#type').val('');
            $('#searchText').val('');
        } else {
            $('#type').val($('[name=selectType]').val());
            $('#searchText').val($("#searchInput").val());
        }
    }
}