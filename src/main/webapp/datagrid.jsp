<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>datagrid数据表格</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<!-- 引入JQuery -->
   <script type="text/javascript" src="<%=path %>/jquery-easyui-1.5/jquery.min.js"></script>
   <!-- 引入EasyUI -->
   <script type="text/javascript" src="<%=path %>/jquery-easyui-1.5/jquery.easyui.min.js"></script>
   <!-- 引入EasyUI的中文国际化js，让EasyUI支持中文 -->
   <script type="text/javascript" src="<%=path %>/jquery-easyui-1.5/locale/easyui-lang-zh_CN.js"></script>
   <!-- 引入EasyUI的样式文件-->
   <link rel="stylesheet" href="<%=path %>/jquery-easyui-1.5/themes/default/easyui.css" type="text/css"/>
   <!-- 引入EasyUI的图标样式文件-->
   <link rel="stylesheet" href="<%=path %>/jquery-easyui-1.5/themes/icon.css" type="text/css"/>
	
  </head>
<script type="text/javascript">
	function reloadgrid() {  
            //查询参数直接添加在queryParams中      
            var queryParams = $('#dg').datagrid('options').queryParams;  
            getQueryParams(queryParams);  
            $('#dg').datagrid('options').queryParams = queryParams;//传递值  
            $("#tt").datagrid('reload');//重新加载table  
  
        }
</script>
<body>
	<div id="cc" class="easyui-layout" style="width:100%;height:100%;border:false;">   
	    		<div id="tb">
	    			<div style="background-color: white;padding: 10px;">
	    			<div style="margin-bottom:10px">
					<input class="easyui-textbox" name="name" style="width:200px;" data-options="label:'Name:',required:true">
					<input class="easyui-textbox" name="name2" style="width:200px;" data-options="label:'Name2:',required:true">
					</div>
					<div>
						<select class="easyui-combobox" name="language" label="Language" style="width:180px">
							<option value="ar">Arabic</option>
							<option value="bg">Bulgarian</option>
						</select>
						<input class="easyui-textbox" name="name2" style="width:200px;" data-options="label:'Name7:',required:true">
					</div>
					</div>
					<div style="">
						<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true">编辑</a>
						<a href="javaScript:;" class="easyui-linkbutton" data-options="iconCls:'icon-help',plain:true" onclick="reloadgrid()">帮助</a>
					</div>
				</div>
				<table id="dg" class="easyui-datagrid" style="width: 100%;height: 100%" toolbar="#tb"
						data-options="rownumbers:true,singleSelect:true,pagination:true,border:false,fitColumns:true,url:'/test/test3.do'">
					<thead>
						<tr>
							<th data-options="field:'itemid',sortable:true" width="20%">编码</th>
							<th data-options="field:'productid'" width="30%">名字</th>
							<th data-options="field:'listprice'" width="40%">密码</th>
							<th data-options="field:'caozuo'" width="10%">操作</th>
						</tr>
					</thead>
					<tbody>   
				        <tr>   
				            <td>001</td>
				            <td>name1</td>
				            <td>2323</td>
				            <td>
				            	<a href="#" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-cancel'">删除</a>
								<a href="#" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-edit'">编辑</a>
							</td>   
				        </tr>   
				        <tr>   
				            <td>002</td>
				            <td>name2</td>
				            <td>4612</td>
				           	<td>
				            	<a href="#" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-cancel'">删除</a>
								<a href="#" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-edit'">编辑</a>
							</td> 
				        </tr>  
				         
				    </tbody>   
						
				</table>
	</div>
</body>
</html>
