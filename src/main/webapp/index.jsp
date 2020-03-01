<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<%
        pageContext.setAttribute("APP_PATH", "http://localhost:8080"+request.getContextPath());
		pageContext.setAttribute("IMG_PATH", "http://localhost:8080/photomanagement/photo/");
    %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>照片管理</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" rel="stylesheet">
	<!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
	<script src="https://cdn.jsdelivr.net/npm/jquery@1.12.4/dist/jquery.min.js"></script>
	<!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js"></script>
	<script src="http://malsup.github.com/jquery.form.js"></script>
	<style type="text/css">
		.imgsize{
             width:200px;
             height:200px;
        }
        .list li {
            float: left;
            display: inline;
            margin: 5px;
        }
        .p{
            text-align:center;
        }
        .click {
        }
        .redBorder{
            background:#F00; color:#FFF;
        }
	</style>
</head>
<body>
	<div class="container-fluid">
		<div class="row">
		  <div class="col-md-12"><em><h1>照片管理网站</h1></em></div>
		</div>
		<div class="row">
		  <div class="col-md-2 col-md-offset-10">
		  	 <button type="button" class="btn btn-info" data-toggle="modal" data-target="#myModal">添加</button>
		  	 <button type="button" class="btn btn-info" onClick="changeMethod()">修改</button>
             <button class="btn btn-danger" onClick="deleteMethod()">删除</button>
           </div>
		</div>
		<!-- 修改Modal -->
		<div class="modal fade" id="changeModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
		  <div class="modal-dialog" role="document">
		    <div class="modal-content">
		      <div class="modal-header">
		        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
		        <h4 class="modal-title" id="myModalLabel">修改信息</h4>
		      </div>
		      <div class="modal-body">
		        <form class="form-horizontal" id="changeform" action="${APP_PATH}/photo" method="put" enctype="multipart/form-data" οnsubmit="submitForm();">
					  <div class="form-group">
					    <label for="exampleInputEmail1">图片所在分组：</label>
					    <input id="groupname" name="gname"type="text" class="form-control"  placeholder="输入图片所在分组名或新建分组">
					  </div>
					  <div class="form-group">
					    <label for="exampleInputEmail1">图片名字：</label>
					    <input id="phname" name="photoname" type="text" class="form-control" placeholder="输入图片所在分组名或新建分组">
					  </div>
				</form>
		      </div>
		      <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                <button type="button" class="btn btn-primary" id="photo_update_btn">修改</button>
            </div>
		    </div>
		  </div>
		</div>
		<!-- 添加Modal -->
		<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
		  <div class="modal-dialog" role="document">
		    <div class="modal-content">
		      <div class="modal-header">
		        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
		        <h4 class="modal-title" id="myModalLabel">上传照片</h4>
		      </div>
		      <div class="modal-body">
		        <form class="form-horizontal" id="form" action="${APP_PATH}/photo" method="post" enctype="multipart/form-data" οnsubmit="submitForm();">
					  <div class="form-group">
					    <label for="exampleInputEmail1">图片所在分组：</label>
					    <input name="gname" type="text" class="form-control" id="exampleInputEmail1" placeholder="输入图片所在分组名或新建分组">
					  </div>
					  <div class="form-group">
					    <label for="exampleInputEmail1">图片名字：</label>
					    <input name="name" type="text" class="form-control" id="exampleInputEmail1" placeholder="输入图片所在分组名或新建分组">
					  </div>
					  <div class="form-group">
					    <label for="exampleInputFile">选择文件</label>
					    <input type="file" id="photo" name="upload">
					    <p class="help-block">选择图片上传</p>
					  </div> 
				    <!-- <input type="submit" value="上传"/> -->
				    <button id ="submit" type="submit" class="btn btn-default">上传</button>
				</form>
		      </div>
		    </div>
		  </div>
		</div>
		<!-- 照片列表 -->
		<div class="row">
		  	<div class="col-md-12">
		  		<ul class="list" id="ul"></ul>
		  	</div>
		</div>
		<!-- 分页信息 -->
		<div class="row">
		
	        <div class="col-md-6" id="page_info_area"></div>
	        <div class="col-md-3 col-md-offset-9" id="page_nav_area"></div>
	    </div>
		<div class="row">
		  <div class="col-md-12">
		  	<div class="text-center"><h4><b>Written by DQ<br>2020.2.25</b></h4></div>
		  </div>
		</div>
	</div>
