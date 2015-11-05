/**
 * @author mady
 * @project myLibe
 */

/**
 * Call a ajax request for add a form to add a user
 * 
 */
var addUser = function () {
	var url = location.host + "/mylibe/view/admin/adduser.jsp"
	ajaxRequest(url);
}


var editUser = function () {
	alert("frs");
}

var deleteUser = function () {
	alert("frsds");
}

/**
 * Ajax request for user
 * @param {type} url
 * @returns {undefined}
 */
var ajaxRequest = function (url) {
	var dados = $("admin-user-form").serialize();
    $.ajax({
        type: 'POST',
        url: url,
        data: dados,
        cache: true,
        beforeSend: function () {
            var load = '<div style="z-index: 10;"><img src="./pix/ring.svg">' +
            '<p style="color: #088a08;">Carregando gráfico...</p></div>';
            $(".chartGl").prepend(load);      
                },
        success: function (result) {
            $("#ajax-response").empty();
            $("#ajax-response").html(result);
        },
        error: function (e, f) {
            console.log(e);
            console.log(f);
            $("#ajax-response").empty();
            $("#ajax-response").html("<h4 style=\"color: red;\">Erro no carregamento</h4>");
        }
    });
}

