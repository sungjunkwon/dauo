<%@tag description="Pagenation template" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:set var="blockSize" value="10"/>
<fmt:parseNumber var="firstBlock" integerOnly="true" type="number" value="${(result.pageResult.number / blockSize) / blockSize}" />
<fmt:parseNumber var="lastBlock" integerOnly="true" type="number" value="${result.pageResult.totalPages - 1}" />
<fmt:parseNumber var="curBlock" integerOnly="true" type="number" value="${result.pageResult.number / blockSize}" />
<fmt:parseNumber var="start" integerOnly="true" type="number" value="${curBlock * blockSize}"/>
<fmt:parseNumber var="end" integerOnly="true" type="number" value="${start + blockSize - 1}"/>
<c:set var="isFirst" value="false"/>
<c:set var="isLast" value="false"/>
<c:if test="${curBlock == 0}">
    <c:set var="isFirst" value="true"/>
</c:if>
<c:if test="${result.pageResult.totalPages <= end + 1}">
    <c:set var="isLast" value="true"/>
    <fmt:parseNumber var="end" integerOnly="true" type="number" value="${result.pageResult.totalPages - 1}"/>
</c:if>
<input type="hidden" name="page"/>
<div class="row">
    <div class="col-md-3">
        <h5 style="color: #2A3F54; font-weight: 700;">Total : ${total}</h5>
    </div>
    <div class="col-md-6 text-center">
        <ul class="pagination justify-content-center"">
            <c:if test="${isFirst == false}">
                <c:if test="${start > 90}">
                    <li class="page-item previous">
                        <a class="page-link" href="javascript:goToPage(${start - 100})"><i class="fa fa-angle-double-left"></i></a>
                    </li>
                </c:if>
                <li class="page-item previous">
                    <a class="page-link" href="javascript:goToPage(${start - 10})"><i class="fa fa-angle-left"></i></a>
                </li>
                <li class="page-item previous">
                    <a href="javascript:goToPage(0)">1</a>
                </li>
                <li><span class='paginationEllipsis'>...</span></li>
            </c:if>
            <c:forEach begin="${start}" end="${end}" varStatus="loop">
                <c:choose>
                    <c:when test="${result.pageResult.number == loop.current}">
                        <li class="page-item active">
                            <a class="page-link" href="javascript:goToPage(${loop.current})">${loop.current + 1}</a>
                        </li>
                    </c:when>
                    <c:otherwise>
                        <li class="page-item">
                            <a class="page-link" href="javascript:goToPage(${loop.current})">${loop.current + 1}</a>
                        </li>
                    </c:otherwise>
                </c:choose>

            </c:forEach>
            <c:if test="${isLast == false}">
                <li><span class='paginationEllipsis'>...</span></li>
                <li class="page-item next">
                    <a href="javascript:goToPage(${lastBlock})">${lastBlock + 1}</a>
                </li>
                <li class="page-item next">
                    <a class="page-link" href="javascript:goToPage(${end + 1})"><i class="fa fa-angle-right"></i></a>
                </li>
                <li class="page-item next">
                    <a class="page-link" href="javascript:goToPage(${end + 91})"><i class="fa fa-angle-double-right"></i></a>
                </li>
            </c:if>
        </ul>
    </div>
</div>
