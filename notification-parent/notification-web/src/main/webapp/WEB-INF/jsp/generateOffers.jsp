<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin Login</title>
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
	padding: 0px 4px;
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
<script type="text/javascript">
$("document").ready(function(){
$.ajax({
    async:false,
	url: "http://instantpayapi-env.us-west-2.elasticbeanstalk.com/customers/offers/rahulsri.dhn@gmail.com/service"

}).then(function(data) {
console.log(data);
});
});
</script>
</head>
<body>
<div class="header"><div style="margin:auto;padding:15px;"><div style="margin:auto;padding:15px; background:url('resources/assets/img/money-logo.png') no-repeat;background-size:47px;">&nbsp;</div></div></div>
<div class="formClass">
<form id="msform">
<fieldset>
		<h2 class="fs-title">Offers</h2>
		<table>
			<tr>
				<th>Offered By</th>
				<th>Description</th>
				<th>Coupon Code</th>
				<th>Rank</th>
			</tr>
			<tr>
			    <td>
				BANK
			    </td>
			    <td>
				Enjoy 20,000 Bonus Miles when you Spend $1,000 in the First 90 Days!!
			    </td>
			    <td>
				90MILES
			    </td>
			    <td>
				2
			    </td>
			</tr>
			<tr>
			    <td>
				BANK
			    </td>
			    <td>
				Get 10% Miles Back when you Redeem for Travel Statement Credits!!
			    </td>
			    <td>
				10MILES
			    </td>
			    <td>
				3
			    </td>
			</tr>
			<tr>
			    <td>
				BANK
			    </td>
			    <td>
				Choose Your Own Coupons and Up to 12% Off or $100 Off!
			    </td>
			    <td>
				100FF100US
			    </td>
			    <td>
				4
			    </td>
			</tr>
			<tr>
			    <td>
				BANK
			    </td>
			    <td>
				TicketNetwork: 10% Off Last-Minute Ticket Purchases
			    </td>
			    <td>
				10LLOYDS
			    </td>
			    <td>
				5
			    </td>
			</tr>
			<tr>
			    <td>
				MERCHANT
			    </td>
			    <td>
				Choose Your Own Coupons and Up to 12% Off or $HOTEL0 Off!
			    </td>
			    <td>
				HOTEL10US
			    </td>
			    <td>
				2
			    </td>
			</tr>
		</table>
		<a href="/Payment-Aggregator/aggregator/" class="action-button">Go to Home Page</a>
	</fieldset>
</form>
</div>