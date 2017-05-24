package ua.shop.vitaly.controllers;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ua.shop.vitaly.models.product.Product;
import ua.shop.vitaly.models.user.User;
import ua.shop.vitaly.services.product.ProductService;

@Controller
@RequestMapping("/")
public class ProductController {
	
	@Autowired
	private HttpSession httpSession;
	@Autowired
	private ProductService productService;
	
	@RequestMapping(value={"/ProductID","/Productid","/PRODUCTID","/productid"},method = RequestMethod.GET)
	public String ProductIdAction(@RequestParam(required = true) String id,ModelMap model) {

		Product product = null;
		try {
			product = productService.getProduct(Integer.parseInt(id));
		} catch (NumberFormatException e) {
			model.addAttribute("error", e.getMessage());
			return "ErrorPage";
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
			return "ErrorPage";
		}
		httpSession.setAttribute("product", product);
		return "/includes/ProductIdContent";
	}
	
	@RequestMapping(value = "/Search", method = RequestMethod.GET)
	public String SeachAction(@RequestParam(required = true) String name, ModelMap model) {
		if(name.length()==0) return "redirect:/";
		ArrayList<Product> itemList = null;
		try {
			itemList = productService.getAllProductsByName(name);
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
			return "ErrorPage";
		}
		httpSession.setAttribute("itemList", itemList);
		return "/includes/SearchContent";
	}
	
	@RequestMapping(value = {"/ProductCard","/productcard","PRODUCTCARD","Productcard"}, method = RequestMethod.GET)
	public String OpenCardAction(ModelMap model) {
		
		int id =  ((User)httpSession.getAttribute("user")).getId(); 
		ArrayList<Product> basketList =null;
		
		try {
			 basketList = productService.getFromBasket(id);
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
			return "ErrorPage";
		}
		httpSession.setAttribute("basketList", basketList);
		return "/includes/basket";
	}
	
	@RequestMapping(value = "/AddToCard", method = RequestMethod.POST)
	public String AddToCardAction(@RequestParam(required = true) String productID, ModelMap model) {
		
		try {
			productService.AddToBasket(((User)httpSession.getAttribute("user")).getId(), Integer.parseInt(productID));
			return "redirect:/ProductID?id="+productID;
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
			return "ErrorPage";
		}
		
	}
	
	@RequestMapping(value = "/RemoveFromCard", method = RequestMethod.POST)
	public String RemoveFromCardAction(@RequestParam(required = true) String prodID, ModelMap model) {
		
		try {
			productService.RemoveFromBasket(((User) httpSession.getAttribute("user")).getId(), Integer.parseInt(prodID));
			return "redirect:/productcard";
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
			return "ErrorPage";
		}

	}
	
}
