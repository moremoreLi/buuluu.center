<%@page import="com.user.buuluu.common.util.CodeStatus,com.user.buuluu.web.view.ResultVO,com.user.buuluu.common.util.Json,org.apache.commons.lang.math.NumberUtils"%>
<%@ page language="java" contentType="application/json; charset=UTF-8" pageEncoding="UTF-8" isErrorPage="true" %>
<%
	String viewName = com.user.buuluu.web.controller.WebHandlerExceptionResolver.getErrorInfo(request,response,exception);

Object errorCode = request.getAttribute(com.user.buuluu.web.controller.WebHandlerExceptionResolver.ERROR_CODE_PARAMETER_NAME);
Object errorMessage = request.getAttribute(com.user.buuluu.web.controller.WebHandlerExceptionResolver.ERROR_MESSAGE_PARAMETER_NAME);

ResultVO<Object> result = new ResultVO<Object>();
result.setErrorCode(NumberUtils.toInt(String.valueOf(errorCode), CodeStatus.UNKNOWN));
result.setErrorMessage(String.valueOf(errorMessage));
result.setResult(null);

request.setAttribute("message", Json.toJson(result));
%>
<%@include file="message.json.jsp" %>
