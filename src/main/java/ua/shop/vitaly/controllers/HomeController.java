package ua.shop.vitaly.controllers;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ua.shop.vitaly.models.product.Product;
import ua.shop.vitaly.services.product.ProductService;


@Controller
@RequestMapping(value = "/")
public class HomeController {

	@Autowired
	private HttpSession httpSession;
	@Autowired
	private ProductService productService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(ModelMap model) {
		ArrayList<Product> itemList = null;
		try {
			 itemList = productService.getAllProducts();
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
			return "ErrorPage";
		}
		httpSession.setAttribute("itemList", itemList);
		return "home";
	}
	
}
