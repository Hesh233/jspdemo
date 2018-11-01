<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page language="java" import="java.util.*" %>
<%@ page language="java" import="com.ssm.domain.GoodsInfo" %>
<%@ page language="java" import="com.ssm.domain.CartInfo" %>
<!DOCTYPE html>
<html>
<head>
 <%@ include file="../header.jsp" %>
</head>
<body>
 <%@ include file="../bhead.jsp" %>



	<script>
	$(function(){
		for (var i=0;i<parseInt("${count}")+1;i++){
			price = $("#a"+i).prev().prev().text();
			count = $("#a"+i).prev().text();
			sum = price * count;
			$("#a"+i).text(sum.toFixed(2)+'元')	;
			//console.log(i);
		}
	});
	</script>
	<h3 class="common_title">确认收货地址</h3>

	<div class="common_list_con clearfix">
		<dl>
		<c:if test="${not empty uphone && not empty Uadress && not empty Ushou }">
			<dt>寄送到：</dt>
			<dd><input type="radio" name="" checked="">${Uadress} （${Ushou} 收） ${Uphone}</dd>
			</c:if>
			<c:if test="${empty uphone}">
			<dt>请完善你的收货信息</dt>
			<dd></dd>
			</c:if>
		</dl>
		<a href="${pageContext.request.contextPath}/user/user_center_site" class="edit_site">编辑收货地址</a>

	</div>
	
	<h3 class="common_title">支付方式</h3>	
	<div class="common_list_con clearfix">
		<div class="pay_style_con clearfix">
			<input type="radio" name="pay_style" checked>
			<label class="cash">货到付款</label>
			<input type="radio" name="pay_style">
			<label class="weixin">微信支付</label>
			<input type="radio" name="pay_style">
			<label class="zhifubao"></label>
			<input type="radio" name="pay_style">
			<label class="bank">银行卡支付</label>
		</div>
	</div>

	<h3 class="common_title">商品列表</h3>
	
	<div class="common_list_con clearfix">
		<ul class="goods_list_th clearfix">
			<li class="col01">商品名称</li>
			<li class="col02">商品单位</li>
			<li class="col03">商品价格</li>
			<li class="col04">数量</li>
			<li class="col05">小计</li>		
		</ul>
		<c:forEach items="${goodslist}" var="item" varStatus="status">
			<ul class="goods_list_td clearfix">
				<li class="col01">${status.count }</li>
				<li class="col02"><img src="${pageContext.request.contextPath}${item.getGpic()}"></li>
				<li class="col03">${item.getGtitle()}</li>
				<li class="col04">${item.getGunit()}</li>
				<li class="col05">${item.getGprice()}</li>
				<li class="col06">${cartlist.get(status.index).getCount()}</li>
				<li class="col07" id="a${status.count}">25.80元</li>
			</ul>
		</c:forEach>

	</div>

	<h3 class="common_title">总金额结算</h3>

	<div class="common_list_con clearfix">
		<div class="settle_con">
			<div class="total_goods_count">共<em>${count}</em>件商品，总金额<b>${sum}元</b></div>
			<div class="transit">运费：<b>10元</b></div>
			<div class="total_pay">实付款：<b>${sums}元</b></div>
		</div>
	</div>

	<div class="order_submit clearfix">
		<a href="javascript:;" id="order_btn">提交订单</a>
	</div>	



	<div class="popup_con">
		<div class="popup">
			<p>订单提交成功！</p>
		</div>
		
		<div class="mask"></div>
	</div>

	<script type="text/javascript">
		$('#order_btn').click(function() {
			localStorage.setItem('order_finish',2);

			$('.popup_con').fadeIn('fast', function() {

				setTimeout(function(){
					$('.popup_con').fadeOut('fast',function(){
						window.location.href = 'index.html';
					});	
				},3000)
				
			});
		});
	</script>
	 	 <%@ include file="../footer.jsp" %>
  </body>
 </html>