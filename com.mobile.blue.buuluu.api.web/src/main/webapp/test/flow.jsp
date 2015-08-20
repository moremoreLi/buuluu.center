<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>CARTIER API JSP</title>
</head>
<Body>
<form name="EventForm" action="../getFoundList.do" method="post">
		<h2>API getFoundList.do</h2>
		lang:<input name="lang" type="text"/>
		device:<input name="device" type="text"/>
		deviceVerNum:<input name="deviceVerNum" type="text"/>
		imei:<input name="imei" type="text"/>
		mac:<input name="mac" type="text"/>
		imsi:<input name="imsi" type="text"/>
		userId:<input name="userId" type="text"/>
		token:<input name="token" type="text"/>
		<input type="submit" style="width: 200px" value="getFoundList"/>
</form>

<form name="EventForm" action="../getAds.do" method="post">
		<h2>API getAds.do</h2>
		lang:<input name="lang" type="text"/>
		device:<input name="device" type="text"/>
		deviceVerNum:<input name="deviceVerNum" type="text"/>
		imei:<input name="imei" type="text"/>
		mac:<input name="mac" type="text"/>
		imsi:<input name="imsi" type="text"/>
		userId:<input name="userId" type="text"/>
		token:<input name="token" type="text"/>
		type:<input name="type" type="text"/>
		<input type="submit" style="width: 200px" value="getAds"/>
</form>

<form name="EventForm" action="../getAdsList.do" method="post">
		<h2>API getAdsList.do</h2>
		lang:<input name="lang" type="text"/>
		device:<input name="device" type="text"/>
		deviceVerNum:<input name="deviceVerNum" type="text"/>
		imei:<input name="imei" type="text"/>
		mac:<input name="mac" type="text"/>
		imsi:<input name="imsi" type="text"/>
		userId:<input name="userId" type="text"/>
		token:<input name="token" type="text"/>
		type:<input name="type" type="text"/>
		pageNo:<input name="pageNo" type="text"/>
		<input type="submit" style="width: 200px" value="getAdsList"/>
</form>


<form name="EventForm" action="../getAdsDetail.do" method="post">
		<h2>API getAdsDetail.do</h2>
		lang:<input name="lang" type="text"/>
		device:<input name="device" type="text"/>
		deviceVerNum:<input name="deviceVerNum" type="text"/>
		imei:<input name="imei" type="text"/>
		mac:<input name="mac" type="text"/>
		imsi:<input name="imsi" type="text"/>
		userId:<input name="userId" type="text"/>
		token:<input name="token" type="text"/>
		type:<input name="type" type="text"/>
		sourceId:<input name="sourceId" type="text"/>
		<input type="submit" style="width: 200px" value="getAdsDetail"/>
</form>

<form name="EventForm" action="../getAdFristList.do" method="post">
		<h2>API getAdFristList.do</h2>
		lang:<input name="lang" type="text"/>
		device:<input name="device" type="text"/>
		deviceVerNum:<input name="deviceVerNum" type="text"/>
		imei:<input name="imei" type="text"/>
		mac:<input name="mac" type="text"/>
		imsi:<input name="imsi" type="text"/>
		userId:<input name="userId" type="text"/>
		token:<input name="token" type="text"/>
		<input type="submit" style="width: 200px" value="getAdFristList"/>
</form>

<form name="EventForm" action="../getGreatAdsList.do" method="post">
		<h2>API getGreatAdsList.do</h2>
		lang:<input name="lang" type="text"/>
		device:<input name="device" type="text"/>
		deviceVerNum:<input name="deviceVerNum" type="text"/>
		imei:<input name="imei" type="text"/>
		mac:<input name="mac" type="text"/>
		imsi:<input name="imsi" type="text"/>
		userId:<input name="userId" type="text"/>
		token:<input name="token" type="text"/>
		pageNo:<input name="pageNo" type="text"/>
		<input type="submit" style="width: 200px" value="getGreatAdsList"/>
</form>

