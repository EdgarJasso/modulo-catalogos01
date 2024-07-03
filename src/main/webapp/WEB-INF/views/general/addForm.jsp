<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script type="text/javascript">
var $general_addForm = {};
(function(){
	
	const $base = "general";
	
	function ejecutar(obj)
	{
		let loading = $portal.dialog.loading().open();
		$portal.system.service
		({	url:$base+"/save",
			data: obj,
			callback:function(r)
			{	
				$("#divFormContainer").hide();
				$("#divFormContainer").html("");
				$general.refreshData();
				$portal.dialog.infoDismiss({message:"Clave <span class='pcolor-red'>"
					+obj.clave +" - "+ obj.desc+" </span> registrada" });
			}
		}).always(()=>{ loading.close(); });
	}
	
	function validar()
	{
		let form = $("#form_addGeneral");
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
		
		obj.idPadre = $general.catalogoPadre;
		if( objToFocus != null ) { objToFocus.focus(); } 
		
		return obj;
	}
	
	this.init = ()=>{
		$("#f_btnSave").off("click"); 
		setTimeout( ()=>{ $("#clave").focus(); },500);
		$("#padreStr").val( $general.catalogoPadreTitle );
		
		try{ $("#estatus").selectpicker('destroy');  }catch(e){}
		$("#estatus").selectpicker({width:'100%'}); 
		
		$("#f_btnSave").click((e)=>
		{ 
			e.preventDefault(); 
			let obj = validar();
			if( obj.valido ) ejecutar(obj);
		});
	};
}).apply($general_addForm);
$(document).ready($general_addForm.init);
</script>
<div class="panel panel-tema ">
	<div class="panel panel-heading ">
		Formulario de registro
	</div>
	
	<form id="form_addGeneral" class="form-horizontal panel-body ">
		
		<div class="form-group" >
			<label class="col-xs-12 col-sm-3  control-label">
				Categoria:
			</label>
			<div class="col-xs-12 col-sm-9">
				<input class="form-control" id="padreStr" name="padreStr" readonly="readonly">
			</div>
		</div>
		
		<div class="form-group" >
			<label class="col-xs-12 col-sm-3  control-label lbl-form">
				<span class="text-error"><i class="fa fa-asterisk ast-required"></i></span> 
					Clave
				<span class="form-span-error"></span>
			</label>
			<div class="col-xs-12 col-sm-4">
				<input class="form-control" id="clave" name="clave" maxlength="50" required="required">
			</div>
			
			<label class="col-xs-12 col-sm-2  control-label lbl-form">
				Estatus:
			</label>
			<div class="col-xs-12 col-sm-3">
				<select class="form-control" id="estatus" name="estatus">
					<option selected="selected" data-icon="fa fa-square pcolor-green" value="A"> Activo</option>
					<option data-icon="fa fa-square pcolor-red" value="I"> Inactivo</option>
				</select>
			</div>
			
		</div>
		
		<div class="form-group" >
			<label class="col-xs-12 col-sm-3  control-label">
				<span class="text-error"><i class="fa fa-asterisk ast-required"></i></span> 
				Descripción:
				<span class="form-span-error"></span>
			</label>
			<div class="col-xs-12 col-sm-9">
				<input class="form-control" id="desc" name="desc" maxlength="100" required="required">
			</div>
		</div>
		
		<div class="form-group" style="padding-right: 15px;">
			<div class="form-group" >
				<div class="col-xs-12 col-sm-4 col-sm-offset-8">
					<button id="f_btnSave" class="btn btn-primary form-control" > Registrar</button>
				</div>
			</div>
		</div>
		
	</form>
</div>	

