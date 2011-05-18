SlideShow = function(parent)
{
	if (parent==null)
	{
		this.parent="";
	}else{
		this.parent = parent + " ";
	}
    this.show();
};

SlideShow.prototype = 
{
	show: function() {
	this.slideShowTimeout = 0;
	
	//Set the opacity of all images to 0
	$(this.parent + '.gallery>a').css({opacity: 0.0});
	
	//Add class show to show
	$(this.parent + '.gallery>a:first').addClass('show');
	
	//Resize the width and height of the image according to the gallery
	$(this.parent + '.gallery>a').find('img').css({width: $(this.parent + '.gallery').css('width'), height: $(this.parent + '.gallery').css('height')});
	
	//Resize the width of the caption according to the image width
	$(this.parent + '.gallery .caption').css({width: $(this.parent + '.gallery').css('width') - 20});
	
	//Get the first image and display it (set it to full opacity)
	$(this.parent + '.gallery a:first').css({opacity: 1.0});
	
	//Get the caption of the first image from REL attribute and display it
	$(this.parent + '.gallery .caption').html($(this.parent + '.gallery a:first').find('img').attr('rel')).animate({opacity: 0.7}, 400);
	
	//Add href attribute to a in .caption a
	$(this.parent + '.gallery .caption a').attr('href',$(this.parent + '.gallery a:first').attr('href'));
	
	//Set the caption background to semi-transparent
	$(this.parent + '.gallery .caption').css({opacity: 0.7});
		
	//Call the gallery function to run the slideshow, 6000 = change to next image after 6 seconds
	this.slideShowTimeout = setInterval('gallery(\'' + this.parent + '\')',6000);
},

change: function(index){
	clearInterval(this.slideShowTimeout);

	//if no IMGs have the show class, grab the first image
	var current = $(this.parent + '.gallery a.show');

	//Get next image, if it reached the end of the slideshow, rotate it back to the first image
	var next = $(this.parent + ".gallery a").eq(index - 1);

	$(this.parent + '.gallery .caption a').attr('href',next.attr('href'));
	$(this.parent + 'input.selectednumber').removeClass('selectednumber');
	$(this.parent + 'input').eq(index - 1).addClass('selectednumber');

	//Get next image caption
	var caption = next.find('img').attr('rel');	
	
	//Hide the current image
	current.animate({opacity: 0.0}, 1000)
	.removeClass('show');

	//Set the fade in effect for the next image, show class has higher z-index
	next.css({opacity: 0.0})
	.addClass('show')
	.animate({opacity: 1.0}, 1000);
	
	//Display the content
	$(this.parent + '.gallery .caption').html(caption);
	
	//Add href attribute to a in .caption a
	$(this.parent + '.gallery .caption a').attr('href',$(this.parent + '.gallery a.show').attr('href'));
	
	//Set the opacity to 0 and height to 1px
	$(this.parent + '.gallery .caption').animate({opacity: 0.0}, { queue:false, duration:0 }).animate({height: '1px'}, { queue:true, duration:300 });	
	
	//Animate the caption, opacity to 0.7 and heigth to 100px, a slide up effect
	$(this.parent + '.gallery .caption').animate({opacity: 0.7},100 ).animate({height: '95px'},500 );
	
	this.slideShowTimeout = setInterval('gallery(\'' + this.parent + '\')',6000);
}
};
function gallery(parent) {

if (parent==null)
{
	parent = "";
}
	//if no IMGs have the show class, grab the first image
	var current = ($(parent + '.gallery a.show')?  $(parent + '.gallery a.show') : $(parent + '.gallery a:first'));

	//Get next image, if it reached the end of the slideshow, rotate it back to the first image
	var next = ((current.next().length) ? ((current.next().hasClass('caption'))? $(parent + '.gallery a:first') :current.next()) : $(parent + '.gallery a:first'));	

	$(parent + '.gallery .caption a').attr('href',next.attr('href')); 
	
	var currentNumber = $(parent + 'input.selectednumber').attr('value');
	if(currentNumber==null || currentNumber>6){
		currentNumber = 0;
	}

	$(parent + 'input.selectednumber').removeClass('selectednumber');
	$(parent + 'input').eq(currentNumber).addClass('selectednumber');

	//Get next image caption
	var caption = next.find('img').attr('rel');	
	
	//Set the fade in effect for the next image, show class has higher z-index
	next.css({opacity: 0.0})
	.addClass('show')
	.animate({opacity: 1.0}, 1000);
	
	//Hide the current image
	current.animate({opacity: 0.0}, 1000)
	.removeClass('show');
	
	//Display the content
	$(parent + '.gallery .caption').html(caption);
	
	//Add href attribute to a in .caption a
	$(this.parent + '.gallery .caption a').attr('href',$(this.parent + '.gallery a.show').attr('href'));

	//Set the opacity to 0 and height to 1px
	$(parent + '.gallery .caption').animate({opacity: 0.0}, { queue:false, duration:0 }).animate({height: '1px'}, { queue:true, duration:300 });	
	
	//Animate the caption, opacity to 0.7 and heigth to 100px, a slide up effect
	$(parent + '.gallery .caption').animate({opacity: 0.7},100 ).animate({height: '95px'},500 );

}