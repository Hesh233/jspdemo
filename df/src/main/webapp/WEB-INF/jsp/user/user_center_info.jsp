<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
 <%@ include file="../header.jsp" %>
</head>
<body>
 <%@ include file="../bhead.jsp" %>
	<div class="main_con clearfix">
		<div class="left_menu_con clearfix">
			<h3>用户中心</h3>
			<ul>
				<li><a href="user_center_info" class="active">· 个人信息</a></li>
				<li><a href="user_center_order">· 全部订单</a></li>
				<li><a href="user_center_site">· 收货地址</a></li>
			</ul>
		</div>
		<div class="right_content clearfix">
				<div class="info_con clearfix">
				<h3 class="common_title2">基本信息</h3>
						<ul class="user_info_list">
							<li><span>用户名：</span>${uname}</li>
							<li><span>联系方式：</span>${Uphone}</li>
							<li><span>联系地址：</span>${Uaddress}</li>			
						</ul>
				</div>
				
				<h3 class="common_title2">最近浏览</h3>
				<div class="has_view_list">
				<ul class="goods_type_list clearfix">
					<c:if test="${not empty viewg}">
						<c:forEach items="${viewg}" var="item" varStatus="status">
							<li><a href="${pageContext.request.contextPath}/goods/${item.getId()}"><img
									src="${pageContext.request.contextPath}${item.getGpic()}"></a>
								<h4>
									<a href="${pageContext.request.contextPath}/goods/${item.getId()}">${item.getGtitle()}</a>
								</h4>
								<div class="operate">
									<span class="prize">￥${item.getGprice()}</span> <span class="unit">${item.getGprice()}/500g</span>
									
								</div></li>
						</c:forEach>
					</c:if>
				</ul>
			</div>
		</div>
	</div>
 <%@ include file="../footer.jsp" %>
</body>
</html>