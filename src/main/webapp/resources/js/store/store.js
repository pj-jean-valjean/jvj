  $(document).ready(function () {
    $('.content').click(function () {
      $(this).toggleClass("heart-active");
      $(this).next().toggleClass("heart-active");
      $(this).children().toggleClass("heart-active");
    });
  });