<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>

	<div id="div-modulo-filter" class="col-lg-2 col-md-4 col-sm-12 col-xs-12 " >
		<label class="control-label lbl-filter " for="codigoPStr">
			Código Postal:
		</label>
		<input id="codigoPStr" name="codigoPStr" type="text" class="form-control" maxlength="5" required="required">
	</div>

	<div id="div-modulo-filter" class="col-lg-2 col-md-4 col-sm-12 col-xs-12 " >
		<label class="control-label lbl-filter " for="estadoStr">
			Estado:
		</label>
		<select	id="estadoStr" name="estadoStr" class="form-control" data-live-search="true"></select>
	</div>

	<div id="div-modulo-filter" class="col-lg-2 col-md-4 col-sm-12 col-xs-12 " >
		<label class="control-label lbl-filter " for="municipoStr">
			Municipio:
		</label>
		<select	id="mnpioStr" name="mnpioStr" class="form-control" data-live-search="true">
			<option value="-1"> - ToDo - </option>
		</select>
	</div>

	<div class="col-lg-2 col-md-4 col-sm-12 col-xs-12">
		<label class="control-label lbl-filter">
		&nbsp;
		</label>
		<button id="btnBuscar" class="btn btn-primary form-control">
		<i class="fa fa-search" aria-hidden="true"></i> Filtrar
		</button>
	</div>

