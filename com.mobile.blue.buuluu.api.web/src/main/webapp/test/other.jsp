<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>CARTIER API JSP</title>
</head>
<Body>
<form name="EventForm" action="../feedBack.do" method="post">
		<h2>API feedBack.do</h2>
		lang:<input name="lang" type="text"/>
		device:<input name="device" type="text"/>
		deviceVerNum:<input name="deviceVerNum" type="text"/>
		imei:<input name="imei" type="text"/>
		mac:<input name="mac" type="text"/>
		imsi:<input name="imsi" type="text"/>
		userId:<input name="userId" type="text"/>
		token:<input name="token" type="text"/>
		content:<input name="content" type="text"/>
		<input type="submit" style="width: 200px" value="feedBack"/>
</form>

<form name="EventForm" action="../versionUpdate.do" method="post">
		<h2>API versionUpdate.do</h2>
		lang:<input name="lang" type="text"/>
		device:<input name="device" type="text"/>
		deviceVerNum:<input name="deviceVerNum" type="text"/>
		imei:<input name="imei" type="text"/>
		mac:<input name="mac" type="text"/>
		imsi:<input name="imsi" type="text"/>
		store:<input name="store" type="text"/>
		channel:<input name="channel" type="text"/>
		internet:<input name="internet" type="text"/>
		resolution:<input name="resolution" type="text"/>
		<input type="submit" style="width: 200px" value="versionUpdate"/>
</form>

<form name="EventForm" action="../getSignList.do" method="post">
		<h2>API getSignList.do</h2>
		lang:<input name="lang" type="text"/>
		device:<input name="device" type="text"/>
		deviceVerNum:<input name="deviceVerNum" type="text"/>
		imei:<input name="imei" type="text"/>
		mac:<input name="mac" type="text"/>
		imsi:<input name="imsi" type="text"/>
		userId:<input name="userId" type="text"/>
		token:<input name="token" type="text"/>
		<input type="submit" style="width: 200px" value="getSignList"/>
</form>

<form name="EventForm" action="../addSign.do" method="post">
		<h2>API addSign.do</h2>
		lang:<input name="lang" type="text"/>
		device:<input name="device" type="text"/>
		deviceVerNum:<input name="deviceVerNum" type="text"/>
		imei:<input name="imei" type="text"/>
		mac:<input name="mac" type="text"/>
		imsi:<input name="imsi" type="text"/>
		userId:<input name="userId" type="text"/>
		token:<input name="token" type="text"/>
		<input type="submit" style="width: 200px" value="addSign"/>
</form>

<form name="EventForm" action="../buuluuMonitor.do" method="post">
		<h2>API buuluuMonitor.do</h2>
		lang:<input name="lang" type="text"/>
		device:<input name="device" type="text"/>
		deviceVerNum:<input name="deviceVerNum" type="text"/>
		imei:<input name="imei" type="text"/>
		mac:<input name="mac" type="text"/>
		imsi:<input name="imsi" type="text"/>
		userId:<input name="userId" type="text"/>
		token:<input name="token" type="text"/>
		dataTime:<input name="dataTime" type="text"/>
		consumBuuluu:<input name="consumBuuluu" type="text"/>
		<input type="submit" style="width: 200px" value="buuluuMonitor"/>
</form>	

<form name="EventForm" action="../alarmPush.do" method="post">
		<h2>API alarmPush.do</h2>
		lang:<input name="lang" type="text"/>
		device:<input name="device" type="text"/>
		deviceVerNum:<input name="deviceVerNum" type="text"/>
		imei:<input name="imei" type="text"/>
		mac:<input name="mac" type="text"/>
		imsi:<input name="imsi" type="text"/>
		userId:<input name="userId" type="text"/>
		token:<input name="token" type="text"/>
		<input type="submit" style="width: 200px" value="alarmPush"/>
</form>	
	

</BODY>
</html>