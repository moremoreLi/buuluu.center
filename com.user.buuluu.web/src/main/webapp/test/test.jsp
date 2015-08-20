<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>CARTIER API JSP</title>
</head>
<Body>
<!-- 1 -->
<form name="EventForm" action="../test.do" method="post">
		<h2>API test</h2>
		<input type="submit" style="width: 200px" value="Test"/>
</form>

<form name="EventForm" action="../login.do" method="post">
		<h2>API login.do</h2>
		p:<input name="p" type="text"/>
		<input type="submit" style="width: 200px" value="login"/>
</form>

<form name="EventForm" action="../login2.do" method="post">
		<h2>API login2.do</h2>
		userId:<input name="userId" type="text"/>
		session:<input name="session" type="text"/>
		loginType:<input name="loginType" type="text"/>
		lang:<input name="lang" type="text"/>
		<input type="submit" style="width: 200px" value="login2"/>
</form>

<form name="EventForm" action="../uploadDB.do" method="post"  enctype="multipart/form-data">
		<h2>API uploadDB.do</h2>
		userId:<input name="userId" type="text"/>
		session:<input name="session" type="text"/>
		lang:<input name="lang" type="text"/>
		appDbPath:<input type="file" id="appDbPath" name="icon">
		device:<input name="device" type="text"/>
		deviceVerNum:<input name="deviceVerNum" type="text" />
		<input type="submit" style="width: 200px" value="uploadDB"/>
</form>

<form name="EventForm" action="../updateStatistics.do" method="post">
		<h2>API updateStatistics.do</h2>
		<input type="submit" style="width: 200px" value="updateStatistics"/>
</form>

<form name="EventForm" action="../updateUserSteps.do" method="post">
		<h2>API updateUserSteps.do</h2>
		userId:<input name="userId" type="text"/>
		session:<input name="session" type="text"/>
		lang:<input name="lang" type="text"/>
		device:<input name="device" type="text"/>
		deviceVerNum:<input name="deviceVerNum" type="text" />
		steps:<input name="steps" type="text" />
		<input type="submit" style="width: 200px" value="updateUserStepss"/>
</form>
<form name="EventForm" action="../downloadDB.do" method="post"  enctype="multipart/form-data">
		<h2>API downloadDB.do</h2>
		userId:<input name="userId" type="text"/>
		session:<input name="session" type="text"/>
		dbName：<input name="dbName" type="text"/>
		lang:<input name="lang" type="text"/>
		device:<input name="device" type="text"/>
		deviceVerNum:<input name="deviceVerNum" type="text" />
		<input type="submit" style="width: 200px" value="downloadDB"/>
</form>

<form name="EventForm" action="../heartbeatCheck.do" method="post">
		<h2>API heartbeatCheck.do</h2>
		<input type="submit" style="width: 200px" value="Test"/>
</form>

<form name="EventForm" action="../uploadFile.do" method="post" enctype="multipart/form-data">
		<h2>API uploadFile</h2>
		userId:<input name="userId" type="text" style="width:150px"/>
		file:<input type="file" id="file" name="file">
		<input type="submit" style="width: 200px" value="uploadFile"/>
</form>

<form name="EventForm" action="../updateStatisticsData.do" method="post">
		<h2>API updateStatisticsData.do</h2>
		lang:<input name="lang" type="text" style="width:50px"/>
		device:<input name="device" type="text" style="width:50px"/>
		deviceVerNum:<input name="deviceVerNum" type="text" style="width:50px"/>
		userId:<input name="userId" type="text" style="width:200px"/>
		session:<input name="session" type="text" style="width:200px"/>
		allSteps:<input name="allSteps" type="text" />
		allHours:<input name="allHours" type="text" />
		allKiloMeters:<input name="allKiloMeters" type="text" />
		allCalories:<input name="allCalories" type="text" />
		blindStatus:<input name="blindStatus" type="text" />
		p:<input name="p" type="text" />
		<input type="submit" style="width: 200px" value="updateStatisticsData"/>
</form>

<form name="EventForm" action="../saveSleepDailyData.do" method="post">
		<h2>API saveSleepDailyData.do</h2>
		lang:<input name="lang" type="text" style="width:50px"/>
		device:<input name="device" type="text" style="width:50px"/>
		deviceVerNum:<input name="deviceVerNum" type="text" style="width:50px"/>
		userId:<input name="userId" type="text" style="width:200px"/>
		session:<input name="session" type="text" style="width:200px"/>
		p:<input name="p" type="text" />
		<input type="submit" style="width: 200px" value="saveSleepDailyData"/>
</form>

