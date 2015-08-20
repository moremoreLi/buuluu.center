<%@page import="com.mobile.blue.buuluu.api.common.util.CodeStatus,com.mobile.blue.buuluu.api.web.view.ResultVO,com.mobile.blue.buuluu.api.common.util.Json,org.apache.commons.lang.math.NumberUtils"%>
<%@ page language="java" contentType="application/json; charset=UTF-8" pageEncoding="UTF-8" isErrorPage="true" %>
<%
	String viewName = com.mobile.blue.buuluu.api.web.controller.WebHandlerExceptionResolver.getErrorInfo(request,response,exception);

Object errorCode = request.getAttribute(com.mobile.blue.buuluu.api.web.controller.WebHandlerExceptionResolver.ERROR_CODE_PARAMETER_NAME);
Object errorMessage = request.getAttribute(com.mobile.blue.buuluu.api.web.controller.WebHandlerExceptionResolver.ERROR_MESSAGE_PARAMETER_NAME);

ResultVO<Object> result = new ResultVO<Object>();
result.setStatus(errorCode+"");
result.setErrorMessage("");
result.setResult(null);

request.setAttribute("message", Json.toJson(result));
%>
<%@include file="message.json.jsp" %>
