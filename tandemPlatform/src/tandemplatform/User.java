/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tandemplatform;

/**
 *
 * @author gshimabuko
 */
public class User {
    private String name = null;
    private String surname= null;
    private String username = null;
    private String password = null;
    private String ID= null;
    private String birthDate= null;
    private String occupation= null;
    private String email = null;
    private String countryOfOrigin = null;
    private String countryOfResidence = null;
    private Integer nativeLanguage = 0;
    
    public void setName(String n)
    {
        name = n;
    }
    public void setSurname(String n)
    {
        surname = n;
    }
    public void setPassword(String n)
    {
        password = n;
    }
    public void setUsername(String n)
    {
        username = n;
    }
    public void setBirthdate(String n)
    {
        birthDate = n;
    }
    public void setOccupation(String n)
    {
        occupation = n;
    }
    public void setEmail(String n)
    {
        email = n;
    }
    public void setCOO(String n)
    {
        countryOfOrigin = n;
    }
    public void setCOR(String n)
    {
        countryOfResidence = n;
    }
    
    public String getName()
    {
        return(name);
    }
    public String getSurname()
    {
        return(surname);
    }
    public String getPassword()
    {
        return(password);
    }
    public String getUsername()
    {
        return username;
    }
    public String getBirthdate()
    {
        return birthDate;
    }
    public String getOccupation()
    {
        return occupation;
    }
    public String getEmail()
    {
        return email;
    }
    public String getCOO()
    {
        return countryOfOrigin;
    }
    public String getCOR()
    {
        return countryOfResidence;
    }
    public void setNativeLanguage(Integer lang)
    {
        nativeLanguage = lang;
    }
    public Integer getNativeLanguage()
    {
        return(nativeLanguage);
    }
    
}
