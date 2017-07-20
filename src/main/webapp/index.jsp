<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false" language="java" contentType="text/html; charset=utf-8"%>
<!--
Author: W3layouts
Author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->
<!doctype html>
<html>
<head>
<title>Tab Weather Widget Flat Responsive Widget Template :: w3layouts</title>
<!-- for-mobile-apps -->
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" /> 
<meta name="keywords" content="Tab Weather Widget Responsive, Login form web template, Sign up Web Templates, Flat Web Templates, Login signup Responsive web template, Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
<!-- //for-mobile-apps -->
<link href="//fonts.googleapis.com/css?family=Roboto+Slab:100,400,700" rel="stylesheet">
<link href='//fonts.googleapis.com/css?family=Roboto:400,100,100italic,300,300italic,400italic,500,500italic,700,700italic,900,900italic' rel='stylesheet' type='text/css'>
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
<script src="js/jquery-2.1.4.min.js"></script>
<link rel="stylesheet" type="text/css" href="css/raccordion.css" />
    <script type="text/javascript">
        $(window).load(function () {
            $('#accordion-wrapper').raccordion({
                speed: 1000,
                sliderWidth: 700,
                sliderHeight: 300,
                autoCollapse: false
            });

        }); 
    </script>
<!--skycons-icons-->
<script src="js/skycons.js"></script>
<!--//skycons-icons-->
</head>
<body>
<div class="content" id="Main-Content">
	<h1>Tab Weather Widget</h1>
	<div class="wrapper">
		<div id="accordion-wrapper">
		<div class="slide"><img src="images/1.jpg" /><div class="caption"><div class="w3layouts-info"><div class="w3layouts-info-top"><h3>30~38°c</h3><h4>多云</h4><p>中国 上海</p></div><canvas id="snow" width="40" height="40"></canvas><div class="w3layouts-info-bottom"><h5>2017-07-18</h5></div></div></div></div><div class="slide"><img src="images/4.jpg" /><div class="caption"><div class="w3layouts-info"><div class="w3layouts-info-top"><h3>30~38°c</h3><h4>多云</h4><p>中国 上海</p></div><canvas id="snow" width="40" height="40"></canvas><div class="w3layouts-info-bottom"><h5>2017-07-19</h5></div></div></div></div><div class="slide"><img src="images/5.jpg" /><div class="caption"><div class="w3layouts-info"><div class="w3layouts-info-top"><h3>30~38°c</h3><h4>多云</h4><p>中国 上海</p></div><canvas id="snow" width="40" height="40"></canvas><div class="w3layouts-info-bottom"><h5>2017-07-20</h5></div></div></div></div><div class="slide"><img src="images/1.jpg" /><div class="caption"><div class="w3layouts-info"><div class="w3layouts-info-top"><h3>29~37°c</h3><h4>晴</h4><p>中国 上海</p></div><canvas id="snow" width="40" height="40"></canvas><div class="w3layouts-info-bottom"><h5>2017-07-21</h5></div></div></div></div><div class="slide"><img src="images/2.jpg" /><div class="caption"><div class="w3layouts-info"><div class="w3layouts-info-top"><h3>29~38°c</h3><h4>多云</h4><p>中国 上海</p></div><canvas id="snow" width="40" height="40"></canvas><div class="w3layouts-info-bottom"><h5>2017-07-22</h5></div></div></div></div><div class="slide"><img src="images/1.jpg" /><div class="caption"><div class="w3layouts-info"><div class="w3layouts-info-top"><h3>29~38°c</h3><h4>多云</h4><p>中国 上海</p></div><canvas id="snow" width="40" height="40"></canvas><div class="w3layouts-info-bottom"><h5>2017-07-23</h5></div></div></div></div><div class="slide"><img src="images/1.jpg" /><div class="caption"><div class="w3layouts-info"><div class="w3layouts-info-top"><h3>28~39°c</h3><h4>小雨</h4><p>中国 上海</p></div><canvas id="snow" width="40" height="40"></canvas><div class="w3layouts-info-bottom"><h5>2017-07-24</h5></div></div></div></div>
        </div>
    </div>
	<!--copyright-->
	<div class="w3ls-copyright">
		<p>© 2017 Tab Weather Widget . All Rights Reserved  | Design by <a href="http://w3layouts.com/" target="_blank">W3layouts</a> </p>
	</div>
	<!--//copyright-->
</div>
		<script>
				 var icons = new Skycons({"color": "#FFD700"}),
					  list  = [
						"clear-day"
					  ],
					  i;

				  for(i = list.length; i--; )
					icons.set(list[i], list[i]);

				  icons.play();
		</script>
		<script>
				 var icons = new Skycons({"color": "#f5f5f5"}),
					  list  = [
						"clear-night", "partly-cloudy-day",
						"partly-cloudy-night", "cloudy", "rain", "sleet", "snow", "wind",
						"fog"
					  ],
					  i;

				  for(i = list.length; i--; )
					icons.set(list[i], list[i]);

				  icons.play();
		</script>
<script src="js/jquery.raccordion.js" type="text/javascript"></script>
<script src="js/jquery.animation.easing.js" type="text/javascript"></script>
<script>
	$(function(){
		$.ajax({
			type:"get",
			url:"http://localhost:9013/lv/weather/queryWeatherMsg/v1.0",
			async:true,
			data:{
				city:'shanghai'
			},
			success:function(res){
				var div = '';
				res = jQuery.parseJSON(res);
				res = res.result.result.HeWeather5;
				var temp = res[0];
				var list = res[0].daily_forecast;
				for(var i = 0;i<list.length;i++){
					var obj = list[i];
					var x =Math.random()*7+1;
					x = Math.floor(x);
					div+='<div class="slide">'+'<img src="images/'+x+'.jpg" />'+'<div class="caption">'+'<div class="w3layouts-info">'+
					'<div class="w3layouts-info-top">'+'<h3>'+obj.tmp.min+'~'+obj.tmp.max+'°c</h3>'+'<h4>'+obj.cond.txt_d+'</h4>'+
					'<p>'+temp.basic.cnty+' '+temp.basic.city+'</p>'+'</div><canvas id="snow" width="40" height="40"></canvas><div class="w3layouts-info-bottom">'+
					'<h5>'+obj.date+'</h5>'+'</div></div></div></div>'
					console.log(x);
				}
				//$('#accordion-wrapper').html(div);
				//$('#accordion-wrapper').prepend(div);
				
				//var id = $('#accordion-wrapper').html();
				//console.log(id);
				//console.log(list)
				console.log(div)
				
			}
		});
	})
	
</script>
</body>
</html>



