<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<c:set var="APP_PATH" value="${pageContext.request.contextPath }" scope="request"/>
<meta charset="UTF-8">
<title>员工列表</title>
<link href="${requestScope.APP_PATH}/static/css/bootstrap.min.css" rel="stylesheet">

<script src="${requestScope.APP_PATH}/static/js/jquery-3.4.1.min.js"></script>
<script src="${requestScope.APP_PATH}/static/js/bootstrap.min.js"></script>
<script type="text/javascript">
$(function(){	
	$("#emp_add_btn").click(function(){	
		$('#empAddModal').modal({
			backdrop: "static"
		})
	})	
})

</script>
</head>
<body>
<!-- 员工添加模态框 -->
<!-- Modal -->
<div class="modal fade" id="empAddModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">添加员工</h4>
      </div>
      <div class="modal-body">
        <form class="form-horizontal">
		  <div class="form-group">
		    <label for="empName" class="col-sm-2 control-label">姓名：</label>
		    <div class="col-sm-10">
		      <input type="text" class="form-control" name="empName" placeholder="empName">
		    </div>
		  </div>
		  
		
		  <div class="form-group">
		    <label for="text" class="col-sm-2 control-label">性别：</label>
		      <div class="col-sm-10">
		      	<label class="radio-inline">
				  <input type="radio" name="gender" id="inlineRadio1" value="option1"> 男
				</label>
				<label class="radio-inline">
				  <input type="radio" name="gender" id="inlineRadio2" value="option2"> 女
				</label>			   
			  </div>
		  </div>
		  
		  
		  <div class="form-group">
		    <label for="text" class="col-sm-2 control-label">邮箱：</label>
		    <div class="col-sm-10">
		      <input type="email" class="form-control" name="empEmail" placeholder="邮箱">
		    </div>
		  </div>
		   <div class="form-group">
		    <label for="text" class="col-sm-2 control-label">部门：</label>
		    <div class="col-sm-4">
				<select class="form-control" name="deptId">
				  <option>1</option>
				 
				</select>
		    </div>
		  </div>
		</form>       
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
        <button type="button" class="btn btn-primary">保存</button>
      </div>
    </div>
  </div>
</div>
<div class="container">
	<!-- 标题层 -->
	<div class="row">
		<div class="col-md-12">
			<h1>员工信息管理</h1>
		</div>
	</div>

	<div class="row">
		<div class="col-md-4 col-md-offset-8">
			<button class="btn btn-primary"  id="emp_add_btn">新增</button>
			<button class="btn btn-danger">批量删除</button>
		</div>
	</div>
	<div class="row">
		<table class="table table-hover">
			<tr>
				<th><input type="checkbox">全选</th>
				<th>列表</th>
				<th>姓名</th>
				<th>性别</th>
				<th>电子邮箱</th>
				<th>部门</th>
				<th>操作</th>
			</tr>
			<c:forEach  var="emp"   items="${PageInfo.list}" varStatus="s" >
				<tr>
					<td><input type="checkbox"></td>
					<td>${s.index+1}</td>		
					<td>${emp.empName}</td>
					<td>${emp.gender=='M'?"男":"女"}</td>
					<td>${emp.email}</td>
					<td>${emp.department.deptName}</td>							
					<td>
						<button class="btn btn-primary btn-sm">
							<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
							编辑
						</button>
						<button class="btn btn-danger btn-sm">
						    <span class="glyphicon glyphicon-trash" aria-hidden="true"></span>					
							删除
						</button>
					</td>
				</tr>			
			</c:forEach>
			
		</table>
	
	</div>
	<div class="row">
		<div class="col-md-6">
			共   ${PageInfo.total}条记录，共${PageInfo.pages} 页，当前第${PageInfo.pageNum }页
		
		</div>
		<div class="col-md-6">
			<nav aria-label="Page navigation">
			  <ul class="pagination">
			 	<li><a href="${APP_PATH}/emp/list?pageNum=1">首页</a></li>
			 	<c:if test="${PageInfo.hasPreviousPage }">
			 		  <li>
					      <a href="${APP_PATH}/emp/list?pageNum=${PageInfo.pageNum-1}" aria-label="Previous">
					        <span aria-hidden="true">&laquo;</span>
					      </a>
					  </li>
			 	</c:if>
			 	
			  
			    <c:forEach items="${PageInfo.navigatepageNums}" var="num">
			    	 <c:if test="${num==PageInfo.pageNum }">
			    	 	<li class="active"><a href="${APP_PATH}/emp/list?pageNum=${num}">${num}</a></li>
			    	 </c:if>
			    	  <c:if test="${num!=PageInfo.pageNum }">
			    	 	<li><a href="${APP_PATH}/emp/list?pageNum=${num}">${num}</a></li>
			    	 </c:if>			    	 
			    </c:forEach>
			    			   
			    
			    <c:if test="${PageInfo.hasNextPage }">
			 		  <li>
					      <a href="${APP_PATH}/emp/list?pageNum=${PageInfo.pageNum+1}" aria-label="Next">
					        <span aria-hidden="true">&raquo;</span>
					      </a>
					  </li>
			 	</c:if>
			    <li><a href="${APP_PATH}/emp/list?pageNum=${PageInfo.pages}">尾页</a></li>
			  </ul>
			</nav>
		
		</div>
	</div>
</div>

</body>
</html>