$(function () {
	
	$('[data-toggle="popover"]').popover('show');
	
});

$(function () {
    $('[data-toggle="tooltip"]').tooltip('show');
});

$(function () {
    $("#chatClient").click(function () {
        
        var w = window.open("cliente.html", "popupWindow", "width=600, height=400, scrollbars=yes");
        var $w = $(w.document.body);
        
        //$w.html("<textarea></textarea>");
    });
});
