package a.songs_site;

import java.io.IOException;
import java.sql.*;

public class MysqlCon {
	  
	
	protected static void MysqlCon() throws IOException {
		try
		{
		    Class.forName("com.mysql.cj.jdbc.Driver");
		    Connection con=DriverManager.getConnection(  
		    		"jdbc:mysql://localhost:3306/songs?useLegacyDatetimeCode=false&serverTimezone=UTC","user","cipa");  
		
		    Statement stmt=con.createStatement(); 
		    ResultSet rs=stmt.executeQuery("select * from songs.songs_view");
		    //while(rs.next())  
		    //{System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));} 
		    while (rs.next()){
	    		System.out.println(rs.getInt(1) + " - " +rs.getString(2)+ " - " + rs.getString(3));
	    	}
		    con.close();
			}
		catch(Exception e)
		{ System.out.println(e);}  
		  
	}
}
