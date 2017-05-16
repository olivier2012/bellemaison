            
    function submit(){
          var get_firstname=document.getElementById("firstname").value ;
           var get_lastname=document.getElementById ("lastname").value;
         var get_email=document.getElementById("email").value;
           var get_address=document.getElementById("address").value;
            var get_result= get_firstname+' '+get_lastname+' '+get_email+' '+get_address;
            // alert(result);
           /*show the user value on the below sheet .  */
         console.log(get_result);
           document.getElementById("result").innerHTML = get_result ;

    }

    function reset(){
          document.getElementById("firstname").value =" " ;
          document.getElementById ("lastname").value =" ";
          document.getElementById("email").value=" ";
          document.getElementById("address").value = " ";
          var get_result= " ";
          document.getElementById("result").innerHTML = get_result ;

            // alert(result);
           /*show the user value on the below sheet .  */
         console.log(get_result);

    }