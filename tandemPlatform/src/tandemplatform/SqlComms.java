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
    public void updateLanguage(User user, int language, int fluency, int hasInterest)
    {
         PreparedStatement insertLanguage = null;
        int result = 0;
        String userID = null;
        String Lang = Integer.toString(language);
        String Fluenc = Integer.toString(fluency);
        String Interest = Integer.toString(hasInterest);
        user.setidUser(searchUserID(user.getUsername()));
        
        try
        {
            
            query = "UPDATE Users_has_Languages SET Fluency = ?, hasInterest = ? WHERE  "
                    + "Users_idUser = ? AND Languages_idLanguages = ?";
            
            
            userID = userID = Integer.toString(user.getidUser());
            insertLanguage = connection.prepareStatement(query);
            insertLanguage.setString(1, Fluenc);
            insertLanguage.setString(2, Interest);
            insertLanguage.setString(3, userID );
            insertLanguage.setString(4, Lang);
            result = insertLanguage.executeUpdate();
        }
        catch(SQLException sqlException)
        {
            sqlException.printStackTrace();
        }
        
    }
    public void updateUser(User user)
    {
        PreparedStatement insertLanguage = null;
        int result = 0;
        String userID = null;
        user.setidUser(searchUserID(user.getUsername()));
        
        try
        {
            
            query = "UPDATE Users SET password = ?, Occupation = ?, email = ?, CountryOfResidence = ? WHERE  "
                    + "idUser = ?";
            
            
            userID = userID = Integer.toString(user.getidUser());
            insertLanguage = connection.prepareStatement(query);
            insertLanguage.setString(1, user.getPassword());
            insertLanguage.setString(2, user.getOccupation());
            insertLanguage.setString(3, user.getEmail() );
            insertLanguage.setString(4, user.getCOR());
            insertLanguage.setString(5, Integer.toString(user.getidUser()));
            result = insertLanguage.executeUpdate();
        }
        catch(SQLException sqlException)
        {
            sqlException.printStackTrace();
        }
    }
    public void busy(User user)
    {
        PreparedStatement logOffStatement = null;
        try
        {
            query = "UPDATE Users SET Status = ? WHERE  "
                    + "username = ?";
                    logOffStatement = connection.prepareStatement(query);
                    logOffStatement.setString(1, "2");
                    logOffStatement.setString(2, user.getUsername());
                    int result = logOffStatement.executeUpdate();
                    System.out.println("Query executada!");
        }
        catch(SQLException sqlException)
        {
            sqlException.printStackTrace();
        }        
    }
    public void logoff(User user)
    {
        PreparedStatement logOffStatement = null;
        try
        {
            query = "UPDATE Users SET Status = ? WHERE  "
                    + "username = ?";
                    logOffStatement = connection.prepareStatement(query);
                    logOffStatement.setString(1, "0");
                    logOffStatement.setString(2, user.getUsername());
                    int result = logOffStatement.executeUpdate();
                    System.out.println("Query executada!");
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
    public ArrayList<User> searchLanguageUser(int lingua, User user, int FluencyMin, int FluencyMax)
    {
        PreparedStatement searchLang = null;
        ResultSet resultSet = null;
        ResultSet resultSet2 = null;
        ResultSet resultSet3 = null;
        int result = 0;
        String langString = Integer.toString(lingua);
        String userFound = null;
        String FluencyString;
        String userID = Integer.toString(searchUserID(user.getUsername()));
        ArrayList <User> userList = new ArrayList();
        User listMember = new User();
                
        
        System.out.println("Buscando match para língua: " + langString);
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
                System.out.println("Searching for users who have language: " + langString);
                searchLang.setString(1, langString);
                resultSet2 = searchLang.executeQuery();
                while(resultSet2.next())
                {
            
                    query = "SELECT Users_idUser FROM Users_has_Languages WHERE Users_idUser = ? AND"
                            + " Languages_idLanguages = ? AND Fluency >= ? AND "
                            + "Fluency <= ?";
                    searchLang = connection.prepareStatement(query);
                    userFound = resultSet2.getString("Users_idUser");
                    System.out.println("User " + userFound+ " has language: " +langString );
                    searchLang.setString(1,userFound);
                    langString = Integer.toString(lingua);
                    searchLang.setString(2,langString);
                    FluencyString = Integer.toString(FluencyMin);
                    searchLang.setString(3, FluencyString);
                    FluencyString = Integer.toString(FluencyMax);
                    searchLang.setString(4, FluencyString);
                    resultSet3 = searchLang.executeQuery();
                    while(resultSet3.next())
                    {
                        listMember.setidUser(resultSet3.getInt("Users_idUser"));
                        System.out.println("User " + listMember.getidUser() + " fits the bill");
                        query = "SELECT * FROM Users WHERE idUser = ?";
                        searchLang = connection.prepareStatement(query);
                        searchLang.setString(1, Integer.toString(listMember.getidUser()));
                        ResultSet resultSet4 = searchLang.executeQuery();
                        System.out.println("Searching data for user: " + listMember.getidUser());
                        while(resultSet4.next())
                        {
                            if(resultSet4.getInt("Status")!=0)
                            {
                                listMember.setidUser(resultSet4.getInt("idUser"));
                                listMember.setUsername(resultSet4.getString("username"));
                                listMember.setName(resultSet4.getString("Name"));
                                listMember.setSurname(resultSet4.getString("Surname"));
                                listMember.setBirthdate(resultSet4.getString("Birthdate"));
                                listMember.setOccupation(resultSet4.getString("Occupation"));
                                listMember.setEmail(resultSet4.getString("email"));
                                listMember.setCOO(resultSet4.getString("CountryOfOrigin"));
                                listMember.setCOR(resultSet4.getString("CountryOfResidence"));
                                query = "SELECT * FROM Users_has_Languages WHERE Users_idUser = ?";
                                PreparedStatement membLang = null;
                                membLang = connection.prepareStatement(query);
                                membLang.setString(1, Integer.toString(listMember.getidUser()));
                                ResultSet resultSet5 = membLang.executeQuery();
                                System.out.println("Searching for languages from user: " + listMember.getidUser());
                                while(resultSet5.next())
                                {
                                    System.out.println("Searching for languages");
                                    query = "SELECT Name FROM Languages WHERE idLanguages = ?";
                                    searchLang = connection.prepareStatement(query);
                                    searchLang.setString(1, resultSet5.getString("Languages_idLanguages"));
                                    ResultSet resultSet6 = searchLang.executeQuery();
                                    if(resultSet6.next())
                                    {
                                        String langName = resultSet6.getString("Name");
                                        System.out.println("Adding Language: "+ langName +"to User");
                                        listMember.setNewLanguage(langName, resultSet5.getInt("Languages_idLanguages"), resultSet5.getInt("Fluency"),resultSet5.getInt("hasInterest"), resultSet5.getInt("Native"));
                                    }
                                    
                                }
                                System.out.println("Adding user "+ listMember.getidUser() + " to the list");
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
                    query = "UPDATE Users SET Status = ? WHERE  "
                    + "username = ?";
                    loginStatement = connection.prepareStatement(query);
                    loginStatement.setString(1, "1");
                    loginStatement.setString(2, username);
                    int result = loginStatement.executeUpdate();
                    System.out.println("Query executada!");
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
    public User searchByUsername(String username)
    {
        PreparedStatement searchUser = null;
        User user = new User();
        
        try
        {
            query = "SELECT * FROM Users INNER JOIN "
                    + "Users_has_Languages ON Users.idUser = Users_has_Languages.Users_idUser "
                    + "WHERE username = ?";
            System.out.println("Searching username: " +username);
            searchUser = connection.prepareStatement(query);
            searchUser.setString(1, username);
            ResultSet resultSet = searchUser.executeQuery();
            while(resultSet.next())
            {
                user.setidUser(resultSet.getInt("idUser"));
                user.setName(resultSet.getString("Name"));
                user.setSurname(resultSet.getString("Surname"));
                user.setUsername(resultSet.getString("username"));
                user.setBirthdate(resultSet.getString("Birthdate"));
                user.setOccupation(resultSet.getString("Occupation"));
                user.setEmail(resultSet.getString("email"));
                user.setCOO(resultSet.getString("CountryOfOrigin"));
                user.setCOR(resultSet.getString("CountryOfResidence"));
                int lang  = resultSet.getInt("Languages_idLanguages");
                int Fluency = resultSet.getInt("Fluency");
                int hasInterest = resultSet.getInt("hasInterest");
                int nativity = resultSet.getInt("Native");
                
                query = "SELECT Name FROM Languages WHERE idLanguages = ?";
                PreparedStatement searchLang = connection.prepareStatement(query);
                searchLang.setString(1, Integer.toString(lang));
                ResultSet resultSet2 = searchLang.executeQuery();
                if(resultSet2.next())
                {
                    String langName = resultSet2.getString("Name");
                    user.setNewLanguage(langName, lang, Fluency, hasInterest, nativity);
                    System.out.println("First Language found: " +langName);
                    while(resultSet.next())
                    {
                        lang  = resultSet.getInt("Languages_idLanguages");
                        Fluency = resultSet.getInt("Fluency");
                        hasInterest = resultSet.getInt("hasInterest");
                        nativity = resultSet.getInt("Native");
                        query = "SELECT Name FROM Languages WHERE idLanguages = ?";
                        searchLang = connection.prepareStatement(query);
                        searchLang.setString(1, Integer.toString(lang));
                        ResultSet resultSet3 = searchLang.executeQuery();
                        if(resultSet3.next())
                        {
                            langName = resultSet3.getString("Name");
                            
                            System.out.println("Next Language found: " +langName);
                        }
                        searchLang = connection.prepareStatement(query);
                        searchLang.setString(1, Integer.toString(lang));
                        user.setNewLanguage(langName, lang, Fluency, hasInterest, nativity);
                    }
                }
            }
            /*
            else
            {
                System.out.println("Usuario não existe");
            }
                    */
        }
        catch(SQLException sqlExc)
        {
            sqlExc.printStackTrace();
        }
        return(user);
    }
              
}
