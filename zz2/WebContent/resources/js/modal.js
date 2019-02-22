/**
 * 
 */

//modal-login
$(".modalBtn").on("click",function(){
   alert('하이!');
});
//modal-close-area
$("body").click(function(e){
   if($(".modal-login").hasClass("open")){ // site 라는 특정영역이 열려있을 경우
      if(!$(".modal-login").has(e.target).length){ // site에 클릭 이벤트가 발생되어 있는게 없다면 아래 내용을 실행.
         $('.modal-login').removeClass('open');
         setTimeout(function() {
            $(".modal-login").css('display','none');
         }, 50)
      }
   }
})
//modal-close-btn
$(".modal-close").on("click",function(){
   $('.modal-login').removeClass('open');
   setTimeout(function() {
      $(".modal-login").css('display','none');
   }, 50)
});

