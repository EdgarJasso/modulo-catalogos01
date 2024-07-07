<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script type="text/javascript">
var $codigoPostal_updateForm = {};
(function(){

	const $base = "codigoPostal";
	const $dialog = app.dialog;
	const $rowId = '${object.id}'; 
	const $row = $codigoPostal.table.getRow($rowId);
	
	function ejecutar(obj)
	{
		let loading = $portal.dialog.loading().open();
		$portal.system.service
		({	url:$base+"/codigoSaveOrUpdate",
			data: obj,
			callback:function(response){	
				if(response.status == 200){
					$codigoPostal.buscarCP();
					$portal.dialog.infoDismiss({
						message:"Codigo Postal <span class='pcolor-red'>"+$rowId+" </span> actualizado" 
					});
					$dialog.close();
				}
			}
		}).always(()=>{ loading.close(); });
	}
	
	function validar()
	{
		let form = $("#form_updateCP");
		$portal.system.cleanForm( form );
		
		let objToFocus = null;
		let obj = $portal.system.serialize(form);

		$.each(obj,(id,value)=>
		{	
			if( $("#"+id).prop('required') && obj[id] == null) 
			{	
				obj.valido = false;
				
				$portal.system.markAsError( $("#"+id) ,null, null );
				objToFocus = objToFocus==null ? $("#"+id) : objToFocus;
			}	
		});
		
		if( objToFocus != null ) { objToFocus.focus(); } 
		
		return obj;
	}

	function llenarCampos(){
		$("#cpKeyStr").val($row.cp_key_str);
		$("#cpCodigoStr").val($row.d_codigo);  
		$("#cpCveEstadoStr").val($row.c_estado); 
		$("#cpCveMnpioStr").val($row.c_mnpio); 
		$("#cpIdAsentaCpconsStr").val($row.id_asenta_cpcons); 
		$("#cpCveCiudadStr").val($row.c_cve_ciudad); 
		$("#cpAsentaStr").val($row.d_asenta); 
		$("#cpMnpioStr").val($row.d_mnpio); 
		$("#cpCiudadStr").val($row.d_ciudad); 
	}
	
	this.init = ()=>{
		console.log($row);
		llenarCampos();
		
		$dialog.setTitle('Registrar nueva razón social');
		$dialog.getButton("btnOK").hide();
		$dialog.getButton("btnCANCEL").hide();
		$(".modal-footer").hide();
		$("#f_btnSave").off("click"); 
		$("#f_btnSave").click((e)=>
		{ 
			e.preventDefault(); 
			let obj = validar();
			if( obj.valido ) ejecutar(obj);
		});
	};
}).apply($codigoPostal_updateForm);
$(document).ready($codigoPostal_updateForm.init);
</script>
<form id="form_updateCP" class="form-horizontal panel-body">
    <div class="form-group">
        <label class="col-xs-12 col-sm-3 control-label">
            <span class="text-error"><i class="fa fa-asterisk ast-required"></i></span> 
            CP Key:
            <span class="form-span-error"></span>
        </label>
        <div class="col-xs-12 col-sm-3">
            <input class="form-control" id="cpKeyStr" readonly="readonly" name="cpKeyStr" required="required">
        </div>
		<label class="col-xs-12 col-sm-3 control-label">
            <span class="text-error"><i class="fa fa-asterisk ast-required"></i></span> 
            Id Asenta:
            <span class="form-span-error"></span>
        </label>
        <div class="col-xs-12 col-sm-3">
            <input class="form-control" id="cpIdAsentaCpconsStr" name="cpIdAsentaCpconsStr" required="required">
        </div>
    </div>
	<div class="form-group">
        <label class="col-xs-12 col-sm-3 control-label">
            <span class="text-error"><i class="fa fa-asterisk ast-required"></i></span> 
            Codigo:
            <span class="form-span-error"></span>
        </label>
        <div class="col-xs-12 col-sm-3">
            <input class="form-control" id="cpCodigoStr" name="cpCodigoStr" required="required">
        </div>
		<label class="col-xs-12 col-sm-3 control-label">
            <span class="text-error"><i class="fa fa-asterisk ast-required"></i></span> 
            Cve. Estado:
            <span class="form-span-error"></span>
        </label>
        <div class="col-xs-12 col-sm-3">
            <input class="form-control" id="cpCveEstadoStr" name="cpCveEstadoStr" required="required">
        </div>
    </div>
	<div class="form-group">
        <label class="col-xs-12 col-sm-3 control-label">
            <span class="text-error"><i class="fa fa-asterisk ast-required"></i></span> 
            Cve. Mnpio:
            <span class="form-span-error"></span>
        </label>
        <div class="col-xs-12 col-sm-3">
            <input class="form-control" id="cpCveMnpioStr" name="cpCveMnpioStr" required="required">
        </div>
		<label class="col-xs-12 col-sm-3 control-label">
            <span class="text-error"><i class="fa fa-asterisk ast-required"></i></span> 
            Cve Ciudad:
            <span class="form-span-error"></span>
        </label>
        <div class="col-xs-12 col-sm-3">
            <input class="form-control" id="cpCveCiudadStr" name="cpCveCiudadStr" required="required">
        </div>
    </div>
	<div class="form-group">
        <label class="col-xs-12 col-sm-3 control-label">
            <span class="text-error"><i class="fa fa-asterisk ast-required"></i></span> 
            Colonia:
            <span class="form-span-error"></span>
        </label>
        <div class="col-xs-12 col-sm-9">
            <input class="form-control" id="cpAsentaStr" name="cpAsentaStr" required="required">
        </div>
    </div>
	<div class="form-group">
        <label class="col-xs-12 col-sm-3 control-label">
            <span class="text-error"><i class="fa fa-asterisk ast-required"></i></span> 
            Ciudad:
            <span class="form-span-error"></span>
        </label>
        <div class="col-xs-12 col-sm-3">
            <input class="form-control" id="cpCiudadStr" name="cpCiudadStr" required="required">
        </div>
		<label class="col-xs-12 col-sm-3 control-label">
            <span class="text-error"><i class="fa fa-asterisk ast-required"></i></span> 
            Municipio:
            <span class="form-span-error"></span>
        </label>
        <div class="col-xs-12 col-sm-3">
            <input class="form-control" id="cpMnpioStr" name="cpMnpioStr" required="required">
        </div>
    </div>
	<div class="form-group" style="padding-right: 15px;">
		<div class="form-group" >
			<div class="col-xs-12 col-sm-4 col-sm-offset-8">
				<button id="f_btnSave" class="btn btn-primary form-control" > Actualizar</button>
			</div>
		</div>
	</div>
		
	</form>
</div>	

