<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>新闻资讯</title>
<c:set var="APP_PATH" value="${pageContext.request.contextPath }" scope="request"/>
<link href="${requestScope.APP_PATH}/static/css/bootstrap.min.css" rel="stylesheet">
<script src="${requestScope.APP_PATH}/static/js/bootstrap.min.js"></script>
<script src="${requestScope.APP_PATH}/static/js/jquery-3.4.1.min.js"></script>
<script type="text/javascript">
$(function(){
	$("#add_btn").click(function(){
		alert("************")
		$("#myModal").modal({
			backdrop: "static"
		})
	})
	
})
</script>
</head>
<body>
<!-- Button trigger modal -->
<button type="button" class="btn btn-primary btn-lg" id="add_btn" data-toggle="modal" data-target="#myModal">
  Launch demo modal
</button>

<!-- Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">Modal title</h4>
      </div>
      <div class="modal-body">
        ...
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary">Save changes</button>
      </div>
    </div>
  </div>
</div>
</body>
</html>