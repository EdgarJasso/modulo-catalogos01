<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script type="text/javascript">
var $razonSoc_updateForm = {};
(function(){
	
	const $base = "razonSoc";
	const $dialog = app.dialog;
    const $rowId = '${object.id}'; 
	const $row = $razonSoc.table.getRow($rowId);

	let rfcValid = false;
    let rowMap = {};

    let extObj = {};
    
	function ejecutar(obj)
	{
		let loading = $portal.dialog.loading().open();
		$portal.system.service
		({	url:$base+"/update",
			data: obj,
			callback:function(response){	
				if(response.status == 200){
                    $portal.dialog.infoDismiss({message:"Razón Social: <span class='pcolor-red'>"+obj.rsNombreStr+" - "+obj.rsRfcStr+"</span> actulizada"});
                    $dialog.close();
                    $razonSoc.loadData();
			    }
			},onError:(r)=>{ 
                console.log(r);
                if(r.message.includes("RAZON_SOCIAL_UK")){
                    $portal.dialog.error("Advertencia: RFC duplicado");
                }else{
                    $portal.dialog.error(r.message);
                }
            }
		}).always(()=>{ loading.close(); });
	}
	
	function validar(){
        console.log("validar");
		let form = $("#form_updateRazonSoc");
		$portal.system.cleanForm( form );
		
		let objToFocus = null;
		let obj = $portal.system.serialize(form);
        
		$.each(obj,(id,value)=>
		{	
			if( $("#"+id).prop('required') && obj[id] == null){	    
				obj.valido = false;
                if($("#"+id).is("select")){
                    let pos = ['rsTipoN','rsGiroN', 'rsCpStr', 'rsAsentaStr'].includes(id) ? 'last' : 'first';
                    $portal.system.markSltAsError($("#"+id));
                }else{
                    $portal.system.markAsError( $("#"+id));
                }
				objToFocus = objToFocus==null ? $("#"+id) : objToFocus;
			}	
		});
		
		if( objToFocus != null ) { objToFocus.focus(); } 
		
		return obj;
	}

    function getCPData(){
        rowMap = {};
        $("#rsAsentaStr").empty();
        let cp = $("#rsCpStr").val().trim();
        if(cp.length > 0){
            let loading = $portal.dialog.loading().open();
            $portal.system.service
            ({	url:"codigoPostal/cpData",
                data: {codigoPStr:cp},
                callback:function(r){	
                    if(r.cpData != null){
                        let options = "";
                        options+='<option value="-1">-</option>';
                        $.each(r.cpData,(i,item)=>{	
                            options+='<option value="'+item.rsIdN+'">'+item.d_asenta+'</option>';
                            rowMap[item.id_n] = item;
                        });
                        
                        $portal.system.setSelect({
                            id      : "id_n",
                            value   : "d_asenta",
                            slt     : $("#rsAsentaStr"),
                            store   : r.cpData,
                            selectpicker   : true,
                            defaultOption  : true,
                            defaultOptionLabel   : "seleccionar",
                            defaultOptionId      : -1,
                            optionSelected       : null,
                            });
                        $("#rsAsentaStr").change(setDataDir);
                        $("#rsPaisStr").val("");
                        $("#rsEdoStr").val("");
                        $("#rsCiudadStr").val("");
                        $("#rsMnpioStr").val("");
                    }
                }
            }).always(()=>{ loading.close(); });
        }
    }

    function setDataDir() {
        extObj = {};
        let selected = $("#rsAsentaStr").val();
        let row = rowMap[selected];
        
        extObj.rsColoniaStr = row.d_asenta;
        extObj.rsMunIdN = row.c_mnpio;
        extObj.rsEdoIdN = row.c_estado;

        $("#rsPaisStr").val(row.pais_desc_str);
        $("#rsEdoStr").val(row.edo_desc_str);
        $("#rsCiudadStr").val(row.c_m_str);
        $("#rsMnpioStr").val(row.c_m_str);
        
    } 
	
    $.fn.rfcValidate = function() {
            const rfcPattern = /^([A-ZÑ&]{3,4})?(\d{2}(0[1-9]|1[0-2])(0[1-9]|[12]\d|3[01]))([A-Z\d]{2})([A\d])$/i;

            this.on('input', function(evt) {
                const value = $(this).val().toUpperCase();
                rfcValid = rfcPattern.test(value);
                const $input = $(this);
                const $formSpanError = $input.closest('.form-group').find('.form-span-error');

                if (rfcValid) {
                    $formSpanError.text('');
                } else {
                    $formSpanError.text('no válido');
                }

                $input.val(value);
            });

            return this; 
        };

    function llenarCampos(){
        console.log($row);

        $("#rsNombreStr").val($row.rs_nombre_str);
        $("#rsRfcStr").val($row.rs_rfc_str).trigger('input');;
        $("#rsCpStr").val($row.rs_cp_str);
        $("#rsPaisStr").val($row.pais_desc_str);
        $("#rsEdoStr").val($row.edo_desc_str);
        $("#rsCiudadStr").val($row.rs_ciudad_str);
        $("#rsMnpioStr").val($row.rs_ciudad_str);
        $("#rsCalleStr").val($row.rs_calle_str);
        $("#rsNumExtStr").val($row.rs_num_ext_str);
        $("#rsNumIntStr").val($row.rs_num_int_str);
        $("#rsEstStr").val($row.rs_est_str);
    }

	this.init = ()=>{
		$dialog.setTitle('Actualizar razón social');
		$dialog.getButton("btnOK").hide();
		$dialog.getButton("btnCANCEL").hide();
		$(".modal-footer").hide();

        $("#rsTipoN").html($razonSoc.tipoOptions);
        try{ $("#rsTipoN").selectpicker('destroy');  }catch(e){}
		$("#rsTipoN").selectpicker({width:'100%'}); 
        
        $("#rsGiroN").html($razonSoc.giroOptions);
        try{ $("#rsGiroN").selectpicker('destroy');  }catch(e){}
		$("#rsGiroN").selectpicker({width:'100%'}); 

        $portal.system.setSelect({slt:$("#rsAsentaStr"),store: [] ,selectpicker:true,defaultOption:true});

        $('#rsRfcStr').rfcValidate();
        
		try{ $("#rsEstStr").selectpicker('destroy');  }catch(e){}
		$("#rsEstStr").selectpicker({width:'100%'});

		setTimeout( ()=>{ $("#rsNombreStr").focus(); },500);
		
        $("#btnBuscarCP").click(getCPData);

        llenarCampos();
		
        $("#f_btnUpdate").off("click");
		$("#f_btnUpdate").click((e)=>{
            console.log("lol dude");
            e.preventDefault(); 
            let obj = validar();
            console.log(obj);
			let obj_ = $.extend(true, {}, obj, extObj);
            if( obj.valido && rfcValid ) ejecutar(obj_);
		});
	};
}).apply($razonSoc_updateForm);
$(document).ready($razonSoc_updateForm.init);
</script>
<form id="form_updateRazonSoc" class="form-horizontal panel-body">
    <div class="form-group">
        <label class="col-xs-12 col-sm-3 control-label">
            <span class="text-error"><i class="fa fa-asterisk ast-required"></i></span> 
            Nombre:
            <span class="form-span-error"></span>
        </label>
        <div class="col-xs-12 col-sm-9">
            <input class="form-control" id="rsNombreStr" name="rsNombreStr" required="required">
        </div>
    </div>
    <div class="form-group">
        <label class="col-xs-12 col-sm-3 control-label">
            <span class="text-error"><i class="fa fa-asterisk ast-required"></i></span> 
            RFC:
            <span class="form-span-error"></span>
        </label>
        <div class="col-xs-12 col-sm-9">
            <input class="form-control" id="rsRfcStr" name="rsRfcStr" required="required">
        </div>
    </div>
    <div class="form-group">
        <label class="col-xs-12 col-sm-3 control-label lbl-form">
            <span class="text-error"><i class="fa fa-asterisk ast-required"></i></span> 
            Tipo:
            <span class="form-span-error"></span>
        </label>
        <div class="col-xs-12 col-sm-4">
            <select class="form-control" id="rsTipoN" name="rsTipoN" required="required">
            </select>
        </div>
        <label class="col-xs-12 col-sm-2 control-label lbl-form">
            <span class="text-error"><i class="fa fa-asterisk ast-required"></i></span> 
            Giro:
            <span class="form-span-error"></span>
        </label>
        <div class="col-xs-12 col-sm-3">
            <select class="form-control" id="rsGiroN" name="rsGiroN" required="required">
            </select>
        </div>
    </div>

    <div class="form-group">
        <label class="col-xs-12 col-sm-3 control-label lbl-form">
            <span class="text-error"><i class="fa fa-asterisk ast-required"></i></span> 
            CP:
            <span class="form-span-error"></span>
        </label>
        <div class="col-xs-12 col-sm-4">
            <div class="input-group">
                <input class="form-control" id="rsCpStr" name="rsCpStr" required="required" type="number" maxlength="5">
				<span class="input-group-btn" >
					<button id="btnBuscarCP" class="btn btn-primary">
						<i class="fa fa-search"></i> 
					</button>
				</span>		
			</div>
        </div>
        <label class="col-xs-12 col-sm-2 control-label lbl-form">
            <span class="text-error"><i class="fa fa-asterisk ast-required"></i></span> 
            Colonia:
            <span class="form-span-error"></span>
        </label>
        <div class="col-xs-12 col-sm-3">
            <select class="form-control" id="rsAsentaStr" name="rsAsentaStr" required="required">
            </select>
        </div>
    </div>
    <div class="form-group">
        <label class="col-xs-12 col-sm-3 control-label lbl-form">
            Pais:
        </label>
        <div class="col-xs-12 col-sm-4">
            <input class="form-control" id="rsPaisStr" name="rsPaisStr" readonly="readonly">
        </div>
        <label class="col-xs-12 col-sm-2 control-label lbl-form">
            Estado:
        </label>
        <div class="col-xs-12 col-sm-3">
            <input class="form-control" id="rsEdoStr" name="rsEdoStr" readonly="readonly">
        </div>
    </div>
    <div class="form-group">
        <label class="col-xs-12 col-sm-3 control-label lbl-form">
            Ciudad:
        </label>
        <div class="col-xs-12 col-sm-4">
            <input class="form-control" id="rsCiudadStr" name="rsCiudadStr" readonly="readonly">
        </div>
        <label class="col-xs-12 col-sm-2 control-label lbl-form">
            Municipio:
        </label>
        <div class="col-xs-12 col-sm-3">
            <input class="form-control" id="rsMnpioStr" name="rsMnpioStr" readonly="readonly">
        </div>
    </div>
    <div class="form-group">
        <label class="col-xs-12 col-sm-3 control-label">
            <span class="text-error"><i class="fa fa-asterisk ast-required"></i></span> 
            Calle:
            <span class="form-span-error"></span>
        </label>
        <div class="col-xs-12 col-sm-9">
            <input class="form-control" id="rsCalleStr" name="rsCalleStr" required="required">
        </div>
    </div>
    <div class="form-group">
        <label class="col-xs-12 col-sm-3 control-label lbl-form">
            <span class="text-error"><i class="fa fa-asterisk ast-required"></i></span> 
            Num Ext:
            <span class="form-span-error"></span>
        </label>
        <div class="col-xs-12 col-sm-4">
            <input class="form-control" id="rsNumExtStr" name="rsNumExtStr" required="required">
        </div>
        <label class="col-xs-12 col-sm-2 control-label lbl-form">
            Num Int:
        </label>
        <div class="col-xs-12 col-sm-3">
            <input class="form-control" id="rsNumIntStr" name="rsNumIntStr" >
        </div>
    </div>
    
    <div class="form-group">
        <label class="col-xs-12 col-sm-3 control-label lbl-form">
            Estatus:
        </label>
        <div class="col-xs-12 col-sm-4">
            <select class="form-control" id="rsEstStr" name="rsEstStr">
                <option selected="selected" data-icon="fa fa-square pcolor-green" value="A"> Activo</option>
                <option data-icon="fa fa-square pcolor-red" value="I"> Inactivo</option>
            </select>
        </div>
    </div>

    <div class="form-group" style="padding-right: 15px;">
        <div class="col-xs-12 col-sm-4 col-sm-offset-8">
            <button id="f_btnUpdate" class="btn btn-primary form-control"> 
                Actualizar
            </button>
        </div>
    </div>
</form>





