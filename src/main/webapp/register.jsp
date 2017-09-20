<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" type="text/css" href="js/jquery-easyui-1.4.3/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="js/jquery-easyui-1.4.3/themes/icon.css">
<link rel="stylesheet" type="text/css" href="js/jquery-easyui-1.4.3/demo/demo.css">
<script type="text/javascript" src="js/jquery-easyui-1.4.3/jquery.min.js"></script>
<script type="text/javascript" src="js/jquery-easyui-1.4.3/jquery.easyui.min.js"></script>

<script type="text/javascript">
	$(function(){
		$('#dd').dialog({    
		    title: '注册界面',    
		    width: 250,    
		    height: 150,    
		    closed: false,    
		    cache: false,
		    draggable:false,
		    modal: true,
		    buttons:[{
				text:'注册',
				handler:function(){
					$('#reg_form').form('submit',{    
					    url:"register.action",    
					    success:function(data){    
					        alert(data);    
					    }    
					}); 
				}
			}]
		}); 
	});
</script>
</head>
<body>
	<div id="dd">
		<form id="reg_form">
			<table>
				<tr>
					<td>用户：</td>
					<td>
						<input type="text" name="username"/>
					</td>
				</tr>
				<tr>
					<td>密码：</td>
					<td>
						<input type="text" name="password"/>
					</td>
				</tr>
			</table>
		</form>
	</div>  
</body>
</html>