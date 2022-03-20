import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


public class insanpham {
	public static void insp() {
		Connection con = JDBCCon.getJDBCCon();
	
		try {
			
			CallableStatement cStmt = con.prepareCall("{call spLaySP()}");
			
			ResultSet rs = cStmt.executeQuery();
			System.out.println("|-------|--------------------------------|-------------|-----------|");
			String header = String.format("|%-6s |  %-25s     |   %-10s|%-10s |","Ma sp","Ten san pham"," Gia","So luong");
			System.out.println(header);
			System.out.println("|-------|--------------------------------|-------------|-----------|");
			while(rs.next()) { 
				String body = String.format("|%-6d |  %-25s     |   %-10d|%-10d |",rs.getInt("msp"),rs.getString("tensp"),rs.getInt("gia"),rs.getInt("soluong"));
				System.out.println(body);
				
				
			}
			System.out.println("|-------|--------------------------------|-------------|-----------|");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static void hetsanpham() {

		Connection con = JDBCCon.getJDBCCon();
	
		try {
			
			CallableStatement cStmt = con.prepareCall("{call hetsanpham()}");
			
			ResultSet rs = cStmt.executeQuery();
			System.out.println("|-------|--------------------------------|-------------|-----------|");
			String header = String.format("|%-6s |  %-25s     |   %-10s|%-10s |","Ma sp","Ten san pham"," Gia","So luong");
			System.out.println(header);
			System.out.println("|-------|--------------------------------|-------------|-----------|");
			while(rs.next()) { 
				String body = String.format("|%-6d |  %-25s     |   %-10d|%-10d |",rs.getInt("msp"),rs.getString("tensp"),rs.getInt("gia"),rs.getInt("soluong"));
				System.out.println(body);
				
				
			}
			System.out.println("|-------|--------------------------------|-------------|-----------|");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
	}
	
	public static void them(int msp, String tensp,int gia, int soluong) {
		Connection con = JDBCCon.getJDBCCon();
		
		try {
			CallableStatement cStmt = con.prepareCall("{call spThem(?,?,?,?)}");
			cStmt.setInt(1,msp);
		    
		    cStmt.setString(2, tensp);
		    cStmt.setInt(3, gia);
		    cStmt.setInt(4, soluong);
		    cStmt.executeQuery();
		    System.out.println("Them du lieu thanh cong!");
			
			//int t = ps.executeUpdate();
			//if ( t != 0)
				//System.out.println("Cap nhat thanh cong");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void suaTen(int msp, String tensp) {
		Connection con = JDBCCon.getJDBCCon();
		
		try {
			CallableStatement cStmt = con.prepareCall("{call suaTen(?,?)}");
			cStmt.setInt(2,msp);
		    cStmt.setString(1, tensp);
		    
		    cStmt.executeQuery();
		    System.out.println("Cap nhat thanh cong!");
			
			//int t = ps.executeUpdate();
			//if ( t != 0)
				//System.out.println("Cap nhat thanh cong");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void suaGia(int gia, int msp ) {
		Connection con = JDBCCon.getJDBCCon();
		
		try {
			CallableStatement cStmt = con.prepareCall("{call suaGia(?,?)}");
			cStmt.setInt(1,gia);
		    cStmt.setInt(2, msp);
		    
		    cStmt.executeQuery();
		    System.out.println("Cap nhat thanh cong!");
			
			//int t = ps.executeUpdate();
			//if ( t != 0)
				//System.out.println("Cap nhat thanh cong");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void suaSL(int soluong, int msp ) {
		Connection con = JDBCCon.getJDBCCon();
		
		try {
			CallableStatement cStmt = con.prepareCall("{call suaSL(?,?)}");
			cStmt.setInt(1,soluong);
		    cStmt.setInt(2, msp);
		    
		    cStmt.executeQuery();
		    System.out.println("Cap nhat thanh cong!");
			
			//int t = ps.executeUpdate();
			//if ( t != 0)
				//System.out.println("Cap nhat thanh cong");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void sua(int msp, String tensp,int gia, int soluong) {
		Connection con = JDBCCon.getJDBCCon();
		String sql = "UPDATE sanpham set tensp = ?, gia = ?, soluong = ? WHERE msp = ? ";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, tensp);
			ps.setInt(2, gia);
			ps.setInt(3, soluong);
			ps.setInt(4, msp);
			int t = ps.executeUpdate();
			if ( t != 0)
				System.out.println("Cap nhat thanh cong");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void capnhatSL(int n,int soluong,int msp) {
		Connection con = JDBCCon.getJDBCCon();
		String sql = "UPDATE sanpham set  soluong = ? WHERE msp = ? ";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setInt(1,(n - soluong));
			ps.setInt(2, msp);
			int t = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	public static void timkiem(int msp) {
		Connection con = JDBCCon.getJDBCCon();
		
		try {
			CallableStatement cStmt = con.prepareCall("{call spTim(?)}");
			cStmt.setInt(1,msp);
			ResultSet rs = cStmt.executeQuery();
			String header = String.format("Danh sach sau khi tim msp = %d ",msp);
			System.out.println(header);
			while (rs.next()) {
				
				System.out.println(" Msp: " +rs.getInt("msp") + " Ten sp: " + rs.getString("tensp")+ " Gia: " + rs.getInt("gia") + " So luong: " +rs.getInt("soluong") );
			}
		  
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void delete(int msp) {
		Connection con = JDBCCon.getJDBCCon();
		//sql = DELIMITER $$ CREATE PROCEDURE xoa(IN msp1 int)BEGIN if exists (select msp from sanpham) 
		//then delete from sanpham where msp = msp1;end if;END; $$DELIMITER ;
		try {
			CallableStatement cStmt = con.prepareCall("{call xoa(?)}");
			cStmt.setInt(1,msp);
		    cStmt.executeQuery();
		    System.out.println("Xoa thanh cong");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Xoa loi");
		}	
		
	}
	
	


	public static void main(String[] args) throws SQLException {
		Scanner sc= new Scanner(System.in);
		
		int msp, gia, soluong;
		
		
		String tensp = new String();
		System.out.println("|------------------------------------------------------------------|");
		System.out.println("|                              BANG CHUC NANG                      |" );
		System.out.println("| 1. IN DANH SACH TAT CA SAN PHAM                                  |");
		System.out.println("| 2. THEM SAN PHAM MOI                                             |");
		System.out.println("| 3. THAY DOI  TEN SAN PHAM                                        | ");
		System.out.println("| 4. THAY DOI GIA SAN PHAM                                         |");
		System.out.println("| 5. THAY DOI SO LUONG SAN PHAM                                    |");
		System.out.println("| 6. XOA SAN PHAM                                                  |");
		System.out.println("| 7. IN DANH SACH CAC SAN PHAM CO SO LUONG GAN HET                 |");
		System.out.println("| 8. THANH TOAN                                                    |");
		System.out.println("| 9. TINH DOANH THU CUA 1 NGAY                                     |");
		System.out.println("| 10.TINH DOANH THU NHIEU NGAY                                     |");
		System.out.println("| 11.TIM KIEM SAN PHAM                                             |");
		System.out.println("| 0. DUNG CHUONG TRINH                                             |");
		System.out.println("|------------------------------------------------------------------|");
        
        
        for (;;) {
        	System.out.println("Chon chuc nang can thuc hien:");
          int  n = sc.nextInt();
            sc.nextLine();


        if(n==1) insp();
        else if(n==2) {
		  
			System.out.println("Nhap ma san pham");
			msp = sc.nextInt();
			sc.nextLine();
			System.out.println("Nhap ten san pham");
			tensp = sc.nextLine();
			System.out.println("Nhap gia san pham");
			gia = sc.nextInt();
			System.out.println("Nhap so luong san pham");
			soluong = sc.nextInt();
			them(msp,tensp,gia,soluong);
			}
		
        else if(n == 3) {
			System.out.println("Nhap msp can thay doi");
			msp =sc.nextInt();
			sc.nextLine();
			timkiem(msp);
			System.out.println("Nhap ten moi cho san pham");
			String s = sc.nextLine();
			suaTen(msp,s);	
			System.out.println("Thong tin san pham sau khi cap nhat");
			timkiem(msp);
		}
        else if(n==4) {
			System.out.println("Nhap msp can thay doi");
			msp =sc.nextInt();
			timkiem(msp);
			System.out.println("Nhap gia moi cho san pham");
			int s = sc.nextInt();
			suaGia(s,msp);	
			System.out.println("Thong tin san pham sau khi cap nhat");
			timkiem(msp);
		}
        else if (n == 5 ) {

			System.out.println("Nhap msp can thay doi");
			msp =sc.nextInt();
			timkiem(msp);
			System.out.println("Nhap so luong moi cho san pham");
			int s = sc.nextInt();
			suaSL(s,msp);	
			System.out.println("Thong tin san pham sau khi cap nhat");
			timkiem(msp);
		}
        else if( n == 6) {
			System.out.println("Nhap msp can xoa");
			msp = sc.nextInt();
			delete(msp);		
		}
        else if( n == 7 ) {
			hetsanpham();
		}
        else if( n == 8) {
			thanhtoan.tinhtien();
		}
        else if( n== 9) {
			System.out.println("Nhap ngay can tinh doanh thu YYYY-MM-DD:");
			String day = sc.nextLine();
			int t = thanhtoan.tinhtong(day);
			System.out.println("Doanh thu cua ngay " + day +" "+ t);
		
		}
        else if (n == 10) {
			System.out.println("Nhap ngay bat dau can tinh doanh thu YYYY-MM-DD:");
			String day1 = sc.nextLine();
			System.out.println("Nhap ngay ket thuc can tinh doanh thu YYYY-MM-DD:");
			String day2 = sc.nextLine();
			int t = thanhtoan.tinhtong2(day1, day2);
			System.out.println("Doanh thu tu ngay " + day1 + " " + "den ngay " + day2+" " +t);
		}
        else if(n ==11) {
			System.out.println("Nhap ma san pham can tim");
			msp = sc.nextInt();
			timkiem(msp);
		
        }
        else if (n == 0) break;	
        }
		
	        

		

	}

}
