<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page language="java" import="java.util.*" %>
<%@ page language="java" import="com.ssm.domain.GoodsInfo" %>
<!DOCTYPE html>
<html>
<head>
 <%@ include file="../header.jsp" %>
</head>
<body>
 <%@ include file="../bhead.jsp" %>
	<div class="navbar_con">
		<div class="navbar">
			<h1 class="fl">全部商品分类</h1>
<%@ include file="./navlist.jsp"%>
		</div>
	</div>

	<div class="center_con clearfix">
<%@ include file="./subnav.jsp"%>
		<div class="slide fl">
			<ul class="slide_pics">
				<li><img src="${pageContext.request.contextPath}/static/images/slide.jpg" alt="幻灯片"></li>
				<li><img src="${pageContext.request.contextPath}/static/images/slide02.jpg" alt="幻灯片"></li>
				<li><img src="${pageContext.request.contextPath}/static/images/slide03.jpg" alt="幻灯片"></li>
				<li><img src="${pageContext.request.contextPath}/static/images/slide04.jpg" alt="幻灯片"></li>
			</ul>
			<div class="prev"></div>
			<div class="next"></div>
			<ul class="points"></ul>
		</div>
		<div class="adv fl">
			<a href="#"><img src="${pageContext.request.contextPath}/static/images/adv01.jpg"></a>
			<a href="#"><img src="${pageContext.request.contextPath}/static/images/adv02.jpg"></a>
		</div>
	</div>

	<div class="list_model">
		<div class="list_title clearfix">
			<h3 class="fl" id="model01">新鲜水果</h3>
			<div class="subtitle fl">
				<span>|</span>
				<c:forEach items="${listn1}" var="item" varStatus="status">
				<a href="${item.getId()}">${item.getGtitle()}</a>
				</c:forEach>
			</div>
			<a href="/goods/list1_1_1" class="goods_more fr" id="fruit_more">查看更多 ></a>
		</div>

		<div class="goods_con clearfix">
		
			<div class="goods_banner fl"><img src="${pageContext.request.contextPath}/static/images/banner01.jpg"></div>
			<ul class="goods_list fl">
			<c:forEach items="${listg1}" var="item" varStatus="status">
				<li>
					<h4><a href="${item.getId()}">${item.getGtitle()}</a></h4>
					<a href="${item.getId()}"><img src="${pageContext.request.contextPath}${item.getGpic()}"></a>
					<div class="prize">¥ ${item.getGprice()}</div>
				</li>
		</c:forEach>	
			</ul>
		</div>
	</div>

	<div class="list_model">
		<div class="list_title clearfix">
			<h3 class="fl" id="model02">海鲜水产</h3>
			<div class="subtitle fl">
				<span>|</span>
				<c:forEach items="${listn2}" var="item" varStatus="status">
				<a href="${item.getId()}">${item.getGtitle()}</a>
				</c:forEach>			
			</div>
			<a href="/goods/list2_1_1" class="goods_more fr">查看更多 ></a>
		</div>

		<div class="goods_con clearfix">
			<div class="goods_banner fl"><img src="${pageContext.request.contextPath}/static/images/banner02.jpg"></div>
			<ul class="goods_list fl">
				<c:forEach items="${listg2}" var="item" varStatus="status">
				<li>
					<h4><a href="${item.getId()}">${item.getGtitle()}</a></h4>
					<a href="${item.getId()}"><img src="${pageContext.request.contextPath}${item.getGpic()}"></a>
					<div class="prize">¥ ${item.getGprice()}</div>
				</li>
				</c:forEach>
			</ul>
		</div>
	</div>

	<div class="list_model">
		<div class="list_title clearfix">
			<h3 class="fl" id="model03">猪牛羊肉</h3>
			<div class="subtitle fl">
				<span>|</span>
				<c:forEach items="${listn3}" var="item" varStatus="status">
				<a href="${item.getId()}">${item.getGtitle()}</a>
				</c:forEach>
			</div>
			<a href="/goods/list3_1_1" class="goods_more fr">查看更多 ></a>
		</div>

		<div class="goods_con clearfix">
			<div class="goods_banner fl"><img src="${pageContext.request.contextPath}/static/images/banner03.jpg"></div>
			<ul class="goods_list fl">
				<c:forEach items="${listg3}" var="item" varStatus="status">
				<li>
					<h4><a href="${item.getId()}">${item.getGtitle()}</a></h4>
					<a href="${item.getId()}"><img src="${pageContext.request.contextPath}${item.getGpic()}"></a>
					<div class="prize">¥ ${item.getGprice()}</div>
				</li>
