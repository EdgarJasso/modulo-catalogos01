<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<style>
	.panel-black .panel-header{
		background-color: var(--menu-bg-color);
    	color: var(--menu-font-color);
    	text-align: center;
    	padding: 5px 0px;
    	margin-bottom: 10px;
	}
</style>

<script type="text/javascript">
var $general = {};
(function() 
{
	const $base = "general";
	this.table	= null;
	
	let generalOptions = "";
	
	const P_CREATE = $portal.menu.permiso.eval("CREATE");
	const P_UPDATE = $portal.menu.permiso.eval("UPDATE");
	
	const nvaUsr = $portal.user.profile.nva_id_n;
	const nvaMenu = $portal.menu.nva_id_n;
	
	this.catalogoPadre = 0;
	this.catalogoPadreTitle = "";
	
	this.optionsFormatter = function(value,row)
	{	
		let id = row.catd_id_n;
		let status = row.catd_est_str;
		let controller = "$"+$base+".controller";
		
		let showActivar   = P_UPDATE && status!="A" ? true:false;
		let showInactivar = P_UPDATE && status=="A" ? true:false;
		let showEditar    = P_UPDATE ? true:false;
		
		let options =
		{ label: value==undefined? "<i class='fa fa-list-ul'></i>": " Acciones ",
		  hint:"Acciones",
		  items:[ {	label:"Activar", 
			  		icon:"fa fa-check-square pcolor-green",
			  		onClick:controller+"("+id+",1)",
			        show: showActivar
			      },
			      {	label:"Inactivar", 
			  		icon:"fa fa-ban pcolor-red",
			  		onClick:controller+"("+id+",2)",
			        show: showInactivar
			      },
			      {	label:"Editar", 
			  		icon:"fa fa-pencil-square-o pcolor-blue",
			  		onClick:controller+"("+id+",3)",
			  		permission: "UPDATE",
			  		show:showEditar
			      }
		        ] 
		};
		return $portal.system.createDropDownMenu(options);
	};
	
	this.controller = (id, opt )=>
	{
		switch(opt)
		{
			case 1:	updateEstatus(id,"A");	break;
			case 2: updateEstatus(id,"I");	break;
			case 3: updateGeneral(id);		break;
		}
	};
	
	function updateGeneral(id)
	{
		$general.catalogoPadre = $("#f_categoria").val();
		$general.catalogoPadreTitle = $('#f_categoria option:selected').text();
		
		$("#divFormContainer").html("");
		app.loading = $portal.dialog.loading().open();
		
		$portal.system.getForm({url:$base+"/updateForm",data:{id:id} })
		.done((form)=>
		{
			$("#divFormContainer").html(form); 
			$("#divFormContainer").show();
		}).always( ()=> { app.loading.close(); });
		
	}
	
	function updateEstatus(id,estatus)
	{
		let loading = $portal.dialog.loading().open();
		$portal.system.service
		({	url:"updateEstatusCatalogoDet",
			data:{ catDIdN:id,catEstStr:estatus },
			callback:function(r)
			{
				loadData();
			}
		}).always(()=>{ loading.close(); });
	}
	
	function toolbarButtons(){
		return {
			btnRefresh: 
			{	icon:"fa-fw fa fa-refresh",
				title:"Recargar datos",
				onclick:"$"+$base+".refreshData($(this))",
			},
			btnAdd: 
			{	icon:"fa-fw fa fa-plus",
				title:"Registrar nuevo perfil",
				onclick:"$"+$base+".addGeneral($(this))",
				permission:"CREATE",
				show:nvaUsr >=nvaMenu
			}
		};
	}
	
	this.refreshData = (btn)=> {
		$portal.system.blockButton(btn);	
		loadData();
	};
	
	function loadData()
	{
		$("#divFormContainer").hide();
		$("#divFormContainer").html("");
		
		$general.table.setData([]);
		$general.catalogoPadre = $("#f_categoria").val();
		
		if($general.catalogoPadre < 0){ return; }
		
		let loading = $portal.dialog.loading().open();
		$portal.system.service
		({	url:"getCatalogoDet",
			data:{catIdN: $general.catalogoPadre},
			callback:(r)=>{
				$general.table.setData(r.catalogoDet);
			}
		}).always(()=>{ loading.close(); });
	}

	function loadGeneralStore(){
		return $portal.system.service
		({	url:"getCatalogo",
			data:{},
			callback:(r)=>
			{	
				let options= '';
				if(r.catalogo.length>1)
			    { options='<option value="-1">-</option>';}
				
				$.each(r.catalogo,(i,item)=>{	
					options+='<option value="'+item.cat_id_n+'" data-name="'+item.cat_desc_str+'">'+item.cat_desc_str+'</option>';
				});
				generalOptions = options;
			}
		});	
	}
	
	
	this.addGeneral =(btn)=>
	{
		$portal.system.blockButton(btn);	
		$general.catalogoPadre = $("#f_categoria").val();
		$general.catalogoPadreTitle = $('#f_categoria option:selected').text();
		
		if($general.catalogoPadre < 0)
		{
			$portal.dialog.warning("Seleccione una categoria válida para poder agregar un nuevo registro");
			return false;
		}
		
		$("#divFormContainer").html("");
		app.loading = $portal.dialog.loading().open();
		
		$portal.system.getForm({url:$base+"/addForm"})
		.done((form)=>
		{
			$("#divFormContainer").html(form); 
			$("#divFormContainer").show();
		}).always( ()=> { app.loading.close(); });
		
	};
	
	function initMenu()
	{
		$("#f_categoria").html(generalOptions);
		$("#f_categoria").selectpicker({width:'100%'}); 
		$("#f_categoria").change(loadData);
		
		$general.table = $("#table_"+$base);
		$portal.system.setTable({table:$general.table,toolbarButtons:toolbarButtons()});	
	}
	
	this.init = ()=> 
	{	
		app.loading = $portal.dialog.loading().open();
		
		$.when( $portal.system.getForm({url:$base+"/filtro"}),
				$portal.system.getForm({url:$base+"/table"}),
				loadGeneralStore()
		).done((filtroTemplate,tableTemplate)=>
		{
			$("#divFiltro").html(filtroTemplate[0]);
			$("#divTableContainer").html(tableTemplate[0]);
			initMenu();			
		}).always(()=>{ app.loading.close(); });
	};
}).apply($general);
$(document).ready($general.init);
</script>
<div id="div-dismiss-container" class="col-lg-12" style="padding: 0px; margin: 0px;"></div>
<div class="panel panel-tema">
	<div id="divFiltro" class="panel-body padding-0"></div>
	<hr class="ps-hr-b-0">
	<div id="divTableContainer" class="panel-body padding-0"></div>
</div>
