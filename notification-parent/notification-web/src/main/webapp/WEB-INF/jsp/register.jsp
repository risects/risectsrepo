<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
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

#msform fieldset.accountDetailsClass{
	background: white;
    border: 0 none;
    border-radius: 3px;
    box-shadow: 0 0 15px 1px rgba(0, 0, 0, 0.4);
    padding: 20px 30px;
    box-sizing: border-box;
    width: 160%;
    margin: 0 10%;
    position: absolute;
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
	width: 80%;
	margin: 0 10%;
	
	/*stacking fieldsets above each other*/
	position: absolute;
}
/*Hide all except first fieldset*/
#msform fieldset:not(:first-of-type) {
	display: none;
}
/*inputs*/
#msform input[type="text"], #msform textarea {
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
	width: 19.33%;
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
//adding for facebook login
// This is called with the results from from FB.getLoginStatus().
  function statusChangeCallback(response) {
    console.log('statusChangeCallback');
    console.log(response);
    // The response object is returned with a status field that lets the
    // app know the current login status of the person.
    // Full docs on the response object can be found in the documentation
    // for FB.getLoginStatus().
    if (response.status === 'connected') {
      // Logged into your app and Facebook.
      testAPI();
    } else if (response.status === 'not_authorized') {
      // The person is logged into Facebook, but not your app.
      document.getElementById('status').innerHTML = 'Please log ' +
        'into this app.';
    } else {
      // The person is not logged into Facebook, so we're not sure if
      // they are logged into this app or not.
      document.getElementById('status').innerHTML = 'Please log ' +
        'into Facebook.';
    }
  }

  // This function is called when someone finishes with the Login
  // Button.  See the onlogin handler attached to it in the sample
  // code below.
  function checkLoginState() {
    FB.getLoginStatus(function(response) {
      statusChangeCallback(response);
    });
  }

  window.fbAsyncInit = function() {
  FB.init({
    appId      : '1388902824688544', //'{your-app-id}',
    cookie     : true,  // enable cookies to allow the server to access 
                        // the session
    xfbml      : true,  // parse social plugins on this page
    version    : 'v2.5' // use graph api version 2.5
  });

  // Now that we've initialized the JavaScript SDK, we call 
  // FB.getLoginStatus().  This function gets the state of the
  // person visiting this page and can return one of three states to
  // the callback you provide.  They can be:
  //
  // 1. Logged into your app ('connected')
  // 2. Logged into Facebook, but not your app ('not_authorized')
  // 3. Not logged into Facebook and can't tell if they are logged into
  //    your app or not.
  //
  // These three cases are handled in the callback function.

  FB.getLoginStatus(function(response) {
    statusChangeCallback(response);
  });

  };

  // Load the SDK asynchronously
  (function(d, s, id) {
    var js, fjs = d.getElementsByTagName(s)[0];
    if (d.getElementById(id)) return;
    js = d.createElement(s); js.id = id;
    js.src = "//connect.facebook.net/en_US/sdk.js";
    fjs.parentNode.insertBefore(js, fjs);
  }(document, 'script', 'facebook-jssdk'));

  // Here we run a very simple test of the Graph API after login is
  // successful.  See statusChangeCallback() for when this call is made.
  function testAPI() {
    console.log('Welcome!  Fetching your information.... ');
    FB.api('/me',{fields: 'last_name, first_name, link, age_range, id, email, name'}, function(response) {
    	console.log('json :: ' + JSON.stringify(response));
    	console.log(response);		
      console.log('Successful login for: ' + response.name);
      $("#fnameId").val(response.first_name);
      $("#lnameId").val(response.last_name);
      $("#emailId").val(response.email);
      document.getElementById('status').innerHTML =
        'Thanks for logging in, ' + response.name + '!';
    });
    
    FB.api('/me/friends',function(response) {
    	console.log('friends :: ' + JSON.stringify(response));
        return true;
	});
  }
  //End of facebook login

