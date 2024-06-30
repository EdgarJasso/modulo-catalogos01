<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
<table  class				= "table-header-compact"
   	    id					= "table_general"	
		data-toolbar-name	= "table_general_tb"
   		data-search			= "true"
   		data-show-columns	= "true"
   		data-show-columns-toggle-all="true"
    	data-show-fullscreen= "true"
    	data-pagination		= "true"
    	data-page-size		= "100"
   		data-page-list		= "[100,500,1000]"
    	data-height			= "450"
  		data-min-height		= "450"
  		data-height-vh		= "60"
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

