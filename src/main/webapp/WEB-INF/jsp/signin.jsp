<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="t" %>

<t:template title="daou">
    <jsp:attribute name="javascriptSrc">
        <!--<script src="/js/admin/admin.js"></script>-->
    </jsp:attribute>
    <jsp:body>
       <div class="container">
           <h3>관리자 로그인</h3>
           <div class="form-border">
               <form method="POST" action="/signin" data-parsley-validate>
               <!--<form data-parsley-validate>-->
                   <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

                    <div class="form-outline mb-4">
                       <label class="control-label" for="inputId">아이디</label>
                       <input class="form-control" id="inputId" name="adminId" type="text" autofocus placeholder="아이디를 입력하세요" data-parsley-required="true" data-parsley-trigger="change"
                        data-parsley-minlength="5" data-parsley-type="email">
                    </div>

                    <!-- Password input -->
                    <div class="form-outline mb-4">
                       <label class="control-label" for="inputPw">비밀번호</label>
                       <input class="form-control" placeholder="비밀번호를 입력하세요" id="inputPw" name="adminPw" type="password" value="" data-parsley-required="true">
                    </div>

                    <!-- Submit button -->
                    <div class="form-outline text-center">
                      <button type="submit" id="login" class="btn btn-kiwoom btn-block mb-4">로그인</button>
                       <!--<button type="button" id="login" class="btn btn-kiwoom btn-block mb-4">로그인</button>-->
                    </div>
               </form>
           </div>
       </div>
    </jsp:body>
</t:template>
