<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="t" %>

<t:template title="daou">
    <jsp:attribute name="javascriptSrc">
        <script src="/js/board/board.js"></script>
    </jsp:attribute>
    <jsp:body>
       <div class="container">
           <div class="col-12">
                <img src="/img/banner.jpg" class="img-fluid" id="banner"/>
                <img src="/img/m_banner.jpg" class="img-fluid" id="m_banner"/>
           </div>
           <h3>증권 교육 신청</h3>
           <div class="form-border">
               <form class="form-horizontal" id="signupForm" action="/signup-super/insert" data-parsley-validate>
                   <!-- Email input -->
                   <div class="form-outline mb-4">
                       <label class="control-label" for="boardWriter">신청자</label>
                       <input type="text" class="form-control" id="boardWriter" name="boardWriter" placeholder="이름을 입력하세요" data-parsley-required="true" data-parsley-trigger="change" data-parsley-minlength="2">
                   </div>

                   <div class="form-outline mb-4">
                       <label class="col-sm-4 control-label" for="boardPhone">전화번호</label>
                       <input type="number" class="form-control" id="boardPhone" name="boardPhone" placeholder="전화번호를 입력하세요" data-parsley-required="true" data-parsley-trigger="change" data-parsley-type="digits" data-parsley-length="[10, 11]">
                   </div>

                   <div class="form-outline mb-4">
                       <label class="col-sm-4 control-label" for="boradTitle">과목</label>
                       <input type="text" class="form-control" id="boardTitle" name="boardTitle" placeholder="과목" value="증권 교육">
                   </div>

                   <div class="form-outline mb-4">
                       <label class="col-sm-4 control-label" for="boradEtc">비고</label>
                       <input type="text" class="form-control" id="boardEtc" name="boardEtc" placeholder="비고">
                   </div>

                   <!-- Submit button -->
                   <div class="form-outline mb-4 text-center">
                       <input type="button" class="btn btn-primary pull-right" id="btnInsert" value="등록"/>
                       <input type="button" class="btn btn-danger pull-right" id="btnCancel"  value="취소"/>
                   </div>
               </form>
           </div>
       </div>
    </jsp:body>
</t:template>
