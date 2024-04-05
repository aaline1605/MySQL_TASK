package com.jdbc;

//imports suitable packages
import java.sql.Connection;   
import java.sql.DriverManager; 
import java.sql.ResultSet;     
import java.sql.Statement;     

public class Empdatabase { 

    public static void main(String[] args) { 
        
    	// Database URL
        String url="jdbc:mysql://localhost:3306/"; 
        
        // Database username
        String username="root";
        
        // Database password
        String password="Aaline@1605"; 
        
        // Try block
        try { 
            Connection con=DriverManager.getConnection(url,username,password); // Establish connection

            // Check connection success
            if(con !=null) {    
                System.out.println("JDBC Connection Successfull....,"); 
            } else {
                    System.out.println("JDBC Connection Failed....,"); 
                }
            
            Statement st=con.createStatement(); // Create statement
            
            String createDB="create database Employee"; // Create database query
            String useDB="use Employee"; // Use database query
            String createTable="create table emptable(empcode int,empname varchar(50),empage int, esalary int)"; // Create table query
            String select="select*from emptable"; // Select query
            
            String insert= // Insert data query
                    """
                    insert into emptable values 
                     (101,'Jenny',25,10000),
                     (102,'Jacky',30,10000),
                     (103,'Joe',20,10000),
                     (104,'John',40,10000),
                     (105,'Shameer',25,10000);
                    
                    """;
            
              st.execute(createDB);            // Execute create database query
              st.execute(useDB);              // Execute use database query
              st.execute(createTable);       // Execute create table query
              st.execute(insert);           // Execute insert data query
            
            // Execute select query
            ResultSet rs=st.executeQuery(select); 
            
            System.out.println("\n------------------TABLE-DETAILS----------------------");
            
            // Print data
            while(rs.next()) { // Iterate over result set
                System.out.println(rs.getInt("empcode")+"  "+rs.getString("empname")+"  "+rs.getInt("empage")
                +"  "+rs.getInt("esalary")); 
            }
            
            con.close();                  // Close connection
                
            
        }catch (Exception e) { 
            e.printStackTrace(); 
        }
}
    
    
/* OUTPUT
 * 
 * JDBC Connection Successfull....,

------------------TABLE-DETAILS----------------------

101  Jenny   25  10000
102  Jacky   30  10000
103  Joe     20  10000
104  John    40  10000
105  Shameer 25  10000
 * 
 */
 

}
