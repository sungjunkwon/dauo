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
           <h3>증권 교육 신청</h3>
           <div class="row">
                <div class="input-group">
                    <input type="text" class="form-control" id="searchInput" placeholder="작성자">
                    <span class="input-group-btn">
                        <button type="button" class="btn btn-primary" id="searchResult">검색</button>
                    </span>
                </div>
           </div>
           <div class="table-responsive py-5">
               <table class="table table‑bordered table-hover">
                   <thead class="thead-dark th-text-center">
                   <tr>
                       <th width="10%">no</th>
                       <th width="15%">작성자</th>
                       <th width="20%">전화번호</th>
                       <th width="15%">교육명</th>
                       <th width="20%">비고</th>
                       <th width="20%">등록일시</th>
                   </tr>
                   </thead>
                   <tbody class="td-text-center">
                   <c:forEach var="item" items="${result.pageResult.content}" varStatus="status">
                       <tr name="list" onclick="goToDetail(${item.boardNo});">
                           <td width="10%" name="playerId">${item.boardNo}</td>
                           <td width="15%">${item.boardWriter}</td>
                           <td width="20%">${item.boardPhone}</td>
                           <td width="15%">${item.boardTitle}</td>
                           <td width="20%">${item.boardEtc}</td>
                           <td width="20%">${item.regDt}</td>
                       </tr>
                   </c:forEach>
                   </tbody>
               </table>
           </div>
            <form action="/board/list" method="get" id="paginationForm">
                <input type="hidden" id="searchText" name="searchText" value="${result.searchText}"/>
                <input type="hidden" id="type" name="type" value="${result.type}"/>
                <c:if test="${result.pageResult.totalPages > 0}">
                    <t:pagination></t:pagination>
                </c:if>
            </form>
       </div>
    </jsp:body>
</t:template>
