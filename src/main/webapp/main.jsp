<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>逗妮开心数据中心</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="">
	<meta http-equiv="description" content="逗妮开心">
	
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
   
   <%-- <script type="text/javascript" src="<%=path %>/jquery-easyui-1.5/eci.index.js"></script> --%>
   <script type="text/javascript">
		var index = 0;
		 var content = "<iframe scrolling='auto' frameborder='0' src='<%=basePath %>test/test2.do' style='width:100%;height:100%;'></iframe>";
		function addPanel(){
			index++;
			$('#tabs').tabs('add',{
				title: 'Tab'+index,
				href: '<%=basePath %>test/test2.do',
				closable: true
			});
		}
	</script>
	
  </head>
  
  <body class="easyui-layout">
		<div data-options="region:'north'" style="height:10%"></div>
		<div data-options="region:'south',split:true" style="height:5%;"></div>
		
		<div data-options="region:'west',split:true" title="菜单导航栏" style="width:15%;">
			<div class="easyui-accordion" data-options="fit:true,border:false">
				<div title="基础管理" style="padding:10px;padding-left: 5px;"  data-options="selected:true">
					 <ul id="tt" class="easyui-tree">
					 	<li>
						<span>基础管理</span>
						<ul>
					       <li data-options="iconCls:'icon-save'">
					           <span>字典管理</span>
					       </li>
					       <li>
					           <span>员工管理</span>
					       </li>
					     </ul>
					     </li>
					 </ul>
				</div>
				<div title="门店管理" style="padding:10px;">
					门店管理
				</div>
				<div title="系统设置" style="padding:10px">
					<span onClick="addPanel()">权限设置</span>
				</div>
			</div>
		</div>
		<div data-options="region:'center',border:'true'">
			<div class="easyui-tabs" data-options="fit:true,border:false,plain:true" id="tabs">
				<div title="主面板" style="padding:10px"></div>
				<div title="卡二" data-options="fit:true,href:'<%=basePath %>test/test2.do'" closable="true"></div>
				
				<!-- <div title="DataGrid" style="padding:5px">
					<table class="easyui-datagrid"
							data-options="url:'datagrid_data1.json',method:'get',singleSelect:true,fit:true,fitColumns:true">
						<thead>
							<tr>
								<th data-options="field:'itemid'" width="80">Item ID</th>
								<th data-options="field:'productid'" width="100">Product ID</th>
								<th data-options="field:'listprice',align:'right'" width="80">List Price</th>
								<th data-options="field:'unitcost',align:'right'" width="80">Unit Cost</th>
								<th data-options="field:'attr1'" width="150">Attribute</th>
								<th data-options="field:'status',align:'center'" width="50">Status</th>
							</tr>
						</thead>
					</table>
				</div> -->
			</div>
		</div>
</body>
</html>
