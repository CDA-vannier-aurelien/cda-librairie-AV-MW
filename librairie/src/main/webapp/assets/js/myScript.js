

function testEmail(){
    var email = $('#email').val();
    $.ajax({
        data:{mail:email},
        type:'POST',
        url:'checkmail',
        success:function (result) {
            $('#result').html(result);

        }
    });
}

$(function () {
    $('[data-toggle="tooltip"]').tooltip()
})


function afficherModaleSuppression(mail){
	$('#idToDeleteText').text(mail);
	$('#idToDelete').val(mail);
	$('#modaleSuppression').modal('show');
}


function calculPrixTotal(){
var listePrix = document.getElementsByName("totalLigne");
	
	var prixTotal = 0;
	
	listePrix.forEach(elements =>{
		prixTotal = prixTotal + parseFloat(elements.innerText);
	})
	
	var retour = document.getElementById("sousTotal");
	retour.innerText = prixTotal;	
	
	var frais = parseFloat(document.getElementById("frais").innerText);
	
	var taxe = prixTotal*0.2;
	
	
	var taxes = document.getElementById("taxes");
	taxes.innerText=taxe;
	
	var prixTotalCommande = frais +taxe + prixTotal;
	
	retour = document.getElementById("totalCommande");
	retour.innerText = prixTotalCommande;
}

