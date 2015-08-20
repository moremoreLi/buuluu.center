<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="pg" uri="http://jsptags.com/tags/navigation/pager"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>IHeHa Order Detail</title>
<script type="text/javascript"
	src="/prod/<%=request.getContextPath() %>/scripts/tableListSort.js"></script>
<script type="text/javascript">
	window.onload = function() {
		//自定义添加class 如果不打算添加 此属性可以为不设置。
		//table.Index为上一次被排序过的坐标值;table.Index初始化为null;
		//fn:fini函数仅为排序过后需要执行的函数，就算没有它也是可以排序的
		//这里传递一个排序过后需要执行的函数仅仅是为了添加排序down和up的标示图标
		function fini(num) {
			table.th[num].className = table.th[num].className == 'selectUp' ? 'selectDown'
					: 'selectUp';//切换标示图标

			each(table.Row, function(o) {//highLight高亮当前排序的列
				o.cells[num].className = 'highLight';
				if (table.Index != null && table.Index != num) {
					o.cells[table.Index].className = '';
				}
			});
			if (table.Index != null && table.Index != num) {//另外的被点击 原先的被取消表示图标
				table.th[table.Index].className = '';
			}
		}

		var table = new tableListSort($('tb'), {
			data : 8,
			fileType : 9,
			fn : fini
		})//文档载入后new传递参数
	}
</script>
<style type="text/css">
table#tb {
	text-align: center;
	border: 1px #ccc solid;
	border-collapse: collapse;
	font-size: 12px;
	font-family: Arial, Helvetica, sans-serif;
	color: #666;
	width: 900px;
	background: url 0 -13px repeat-x;
}

table#tb td {
	border-bottom: #ccc 1px solid;
	padding: .3em 0 .3em 0;
}

#tb th {
	height: 30px;
	color: #009;
	background-color: #dde6f5;
	padding-right: 16px;
}

#tb thead tr {
	background-color: #dde6f5;
}

#tb td.highLight {
	color: #000;
}

#tb th.selectUp {
	background: no-repeat right center transparent;
}

#tb th.selectDown {
	background: no-repeat right center transparent;
}
</style>
<style type="text/css">
.even {
	background: white;
}

.odd {
	background: #dde6f5;
}

