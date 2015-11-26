/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tandemplatform;
import java.awt.List;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.ArrayList;

/**
 *
 * @author gshimabuko
 */
public class SqlComms 
{
    static final String DATABASE_URL = "jdbc:mysql://localhost/tandem";
    
    Connection connection = null;
    Statement statement = null;
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
        ResultSet resultSet = null;
        int result = 0;
        PreparedStatement insertUser = null;
        
        User results = new User();
        query = "INSERT INTO Users ( Name, Surname, username, password, Birthdate, Occupation, email, "
                + "CountryOfOrigin, CountryOfResidence, Status) VALUES (?,?,?,?,?,?,?,?,?,?);";
        
        
        
        
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
            
            query = "SELECT idUser FROM Users WHERE username = ?";
//            String langQuery = "" +user.getNativeLanguage();
            insertUser = null;
            insertUser = connection.prepareStatement(query);
            insertUser.setString(1, user.getUsername());
            resultSet = insertUser.executeQuery();
            if(resultSet.next())
            {
                user.setidUser(resultSet.getInt("idUser"));
                System.out.println("UserID:" + user.getidUser());
                insertNativeLanguage(user);
            }
            
        }
        catch(SQLException sqlException)
        {
            sqlException.printStackTrace();
        }
           
        
    }
    public void insertNativeLanguage(User user)
    {
        PreparedStatement insertNativeLanguage = null;
        int result = 0;
        String userID = null;
        String nativeLanguage;
        try
        {
            
            query = "INSERT INTO Users_has_Languages (Users_idUser, Languages_idLanguages,"
                    + " Fluency, hasInterest, Native) VALUES (?,?,?,?,?);";
            
            userID = "" + user.getidUser();
            nativeLanguage = "" + user.getNativeLanguage();
            
            insertNativeLanguage = connection.prepareStatement(query);
            insertNativeLanguage.setString(1, userID);
            insertNativeLanguage.setString(2, nativeLanguage);
            insertNativeLanguage.setString(3, "5");
            insertNativeLanguage.setString(4, "0");
            insertNativeLanguage.setString(5, "1");
            result = insertNativeLanguage.executeUpdate();
        }
        catch(SQLException sqlException)
        {
            sqlException.printStackTrace();
        }
    }
    public void insertLanguage(User user, int Language, int Fluency, int hasInterest)
    {
        PreparedStatement insertLanguage = null;
        int result = 0;
        String userID = null;
        String Lang = ""+ Language;
        String Fluenc = "" + Fluency;
        String Interest = "" + hasInterest;
        user.setidUser(searchUserID(user.getUsername()));
        
        try
        {
            
            query = "INSERT INTO Users_has_Languages (Users_idUser, Languages_idLanguages,"
                    + " Fluency, hasInterest, Native) VALUES (?,?,?,?,?);";
            
            userID = "" + user.getidUser();
            insertLanguage = connection.prepareStatement(query);
            insertLanguage.setString(1, userID);
            insertLanguage.setString(2, Lang);
            insertLanguage.setString(3, Fluenc );
            insertLanguage.setString(4, Interest);
            insertLanguage.setString(5, "0");
            result = insertLanguage.executeUpdate();
        }
        catch(SQLException sqlException)
        {
            sqlException.printStackTrace();
        }
    }
    public int userExist(String username)
    {
        PreparedStatement searchUser = null;
        ResultSet resultSet = null;
        int result = 0;
        
        query = "SELECT idUser FROM Users WHERE username = ?";
        try
        {
            searchUser = connection.prepareStatement(query);
            searchUser.setString(1, username);
            resultSet = searchUser.executeQuery();
            if (resultSet.next())
            {
                result = 1;
                System.out.println("User Found");
            }
            else
            {
                result = 0;
                System.out.println("User not found");
            }
        }
        catch(SQLException sql)
        {
            sql.printStackTrace();
        }
        return(result);
    }
    public ArrayList searchLanguageUser(int Language, User user, int FluencyMin, int FluencyMax)
    {
        PreparedStatement searchLang = null;
        ResultSet resultSet = null;
        ResultSet resultSet2 = null;
        ResultSet resultSet3 = null;
        int result = 0;
        String langString = ""+Language;
        String userFound = null;
        String FluencyString;
        String userID = ""+searchUserID(user.getUsername());
        ArrayList <User> userList = new ArrayList();
        User listMember = new User();
                
        
        
        query = "SELECT Languages_idLanguages FROM Users_has_Languages WHERE Users_idUser = ? AND Fluency >= 3";
        try
        {
            searchLang = connection.prepareStatement(query);
            searchLang.setString(1, userID);
            resultSet = searchLang.executeQuery();
            
            while(resultSet.next())
            {
            
                query = "SELECT Users_idUser FROM Users_has_Languages WHERE Languages_idLanguages = ? AND hasInterest = 1"; 
                searchLang = connection.prepareStatement(query);
                langString = resultSet.getString("Languages_idLanguages");
                searchLang.setString(1, langString);
                resultSet2 = searchLang.executeQuery();
                while(resultSet2.next())
                {
            
                    query = "SELECT Users_idUser FROM Users_has_Languages WHERE Users_idUser = ? AND"
                            + " Languages_idLanguages = ? AND Fluency >= ? AND "
                            + "Fluency <= ?";
                    searchLang = connection.prepareStatement(query);
                    userFound = resultSet2.getString("Users_idUser");
                    searchLang.setString(1,userFound);
                    langString = ""+Language;
                    searchLang.setString(2,langString);
                    FluencyString = ""+FluencyMin;
                    searchLang.setString(3, FluencyString);
                    FluencyString = ""+FluencyMax;
                    searchLang.setString(4, FluencyString);
                    resultSet3 = searchLang.executeQuery();
                    while(resultSet3.next())
                    {
                        listMember.setidUser(resultSet3.getInt("Users_idUser"));
                        query = "SELECT * FROM Users WHERE idUser = ?";
                        searchLang = connection.prepareStatement(query);
                        searchLang.setString(1, Integer.toString(listMember.getidUser()));
                        ResultSet resultSet4 = searchLang.executeQuery();
                        while(resultSet4.next())
                        {
                            if(resultSet4.getInt("Status")==0)
                            {
                                listMember.setidUser(resultSet4.getInt("idUser"));
                                listMember.setBirthdate(resultSet4.getString("Birthdate"));
                                listMember.setOccupation(resultSet4.getString("Occupation"));
                                listMember.setCOO(resultSet4.getString("CountryOfOrigin"));
                                listMember.setCOR(resultSet4.getString("CountryOfResidence"));
                                query = "SELECT * FROM Users_has_Languages WHERE Users_idUser = ?";
                                PreparedStatement membLang = null;
                                membLang = connection.prepareStatement(query);
                                membLang.setString(1, Integer.toString(listMember.getidUser()));
                                ResultSet resultSet5 = membLang.executeQuery();
                                while(resultSet5.next())
                                {
                                    listMember.setNewLanguage(resultSet5.getInt("Languages_idLanguages"), resultSet5.getInt("Fluency"),resultSet5.getInt("hasInterest"), resultSet5.getInt("Native"));
                                }
                                userList.add(listMember);
                            }
                            
                        }
                        
                        System.out.println(resultSet3.getString("Users_idUser"));
                    }
                }
                            
            }
        }
        catch(SQLException sql)
        {
            sql.printStackTrace();
        }
        return(userList);
    }
    public int searchUserID(String username)
    {
        PreparedStatement searchUser = null;
        ResultSet resultSet = null;
        int result = 0;
        User user = null;
        
        query = "SELECT idUser FROM Users WHERE username = ?";
        try
        {
            searchUser = connection.prepareStatement(query);
            searchUser.setString(1, username);
            resultSet = searchUser.executeQuery();
            if (resultSet.next())
            {
                result = resultSet.getInt("idUser");
                System.out.println("User Found");
            }
            else
            {
                result = 0;
                System.out.println("User not found");
            }
        }
        catch(SQLException sql)
        {
            sql.printStackTrace();
        }
        return(result);
    }
    public int login (String username, String Password)
    {
        PreparedStatement loginStatement = null;
        query = "SELECT password FROM Users WHERE username = ?";
        int valida = 2;
        ResultSet loginResult = null;
        System.out.println("Trying login!");
        try
        {
            loginStatement = connection.prepareStatement(query);
            loginStatement.setString(1, username);
            loginResult = loginStatement.executeQuery();
            System.out.println("Query executada!");
            while(loginResult.next())
            {
                System.out.println("teste do if");
                String Pass = loginResult.getString("password");
                System.out.println("Password" + Pass);
                if (Password.equals(Pass))
                {
                    valida = 1;
                }
                else
                {
                    valida = 0;
                }
            }
        }
        catch(SQLException sqlExc)
        {
            sqlExc.printStackTrace();
        }
        return(valida);
                    
    }
              
}
