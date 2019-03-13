/** Ajax Login pop up**/

$(document).ready(function() {
	 
	
    //Stops the submit request
    $("#loginForm").submit(function(e){
           e.preventDefault();
           var id  = $('#uname').val();
           var psw = $('#psw').val();
           $.ajax({
         	  type : 'POST',
         	  url : 'connexion',
         	  data : "uname=" + id +"&psw=" +psw,
         	  success : function(data){
         		  if(jQuery.isEmptyObject(data.erreurs)){
         	            window.location.reload(true); 
         		  }else {
         			  $.each(data.erreurs,function(key,value){
         				 //alert(data.resultat+"	"+value);
         				 $("."+key).append("<span class='error'>"+value+"</span>");
         			  });
         			 $('.resultat').append("<span class='error'>"+data.resultat+"</span>");
         		  }
         	  },
         	  error : function(msg){
         		 
         	  }
           });
    });
    
    
});