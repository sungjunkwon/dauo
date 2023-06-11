<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="t" %>

<t:template title="daou">
    <jsp:attribute name="javascriptSrc">
        <script src="/js/admin/admin.js"></script>
    </jsp:attribute>
    <jsp:body>
       <div class="container">
           <h3>관리자 로그인</h3>
           <div class="form-border">
               <form data-parsley-validate>
                   <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

                    <div class="form-outline mb-4">
                       <label class="control-label" for="inputId">아이디</label>
                       <input class="form-control" placeholder="아이디" id="inputId" name="adminId" type="text" autofocus>
                    </div>

                    <!-- Password input -->
                    <div class="form-outline mb-4">
                       <label class="control-label" for="inputPw">비밀번호</label>
                       <input class="form-control" placeholder="비밀번호" id="inputPw" name="adminPw" type="password" value="">
                    </div>

                    <!-- Submit button -->
                    <div class="form-outline text-center">
                       <button type="button" id="login" class="btn btn-primary btn-block mb-4">로그인</button>
                    </div>
               </form>
           </div>
       </div>
    </jsp:body>
</t:template>
