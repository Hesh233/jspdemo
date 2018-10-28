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
 <script>

$(function(){
	var $add_x = $('#add_cart').offset().top;
	var $add_y = $('#add_cart').offset().left;

	var $to_x = $('#show_count').offset().top;
	var $to_y = $('#show_count').offset().left;

	$(".add_jump").css({'left':$add_y+80,'top':$add_x+10,'display':'block'})
	$('#add_cart').click(function(){
		$(".add_jump").stop().animate({
			'left': $to_y+7,
			'top': $to_x+7},
			"fast", function() {
				$(".add_jump").fadeOut('fast',function(){
					$('#show_count').html(2);
					
				});

		});
	})
	function timeo(){}
	$('.num_show').blur(function(event) {
		num = $('.num_show').val();
		if (num > 99) {
			num = 99;
		} else if (num < 1) {
			num = 1;
		}
		$('.num_show').val(num);
		total = "${goodsinf.getGprice()}" * num;
		$('#_gtotal_').text(total.toFixed(2) + '元');
	});
	// 点击加入购物车
	
	var ajax =1;           //防止重复提交判断标志位
	$("#add_cart").click(function(){
		count = $(".num_show").val();
		url = "${pageContext.request.contextPath}"+"/cart/add" 
		
		if (ajax==1){
		ajax=0;	
		$.ajax({ 
			type:'get', 
			url:url, 
			data:{a:"${goodsinf.getId()}",b:count}, 
			cache:false, 
			dataType:'json', 
			complete:function(data){ 
				if(data.count==0){
					alert("请先登录");
				}
				$("#show_count").text(data.num);
				ajax=1;
			} 
			}); 
		}
		});

	// 	$("#add_cart").click(function(){
	// 		count = $(".num_show").val();
	// 		url = "/cart/add" + {{goods.id}} + "_" + count;
	// 		console.log(ajax);
	// 		if(ajax==1){
	// 		//window.setTimeout(timeo,3000);	
	// 	$.get(url, function(data){
	// 		$("#show_count").text(data.count);
	// 		ajax=0;
	// 	},ajax=1);
	// }
	// });
});
function add()
	{
	num = $('.num_show').val();
	if (num<99){
		num++;
		$('.num_show').val(num);
	}
	total = "${goodsinf.getGprice()}" *num;
	$("#_gtotal_").text(total.toFixed(2)+'元');
	}
function minus()
{
	num = $('.num_show').val();
	if (num>1){
		num--;
		$('.num_show').val(num);
	}
	total = "${goodsinf.getGprice()}" *num;
	$("#_gtotal_").text(total.toFixed(2)+'元');
	}
</script>
</head>
<body>
 <%@ include file="../bhead.jsp" %>
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


	<div class="goods_detail_con clearfix">
		<div class="goods_detail_pic fl"><img src="${pageContext.request.contextPath}${goodsinf.getGpic()} "style="width:350px;height:350px"></div>

		<div class="goods_detail_list fr">
			<h3>${goodsinf.getGtitle()}</h3>
			<p>${goodsinf.getGjianjie()}</p>
			<div class="prize_bar">
				<span class="show_pirze">¥<em>${goodsinf.getGprice()}</em></span>
				<span class="show_unit">单  位：${goodsinf.getGunit()}</span>
			</div>
			<div class="goods_num clearfix">
				<div class="num_name fl">数 量：</div>
				<div class="num_add fl">
					<input type="text" class="num_show fl" value="1">
					<a href="javascript:add();" class="add fr">+</a>
					<a href="javascript:minus();" class="minus fr">-</a>	
				</div> 
			</div>
			<div class="total">总价：<em id="_gtotal_">${goodsinf.getGprice()}元</em></div>
			<div class="operate_btn">
				<a href="javascript:;" class="buy_btn">立即购买</a>
				<a href="javascript:;" class="add_cart" id="add_cart">加入购物车</a>				
			</div>
		</div>
	</div>

	<div class="main_wrap clearfix">
		<div class="l_wrap fl clearfix">
<%@ include file="./new_goods.jsp"%>
		</div>

		<div class="r_wrap fr clearfix">
			<ul class="detail_tab clearfix">
				<li class="active">商品介绍</li>
				<li>评论</li>
			</ul>

			<div class="tab_content">
				<dl>
					<dt>商品详情：</dt>
					<dd>${goodsinf.getGcontent()} </dd>
				</dl>
			</div>

		</div>
	</div>
	 <%@ include file="../footer.jsp" %>
</body>
</html>