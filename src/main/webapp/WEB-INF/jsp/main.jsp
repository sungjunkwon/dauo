<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="t" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<t:template title="">
    <jsp:attribute name="javascriptSrc">
        <script src="/js/main.js"></script>
    </jsp:attribute>
    <jsp:body>
       <div class="container">
           <div class="col-12">
             <img src="/img/main.png" id="main" width="636" height="901" usemap="#mainMap"/>
             <map name="mainMap">
                <area shape="rect" title="교육신청" coords="238,302,410,370" href="/board/insert">
             </map>
           </div>
       </div>
    </jsp:body>
</t:template>