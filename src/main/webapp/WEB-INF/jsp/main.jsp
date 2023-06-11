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
             <img src="/img/main.jpg" id="main" width="1296" height="914" usemap="#mainMap"/>
             <map name="mainMap">
                 <area shape="rect" title="교육신청" coords="82,607,436,701" href="/board/insert">
                 <area shape="rect" title="신청조회" coords="583,606,937,701" href="/board/list">
             </map>

              <img src="/img/m_main.jpg" id="m_main" width="600" height="962" usemap="#m_mainMap"/>
              <map name="m_mainMap">
                  <area shape="rect" title="교육신청" coords="46,658,335,731" href="/board/insert">
                  <area shape="rect" title="신청조회" coords="47,770,337,844" href="/board/list">
              </map>
           </div>
       </div>
    </jsp:body>
</t:template>