import java.sql.Connection;
import java.sql.DriverManager;

public class JDBCCon {
	public static Connection  getJDBCCon() {
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection("jdbc:mysql://localhost/qlbanhang?" + "user=root");
			
			return DriverManager.getConnection("jdbc:mysql://localhost/qlbanhang?" + "user=root");
			
			
			
		} catch (Exception e){
			
			e.printStackTrace();
		}

	
		
		return null;
		
	}

	public static void main(String[] args) {
		Connection conn= getJDBCCon();
		if (conn != null)
				System.out.println("Ket noi thanh cong");
		else System.out.println("Loi ket noi");
		
		

	}

}
