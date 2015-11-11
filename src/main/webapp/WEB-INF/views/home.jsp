<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html >
  <head>
    <meta charset="UTF-8">
    <title>Login</title>


    

    <link rel='stylesheet prefetch' href='http://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css'>

       
<style>
     <%@ include file="css/style.css"%>
     
      <%@ include file="css/normalize.css"%>
      
     
</style>



  </head>

  <body>

    <div class="logmod" style="background: #283d68;">
  <div class="logmod__wrapper">
    <div class="connect__context" style="background: #dd4b39; color: #FFF; padding-bottom:3%;" >
      <br/>
    <h2>Spending Tracker</h2>
    <span>All your spending in one place</span></div>
    <div class="logmod__container">
      <ul class="logmod__tabs">
        <li data-tabtar="lgm-2"><a href="#">Login</a></li>
        <li data-tabtar="lgm-1"><a href="#">Sign Up</a></li>
      </ul>
      <div class="logmod__tab-wrapper">
      <div class="logmod__tab lgm-1">
        <div class="logmod__heading">
          <span class="logmod__heading-subtitle">Enter your personal details <strong>to create an account</strong></span>
        </div>
        <div class="logmod__heading">
          <span class="logmod__heading-subtitle" style="color:red; line-height:normal;"><strong>${regmessage}</strong></span>
        </div>
        <div class="logmod__form">
          <form accept-charset="utf-8" action="signup" class="simform" method="post">
          <div class="sminputs">
              <div class="input string optional">
                <label class="string optional" for="userfname">First Name*</label>
                <input class="string optional" maxlength="255" id="userfname" placeholder="A" name="rfname" type="text" size="50" />
              </div>
              <div class="input string optional">
                <label class="string optional" for="usermname">Middle Name *</label>
                <input class="string optional" maxlength="255" id="usermname" placeholder="Repeat password" type="text" name="rmname" size="50" />
              </div>
              <div class="input string optional">
                <label class="string optional" for="userlname">Last Name*</label>
                <input class="string optional" maxlength="255" id="userlname" placeholder="Repeat password" type="text" name="rlname" size="50" />
              </div>
            </div>
            <div class="sminputs">
              <div class="input full">
                <label class="string optional" for="user-name">User Name*</label>
                <input class="string optional"  maxlength="255" id="user-name" placeholder="User Name(eg: sandy)" type="text" name="rusername" size="50" onchange="checkusername" />
              	<span>${uservalidity} </span>
              </div>
            </div>
            <div class="sminputs">
              <div class="input string optional">
                <label class="string optional" for="user-pw">Password *</label>
                <input class="string optional" maxlength="255" id="user-pw" placeholder="Password" name="rpassword1"type="text" size="50" />
              </div>
              <div class="input string optional">
                <label class="string optional" for="user-pw-repeat">Repeat password *</label>
                <input class="string optional" maxlength="255" id="user-pw-repeat" placeholder="Repeat password" type="text" name="rpassword2" size="50" />
              </div>
            </div>
            <div class="sminputs">
              <div class="input full">
                <label class="string optional" for="user-email">Email*</label>
                <input class="string optional"  maxlength="255" id="user-email" placeholder="Email" type="email" name="remail" size="50" />
              </div>
            </div>
            <div class="sminputs">
              <div class="input full">
                <label class="string optional" for="age">Age*</label>
                <input class="string optional"  maxlength="255" id="age" placeholder="Age" type="text" name="age" size="50" />
              </div>
            </div>
            
            <div class="sminputs">
              <div class="input full">
                <label class="string optional" for="dob">Date Of Birth(mm/dd/yyyy)*</label>
                <input class="string optional"  maxlength="255" id="dob" placeholder="Age" type="text" name="dob" size="50" />
              </div>
            </div>
            
            
            <div class="sminputs">
              <div class="input full">
                <label class="string optional" for="currency">Currency*</label>
                <input class="string optional"  maxlength="255" id="currency" placeholder="$" type="text" name="currency" size="50" />
              </div>
            </div>
            <div class="simform__actions">
              <button class="sumbit" onfocus="this.blur()" readonly="readonly" name="commit" type="sumbit" value="Create Account">Create Account</button>
              <span class="simform__actions-sidetext">By creating an account you agree to our <a class="special" href="#" target="_blank" role="link">Terms & Privacy</a></span>
            </div>
          </form>
        </div>

      </div>
      <div class="logmod__tab lgm-2">
        <div class="logmod__heading">
          <span class="logmod__heading-subtitle">Enter your email and password <strong>to sign in</strong></span>
        </div>
        <div class="logmod__heading">
          <span class="logmod__heading-subtitle" style="color:red; line-height:normal;"><strong>${errormessage }</strong></span>
        </div>
        <div class="logmod__form">
          <form accept-charset="utf-8" class="simform" action="trylogin" method="post">
            <div class="sminputs">
              <div class="input full">
                <label class="string optional" for="user-name">Email*</label>
                <input class="string optional" maxlength="255" id="user-name" placeholder="User Name" type="text" name ="lusername" size="50" />
              </div>
            </div>
            <div class="sminputs">
              <div class="input full">
                <label class="string optional" for="user-pw">Password *</label>
                <input class="string optional" maxlength="255" id="user-pw" placeholder="Password" type="password" name="lpassword" size="50" />
                						<span class="hide-password">Show</span>
              </div>
            </div>
            <div class="simform__actions">
              <button class="sumbit" name="commit" type="sumbit" value="Log In" onfocus="this.blur()" readonly="readonly">Log Me In</button>
              <span class="simform__actions-sidetext"><a class="special" role="link" href="#">Forgot your password?<br>Click here</a></span>
            </div>
          </form>
        </div>

          </div>
      </div>
    </div>
  </div>
