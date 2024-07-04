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
	
	const nvaUsr = $portal.user.profile.nva_id_n;
	const nvaMenu = $portal.menu.nva_id_n;



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
		$portal.system.setTable({table:$codigoPostal.table,toolbarButtons:toolbarButtons()});	
		$("#btnBuscar").click(loadView);
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

	function loadView(){
		$codigoPostal.table.setData([]);
		let obj =  validar();
		
		if(obj.valido){
			let loading = $portal.dialog.loading().open();
			$portal.system.service
			({	url:$base+"/view",
				data: obj,
				callback:function(r){	
					$codigoPostal.table.setData(r.codigoPostal);
				}
			}).always(()=>{ loading.close(); });
		}else{
			$portal.dialog.warning(obj.messaage);
		}
	}

	function validar(){
		let obj = {};
			obj.codigoPStr = ($("#codigoPStr").val() != "")?$("#codigoPStr").val():"X";
			obj.estadoStr  = ($("#estadoStr").val() != "-1")?$("#estadoStr").val():"X";
			obj.mnpioStr   = ($("#mnpioStr").val() != "-1")?$("#mnpioStr").val():"X";
			obj.valido	   = true;
			obj.messaage   = null;

		if(obj.codigoPStr == "X" && obj.estadoStr == "X"){ 
			obj.valido = false;
			obj.messaage = "Codigo Postal o Estado requerido" ;
		}
		
		return obj;
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
				title:"Cargar csv sepomex",
				onclick:"$"+$base+".showAdd($(this))",
				permission:"CREATE",
				show:nvaUsr >=nvaMenu
			}
		};
	}

	this.showAdd = function(btn){
		$portal.system.blockButton(btn);	
		$portal.system.loadForm({url:$base+"/uploadForm"});
	};
	
	
}).apply($codigoPostal);
$(document).ready($codigoPostal.init);
</script>

<div id="div-dismiss-container" class="col-lg-12" style="padding: 0px; margin: 0px;"></div>
<div class="panel panel-tema">
	<div id="divFiltro" class="panel-body padding-0"></div>
	<hr class="ps-hr-b-0">
	<div id="divTableContainer" class="panel-body padding-0"></div>
</div>