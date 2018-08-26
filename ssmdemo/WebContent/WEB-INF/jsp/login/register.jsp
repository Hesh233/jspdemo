<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<title>register</title>
<link rel="stylesheet"
	href="${ pageContext.request.contextPath }/layui/css/layui.css">
<style>
#top {
	margin-top: 10%;
	font-size: 200%;;
	text-align: center;
	color: #1E9FFF;
}

#middle {
	margin-top: 15%;
}
</style>
</head>
<body style="background-color: #d2d2d2">
	<div style="text-align: right">
		<button class="layui-btn" onclick="window.location.href='loginForm'">返回登录</button>	
	</div>
	<div id="top">注册</div>
	<div class="layui-row">
		<div class="layui-col-xs4">
			<div class="grid-demo grid-demo-bg1">&nbsp;</div>
		</div>
		<div class="layui-col-xs6">
			<div class="grid-demo">
				<div id="middle">
					<div class="layui-tab">
						<ul class="layui-tab-title">
							<li class="layui-this">用户端</li>
							<li>商家端</li>
							<li>配送端</li>
						</ul>
						<div class="layui-tab-content">
							<div class="layui-tab-item layui-show">
<!-- 															用户端 -->
								<form action="/ssmdemo/register" method="post"
									id="register1">
<!-- 									帐号输入 -->
									<div class="layui-form-item">
										<label class="layui-form-label">帐号</label>
										<div class="layui-input-inline">
											<input type="text" name="username" id="username1" 
												lay-verify="required" value="" class="layui-input" />
										</div>
									</div>
									<!--密码输入-->
									<div class="layui-form-item">
										<label class="layui-form-label">密码</label>
										<div class="layui-input-inline">
											<input type="password" name="password" id="password" 
												lay-verify="required" value="" class="layui-input" />
										</div>
									</div>
<!-- 																		确认密码输入 -->
									<div class="layui-form-item">
										<label class="layui-form-label">确认密码</label>
										<div class="layui-input-inline">
											<input type="password" id="passwordconfirm"
												name="passwordconfirm"  lay-verify="required"
												value="" class="layui-input" />
										</div>
									</div>
<!-- 									验证码输入 --> 
<!-- 									<div class="layui-form-item"> -->
<!-- 										<label class="layui-form-label">验证码</label> -->
<!-- 										<div class="layui-input-inline"> -->
<!-- 											<input type="text" name="captcha" id="captcha"  -->
<!-- 												lay-verify="required" autocomplete="off" class="layui-input" -->
<!-- 												style="width: 90px;"> -->
<!-- 										</div> -->
<!-- 										<img src="" name="KeyImg" id="KeyImg" align="bottom" -->
<!-- 											onclick="" alt="看不清楚,点击刷新" -->
<!-- 											style="height: 38px; width: 150px;"> -->
<!-- 									</div> -->
<!-- 									按钮 -->
									<div class="layui-row">
										<div class="layui-col-xs3">
											<div class="grid-demo grid-demo-bg1">&nbsp;</div>
										</div>
										<div class="layui-col-xs6">
											<div class="grid-demo">
												<!-- 												<input type="submit" name="submit" id="submit" -->
												<input type="button" value="注册" onClick="checkLogin(this)"
													id="btn1" class="layui-btn layui-btn-normal" value="注册">
												<input type="reset" name="reset" id="reset"
													class="layui-btn" value="重置"> <input type="hidden"
													name="type" id="type" value="1">
											</div>
										</div>
									</div>
								</form>
							</div>







							<div class="layui-tab-item">
<!-- 															商家端							 -->
								<form action="/ssmdemo/register" method="post"
									id="register2">
									<!--帐号输入 -->
									<div class="layui-form-item">
										<label class="layui-form-label">帐号</label>
										<div class="layui-input-inline">
											<input type="text" name="username" id="username2" 
												lay-verify="required" value="" class="layui-input" />
										</div>
									</div>
<!-- 									密码输入 -->
									<div class="layui-form-item">
										<label class="layui-form-label">密码</label>
										<div class="layui-input-inline">
											<input type="password" name="password" id="password" 
												lay-verify="required" value="" class="layui-input" />
										</div>
									</div>
<!-- 																		确认密码输入 -->
									<div class="layui-form-item">
										<label class="layui-form-label">确认密码</label>
										<div class="layui-input-inline">
											<input type="password" id="passwordconfirm"
												name="passwordconfirm"  lay-verify="required"
												value="" class="layui-input" />
										</div>
									</div>
