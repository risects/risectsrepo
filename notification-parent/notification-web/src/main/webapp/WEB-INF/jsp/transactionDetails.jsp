<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<HTML>
<HEAD>
<Style type="text/css">
/*custom font*/


/*basic reset*/
* {margin: 0; padding: 0;}

html {
	height: 100%;
	/*Image only BG fallback*/
	

}

body {
	font-family: montserrat, arial, verdana;
	background: #e9ebee;
}
/*form styles*/
#msform {
	width: 400px;
	margin: 50px auto;
	text-align: center;
	position: relative;
}
#msform fieldset {
	background: white;
	border: 0 none;
	border-radius: 3px;
	box-shadow: 0 0 15px 1px rgba(0, 0, 0, 0.4);
	padding: 20px 30px;
	
	box-sizing: border-box;

	margin: 0 10%;
	
	/*stacking fieldsets above each other*/
	position: absolute;
}
/*Hide all except first fieldset*/
#msform fieldset:not(:first-of-type) {
	display: none;
}
/*inputs*/
#msform input, #msform textarea {
	padding: 15px;
	border: 1px solid #ccc;
	border-radius: 3px;
	margin-bottom: 10px;
	width: 100%;
	box-sizing: border-box;
	font-family: montserrat;
	color: #2C3E50;
	font-size: 13px;
}
/*buttons*/
#msform .action-button {
	width: 100px;
	background: #27AE60;
	font-weight: bold;
	color: white;
	border: 0 none;
	border-radius: 1px;
	cursor: pointer;
	padding: 10px 5px;
	margin: 10px 5px;
}
#msform .action-button:hover, #msform .action-button:focus {
	box-shadow: 0 0 0 2px white, 0 0 0 3px #27AE60;
}
/*headings*/
.fs-title {
	font-size: 15px;
	text-transform: uppercase;
	color: #2C3E50;
	margin-bottom: 10px;
}
.fs-subtitle {
	font-weight: normal;
	font-size: 13px;
	color: #666;
	margin-bottom: 20px;
}
/*progressbar*/
#progressbar {
	margin-bottom: 30px;
	overflow: hidden;
	/*CSS counters to number the steps*/
	counter-reset: step;
}
#progressbar li {
	list-style-type: none;
	color: white;
	text-transform: uppercase;
	font-size: 9px;
	width: 33.33%;
	float: left;
	position: relative;
}
#progressbar .active{
color:'#27AE60';
}
#progressbar li:before {
	content: counter(step);
	counter-increment: step;
	width: 20px;
	line-height: 20px;
	display: block;
	font-size: 10px;
	color: #333;
	background: white;
	border-radius: 3px;
	margin: 0 auto 5px auto;
}
/*progressbar connectors*/
#progressbar li:after {
	content: '';
	width: 100%;
	height: 2px;
	background: white;
	position: absolute;
	left: -50%;
	top: 9px;
	z-index: -1; /*put it behind the numbers*/
}
#progressbar li:first-child:after {
	/*connector not needed before the first step*/
	content: none; 
}
/*marking active/completed steps green*/
/*The number of the step and the connector before it = green*/
#progressbar li.active:before,  #progressbar li.active:after{
	background: #27AE60;
	color: white;
}
.header{
background-color: #3b5998;
    border-bottom: 1px solid #29487d;
    color: #fff;
	    height: 50px;
    min-width: 100%;
}
<!-- Start Expand and collapse-->
.toggle-box {
  display: none;
}

.toggle-box + label {
  cursor: pointer;
  display: block;
  font-weight: bold;
  line-height: 21px;
  margin-bottom: 5px;
}

.toggle-box + label + div {
  display: none;
  margin-bottom: 10px;
}

.toggle-box:checked + label + div {
  display: block;
}

.toggle-box + label:before {
  background-color: #4F5150;
  -webkit-border-radius: 10px;
  -moz-border-radius: 10px;
  border-radius: 10px;
  color: #FFFFFF;
  content: "+";
  display: block;
  float: left;
  font-weight: bold;
  height: 20px;
  line-height: 20px;
  margin-right: 5px;
  text-align: center;
  width: 20px;
}

.toggle-box:checked + label:before {
  content: "\2212";
}

<!-- End Expand and collapse-->
<!-- Table CSS -->
table {
    font-family: arial, sans-serif;
    border-collapse: collapse;
    width: 100%;
}

td, th {
    border: 1px solid #dddddd;
    text-align: left;
    padding: 8px;
    font-size:12px;
}

