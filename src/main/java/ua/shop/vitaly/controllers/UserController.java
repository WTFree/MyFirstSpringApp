package ua.shop.vitaly.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ua.shop.vitaly.services.User.UserService;

@Controller
@RequestMapping("/")
public class UserController {
	
	
	@Autowired
	private HttpSession httpSession;
	
	@Autowired
	private UserService uService;
	
    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registerAction(@RequestParam(required = true) String login, String password, String conf_password, ModelMap model) {	

		if(conf_password.equals(password)){
			try{
				uService.createUser(login, conf_password);
				httpSession.setAttribute("user", uService.getUser(login, password));
				return "redirect:/";
			}
			catch(Exception e){
				model.addAttribute("error", e.getMessage());
				return "ErrorPage";
			}
		}
		else{
			model.addAttribute("error", "pass != conf. pass");
			return "ErrorPage";
		}

	}

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String loginAction(@RequestParam("login") String login, @RequestParam("password") String password, ModelMap model) {
    	
    	try{
    		httpSession.setAttribute("user",uService.getUser(login, password));
    		return "redirect:/";
    	}
    	catch(Exception e){
			model.addAttribute("error", e.getMessage());
			return "ErrorPage";
    	}

    }

    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    public String logoutAction() {
        httpSession.removeAttribute("user");
        return "redirect:/";
    }

}

