
$(document).ready(function () {

  // 滑到主選單，子選單出現
  $('.sub-menu').hide();
  $('.menu>li').hover(function () {
    if ($('> ul.sub-menu', this).length > 0) {
      $('> ul.sub-menu', this).stop().slideDown('slow');
    }
  }, function () {
    if ($('> ul.sub-menu', this).length > 0) {
      $('> ul.sub-menu', this).stop().slideUp('slow');
    }

  })

  $('.menu>li>a').click(function(){
    $('.menu>li>a').removeClass('menu-active');
    $(this).addClass('menu-active');
  })

  // 首頁--slider
  $(".carousel").carousel({
    interval: 3000
  });

  // 首頁-漢堡選單
  $('.burger-menu').click(function(){
    $('.rightbar').toggleClass('menu-show');
  })

  // 我要領養頁--『更多條件』按鈕
  $('.more-area').hide();
  $('#search-more').click(function(){
    $('.more-area').slideToggle();
  })

  // 我要認養頁面-『依時間排序』『依推薦排序』切換tab
  $('.search-result .tab').click(function(){
    $('.search-result .tab').removeClass('tab-active');
    $(this).addClass('tab-active');
  });
  // 點擊tab後要用ajax發出request，替換內容區塊。

  
  // 用來顯示大圖片用
  var showImage = $('#show-image');

  // 當滑鼠移到 .image 中的某一個超連結時
  $('.photo-list img').mouseover(function(){
    // 把 #show-image 的 src 改成被移到的超連結的位置
    showImage.attr('src', $(this).attr('src'));
    $('.photo-list img').removeClass('selected-img');
    $(this).addClass('selected-img');
  })

});