<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<script type="text/javascript">
    var $razonSoc = {};
    (function(){

        const $base = "razonSoc";
        this.table	= null;
        
        const P_CREATE = $portal.menu.permiso.eval("CREATE");
        const P_UPDATE = $portal.menu.permiso.eval("UPDATE");
        
        const nvaUsr = $portal.user.profile.nva_id_n;
        const nvaMenu = $portal.menu.nva_id_n;
	
        
	this.init = ()=> 
	{	
		app.loading = $portal.dialog.loading().open();
		
		$.when( $portal.system.getForm({url:$base+"/filtro"}),
				$portal.system.getForm({url:$base+"/table"}),
		).done((filtroTemplate,tableTemplate)=>{
			$("#divFiltro").html(filtroTemplate[0]);
			$("#divTableContainer").html(tableTemplate[0]);
			initMenu();			
		}).always(()=>{ app.loading.close(); });
	};

    function initMenu(){
		/*
        $("#f_categoria").html(generalOptions);
		$("#f_categoria").selectpicker({width:'100%'}); 
		$("#f_categoria").change(loadData);
		*/
		$razonSoc.table = $("#table_"+$base);
		$portal.system.setTable({table:$razonSoc.table,toolbarButtons:toolbarButtons()});	
	}

    function toolbarButtons(){
		return {
			btnRefresh: 
			{	icon:"fa-fw fa fa-refresh",
				title:"Recargar datos",
				//onclick:"$"+$base+".refreshData($(this))",
			},
			btnAdd: 
			{	icon:"fa-fw fa fa-plus",
				title:"Registrar nueva razón social",
				onclick:"$"+$base+".showAdd($(this))",
				permission:"CREATE",
				show:nvaUsr >=nvaMenu
			}
		};
	}

    this.showAdd = function(btn){
		$portal.system.blockButton(btn);	
		$portal.system.loadForm({url:$base+"/addForm"});
	};
    

}).apply($razonSoc);
$(document).ready($razonSoc.init);
</script>


<div id="div-dismiss-container" class="col-lg-12" style="padding: 0px; margin: 0px;"></div>
<div class="panel panel-tema">
	<div id="divFiltro" class="panel-body padding-0"></div>
	<hr class="ps-hr-b-0">
	<div id="divTableContainer" class="panel-body padding-0"></div>
</div>