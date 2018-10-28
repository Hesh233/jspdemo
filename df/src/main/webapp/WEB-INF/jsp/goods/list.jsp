<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page language="java" import="java.util.*"%>
<%@ page language="java" import="com.ssm.domain.GoodsInfo"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../header.jsp"%>
<%@ include file="../bhead.jsp"%>
<script type="text/javascript">
$(function(){
	var ajax =1;           //防止重复提交判断标志位
$(".add_goods").click(function(){
	count = $(".num_show").val();
	url = "${pageContext.request.contextPath}/cart/add" 
	
	if (ajax==1){
	ajax=0;	
	$.ajax({ 
		type:'get', 
		url:url, 
		data:{a:this.id,b:1}, 
		cache:false, 
		dataType:'json', 
		success:function(data){
			if(data.count==0){
				alert("请先登录");
			}
		 $("#show_count").text(data.count);
		} ,
		complete:function(count){ 
			ajax=1;
		} 
		}); 
	}
	});
});
</script>
</head>
<body>
	<div class="navbar_con">
		<div class="navbar clearfix">
			<div class="subnav_con fl">
				<h1>全部商品分类</h1>
				<span></span>
<%@ include file="./subnav.jsp"%>
			</div>
<%@ include file="./navlist.jsp"%>
		</div>
	</div>

 <%@ include file="./breadcrumb.jsp" %>

	<div class="main_wrap clearfix">
		<div class="l_wrap fl clearfix">
			<%@ include file="./new_goods.jsp"%>
		</div>

		<div class="r_wrap fr clearfix">
			<div class="sort_bar">
				<c:if test="${regex3==1}">
					<a href="${pageContext.request.contextPath}/goods/list${regex1}_1_1" class="active">默认</a>
					<a href="${pageContext.request.contextPath}/goods/list${regex1}_1_2">价格</a>
					<a href="${pageContext.request.contextPath}/goods/list${regex1}_1_3">人气</a> 
				</c:if>
				<c:if test="${regex3==2}">
					<a href="${pageContext.request.contextPath}/goods/list${regex1}_1_1">默认</a>
					<a href="${pageContext.request.contextPath}/goods/list${regex1}_1_2" class="active">价格</a>
					<a href="${pageContext.request.contextPath}/goods/list${regex1}_1_3">人气</a> 
				</c:if>
				<c:if test="${regex3==3}">
					<a href="${pageContext.request.contextPath}/goods/list${regex1}_1_1">默认</a>
					<a href="${pageContext.request.contextPath}/goods/list${regex1}_1_2">价格</a>
					<a href="${pageContext.request.contextPath}/goods/list${regex1}_1_3" class="active">人气</a> 
				</c:if>
			</div>

			<ul class="goods_type_list clearfix">
			<c:if test="${not empty listg}">
				<c:forEach items="${listg}" var="item" varStatus="status">
					<li><a href="${item.getId()}"><img
							src="${pageContext.request.contextPath}${item.getGpic()}"></a>
						<h4>
							<a href="${item.getGprice()}">${item.getGtitle()}</a>
						</h4>
						<div class="operate">
							<span class="prize">￥${item.getGprice()}</span> <span class="unit">
								${item.getGprice()}￥/500g</span> <a href="javascript:;"
								id="${item.getId()}" class="add_goods" title="加入购物车"></a>
						</div></li>
				</c:forEach>
</c:if>
			</ul>
			<c:if test="${maxpage>=2}"><!-- 搜索分页得再写一遍因为url不一样 -->
				<div class="pagenation">
					<c:if test="${page!=1}">
						<a href="${pageContext.request.contextPath}/goods/list${regex1}_${page-1}_${regex3}">上一页</a>
					</c:if>

					<c:forEach var="i" begin="1" end="${maxpage}" step="1">
						<c:if test="${page==i}">
							<a href="${pageContext.request.contextPath}/goods/list${regex1}_${i}_${regex3}" class="active">${i}</a>
						</c:if>
						<c:if test="${page!=i}">
							<a href="${pageContext.request.contextPath}/goods/list${regex1}_${i}_${regex3}">${i}</a>
						</c:if>
					</c:forEach>
					<c:if test="${page!=maxpage}">
						<a href="${pageContext.request.contextPath}/goods/list${regex1}_${page+1}_${regex3}">下一页</a>
					</c:if>
				</div>
			</c:if>
		</div>
	</div>
	<%@ include file="../footer.jsp"%>
</body>
</html>