<!--  									验证码输入 --> 
<!-- 									<div class="layui-form-item"> -->
<!-- 										<label class="layui-form-label">验证码</label> -->
<!-- 										<div class="layui-input-inline"> -->
<!-- 											<input type="text" name="captcha" id="captcha"  -->
<!-- 												lay-verify="required" autocomplete="off" class="layui-input" -->
<!-- 												style="width: 90px;"> -->
<!-- 										</div> -->
<!-- 										<img src="" name="KeyImg" id="KeyImg" align="bottom" -->
<!-- 											onclick="" alt="看不清楚,点击刷新" -->
<!-- 											style="height: 38px; width: 150px;"> -->
<!-- 									</div> -->
									<!-- 按钮 -->
									<div class="layui-row">
										<div class="layui-col-xs3">
											<div class="grid-demo grid-demo-bg1">&nbsp;</div>
										</div>
										<div class="layui-col-xs6">
											<div class="grid-demo">
												<!-- 												<input type="submit" name="submit" id="submit" -->
												<input type="button" value="注册" onClick="checkLogin(this)"
													id="btn2" class="layui-btn layui-btn-normal" value="注册">
												<input type="reset" name="reset" id="reset"
													class="layui-btn" value="重置"> <input type="hidden"
													name="type" id="type" value="2">
											</div>
										</div>
									</div>
								</form>
							</div>









							<div class="layui-tab-item">
								<!-- 							配送端 -->
								<form action="/ssmdemo/register" method="post"
									id="register3">
									<!--帐号输入 -->
									<div class="layui-form-item">
										<label class="layui-form-label">帐号</label>
										<div class="layui-input-inline">
											<input type="text" name="username" id="username3" 
												lay-verify="required" value="" class="layui-input" />
										</div>
									</div>
<!-- 									密码输入 -->
									<div class="layui-form-item">
										<label class="layui-form-label">密码</label>
										<div class="layui-input-inline">
											<input type="password" name="password" id="password" 
												lay-verify="required" value="" class="layui-input" />
										</div>
									</div>
<!-- 																		确认密码输入 -->
									<div class="layui-form-item">
										<label class="layui-form-label">确认密码</label>
										<div class="layui-input-inline">
											<input type="password" id="passwordconfirm"
												name="passwordconfirm"  lay-verify="required"
												value="" class="layui-input" />
										</div>
									</div>
<!-- 									验证码输入 --> 
<!-- 									<div class="layui-form-item"> -->
<!-- 										<label class="layui-form-label">验证码</label> -->
<!-- 										<div class="layui-input-inline"> -->
<!-- 											<input type="text" name="captcha" id="captcha"  -->
<!-- 												lay-verify="required" autocomplete="off" class="layui-input" -->
<!-- 												style="width: 90px;"> -->
<!-- 										</div> -->
<!-- 										<img src="" name="KeyImg" id="KeyImg" align="bottom" -->
<!-- 											onclick="" alt="看不清楚,点击刷新" -->
<!-- 											style="height: 38px; width: 150px;"> -->
<!-- 									</div> -->
<!-- 									按钮 -->
									<div class="layui-row">
										<div class="layui-col-xs3">
											<div class="grid-demo grid-demo-bg1">&nbsp;</div>
										</div>
										<div class="layui-col-xs6">
											<div class="grid-demo">
												<!-- 												<input type="submit" name="submit" id="submit" -->
												<input type="button" value="注册" onClick="checkLogin(this)"
													id="btn3" class="layui-btn layui-btn-normal" value="注册">
												<input type="reset" name="reset" id="reset"
													class="layui-btn" value="重置"> <input type="hidden"
													name="type" id="type" value="3">
											</div>
										</div>
									</div>
								</form>
							</div>


						</div>
					</div>

				</div>
			</div>
		</div>
	</div>
	<script src="layui/layui.js"></script>
	<script>
		//JavaScript代码区域
		layui.use('element', function() {
			var element = layui.element;
		});
		layui.use('form', function() {
			var form = layui.form;

			//监听提交
			form.on('submit(formDemo)', function(data) {
				layer.msg(JSON.stringify(data.field));
				return false;
			});
		});
		function checkLogin(obj) {
		var id = obj.id;
		var userName;
		var loginForm = document.getElementById(getform(id));
		//   var loginForm=document.getElementById("register1");
		var userName = document.getElementById(getusername(id)).value;
		var userPass = document.getElementById("password").value;
		if (userName == '') {
			alert("用户名不能为空！");
			return false;
		}

		if (filterSqlStr(userName)) {
			alert("用户名字符中包含了敏感字符" + sql_str() + ",请重新输入！");
			return false;
		}

		//loginForm.action="/ssmdemo/register";  
		loginForm.submit();
	}
	//获取是哪个表单  跳转
	function getform(id) {
		var formId;
		if (id == 'btn1') {
			formId = "register1"
		}
		if (id == 'btn2') {
			formId = "register2"
		}
		if (id == 'btn3') {
			formId = "register3"
		}
		if (id == 'btn4') {
			formId = "login"
		}
		return formId;
	}
	//获取从那个表单的username
	function getusername(id) {
		var userId;
		if (id == 'btn1') {
			userId = "username1"
		}
		if (id == 'btn2') {
			userId = "username2"
		}
		if (id == 'btn3') {
			userId = "username3"
		}
		if (id == 'btn4') {
			userId = "username4"
		}
		return userId;
	}

	//<!-- 过滤一些敏感字符函数 -->  
	function filterSqlStr(value) {

		var sqlStr = sql_str().split(',');
		var flag = false;

		for (var i = 0; i < sqlStr.length; i++) {

			if (value.toLowerCase().indexOf(sqlStr[i]) != -1) {
				flag = true;
				break;

			}
		}
		return flag;
	}

	function sql_str() {
		var str = "and,delete,or,exec,insert,select,union,update,count,*,',join,>,<";
		return str;
	}
		
	</script>
</body>
</html>