tr:nth-child(even) {
    background-color: #dddddd;
}
<!-- End Table CSS -->
</style>
<!-- jQuery -->
<script src="http://thecodeplayer.com/uploads/js/jquery-1.9.1.min.js" type="text/javascript"></script>
<!-- jQuery easing plugin -->
<script src="http://thecodeplayer.com/uploads/js/jquery.easing.min.js" type="text/javascript"></script>
<script type="text/javascript">
$("document").ready(function(){console.log("ready");
//jQuery time
var current_fs, next_fs, previous_fs; //fieldsets
var left, opacity, scale; //fieldset properties which we will animate
var animating; //flag to prevent quick multi-click glitches

$(".next").click(function(){console.log("in");
	if(animating) return false;
	animating = true;
	
	current_fs = $(this).parent();
	next_fs = $(this).parent().next();
	
	//activate next step on progressbar using the index of next_fs
	$("#progressbar li").eq($("fieldset").index(next_fs)).addClass("active");
	
	//show the next fieldset
	next_fs.show(); 
	//hide the current fieldset with style
	current_fs.animate({opacity: 0}, {
		step: function(now, mx) {
			//as the opacity of current_fs reduces to 0 - stored in "now"
			//1. scale current_fs down to 80%
			scale = 1 - (1 - now) * 0.2;
			//2. bring next_fs from the right(50%)
			left = (now * 50)+"%";
			//3. increase opacity of next_fs to 1 as it moves in
			opacity = 1 - now;
			current_fs.css({'transform': 'scale('+scale+')'});
			next_fs.css({'left': left, 'opacity': opacity});
		}, 
		duration: 800, 
		complete: function(){
			current_fs.hide();
			animating = false;
		}, 
		//this comes from the custom easing plugin
		easing: 'easeInOutBack'
	});
});

$(".previous").click(function(){
	if(animating) return false;
	animating = true;
	
	current_fs = $(this).parent();
	previous_fs = $(this).parent().prev();
	
	//de-activate current step on progressbar
	$("#progressbar li").eq($("fieldset").index(current_fs)).removeClass("active");
	
	//show the previous fieldset
	previous_fs.show(); 
	//hide the current fieldset with style
	current_fs.animate({opacity: 0}, {
		step: function(now, mx) {
			//as the opacity of current_fs reduces to 0 - stored in "now"
			//1. scale previous_fs from 80% to 100%
			scale = 0.8 + (1 - now) * 0.2;
			//2. take current_fs to the right(50%) - from 0%
			left = ((1-now) * 50)+"%";
			//3. increase opacity of previous_fs to 1 as it moves in
			opacity = 1 - now;
			current_fs.css({'left': left});
			previous_fs.css({'transform': 'scale('+scale+')', 'opacity': opacity});
		}, 
		duration: 800, 
		complete: function(){
			current_fs.hide();
			animating = false;
		}, 
		//this comes from the custom easing plugin
		easing: 'easeInOutBack'
	});
});

$(".submit").click(function(){
	return false;
});
});

</script>

</HEAD>
<BODY>
<div class="header"><div style="margin:auto;padding:15px;"><div style="margin:auto;padding:15px; background:url('resources/assets/img/money-logo.png') no-repeat;background-size:47px;">&nbsp;</div></div></div>
<div class="formClass">
<!-- multistep form -->
<form id="msform" action="getOffers" method="POST">
	<!-- progressbar -->
	<ul id="progressbar" style="display: none;">
		<li class="active">Account Setup</li>
		<li>Social Profiles</li>
		<li>Personal Details</li>
		<li>Account Details</li>
	</ul>
	<!-- fieldsets -->
	<fieldset>
		<h2 class="fs-title">Customer transaction Details</h2>
		<!-- <h3 class="fs-subtitle">Customers account details</h3> -->
		
		<input class="toggle-box" id="customer1" type="checkbox" style="display: none;"/>
		<label for="customer1">John Doe</label>
		<div>
		<table>
			<tr>
				<th>Transaction date</th>
				<th>Amount</th>
				<th>Transaction type</th>
				<th>Merchant Name</th>
				<th>Direction</th>
				<th>Account Type</th>
				<th>Bank</th>
			</tr>
			<tr>
			    <td>
				2016-05-04
			    </td>
			    <td>
				$10.00
			    </td>
			    <td>
				FOOD
			    </td>
			    <td>
				MERCHANT
			    </td>
			     <td>
				OUT
			    </td>
			    <td>
				Saving
			    </td>
			    <td>
				Barclays
			    </td>
			</tr>
			<tr>
			    <td>
				2026-03-01
			    </td>
			    <td>
				$20.00
			    </td>
			    <td>
				 FOOD
			    </td>
			    <td>
				MERCHANT
			    </td>
			    <td>
				OUT
			    </td>
			     <td>
				Saving
			    </td>
			    <td>
				Barclays
			    </td>
			</tr>
			<tr>
			    <td>
				2026-03-01
			    </td>
			    <td>
				$99.00
			    </td>
			    <td>
				 MOVIES
			    </td>
			    <td>
				MERCHANT
			    </td>
			    <td>
				OUT
			    </td>
			    <td>
				Saving
			    </td>
			    <td>
				Barclays
			    </td>
			</tr>
			<tr>
			    <td>
				2026-03-01
			    </td>
			    <td>
				$80.00
			    </td>
			    <td>
				 ENTERTAINMENT
			    </td>
			    <td>
				MERCHANT
			    </td>
			    <td>
				OUT
			    </td>
			    <td>
				Saving
			    </td>
			    <td>
				Barclays
			    </td>
			</tr>
			<tr>
			    <td>
				2026-03-01
			    </td>
			    <td>
				$20.00
			    </td>
			    <td>
				 FOOD
			    </td>
			    <td>
				MERCHANT
			    </td>
			    <td>
				OUT
			    </td>
			    <td>
				Saving
			    </td>
			    <td>
				Barclays
			    </td>
			</tr>
			<tr>
			    <td>
				2026-03-01
			    </td>
			    <td>
				$238.00
			    </td>
			    <td>
				 ELECTRONICS
			    </td>
			    <td>
				MERCHANT
			    </td>
			    <td>
				OUT
			    </td>
			    <td>
				Saving
			    </td>
			    <td>
				Barclays
			    </td>
			</tr>
			<tr>
				<td><input type="submit" name="getOffers" class="getOffers action-button" value="Generate offers" /></td>
			</tr>
		</table>
		</div>
		<input type="button" name="next" class="next action-button" value="Next" />
	</fieldset>
	</form>
	</div>
	</BODY>
	</HTML>