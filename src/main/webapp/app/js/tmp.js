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
	
	let catalogoPadre = 0;
	let catalogoPadreTitle = "";
	let idDC = 0;
	
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
	
	function updateEstatus(id,estatus){
		inactiveForm();
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
	
	function updateGeneral(id){
		idDC = id;
		$("#f_btnSave").hide();
		$("#f_btnUpate").show();
		let row = $general.table.getRow(idDC);
		//console.log(row);
		activeForm();
		catalogoPadre = $("#f_categoria").val();
		catalogoPadreTitle = $('#f_categoria option:selected').text();
		$("#catDIdN").val(row.catd_id_n);
		$("#catIdN").val(row.cat_id_n);
		$("#f_gen_idcat_str").val(catalogoPadreTitle);
		$("#catDCveStr").val(row.catd_cve_str);
		$("#catDescStr").val(row.catd_desc_str);
		$("#catEstStr").val(row.catd_est_str);
	}
	
	
	this.addGeneral =(btn)=>
	{
		$portal.system.blockButton(btn);	
		catalogoPadre = $("#f_categoria").val();
		catalogoPadreTitle = $('#f_categoria option:selected').text();
		
		if(catalogoPadre < 0)
		{
			$portal.dialog.warning("Seleccione una categoria válida para poder agregar un nuevo registro");
			return false;
		}
		
		$("#divFormContainer").html("");
		app.loading = $portal.dialog.loading().open();
		
		$portal.system.getForm({url:$base+"/addForm"})
		.done(   (form)=>
		{
			$("#divFormContainer").html(form); 
			$("#divFormContainer").show();
		}).always( ()=> { app.loading.close(); });
		
	};
	
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
	
	function loadData(){
		catalogoPadre = $("#f_categoria").val();
		
		if(catalogoPadre > 0){
			let loading = $portal.dialog.loading().open();
			
			$portal.system.service
			({	url:"getCatalogoDet",
				data:{catIdN:catalogoPadre},
				callback:(r)=>{
					$general.table.setData(r.catalogoDet);
				}
			}).always(()=>{ loading.close(); });	
		}else{
			$general.table.setData([]);
		}
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
	
	function saveGeneral(){
		$portal.system.blockButton($(this));
		let obj = validateForm(0);
		//console.log(obj);
		if(obj.validate){
			let loading = $portal.dialog.loading().open();
			$portal.system.service
			({	url:"saveCatalogoDet",
				data:obj,
				callback:(r)=>{	
					console.log(r);
				}
			}).always(()=>{ 
				loading.close();
				loadData();
				inactiveForm();
			});
		}
	}
	
	function _updateGeneral(){
		$portal.system.blockButton($(this));
		let obj = validateForm(1);
		//console.log(obj);
		if(obj.validate){
			let loading = $portal.dialog.loading().open();
			$portal.system.service
			({	url:"updateCatalogoDet",
				data:obj,
				callback:(r)=>{	
					console.log(r);
				}
			}).always(()=>{ 
				loading.close();
				loadData();
				inactiveForm();
			});
		}
	}
	
	function validateForm(tipo){
		let form = $("#form_addGeneral");
		$portal.system.cleanForm( form );
		
		let objToFocus = null;
		let obj = $portal.system.serialize(form);
		//console.log(obj);
		//obj.app_id_n = $rowId;
		obj.validate = true;
		$.each(obj,(id,value)=>
		{	//console.log(id, value);
			if( $("#"+id).prop('required') && obj[id] == null) 
			{	
				obj.validate = false;
				
				$portal.system.markAsError( $("#"+id) ,null, null );
				objToFocus = objToFocus==null ? $("#"+id) : objToFocus;
			}	
		});
		
		if( objToFocus != null ) { objToFocus.focus(); } 
		
		return obj;
	}
	
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