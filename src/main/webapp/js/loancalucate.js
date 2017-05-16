

 function calculate() {
    var get_loanterm =parseInt(document.getElementById("loanterm").value);
     console.log(get_loanterm);
    var get_loanmount = parseInt(document.getElementById("loanmount").value)
    var get_interestrate = parseFloat(document.getElementById("interestrate").value)
    var get_result= get_loanterm+(get_loanmount*get_interestrate/12)/(1-1/Math.pow((1+get_interestrate/12),12));
     console.log(get_result)
    document.getElementById("result").innerHTML = get_result;
}  

 function reset(){
    document.getElementById("loanterm").value=" ";
  //   console.log(get_loanterm);
    document.getElementById("loanmount").value =" ";
    document.getElementById("interestrate").value=" ";
    var get_result= " ";
     console.log(get_result)
    document.getElementById("result").innerHTML = get_result;
    
}  
