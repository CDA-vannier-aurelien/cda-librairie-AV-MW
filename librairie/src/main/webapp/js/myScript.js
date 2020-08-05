function testlogin(){
    var login = $('#login').val();

    $.ajax({
        type:'POST',
        data:{login:login},
        url:'LoginServlet',
        success:function (result) {
            $('#result').html(result);
        }
    });
}
