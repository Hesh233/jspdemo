<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page language="java" import="java.util.*"%>
<%@ page language="java" import="com.ssm.domain.GoodsInfo" %>
			<div class="new_goods">
				<h3>新品推荐</h3>
				<ul>
				<c:forEach items="${listn}" var="item" varStatus="status">
					<li><a href="${pageContext.request.contextPath}/goods/${item.getId()}"><img src="${pageContext.request.contextPath}${item.getGpic()}"></a>
						<h4>
							<a href="${pageContext.request.contextPath}/goods/${item.getId()}">${item.getGtitle()}</a>
						</h4>
						<div class="prize">￥${item.getGprice()}</div></li> 
						</c:forEach>
				</ul>
			</div>