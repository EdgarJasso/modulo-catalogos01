<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link href="${resources}app/css/plugins/fileinput.css" rel="stylesheet">
<script src="${resources}app/js/plugins/fileinput.js" type="text/javascript"></script>

<script type="text/javascript">
var $codigoPostal = {};
(function(){
	
	const $base = "codigoPostal";
	this.table	= null;
	
	let estadoMap = {};
	let estadoOptions = "";

	const P_CREATE = $portal.menu.permiso.eval("CREATE");
	const P_UPDATE = $portal.menu.permiso.eval("UPDATE");
	const P_DELETE = $portal.menu.permiso.eval("DELETE");
	
	const nvaUsr = $portal.user.profile.nva_id_n;
	const nvaMenu = $portal.menu.nva_id_n;

	let filtro= { valido:false, total:null};

	this.init = ()=>  
	{	
		app.loading = $portal.dialog.loading().open();
		
		$.when( $portal.system.getForm({url:$base+"/filtro"}),
				$portal.system.getForm({url:$base+"/table"}),
				loadEstadosStore()
		).done((filtroTemplate,tableTemplate)=>
		{
			$("#divFiltro").html(filtroTemplate[0]);
			$("#divTableContainer").html(tableTemplate[0]);
			initMenu();			
		}).always(()=>{ app.loading.close(); });
	};

	function initMenu(){
		
		$("#estadoStr").html(estadoOptions);
		$("#estadoStr").selectpicker({width:'100%'}); 
		$("#estadoStr").change(loadMnpio);

		$("#codigoPStr").onlyNumbers();
		$("#codigoPStr").focus();
		
		$codigoPostal.table = $("#table_"+$base);
		$("#btnBuscar").click(onclickBuscar);
		$portal.system.setTable({
			table:$codigoPostal.table,
			toolbarButtons:$codigoPostal.toolbarButtons()
		});	
		
	}

	function loadEstadosStore(){
		return $portal.system.service
		({	url:$base+"/estadoList",
			data:{},
			callback:(r)=>
			{	
				let options= '';
				if(r.estado.length>1)
			    { options='<option value="-1">-</option>';}
				
				$.each(r.estado,(i,item)=>{	
					options+='<option value="'+item.edo_id_n+'">'+item.edo_desc_str+'</option>';
					estadoMap[item.edo_id_n] = {id:item.edo_id_n,cve:item.edo_cve_str,name:item.edo_desc_str};
				});
				estadoOptions = options;
			}
		});	
	}
	
	function loadMnpio(){
		let estadoSelected = $("#estadoStr").val();
		console.log(estadoMap[estadoSelected]);
		
		$("#municipoStr").empty();
		$("#municipoStr").html('<option value="-1"> - ToDo - </option>');
		$("#municipoStr").selectpicker({width:'100%'}); 
	}

	this.buscarCP = ()=>{
		onclickBuscar();
	}

	function onclickBuscar(){

		filtro = {
			codigoPStr : ($("#codigoPStr").val() != "")?$("#codigoPStr").val():"X",
			estadoStr  : ($("#estadoStr").val() != "-1")?$("#estadoStr").val():"X",
			mnpioStr   : ($("#mnpioStr").val() != "-1")?$("#mnpioStr").val():"X",
			valido:		true,
			total:		null
		};

		if(filtro.codigoPStr == "X" && filtro.estadoStr == "X"){
			filtro.valido = false;
			$portal.dialog.warning("Codigo Postal o Estado requerido.");
			return false;
		}

		$portal.system.setTable
		({	
			table:$codigoPostal.table,
			toolbarButtons:$codigoPostal.toolbarButtons(),
			ajax:"$codigoPostal.ajaxRequest", 
			sidePagination:'server'
		});
	}

	this.ajaxRequest = (params)=>
	{
		let defaults={valido:false,pager : params};
		let data = $.extend({},defaults,filtro);
		
		if(!data.valido ){ $(".fixed-table-loading").html("");	return false;}
		
		let loading = $portal.dialog.loading().open();
		$portal.system.service
		({  
			url:$base+"/view",data:data,
			callback:(r)=>
			{
				let rows  = r.codigoPostal;
				let total = r.total;
				filtro.total = total;
				params.success({ rows: rows, total:total });
			}
		}).always(()=>{ loading.close(); $portal.system.resetView(); });
	};

	
	this.toolbarButtons = function(){
		return {
			btnAdd: 
			{	icon:"fa-fw fa fa-plus",
				title:"Cargar csv sepomex",
				onclick:"$"+$base+".showAdd($(this))",
				permission:"CREATE",
				show:nvaUsr >=nvaMenu
			}
		};
	}

	this.optionsFormatter = function(value,row)
	{	
		let id = row.cp_key_str;
		let controller = "$"+$base+".controller";
		
		let showEditar    = P_UPDATE ? true:false;
		let showEliminar  = P_DELETE ? true:false;

		let options =
		{ label: value==undefined? "<i class='fa fa-list-ul'></i>": " Acciones ",
		  hint:"Acciones",
		  items:[ {	label:"Editar", 
			  		icon:"fa fa-pencil-square-o pcolor-blue",
			  		onClick:controller+ "('" + id + "', 1)",
			  		permission: "UPDATE",
			  		show:showEditar
			      },
				  {	label:"Eliminar", 
			  		icon:"fa fa-ban pcolor-red",
			  		onClick:controller+ "('" + id + "', 2)",
			  		permission: "DELETE",
			  		show:showEliminar
			      }
			      
		        ] 
		};
		return $portal.system.createDropDownMenu(options);
	};

	this.controller = (id, opt )=>{
		switch(opt){
			case 1: updateCP(id);	break;
			case 2: deleteCP(id);	break;
		}
	};

	this.showAdd = function(btn){
		$portal.system.blockButton(btn);	
		$portal.system.loadForm({url:$base+"/uploadForm"});
	};

	function updateCP(id){		
		$portal.system.loadForm({
			data:{id:id},
			url:$base+"/updateForm"
		});
	}


	function deleteCP(id,estatus)
	{
		let loading = $portal.dialog.loading().open();
		$portal.system.service
		({	url:$base+"/codigoDelete",
			data:{ cpKeyStr:id},
			encoded:false,
			callback:function(r){
				if(r.status == 200){
					$portal.dialog.infoDismiss({message:"Codigo Postal: <span class='pcolor-red'> Eliminado</span>"});
					onclickBuscar();
				}
			}
		}).always(()=>{ loading.close(); });
	}
	
	
}).apply($codigoPostal);
$(document).ready($codigoPostal.init);
</script>

<div id="div-dismiss-container" class="col-lg-12" style="padding: 0px; margin: 0px;"></div>
<div class="panel panel-tema">
	<div id="divFiltro" class="panel-body padding-0"></div>
	<hr class="ps-hr-b-0">
	<div id="divTableContainer" class="panel-body padding-0"></div>
</div>