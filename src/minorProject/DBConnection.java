package minorProject;

import java.sql.*;

public class DBConnection implements DbConnectivity {
	
	private String name;
	private String gender;
	private String mobile_no;
	private String email_id;
	private String category;
	private String shop_name;
	private String address;
	private String password;
	
	private long product_id;
	private String product_name;
	private String quantity;
	private String price;
	private String mfgdt;
	private String expdt;
	private String supplier_ID;
	private String supplier_agency;
	
	private long supplier_id;
	private String supplier_Name;
	private String agency;
	private String ph_no;
	private String supplier_address;

	private String customer_id;
	private String customer_name;
	private String phone_no;
	private String amount;
	private String date;
	private String product_Name;

	public void setName(String name) {
		this.name = name;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public void setMobile_no(String mobile_no) {
		this.mobile_no = mobile_no;
	}

	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public void setShop_name(String shop_name) {
		this.shop_name = shop_name;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setProduct_id(long product_id) {
		this.product_id = product_id;
	}
	
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public void setMfgdt(String mfgdt) {
		this.mfgdt = mfgdt;
	}

	public void setExpdt(String expdt) {
		this.expdt = expdt;
	}

	public void setSupplier_ID(String supplier_name) {
		this.supplier_ID = supplier_name;
	}
	
	public void setSupplier_agency(String supplier_agency) {
		this.supplier_agency = supplier_agency;
	}

	public void setSupplier_id(long supplier_id) {
		this.supplier_id = supplier_id;
	}

	public void setSupplier_Name(String supplier_Name) {
		this.supplier_Name = supplier_Name;
	}

	public void setAgency(String agency) {
		this.agency = agency;
	}

	public void setPh_no(String ph_no) {
		this.ph_no = ph_no;
	}

	public void setSupplier_address(String supplier_address) {
		this.supplier_address = supplier_address;
	}
	
	public void setCustomer_id(String customer_id) {
		this.customer_id = customer_id;
	}

	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}

	public void setPhone_no(String phone_no) {
		this.phone_no = phone_no;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public void setProduct_Name(String product_Name) {
		this.product_Name = product_Name;
	}
	
	public void setDate(String date) {
		this.date = date;
	}

@Override
public void addRegistrationData() {

	try {
		Connection conn = dbConnect();
		
		PreparedStatement ps = conn.prepareStatement("insert into registrationdata values(?,?,?,?,?,?,?,?)");
		
		ps.setString(1,name);
		ps.setString(2,gender);
		ps.setString(3,mobile_no);
		ps.setString(4,email_id);
		ps.setString(5,category);
		ps.setString(6,shop_name);
		ps.setString(7,address);
		ps.setString(8,password);
		ps.executeUpdate();
			
		conn.close();
			
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
			
}


@Override
public Connection dbConnect() throws SQLException, ClassNotFoundException {
	Class.forName("com.mysql.cj.jdbc.Driver");
	
	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/usedb","root","database@Msql@124");
	return con;
}

@Override
public void addProduct() {
	
	try {
		
		Connection conn = dbConnect();
		
		PreparedStatement ps = conn.prepareStatement("insert into product_details values(?,?,?,?,?,?,?,?)");
		ps.setLong(1, product_id);
		ps.setString(2, product_name);
		ps.setString(3, quantity);
		ps.setString(4, price);
		ps.setString(5, mfgdt);
		ps.setString(6, expdt);
		ps.setString(7, supplier_ID);
		ps.setString(8, supplier_agency);
		ps.executeUpdate();
		
		conn.close();
		
	} catch (SQLException | ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} 
	
}

@Override
public void updateProduct(long pid) {
	 
	try {
		Connection conn = dbConnect();
		PreparedStatement ps = conn.prepareStatement("update product_details set product_name=?,quantity=?,price=?,manufacturing_date=?,expiry_date=?,supplier_id=?,agency_name=? where product_id = ?");
		
		ps.setString(1, product_name);
		ps.setString(2, quantity);
		ps.setString(3, price);
		ps.setString(4, mfgdt);
		ps.setString(5, expdt);
		ps.setString(6, supplier_ID);
		ps.setString(7, supplier_agency);
		ps.setLong(8, pid);
		
		ps.executeUpdate();
		
		conn.close();
	} catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	
}

public void updateQuantity(long pid) {
	int qt=0;
	try {
		Connection conn = dbConnect();
		PreparedStatement ps = conn.prepareStatement("select quantity from product_details where product_id=?");
		ps.setLong(1, pid);
		ResultSet q = ps.executeQuery();
		while(q.next()) {
			qt = Integer.parseInt(q.getString(1));
		}
		qt-=Integer.parseInt(quantity);
		Statement st = conn.createStatement();
		String sql = "update product_details set quantity = "+qt+" where product_id="+pid+"";
		st.executeUpdate(sql);
		conn.close();
		
		
		conn.close();
	}catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}

public boolean isZero(String pid) {
	int val = 0;
	try {
		Connection conn;
		conn = dbConnect();
		PreparedStatement ps = conn.prepareStatement("select quantity from product_details where product_id=?");
		ps.setLong(1, Integer.parseInt(pid));
		ResultSet q = ps.executeQuery();
		while(q.next()) {
			val = Integer.parseInt(q.getString(1));
		}
		if (val <= 0){
			return true;
		}
		else {
			return false;
		}
	} catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	
	}
	return false;
	
}

@Override
public void deleteProduct(long pid) {
	try {
		Connection conn = dbConnect();
		PreparedStatement ps = conn.prepareStatement("delete from product_details where product_id=?");
		
		ps.setLong(1, pid);
		
		ps.executeUpdate();
		
		conn.close();
		
	} catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
}

@Override
public ResultSet showProduct(String pname) throws SQLException, ClassNotFoundException {
	
		Connection conn = dbConnect();
		PreparedStatement ps = conn.prepareStatement("select * from product_details where product_name=?");
		ps.setString(1, pname);
		
		ResultSet rs = ps.executeQuery();
			
		return rs;
	
	
}

@Override
public ResultSet showProduct() throws SQLException, ClassNotFoundException {
		Connection conn = dbConnect();
		PreparedStatement ps = conn.prepareStatement("select * from product_details");
		
		ResultSet rs = ps.executeQuery();
		
		return rs;
}

@Override
public void addCustomer() {
try {
		
		Connection conn = dbConnect();
		
		Statement st = conn.createStatement();
		String sql = "insert into customer_details set customer_id='"+customer_id+"',customer_name='"+customer_name+"',phone_no='"+phone_no+"',amount='"+amount+"',product_name='"+product_Name+"',date='"+date+"'";
		st.executeUpdate(sql);
		
		conn.close();
		
	} catch (SQLException | ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} 
	
}

@Override
public void updateCustomer(String cid) {
	try {
		Connection conn = dbConnect();
		Statement st = conn.createStatement();
		String sql = "update customer_details set customer_name='"+customer_name+"',phone_no='"+phone_no+"',amount='"+amount+"',product_name='"+product_Name+"',date='"+date+"'";
		st.executeUpdate(sql);
		
		conn.close();
	} catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}

@Override
public void deleteCustomer(String cid) {
	try {
		Connection conn = dbConnect();
		PreparedStatement ps = conn.prepareStatement("delete from customer_details where customer_id=?");
		
		ps.setString(1, cid);
		
		ps.executeUpdate();
		
		conn.close();
		
	} catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}

@Override
public ResultSet showCustomer(String cid) throws SQLException, ClassNotFoundException{
	Connection conn = dbConnect();
	PreparedStatement ps = conn.prepareStatement("select * from customer_details where customer_id=?");
	ps.setString(1, cid);
	
	ResultSet rs = ps.executeQuery();
		
	return rs;
	
}

@Override
public ResultSet showCustomer() throws SQLException, ClassNotFoundException {
	Connection conn = dbConnect();
	PreparedStatement ps = conn.prepareStatement("select * from customer_details");
	
	ResultSet rs = ps.executeQuery();
	
	return rs;
	
}

@Override
public void addSupplier() {
	try {
		
		Connection conn = dbConnect();
		
		PreparedStatement ps = conn.prepareStatement("insert into supplier_details values(?,?,?,?,?)");
		ps.setLong(1, supplier_id);
		ps.setString(2, supplier_Name);
		ps.setString(3, agency);
		ps.setString(4, ph_no);
		ps.setString(5, supplier_address);
		ps.executeUpdate();
		
		conn.close();
		
	} catch (SQLException | ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} 
	
}

@Override
public void updateSupplier(long sid) {
	try {
		Connection conn = dbConnect();
		PreparedStatement ps = conn.prepareStatement("update supplier_details set supplier_name=?,agency=?,phone_no=?,address=? where supplier_id = ?");
		
		ps.setString(1, supplier_Name);
		ps.setString(2, agency);
		ps.setString(3, ph_no);
		ps.setString(4, supplier_address);
		ps.setLong(5, sid);
		
		ps.executeUpdate();
		
		conn.close();
	} catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}

@Override
public void deleteSupplier(long sid) {
	try {
		Connection conn = dbConnect();
		PreparedStatement ps = conn.prepareStatement("delete from supplier_details where supplier_id=?");
		
		ps.setLong(1, sid);
		
		ps.executeUpdate();
		
		conn.close();
		
	} catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}

@Override
public ResultSet showSupplier(String sid) throws ClassNotFoundException, SQLException {
	Connection conn = dbConnect();
	PreparedStatement ps = conn.prepareStatement("select * from supplier_details where supplier_id=?");
	ps.setString(1, sid);
	
	ResultSet rs = ps.executeQuery();
		
	return rs;
	
	
}


@Override
public ResultSet showSupplier() throws ClassNotFoundException, SQLException {
	Connection conn = dbConnect();
	PreparedStatement ps = conn.prepareStatement("select * from supplier_details");
	
	ResultSet rs = ps.executeQuery();
	
	return rs;
	
}

public ResultSet getData(String pid) throws SQLException, ClassNotFoundException {
	Connection conn = dbConnect();
	PreparedStatement ps = conn.prepareStatement("select price from product_details where product_id = ?");
	ps.setString(1, pid);
	ResultSet rs = ps.executeQuery();
	return rs;
}

}
