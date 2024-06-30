<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<br>
<div class="panel panel-black">
	<div class="panel-header">
		Formulario de registro
	</div>
	
	<form id="form_addGeneral" class="form-horizontal panel-body ">
		
		<div class="form-group" >
			<label class="col-xs-12 col-sm-3  control-label">
				UID:
			</label>
			<div class="col-xs-12 col-sm-3">
				<input class="form-control" id="catDIdN" name="catDIdN" readonly="readonly">
			</div>
			
			<label class="col-xs-12 col-sm-3  control-label">
				IDC:
			</label>
			<div class="col-xs-12 col-sm-3">
				<input class="form-control" id="catIdN" name="catIdN" readonly="readonly">
			</div>
		</div>
		
		<div class="form-group" >
			<label class="col-xs-12 col-sm-3  control-label">
				Categoria:
			</label>
			<div class="col-xs-12 col-sm-9">
				<input class="form-control" id="f_gen_idcat_str" name="f_gen_idcat_str" readonly="readonly">
			</div>
		</div>
		
		
		
		<div class="form-group" >
			<label class="col-xs-12 col-sm-3  control-label lbl-form">
				<span class="text-error"><i class="fa fa-asterisk ast-required"></i></span> 
					Clave
				<span class="form-span-error"></span>
			</label>
			<div class="col-xs-12 col-sm-3">
				<input class="form-control" id="catDCveStr" name="catDCveStr" maxlength="50" required="required">
			</div>
			
			<label class="col-xs-12 col-sm-3  control-label lbl-form">
				Estatus:
			</label>
			<div class="col-xs-12 col-sm-3">
				<select class="form-control" id="catEstStr" name="catEstStr">
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
				<input class="form-control" id="catDescStr" name="catDescStr" maxlength="100" required="required">
			</div>
		</div>
		
		<div class="form-group" >
			<div class="col-lg-7 col-md-6 col-sm-6 col-xs-6" style="float: right;">
				<label class="control-label lbl-filter">&nbsp;</label>
				<button id="f_btnSave" class="btn btn-primary form-control btn-filter " >
				<i class="fa fa-save" aria-hidden="true"></i> Guardar</button>
			</div>
			<div class="col-lg-7 col-md-6 col-sm-6 col-xs-6" style="float: right;">
				<label class="control-label lbl-filter">&nbsp;</label>
				<button id="f_btnUpate" class="btn btn-primary form-control btn-filter " >
				<i class="fa fa-pencil" aria-hidden="true"></i> Editar</button>
			</div>
		</div>
		
	</form>
</div>	

