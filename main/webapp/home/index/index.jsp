<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>


<link rel="stylesheet" href="owl.carousel/owl.carousel.min.css"></link>
<link rel="stylesheet" href="owl.carousel/owl.theme.default.min.css"></link>
<link rel="stylesheet" href="bootstrap/animate.css">
<link rel="stylesheet" href="bootstrap/bootstrap.min.css">
<script src='https://ajax.googleapis.com/ajax/libs/jquery/2.0.0/jquery.min.js'></script>
<script src="owl.carousel/owl.carousel.min.js"></script>

<!--icon    -->
<link href="https://file.myfontastic.com/q7vPAHfyZAb68aTYyhnm4S/icons.css" rel="stylesheet">
<link href="css/index.css" rel="stylesheet">

 

<script>
$(window).ready(function (params) {
   
    $('.owl-carousel').owlCarousel({
loop:true,
margin:0,
 /*nav:true,   控制列 */
autoWidth:true,   /* 可自行設定輪播寬度 */
items:4,  /* 一頁出現的張數 */
autoplay:true,  /* 自動輪播 */
autoplayTimeout:1000,  /* 輪播速度 */
autoplayHoverPause:true
});
    



})

</script>
</head>
<body>
<jsp:include page="../header/header.jsp"></jsp:include>
          <!--輪播-->
<div class="coustom">
    <div class="col-md-12 owl-carousel owl-theme ">
        <div class="item" style="max-width: 425px; "><a href="#1"><img src="img/15.jpg"></a></div>
        <div class="item" style="max-width: 425px; "><a href="#2"><img src="img/16.jpg"></a></div>
        <div class="item" style="max-width: 425px; "><a href="#3"><img src="img/17.jpg"></a></div>
        <div class="item" style="max-width: 425px; "><a href="#4"><img src="img/18.jpg"></a></div>
        <div class="item" style="max-width: 425px; "><a href="#5"><img src="img/16.jpg"></a></div>
        <div class="item" style="max-width: 425px; "><a href="#6"><img src="img/17.jpg"></a></div>
        <div class="item" style="max-width: 425px; "><a href="#7"><img src="img/18.jpg"></a></div>
     </div>
    </div>
<script src="./bootstrap/bootstrap.js"></script>
<jsp:include page="../footer/footer.jsp"></jsp:include>
<script src="js/index.js"></script>
</body>
</html>