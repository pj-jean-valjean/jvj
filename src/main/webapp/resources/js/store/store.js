  $(document).ready(function () {
    $('.content').click(function () {
      $(this).toggleClass("heart-active");
      $(this).next().toggleClass("heart-active");
      $(this).children().toggleClass("heart-active");
    });
  });
  
   $(".pdt-img").click(function(){
  
    $(this).addClass("outer");
    $(this).addClass("bingel").toggleClass("emphasized");
    $(this).css({ "position": "fixed", "top": "41%", "left":"43%"}).css("z-index","999");
    
    
    setTimeout(() => {location.href ="store/info"}, 1500);
    
  

  });

  