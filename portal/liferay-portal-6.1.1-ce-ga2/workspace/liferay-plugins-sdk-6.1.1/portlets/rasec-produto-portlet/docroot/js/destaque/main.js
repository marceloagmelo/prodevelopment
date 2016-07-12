$(document).ready(function() {

	//When page loads...
	$(".conteudoDestaqueProd").hide(); //Hide all content
	$("ul.tabs2 li:first").addClass("active").show(); //Activate first tab
	$(".conteudoDestaqueProd:first").show(); //Show first tab content

	//On Click Event
	$("ul.tabs2 li").click(function() {

		$("ul.tabs2 li").removeClass("active"); //Remove any "active" class
		$(this).addClass("active"); //Add "active" class to selected tab
		$(".conteudoDestaqueProd").hide(); //Hide all tab content

		var activeTab = $(this).find("a").attr("href"); //Find the href attribute value to identify the active tab + content
		$(activeTab).fadeIn(); //Fade in the active ID content
		return false;
	});

	});