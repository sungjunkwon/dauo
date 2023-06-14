<%@tag description="base Page template" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@attribute name="title" %>
<%@attribute name="openNavClass" %>
<%@attribute name="header" fragment="true" %>
<%@attribute name="footer" fragment="true" %>
<%@attribute name="javascriptSrc" fragment="true" %>
<!--<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">-->
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="utf-8">
    <meta http-equiv="Expires" content="-1">
    <meta http-equiv="Pragma" content="no-cache">
    <meta http-equiv="Cache-Control" content="no-cache">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <meta name="description" content="">
    <meta name="author" content="">

    <title>daou</title>

     <script inline="javascript" type="text/javascript" src="/vendor/jquery/jquery.min.js"></script>

     <script inline="javascript" type="text/javascript" src="/vendor/rwdimageMaps/jquery.rwdImageMaps.min.js"></script>
     <script inline="javascript" type="text/javascript" src="/vendor/bootstrap/js/bootstrap.min.js"></script>
     <script inline="javascript" type="text/javascript" src="/vendor/parsley/parsley.min.js"></script>
     <script inline="javascript" type="text/javascript" src="/vendor/parsley/i18n/ko.js"></script>
     <script inline="javascript" type="text/javascript" src="/vendor/select2/js/select2.min.js"></script>

     <!--Common CSS -->
     <link inline="css" href="/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet"/>
     <link inline="css" href="/vendor/select2/css/select2.min.css" rel="stylesheet"/>
     <link inline="css" href="/css/custom.css" rel="stylesheet"/>
</head>

<body>
    <div id="wrap">
        <div class="container">
            <header class="d-flex flex-wrap align-items-center justify-content-md-between py-3 mb-4 border-bottom">
                <div class="col-6 text-end">
                    <a href="/" class="d-flex align-items-center mb-2 mb-md-0 text-dark text-decoration-none">
                        <img src="/img/logo.png"/>
                    </a>
                </div>
                <div class="col-6 text-end">
                <c:choose>
                    <c:when test="${sessionScope.SESSION_INFO.id eq null}">
                        <a type="button" class="btn btn-kiwoom"  href="/signin">로그인</a>
                        <a type="button" class="btn btn-kiwoom-outline"  href="/signup-super">회원가입</a>
                    </c:when>
                    <c:otherwise>
                        <a type="button" class="btn btn-kiwoom"  href="/signout">로그아웃</a>
                    </c:otherwise>
                </c:choose>
                </div>
            </header>
        </div>

        <jsp:doBody/>
    </div>
    <footer>
        <div class="container">
            <div class="col-6 text-end">
                <!--
                <a href="/" class="d-flex align-items-center mb-2 mb-md-0 text-dark text-decoration-none">
                    <img src="/img/logo_footer.png"/>
                </a>
                -->
            </div>
        </div>
    </footer>
</body>
</div>

<jsp:invoke fragment="javascriptSrc"/>
<script type="text/javascript">
    $(document).ready(function(){
    });
</script>
</body>
</html>
