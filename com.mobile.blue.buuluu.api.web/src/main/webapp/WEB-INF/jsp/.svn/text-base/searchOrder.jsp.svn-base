<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>IHeHa Order Detail</title>
<script type="text/javascript"
	src="/prod/<%=request.getContextPath() %>/My97DatePicker/WdatePicker.js"></script>
</head>
<body>
	<div width="100%" height="100%">
		<div width="100%" height="5%">
			<form name="EventForm" action="/prod/<%=request.getContextPath() %>/getOrderLists.do" method="post" target="ifr">
				Order No. (訂單號):<input type="text" id="tid" name="tid" style="width: 150px" value="" /> &nbsp;&nbsp;
				PurchaseDate (訂購日期):<input type="text" id="orderTime" name="orderTime" onFocus="WdatePicker({startDate:'%y-%M-01 00:00:00',dateFmt:'yyyy-MM-dd HH:mm:ss',alwaysUseStartDate:true})"/>
				<input type="submit" style="width: 150px" value="Search" />
			</form>
		</div>
		<div width="100%" height="95%">
			<iframe name="ifr" marginWidth=0 marginHeight=0 scrolling=auto src="/prod/<%=request.getContextPath() %>/getOrderLists.do" frameBorder=0 width="100%" height=800></iframe>
		</div>
	</div>
</body>
</html>