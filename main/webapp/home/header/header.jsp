<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


   <div class="newlo">
         <div class="innerlo">
         </div>
   </div>
   
   
   <!-- cart -->
     <div class="cart">
     
     <table class="cartT">
		<tr>
			<td>商品名稱</td>
			<td>顏色</td>
			<td>尺寸</td>
			<td>數量</td>
			<td>小計</td>
		</tr>
		<c:forEach items="${Cart}" var="x">
		<tr>
				<td><img src="${initParam['itemImgRoute']}${x.itemPic1}" alt=""><span>${x.itemHeader}</span></td>
				<td>${x.itemColor}</td>
				<td>${x.itemSize}</td>
				<td>${x.ordQty}</td>
				<td class="singlePrice" name="singlePrice">${x.itemPrice * x.itemDiscount * x.ordQty}</td>
		</tr>
	</c:forEach>
</table></div>

<!--title-->
<nav class="navbar navbar-default bgcolor">
	<div class="container-fluid">
		<!-- Brand and toggle get grouped for better mobile display 
          <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
              <span class="sr-only">Toggle navigation</span>
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">Brand</a>
          </div>-->
		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse coustom_navbar0" id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav navbar-right">
				<li><a class="loginB" style="padding: 0; margin: 0; line-height: 27px; color: white;"  >Login</a></li>
				<li><span style="padding: 0; margin-left: 20px; margin-right: 20px; line-height: 27px; color: white;">/</span></li>
				<li><a class="memberB" style="padding: 0; margin: 0; line-height: 27px; color: white;"  >Member</a></li>
				<li><span style="padding: 0; margin-left: 20px; margin-right: 20px; line-height: 27px; color: white;">/</span></li>
				<li><a class="cartB" style="padding: 0; margin: 0; margin-right: 20%; line-height: 27px; color: white;"  >Cart</a></li>
			</ul>
		</div>
		<!-- /.navbar-collapse -->
	</div>
	<!-- /.container-fluid -->
</nav>
<!--頁首-->
<div class="page-header page_header">
	<span>Belle_Rêver</span>
</div>


<!--頁首導覽-->
<nav class="navbar navbar-default coustom_navbar"
	style="padding: 0; margin: 0;">
	<div class="container-fluid ">
		<!-- Collect the nav links, forms, and other content for toggling -->
		<center>
			<div class="collapse navbar-collapse coustom_navbar_div"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav nav_ul ">

					<li><a class="customerService"
						style="padding: 0; margin: 0; line-height: 30px;">NEW IN</a>
						<div class="customerService_inner"></div></li>


					<li><a class="clothes"
						style="padding: 0; margin: 0; line-height: 30px;">Clothes</a>
						<div class="clothes_inner"></div></li>
					<li><a class="customerService"
						style="padding: 0; margin: 0; line-height: 30px;">Shoes</a>
						<div class="customerService_inner"></div></li>

					<li><a class="customerService"
						style="padding: 0; margin: 0; line-height: 30px;">Accessories</a>
						<div class="customerService_inner"></div></li>

					<li><a class="aboutMe"
						style="padding: 0; margin: 0; line-height: 30px;">Bags</a>
						<div class="aboutMe_inner"></div></li>

					<li><a class="customerService"
						style="padding: 0; margin: 0; line-height: 30px; color: red;">Sale</a>
						<div class="customerService_inner"></div></li>
					<li><div
							style="border-bottom: 1px solid black; display: inline-block; padding-bottom: 0px; line-height: 30px; margin-left: 110%;">
							<span class="icon-search" /><input type="text"
								class="coustom_text" placeholder="Search">
						</div></li>
				</ul>

			</div>
			<!-- /.navbar-collapse -->
		</center>
	</div>
	<!-- /.container-fluid -->
</nav>