</div>
    <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
	<script>
	var LoginModalController = {
		    tabsElementName: ".logmod__tabs li",
		    tabElementName: ".logmod__tab",
		    inputElementsName: ".logmod__form .input",
		    hidePasswordName: ".hide-password",

		    inputElements: null,
		    tabsElement: null,
		    tabElement: null,
		    hidePassword: null,

		    activeTab: null,
		    tabSelection: 0, // 0 - first, 1 - second

		    findElements: function () {
		        var base = this;

		        base.tabsElement = $(base.tabsElementName);
		        base.tabElement = $(base.tabElementName);
		        base.inputElements = $(base.inputElementsName);
		        base.hidePassword = $(base.hidePasswordName);

		        return base;
		    },

		    setState: function (state) {
		    	var base = this,
		            elem = null;

		        if (!state) {
		            state = 0;
		        }

		        if (base.tabsElement) {
		        	elem = $(base.tabsElement[state]);
		            elem.addClass("current");
		            $("." + elem.attr("data-tabtar")).addClass("show");
		        }

		        return base;
		    },

		    getActiveTab: function () {
		        var base = this;

		        base.tabsElement.each(function (i, el) {
		           if ($(el).hasClass("current")) {
		               base.activeTab = $(el);
		           }
		        });

		        return base;
		    },

		    addClickEvents: function () {
		    	var base = this;

		        base.hidePassword.on("click", function (e) {
		            var $this = $(this),
		                $pwInput = $this.prev("input");

		            if ($pwInput.attr("type") == "password") {
		                $pwInput.attr("type", "text");
		                $this.text("Hide");
		            } else {
		                $pwInput.attr("type", "password");
		                $this.text("Show");
		            }
		        });

		        base.tabsElement.on("click", function (e) {
		            var targetTab = $(this).attr("data-tabtar");

		            e.preventDefault();
		            base.activeTab.removeClass("current");
		            base.activeTab = $(this);
		            base.activeTab.addClass("current");

		            base.tabElement.each(function (i, el) {
		                el = $(el);
		                el.removeClass("show");
		                if (el.hasClass(targetTab)) {
		                    el.addClass("show");
		                }
		            });
		        });

		        base.inputElements.find("label").on("click", function (e) {
		           var $this = $(this),
		               $input = $this.next("input");

		            $input.focus();
		        });

		        return base;
		    },

		    initialize: function () {
		        var base = this;

		        base.findElements().setState().getActiveTab().addClickEvents();
		    }
		};

		$(document).ready(function() {
		    LoginModalController.initialize();
		});

	</script>




  </body>
</html>
