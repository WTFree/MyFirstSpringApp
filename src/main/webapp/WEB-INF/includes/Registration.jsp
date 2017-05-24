<div class="modal-shadow-registration"></div>
<div class="modal-window-registration">
  <div class="close-registration">X</div>
  <p class="validateTips"><font size="3">All form fields are required.</font></p>
  <form method = "post" action ="${pageContext.request.contextPath}/registration">
    <fieldset>
    <div class="main-registration">
      <div class="field-registration">
	      <label for="name"><font size = "3">Name</font></label>
	      <input type="text" name="login" placeholder="Write your login" id="login" class="text ui-widget-content ui-corner-all">
      </div>
      <div class="field-registration">
	      <label for="password"><font size ="3">Password</font></label>
	      <input type="password" name="password" placeholder="Pass" id="password"  class="text ui-widget-content ui-corner-all">
	  </div>
	  <div class="field-registration">
	   	  <label for="conf_password"><font size = "3">Confirm Password</font></label>
	  <input type="password" name="conf_password" id ="conf_password" placeholder="Conf. pass" class="text ui-widget-content ui-corner-all">
      </div>
      <br><input type="submit" value="Registration">
    </div>
    </fieldset>
  </form>
</div>