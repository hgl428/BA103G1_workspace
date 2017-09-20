<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.PetImage.model.*"%>
<%-- 此頁練習採用 EL 的寫法取值 --%>

<%
	PetImageService picSvc = new PetImageService();
	List<PetImageVO> list = picSvc.getAll();
	pageContext.setAttribute("list", list);
%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="css/main.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="js/main.js"></script>
<script type="text/javascript" src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCVTvj_0kUlIT4NDFTo4AV0ZJbliitGrPQ"></script>
<script type="text/javascript">
	
</script>
<title>iPet愛動物</title>


</head>

<body>

	<!--第一區：nav區-->
	<div class="b_nav">
		<div class="container">

			<!--左欄：logo區-->
			<div class="col-xs-2 col-sm-2">
				<a class="logo" href="index.html">
					<img src="images/Ipet_Logo .png">
				</a>
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
							<span>
								<a href="#">
									<i class="fa fa-cart-plus" aria-hidden="true"></i>
									購物車
								</a>
							</span>
						</div>
						<div class="icon member">
							<span>
								<a href="#">
									<i class="fa fa-user-o" aria-hidden="true"></i>
									加入會員
								</a>
							</span>
						</div>
						<div class="icon login">
							<span>
								<a href="#">
									<i class="fa fa-user-circle" aria-hidden="true"></i>
									登入
								</a>
							</span>
						</div>
					</div>
				</div>
				<!--購物車、註冊、登入、會員專區（登入成功後，登入兩字變為會員專區）end-->

				<!--選單區-->
				<div class="col-sm-12">
					<div class="row">
						<ul class="menu">
							<li>
								<a href="adopt.html">我要認養</a>
								<ul class="sub-menu">
									<li>
										<a href="#">自我評估</a>
									</li>
									<li>
										<a href="adopt.html">認養總覽</a>
									</li>
								</ul>
							</li>
							<li>
								<a href="addadoption.html">我要送養</a>
								<ul class="sub-menu">
									<li>
										<a href="#">送養須知</a>
									</li>
									<li>
										<a href="addadoption.html">新增送養</a>
									</li>
								</ul>
							</li>
							<li>
								<a href="shopping.html">購物商城</a>
							</li>
							<li>
								<a href="#">討論區</a>
							</li>
							<li>
								<a href="#">寵物牆</a>
							</li>
							<li>
								<a href="#">活動專區</a>
								<ul class="sub-menu">
									<li>
										<a href="#">本版活動</a>
									</li>
									<li>
										<a href="#">領養分享</a>
									</li>
								</ul>
							</li>
						</ul>
					</div>
				</div>
				<!--選單區 end-->

			</div>
			<!--右欄：購物車等icon＋選單區 end-->

		</div>
	</div>
	<!--第一區：nav區 end-->

	<!--各頁主內容寫在這-->
	<div class="adopt-search-content">
		<div class="container">

			<div class="left-sidebar col-xs-12">
				<div class="row">
					<!--搜尋條件區開始-->
					<div class="conditions-area">

						<div class="col-sm-12">
							<label for="petPosition"></label>
							<input type="text" name="" placeholder="請輸入搜尋關鍵字">
						</div>

						<div class="col-sm-12">
							<label for="petPosition">動物類型</label>
							<select>
								<option value="">請選擇</option>
								<option value="狗">狗</option>
								<option value="貓">貓</option>
								<option value="水族">水族</option>
								<option value="鳥">鳥</option>
								<option value="其他">其他</option>
							</select>
						</div>

						<div class="col-sm-12">
							<label for="petPosition">動物所在縣市</label>
							<select name="propaddress" id="petPosition">
								<option value="">請選擇</option>
								<option value="台北市">台北市</option>
								<option value="新北市">新北市</option>
								<option value="桃園市">桃園市</option>
								<option value="新竹市">新竹市</option>
								<option value="新竹縣">新竹縣</option>
								<option value="宜蘭縣">宜蘭縣</option>
								<option value="基隆市">基隆市</option>
								<option value="台中市">台中市</option>
								<option value="彰化縣">彰化縣</option>
								<option value="雲林縣">雲林縣</option>
								<option value="苗栗縣">苗栗縣</option>
								<option value="南投縣">南投縣</option>
								<option value="高雄市">高雄市</option>
								<option value="台南市">台南市</option>
								<option value="嘉義市">嘉義市</option>
								<option value="嘉義縣">嘉義縣</option>
								<option value="屏東縣">屏東縣</option>
								<option value="台東縣">台東縣</option>
								<option value="花蓮縣">花蓮縣</option>
								<option value="澎湖縣">澎湖縣</option>
								<option value="金門縣">金門縣</option>
								<option value="連江縣">連江縣</option>
							</select>
						</div>

						<div class="col-sm-12">
							<label for="petAge">年齡</label>
							<select id="petAge">
								<option value="">請選擇</option>
								<option value="幼年">幼年</option>
								<option value="成年">成年</option>
							</select>
						</div>

						<div class="col-sm-12 text-right">
							<button class="btn btn-default" id="search-now">馬上搜尋</button>
							<button class="btn btn-info" id="search-more">更多條件</button>
						</div>

						<div class="col-sm-12">
							<div class="more-area">

								<div class="col-sm-10">
									<div class="row">
										<!-- 這裡有更多條件，請條列有哪些篩選條件。 -->
										<div class="col-sm-12">
											<label for="petPosition">動物性別</label>
											<select>
												<option value="">請選擇</option>
												<option value="公">公</option>
												<option value="母">母</option>
											</select>
										</div>

										<!-- <div class="col-sm-12">
                      <label for="petsex">動物性別</label>
                      <div class="checkbox petSex">
                        <input type="checkbox" value="">公
                        <input type="checkbox" value="">母
                      </div>
                    </div> -->


										<div class="col-sm-12 petColor">
											<label for="petColor">毛色</label>
											<select class="form-control" id="petColor">
												<option value="">請選擇</option>
												<option value="">黑</option>
												<option value="">白</option>
												<option value="">黑白</option>
												<option value="">黃</option>
												<option value="">黃白</option>
												<option value="">虎斑</option>
												<option value="">米克斯</option>
												<option value="">棕</option>
												<option value="">咖啡</option>
												<option value="">其他</option>
											</select>
										</div>
									</div>
								</div>

								<button class="btn btn-default pull-right" id="adopt-search">搜尋</button>
								<div class="clearfix"></div>
							</div>
						</div>

						<div class="clearfix"></div>


					</div>
					<!--搜尋條件區結束-->
					<!--地圖＋領養方塊區開始-->
					<!--其他區廣告開始-->
					<div class="ad-area ">
						<p>廣告區：熱門貼文或是認養心得或是認養需知。</p>
					</div>
					<!--其他區廣告結束-->
				</div>
			</div>

			<div class="search-result col-xs-12 col-sm-9 col-sm-push-3">
				<div class="col-sm-12">
					<div class="row">
						<div class="b-photo-gallery">

							<!--照片slider顯示開始-->
							<div class="main-photo">
								<img id="show-image" src="images/15.jpg" alt="">

							</div>
							<ul class="photo-list">
								<c:forEach var="imageVO" items="${list}">
									<li>
										<img src="<%=request.getContextPath()%>/JSP/IpetB/PetImage.do?picNo=${imageVO.picNo}" alt="">
										</a>
									</li>
								</c:forEach>
								<li>
									<img class="selected-img" src="images/cat09.png" alt="">
								</li>
								<li>
									<img src="images/2.jpg" alt="">
									</a>
								</li>
								<li>
									<img src="images/10.png" alt="">
									</a>
								</li>
								<li>
									<img src="images/cat06.png" alt="">
								</li>
								<li>
									<img src="images/15.jpg" alt="">
								</li>
								<li>
									<img src="images/31.jpg" alt="">
								</li>
								<li>
									<img src="images/dog21.jpg" alt="">
								</li>
								<li>
									<img src="images/cat19.png" alt="">
								</li>
								<li>
									<img src="images/11.png" alt="">
								</li>
								<li>
									<img src="images/1.jpg" alt="">
								</li>
							</ul>
							<!--照片slider顯示結束-->

						</div>
					</div>
				</div>

				<div class="col-sm-12">
					<div class="row">
						<div class="b-title-area left">
							<span>貓咪</span>
							<h2>可愛活潑小橘球</h2>
						</div>
					</div>
					<div class="b-detail">
						<!-- 動物現況簡述 200字元 start-->
						<div class="description">
							<p>關於這隻動物的簡單描述，包括動物現況等等等等。 關於這隻動物的簡單描述，包括動物現況等等等等。 關於這隻動物的簡單描述，包括動物現況等等等等。 關於這隻動物的簡單描述，包括動物現況等等等等。 關於這隻動物的簡單描述，包括動物現況等等等等。 關於這隻動物的簡單描述，包括動物現況等等等等。 關於這隻動物的簡單描述，包括動物現況等等等等。限制200字元。</p>
						</div>
						<!-- 動物現況簡述 end-->
						<!-- 基本資料 start -->
						<div class="info">
							<h3>基本資料</h3>
							<div class="item col-sm-6">
								<p>
									<span class="title">動物編號：</span>
									<span class="text">000010</span>
								</p>
							</div>
							<div class="item col-sm-6">
								<p>
									<span class="title">動物姓名：</span>
									<span class="text">小橘球</span>
								</p>
							</div>
							<div class="item col-sm-6">
								<p>
									<span class="title">性別：</span>
									<span class="text">公</span>
								</p>
							</div>
							<div class="item col-sm-6">
								<p>
									<span class="title">動物類型：</span>
									<span class="text">貓咪</span>
								</p>
							</div>
							<div class="item col-sm-6">
								<p>
									<span class="title">毛色：</span>
									<span class="text">黃白</span>
								</p>
							</div>
							<div class="item col-sm-6">
								<p>
									<span class="title">動物品種：</span>
									<span class="text">家菲貓</span>
								</p>
							</div>
							<div class="item col-sm-6">
								<p>
									<span class="title">動物體型：</span>
									<span class="text">中</span>
								</p>
							</div>
							<div class="item col-sm-6">
								<p>
									<span class="title">年齡：</span>
									<span class="text">約1歲</span>
								</p>
							</div>
							<div class="item col-sm-6">
								<p>
									<span class="title">送養縣市：</span>
									<span class="text">桃園市</span>
								</p>
							</div>
							<div class="item col-sm-6">
								<p>
									<span class="title">送養地址：</span>
									<span class="text">桃園市中壢區中大路300號</span>
								</p>
							</div>
							<div class="item col-sm-6">
								<p>
									<span class="title">晶片：</span>
									<span class="text">有</span>
								</p>
							</div>
							<div class="item col-sm-6">
								<p>
									<span class="title">絕育：</span>
									<span class="text">是</span>
								</p>
							</div>
							<div class="clearfix"></div>
						</div>
						<!-- 基本資料 end -->
						<!-- 按鈕區 start -->
						<div class="btn-area">
							<button>加入最愛</button>
							<button>提出認養</button>
							<button>檢舉</button>
						</div>
						<!-- 按鈕區 end -->
					</div>
				</div>
			</div>

			<div class="clearfix"></div>
		</div>
		<!--地圖＋領養方塊區結束-->
	</div>
	</div>
	<!--各頁主內容寫在這 end-->

	<!--最後一區：footer-->
	<footer>
		<div class="container"></div>
	</footer>

	<!--最後一區：end-->

</body>

</html>