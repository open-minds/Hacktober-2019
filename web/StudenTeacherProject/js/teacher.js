
			var addinginput;
			var inputnumber;
			$(document).ready(function(){
				inputnumber =document.getElementsByTagName("form").length;
				addinput();

			});
			function addinput(){
				$("#qstn"+inputnumber).prop("onclick", null);
				inputnumber++;

				var qstn = '<form action="teacher.php" method="POST" ><input id="qstn'+inputnumber+'" onclick="addinput()" type="text" name="qstn"> <input id="ansr'+inputnumber+'"  type="text" name="ansr"> <select name="Domain"><optgroup label="Domain"><option value="Informatique">Informatique</option><option value="Informatique">Biologie</option><option value="Math">Math</option><option value="Physique">Physique</option><option value="Pharmacy">Pharmacy</option></select> <input type="submit" name="submit"></form>';

				$("#qstnswrpr").append(qstn);

				for(var i=0; i<document.forms.length; i++){
					var form = document.forms[i];
					form.addEventListener("submit", myListener,false);
				}			
			}
			function myListener(e){
				e.preventDefault();
				var question = $(this).find('input[name="qstn"]').val();
				var answer = $(this).find('input[name="ansr"]').val();
				var domain = $(this).find("select").val();
				$.ajax(
				{
					url :'teachersrvr.php',
					method : 'POST',
					data: {
						domainphp: domain,
						questionphp: question,
						answerphp:answer
					},
					dataType : 'text'
				});
				$(this).remove();
			}
			