</c:forEach>
			</ul>
		</div>
	</div>

	<div class="list_model">
		<div class="list_title clearfix">
			<h3 class="fl" id="model04">禽类蛋品</h3>
			<div class="subtitle fl">
				<span>|</span>
				<c:forEach items="${listn4}" var="item" varStatus="status">
				<a href="${item.getId()}">${item.getGtitle()}</a>
</c:forEach>
			</div>
			<a href="/goods/list4_1_1" class="goods_more fr">查看更多 ></a>
		</div>

		<div class="goods_con clearfix">
			<div class="goods_banner fl"><img src="${pageContext.request.contextPath}/static/images/banner04.jpg"></div>
			<ul class="goods_list fl">
				<c:forEach items="${listg4}" var="item" varStatus="status">
				<li>
					<h4><a href="${item.getId()}">${item.getGtitle()}</a></h4>
					<a href="${item.getId()}"><img src="${pageContext.request.contextPath}${item.getGpic()}"></a>
					<div class="prize">¥ ${item.getGprice()}</div>
				</li>
</c:forEach>
			</ul>
		</div>
	</div>

	<div class="list_model">
		<div class="list_title clearfix">
			<h3 class="fl" id="model05">新鲜蔬菜</h3>
			<div class="subtitle fl">
				<span>|</span>
				<c:forEach items="${listn5}" var="item" varStatus="status">
				<a href="${item.getId()}">${item.getGtitle()}</a>
</c:forEach>
			</div>
			<a href="/goods/list5_1_1" class="goods_more fr">查看更多 ></a>
		</div>

		<div class="goods_con clearfix">
			<div class="goods_banner fl"><img src="${pageContext.request.contextPath}/static/images/banner05.jpg"></div>
			<ul class="goods_list fl">
				<c:forEach items="${listg5}" var="item" varStatus="status">
				<li>
					<h4><a href="${item.getId()}">${item.getGtitle()}</a></h4>
					<a href="${item.getId()}"><img src="${pageContext.request.contextPath}${item.getGpic()}"></a>
					<div class="prize">¥ ${item.getGprice()}</div>
				</li>
</c:forEach>
			</ul>
		</div>
	</div>

	<div class="list_model">
		<div class="list_title clearfix">
			<h3 class="fl" id="model06">速冻食品</h3>
			<div class="subtitle fl">
				<span>|</span>
				<c:forEach items="${listn6}" var="item" varStatus="status">
				<a href="${item.getId()}">${item.getGtitle()}</a>
</c:forEach>
			</div>
			<a href="/goods/list6_1_1" class="goods_more fr">查看更多 ></a>
		</div>

		<div class="goods_con clearfix">
			<div class="goods_banner fl"><img src="${pageContext.request.contextPath}/static/images/banner06.jpg"></div>
			<ul class="goods_list fl">
				<c:forEach items="${listg6}" var="item" varStatus="status">
				<li>
					<h4><a href="${item.getId()}">${item.getGtitle()}</a></h4>
					<a href="${item.getId()}"><img src="${pageContext.request.contextPath}${item.getGpic()}"></a>
					<div class="prize">¥ ${item.getGprice()}</div>
				</li>
</c:forEach>
			</ul>
		</div>
	</div>
	 <%@ include file="../footer.jsp" %>
</body>
</html>