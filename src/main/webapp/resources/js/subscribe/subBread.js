/* 버튼 선택 */
$(document).ready(function(){
    $('.btn-area').each(function(index){
        $(this).attr('btn', index);
    }).click(function(){
        var index = $(this).attr('btn');
        $('.btn-area[menu-index=' + index + ']').addClass('clicked_menu');
        $('.btn-area[menu-index!=' + index + ']').removeClass('clicked_menu');
    });
});
