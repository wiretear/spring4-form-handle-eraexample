<!DOCTYPE html>
<html >
<head>
  <meta charset="UTF-8">
  <title>Spring Login Form</title>
      <style>
      * { box-sizing:border-box; }

body {
	font-family: Helvetica;
	background-image: url(http://www.prowebdesignuk.com/wp-content/uploads/revslider/The7-homepage/bg-01.jpg);
	
  -webkit-font-smoothing: antialiased;
}

hgroup { 
	text-align:center;
	margin-top: 4em;
}

h1, h3 { font-weight: 300; }
  
h1 { color: #636363; }

h3 { color: #4a89dc; }

form {
	width: 380px;
	margin: 4em auto;
	padding: 3em 2em 2em 2em;
	background: #fafafa;
	border: 1px solid #ebebeb;
	box-shadow: rgba(0,0,0,0.14902) 0px 1px 1px 0px,rgba(0,0,0,0.09804) 0px 1px 2px 0px;
}

.group { 
	position: relative; 
	margin-bottom: 45px; 
}

input {
	font-size: 18px;
	padding: 10px 10px 10px 5px;
	-webkit-appearance: none;
	display: block;
	background: #fafafa;
	color: #636363;
	width: 100%;
	border: none;
	border-radius: 0;
	border-bottom: 1px solid #757575;
}

input:focus { outline: none; }


/* Label */

label {
	color: #999; 
	font-size: 18px;
	font-weight: normal;
	position: absolute;
	pointer-events: none;
	left: 5px;
	top: 10px;
	-webkit-transition:all 0.2s ease;
	transition: all 0.2s ease;
}


/* active */

input:focus ~ label, input.used ~ label {
	top: -20px;
  -webkit-transform: scale(.75);
          transform: scale(.75); left: -2px;
	/* font-size: 14px; */
	color: #4a89dc;
}


/* Underline */

.bar {
	position: relative;
	display: block;
	width: 100%;
}

.bar:before, .bar:after {
	content: '';
	height: 2px; 
	width: 0;
	bottom: 1px; 
	position: absolute;
	background: #4a89dc; 
	-webkit-transition:all 0.2s ease; 
	transition: all 0.2s ease;
}

.bar:before { left: 50%; }

.bar:after { right: 50%; }


/* active */

input:focus ~ .bar:before, input:focus ~ .bar:after { width: 50%; }


/* Highlight */

.highlight {
	position: absolute;
	height: 60%; 
	width: 100px; 
	top: 25%; 
	left: 0;
	pointer-events: none;
	opacity: 0.5;
}


/* active */

input:focus ~ .highlight {
	-webkit-animation: inputHighlighter 0.3s ease;
	        animation: inputHighlighter 0.3s ease;
}


/* Animations */

@-webkit-keyframes inputHighlighter {
	from { background: #4a89dc; }
	to 	{ width: 0; background: transparent; }
}

@keyframes inputHighlighter {
	from { background: #4a89dc; }
	to 	{ width: 0; background: transparent; }
}


/* Button */

.button {
  position: relative;
  display: inline-block;
  padding: 12px 24px;
  margin: .3em 0 1em 0;
  width: 100%;
  vertical-align: middle;
  color: #fff;
  font-size: 16px;
  line-height: 20px;
  -webkit-font-smoothing: antialiased;
  text-align: center;
  letter-spacing: 1px;
  background: transparent;
  border: 0;
  border-bottom: 2px solid #3160B6;
  cursor: pointer;
  -webkit-transition:all 0.15s ease;
  transition: all 0.15s ease;
}
.button:focus { outline: 0; }


/* Button modifiers */

.buttonBlue {
  background: #4a89dc;
  text-shadow: 1px 1px 0 rgba(39, 110, 204, .5);
}

.buttonBlue:hover { background: #357bd8; }


/* Ripples container */

.ripples {
  position: absolute;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  overflow: hidden;
  background: transparent;
}
/* Ripples circle */

.ripplesCircle {
  position: absolute;
  top: 50%;
  left: 50%;
  -webkit-transform: translate(-50%, -50%);
          transform: translate(-50%, -50%);
  opacity: 0;
  width: 0;
  height: 0;
  border-radius: 50%;
  background: rgba(255, 255, 255, 0.25);
}

.ripples.is-active .ripplesCircle {
  -webkit-animation: ripples .4s ease-in;
          animation: ripples .4s ease-in;
}


/* Ripples animation */

@-webkit-keyframes ripples {
  0% { opacity: 0; }

  25% { opacity: 1; }

  100% {
    width: 200%;
    padding-bottom: 200%;
    opacity: 0;
  }
}

@keyframes ripples {
  0% { opacity: 0; }

  25% { opacity: 1; }

  100% {
    width: 200%;
    padding-bottom: 200%;
    opacity: 0;
  }
}

footer { text-align: center; }

footer p {
	color: #888;
	font-size: 13px;
	letter-spacing: .4px;
}

footer a {
	color: #4a89dc;
	text-decoration: none;
	-webkit-transition:all .2s ease;
	transition: all .2s ease;
}

footer a:hover {
	color: #666;
	text-decoration: underline;
}

footer img {
	width: 80px;
	-webkit-transition:all .2s ease;
	transition: all .2s ease;
}

footer img:hover { opacity: .83; }

footer img:focus , footer a:focus { outline: none; }
      </style>
</head>

<body>
  <hgroup>
  <h1>Spring First Project</h1>
  <h3>By Neaz Ahsan</h3>
  <h4>${msg}</h4>
</hgroup>
<form method="post" action="/spring-mvc-form-era/usershome">
  <div class="group">
    <input type="text" name="name" /><span class="highlight"></span><span class="bar"></span>
    <label>User Name</label>
  </div>
  <div class="group">
    <input type="password" name="password" /><span class="highlight"></span><span class="bar"></span>
    <label>Password</label>
  </div>
  <input type="submit" class="button buttonBlue" value="Submit">
    
</form>

  <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
   <script>
   $(window, document, undefined).ready(function() {

	   $('input').blur(function() {
	     var $this = $(this);
	     if ($this.val())
	       $this.addClass('used');
	     else
	       $this.removeClass('used');
	   });

	   var $ripples = $('.ripples');

	   $ripples.on('click.Ripples', function(e) {

	     var $this = $(this);
	     var $offset = $this.parent().offset();
	     var $circle = $this.find('.ripplesCircle');

	     var x = e.pageX - $offset.left;
	     var y = e.pageY - $offset.top;

	     $circle.css({
	       top: y + 'px',
	       left: x + 'px'
	     });

	     $this.addClass('is-active');

	   });

	   $ripples.on('animationend webkitAnimationEnd mozAnimationEnd oanimationend MSAnimationEnd', function(e) {
	   	$(this).removeClass('is-active');
	   });

	 });
   </script> 
     

</body>
</html>