<form name="EventForm" action="../getFlowCoins.do" method="post">
		<h2>API getFlowCoins.do</h2>
		lang:<input name="lang" type="text"/>
		device:<input name="device" type="text"/>
		deviceVerNum:<input name="deviceVerNum" type="text"/>
		imei:<input name="imei" type="text"/>
		mac:<input name="mac" type="text"/>
		imsi:<input name="imsi" type="text"/>
		userId:<input name="userId" type="text"/>
		token:<input name="token" type="text"/>
		sourceId:<input name="sourceId" type="text"/>
		type:<input name="type" type="text"/>
		<input type="submit" style="width: 200px" value="getFlowCoins"/>
</form>

<form name="EventForm" action="../getCoinsDetail.do" method="post">
		<h2>API getCoinsDetail.do</h2>
		lang:<input name="lang" type="text"/>
		device:<input name="device" type="text"/>
		deviceVerNum:<input name="deviceVerNum" type="text"/>
		imei:<input name="imei" type="text"/>
		mac:<input name="mac" type="text"/>
		imsi:<input name="imsi" type="text"/>
		userId:<input name="userId" type="text"/>
		token:<input name="token" type="text"/>
		billingId:<input name="billingId" type="text"/>
		<input type="submit" style="width: 200px" value="getCoinsDetail"/>
</form>

<form name="EventForm" action="../useCoins.do" method="post">
		<h2>API useCoins.do</h2>
		lang:<input name="lang" type="text"/>
		device:<input name="device" type="text"/>
		deviceVerNum:<input name="deviceVerNum" type="text"/>
		imei:<input name="imei" type="text"/>
		mac:<input name="mac" type="text"/>
		imsi:<input name="imsi" type="text"/>
		userId:<input name="userId" type="text"/>
		token:<input name="token" type="text"/>
		billingId:<input name="billingId" type="text"/>
		flowCoins:<input name="flowCoins" type="text"/>
		userCoin:<input name="userCoin" type="text"/>
		sourceName:<input name="sourceName" type="text"/>
		<input type="submit" style="width: 200px" value="useCoins"/>
</form>

<form name="EventForm" action="../requestCoins.do" method="post">
		<h2>API requestCoins.do</h2>
		lang:<input name="lang" type="text"/>
		device:<input name="device" type="text"/>
		deviceVerNum:<input name="deviceVerNum" type="text"/>
		imei:<input name="imei" type="text"/>
		mac:<input name="mac" type="text"/>
		imsi:<input name="imsi" type="text"/>
		userId:<input name="userId" type="text"/>
		token:<input name="token" type="text"/>
		type:<input name="type" type="text"/>
		<input type="submit" style="width: 200px" value="requestCoins"/>
</form>

<form name="EventForm" action="../getBillList.do" method="post">
		<h2>API getBillList.do</h2>
		lang:<input name="lang" type="text"/>
		device:<input name="device" type="text"/>
		deviceVerNum:<input name="deviceVerNum" type="text"/>
		imei:<input name="imei" type="text"/>
		mac:<input name="mac" type="text"/>
		imsi:<input name="imsi" type="text"/>
		userId:<input name="userId" type="text"/>
		token:<input name="token" type="text"/>
		pageNo:<input name="pageNo" type="text"/>
		type:<input name="type" type="text"/>
		<input type="submit" style="width: 200px" value="getBillList"/>
</form>

<form name="EventForm" action="../getDownloadList.do" method="post">
		<h2>API getDownloadList.do</h2>
		lang:<input name="lang" type="text"/>
		device:<input name="device" type="text"/>
		deviceVerNum:<input name="deviceVerNum" type="text"/>
		imei:<input name="imei" type="text"/>
		mac:<input name="mac" type="text"/>
		imsi:<input name="imsi" type="text"/>
		userId:<input name="userId" type="text"/>
		token:<input name="token" type="text"/>
		<input type="submit" style="width: 200px" value="getDownloadList"/>
</form>

<form name="EventForm" action="../getDownloadNextList.do" method="post">
		<h2>API getDownloadNextList.do</h2>
		lang:<input name="lang" type="text"/>
		device:<input name="device" type="text"/>
		deviceVerNum:<input name="deviceVerNum" type="text"/>
		imei:<input name="imei" type="text"/>
		mac:<input name="mac" type="text"/>
		imsi:<input name="imsi" type="text"/>
		userId:<input name="userId" type="text"/>
		token:<input name="token" type="text"/>
		pageNo:<input name="pageNo" type="text"/>
		<input type="submit" style="width: 200px" value="getDownloadNextList"/>
