/**
 * 
 */


function go_search() {
	document.frm.action = "product_list";
	document.frm.submit();
	
}


function go_total() {
	document.frm.key.value= "";
	document.frm.action = "product_list";
	document.frm.submit();
	
}

function go_list() {
	document.frmm.action = "product_list";
	document.frmm.submit();
}

 
function insert_product() {
	document.frmm.action = "insert_product";
	document.frmm.submit();
}

function delete_selected() {
	document.formm.action = "delete_selected";
	document.formm.submit();
}

function make_trip(){
	document.formm.action = "make_trip";
	document.formm.submit();
}


function make_schedule(){
	document.formm.action = "make_schedule";
	document.formm.submit();
}

function numberWithCommas(x) {
    return x.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
}