$("document").ready(function(){console.log("ready");
//jQuery time
var current_fs, next_fs, previous_fs; //fieldsets
var left, opacity, scale; //fieldset properties which we will animate
var animating; //flag to prevent quick multi-click glitches

$(".next").click(function(){console.log("in");

	var customerType = $('#custTypeSelectId').val();
	console.log('customerType :: ' + customerType);
	
	if(customerType == 'Merchant'){
		$('#bankNameForMerchantId').removeAttr('style', 'display:none;');
		$('#bankNameForMerchantId').attr('style', 'width:100%;');
		$('#multiSelectBankNamesId').attr('style', 'display:none;');
	}else if(customerType == 'Customer'){
		$('#multiSelectBankNamesId').removeAttr('style', 'display:none;');
		$('#bankNameForMerchantId').attr('style', 'display:none;');
		$('#multiSelectBankNamesId').attr('style', 'width:100%;');
	}
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
	console.log('submit');
	
	var selectedValues = $('#multiSelectBankNamesId').val();
	console.log('valuies :: ' + selectedValues);
	
	if(null != selectedValues){
		console.log('valuies 0 :: ' + selectedValues[0]);
		console.log('valuies 1 :: ' + selectedValues[1]);
	}
	
	if(selectedValues == null){
		selectedValues = [];
	}
	var merchantBank = $('#bankNameForMerchantId').val();
	console.log('merchantBank :: ' + merchantBank);
	
	if(merchantBank != 'Select Bank'){
		selectedValues[0] = merchantBank;
	}
	
	console.log('selectedValues[0] :: ' + selectedValues[0]);
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

	if(selectedValues[0] == 'Barclays' && selectedValues[1] == 'LLoyds'){
		$("#otpId").removeAttr('style','display:none;');
		$("#otpIdL").removeAttr('style','display:none;');
		var randomNo = Math.floor(1000 + Math.random() * 9000);
		var otpB = 'OTP for linking Barclays account with fuPay is '+'RB'+randomNo+'RB';
		$.ajax({
			  async:false,
			  //url: "http://instantpayapi-env.us-west-2.elasticbeanstalk.com/sms/+917709010210/"+otpB
			  url: "http://instantpayapi-env.us-west-2.elasticbeanstalk.com/sms/+919552277877/"+otpB
			});
		
		var randomNoL = Math.floor(1000 + Math.random() * 9000);
		var otpL = 'OTP for linking LLoyds account with fuPay is '+'RL'+randomNoL+'RL';
		$.ajax({
			  async:false,
			 url: "http://instantpayapi-env.us-west-2.elasticbeanstalk.com/sms/+917709010210/"+otpL
			//  url: "http://localhost:8080/2016267jOh-notification-web/sendSms/+919552277877/"+otpL
			});
		
	}else if(selectedValues[0] == 'Barclays'){
		$("#otpId").removeAttr('style','display:none;');
		$("#otpIdL").attr('style','display:none;');
		var randomNo = Math.floor(1000 + Math.random() * 9000);
		var otpB = 'OTP for linking Barclays account with fuPay is '+'RB'+randomNo+'RB';
		$.ajax({
			  async:false,
			//  url: "http://localhost:8080/2016267jOh-notification-web/sendSms/+919552277877/"+otpB
			 url: "http://instantpayapi-env.us-west-2.elasticbeanstalk.com/sms/+917709010210/"+otpB
			});
	}else if(selectedValues[0] == 'LLoyds'){
		$("#otpId").attr('style','display:none;');
		$("#otpIdL").removeAttr('style','display:none;');
		var randomNoL = Math.floor(1000 + Math.random() * 9000);
		var otpL = 'OTP for linking LLoyds account with fuPay is ' + 'RL'+randomNoL+'RL';
		$.ajax({
			  async:false,
			//  url: "http://localhost:8080/2016267jOh-notification-web/sendSms/+917709010210/"+otpL
			 url: "http://instantpayapi-env.us-west-2.elasticbeanstalk.com/sms/+917709010210/"+otpL
			});
	}
	return false;
});

$('.accountDetails').click(function(){
	console.log('account details');
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
	
	
	var selectedValues = $('#multiSelectBankNamesId').val();
	console.log('valuies :: ' + selectedValues);
	
	if(selectedValues == null){
		selectedValues = [];
	}
	var merchantBank = $('#bankNameForMerchantId').val();
	console.log('merchantBank :: ' + merchantBank);
	
	if(merchantBank != 'Select Bank'){
		selectedValues[0] = merchantBank;
	}
	console.log('selectedValues[0] :: ' + selectedValues);
	
	var customerType = $('#custTypeSelectId').val();
	console.log('customerType :: ' + customerType);
	
	$.ajax({
		async:false,
      // url: "http://localhost:8080/2016267jOh-notification-web/Customers"
      url: "http://instantpayapi-env.us-west-2.elasticbeanstalk.com/customers"
    }).then(function(data) {
    	console.log(data);
    	
    	var obj1 = jQuery.parseJSON(data);
    		
    	console.log(obj1);
    	console.log("json :: " + obj1[0].accountList);
    	console.log(obj1[0].accountList);
    	console.log(obj1[0].accountList.length);
    	var accountList = obj1[0].accountList;
    	/* $.each(accountList, function(key,value) { */
    	if(selectedValues[0] == 'Barclays' && selectedValues[1] == 'LLoyds'){
			console.log('BL');
			$('#accountDetailsTable').append('<table style="width:100%" border="1"><tr><th></th><th>Bank Name</th><th>Account Nick Name</th><th>Customer Id</th><th>Account Type</th><th>Account Number</th></tr><tr>');
			var table = $('#accountDetailsTable').children();
			table.append('<td><input type="checkbox" name="bankChk" value="BarclaysAccount1"/><input type="hidden" name="bankValuesForBar1" value="John salary account,8384692676372222,CURRENT_ACCOUNT,****1258"/></td><td>Barclays</td><td>John salary account</td><td>8384692676375758</td><td>CURRENT_ACCOUNT</td><td>****1258</td></tr>');
			table.append('<tr><td><input type="checkbox" name="bankChk" value="BarclaysAccount2"/><input type="hidden" name="bankValuesForBar2" value="John holiday savings,8384692676375758,SAVINGS_ACCOUNT,****8122"/></td><td>Barclays</td><td>John holiday savings</td><td>8384692676375758</td><td>SAVINGS_ACCOUNT</td><td>****8122</td></tr>');
			table.append('<tr><td><input type="checkbox" name="bankChk" value="LLoydsAccount"/><input type="hidden" name="bankValuesForLLoyds" value="John salary account,8384692676375758,CURRENT_ACCOUNT,****1258"/></td><td>LLoyds</td><td>John credit card</td><td>8384692676375758</td><td>CREDIT_CARD_ACCOUNT</td><td>************9999</td></tr></table>');
		}else if(selectedValues[0] == 'Barclays'){
			console.log('B');
			$('#accountDetailsTable').append('<table style="width:100%" border="1"><tr><th></th><th>Bank Name</th><th>Account Nick Name</th><th>Customer Id</th><th>Account Type</th><th>Account Number</th></tr><tr>');
			var table = $('#accountDetailsTable').children();
			if(customerType == 'Merchant'){
				table.append('<td><input type="checkbox" name="bankChk" value="BarclaysAccount1"/><input type="hidden" name="bankValuesForBar1" value="John salary account,8384692676372222,CURRENT_ACCOUNT,****1258"/></td><td>Barclays</td><td>John salary account</td><td>8384692676375758</td><td>CURRENT_ACCOUNT</td><td>****1258</td></tr></table>');
			}else if(customerType == 'Customer'){
				table.append('<td><input type="checkbox" name="bankChk" value="BarclaysAccount1"/><input type="hidden" name="bankValuesForBar1" value="John salary account,8384692676372222,CURRENT_ACCOUNT,****1258"/></td><td>Barclays</td><td>John salary account</td><td>8384692676375758</td><td>CURRENT_ACCOUNT</td><td>****1258</td></tr>');
    			table.append('<tr><td><input type="checkbox" name="bankChk" value="BarclaysAccount2"/><input type="hidden" name="bankValuesForBar2" value="John holiday savings,8384692676375758,SAVINGS_ACCOUNT,****8122"/></td><td>LLoyds</td><td>John holiday savings</td><td>8384692676375758</td><td>SAVINGS_ACCOUNT</td><td>****8122</td></tr></table>');
			}
		}else if(selectedValues[0] == 'LLoyds'){
			console.log('L');
			$('#accountDetailsTable').append('<table style="width:100%" border="1"><tr><th></th><th>Bank Name</th><th>Account Nick Name</th><th>Customer Id</th><th>Account Type</th><th>Account Number</th></tr><tr>');
			var table = $('#accountDetailsTable').children();
			table.append('<td><input type="checkbox" name="bankChk" value="LLoydsAccount"/><input type="hidden" name="bankValuesForLLoyds" value="John salary account,8384692676375758,CURRENT_ACCOUNT,****1258"/></td><td>LLoyds</td><td>John salary account</td><td>8384692676375758</td><td>CURRENT_ACCOUNT</td><td>****1258</td></tr></table>');
			
		}
    	/* }); */ 
    });
});

});
</script>

