package minorProject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {
	public boolean isValidMobileNo(String str) {
		Pattern ptrn = Pattern.compile("(0/91)?[6-9][0-9]{9}");
		Matcher match = ptrn.matcher(str);
		return (match.find() && match.group().equals(str));
	}

	public boolean isValidName(String name) {

		String regex = "^[\\p{L} .'-]+$"; 
		Pattern p = Pattern.compile(regex);
		if (name == null) {
			return false;
		}
		Matcher m = p.matcher(name);
		return m.matches();
	}

	public boolean isInt(String a) {
		try {
			Integer.parseInt(a);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	public boolean isValidUser(String username, String password) {
		String name = null;
		String pwd = null;
		try {
			DBConnection dbconn = new DBConnection();
			Connection con = dbconn.dbConnect();

			PreparedStatement ps = con.prepareStatement("select name, password from registrationdata where name =?");
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				name = rs.getString(1);
				pwd = rs.getString(2);
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return (username.equals(name) && password.equals(pwd));

	}
	
	public boolean isValidSupplier(String supplier_id, String agency_name) {
		String sid = null;
		String agency = null;
		try {
			DBConnection dbconn = new DBConnection();
			Connection con = dbconn.dbConnect();

			PreparedStatement ps = con.prepareStatement("select supplier_id, agency from supplier_details where supplier_id =?");
			ps.setString(1, supplier_id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				sid = rs.getString(1);
				agency = rs.getString(2);
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return (supplier_id.equals(sid)&&agency_name.equals(agency));
	}

}
