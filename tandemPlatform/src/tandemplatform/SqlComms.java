/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tandemplatform;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.DateFormat;
/**
 *
 * @author gshimabuko
 */
public class SqlComms 
{
    static final String DATABASE_URL = "jdbc:mysql://localhost/tandem";
    
    Connection connection = null;
    Statement statement = null;
    ResultSet resultSet = null;
    String root = "tandem";
    String dbPassword = "tandem";
    String query = null;
    
    public SqlComms()
    {
        try
        {
           connection = DriverManager.getConnection(DATABASE_URL, root, dbPassword);
        }
        catch(SQLException sqlException)
        {
            sqlException.printStackTrace();
        }
    }
    public void createUser(User user)            
    {   
        int result = 0;
        PreparedStatement insertUser = null;
        query = "INSERT INTO Users ( Name, Surname, username, password, Birthdate, Occupation, email, "
                + "CountryOfOrigin, CountryOfResidence, Status) VALUES (?,?,?,?,?,?,?,?,?,?);";
        
        /*
        query = "INSERT INTO Users ( Name, Surname, username, password, Birthdate, Occupation, email, "
                + "CountryOfOrigin, CountryOfResidence, Status) VALUES ('"+ user.getName();
                
        query = query + "', '" + user.getSurname() +"', '" + user.getUsername() + "', '" + user.getPassword() + "', '";
        query = query + user.getBirthdate() + "', '" + user.getOccupation() + "', '" + user.getEmail()
                + "', '" + user.getCOO()+"', '";
        query = query + user.getCOR() + "', 0);";
        */
        
        
        System.out.println("Query: " + query);
        try
        {
            insertUser = connection.prepareStatement(query);
            insertUser.setString(1, user.getName());
            insertUser.setString(2, user.getSurname());
            insertUser.setString(3, user.getUsername());
            insertUser.setString(4, user.getPassword());
            insertUser.setString(5, user.getBirthdate());
            insertUser.setString(6, user.getOccupation());
            insertUser.setString(7, user.getEmail());
            insertUser.setString(8, user.getCOO());
            insertUser.setString(9, user.getCOR());
            insertUser.setString(10, "0");
            result = insertUser.executeUpdate();
        }
        catch(SQLException sqlException)
        {
            sqlException.printStackTrace();
        }
        
    }
}
