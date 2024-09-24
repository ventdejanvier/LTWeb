<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html lang="en">


<!-- Head BEGIN -->
<head>
<meta charset="utf-8">
<title>Metronic Shop UI</title>

<meta content="width=device-width, initial-scale=1.0" name="viewport">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">

<meta content="Metronic Shop UI description" name="description">
<meta content="Metronic Shop UI keywords" name="keywords">
<meta content="keenthemes" name="author">

<meta property="og:site_name" content="-CUSTOMER VALUE-">
<meta property="og:title" content="-CUSTOMER VALUE-">
<meta property="og:description" content="-CUSTOMER VALUE-">
<meta property="og:type" content="website">
<meta property="og:image" content="-CUSTOMER VALUE-">
<!-- link to image for socio -->
<meta property="og:url" content="-CUSTOMER VALUE-">

<link rel="shortcut icon" href="favicon.ico">

<!-- Fonts START -->
<link
	href="http://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700|PT+Sans+Narrow|Source+Sans+Pro:200,300,400,600,700,900&amp;subset=all"
	rel="stylesheet" type="text/css">
<link
	href="http://fonts.googleapis.com/css?family=Source+Sans+Pro:200,300,400,600,700,900&amp;subset=all"
	rel="stylesheet" type="text/css">
<!--- fonts for slider on the index page -->
<!-- Fonts END -->

<!-- Global styles START -->
<link
	href="../../assets/global/plugins/font-awesome/css/font-awesome.min.css"
	rel="stylesheet">
<link href="../../assets/global/plugins/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<!-- Global styles END -->

<!-- Page level plugin styles START -->
<link
	href="../../assets/global/plugins/fancybox/source/jquery.fancybox.css"
	rel="stylesheet">
<link
	href="../../assets/global/plugins/carousel-owl-carousel/owl-carousel/owl.carousel.css"
	rel="stylesheet">
<link
	href="../../assets/global/plugins/slider-layer-slider/css/layerslider.css"
	rel="stylesheet">
<!-- Page level plugin styles END -->

<!-- Theme styles START -->
<link href="../../assets/global/css/components.css" rel="stylesheet">
<link href="../../assets/frontend/layout/css/style.css" rel="stylesheet">
<link href="../../assets/frontend/pages/css/style-shop.css"
	rel="stylesheet" type="text/css">
<link href="../../assets/frontend/pages/css/style-layer-slider.css"
	rel="stylesheet">
<link href="../../assets/frontend/layout/css/style-responsive.css"
	rel="stylesheet">
<link href="../../assets/frontend/layout/css/themes/red.css"
	rel="stylesheet" id="style-color">
<link href="../../assets/frontend/layout/css/custom.css"
	rel="stylesheet">
<!-- Theme styles END -->
</head>
<!-- Head END -->

<!-- Body BEGIN -->
<body class="ecommerce">

	<!-- Begin header -->
	<%@ include file="/commons/web/header.jsp"%>>
	<!-- End header -->


	<!-- Begin Slider -->

	<!-- End Slider -->

	<div class="main">
		<div class="container">
			<!-- Begin content -->
			<sitemesh:write property="body" />
			<!-- End content -->
		</div>
	</div>


	<!-- Begin footer -->
	<%@ include file="/commons/web/footer.jsp"%>>
	<!-- End footer -->



	<!-- Load javascripts at bottom, this will reduce page load time -->
	<!-- BEGIN CORE PLUGINS (REQUIRED FOR ALL PAGES) -->
	<!--[if lt IE 9]>
    <script src="../../assets/global/plugins/respond.min.js"></script>  
    <![endif]-->
	<script src="../../assets/global/plugins/jquery.min.js"
		type="text/javascript"></script>
	<script src="../../assets/global/plugins/jquery-migrate.min.js"
		type="text/javascript"></script>
	<script src="../../assets/global/plugins/bootstrap/js/bootstrap.min.js"
		type="text/javascript"></script>
	<script src="../../assets/frontend/layout/scripts/back-to-top.js"
		type="text/javascript"></script>
	<script
		src="../../assets/global/plugins/jquery-slimscroll/jquery.slimscroll.min.js"
		type="text/javascript"></script>
	<!-- END CORE PLUGINS -->

	<!-- BEGIN PAGE LEVEL JAVASCRIPTS (REQUIRED ONLY FOR CURRENT PAGE) -->
	<script
		src="../../assets/global/plugins/fancybox/source/jquery.fancybox.pack.js"
		type="text/javascript"></script>
	<!-- pop up -->
	<script
		src="../../assets/global/plugins/carousel-owl-carousel/owl-carousel/owl.carousel.min.js"
		type="text/javascript"></script>
	<!-- slider for products -->
	<script src='../../assets/global/plugins/zoom/jquery.zoom.min.js'
		type="text/javascript"></script>
	<!-- product zoom -->
	<script
		src="../../assets/global/plugins/bootstrap-touchspin/bootstrap.touchspin.js"
		type="text/javascript"></script>
	<!-- Quantity -->

	<!-- BEGIN LayerSlider -->
	<script
		src="../../assets/global/plugins/slider-layer-slider/js/greensock.js"
		type="text/javascript"></script>
	<!-- External libraries: GreenSock -->
	<script
		src="../../assets/global/plugins/slider-layer-slider/js/layerslider.transitions.js"
		type="text/javascript"></script>
	<!-- LayerSlider script files -->
	<script
		src="../../assets/global/plugins/slider-layer-slider/js/layerslider.kreaturamedia.jquery.js"
		type="text/javascript"></script>
	<!-- LayerSlider script files -->
	<script src="../../assets/frontend/pages/scripts/layerslider-init.js"
		type="text/javascript"></script>
	<!-- END LayerSlider -->

	<script src="../../assets/frontend/layout/scripts/layout.js"
		type="text/javascript"></script>
	<script type="text/javascript">
		jQuery(document).ready(function() {
			Layout.init();
			Layout.initOWL();
			LayersliderInit.initLayerSlider();
			Layout.initImageZoom();
			Layout.initTouchspin();
			Layout.initTwitter();

			Layout.initFixHeaderWithPreHeader();
			Layout.initNavScrolling();
		});
	</script>
	<!-- END PAGE LEVEL JAVASCRIPTS -->
</body>
<!-- END BODY -->
</html>