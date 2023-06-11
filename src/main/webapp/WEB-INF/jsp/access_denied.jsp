<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="t" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<t:template title="">
    <jsp:attribute name="javascriptSrc">
        <%--<script src="/js/custom.js"></script>--%>
        <script>
            $(document).ready(function () {
               if($('#auth').val() === '1'){
                   $('table tbody tr:first-child').css('border','2px solid #9f191f');
               } else if($('#auth').val() === '2'){
                   $('table tbody tr:nth-child(2)').css('border','2px solid #9f191f');
               } else {
                   $('table tbody tr:nth-child(3)').css('border','2px solid #9f191f');
               }
            });
        </script>
    </jsp:attribute>
    <jsp:body>
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <h2 style="color: #9f191f; font-size: 23px; font-weight: 800;">[ ACCESS DENIED ] <span style="font-size: 17px; font-weight: 600">접근 불가</span></h2>
                    <input type="hidden" id="auth" value="${adminAuth}">
                </div>
            </div>
            <div class="row">
                <div class="col-sm-12 col-md-12">
                    <div class="page-title">
                        <div class="title-left">
                            <h3>${adminName} 님의 권한은 ${adminAuthName}입니다.
                                <small><b>해당 페이지의 접근 권한이 없습니다.</b></small>
                            </h3>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-md-12">
                    <div class="table-responsive">
                        <table class="table table-list table-custom table-record" style="overflow-x: hidden;">
                            <thead class="th-text-center" >
                            <tr>
                                <th>Auth NO</th>
                                <th>Auth Name</th>
                                <th>ETC</th>
                            </tr>
                            </thead>
                            <tbody class="td-text-center" style="border: none;">
                            <tr>
                                <td>1</td>
                                <td>Supervisor</td>
                                <td>최고 권한</td>
                            </tr>
                            <tr>
                                <td>2</td>
                                <td>Manager</td>
                                <td>등록,조회,수정,삭제</td>
                            </tr>
                            <tr>
                                <td>3</td>
                                <td>User</td>
                                <td>조회</td>
                            </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </jsp:body>
</t:template>