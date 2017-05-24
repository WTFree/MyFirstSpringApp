package ua.shop.vitaly.services.product;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.shop.vitaly.models.product.NoSuchProductException;
import ua.shop.vitaly.models.product.Product;
import ua.shop.vitaly.models.product.DAO.JDBCProductDAO;

@Service
public class ProductService implements IProductService {
	
	@Autowired
	private JDBCProductDAO productDAO;
	
	public Product getProduct(int id) throws Exception {
		if(productDAO.getProduct(id)!=null){
			return productDAO.getProduct(id);
		}
		else{throw new NoSuchProductException("Error: Invalid product id");}
	}

	public Product getProduct(String name, String price, String type, String img) throws Exception {
		if(productDAO.getProduct(name, price, type, img)!=null){
			return productDAO.getProduct(name, price, type, img);
		}
		else{throw new NoSuchProductException("Error: fields were wrong, try to switch them");}
	}

	public ArrayList<Product> getAllProducts() throws Exception {
		return productDAO.getAllProducts();
	}

	public ArrayList<Product> getAllProductsByName(String name) throws Exception {
		return productDAO.getAllProductsByName(name);
	}
	//Admin ACTIONS
	public int updateProduct(Product OLDproduct, Product NEWproduct) throws Exception {
		
		boolean productUP = false;
		if(OLDproduct.getName()!=null && OLDproduct.getName().length()>4 && OLDproduct.getPrice()!=null && OLDproduct.getPrice().length()>0 &&
		   OLDproduct.getType() !=null && OLDproduct.getType().length()>3 && OLDproduct.getImg()!=null && OLDproduct.getImg().length()>3 &&
		   NEWproduct.getName()!=null && NEWproduct.getName().length()>4 && NEWproduct.getPrice()!=null && NEWproduct.getPrice().length()>0 && 
		   NEWproduct.getType() !=null && NEWproduct.getType().length()>3 && NEWproduct.getImg()!=null && NEWproduct.getImg().length()>3){
			try{
				for(Product x : productDAO.getAllProducts()){
					if(x.getName().equals(OLDproduct.getName())&&x.getPrice().equals(OLDproduct.getPrice())&&
							x.getType().equals(OLDproduct.getType())&&x.getImg().equals(OLDproduct.getImg())) {
						productUP=true;
						break;
					}
				}
			}catch(Exception e){e.getStackTrace();}
		}else{
			throw new NoSuchProductException("Error: Not Valid Fields");
		}
		if(productUP==true&&
		   OLDproduct.getName()!=null && OLDproduct.getName().length()>4 && OLDproduct.getPrice()!=null && OLDproduct.getPrice().length()>0 &&
		   OLDproduct.getType() !=null && OLDproduct.getType().length()>3 && OLDproduct.getImg()!=null && OLDproduct.getImg().length()>3 &&
		   NEWproduct.getName()!=null && NEWproduct.getName().length()>4 && NEWproduct.getPrice()!=null && NEWproduct.getPrice().length()>0 && 
		   NEWproduct.getType() !=null && NEWproduct.getType().length()>3 && NEWproduct.getImg()!=null && NEWproduct.getImg().length()>3){
			try {
				if(productDAO.getAllProducts().contains(NEWproduct)) throw new NoSuchProductException("Error: new product has already register");
				return productDAO.updateProduct(productDAO.getProduct(OLDproduct.getName(), OLDproduct.getPrice(), OLDproduct.getType(), OLDproduct.getImg()), NEWproduct);
			} catch (Exception e) {
				throw new NoSuchProductException("Error: Problems with DB");
			}
		}
		else{
			throw new NoSuchProductException("Error: old products didn't register or new product is invalid");
		}	
	}

	public boolean deleteProduct(Product product) throws Exception {
		boolean productUP = false;
	    if(product.getName()!=null && product.getName().length()>4 && product.getPrice()!=null && product.getPrice().length()>0 &&
			   product.getType() !=null && product.getType().length()>3 && product.getImg()!=null && product.getImg().length()>3){
				try{
					for(Product x : productDAO.getAllProducts()){
						if(x.getName().equals(product.getName()) && x.getPrice().equals(product.getPrice())&&
						   x.getType().equals(product.getType()) && x.getImg().equals(product.getImg())) {
							productUP=true;
							break;
						}
					}
				}
				catch(Exception e){
					e.getStackTrace();
		 		}
	    }else{
		   throw new NoSuchProductException("Error: Not Valid Fields");
	    }
	    if(productUP==true && 
	       product.getName()!=null && product.getName().length()>4 && product.getPrice()!=null && product.getPrice().length()>0 &&
	       product.getType() !=null && product.getType().length()>3 && product.getImg()!=null && product.getImg().length()>3){
		   
		    try {
		    	return productDAO.deleteProduct(productDAO.getProduct(product.getName(), product.getPrice(), product.getType(), product.getImg()));
		    } catch (Exception e) {
		 		throw new NoSuchProductException("Error: Some Problems with DB");
		    }
		    
	    }
	    else{
	 		throw new NoSuchProductException("Error: Product Delete");
	    }
	}

	public boolean createProduct(String nameProd, String price, String type, String img) throws NoSuchProductException {
		boolean productUP = false;
		if(nameProd!=null && nameProd.length()>4 && price!=null && price.length()>0 &&
		   type !=null && type.length()>3 && img!=null && img.length()>3){
			try{
				for(Product x : productDAO.getAllProducts()){
					if(x.getName().equals(nameProd) && x.getPrice().equals(price)&&
					   x.getType().equals(type) && x.getImg().equals(img)) {
						productUP=true;
						break;
					}
				}
			}catch(Exception e){e.getStackTrace();}
		}
		else{
			throw new NoSuchProductException("Error: Not Valid Fields");		
		}
		if(productUP==false && 
		   nameProd!=null && nameProd.length()>4 && price!=null && price.length()>0 &&
		   type !=null && type.length()>3 && img!=null && img.length()>3){ 
			return productDAO.createProduct(nameProd,price,type,img);
		}
		else{
			throw new NoSuchProductException("Error: Product has already registered");
		}
	}
	
	//Basket ACTION
	public boolean AddToBasket(int userID, int productID) throws Exception{
		
		int count = 0; 
		try {
			for(Product x : productDAO.getAllProducts()){
				
				if (x.getId()==productID){
					count++;
					break;
				}
				
			}
		} 
		catch (Exception e) {
			throw new NoSuchProductException("We are trying to repair your basket");
		}
		
		if(count !=0){
			return productDAO.AddToBasket(userID, productID);
		}
		else{throw new NoSuchProductException("Error: That product did not find");}
		
	}

	public ArrayList<Product> getFromBasket(int id) {
		return productDAO.getFromBasket(id);
	}

	public boolean RemoveFromBasket(int userID, int prodID) throws Exception{
		boolean prodUP = false;
 		try {
 			for(Product x : productDAO.getAllProducts()){
 				
 				if (x.getId()==prodID){
					prodUP = true;
 					break;
 				}
 				
 			}
 		} catch (Exception e) {
			throw new NoSuchProductException("We are trying to repair your basket");
 		}
		if(prodUP=true){
 			return productDAO.RemoveFromBasket(userID, prodID);
 		}
		else{throw new NoSuchProductException("Error: That product did not find");}

	}

}
