

//url to http server
//example "http://localhost:8080/japp/service?room=ROOM1"
var url = "http://localhost:8080/japp/service"; 


/**onClick to change room status
 * send http GET request to the server
 * Request server to change the status of room 
 
 
 */
$('#ROOM2').on('click', function(){
    $.get(url,{ room: "ROOM2"}, function(data) {
        var result = data.toString();
        console.log(data);
        //checking status of light 
        if (result == 1 ) {
            $('#ROOM2').removeClass('off');
            $('#ROOM2').addClass('on');
        }
        else{
            $('#ROOM2').removeClass('on');
            $('#ROOM2').addClass('off');
        }
    });
});


$('#ROOM3').on('click', function(){
    $.get(url,{ room: "ROOM3"}, function(data, status  ) {
        var result = data.toString();
        console.log(data);

        if (result == 1 ) {
            $('#ROOM3').removeClass('off');
            $('#ROOM3').addClass('on');
        }
        else{
            $('#ROOM3').removeClass('on');
            $('#ROOM3').addClass('off');
        }
    });
});


$('#ROOM4').on('click', function(){
    $.get(url,{ room: "ROOM4"}, function(data, status  ) {
        var result = data.toString();
        console.log(data);

        if (result == 1 ) {
            $('#ROOM4').removeClass('off');
            $('#ROOM4').addClass('on');
        }
        else{
            $('#ROOM4').removeClass('on');
            $('#ROOM4').addClass('off');
        }
    });
});


$('#ROOM5').on('click', function(){
    $.get(url,{ room: "ROOM5"}, function(data, status  ) {
        var result = data.toString();
        console.log(data);

        if (result == 1 ) {
            $('#ROOM5').removeClass('off');
            $('#ROOM5').addClass('on');
        }
        else{
            $('#ROOM5').removeClass('on');
            $('#ROOM5').addClass('off');
        }
    });
});


$('#ROOM1').on('click', function(){
    $.get(url,{ room: "ROOM1"}, function(data, status  ) {
        var result = data.toString();
        console.log(data);

        if (result == 1 ) {
            $('#ROOM1').removeClass('off');
            $('#ROOM1').addClass('on');
        }
        else{
            $('#ROOM1').removeClass('on');
            $('#ROOM1').addClass('off');
        }
    });
});

