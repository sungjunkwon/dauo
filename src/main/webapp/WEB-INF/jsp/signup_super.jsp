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
        <h3>관리자 회원 가입</h3>
        <div class="form-border">
            <form id="superSignupForm" data-parsley-validate>
              <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

              <div class="form-outline mb-4">
                  <label class="col-sm-4 control-label" for="inputId">아이디</label>
                  <input class="form-control" id="inputId" name="adminId" placeholder="아이디를 입력하세요" data-parsley-required="true" data-parsley-trigger="change"
                         data-parsley-minlength="5" data-parsley-type="email">
              </div>

              <div class="form-outline mb-4">
                  <label class="col-sm-4 control-label" for="inputPw">비밀번호</label>
                  <input type="password" class="form-control" id="inputPw" name="adminPw" placeholder="비밀번호를 입력하세요 (영문+숫자 6자리 이상)" data-parsley-required="true"
                         data-parsley-trigger="change" data-parsley-minlength="6" data-parsley-pattern="/^.*(?=.{6,20})(?=.*[0-9])(?=.*[a-zA-Z]).*$/">
              </div>

              <div class="form-outline mb-4">
                  <label class="col-sm-4 control-label" for="inputConfirm">비밀번호 확인</label>
                  <input type="password" class="form-control" id="inputConfirm" placeholder="비밀번호를 다시 한번 입력하세요" data-parsley-required="true" data-parsley-trigger="change"
                         data-parsley-minlength="6" data-parsley-equalto="#inputPw" data-parsley-pattern="/^.*(?=.{6,20})(?=.*[0-9])(?=.*[a-zA-Z]).*$/">
              </div>

              <div class="form-outline mb-4">
                  <label class="control-label" for="inputName">이름</label>
                  <input class="form-control" id="inputName" name="adminNm" placeholder="이름을 입력하세요" data-parsley-required="true" data-parsley-trigger="change" data-parsley-minlength="2">
              </div>

              <div class="form-outline mb-4">
                  <label class="col-sm-4 control-label" for="inputPhoneNum">전화번호</label>
                  <input class="form-control" id="inputPhoneNum" name="adminPhone" placeholder="전화번호를 입력하세요" data-parsley-required="true" data-parsley-trigger="change" data-parsley-type="digits" data-parsley-length="[10, 11]">
              </div>

              <!-- Submit button -->
              <div class="form-outline text-center">
                  <input type="button" class="btn btn-kiwoom pull-right" id="btnSuperSignup" value="가입"/>
                  <input type="button" class="btn btn-gray pull-right" id="btnCancel"  value="취소"/>
              </div>
            </form>
        </div>
      </div>
    </jsp:body>
</t:template>
