<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>CARTIER API JSP</title>
</head>
<Body>
<form name="EventForm" action="../snsLogin.do" method="post">
		<h2>API snsLogin.do</h2>
		lang:<input name="lang" type="text"/>
		device:<input name="device" type="text"/>
		deviceVerNum:<input name="deviceVerNum" type="text"/>
		imei:<input name="imei" type="text"/>
		mac:<input name="mac" type="text"/>
		imsi:<input name="imsi" type="text"/>
		type:<input name="type" type="text"/>
		snsId:<input name="snsId" type="text"/>
		<input type="submit" style="width: 200px" value="snsLogin"/>
</form>

<form name="EventForm" action="../inviteFriend.do" method="post">
		<h2>API inviteFriend.do</h2>
		lang:<input name="lang" type="text"/>
		device:<input name="device" type="text"/>
		deviceVerNum:<input name="deviceVerNum" type="text"/>
		imei:<input name="imei" type="text"/>
		mac:<input name="mac" type="text"/>
		imsi:<input name="imsi" type="text"/>
		userId:<input name="userId" type="text"/>
		token:<input name="token" type="text"/>
		countryCode:<input name="countrytelCode" type="text"/>
		tel:<input name="tel" type="text"/>
		email:<input name="email" type="text"/>
		<input type="submit" style="width: 200px" value="inviteFriend"/>
</form>

<form name="EventForm" action="../receiverMsg.do" method="post">
		<h2>API receiverMsg.do</h2>
		lang:<input name="lang" type="text"/>
		device:<input name="device" type="text"/>
		deviceVerNum:<input name="deviceVerNum" type="text"/>
		imei:<input name="imei" type="text"/>
		mac:<input name="mac" type="text"/>
		imsi:<input name="imsi" type="text"/>
		userId:<input name="userId" type="text"/>
		token:<input name="token" type="text"/>
		<input type="submit" style="width: 200px" value="receiverMsg"/>
</form>

<form name="EventForm" action="../receiverMsgDetail.do" method="post">
		<h2>API receiverMsgDetail.do</h2>
		lang:<input name="lang" type="text"/>
		device:<input name="device" type="text"/>
		deviceVerNum:<input name="deviceVerNum" type="text"/>
		imei:<input name="imei" type="text"/>
		mac:<input name="mac" type="text"/>
		imsi:<input name="imsi" type="text"/>
		userId:<input name="userId" type="text"/>
		token:<input name="token" type="text"/>
		typeId:<input name="typeId" type="text"/>
		<input type="submit" style="width: 200px" value="receiverMsgDetail"/>
</form>

<form name="EventForm" action="../blindLogin.do" method="post">
		<h2>API blindLogin.do</h2>
		lang:<input name="lang" type="text"/>
		device:<input name="device" type="text"/>
		deviceVerNum:<input name="deviceVerNum" type="text"/>
		imei:<input name="imei" type="text"/>
		mac:<input name="mac" type="text"/>
		imsi:<input name="imsi" type="text"/>
		countryCode:<input name="countryCode" type="text"/>
		tel:<input name="tel" type="text"/>
		pwd:<input name="pwd" type="text"/>
		type:<input name="type" type="text"/>
		snsId:<input name="snsId" type="text"/>
		<input type="submit" style="width: 200px" value="blindLogin"/>
</form>

<form name="EventForm" action="../blindRegister.do" method="post">
		<h2>API blindRegister.do</h2>
		lang:<input name="lang" type="text"/>
		device:<input name="device" type="text"/>
		deviceVerNum:<input name="deviceVerNum" type="text"/>
		imei:<input name="imei" type="text"/>
		mac:<input name="mac" type="text"/>
		imsi:<input name="imsi" type="text"/>
		countryCode:<input name="countryCode" type="text"/>
		tel:<input name="tel" type="text"/>
		pwd:<input name="pwd" type="text"/>
		pushStatus:<input name="pushStatus" type="text"/>
		type:<input name="type" type="text"/>
		snsId:<input name="snsId" type="text"/>
		<input type="submit" style="width: 200px" value="blindRegister"/>
</form>

<form name="EventForm" action="../getBlindStatus.do" method="post">
		<h2>API getBlindStatus.do</h2>
		lang:<input name="lang" type="text"/>
		device:<input name="device" type="text"/>
		deviceVerNum:<input name="deviceVerNum" type="text"/>
		imei:<input name="imei" type="text"/>
		mac:<input name="mac" type="text"/>
		imsi:<input name="imsi" type="text"/>
		userId:<input name="userId" type="text"/>
		token:<input name="token" type="text"/>
		<input type="submit" style="width: 200px" value="getBlindStatus"/>
</form>

<form name="EventForm" action="../blindSns.do" method="post">
		<h2>API blindSns.do</h2>
		lang:<input name="lang" type="text"/>
		device:<input name="device" type="text"/>
		deviceVerNum:<input name="deviceVerNum" type="text"/>
		imei:<input name="imei" type="text"/>
		mac:<input name="mac" type="text"/>
		imsi:<input name="imsi" type="text"/>
		type:<input name="type" type="text"/>
		snsId:<input name="snsId" type="text"/>
		snsToken:<input name="snsToken" type="text"/>
		userId:<input name="userId" type="text"/>
		token:<input name="token" type="text"/>
		<input type="submit" style="width: 200px" value="blindSns"/>
</form>
</BODY>
</html>