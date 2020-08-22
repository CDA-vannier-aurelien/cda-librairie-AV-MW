function testEmail() {
    var email = $('#email').val();
    $.ajax({
        data: {mail: email},
        type: 'POST',
        url: 'checkmail',
        success: function (result) {
            $('#result').html(result);

        }
    });
}

function transfertRefAndQuantitee(reference,quantitee){
	
	$('#transfertB').val(reference);
	$('#ancienneQuantitee').html(" " +quantitee);
	
}

function transfertRef(reference){
	
	$('#transfert').val(reference);
	$('#idLivre').html(" " +reference);
	
}

function testReference() {
    var reference = $('#reference').val();
    $.ajax({
        data: {reference: reference},
        type: 'Post',
        url: 'checkRef',
        success: function (result) {

            if (result === "exists") {
                $('#result').html("référence non valide");
                $('#valider').attr("disabled", true);
                $('#result').attr("class", "text-danger error");
            } else {
                $('#valider').attr("disabled", false);
                $('#result').html("référence valide");
                $('#result').attr("class", "text-success");

            }
        }
        
    })}
function testAuteur(){
	var auteur = $('#nomUsageAuteur').val();
    $.ajax({
    	data:{nomUsage:auteur},
        type:'Post',
        url:'checkAuteur',
        success:function (result) {
            
            if(result==="exists"){
            	$('#resultTestAuteur').html("Auteur déjà présent");
            	$('#ajoutAuteur').attr("disabled", true);
            	$('#resultTestAuteur').attr("class","text-danger error");
            }else{
            	$('#ajoutAuteur').attr("disabled", false);
            	$('#resultTestAuteur').html("Auteur valide");
            	$('#resultTestAuteur').attr("class","text-success");
            	
            }
        }
        
    })}
function testEditeur(){
	var editeur = $('#nomEditeur').val();
    $.ajax({
        data:{nom:editeur},
        type:'Post',
        url:'checkEditeur',
        success:function (result) {
            
            if(result==="exists"){
            	$('#resultTestEditeur').html("Editeur déjà présent");
            	$('#ajoutEditeur').attr("disabled", true);
            	$('#resultTestEditeur').attr("class","text-danger error");
            }else{
            	$('#ajoutEditeur').attr("disabled", false);
            	$('#resultTestEditeur').html("Editeur valide");
            	$('#resultTestEditeur').attr("class","text-success");
            	
            }
        }
        
    })}

function addOptionAuteur(){
	var auteur = $('#auteur').val();
	
    if(auteur.length>1) {
    	$('#listAuteur').empty();
    	
    $.ajax({
        data:{nomUsage:auteur},
        type:'post',
        url:'addOptionAuteur',
        success:function (result) {
        	result = JSON.parse(result);
        	if(result.length>0){
        		$("#butttonModalAuteur").attr('class',"d-none");
        		$.each(result,function(element , nom){
            		
            		 $('#listAuteur').append($("<option>").attr('value', nom).text(nom));
            		  $('#valider').attr("disabled", false);
 
            	})
        	}else {
        		$("#butttonModalAuteur").attr('class',"text-danger error");
        		  $('#valider').attr("disabled", true);
        	}
        	}
        
    })}else {
    	$("#butttonModalAuteur").attr('class',"d-none");
    }}

function addOptionEditeur(){
    var editeur = $('#editeur').val();
    if(editeur.length>1){
    	$('#listEditeur').empty();
    	
    
    $.ajax({
        data:{nom:editeur},
        type:'post',
        url:'addOptionEditeur',
        success:function (result) {
        	result = JSON.parse(result);
        	if(result.length>0){
        		$("#butttonModalAuteur").attr('class',"d-none");
        		$.each(result,function(element , nom){
            		 $('#listEditeur').append($("<option>").attr('value', nom).text(nom));
            		  $('#valider').attr("disabled", false);
            	})
        	}else {
        		$("#butttonModalAuteur").attr('class',"text-danger error");
        		  $('#valider').attr("disabled", true);
        	}
        	
        	
        }
        
    })}else {
    	$("#butttonModalAuteur").attr('class',"d-none");
    }}



$(function () {
    $('[data-toggle="tooltip"]').tooltip()
})


function afficherModaleSuppression(mail) {
    $('#idToDeleteText').text(mail);
    $('#idToDelete').val(mail);
    $('#modaleSuppression').modal('show');
}


function calculPrixTotal() {
    var listePrix = document.getElementsByName("totalLigne");

    var prixTotal = 0;

    listePrix.forEach(elements => {
        prixTotal = prixTotal + parseFloat(elements.innerText);
    })

    var retour = document.getElementById("sousTotal");
    retour.innerText = prixTotal;

    var frais = parseFloat(document.getElementById("frais").innerText);

    var taxe = prixTotal * 0.2;


    var taxes = document.getElementById("taxes");
    taxes.innerText = taxe;

    var prixTotalCommande = frais + taxe + prixTotal;

    retour = document.getElementById("totalCommande");
    retour.innerText = prixTotalCommande;

}


function supprimerLigne(corbeilleId) {

    var corbeille = document.getElementById("corbeille" + corbeilleId);

    corbeille.submit();
}

