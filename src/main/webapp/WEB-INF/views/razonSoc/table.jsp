<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
<style>
.form-reg-padding{ padding-top: 44px;}
</style>
<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12" style="padding: 0px;">
	<table  class				= "table-header-compact"
	   	    id					= "table_razonSoc"	
			data-toolbar-name	= "table_razonSoc_tb"
	   		data-search			= "true"
	   		data-show-columns	= "true"
	   		data-show-columns-toggle-all="false"
	    	data-show-fullscreen= "false"
	    	data-pagination		= "true"
	    	data-page-size		= "100"
	   		data-page-list		= "[100,500,1000]"
	    	data-height			= "350"
	  		data-min-height		= "350"
	  		data-height-vh		= "40"
	  		data-unique-id 		= "rs_id_n"
			>
		<thead>	
			<tr>	
				<th data-field="rs_id_n" 		data-sortable="true" data-visible="false" >Id</th>
				<th data-field="rs_nombre_str" 	data-sortable="true">Nombre</th>
				<th data-field="rs_rfc_str" 	data-sortable="true">RFC</th>
				<th data-field="rs_dir_str" 	data-sortable="true" data-align="right">Dirección</th>
				<th data-field="rs_tipo_n" 		data-sortable="true" data-visible="false">ID Tipo</th>
				<th data-field="rs_tipo_str" 	data-sortable="true" data-align="center">Tipo</th>
				<th data-field="rs_giro_n" 		data-sortable="true" data-visible="false">ID Giro</th>
				<th data-field="rs_giro_str" 	data-sortable="true" data-align="center">Giro</th>
				<th data-field="rs_calle_str" 	data-sortable="true" data-visible="false">Calle</th>
				<th data-field="rs_num_ext_str" data-sortable="true" data-visible="false">Número Exterior</th>
				<th data-field="rs_num_int_str" data-sortable="true" data-visible="false">Número Interior</th>
				<th data-field="rs_colonia_str" data-sortable="true" data-visible="false">Colonia</th>
				<th data-field="rs_mun_id_n" 	data-sortable="true" data-visible="false">Municipio ID</th>
				<th data-field="rs_ciudad_str" 	data-sortable="true" data-visible="false">Ciudad</th>
				<th data-field="rs_edo_id_n" 	data-sortable="true" data-visible="false">Estado ID</th>
				<th data-field="edo_cve_str" 	data-sortable="true" data-visible="false">Clave Estado</th>
				<th data-field="edo_desc_str" 	data-sortable="true" data-visible="false">Descripción Estado</th>
				<th data-field="rs_pais_id_n" 	data-sortable="true" data-visible="false">País ID</th>
				<th data-field="pais_cve_str" 	data-sortable="true" data-visible="false">Clave País</th>
				<th data-field="pais_desc_str" 	data-sortable="true" data-visible="false">Descripción País</th>
				<th data-field="rs_cp_str" 		data-sortable="true" data-visible="false">Código Postal</th>
				<th data-field="rs_est_str" 	data-sortable="true" data-formatter="$portal.system.statusFormatter">Estado</th>
				<th data-field="rs_freg_dt" 	data-sortable="true" data-visible="false">Fecha de Registro</th>
				<th data-field="rs_id_n" 	    data-formatter="$razonSoc.optionsFormatter" data-width="50" data-align="center">Acciones</th>
			</tr>
		</thead>
	</table>
</div>
