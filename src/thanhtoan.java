import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
public class thanhtoan {
	
	public static  int laygia(int msp) {

		
		Connection con = JDBCCon.getJDBCCon();	
			try {
				CallableStatement cStmt = con.prepareCall("{call spTim(?)}");
				cStmt.setInt(1,msp);
				ResultSet rs = cStmt.executeQuery();
				while(rs.next()) {
					int t = rs.getInt("gia");
				return t;
				}
							
		}
			 catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			return 0;

}
	public static  int laySL(int msp) {

		
		Connection con = JDBCCon.getJDBCCon();	
			try {
				CallableStatement cStmt = con.prepareCall("{call spTim(?)}");
				cStmt.setInt(1,msp);
				ResultSet rs = cStmt.executeQuery();
				while(rs.next()) {
					int t = rs.getInt("soluong");
				return t;
				}
							
		}
			 catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			return 0;

}
	
	public static void them(String sp, int tien) {

		Connection con = JDBCCon.getJDBCCon();
		
		try {
			CallableStatement cStmt = con.prepareCall("{call ThemThanhToan(?,?)}");
    
		    cStmt.setString(1,sp);
			cStmt.setInt(2,tien);
		    cStmt.executeQuery();
			
			//int t = ps.executeUpdate();
			//if ( t != 0)
				//System.out.println("Cap nhat thanh cong");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	public static void tinhtien() {
		System.out.println("Nhap so mat hang can thanh toan");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int[] msp = new int [n];
		int[] b = new int [n];
		int[] gia = new int [n];
		int[] laysl = new int [n];
		for(int i=0 ; i<n ; i++) {
			System.out.println("Nhap msp thu: "+ (i+1));
			msp[i]= sc.nextInt();
			gia[i]= laygia(msp[i]);
			laysl[i]= laySL(msp[i]);
			System.out.println("Nhap so luong thu: "+ (i+1));
			b[i]= sc.nextInt();
			
		}
		int t =0;
		String sp= " ";
		
		System.out.println("|-------|-------------|-----------|");
		String header = String.format("|%-6s |   %-10s|%-10s |","Ma sp"," Gia","So luong");
		System.out.println(header);
		System.out.println("|-------|-------------|-----------|");
		for(int i =0; i<n ;i ++) {
			t =t + gia[i]*b[i];
			String body = String.format("|%-6d |   %-10d|%-10d |",msp[i],gia[i],b[i]);
			System.out.println(body);
			insanpham.capnhatSL(laysl[i],b[i],msp[i]);
			sp = sp +"(" + msp[i] + " " + b[i] + ")" +" ";
		}
		System.out.println("|-------|-------------|-----------|");
		System.out.println("|Thanh tien "+ t);
		System.out.println("|-------|-------------|-----------|");
		them(sp,t);
		
		
		
	}
	public static int tinhtong(String day) {


		
		Connection con = JDBCCon.getJDBCCon();	
			try {
				CallableStatement cStmt = con.prepareCall("{call tinhtong1(?)}");
				cStmt.setString(1,day);
				ResultSet rs = cStmt.executeQuery();
				while(rs.next()) {
					int t = rs.getInt("sum(tongtien)");
					return t;
				
				}
							
		}
			 catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			return 0;
	}
	public static int tinhtong2(String day1, String day2) {



		
		Connection con = JDBCCon.getJDBCCon();	
			try {
				CallableStatement cStmt = con.prepareCall("{call tinhtong2(?,?)}");
				cStmt.setString(1,day1);
				cStmt.setString(2,day2);
				ResultSet rs = cStmt.executeQuery();
				while(rs.next()) {
					int t = rs.getInt("sum(tongtien)");
					return t;
				
				}
							
		}
			 catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			return 0;
	
	}
	public static void main(String[] args) {
    int t = tinhtong("2022-03-18");
    System.out.println(t);
		
		
	}
}
