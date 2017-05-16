document.getElementById("screen.w").innerHTML = "Screen Width : " + screen.width;
document.getElementById("screen.h").innerHTML = "Screen height : " + screen.height;
document.getElementById("screen.aw").innerHTML = "Available Screen Width : " + screen.availWidth;
document.getElementById("screen.ah").innerHTML = "Available Screen height : " + screen.availHeight;
document.getElementById("screen.cd").innerHTML = "Screen color Depth : " + screen.colorDepth;
document.getElementById("screen.pd").innerHTML = "Screen pixel Depth : " + screen.pixelDepth;

var w = window.innerWidth
|| document.documentElement.clientWidth
|| document.body.clientWidth;

var h = window.innerHeight
|| document.documentElement.clientHeight
|| document.body.clientHeight;

document.getElementById("window.open").innerHTML = "Browser inner windows width : "+w +", height: "+ h;
/*
document.getElementById("window.open").addEventListener('mousedown',(function (){window.open(1);});
document.getElementById("window.close").addEventListener('mousedown',(function (){window.close();});
document.getElementById("window.moveTo").addEventListener('mousedown',(function (){window.moveTo();});
document.getElementById("window.resizeTo").addEventListener('mousedown',(function (){window.resizeTo();}); */
document.getElementById("window.header").innerHTML = "window header : " + window.document.getElementById("header");                                                            