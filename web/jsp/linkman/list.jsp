<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<TITLE>联系人列表</TITLE> 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<LINK href="${pageContext.request.contextPath }/css/Style.css" type=text/css rel=stylesheet>
<LINK href="${pageContext.request.contextPath }/css/Manage.css" type=text/css
	rel=stylesheet>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.4.4.min.js"></script>
<SCRIPT language=javascript>
	function to_page(page){
		if(page){
			$("#currentPage").val(page);
		}
		$("#customerForm").submit();
	}
	function changePaseSize(pageSize) {
		if (pageSize) {
			$("#pageSize").val(pageSize);
		}
		$("#customerForm").submit();
	}

	function choseCustomer() {
		window.open(
		        '${pageContext.request.contextPath}/CustomerAction_list?from=choseCust',
                '选择客户',
                'height=300,width=600,left=300,top=200'
        );
	}
	// 点击选择
	function selectLkm(lkm_id, lkm_name) {
        var srcWin = window.opener;
        srcWin.document.getElementById("lkm_name").value=lkm_name;
        srcWin.document.getElementById("lkm_id").value=lkm_id;
        window.close();
    }
</SCRIPT>

<META content="MSHTML 6.00.2900.3492" name=GENERATOR>
</HEAD>
<BODY>

		<TABLE cellSpacing=0 cellPadding=0 width="98%" border=0>
			<TBODY>
				<TR>
					<TD width=15><IMG src="${pageContext.request.contextPath }/images/new_019.jpg"
						border=0></TD>
					<TD width="100%" background="${pageContext.request.contextPath }/images/new_020.jpg"
						height=20></TD>
					<TD width=15><IMG src="${pageContext.request.contextPath }/images/new_021.jpg"
						border=0></TD>
				</TR>
			</TBODY>
		</TABLE>
		<TABLE cellSpacing=0 cellPadding=0 width="98%" border=0>
			<TBODY>
				<TR>
					<TD width=15 background="${pageContext.request.contextPath }/images/new_022.jpg"><IMG
						src="${pageContext.request.contextPath }/images/new_022.jpg" border=0></TD>
					<TD vAlign=top width="100%" bgColor=#ffffff>
						<TABLE cellSpacing=0 cellPadding=5 width="100%" border=0>
							<TR>
								<TD class=manageHead>当前位置：联系人管理 &gt; 联系人列表</TD>
							</TR>
							<TR>
								<TD height=2></TD>
							</TR>
						</TABLE>
						<TABLE borderColor=#cccccc cellSpacing=0 cellPadding=0 width="100%" align=center border=0>

							<TBODY>
								<TR>
									<TD height=25>
										<form id="customerForm" name="customerForm" action="${pageContext.request.contextPath }/LinkManAction_list" method=post>

											<input type="hidden" id="currentPage" name="currentPage" value="<s:property value="#pageBean.currentPage"/>">
											<input type="hidden" id="pageSize" name="pageSize" value="<s:property value="#pageBean.pageSize"/>">
											<input type="hidden" id="cust_id" name="customer.cust_id">

											<TABLE cellSpacing=0 cellPadding=2 border=0>
												<TBODY>
													<TR>
														<TD>联系人名称：</TD>
														<TD><INPUT class=textbox id=sChannel2 style="WIDTH: 80px" maxLength=50 name="lkm_name" value="${param.lkm_name}"></TD>
                                                        <TD>所属客户：</TD>
														<TD><input type="text" id="cust_name" name="customer.cust_name" value="${param['customer.cust_name']}">
															<input type="button" id="chose" onclick="choseCustomer()" value="选择客户">
														</TD>
														<TD><INPUT class=button id=sButton2 type=submit value=" 筛选 " name=sButton2></TD>
													</TR>
												</TBODY>
											</TABLE>
										</form>
									</TD>
								</TR>
							    
								<TR>
									<TD>
										<TABLE id=grid
											style="BORDER-TOP-WIDTH: 0px; FONT-WEIGHT: normal; BORDER-LEFT-WIDTH: 0px; BORDER-LEFT-COLOR: #cccccc; BORDER-BOTTOM-WIDTH: 0px; BORDER-BOTTOM-COLOR: #cccccc; WIDTH: 100%; BORDER-TOP-COLOR: #cccccc; FONT-STYLE: normal; BACKGROUND-COLOR: #cccccc; BORDER-RIGHT-WIDTH: 0px; TEXT-DECORATION: none; BORDER-RIGHT-COLOR: #cccccc"
											cellSpacing=1 cellPadding=2 rules=all border=0>
											<TBODY>
												<TR
													style="FONT-WEIGHT: bold; FONT-STYLE: normal; BACKGROUND-COLOR: #eeeeee; TEXT-DECORATION: none">
													<TD>联系人名称</TD>
													<TD>性别</TD>
													<TD>办公电话</TD>
													<TD>手机</TD>
													<TD>操作</TD>
												</TR>
												<c:forEach items="${pageBean.list }" var="linkman">
												<TR
													style="FONT-WEIGHT: normal; FONT-STYLE: normal; BACKGROUND-COLOR: white; TEXT-DECORATION: none">
													<TD>${linkman.lkm_name }</TD>
													<TD>${linkman.lkm_gender }</TD>
													<TD>${linkman.lkm_phone }</TD>
													<TD>${linkman.lkm_mobile }</TD>

													<TD>
                                                    <s:if test="#paramters.from == null">
                                                        <a href="${pageContext.request.contextPath }/linkmanServlet?method=edit&lkmId=${linkman.lkm_id}">修改</a>
                                                        &nbsp;&nbsp;
                                                        <a href="${pageContext.request.contextPath }/linkmanServlet?method=delete&lkmId=${linkman.lkm_id}">删除</a>
                                                    </s:if>
                                                    <s:else>
                                                        <input type="button" onclick="selectLkm(${linkman.lkm_id},'${linkman.lkm_name}')" value="选择">
                                                    </s:else>
                                                    </TD>
												</TR>
												
												</c:forEach>

											</TBODY>
										</TABLE>
									</TD>
								</TR>
								
								<TR>
									<TD><SPAN id=pagelink>
											<DIV
												style="LINE-HEIGHT: 20px; HEIGHT: 20px; TEXT-ALIGN: right">
												共[<B>${pageBean.totalCount}</B>]条记录,共[<B>${pageBean.totalPage}</B>]页
												,每页显示
												<select id="pageSizeSelect" name="pageSize" onchange="changePaseSize($('#pageSizeSelect option:selected').val())">
													<option value="3" <c:if test="${pageBean.pageSize==3 }">selected</c:if>>3</option>
													<option value="5" <c:if test="${pageBean.pageSize==5 }">selected</c:if>>5</option>
												</select>
												条
												[<A href="javascript:void(0)" onclick="to_page(${pageBean.currentPage-1})">前一页</A>]
												<B>${pageBean.currentPage}</B>
												[<A href="javascript:void(0)" onclick="to_page(${pageBean.currentPage+1})">后一页</A>]
												到
												<input type="text" size="3" id="page" name="page" />
												页
												
												<input type="button" value="Go" onclick="to_page($('#page').val())"/>
											</DIV>
									</SPAN></TD>
								</TR>
							</TBODY>
						</TABLE>
					</TD>
					<TD width=15 background="${pageContext.request.contextPath }/images/new_023.jpg"><IMG
						src="${pageContext.request.contextPath }/images/new_023.jpg" border=0></TD>
				</TR>
			</TBODY>
		</TABLE>
		<TABLE cellSpacing=0 cellPadding=0 width="98%" border=0>
			<TBODY>
				<TR>
					<TD width=15><IMG src="${pageContext.request.contextPath }/images/new_024.jpg"
						border=0></TD>
					<TD align=middle width="100%"
						background="${pageContext.request.contextPath }/images/new_025.jpg" height=15></TD>
					<TD width=15><IMG src="${pageContext.request.contextPath }/images/new_026.jpg"
						border=0></TD>
				</TR>
			</TBODY>
		</TABLE>

</BODY>
</HTML>
