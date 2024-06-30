<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
<style>
body{text-align: center;padding-top: 20px;padding-left: 50px;font-family: Helvetica;}
td{padding: 10px;}
.tdAttr {background-color: #004B85;color:#FFF;	border: solid 1px #CCC;}
.tdVal{color:#DA0080;border: solid 1px #CCC;}
</style>
	<div align="center">
		<table style="border: solid 1px #000; border-collapse: collapse; max-width: 700px;">
			<tr> 
				<td class="tdAttr">Aplicativo</td>
				<td class="tdVal" >${name}</td>
			</tr>
			<tr>
				<td class="tdAttr">Descripcción</td>
				<td class="tdVal" >${desc}</td>
			</tr>
			<tr>
				<td class="tdAttr">Versión</td>
				<td class="tdVal" >${version}</td>
			</tr>
			<tr>
				<td class="tdAttr">Liberación</td>
				<td class="tdVal">${release}</td>
			</tr>
			<tr>
				<td class="tdAttr">Ambiente</td>
				<td class="tdVal" >${profile}</td>
			</tr>
		</table>	
	</div>