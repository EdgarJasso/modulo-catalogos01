<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script type="text/javascript">
var $codigoPostal_uploadForm = {};
(function(){
	
	const $base = "codigoPostal";
	const $dialog = app.dialog;

	this.init = function(){
		$dialog.setTitle('Carga masiva de codigos postales');
		$dialog.getButton("btnOK").hide();
		
		setFileInput();

	};

	function setFileInput()
	{
		let data = {};
		
		$("#input-id").fileinput({
			showPreview : false,
			allowedFileExtensions : [ 'csv','CSV'],
			showCancel:false,
			uploadUrl : "http://localhost:7575/modulo/service/codigoPostal/upload",
			//$vars.AUTH,$portal.decode($portal.login.auth
			ajaxSettings : {
				beforeSend : (xhr)=>{  
					xhr.setRequestHeader($vars.AUTH,$portal.decode($portal.menu.auth));
				},
			}
		});

		$('#input-id').on('fileuploaded',function(event, data, previewId, index){
			let response = data.response;
			if(response.status == 200){
				$dialog.close();
				$portal.dialog.infoDismiss({message:" <span class='pcolor-red'>"
					+response.message+" </span> " });
			}
		});
	}

	function uploadFile(){
		console.log("uploadFile");
	}
	
}).apply($codigoPostal_uploadForm);
$(document).ready($codigoPostal_uploadForm.init);
</script>


<div class="panel-body padding-0">
	<div id="div-label"></div>
	<div class="col-lg-12">
		<input id="input-id" type="file" class="file" data-preview-file-type="text" name="file">
	</div>
</div>

