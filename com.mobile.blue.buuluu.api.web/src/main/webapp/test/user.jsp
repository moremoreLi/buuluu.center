<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>CARTIER API JSP</title>
</head>
<Body>

<form name="EventForm" action="http://192.168.1.126/appinfo-applist-aaaaa.html" method="post">
		<h2>API test.do</h2>
		categoryid:<input name="categoryid" type="text"/>
		classid:<input name="classid" type="text"/>
		order:<input name="order" type="text"/>
		orderType:<input name="orderType" type="text"/>
		page:<input name="page" type="text"/>
		<input type="submit" style="width: 200px" value="login"/>
</form>

<form name="EventForm" action="../login.do" method="post">
		<h2>API login.do</h2>
		lang:<input name="lang" type="text"/>
		device:<input name="device" type="text"/>
		deviceVerNum:<input name="deviceVerNum" type="text"/>
		imei:<input name="imei" type="text"/>
		mac:<input name="mac" type="text"/>
		imsi:<input name="imsi" type="text"/>
		tel:<input name="tel" type="text"/>
		pwd:<input name="pwd" type="text"/>
		countryCode:<input name="countryCode" type="text"/>
		<input type="submit" style="width: 200px" value="login"/>
</form>

<form name="EventForm" action="../register.do" method="post">
		<h2>API register.do</h2>
		lang:<input name="lang" type="text"/>
		device:<input name="device" type="text"/>
		deviceVerNum:<input name="deviceVerNum" type="text"/>
		imei:<input name="imei" type="text"/>
		mac:<input name="mac" type="text"/>
		imsi:<input name="imsi" type="text"/>
		tel:<input name="tel" type="text"/>
		pwd:<input name="pwd" type="text"/>
		countryCode:<input name="countryCode" type="text"/>
		pushStatus:<input name="pushStatus" type="text"/>
		log:<input name="log" type="text"/>
		lat:<input name="lat" type="text"/>
		activation:<input name="activation" type="text"/>
		<input type="submit" style="width: 200px" value="register"/>
</form>

<form name="EventForm" action="../quickRegister.do" method="post">
		<h2>API quickRegister.do</h2>
		lang:<input name="lang" type="text"/>
		device:<input name="device" type="text"/>
		deviceVerNum:<input name="deviceVerNum" type="text"/>
		imei:<input name="imei" type="text"/>
		mac:<input name="mac" type="text"/>
		imsi:<input name="imsi" type="text"/>
		tel:<input name="tel" type="text"/>
		pwd:<input name="pwd" type="text"/>
		countryCode:<input name="countryCode" type="text"/>
		pushStatus:<input name="pushStatus" type="text"/>
		log:<input name="log" type="text"/>
		lat:<input name="lat" type="text"/>
		<input type="submit" style="width: 200px" value="quickRegister"/>
</form>

<form name="EventForm" action="../sendActivation.do" method="post">
		<h2>API sendActivation.do</h2>
		lang:<input name="lang" type="text"/>
		device:<input name="device" type="text"/>
		deviceVerNum:<input name="deviceVerNum" type="text"/>
		imei:<input name="imei" type="text"/>
		mac:<input name="mac" type="text"/>
		imsi:<input name="imsi" type="text"/>
		countryCode:<input name="countryCode" type="text"/>
		tel:<input name="tel" type="text"/>
		type:<input name="type" type="text"/>
		<input type="submit" style="width: 200px" value="sendActivation"/>
</form>

<form name="EventForm" action="../verifyActivation.do" method="post">
		<h2>API verifyActivation.do</h2>
		lang:<input name="lang" type="text"/>
		device:<input name="device" type="text"/>
		deviceVerNum:<input name="deviceVerNum" type="text"/>
		imei:<input name="imei" type="text"/>
		mac:<input name="mac" type="text"/>
		imsi:<input name="imsi" type="text"/>
		countryCode:<input name="countryCode" type="text"/>
		tel:<input name="tel" type="text"/>
		activation:<input name="activation" type="text"/>
		<input type="submit" style="width: 200px" value="verifyActivation"/>
