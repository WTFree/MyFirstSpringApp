package ua.shop.vitaly.models.product;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="products")
public class Product {
	
	@Id
	@Column(name = "id")
	@GeneratedValue
	private int id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="price")
	private String price;
	
	@Column(name="type")
	private String type;
	
	@Column(name="img")
	private String img;
	
	public Product(){
		
	}
	public Product(String name, String price, String type, String img){
		this.name = name;
		this.price = price;
		this.type = type;
		this.img = img;
	}
	public Product(int id,String name, String price, String type, String img){
		this.id = id;
		this.name = name;
		this.price = price;
		this.type = type;
		this.img = img;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + ", type=" + type + ", img=" + img + "]";
	}
	
}
