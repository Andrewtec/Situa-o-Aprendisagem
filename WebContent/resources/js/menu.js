$(function(){
	if(location.href.substr(-1) == '/'){
		$('#menu_princilal li:first').addClass('active');
	}else{
	$('#menu_principal li a').each(function(){
		if (location.href == this.href){
			$(this.parentElement).addClass('active');
		}
	
	});
	}
})