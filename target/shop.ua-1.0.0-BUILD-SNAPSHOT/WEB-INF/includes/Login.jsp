<div class="modal-shadow-login"></div>
<div class="modal-window-login">
  <div class="close-login">X</div>
  <p class="validateTips"><font size="3">Write your personal datas</font></p>
  <form method = "post" action ="${pageContext.request.contextPath}/login">
    <fieldset>
    <div class="main-login">
      <div class="field-login">
	      <label for="name"><font size="3">Name</font></label>
	      <input type="text" name="login" placeholder="Write your login" id="login" class="text ui-widget-content ui-corner-all">
      </div>
      <div class="field-login">
	      <label for="password"><font size="3">Password</font></label>
	      <input type="password" name="password" placeholder="Pass" id="password"  class="text ui-widget-content ui-corner-all">
	  </div>
   	  <br> <input type="submit" value="Login" >
    </div>
    </fieldset>
    </form>
</div>
