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
		
		this.tipoMap = {};
		this.tipoOptions = "";

		this.giroMap = {};
        this.giroOptions = "";

	this.init = ()=> 
	{	
		app.loading = $portal.dialog.loading().open();
		
		$.when( 
				$portal.system.getForm({url:$base+"/filtro"}),
				$portal.system.getForm({url:$base+"/table"}),
				getTipoStore(),
				getGiroStore()
		).done((filtroTemplate,tableTemplate)=>{
			$("#divFiltro").html(filtroTemplate[0]);
			$("#divTableContainer").html(tableTemplate[0]);
			initMenu();			
		}).always(()=>{ app.loading.close(); });
	};

    function initMenu(){

		$razonSoc.table = $("#table_"+$base);
			$portal.system.setTable({table:$razonSoc.table,toolbarButtons:toolbarButtons()});	
			$("#btnBuscar").click($razonSoc.loadData);

			$("#f_tipo").html($razonSoc.tipoOptions);
			try{ $("#f_tipo").selectpicker('destroy');  }catch(e){}
			$("#f_tipo").selectpicker({width:'100%'}); 
			
			$("#f_giro").html($razonSoc.giroOptions);
			try{ $("#f_giro").selectpicker('destroy');  }catch(e){}
			$("#f_giro").selectpicker({width:'100%'}); 
	
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
    
	function getTipoStore(){
		return $portal.system.service
		({	url:"general/detList",
			data:{idPadre: 2},
			callback:(r)=>{	
				let options= '';
				if(r.catalogoDet.length>0)
			    { options='<option value="-1">-</option>';}
				
				$.each(r.catalogoDet,(i,item)=>{	
					if(item.catd_est_str == "A"){
						options+='<option value="'+item.catd_id_n+'" ">'+item.catd_desc_str+'</option>';
						$razonSoc.tipoMap[item.catd_id_n] = {id:item.catd_id_n,value:item.catd_desc_str};
					}
				});
				$razonSoc.tipoOptions = options;

			}
		});	
	}

	function getGiroStore(){
		return $portal.system.service
		({	url:"general/detList",
			data:{idPadre: 3},
			callback:(r)=>{	
				let options= '';
				if(r.catalogoDet.length>0)
			    { options='<option value="-1">-</option>';}
				
				$.each(r.catalogoDet,(i,item)=>{	
					if(item.catd_est_str == "A"){
						options+='<option value="'+item.catd_id_n+'" ">'+item.catd_desc_str+'</option>';
						$razonSoc.giroMap[item.catd_id_n] = {id:item.catd_id_n,value:item.catd_desc_str};
					}
				});
				$razonSoc.giroOptions = options;

			}
		});	
	}

	this.refreshData = (btn)=> {
		$portal.system.blockButton(btn);	
		$razonSoc.loadData();
	};

	this.loadData = ()=>{
		let obj = {};
			obj.rsTipoN = $("#f_tipo").val(); 
			obj.rsGiroN = $("#f_giro").val(); 

		let loading = $portal.dialog.loading().open();
		$portal.system.service
		({	url:$base+"/view",
			data:obj,
			callback:(r)=>{
				$razonSoc.table.setData(r.rsView);
			}
		}).always(()=>{ loading.close(); });
	}

	this.optionsFormatter = function(value,row){
		let id = row.rs_id_n;
		let status = row.rs_est_str;
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

	function updateEstatus(id,estatus)
	{
		let loading = $portal.dialog.loading().open();
		$portal.system.service
		({	url:$base+"/updateEstatus",
			data:{ rsIdN:id,rsEstStr:estatus },
			callback:function(r){
				$razonSoc.loadData();
			}
		}).always(()=>{ loading.close(); });
	}

	function updateGeneral(id){		
		$portal.system.loadForm({
			data:{id:id},
			url:$base+"/updateForm"
		});
	}

}).apply($razonSoc);
$(document).ready($razonSoc.init);
</script>


<div id="div-dismiss-container" class="col-lg-12" style="padding: 0px; margin: 0px;"></div>
<div class="panel panel-tema">
	<div id="divFiltro" class="panel-body padding-0"></div>
	<hr class="ps-hr-b-0">
	<div id="divTableContainer" class="panel-body padding-0"></div>
</div>