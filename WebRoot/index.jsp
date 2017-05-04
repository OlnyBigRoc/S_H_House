<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3c.org/TR/1999/REC-html401-19991224/loose.dtd">
<!-- saved from url=(0030)http://localhost:8080/House-2/ -->
<HTML xmlns="http://www.w3.org/1999/xhtml">
<HEAD>
<TITLE>首页</TITLE> 
<META content="text/html; charset=utf-8" http-equiv=Content-Type>
<LINK rel=stylesheet type=text/css href="css/style.css">
<META name=GENERATOR content="MSHTML 8.00.7601.17514">
</HEAD>
<BODY>
	<DIV id=header class=wrap>
		<DIV id=logo>
			<IMG src="images/logo.gif">
		</DIV>
		<c:if test="${user!=null}">
			<div class="login">
			<span style="font-size: 20px;">欢迎用户：<a style="color: red;">${user.name}</span></a>
			</div>
		</c:if>
		<c:if test="${user==null}">
			<div class="login">
				<a href="login.jsp">登录</a>
				<a href="regs.jsp">注册</a>
			</div>
		</c:if>
	</DIV>
		
	<DIV id=navbar class=wrap>
		<DL class="search clearfix">
			<FORM id="sform" method="post" action="search">
				<DT>
					<UL>
						<LI class=bold>房屋信息</LI>
						<LI>标题：<INPUT class="text" type="text" name="title"> <LABEL
							class="ui-blue"><INPUT onclick=doSearch() value="搜索房屋"
								type="submit" name="search"> </LABEL>
						</LI>
					</UL>
				</DT>
				<DD>
					<UL>
						<LI class="first">价格</LI>
						<LI><SELECT name="price">
								<OPTION selected value="">不限</OPTION>
								<OPTION value="500">500元以下</OPTION>
								<OPTION value="501-1000">500元—1000元</OPTION>
								<OPTION value="1000">1000元以上</OPTION>
						</SELECT>
						</LI>
					</UL>
				</DD>
				<DD>
					<UL>
						<LI class="first">房屋位置</LI>
						<LI><SELECT id="street" name="street_id">
								<OPTION selected value="">不限</OPTION>
								<c:forEach items="${streetList}" var="street">
									<OPTION value="${street.id}">${street.name}</OPTION>
								</c:forEach>
						</SELECT>
						</LI>
					</UL>
				</DD>
				<DD>
					<UL>
						<LI class="first">房型</LI>
						<LI><SELECT name="type_id">
								<OPTION selected value="">不限</OPTION>
								<c:forEach items="${typesList}" var="types">
									<OPTION value="${types.id }">${types.name}</OPTION>
								</c:forEach>
						</SELECT>
						</LI>
					</UL>
				</DD>
				<DD>
					<UL>
						<LI class=first>面积</LI>
						<LI>
						<SELECT name="floorage">
								<OPTION selected value="">不限</OPTION>
								<OPTION value="40">40以下</OPTION>
								<OPTION value="41-100">40-500</OPTION>
								<OPTION value="101-150">101-150</OPTION>
								<OPTION value="150">150以上</OPTION>
						</SELECT>
						</LI>
					</UL>
				</DD>
			</FORM>
		</DL>
	</DIV>
	<DIV class="main wrap">
		<TABLE class=house-list>
			<TBODY>
				<s:if test="houseList!=null">
					<s:iterator value="houseList" status="status">
						<TR class=odd>
						<TD class=house-thumb><span><A href="details.htm"
							target="_blank"><img src="images/thumb_house.gif" width="100"
								height="75" alt=""> </a> </span></TD>
					<TD>
						<DL>
							<DT>
								<A href="details.htm" target="_blank"><s:property value="title"/></A>
							</DT>
							<DD>
								<s:property value="street.district.name"/>区<s:property value="street.name"/>，<s:property value="floorage"/>平米
						<br />联系方式：<s:property value="contact"/>
							</DD>
						</DL></TD>
					<TD class=house-type><s:property value="types.name"/></TD>
					<TD class=house-price><SPAN><s:property value="price"/></SPAN>元/月</TD>
				</TR>
		</s:iterator>
	</s:if>
  	<s:if test="houseList==null">
    	<tr><s:property value="无租房信息"/></tr> 
    </s:if>
			</TBODY>
		</TABLE>
		<DIV class=pager>
			<UL>
				<LI class=current><A href="#">首页</A></LI>
				<LI><A href="#">上一页</A></LI>
				<LI><A href="#">下一页</A></LI>
				<LI><A href="#">末页</A></LI>
			</UL>
			<SPAN class=total>${pageNo}/${sumPage}页</SPAN>
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

