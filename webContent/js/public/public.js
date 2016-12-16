/*轮播图*/
function carouselFn(index,caroDiv,aCarouselNav){
	this.index = index;
	this.caroDiv = caroDiv;
	this.caroList = this.caroDiv.find('.carouselList');
	this.aCarouselNav=aCarouselNav;
	this.width = this.caroDiv.width();
	this.length = this.caroList.find('li').length;
}
carouselFn.prototype.aRight=function(){
	this.index++;
	this.index=this.index % this.length;
	
	this.caroList.stop(true,true).animate({
		"left":-this.index*this.width
	},800);
	
	/*console.log(this.aCarouselNav);*/
	
	if(this.aCarouselNav){		
		this.aCarouselNav.each(function(i){
			$(this).removeClass('active');
		});
		this.aCarouselNav.eq(this.index).addClass('active');
	}
}
