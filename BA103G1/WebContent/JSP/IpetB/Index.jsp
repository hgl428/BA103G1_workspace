<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.PetSpecies.model.*"%>
<%@ page import="com.petInformation.model.*"%>
<%@ page import="com.PetBreed.model.*"%>
<%
	PetSpeciesService speciesSvc = new PetSpeciesService();
	List<PetSpeciesVO> species = speciesSvc.getAll();
	pageContext.setAttribute("species", species);

	PetInformationService petInfoSvc = new PetInformationService();
	List<PetInformationVO> list = petInfoSvc.getAll();
	pageContext.setAttribute("list", list);

	PetBreedService breedSvc = new PetBreedService();
	List<PetBreedVO> breedVO = breedSvc.getAll();
	pageContext.setAttribute("breedVO", breedVO);
%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="css/main.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="js/main.js"></script>

<title>iPet愛動物</title>
</head>

<body>

	<!--第一區：nav區-->
	<div class="b_nav">
		<div class="container">

			<!--左欄：logo區-->
			<div class="col-xs-2 col-sm-2">
				<a class="logo" href="index.html"><img
					src="images/Ipet_Logo .png"></a>
			</div>
			<!--左欄：logo區 end-->
			<!--手機版的漢堡選單開始-->
			<div class="burger-menu">
				<i class="fa fa-bars" aria-hidden="true"></i>
			</div>
			<!--手機版的漢堡選單結束-->

			<!--右欄：購物車等icon＋選單區-->
			<div class="col-xs-10 col-sm-10 rightbar text-right">

				<!--購物車、註冊、登入、會員專區（登入成功後，登入兩字變為會員專區）-->
				<div class="col-sm-12">
					<div class="row">

						<div class="icon shopping">
							<span><a href="#"><i class="fa fa-cart-plus"
									aria-hidden="true"></i>購物車</a></span>
						</div>
						<div class="icon member">
							<span><a href="#"><i class="fa fa-user-o"
									aria-hidden="true"></i>加入會員</a></span>
						</div>
						<div class="icon login">
							<span><a href="#"><i class="fa fa-user-circle"
									aria-hidden="true"></i>登入</a></span>
						</div>
					</div>
				</div>
				<!--購物車、註冊、登入、會員專區（登入成功後，登入兩字變為會員專區）end-->

				<!--選單區-->
				<div class="col-sm-12">
					<div class="row">
						<ul class="menu">
							<li><a href="adopt.html">我要認養</a>
								<ul class="sub-menu">
									<li><a href="#">自我評估</a></li>
									<li><a href="adopt.html">認養總覽</a></li>
								</ul></li>
							<li><a href="addadoption.html">我要送養</a>
								<ul class="sub-menu">
									<li><a href="#">送養須知</a></li>
									<li><a href="addadoption.html">新增送養</a></li>
								</ul></li>
							<li><a href="shopping.html">購物商城</a></li>
							<li><a href="#">討論區</a></li>
							<li><a href="#">寵物牆</a></li>
							<li><a href="#">活動專區</a>
								<ul class="sub-menu">
									<li><a href="#">本版活動</a></li>
									<li><a href="#">領養分享</a></li>
								</ul></li>
						</ul>
					</div>
				</div>
				<!--選單區 end-->

			</div>
			<!--右欄：購物車等icon＋選單區 end-->

		</div>
	</div>
	<!--第一區：nav區 end-->

	<!--第二區：Banner區 領養心得-->
	<div id="carousel-id" class="carousel slide" data-ride="carousel">
		<!-- 幻燈片小圓點區 -->
		<ol class="carousel-indicators">
			<li data-target="#carousel-id" data-slide-to="0" class=""></li>
			<li data-target="#carousel-id" data-slide-to="1" class=""></li>
			<li data-target="#carousel-id" data-slide-to="2" class="active"></li>
		</ol>
		<!-- 幻燈片主圖區 -->
		<div class="carousel-inner">
			<div class="item">
				<img src="images/dog21_18X9_副本.jpg" alt="">
				<div class="container">
					<div class="carousel-caption">
						<h1>以領養替代購買</h1>
						<p>希望您可以此找到珍愛一輩子的寵物</p>
						<p>
							<a class="btn btn-primary" href="#">詳細內容</a>
						</p>
					</div>
				</div>
			</div>
			<div class="item">
				<img src="images/dog55_副本.png" alt="">
				<div class="container">
					<div class="carousel-caption">
						<h1>以領養替代購買</h1>
						<p>希望您可以在此找到珍愛一輩子的寵物</p>
						<p>
							<a class="btn btn-primary" href="#">詳細內容</a>
						</p>
					</div>
				</div>
			</div>
			<div class="item active">
				<img src="images/dog22_18X9.jpg" alt="">
				<div class="container">
					<div class="carousel-caption">
						<h1>以領養替代購買</h1>
						<p>希望您可以在此找到珍愛一輩子的寵物</p>
						<p>
							<a class="btn btn-primary" href="#" role="button">詳細內容</a>
						</p>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- 上下頁控制區 -->
	<a class="left carousel-control" href="#carousel-id" data-slide="prev"><span
		class="glyphicon glyphicon-chevron-left"></span></a>
	<a class="right carousel-control" href="#carousel-id" data-slide="next"><span
		class="glyphicon glyphicon-chevron-right"></span></a>
	</div>
	<!--第二區：Banner區 end-->

	<!--第三區： 領養posts-->
	<div class="post-content">
		<div class="container">

			<!--各區的主標題-->
			<div class="col-sm-12 title-area">
				<div class="row">
					<div class="col-sm-6">
						<div class="title left">
							<div class="tab col-sm-3 tab-active">推薦領養</div>
							<div class="tab col-sm-3">最新送養</div>
						</div>
					</div>
					<div class="col-sm-6">
						<div class="title right text-right">
							<button class="btn btn-info">看更多</button>
							<button class="btn btn-info">我要領養</button>
						</div>
					</div>
				</div>
			</div>
			<!--各區的主標題 end-->

			<!--各區的主內容-->
			<!--第1則-->
			<div class="col-xs-6 col-sm-3">
				<div class="box">
					<div class="post-img">
						<img src="images/31.jpg">
					</div>

					<c:forEach var="titleVO" items="${list}">
						<div class="post-text">
							<h3>
								<a href="#">${titleVO.petTitle}</a>
							</h3>
							<p>認養前請再三考慮，不要衝動承諾認養後需耐心對待，不要輕言放棄……</p>
						</div>
					</c:forEach>

				</div>
			</div>
			<!--第1則end-->
			<!--第2則-->
			<div class="col-xs-6 col-sm-3">
				<div class="box">
					<div class="post-img">
						<img src="images/31.jpg">
					</div>
					<div class="post-text">
						<h3>
							<a href="#">可愛活潑～小橘球</a>
						</h3>
						<p>認養前請再三考慮，不要衝動承諾認養後需耐心對待，不要輕言放棄……</p>
					</div>
				</div>
			</div>
			<!--第2則end-->
			<!--第3則-->
			<div class="col-xs-6 col-sm-3">
				<div class="box">
					<div class="post-img">
						<img src="images/31.jpg">
					</div>
					<div class="post-text">
						<h3>
							<a href="#">可愛活潑～小橘球</a>
						</h3>
						<p>認養前請再三考慮，不要衝動承諾認養後需耐心對待，不要輕言放棄……</p>
					</div>
				</div>
			</div>
			<!--第3則end-->
			<!--第4則-->
			<div class="col-xs-6 col-sm-3">
				<div class="box">
					<div class="post-img">
						<img src="images/31.jpg">
					</div>
					<div class="post-text">
						<h3>
							<a href="#">可愛活潑～小橘球</a>
						</h3>
						<p>認養前請再三考慮，不要衝動承諾認養後需耐心對待，不要輕言放棄……</p>
					</div>
				</div>
			</div>
			<!--第4則end-->
			<!--第5則-->
			<div class="col-xs-6 col-sm-3">
				<div class="box">
					<div class="post-img">
						<img src="<%=request.getContextPath()%>/JSP/IpetB/PetImage.do?picNo=4">
					</div>
					<div class="post-text">
						<h3>
							<a
								href="<%=request.getContextPath()%>/JSP/IpetB/PetImage.do?picNo=12">可愛活潑～小橘球</a>
						</h3>
						<p>認養前請再三考慮，不要衝動承諾認養後需耐心對待，不要輕言放棄……</p>
					</div>
				</div>
			</div>
			<!--第5則end-->
			<!--第6則-->
			<div class="col-xs-6 col-sm-3">
				<div class="box">
					<div class="post-img">
						<img src="images/31.jpg">
					</div>
					<div class="post-text">
						<h3>
							<a href="#">可愛活潑～小橘球</a>
						</h3>
						<p>認養前請再三考慮，不要衝動承諾認養後需耐心對待，不要輕言放棄……</p>
					</div>
				</div>
			</div>
			<!--第6則end-->
			<!--第7則-->
			<div class="col-xs-6 col-sm-3">
				<div class="box">
					<div class="post-img">
						<img src="images/31.jpg">
					</div>
					<div class="post-text">
						<h3>
							<a href="#">可愛活潑～小橘球</a>
						</h3>
						<p>認養前請再三考慮，不要衝動承諾認養後需耐心對待，不要輕言放棄……</p>
					</div>
				</div>
			</div>
			<!--第7則end-->
			<!--第8則-->
			<div class="col-xs-6 col-sm-3">
				<div class="box">
					<div class="post-img">
						<img src="images/31.jpg">
					</div>
					<div class="post-text">
						<h3>
							<a href="#">可愛活潑～小橘球</a>
						</h3>
						<p>認養前請再三考慮，不要衝動承諾認養後需耐心對待，不要輕言放棄……</p>
					</div>
				</div>
			</div>
			<!--第8則end-->


		</div>

	</div>

	<!--第四區： 討論區-->
	<div class="discuss-content">
		<div class="container">
			<!--各區的主標題-->
			<div class="col-sm-12 title-area">
				<div class="row">
					<div class="col-sm-6">
						<div class="title left">
							<div class="tab col-sm-3 tab-active">熱門討論</div>
							<!--<div class="tab col-sm-3">最新送養</div>-->
						</div>
					</div>
					<div class="col-sm-6">
						<div class="title right text-right">
							<button class="btn btn-info">看更多</button>
							<button class="btn btn-info">我要發表</button>
						</div>
					</div>
				</div>
			</div>
			<!--各區的主標題 end-->
			<!--各區的主內容-->
			<!--第1則-->
			<div class="col-sm-6">
				<div class="discussion">
					<div class="img">
						<img src="images/14.png" alt="">
					</div>
					<div class="text">
						<h3>
							<span>主題：</span>求推薦～帶狗狗奔跑的好地方
						</h3>
						<p>想帶狗狗去跑跑，台北地區有推薦的好地方嗎？</p>
					</div>
				</div>
			</div>
			<!--第1則end-->
			<!--第2則-->
			<div class="col-sm-6">
				<div class="discussion">
					<div class="img">
						<img src="images/14.png" alt="">
					</div>
					<div class="text">
						<h3>
							<span>主題：</span>求推薦～帶狗狗奔跑的好地方
						</h3>
						<p>想帶狗狗去跑跑，台北地區有推薦的好地方嗎？</p>
					</div>
				</div>
			</div>
			<!--第2則end-->
			<!--第3則-->
			<div class="col-sm-6">
				<div class="discussion">
					<div class="img">
						<img src="images/14.png" alt="">
					</div>
					<div class="text">
						<h3>
							<span>主題：</span>求推薦～帶狗狗奔跑的好地方
						</h3>
						<p>想帶狗狗去跑跑，台北地區有推薦的好地方嗎？</p>
					</div>
				</div>
			</div>
			<!--第3則end-->
			<!--第4則-->
			<div class="col-sm-6">
				<div class="discussion">
					<div class="img">
						<img src="images/14.png" alt="">
					</div>
					<div class="text">
						<h3>
							<span>主題：</span>求推薦～帶狗狗奔跑的好地方
						</h3>
						<p>想帶狗狗去跑跑，台北地區有推薦的好地方嗎？</p>
					</div>
				</div>
			</div>
			<!--第4則end-->


			<!--各區的主內容 end-->
		</div>
	</div>
	<!--第四區：討論區end-->

	<!--第五區：商品區-->
	<div class="products-content">
		<div class="container">
			<!--各區的主標題-->
			<div class="col-sm-12 title-area">
				<div class="row">
					<div class="col-sm-6">
						<div class="title left">
							<div class="tab col-sm-3 tab-active">熱門商品</div>
							<div class="tab col-sm-3">最新商品</div>
						</div>
					</div>
					<div class="col-sm-6">
						<div class="title right text-right">
							<button class="btn btn-info">看更多</button>
						</div>
					</div>
				</div>
			</div>
			<!--各區的主標題 end-->
			<!--各區主內容-->
			<!--第1則-->
			<div class="col-sm-2">
				<div class="product">
					<div class="img">
						<img class="img-responsive" src="images/cat1.jpg" alt="">
					</div>
					<div class="text">
						<h3>貓貓最愛糧食</h3>
						<p>$3000元</p>
						<button class="btn btn-default">
							<i class="fa fa-cart-plus" aria-hidden="true"></i>加入購物車
						</button>
					</div>
				</div>
			</div>
			<!--第1則end-->
			<!--第2則-->
			<div class="col-sm-2">
				<div class="product">
					<div class="img">
						<img class="img-responsive" src="images/cat1.jpg" alt="">
					</div>
					<div class="text">
						<h3>貓貓最愛糧食</h3>
						<p>$3000元</p>
						<button class="btn btn-default">
							<i class="fa fa-cart-plus" aria-hidden="true"></i>加入購物車
						</button>
					</div>
				</div>
			</div>
			<!--第2則end-->
			<!--第3則-->
			<div class="col-sm-2">
				<div class="product">
					<div class="img">
						<img class="img-responsive" src="images/cat1.jpg" alt="">
					</div>
					<div class="text">
						<h3>貓貓最愛糧食</h3>
						<p>$3000元</p>
						<button class="btn btn-default">
							<i class="fa fa-cart-plus" aria-hidden="true"></i>加入購物車
						</button>
					</div>
				</div>
			</div>
			<!--第3則end-->
			<!--第4則-->
			<div class="col-sm-2">
				<div class="product">
					<div class="img">
						<img class="img-responsive" src="images/cat1.jpg" alt="">
					</div>
					<div class="text">
						<h3>貓貓最愛糧食</h3>
						<p>$3000元</p>
						<button class="btn btn-default">
							<i class="fa fa-cart-plus" aria-hidden="true"></i>加入購物車
						</button>
					</div>
				</div>
			</div>
			<!--第4則end-->
			<!--第5則-->
			<div class="col-sm-2">
				<div class="product">
					<div class="img">
						<img class="img-responsive" src="images/cat1.jpg" alt="">
					</div>
					<div class="text">
						<h3>貓貓最愛糧食</h3>
						<p>$3000元</p>
						<button class="btn btn-default">
							<i class="fa fa-cart-plus" aria-hidden="true"></i>加入購物車
						</button>
					</div>
				</div>
			</div>
			<!--第5則end-->
			<!--第6則-->
			<div class="col-sm-2">
				<div class="product">
					<div class="img">
						<img class="img-responsive" src="images/cat1.jpg" alt="">
					</div>
					<div class="text">
						<h3>貓貓最愛糧食</h3>
						<p>$3000元</p>
						<button class="btn btn-default">
							<i class="fa fa-cart-plus" aria-hidden="true"></i>加入購物車
						</button>
					</div>
				</div>
			</div>
			<!--第6則end-->

			<!--各區主內容 ㄎ-->
		</div>
	</div>
	<!--第五區：商品區 end-->

	<!--第六區：寵物協尋-->
	<div class="finding-content">
		<div class="container">
			<!--各區的主標題-->
			<div class="col-sm-12 title-area">
				<div class="row">
					<div class="col-sm-6">
						<div class="title left">
							<div class="tab col-sm-3 tab-active">寵物協尋</div>
							<!--<div class="tab col-sm-3">最新送養</div>-->
						</div>
					</div>
					<div class="col-sm-6">
						<div class="title right text-right">
							<button class="btn btn-info">看更多</button>
							<button class="btn btn-info">我要協尋</button>
						</div>
					</div>
				</div>
			</div>
			<!--各區的主標題 end-->

			<!--各區的主內容-->
			<div class="col-sm-12">
				<div class="col-sm-4">
					<div class="row">
						<div class="finding-post">
							<img class="img-responsive" src="images/1.jpg" alt="">
							<div class="text">
								<h3>急！！！狗狗在河濱公園遺失，幫忙找找！</h3>
							</div>
						</div>
					</div>
				</div>
				<div class="col-sm-4">
					<div class="row">
						<div class="finding-post">
							<img class="img-responsive" src="images/2.jpg" alt="">
							<div class="text">
								<h3>狗狗在河濱公園遺失，幫忙找找！</h3>
							</div>
						</div>
					</div>
				</div>
				<div class="col-sm-4">
					<div class="row">
						<div class="finding-post">
							<img class="img-responsive" src="images/3.jpg" alt="">
							<div class="text">
								<h3>狗狗在河濱公園遺失，幫忙找找！</h3>
							</div>
						</div>
					</div>
				</div>
				<div class="col-sm-4">
					<div class="row">
						<div class="finding-post">
							<img class="img-responsive" src="images/4.jpg" alt="">
							<div class="text">
								<h3>狗狗在河濱公園遺失，幫忙找找！</h3>
							</div>
						</div>
					</div>
				</div>
				<div class="col-sm-4">
					<div class="row">
						<div class="finding-post">
							<img class="img-responsive" src="images/16.jpg" alt="">
							<div class="text">
								<h3>狗狗在河濱公園遺失，幫忙找找！</h3>
							</div>
						</div>
					</div>
				</div>
				<div class="col-sm-4">
					<div class="row">
						<div class="finding-post">
							<img class="img-responsive" src="images/11.png" alt="">
							<div class="text">
								<h3>狗狗在河濱公園遺失，幫忙找找！</h3>
							</div>
						</div>
					</div>
				</div>
			</div>
			<!--各區的主內容 end-->
		</div>
	</div>

	<!--第六區：寵物協尋 end-->

	<!--最後一區：footer-->
	<footer>
		<div class="container"></div>
	</footer>

	<!--最後一區：end-->

</body>

</html>