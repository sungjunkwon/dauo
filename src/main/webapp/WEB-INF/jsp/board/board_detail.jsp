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
           <h3>교육 신청 조회</h3>
           <div class="form-border">
               <div class="form-outline mb-4">
                   <label class="control-label" for="boardWriter">신청자</label>
                   <input type="text"  class="form-control" id="boardWriter" name="boardWriter" value="${result.boardWriter}" readonly>
               </div>

               <div class="form-outline mb-4">
                   <label class="col-sm-4 control-label" for="boardPhone">전화번호</label>
                   <input type="number"  class="form-control" id="boardPhone" name="boardPhone" value="${result.boardPhone}" readonly>
               </div>

               <div class="form-outline mb-4">
                   <label class="col-sm-4 control-label" for="boradTitle">과목</label>
                   <input type="text" class="form-control" id="boardTitle" name="boardTitle" value="${result.boardTitle}" readonly>
               </div>

               <div class="form-outline mb-4">
                   <label class="col-sm-4 control-label" for="boradEtc">비고</label>
                   <input type="text"  class="form-control" id="boardEtc" name="boardEtc" value="${result.boardEtc}" readonly>
               </div>

               <div class="form-outline mb-4">
                  <label class="col-sm-4 control-label" for="regDt">등록일</label>
                  <input type="text"  class="form-control" id="regDt" name="regDt" value="${result.regDt}" readonly>
               </div>
               <div class="form-outline mb-4 text-center">
                   <input type="button" class="btn btn-gray pull-right" id="btnCancel"  value="닫기"/>
               </div>
           </div>
       </div>
    </jsp:body>
</t:template>