.thWidthAndHeight {
	width: 100px;
	heigth: 20px;
}
</style>
</head>
<Body>
	<table id="tb" name="order" cellpadding="0" cellspacing="0" border="1" heigth="95%">
		<thead>
			<tr>
				<th>ID</th>
				<th>Order No.</th>
				<th>COUPONCODE</th>
				<th>LOCATION</th>
				<th>PROVINCE</th>
				<th>CITY</th>
				<th>REGION</th>
				<th>POSTALCODE</th>
				<th width="10000px">ADDRESS</th>
				<!-- <th>OFFICEADDRESS</th> -->
				<th>RECEIVERNAME</th>
				<th>PHONENO</th>
				<!-- <th>EMAILADDRESS</th> -->
				<th>CREATEDATE</th>
				<th>QUANTITY</th>
				<th>PAYMENTTOTAL</th>
				<th>PAYMENTMETHOD</th>
				<th>PAYMENTSTATUS</th>
				<th>ORDERSTATUS</th>
				<th>REFUNDSTATUS</th>
				<th>DISPUTESTATUS</th>
				<th>BILL_LOCATION</th>
				<th>BILL_PROVINCE</th>
				<th>BILL_CITY</th>
				<th>BILL_REGION</th>
				<th>BILL_POSTALCODE</th>
				<th>BILL_ADDRESS</th>
				<th>BILL_OFFICEADDRESS</th>
				<th>BILL_RECEIVERNAME</th>
				<th>BILL_PHONENO</th>
				<!-- <th>BILL_EMAILADDRESS</th> -->
				<th>REMARK</th>
				<th>ITEM_ID</th>
				<th>SKU_NO</th>
				<th>SKU_NAME</th>
				<th>QTY</th>
				<th>PRICE</th>
				<th>SALE_SUM</th>
				<th>PAY_SUM</th>
				<th>ORDER_DISCOUNT</th>
			</tr>
		</thead>
		<tbody>
			<c:if test="${!empty pm.datas}">
				<c:forEach items="${orderLists }" var="orderlist">
					<c:if test="${orderlist.index % 2== 0}">
						<tr class="even">
							<td>${orderlist.id }</td>
							<td>${orderlist.orderCode }</td>
							<td>${orderlist.couponCode }</td>
							<td>${orderlist.location }</td>
							<td>${orderlist.province }</td>
							<td>${orderlist.city }</td>
							<td>${orderlist.region }</td>
							<td>${orderlist.postalCode }</td>
							<td width="10000px">${orderlist.address }</td>
							<!-- <td>${orderlist.officeAddress }</td> -->
							<td>${orderlist.receiverName }</td>
							<td>${orderlist.phoneNo }</td>
							<!-- <td>${orderlist.emailAddress }</td> -->
							<td>${orderlist.createDate }</td>
							<td>${orderlist.quantity }</td>
							<td>${orderlist.paymentTotal }</td>
							<td>${orderlist.paymentMethod }</td>
							<td>${orderlist.paymentStatus }</td>
							<td>${orderlist.orderStatus }</td>
							<td>${orderlist.refundStatus }</td>
							<td>${orderlist.disputeStatus }</td>
							<td>${orderlist.bill_location }</td>
							<td>${orderlist.bill_province }</td>
							<td>${orderlist.bill_city }</td>
							<td>${orderlist.bill_region }</td>
							<td>${orderlist.bill_postalCode }</td>
							<td>${orderlist.bill_address }</td>
							<td>${orderlist.bill_officeAddress }</td>
							<td>${orderlist.bill_receiverName }</td>
							<td>${orderlist.bill_phoneNo }</td>
							<!-- <td>${orderlist.bill_emailAddress }</td> -->
							<td>${orderlist.remark }</td>
							<td>${orderlist.item_id }</td>
							<td>${orderlist.sku_no }</td>
							<td>${orderlist.sku_name }</td>
							<td>${orderlist.qty }</td>
							<td>${orderlist.price }</td>
							<td>${orderlist.sale_sum }</td>
							<td>${orderlist.pay_sum }</td>
							<td>${orderlist.order_discount }</td>
						</tr>
					</c:if>

					<c:if test="${orderlist.index % 2 == 1}">
						<tr class="odd">
							<td>${orderlist.id }</td>
							<td>${orderlist.orderCode }</td>
							<td>${orderlist.couponCode }</td>
							<td>${orderlist.location }</td>
							<td>${orderlist.province }</td>
							<td>${orderlist.city }</td>
							<td>${orderlist.region }</td>
							<td>${orderlist.postalCode }</td>
							<td width="10000px">${orderlist.address }</td>
							<!-- <td>${orderlist.officeAddress }</td> -->
							<td>${orderlist.receiverName }</td>
							<td>${orderlist.phoneNo }</td>
							<!-- <td>${orderlist.emailAddress }</td> -->
							<td>${orderlist.createDate }</td>
							<td>${orderlist.quantity }</td>
							<td>${orderlist.paymentTotal }</td>
							<td>${orderlist.paymentMethod }</td>
							<td>${orderlist.paymentStatus }</td>
							<td>${orderlist.orderStatus }</td>
							<td>${orderlist.refundStatus }</td>
							<td>${orderlist.disputeStatus }</td>
							<td>${orderlist.bill_location }</td>
							<td>${orderlist.bill_province }</td>
							<td>${orderlist.bill_city }</td>
							<td>${orderlist.bill_region }</td>
							<td>${orderlist.bill_postalCode }</td>
							<td>${orderlist.bill_address }</td>
							<td>${orderlist.bill_officeAddress }</td>
							<td>${orderlist.bill_receiverName }</td>
							<td>${orderlist.bill_phoneNo }</td>
							<!-- <td>${orderlist.bill_emailAddress }</td> -->
							<td>${orderlist.remark }</td>
							<td>${orderlist.item_id }</td>
							<td>${orderlist.sku_no }</td>
							<td>${orderlist.sku_name }</td>
							<td>${orderlist.qty }</td>
							<td>${orderlist.price }</td>
							<td>${orderlist.sale_sum }</td>
							<td>${orderlist.pay_sum }</td>
							<td>${orderlist.order_discount }</td>
						</tr>
					</c:if>
				</c:forEach>
			</c:if>
			<c:if test="${empty pm.datas}">
				<tr>
					<td colspan="40" align="left" bgcolor="#EFF3F7"><font color="red">No Records</font></td>
				</tr>
			</c:if>
		</tbody>
	</table>
	<c:if test="${!empty pm.datas}">
	<pg:pager url="getOrderLists.do" items="${pm.total}"
		export="currentPageNumber=pageNumber" maxPageItems="${pm.pageSize }"
		maxIndexPages="${pm.pageNum }">
		<c:if test="${pm.pageNum != 1}">
		<pg:first>
			<a href="${pageUrl}"><<</a>
		</pg:first>
		<pg:prev>
			<a href="${pageUrl }">&lt;</a>
		</pg:prev>
		</c:if>
		<c:if test="${pm.pageNum == 1}">
		<pg:first>
			<a href="#"><<</a>
		</pg:first>
		<pg:prev>
			<a href="#">&lt;</a>
		</pg:prev>
		</c:if>
		<pg:pages>
			<c:choose>
				<c:when test="${currentPageNumber eq pageNumber}">
					<font color="red">${pageNumber }</font>
				</c:when>
				<c:otherwise>
					<a href="${pageUrl }">${pageNumber }</a>
				</c:otherwise>
			</c:choose>
		</pg:pages>
		<c:if test="${pm.pageNum != 1}">
		<pg:next>
			<a href="${pageUrl }">></a>
		</pg:next>
		<pg:last>
			<a href="${pageUrl }">>></a>
		</pg:last>
		</c:if>
		<c:if test="${pm.pageNum == 1}">
		<pg:next>
			<a href="#">></a>
		</pg:next>
		<pg:last>
			<a href="#">>></a>
		</pg:last>
		</c:if>
	</pg:pager>
	</c:if>
</BODY>
</html>