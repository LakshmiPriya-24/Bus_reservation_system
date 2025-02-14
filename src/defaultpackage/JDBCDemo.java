package defaultpackage;
import java.sql.*;

public class JDBCDemo {
	public static void main(String[] args) throws Exception {
		callable2();
	}
	public static void readRecords() throws Exception{
		String url ="jdbc:mysql://localhost:3306/jdbcdemo";
		String username = "root";
		String query = "select * from employee";
		String password = "Lachu@mysql25";
		Connection con = DriverManager.getConnection(url,username,password);
		Statement st  = con.createStatement();
		ResultSet rs = st.executeQuery(query);
		while(rs.next()) {
		System.out.println("id is" + rs.getInt(1));
		System.out.println("Name is" + rs.getString(2));
		System.out.println("Salary is" + rs.getInt(3));
		}
		con.close(); 
	}
	public static void insertRecord() throws Exception{
		String url ="jdbc:mysql://localhost:3306/jdbcdemo";
		String username = "root";
		String query = "insert into employee values(4,'priya',563836)";
		String password = "Lachu@mysql25";
		Connection con = DriverManager.getConnection(url,username,password);
		Statement st  = con.createStatement();
		int rows = st.executeUpdate(query);
		System.out.println(rows);

		con.close(); 
	}
	public static void insertRwithout() throws Exception{
		String url ="jdbc:mysql://localhost:3306/jdbcdemo";
		String username = "root";
		String password = "Lachu@mysql25";
		
		int id =6;
		String name = "Varsh";
		int salary = 847245;
		
		String query = "insert into employee values("+id+",'"+name+"',"+salary+");";

		
		Connection con = DriverManager.getConnection(url,username,password);
		Statement st  = con.createStatement();
		int rows = st.executeUpdate(query);
		System.out.println(rows);

		con.close(); 
	}
	public static void insertwithpst() throws Exception{
		String url ="jdbc:mysql://localhost:3306/jdbcdemo";
		String username = "root";
		String password = "Lachu@mysql25";
		
		int id =6;
		String name = "Varuh";
		int salary = 847248;
		
		String query = "insert into employee values(?,?,?);";

		
		Connection con = DriverManager.getConnection(url,username,password);
		PreparedStatement pst = con.prepareStatement(query);
		pst.setInt(1, id);
		pst.setString(2, name);
		pst.setInt(3, salary);
		int rows = pst.executeUpdate();
		
		//Statement st  = con.createStatement();
		//int rows = st.executeUpdate(query);
		System.out.println(rows);

		con.close(); 
	}
	public static void delete() throws Exception{
		String url ="jdbc:mysql://localhost:3306/jdbcdemo";
		String username = "root";
		String password = "Lachu@mysql25";
		
		int id =5;

		
		String query = "delete from employee where emp_id = " + id;

		
		Connection con = DriverManager.getConnection(url,username,password);
		Statement st  = con.createStatement();
		int rows = st.executeUpdate(query);
		System.out.println(rows);

		con.close(); 
	}
	public static void update() throws Exception{
		String url ="jdbc:mysql://localhost:3306/jdbcdemo";
		String username = "root";
		String password = "Lachu@mysql25";
		
		String query = "update employee set salary = 298863476 where emp_id=1";

		
		Connection con = DriverManager.getConnection(url,username,password);
		Statement st  = con.createStatement();
		int rows = st.executeUpdate(query);
		System.out.println(rows);

		con.close(); 
	}
	public static void callable() throws Exception{
		String url ="jdbc:mysql://localhost:3306/jdbcdemo";
		String username = "root";
		String password = "Lachu@mysql25";
		
		Connection con = DriverManager.getConnection(url,username,password);
		CallableStatement cst = con.prepareCall("{call GetEmp()}");
		ResultSet rs = cst.executeQuery();
		while(rs.next()) {
			System.out.println("id is" + rs.getInt(1));
			System.out.println("Name is" + rs.getString(2));
			System.out.println("Salary is" + rs.getInt(3));
			}
		con.close(); 
	}
	public static void callable2() throws Exception{
		String url ="jdbc:mysql://localhost:3306/jdbcdemo";
		String username = "root";
		String password = "Lachu@mysql25";
		int id =3;
		Connection con = DriverManager.getConnection(url,username,password);
		CallableStatement cst = con.prepareCall("{call GetEmpById(?)}");
		cst.setInt(1, id);
		ResultSet rs = cst.executeQuery();
		while(rs.next()) {
			System.out.println("id is" + rs.getInt(1));
			System.out.println("Name is" + rs.getString(2));
			System.out.println("Salary is" + rs.getInt(3));
			}
		con.close(); 
	}
	
}
