$(document).ready(function(){
  $("section h1, section h2").each(function(){
    $("nav ul").append("<li class='tag-" + this.nodeName.toLowerCase() + "'><a href='#" + $(this).text().toLowerCase().replace(/ /g, '-').replace(/[^\w-]+/g,'') + "'>" + $(this).text() + "</a></li>");
    $(this).attr("id",$(this).text().toLowerCase().replace(/ /g, '-').replace(/[^\w-]+/g,''));
    $("nav ul li:first-child a").parent().addClass("active");
  });

  $("nav ul li").on("click", "a", function(event) {
    var position = $($(this).attr("href")).offset().top - 190;
    $("html, body").animate({scrollTop: position}, 400);
    $("nav ul li a").parent().removeClass("active");
    $(this).parent().addClass("active");
    event.preventDefault();
  });

  $("h2[id='ejercicios'] ~ ul > li").addClass("oculto")
  $("h2[id='ejercicios'] ~ ul li ul").hide();
  //$("h2[id='ejercicios'] + ul li p").text($("h2[id='ejercicios'] + ul li p").text() + " [ + ]");
  //$("h2[id='ejercicios'] + ul li p:first-child").append("<span> [ + ]</span>");
  $("h2[id='ejercicios'] ~ ul li").click(function() {
    if (!$(this).hasClass("visible")) {
      var nodo_visible = $(this).parent().parent().find("li.visible");
      nodo_visible.find("ul").slideToggle();
      nodo_visible.removeClass("visible").addClass("oculto");
      $(this).find("ul").slideToggle();
      $(this).addClass("visible").removeClass("oculto");
    } else {
      $(this).find("ul").slideToggle();
      $(this).removeClass("visible").addClass("oculto");
    }
    /*var nodo = $(this).find("ul");
    var html = $(this).find("p:first").html();
    alert(html);
    $(this).find("p:first").html(html.replace(" [ - ]", " [ + ]"));
    if (!nodo.hasClass("visible")) {
      $(this).html(html.replace(" [ - ]", " [ + ]"));
      var html = nodo.parent().parent().find("ul.visible").parent().find("p:first").html();
      if (html != null) {
        //alert(html);
        nodo.parent().parent().find("ul.visible").parent().find("p:first").html(html.replace('+', '-'));
      }
      nodo.parent().parent().find("ul.visible").slideToggle();
      nodo.parent().parent().find("ul.visible").removeClass("visible").addClass("oculto");
      nodo.slideToggle();
      nodo.addClass("visible").removeClass("oculto");
    } else {
      var html = nodo.parent().parent().find("ul.visible").parent().find("p:first").html();
      //alert(html);
      nodo.parent().parent().find("ul.visible").parent().find("p:first").html(html.replace('-', '+'));
      nodo.slideToggle();
      nodo.removeClass("visible").addClass("oculto");
    }*/
  });

});
