// $("btn-secondary").click(function () {
//     $(".exampleModalCenter").removeClass("show")
// });

$(document).on("click", ".open-AddDialog", function () {
    var image = $(this).data('image');
    $(".modal-body #base64String").val(image);
});

$('#cls').click(function () {
    $('#modal').delay(1).fadeOut(1);
    setTimeout(function () {
        $('#modal').modal("hide");
    }, 200);
});

$(function () {
    var includes = $('[data-include]')
    $.each(includes, function () {
        var file = 'templates/layouts/' + $(this).data('include') + '.html'
        $(this).load(file)
    })
})

$(function () {
    var includes = $('[data-included]')
    $.each(includes, function () {
        var file = 'templates/partial/' + $(this).data('include') + '.html'
        $(this).load(file)
    })
})