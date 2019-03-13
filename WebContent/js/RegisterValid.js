(function() {
  'use strict';
  window.addEventListener('load', function() {
    // Fetch all the forms we want to apply custom Bootstrap validation styles to
    var forms = document.getElementsByClassName('needs-validation');
    // Loop over them and prevent submission
    var validation = Array.prototype.filter.call(forms, function(form) {
      form.addEventListener('submit', function(event) {
        if (form.checkValidity() === false) {
          event.preventDefault();
          event.stopPropagation();
          var id  = $('#uname').val();
          var email  = $('#email').val();
          var bday = $('#bday').val();
          var psw = $('#pwd').val();
          var conf = $('#confirmation').val();
          alert("Ajax register");
          $.ajax({
        	  type : 'POST',
        	  url : 'register?action=validate',
        	  data : "uname=" + id +"&email="+email+"&bday="+bday+"&psw=" +psw+"&confirmation="+conf,
        	  success : function(data){
        		 if(jQuery.isEmptyObject(data.erreurs)){
        			 alert(data.resultat);
        		 }else{
        			 alert(data.resultat+"	"+value);
        			 $.each(data.erreurs,function(key,value){
         				 $("."+key).append(value);
         			  });
        		 }
        	  },
        	  error : function(msg){
        		 
        	  }
          });
        }
        form.classList.add('was-validated');
      }, false);
    });
  }, false);
})();  