
/*
$("#iframe").on('load',function($){
    alert("mm")
});
*/
$(window).on('load',function(){
    alert("windows loading ..")   
    
})
/* the unload function does not work !! 
$(window).on('unload',function(){
    window.open();
    var c =confirm("Are you sure ?")
    if(c){
        return true;
    } else {
        return false;
    }
});
*/

$(document).ready(function(){
    alert("document ready !");
  $('#toggle_message').click(function(){
     $('p').toggle(); 
      
    var count=$('*').length;
    console.log('there are '+count +' elements in the page !');
    
    var count1=$('#area').find('*').length;
    console.log('there are '+count1 +' elements in the area !');
      
  });  
      
   
});

