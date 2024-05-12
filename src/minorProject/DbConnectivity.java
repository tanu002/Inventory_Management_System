package minorProject;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public interface DbConnectivity {
	
	public Connection dbConnect() throws SQLException, ClassNotFoundException;
	public void addRegistrationData();
	public void addProduct();
	public void updateProduct(long pid);
	public void deleteProduct(long pid);
	public ResultSet showProduct(String pname) throws SQLException, ClassNotFoundException;
	public ResultSet showProduct() throws SQLException, ClassNotFoundException;
	public void addCustomer();
	public void updateCustomer(String cid);
	public void deleteCustomer(String cid);
	public ResultSet showCustomer (String cid) throws ClassNotFoundException, SQLException;
	public ResultSet showCustomer() throws ClassNotFoundException, SQLException;
	public void addSupplier ();
	public void updateSupplier(long sid);
	public void deleteSupplier(long sid);
	public ResultSet showSupplier(String sname) throws ClassNotFoundException, SQLException;
	public ResultSet showSupplier() throws ClassNotFoundException, SQLException;
}
