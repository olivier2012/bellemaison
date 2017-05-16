function changebigpic(picurl,tip){
    $('#show_box').html('<img src='+picurl+' width:600;height:400;\>');
    console.log(picurl);
    
}

$("li[role='tab']").click(function(){
    $("li[role='tab']").attr("aria-selected","false");
    $(this).attr("aria-selected","true");
    var tabpanid=$(this).attr("aria-controls");
    console.log(tabpanid);
    var tabpan = $("#"+tabpanid);
     console.log(tabpan);
    changebigpic('./res/pic/house_1.jpg','house_1.jpg' );
    $("div[role='tabpanel']").attr("aria-hidden","true");
    tabpan.attr("aria-hidden","false");
});
/* use the keyboard to control the panel switch*/
$("li[role='tab']").keydown(function(ev) {
if (ev.which ==13) {
$(this).click()
}
});

//This adds keyboard function that pressing an arrow left or arrow right from the tabs toggle the tabs.
$("li[role='tab']").keydown(function(ev) {
if ((ev.which ==39)||(ev.which ==37)) {
 var selected= $(this).attr("aria-selected");
 if (selected =="true"){
   $("li[aria-selected='false']").attr("aria-selected","true").focus() ;
   $(this).attr("aria-selected","false");
   var tabpanid= $("li[aria-selected='true']").attr("aria-controls");
   var tabpan = $("#"+tabpanid);
   $("div[role='tabpanel']").attr("aria-hidden","true");
   tabpan.attr("aria-hidden","false");
   }
}
});


$('#img_thumbnail').click(function()                              {
    
    var get_pic = $('#img_thumbnail').html();
    console.log(get_pic);
});