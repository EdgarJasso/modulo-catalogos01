<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
<style>
.form-reg-padding{ padding-top: 44px;}
</style>
<div class="col-lg-6 col-md-12 col-sm-12 col-xs-12" style="padding: 0px;">
	<table  class				= "table-header-compact"
	   	    id					= "table_general"	
			data-toolbar-name	= "table_general_tb"
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
	  		data-unique-id 		= "catd_id_n"
			>
		<thead>	
			<tr>	
				<th data-field="catd_id_n" 	data-align="center" data-width=70 
					data-visible=false data-sortable=true>Id</th>
				<th data-field="cat_id_n" 		data-visible=false data-sortable=true>IdCatalogo</th>
				<th data-field="catd_cve_str"   data-sortable=true>Clave</th>
				<th data-field="catd_desc_str"  data-sortable=true>Descripcion</th>
				<th data-field="catd_est_str"   data-sortable=true data-formatter="$portal.system.statusFormatter">Estatus</th>
				<th data-formatter="$general.optionsFormatter" data-width=50 data-align="center">Acciones</th>
			</tr>
		</thead>
	</table>
</div>

<div id="divFormContainer" class="col-lg-6 col-md-12 col-sm-12 col-xs-12 form-reg-padding">
</div>
