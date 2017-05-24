package ua.shop.vitaly.models.product.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mysql.jdbc.Statement;

import ua.shop.vitaly.models.product.NoSuchProductException;
import ua.shop.vitaly.models.product.Product;

@Repository
public class JDBCProductDAO implements IProductDAO{

    private static final String GET_PRODUCT = "SELECT * FROM PRODUCTS WHERE name = ? AND price = ? AND type =? AND img = ?";
    private static final String GET_ALL_PRODUCTS = "SELECT * FROM PRODUCTS";
    private static final String CREATE_PRODUCT = "INSERT INTO PRODUCTS (name, price,type,img) values (? , ?, ?, ?)";
    private static final String DELETE = "DELETE FROM PRODUCTS WHERE id = ?";
    private static final String UPDATE = "UPDATE PRODUCTS SET name = ?, price = ?, type = ?, img = ? WHERE id = ?";
    private static final String SELECT_PRODUCT = "SELECT * FROM PRODUCTS WHERE id = ?";
    private static final String ADD_TO_BASKET = "INSERT INTO BASKET(id_user,id_product) values (?, ?)";
    private static final String REMOVE_FROM_BASKET ="DELETE FROM BASKET WHERE id_user = ? and id =?";
    
    @Autowired
    private DataSource dataSource;
    
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    
    @Override
	public Product getProduct(int id) throws Exception {
    	Connection conn = null;
    	PreparedStatement pStat = null;
    	ResultSet resultSet = null;
		
		try{
			conn = dataSource.getConnection();
			pStat = (PreparedStatement) conn.prepareStatement(SELECT_PRODUCT);
            pStat.setInt(1, id);
			resultSet = pStat.executeQuery();
			
			boolean hasProduct = resultSet.next();
			if(!hasProduct) throw new NoSuchProductException("Product not found!");
			return new Product(resultSet.getInt("id"),
					resultSet.getString("name"),
					resultSet.getString("price"),
					resultSet.getString("type"),
					resultSet.getString("img"));
		
		}catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
        	if(resultSet!=null){
				try{
					resultSet.close();
				}catch(SQLException ignored){}
			}
        	if(pStat!=null){
				try{
					pStat.close();
				}catch(SQLException ignored){}
			}
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ignored) {}
            }
        }
	}


	@Override
	public Product getProduct(String name, String price, String type, String img) throws Exception {
		Connection conn = null;
		PreparedStatement pStat = null;
		ResultSet resultSet = null;
		
		try{
			conn = dataSource.getConnection();
			pStat = conn.prepareStatement(GET_PRODUCT);
	        pStat.setString(1, name);
	        pStat.setString(2, price);
	        pStat.setString(3, type);
	        pStat.setString(4, img);
	        resultSet = pStat.executeQuery();
			
			boolean hasProduct = resultSet.next();
			if(!hasProduct) throw new NoSuchProductException("Product not found!");
			return new Product(resultSet.getInt("id"),
					resultSet.getString("name"),
					resultSet.getString("price"),
					resultSet.getString("type"),
					resultSet.getString("img"));
		}catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
        	if(resultSet!=null){
				try{
					resultSet.close();
				}catch(SQLException ignored){}
			}
        	if(pStat !=null){
        		try{
        			pStat.close();
        		}catch(SQLException igonored){}
        	}
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ignored) {}
            }
        }
	}

	@Override
	public ArrayList<Product> getAllProducts() throws Exception {
		Connection conn = null;
		Statement statement = null;
		ResultSet resultSet = null;
		ArrayList<Product> AllProducts = new ArrayList<>();
		
		try{
			conn = dataSource.getConnection();
			statement = (Statement) conn.createStatement();
			resultSet = statement.executeQuery(GET_ALL_PRODUCTS);
			while(resultSet.next()){
				Product product = new Product(resultSet.getInt("id"),
						resultSet.getString("name"),
						resultSet.getString("price"),
						resultSet.getString("type"),
						resultSet.getString("img"));
				AllProducts.add(product);
			}
			
			return AllProducts;
		}
		catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
        	if(resultSet!=null){
				try{
					resultSet.close();
				}catch(SQLException ignored){}
			}
        	if(statement!=null){
				try{
					statement.close();
				}catch(SQLException ignored){}
			}
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ignored) {}
            }
        }		
	}

	@Override
	public int updateProduct(Product OLDproduct, Product NEWproduct) throws Exception {
		 if (OLDproduct == null || NEWproduct == null )
	            throw new IllegalArgumentException("Object is null");
	     else if (OLDproduct.getId() == 0)
	            throw new IllegalArgumentException("Contact doesn't have id");
		 
		 Connection conn = null;
		 PreparedStatement pStat = null;
	        
		 try {
				conn = dataSource.getConnection();
	            pStat = conn.prepareStatement(UPDATE);
	            pStat.setString(1, NEWproduct.getName());
	            pStat.setString(2, NEWproduct.getPrice());
	            pStat.setString(3, NEWproduct.getType());
	            pStat.setString(4, NEWproduct.getImg());
	            pStat.setInt(5, OLDproduct.getId());
	            return pStat.executeUpdate();
	        } finally {
	        	if(pStat !=null){
	        		try{
	        			pStat.close();
	        		}catch(SQLException igonored){}
	        	}
	            if (conn != null) {
	                try {
	                    conn.close();
	                } catch (SQLException ignored) {}
	            }
	        }	}

	@Override
	public boolean deleteProduct(Product product) throws Exception {
		if (product == null)
            throw new IllegalArgumentException("Object is null");
        else if (product.getId() == 0)
            throw new IllegalArgumentException("Product doesn't have id or id is invalid");

        Connection conn = null;
        PreparedStatement pStat = null;
        try {
			conn = dataSource.getConnection();
            pStat = conn.prepareStatement(DELETE);
            pStat.setInt(1, product.getId());

            return pStat.executeUpdate() > 0;
        } finally {
        	if(pStat !=null){
        		try{
        			pStat.close();
        		}catch(SQLException igonored){}
        	}
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ignored) {}
            }
        }
	}

	@Override
	public boolean createProduct(String name, String price, String type, String img) {
		Connection conn = null;
		PreparedStatement pStat = null;
		
		try{
			conn = dataSource.getConnection();
			pStat = (PreparedStatement) conn.prepareStatement(CREATE_PRODUCT); 
			pStat.setString(1, name);
			pStat.setString(2, price);
			pStat.setString(3, type);
			pStat.setString(4, img);
			pStat.executeUpdate();
			return true;
		}
		catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
        	if(pStat !=null){
        		try{
        			pStat.close();
        		}catch(SQLException igonored){}
        	}
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ignored) {}
            }
        }
	}

	@Override
	public boolean AddToBasket(int userID, int productID) {
		Connection conn = null;
		PreparedStatement pStat = null;
		
		try{
			conn = dataSource.getConnection();
			pStat = (PreparedStatement) conn.prepareStatement(ADD_TO_BASKET); 
			pStat.setInt(1, userID);
			pStat.setInt(2, productID);
			pStat.executeUpdate();
			return true;
		}
		catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
        	if(pStat !=null){
        		try{
        			pStat.close();
        		}catch(SQLException igonored){}
        	}
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ignored) {}
            }
        }
}

	@Override
	public ArrayList<Product> getFromBasket(int id) {
		Connection conn = null;
		Statement statement = null;
		ResultSet result = null;
		
		ArrayList<Product> AllProducts = new ArrayList<>();
		
		try{
			conn = dataSource.getConnection();
			statement = (Statement) conn.createStatement();
			result = statement.executeQuery("SELECT * FROM basket INNER JOIN products ON products.id = basket.id_product WHERE basket.id_user ="+id);
			while(result.next()){
				Product product = new Product(result.getInt("id"),
						result.getString("name"),
						result.getString("price"),
						result.getString("type"),
						result.getString("img"));
				AllProducts.add(product);
			}
		
			return AllProducts;
		}
		catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
        	if (result != null) {
                try {
                	result.close();
                } catch (SQLException ignored) {}
            }
        	if (statement != null) {
                try {
                	statement.close();
                } catch (SQLException ignored) {}
            }
        	if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ignored) {}
            }
        }				
	}

	@Override
	public boolean RemoveFromBasket(int userID, int productID) {
		Connection conn = null;
		PreparedStatement pStat = null;
        try {
			conn = dataSource.getConnection();
            pStat = conn.prepareStatement(REMOVE_FROM_BASKET);
            pStat.setInt(1, userID);
            pStat.setInt(2, productID);

            return pStat.executeUpdate() > 0;
        } catch(Exception e){
        	e.getStackTrace();
        	return false;}
        finally {
        	if(pStat !=null){
        		try{
        			pStat.close();
        		}catch(SQLException igonored){}
        	}
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ignored) {}
            }
        }
	}


	@Override
	public ArrayList<Product> getAllProductsByName(String name) throws Exception {
		Connection conn = null;
		Statement statement = null;
		ResultSet result = null;
		ArrayList<Product> AllProductsByName = new ArrayList<>();
		
		try{
			conn = dataSource.getConnection();
			statement = (Statement) conn.createStatement();
			result = statement.executeQuery("SELECT * FROM PRODUCTS WHERE NAME =\""+name+"\"");
			while(result.next()){
				Product product = new Product(result.getInt("id"),
						result.getString("name"),
						result.getString("price"),
						result.getString("type"),
						result.getString("img"));
				AllProductsByName.add(product);
			}
		
			return AllProductsByName;
		}
		catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
        	if (result != null) {
                try {
                	result.close();
                } catch (SQLException ignored) {}
            }
        	if (statement != null) {
                try {
                	statement.close();
                } catch (SQLException ignored) {}
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ignored) {}
            }
        }
	}

}
