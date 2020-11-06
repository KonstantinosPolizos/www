import java.sql.*;

public class RegisterDatabase {
	private String dburl = "jdbc:mysql://localhost:3306/dbuser?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=Europe/Moscow";
	private String dbname = "root";
	private String dbpassword = "root";
	private String dbdriver = "com.mysql.jdbc.Driver";
	private String res = "";
	
	public void loadDriver(String dbdriver) {
		try {
			Class.forName(dbdriver);
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public Connection getConnection() {	
		try {
			Connection conn = DriverManager.getConnection(dburl, dbname, dbpassword);
			return conn;
		}
		catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public String insert(Member member) throws ClassNotFoundException {
		String sql = "INSERT INTO dbuser.member" +
				" (barcode, name, color, description)" +
				" VALUES(?, ?, ?, ?);";
		
		res = "Data inserted successfully";
		
		try {
			Class.forName(dbdriver);
			Connection conn = DriverManager.getConnection(dburl, dbname, dbpassword);
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, member.getBarcode());
			ps.setString(2, member.getName());
			ps.setString(3, member.getColor());
			ps.setString(4, member.getDescription());
			ps.executeUpdate();
			conn.close();
		}
		catch(SQLException e) {
			e.printStackTrace();
			res = "Data didn't insert successfully or already exist. Try again";
		}
		
		return res;
	}
}