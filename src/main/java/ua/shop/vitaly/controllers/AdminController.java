package ua.shop.vitaly.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ua.shop.vitaly.models.product.NoSuchProductException;
import ua.shop.vitaly.models.product.Product;
import ua.shop.vitaly.services.product.ProductService;

@Controller
@RequestMapping("/")
public class AdminController {
	
	@Autowired
	private ProductService productService;

	@RequestMapping(value ={"/AdminMenu","/adminmenu","ADMINMENU","Adminmenu"})
	public String AdminMenuAction(){
		return "AdminMenu";
	}
	
	@RequestMapping(value ={"/ProductRegister","/productegister","PRODUCTREGISTER","Productegister"}, method=RequestMethod.POST)
	public String ProductRegisterAction(@RequestParam(required = true) String nameProd, String price, String type, String img,ModelMap model){

		try {
			productService.createProduct(nameProd,price,type,img);
			return "redirect:/adminmenu";
		} catch (NoSuchProductException e) {
			model.addAttribute("error", e.getMessage());
			return "ErrorPage";		
		}
		
	}
	
	@RequestMapping(value ={"/ProductDelete","/productdelete","PRODUCTDELETE","Productdelete"}, method=RequestMethod.POST)
	public String ProductDeleteAction(@RequestParam(required = true) String nameProd, String price, String type, String img, ModelMap model){
		try{
			productService.deleteProduct(productService.getProduct(nameProd, price, type, img));
			return "redirect:/adminmenu";
		}
		catch(Exception e){
			model.addAttribute("error", e.getMessage());
			return "ErrorPage";
		}
	}
	
	@RequestMapping(value ={"/ProductUpdate","/productUpdate","PRODUCTUPDATE","Productupdate"}, method=RequestMethod.POST)
	public String ProductUpdateAction(@RequestParam(required = true) String OLDnameProd, String OLDprice, String OLDtype, String OLDimg,
			 String NEWnameProd, String NEWprice, String NEWtype, String NEWimg,ModelMap model){
		
		try {
			productService.updateProduct(productService.getProduct(OLDnameProd, OLDprice, OLDtype, OLDimg), new Product(NEWnameProd, NEWprice, NEWtype, NEWimg));
			return "redirect:/adminmenu";
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
			return "ErrorPage";		
		}
		
	}
	
}