</form>

<form name="EventForm" action="../autoLogin.do" method="post">
		<h2>API autoLogin.do</h2>
		lang:<input name="lang" type="text"/>
		device:<input name="device" type="text"/>
		deviceVerNum:<input name="deviceVerNum" type="text"/>
		imei:<input name="imei" type="text"/>
		mac:<input name="mac" type="text"/>
		imsi:<input name="imsi" type="text"/>
		userId:<input name="userId" type="text"/>
		token:<input name="token" type="text"/>
		<input type="submit" style="width: 200px" value="autoLogin"/>
</form>

<form name="EventForm" action="../resetPassword.do" method="post">
		<h2>API resetPassword.do</h2>
		lang:<input name="lang" type="text"/>
		device:<input name="device" type="text"/>
		deviceVerNum:<input name="deviceVerNum" type="text"/>
		imei:<input name="imei" type="text"/>
		mac:<input name="mac" type="text"/>
		imsi:<input name="imsi" type="text"/>
		userId:<input name="userId" type="text"/>
		token:<input name="token" type="text"/>
		oldPwd:<input name="oldPwd" type="text"/>
		newPwd:<input name="newPwd" type="text"/>
		<input type="submit" style="width: 200px" value="resetPassword"/>
</form>

<form name="EventForm" action="../recoverPassword.do" method="post">
		<h2>API recoverPassword.do</h2>
		lang:<input name="lang" type="text"/>
		device:<input name="device" type="text"/>
		deviceVerNum:<input name="deviceVerNum" type="text"/>
		imei:<input name="imei" type="text"/>
		mac:<input name="mac" type="text"/>
		imsi:<input name="imsi" type="text"/>
		countryCode:<input name="countryCode" type="text"/>
		tel:<input name="tel" type="text"/>
		email:<input name="email" type="text"/>
		<input type="submit" style="width: 200px" value="recoverPassword"/>
</form>

<form name="EventForm" action="../getUserProfile.do" method="post">
		<h2>API getUserProfile.do</h2>
		lang:<input name="lang" type="text"/>
		device:<input name="device" type="text"/>
		deviceVerNum:<input name="deviceVerNum" type="text"/>
		imei:<input name="imei" type="text"/>
		mac:<input name="mac" type="text"/>
		imsi:<input name="imsi" type="text"/>
		userId:<input name="userId" type="text"/>
		token:<input name="token" type="text"/>
		<input type="submit" style="width: 200px" value="getUserProfile"/>
</form>

<form name="EventForm" action="../updateUserProfile.do" method="post">
		<h2>API updateUserProfile.do</h2>
		lang:<input name="lang" type="text"/>
		device:<input name="device" type="text"/>
		deviceVerNum:<input name="deviceVerNum" type="text"/>
		imei:<input name="imei" type="text"/>
		mac:<input name="mac" type="text"/>
		imsi:<input name="imsi" type="text"/>
		userId:<input name="userId" type="text"/>
		token:<input name="token" type="text"/>
		sex:<input name="sex" type="text"/>
		icon:<input name="icon" type="text"/>
		birthday:<input name="birthday" type="text"/>
		country:<input name="country" type="text"/>
		nickName:<input name="nickName" type="text"/>
		log:<input name="log" type="text"/>
		lat:<input name="lat" type="text"/>
		tel:<input name="tel" type="text"/>
		<input type="submit" style="width: 200px" value="updateUserProfile"/>
</form>

<form name="EventForm" action="../logout.do" method="post">
		<h2>API logout.do</h2>
		lang:<input name="lang" type="text"/>
		device:<input name="device" type="text"/>
		deviceVerNum:<input name="deviceVerNum" type="text"/>
		imei:<input name="imei" type="text"/>
		mac:<input name="mac" type="text"/>
		imsi:<input name="imsi" type="text"/>
		userId:<input name="userId" type="text"/>
		token:<input name="token" type="text"/>
		<input type="submit" style="width: 200px" value="logout"/>
</form>

</BODY>
</html>