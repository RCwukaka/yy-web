function show(){ 
var alertPart=document.getElementById("alert"); 
alertPart.style.display="block"; 
alertPart.style.position = "absolute"; 
alertPart.style.top = "20%"; 
alertPart.style.left = "30%"; 
alertPart.style.marginTop = "-75px"; 
alertPart.style.marginLeft = "-150px"; 
alertPart.style.background="cyan"; 
alertPart.style.width="300px"; 
alertPart.style.height="200px"; 
alertPart.style.zIndex = "501"; 

var mybg = document.createElement("div"); 
mybg.setAttribute("id","mybg"); 
mybg.style.background = "#000"; 
mybg.style.width = "100%"; 
mybg.style.height = "100%"; 
mybg.style.position = "absolute"; 
mybg.style.top = "0"; 
mybg.style.left = "0"; 
mybg.style.zIndex = "500"; 
mybg.style.opacity = "0.4"; 
mybg.style.filter = "Alpha(opacity=30)"; 
document.body.appendChild(mybg); 
document.body.style.overflow = "hidden"; 
} 