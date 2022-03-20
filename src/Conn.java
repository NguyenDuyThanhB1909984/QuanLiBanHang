import java.sql.Connection;
import java.sql.DriverManager;

public class Conn {
	
	
	public static void hien() {
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection("jdbc:mysql://localhost/phonebook?" + "user=root");
			
			System.out.println("Noi ket thanh cong");
			
			
			
			
		} catch (Exception e){
			System.out.println("Ket noi bi loi");
			e.printStackTrace();
		}

	}
	public static void main(String[] args) {
		hien();
	}
	
}

