
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



$(function () {
    $('[data-toggle="tooltip"]').tooltip()
})


function afficherModaleSuppression(mail){
	$('#idToDeleteText').text(mail);
	$('#idToDelete').val(mail);
	$('#modaleSuppression').modal('show');
}