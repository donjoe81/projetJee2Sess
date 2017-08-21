/**
 * 
 */

window.onload = init;

function init(){
	$("a_rdv").onclick = listRdv;
}

function listRdv(){
	var xhr = getXHR();
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4) {
			if (xhr.status == 200) {
				callBackListRdv(xhr.responseText);
			}
			else
				$("d_rdv").innerHTML = "pas de resultats";
		}else
			alert("pas de connection");
	}
	xhr.open("GET","vos_rendez_vous.php",true);
	xhr.send(null);
}

function callBackListRdv(rsp){
	alert(rsp);
	$("d_rdv").innerHTML = rsp;
}