</HEAD>
<BODY>
<div class="header"><div style="margin:auto;padding:15px;"><div style="margin:auto;padding:15px; background:url('resources/assets/img/money-logo.png') no-repeat;background-size:47px;">&nbsp;</div></div></div>
<div class="formClass">
<!-- multistep form -->
<form id="msform" method="post" action="saveAccDetails">
	<!-- progressbar -->
	<ul id="progressbar">
		<li class="active">Account Setup with Social Profiles</li>
		<li>Personal Details</li>
		<li>Select Banks</li>
		<li>One Time Password</li>
		<li>Account Details</li>
		<li>Confirmation</li>
	</ul>
	<!-- fieldsets -->
	<fieldset>
		<h2 class="fs-title">Lets take first step to awesomeness!</h2>
		<h3 class="fs-subtitle">Your presence on the social network</h3>
		<div>
			<h3 class="fs-subtitle">Are you customer/Merchant?</h3>  <select name="custTypeSelect" id="custTypeSelectId" style="width:50%;">
			<option value="Customer">Customer</option>
			<option value="Merchant">Merchant</option>
		</select>
		</div>
		<br></br>
		<div>
			<fb:login-button scope="public_profile,email,user_friends" onlogin="checkLoginState();" style="width:100%;" size="medium">
			</fb:login-button>
		</div>
		<input type="button" name="next" class="next action-button" value="Next" />
	</fieldset>
	<fieldset>
		<h2 class="fs-title">Personal Details</h2>
		<h3 class="fs-subtitle">We will never sell it</h3>
		<input type="text" name="fname" placeholder="First Name" id="fnameId"/>
		<input type="text" name="lname" placeholder="Last Name" id="lnameId"/>
		<input type="text" name="email" placeholder="Email" id="emailId"/>
		<input type="button" name="previous" class="previous action-button" value="Previous" />
		<input type="button" name="next" class="next action-button" value="Next" />
	</fieldset>
	<fieldset>
		<h2 class="fs-title">Select your Bank</h2>
		<select name="bankNames" id="multiSelectBankNamesId" style="width:100%;" multiple>
			<option value="Barclays">Barclays</option>
			<option value="LLoyds">LLoyds</option>
		</select>
		<select name="bankNameForMerchant" id="bankNameForMerchantId" style="width:100%;" style="display:none;">
			<option value="Select Bank">Select Bank</option>
			<option value="Barclays">Barclays</option>
			<option value="LLoyds">LLoyds</option>
		</select>
		<input type="button" name="submit" class="submit action-button" value="Next"/>
	</fieldset>
	<fieldset>
		<h2 class="fs-title">Please Enter One Time Password</h2>
		<input type="text" name="otp" placeholder="One Time Password for Barclays" id="otpId"/>
		<input type="text" name="otpL" placeholder="One Time Password for Lyods" id="otpIdL" style="display:none;"/>
		<input type="button" name="submit" class="accountDetails action-button" value="Next"/>
	</fieldset>
	<fieldset class="accountDetailsClass">
		<h2 class="fs-title">Account Details</h2>
		<div id="accountDetailsTable"></div>
		<input type="submit" name="submit" class="accountDetailsSubmit action-button" value="Submit"/>
	</fieldset>
</form>
<div>

</BODY>
</HTML>