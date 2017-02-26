package prashanti.jdbc.practise;

import java.sql.*;

public class JDBCDemo {
	
	Connection con=null;
	public static final String CREATE_TABLE="Create table employee(firstname character varying (40) NOT NULL,lastname character varying(40) NOT NULL,empid character varying (40) NOT NULL,emailid character varying (40) NOT NULL)";
	public static final String INSERT_EMPLOYEE="INSERT INTO employee(firstname,lastname,empid,emailid) values(?,?,?,?)";
	public static final String SELECT_EMP_INFO="select firstname,lastname from employee where empid=?";
	public static final String UPDATE_EMAIL="UPDATE employee set email=? where empid=? ";
	
	
	private void getConnection()
	{
	try{
		System.out.println("Before postgres1 driver registered");
		Class.forName("org.postgresql.Driver");
		System.out.println("Postgres driver is registered");
		con=DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/prashanti", "postgres","Paddu@2016");
	
	}
	catch(ClassNotFoundException e)
	{
		e.printStackTrace();
	}
	catch(SQLException e)
	{
		e.printStackTrace();
	}
	}
	
	
	public boolean createemployee()
	{
		boolean result=false;
		Statement stmt=null;
		Statement stmt2=null;
		boolean isTableExists=false;
		try
		{
			getConnection();
			stmt2=con.createStatement();
			stmt=con.createStatement();
			ResultSet rs= stmt2.executeQuery("SELECT EXISTS (SELECT 1 FROM pg_tables WHERE schema='public' AND tablename='employee')");
			while(rs.next())
			{
				isTableExists=rs.getBoolean(1);
			}
			if(!isTableExists)
			{
				result=stmt.execute(CREATE_TABLE);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try{
				stmt.close();
			}catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		return result;
	}
	
	public int saveEmployeeDetails(EmpInfo empinfo){
		int result=0;
		PreparedStatement ps=null;
		try{
			getConnection();
			ps=con.prepareStatement("INSERT_EMPLOYEE");
			ps.setString(1, empinfo.getFirstname());
			ps.setString(2, empinfo.getLastname());
			ps.setString(3, empinfo.getEmpid());
			ps.setString(4, empinfo.getEmailid());
			result=ps.executeUpdate();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try{
				ps.close();
			}catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		return result;
	}
	
	
	public void updateEmail(String emailid, String empid)
	{
		PreparedStatement ps=null;
		try
		{
			getConnection();
			con.prepareStatement(UPDATE_EMAIL);
			ps.setString(1, emailid);
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	

	public static void main(String[] args) {
		EmpInfo info=new EmpInfo();
		info.setFirstname("prashanti");
		info.setLastname("juluru");
		info.setEmpid("100");
		info.setEmailid("shanti@gmail.com");
		
		JDBCDemo demo=new JDBCDemo();
		demo.getConnection();
		demo.createemployee();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		// TODO Auto-generated method stub

	}

}