</body>
<script type="text/javascript">
	var check="";//记录想要处理的照片数据
	var current_page;
	var flag=1;//记录状态，修改状态和删除状态
	
	$(function(){
		to_page(1);
	});
	function to_page(pn) {
        $.ajax({
            url: "${APP_PATH}/photo",
            data:"pn="+pn,
            type: "GET",
            success: function (result) {
            	build_photo_list(result);
            	build_page_info(result);
                build_page_nav(result);
            }
        });
    }
	/**
     * 显示照片信息
     * @param result
     */
	function build_photo_list(result){
		var photo=result.map.pageInfo.list;
		var lists=$("#ul");
		lists.empty();
		$.each(photo,function(index,item){
			var img=$("<img alt=\"Responsive image\" class=\"img-thumbnail imgsize\">");
			img.attr("src","${IMG_PATH}"+item.path);
			var div=$("<div class=\"click\"></div>").append(img).append("<div class=\"p\"><b>"+item.photoname+"</b></div>");
			div.attr("id",item.photoid);
			var li=$("<li></li>").append(div);
			lists.append(li);
		});
	}
	/**
     * 解析显示分页信息
     * @param result
     */
    function build_page_info(result) {
        $("#page_info_area").empty();
        $("#page_info_area").append("<h4><b>当前第"
            + result.map.pageInfo.pageNum
            + "页,总共"
            + result.map.pageInfo.pages
            + "页,总共有"
            + result.map.pageInfo.total
            + "条记录</b></h4>");
           current_page=result.map.pageInfo.pageNum;
    }
	/**
     * 解析显示分页条
     * @param result
     */
    function build_page_nav(result) {
        $("#page_nav_area").empty();
        var ul = $("<ul></ul>").addClass("pagination");
        var firstPageLi = $("<li></li>")
            .append($("<a></a>").append("首页").attr("href", "#"));
        var prePageLi = $("<li></li>")
            .append($("<a></a>").append("&laquo;"));
        if (!result.map.pageInfo.hasPreviousPage) {
            firstPageLi.addClass("disabled");
            prePageLi.addClass("disabled");
        } else {
            firstPageLi.click(function () {
                to_page(1);
            });
            prePageLi.click(function () {
                to_page(result.map.pageInfo.pageNum - 1);
            });
        }
        var nextPageLi = $("<li></li>")
            .append($("<a></a>").append("&raquo;"));
        var lastPageLi = $("<li></li>")
            .append($("<a></a>").append("尾页").attr("href", "#"));
        if (!result.map.pageInfo.hasNextPage) {
            lastPageLi.addClass("disabled");
            nextPageLi.addClass("disabled");
        } else {
            lastPageLi.click(function () {
                to_page(result.map.pageInfo.pages);
            });
            nextPageLi.click(function () {
                to_page(result.map.pageInfo.pageNum + 1);
            });
        }
        ul.append(firstPageLi).append(prePageLi);
        $.each(result.map.pageInfo.navigatepageNums, function (index, item) {
            var numLi = $("<li></li>")
                .append($("<a></a>").append(item));
            if (result.map.pageInfo.pageNum == item) {
                numLi.addClass("active");
            }
            numLi.click(function () {
                to_page(item)
            });
            ul.append(numLi);
        });
        ul.append(nextPageLi).append(lastPageLi);
        var navEle = $("<nav></nav>").append(ul);
        $("#page_nav_area").append(navEle);
    }
    /**
     * 提交上传文件数据
     */
    $(document).ready(function() {
        $('#form').ajaxForm(function(result) {
            alert(result.msg);
            $("#myModal").modal('hide');
            to_page(current_page);
        });
    });
    /**
    *照片多选删除或者修改选中
    */
    $("#ul").on("click",".click",function () {
        if(flag==1){//修改状态
        	check=$(this).attr("id");
        	getEmp($(this).attr("id"));
        	$("#changeModal").modal({
                backdrop: "static"
            });
        }else{//删除状态
        	$(this).toggleClass("redBorder");
            check=check+($(this).attr("id"))+"-";
        }
    });
    //获取照片信息并设置修改模态框
    function getEmp(id) {
        $.ajax({
            url: "${APP_PATH}/photo/" + id,
            type: "GET",
            success: function (result) {
                //console.log(result);
                var data = result.map.photo;
                $("#phname").val(data.photoname);
                $("#groupname").val(data.gname);
            }
        });
    }
    /**
    *提交删除照片数据
    */
    function deleteMethod(){
    	if(flag==0){
    		if(confirm("确认删除已选择图片吗？")){
        		check=check.substring(0,check.length-1);
        		$.ajax({
        			url:"${APP_PATH}/photo/"+check,
        			type:"delete",
        			success:function(result){
        				alert(result.msg);
        				to_page(current_page);
        				check="";
        			}
        		});
        	}
    	}else{
    		flag=0;
    		alert("您已进入删除模式，点击下方图片可以选中（可以多选），再次点击删除按钮即可删除图片");
    	}
    }
	function changeMethod(){
		if(flag==1){
			alert("您已经在修改模式，点击图片即可以修改图片信息！");
		}else{
			flag=1;
			alert("您已进入修改模式，点击图片即可以修改图片信息！");
		}
	}
	$("#photo_update_btn").click(function(){
		if(confirm("确认提交吗？")){
     		$.ajax({
     			url:"${APP_PATH}/photo/"+check,
     			type:"put",
     			data:$("#changeModal form").serialize(),
     			success:function(result){
     				alert(result.msg);
     	            $("#changeModal").modal('hide');
     	            to_page(current_page);
     			}
     		});
     	}
	});
</script>
</html>