<form name="EventForm" action="../getLatestSleepDailyDataTime.do" method="post">
		<h2>API getLatestSleepDailyDataTime.do</h2>
		lang:<input name="lang" type="text" style="width:50px"/>
		device:<input name="device" type="text" style="width:50px"/>
		deviceVerNum:<input name="deviceVerNum" type="text" style="width:50px"/>
		userId:<input name="userId" type="text" style="width:200px"/>
		session:<input name="session" type="text" style="width:200px"/>
		<input type="submit" style="width: 200px" value="getLatestSleepDailyDataTime"/>
</form>

<form name="EventForm" action="../sendEmail.do" method="post" >
		<h2>API sendEmail.do</h2>
		toName:<input name="toName" type="text"/>
		toEmail:<input name="toEmail" type="text" />
		emailTitle:<input name="emailTitle" type="text"/>
		emailContent :<input name="emailContent" type="text"/>
		attachFileName:<input name="attachFileName" type="text"/>
		cc:<input name="cc" type="text"/>
		bcc:<input name="bcc" type="text"/>
		<input type="submit" style="width: 100px" value="sendEmail"/>
</form>

<form name="EventForm" action="../placingOrder.do" method="post" >
		<h2>API placingOrder.do</h2>
		json:<input name="json" type="text"/>
		<input type="submit" style="width: 100px" value="placingOrder"/>
</form>

<form name="EventForm" action="../deleteRouteTracking.do" method="post" >
		<h2>API deleteRouteTracking.do</h2>
		lang:<input name="lang" type="text"/>
		device:<input name="device" type="text"/>
		deviceVerNum:<input name="deviceVerNum" type="text"/>
		userId:<input name="userId" type="text"/>
		session:<input name="session" type="text"/>
		buId:<input name="buId" type="text"/>
		<input type="submit" style="width: 200px" value="deleteRouteTracking"/>
</form> 
<!--  
<form name="EventForm" action="../deleteRouteTrackingPoint.do" method="post" >
		<h2>API deleteRouteTrackingPoint.do</h2>
		lang:<input name="lang" type="text"/>
		device:<input name="device" type="text"/>
		deviceVerNum:<input name="deviceVerNum" type="text"/>
		userId:<input name="userId" type="text"/>
		session:<input name="session" type="text"/>
		buId:<input name="buId" type="text" />
		indexId:<input name="indexId" type="text" />
		<input type="submit" style="width: 200px" value="deleteRouteTrackingPoint"/>
</form>
-->
<form name="EventForm" action="../getRouteTracking.do" method="post" >
		<h2>API getRouteTracking.do</h2>
		lang:<input name="lang" type="text"/>
		device:<input name="device" type="text"/>
		deviceVerNum:<input name="deviceVerNum" type="text"/>
		userId:<input name="userId" type="text"/>
		session:<input name="session" type="text"/>
		pageNum:<input name="pageNum" type="text" />
		pageSize:<input name="pageSize" type="text" />
		<input type="submit" style="width: 100px" value="getRouteTracking"/>
</form>
<form name="EventForm" action="../uploadRouteTracking.do" method="post" enctype="multipart/form-data">
		<h2>API uploadRouteTracking.do</h2>
		lang:<input name="lang" type="text" style="width:100px" maxlength="8"/>
		device:<input name="device" type="text" style="width:100px" maxlength="2"/>
		deviceVerNum:<input name="deviceVerNum" type="text" style="width:100px" maxlength="10"/>
		userId:<input name="userId" type="text" style="width:200px" maxlength="50"/>
		session:<input name="session" type="text" style="width:200px" maxlength="50"/><br/>
		filePath:
		<input type="text" style="width: 240px;"  id="f_file" readonly="readonly"><input type="button" value="Browse..." onClick="document.getElementById('t_file').click()">
		<input name="fileName" type="file" id="t_file" onchange="document.getElementById('f_file').value=this.value" style="display:none">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<input type="submit" style="width: 150px" value="uploadRouteTracking"/>
</form>
<form name="EventForm" action="../addRouteTracking.do" method="post" >
		<h2>API addRouteTracking.do</h2>
		lang:<input name="lang" type="text" style="width:50px" maxlength="8"/>
		device:<input name="device" type="text" style="width:50px" maxlength="2"/>
		deviceVerNum:<input name="deviceVerNum" type="text" style="width:50px" maxlength="10"/>
		userId:<input name="userId" type="text" style="width:150px" maxlength="50"/>
		session:<input name="session" type="text" style="width:150px" maxlength="50"/>
		<br/>
		p:<input name="p" type="text" style="width:600px" maxlength="1000"/>
		<input type="submit" style="width: 150px" value="addRouteTracking"/>
</form>

<form name="EventForm" action="../getFirmwareInfo.do" method="post" >
		<h2>API getFirmwareInfo.do</h2>
		type:<input name="type" type="text" style="width:50px" maxlength="8"/>
		<input type="submit" style="width: 150px" value="getFirmwareInfo"/>
</form>
</BODY>
</html>