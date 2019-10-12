//Benyamina Mohammed - Belaroui Samir
var counter =0;
$("document").ready(function() {
  $(".child").draggable({
    revert: true

  });
  $(".parent").droppable({
    accept: '.child',
    drop: function(event, ui) {
      var move = $(this).children().detach();
      $(ui.draggable).parent().append(move);
    $(this).append($(ui.draggable));
    var dragged = $(ui.draggable).attr("id");
    var container= $(this).attr("id");
    if($("#"+container).hasClass(dragged)){
      container = container.substring(0,container.length-1);
      counter++;
      $("#"+container+"1").css("filter","grayscale(0%)");
      ui.draggable.draggable({disabled: true});
      if(counter==8){
      $("#blurrr *").not("#Replay").css({ 
       "filter": "blur(8px)",
  "-webkit-filter": "blur(8px)"});
      $("#Replay").css("visibility","visible");

    }
    }
    }
  });
});


function randPic(){
	 var txtlist = ["Lion","Tigre","Singe","Abeille","Cheval","Oiseau","Elephant","Ours"];
	 var piclist = ["Lion","Tigre","Singe","Abeille","Cheval","Oiseau","Elephant","Ours"];
	 for(i=0;i<8;i++){
		var ran =Math.floor(Math.random()*txtlist.length);
			document.getElementById("child"+i).innerHTML= txtlist[ran];
			document.getElementById("child"+i).id= txtlist [ran];
  			txtlist.splice(ran, 1);
	}
}