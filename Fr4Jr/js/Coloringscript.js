//Benyamina Mohammed - Belaroui Samir
const canvas = document.getElementById("mainDraw");
canvas.width = 470;
canvas.height=525;
const context = canvas.getContext("2d");
context.strokeStyle ="#ff4141";
context.lineWidth = 10;
context.lineCap = "round";

let shouldPaint = false;

const can = document.getElementById("Interface");
can.width = 470;
can.height=525;
const con = can.getContext("2d");

  base_image = new Image();
  base_image.src = 'images/clrbird.png';
  base_image.onload = function(){
    con.drawImage(base_image, 0, 0,470,525);
  }

document.addEventListener("mousedown", function (event){
	
	shouldPaint= true;
	context.moveTo(event.pageX -canvas.offsetLeft ,event.pageY -canvas.offsetTop);
	context.beginPath();

});
document.addEventListener("mouseup",function(event){
	shouldPaint = false;
});

document.addEventListener("mousemove",function(event){
	if(shouldPaint){
		context.lineTo(event.pageX -canvas.offsetLeft ,event.pageY -canvas.offsetTop);
		context.stroke();
	}
});
document.querySelectorAll("nav a").forEach(link => {
	link.addEventListener("click",function(event){
		if(this.className == "size"){
			context.lineWidth = this.getAttribute("data-value");
		}else{
		context.strokeStyle = this.style.backgroundColor ;
	}
	})
});
bird = new Image();
    	bird.src = 'images/clrbird.png';
monkey = new Image();
    	monkey.src = 'images/clrmonkey.png';
hamtaru = new Image();
    	hamtaru.src = 'images/clrhamtaru.png';
function imgClick(id){
	con.clearRect(0, 0, canvas.width, canvas.height);
	context.clearRect(0, 0, canvas.width, canvas.height);
	if(id=="bird"){
		
    	con.drawImage(bird, 0, 0,470,525);
	}else{
		if(id=="monkey"){
		
    	con.drawImage(monkey, 0, 0,470,525);
	}else{
		
    	con.drawImage(hamtaru, 0, 0,470,525);
	}
	}
}