</form>

<form name="EventForm" action="../getScratchList.do" method="post">
		<h2>API getScratchList.do</h2>
		lang:<input name="lang" type="text"/>
		device:<input name="device" type="text"/>
		deviceVerNum:<input name="deviceVerNum" type="text"/>
		imei:<input name="imei" type="text"/>
		mac:<input name="mac" type="text"/>
		imsi:<input name="imsi" type="text"/>
		userId:<input name="userId" type="text"/>
		token:<input name="token" type="text"/>
		<input type="submit" style="width: 200px" value="getDownloadNextList"/>
</form>

<form name="EventForm" action="../getScratchCoins.do" method="post">
		<h2>API getScratchCoins.do</h2>
		lang:<input name="lang" type="text"/>
		device:<input name="device" type="text"/>
		deviceVerNum:<input name="deviceVerNum" type="text"/>
		imei:<input name="imei" type="text"/>
		mac:<input name="mac" type="text"/>
		imsi:<input name="imsi" type="text"/>
		userId:<input name="userId" type="text"/>
		token:<input name="token" type="text"/>
		scratchId:<input name="scratchId" type="text"/>
		<input type="submit" style="width: 200px" value="getScratchCoins"/>
</form>


<form name="EventForm" action="../getFlowPkg.do" method="post">
		<h2>API getFlowPkg.do</h2>
		lang:<input name="lang" type="text"/>
		device:<input name="device" type="text"/>
		deviceVerNum:<input name="deviceVerNum" type="text"/>
		imei:<input name="imei" type="text"/>
		mac:<input name="mac" type="text"/>
		imsi:<input name="imsi" type="text"/>
		userId:<input name="userId" type="text"/>
		token:<input name="token" type="text"/>
		<input type="submit" style="width: 200px" value="getFlowPkg"/>
</form>

<form name="EventForm" action="../getFarVideo.do" method="post">
		<h2>API getFarVideo.do</h2>
		lang:<input name="lang" type="text"/>
		device:<input name="device" type="text"/>
		deviceVerNum:<input name="deviceVerNum" type="text"/>
		imei:<input name="imei" type="text"/>
		mac:<input name="mac" type="text"/>
		imsi:<input name="imsi" type="text"/>
		userId:<input name="userId" type="text"/>
		token:<input name="token" type="text"/>
		<input type="submit" style="width: 200px" value="getFarVideo"/>
</form>

<form name="EventForm" action="../getFarApp.do" method="post">
		<h2>API getFarApp.do</h2>
		lang:<input name="lang" type="text"/>
		device:<input name="device" type="text"/>
		deviceVerNum:<input name="deviceVerNum" type="text"/>
		imei:<input name="imei" type="text"/>
		mac:<input name="mac" type="text"/>
		imsi:<input name="imsi" type="text"/>
		userId:<input name="userId" type="text"/>
		token:<input name="token" type="text"/>
		<input type="submit" style="width: 200px" value="getFarApp"/>
</form>


<form name="EventForm" action="../getGameList.do" method="post">
		<h2>API getGameList.do</h2>
		lang:<input name="lang" type="text"/>
		device:<input name="device" type="text"/>
		deviceVerNum:<input name="deviceVerNum" type="text"/>
		imei:<input name="imei" type="text"/>
		mac:<input name="mac" type="text"/>
		imsi:<input name="imsi" type="text"/>
		userId:<input name="userId" type="text"/>
		token:<input name="token" type="text"/>
		<input type="submit" style="width: 200px" value="getGameList"/>
</form>

<form name="EventForm" action="../vistorLogin.do" method="post">
		<h2>API vistorLogin.do</h2>
		lang:<input name="lang" type="text"/>
		device:<input name="device" type="text"/>
		deviceVerNum:<input name="deviceVerNum" type="text"/>
		imei:<input name="imei" type="text"/>
		mac:<input name="mac" type="text"/>
		imsi:<input name="imsi" type="text"/>
		<input type="submit" style="width: 200px" value="vistorLogin"/>
</form>
</BODY>
</html>