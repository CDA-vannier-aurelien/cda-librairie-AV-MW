

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

function testReference(){
    var reference = $('#reference').val();
    $.ajax({
        data:{reference:reference},
        type:'Post',
        url:'checkRef',
        success:function (result) {
            
            if(result==="exists"){
            	$('#result').html("référence non valide");
            	$('#valider').attr("disabled", true);
            	$('#result').attr("class","text-danger error");
            }else{
            	$('#valider').attr("disabled", false);
            	$('#result').html("référence valide");
            	$('#result').attr("class","text-success");
            	
            }
        }
        
    })}

function testAuteur(){
	var auteur = $('#auteur').val();
    if(auteur.length>1){
    	$('#listAuteur').empty();
    	
    $.ajax({
        data:{nomUsage:auteur},
        type:'post',
        url:'checkAuteur',
        success:function (result) {
        	console.log(JSON.parse(result))
        	result = JSON.parse(result);
        	$.each(result,function(element , nom){
        		console.log(nom);
        		 $('#listAuteur').append($("<option>").attr('value', nom).text(nom))
        	})}
        
    })}}

function testEditeur(){
    var editeur = $('#editeur').val();
    if(editeur.length>1){
    	$('#listEditeur').empty();
    	
    
    $.ajax({
        data:{nom:editeur},
        type:'post',
        url:'checkEditeur',
        success:function (result) {
        	console.log(JSON.parse(result))
        	result = JSON.parse(result);
        	$.each(result,function(element , nom){
        		console.log(nom);
        		 $('#listEditeur').append($("<option>").attr('value', nom).text(nom))
        	})
        	
            
//            if(result==="exists"){
//            	$('#resultEditeur').html("référence non valide");
//            	$('#valider').attr("disabled", true);
//            	$('#resultEditeur').attr("class","text-danger error");
//            }else{
//            	$('#valider').attr("disabled", false);
//            	
//            	$('#resultEditeur').attr("class","text-success");
//            	
//            }
        }
        
    })}}



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


function supprimerLigne(corbeilleId){
	
	var corbeille = document.getElementById("corbeille" + corbeilleId);
	
	corbeille.submit();
}

