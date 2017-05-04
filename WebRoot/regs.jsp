<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3c.org/TR/1999/REC-html401-19991224/loose.dtd">
<!-- saved from url=(0049)http://localhost:8080/HouseRent/page/register.jsp -->
<HTML xmlns="http://www.w3.org/1999/xhtml">
<HEAD>
<TITLE>用户注册</TITLE>
<META content="text/html; charset=utf-8" http-equiv=Content-Type>
<LINK rel=stylesheet type=text/css href="css/style.css">
<META name=GENERATOR content="MSHTML 8.00.7601.17514">
</HEAD>
<BODY>
	<DIV id=header class=wrap>
		<DIV id=logo>
			<IMG src="images/logo.gif">
		</DIV>
	</DIV>
	<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
	<!-- 
	<script type="text/javascript">
		function checkName() {
			var username = document.getElementsByName("name")[0].value;
			$.ajax({
				type : "post",
				url : "UsersActionselectName.action",
				data : "name=" + username,
				success : function(dd) {
					if (dd == "true") {
						alert("此用户名已存在");
						document.getElementById("submit").disabled = true;
					} else if (dd == "false") {
						document.getElementById("submit").disabled = false;
					}
					alert("请您换个用户名试试哦@");
				},
				error : function() {
					alert("出错误了!!!");
				}
			});
		}
	</script>
	 -->
	<DIV id=regLogin class=wrap>
		<DIV class=dialog>
			<DL class=clearfix>
				<DT>新用户注册</DT>
				<DD class=past>填写个人信息</DD>
			</DL>
			<DIV class=box>
				<FORM action="UsersActioninsert" method="post">
					<DIV class=infos>
						<TABLE class=field>
							<TBODY>
								<TR>
									<TD class=field>用 户 名：</TD>
									<TD><INPUT class=text type=text name="name"></TD>
								</TR>
								<TR>
									<TD class=field>密 码：</TD>
									<TD><INPUT class=text type=password name="password">
									</TD>
								</TR>
							</TBODY>
						</TABLE>
						<DIV class=buttons>
							<INPUT value=立即注册 type="submit" id="submit"> <INPUT
								onclick='document.location="login.jsp"' value=立即登录 type=button>
						</DIV>
					</DIV>
				</FORM>
			</DIV>
		</DIV>
	</DIV>
	<DIV id=footer class=wrap>
		<DL>
			<DT>租房网 © 2010 租房网 京ICP证1000001号</DT>
			<DD>关于我们 · 联系方式 · 意见反馈 · 帮助中心</DD>
		</DL>
	</DIV>
</BODY>
</HTML>

