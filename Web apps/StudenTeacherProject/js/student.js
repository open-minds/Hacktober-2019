$(document).ready(function(){
	function autocomplete(inp, arr) {
		var currentFocus;
		inp.addEventListener("input", function(e) {
			var a, b, i, val = this.value;
			closeAllLists();
			if (!val) { return false;}
			currentFocus = -1;
			a = document.createElement("DIV");
			a.setAttribute("id", this.id + "autocomplete-list");
			a.setAttribute("class", "autocomplete-items");
			this.parentNode.appendChild(a);
			for (i = 0; i < arr.length; i++) {
				if (arr[i].substr(0, val.length).toUpperCase() == val.toUpperCase()) {
					b = document.createElement("DIV");
					b.innerHTML = "<strong>" + arr[i].substr(0, val.length) + "</strong>";
					b.innerHTML += arr[i].substr(val.length);
					b.innerHTML += "<input type='hidden' value='" + arr[i] + "'>";
					b.addEventListener("click", function(e) {
						inp.value = this.getElementsByTagName("input")[0].value;
						closeAllLists();
					});
					a.appendChild(b);
				}
			}
		});
		inp.addEventListener("keydown", function(e) {
			var x = document.getElementById(this.id + "autocomplete-list");
			if (x) x = x.getElementsByTagName("div");
			if (e.keyCode == 40) {
				currentFocus++;
				addActive(x);
			} else if (e.keyCode == 38) {
				currentFocus--;
				addActive(x);
			} else if (e.keyCode == 13) {
				e.preventDefault();
				if (currentFocus > -1) {
					if (x) x[currentFocus].click();
				}
			}
		});
		function addActive(x) {
			/*a function to classify an item as "active":*/
			if (!x) return false;
			/*start by removing the "active" class on all items:*/
			removeActive(x);
			if (currentFocus >= x.length) currentFocus = 0;
			if (currentFocus < 0) currentFocus = (x.length - 1);
			/*add class "autocomplete-active":*/
			x[currentFocus].classList.add("autocomplete-active");
		}
		function removeActive(x) {
			for (var i = 0; i < x.length; i++) {
				x[i].classList.remove("autocomplete-active");
			}
		}
		function closeAllLists(elmnt) {
			var x = document.getElementsByClassName("autocomplete-items");
			for (var i = 0; i < x.length; i++) {
				if (elmnt != x[i] && elmnt != inp) {
					x[i].parentNode.removeChild(x[i]);
				}
			}
		}
		document.addEventListener("click", function (e) {
			closeAllLists(e.target);
		});
	}

	var Domains = ["Informatique","Biologie"];

	autocomplete(document.getElementById("searchbox"), Domains);
	var qid;
	$("#searchform").submit(function(event){
		var domain =$("#searchbox").val();
		$.ajax({
			url : 'studentsrvr.php',
			method : 'POST',
			data : {
				domain : domain
			},
			success:function(response){
				$("#qstnspace").empty();
				if(response=="no result"){
					$("#qstnspace").append("<p>No Result</p>");
				}else{
					for(i=0;i<response.length;i++){
						$("#qstnspace").append('<form ><label for=qstn"'+i+'">'+response[i].qstn+'</label> <input name="ansr" style="width:100px" type="text"> <input type="submit" value="submit"><br>');
						qid = response[i].Qid;
						$("form").last().submit( function(event){
							event.preventDefault();
							var answer = $(this).find('input[name="ansr"]').val();
							
							$.ajax({
								url: 'answers.php',
								method:'POST',
								data: {
								answer : answer,
								qid : qid,
								domain : domain
								}
							});
							$(this).remove();
						});
					}
				}
			},
			dataType: 'json'
		});
	});
});