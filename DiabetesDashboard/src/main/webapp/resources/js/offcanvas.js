
$(document).ready(function () {
  $('[data-toggle="offcanvas"]').click(function () {
    $('.row-offcanvas').toggleClass('active')
  });
});

$(".more").toggle(function(){
    $(this).text(" hide").css({"color":"orange","font-weight":"200"}).siblings(".complete").show("slow");    
}, function(){
    $(this).text("more...").css({"color":"orange","font-weight":"200"}).siblings(".complete").hide();    
});


