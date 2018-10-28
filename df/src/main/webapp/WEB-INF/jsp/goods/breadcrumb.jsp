<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
	<div class="breadcrumb">
		<a href="${pageContext.request.contextPath}/goods/index">全部分类</a>
		
		<a href="list${goodsinf.getGtypeId()}_1_1"><span>>${gtitle}</span></a>
		
		<c:if test="${not empty isdetail}">
		<span>></span>
		<a href="#">商品详情</a>
		</c:if>
	</div>