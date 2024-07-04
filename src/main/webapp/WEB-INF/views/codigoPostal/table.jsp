<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
<style>
.form-reg-padding{ padding-top: 44px;}
</style>
<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12" style="padding: 0px;">
	<table  class				= "table-header-compact"
	   	    id					= "table_codigoPostal"	
			data-toolbar-name	= "table_codigoPostal_tb"
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
	  		data-unique-id 		= "id_n"
			>
		<thead>	
			<tr>	
				<th data-field="id_n" 	data-align="center" data-width=70 
					data-visible=false data-sortable=true>Id</th>
				<th data-field="d_codigo" 		data-sortable=true>Codigo</th>
				<th data-field="d_asenta"   	data-sortable=true>Colonia</th>
				<th data-field="d_ciudad"  		data-sortable=true>Ciudad</th>
				<th data-field="c_estado"   	data-sortable=true>Estado</th>
				<th data-field="c_mnpio"   		data-sortable=true>Munucipio</th>
				<th data-field="c_cve_ciudad"   data-sortable=true>Clave</th>
			</tr>
		</thead>
	</table>
</div>

<!-- div id="divFormContainer" class="col-lg-6 col-md-12 col-sm-12 col-xs-12 form-reg-padding">
</div -->
