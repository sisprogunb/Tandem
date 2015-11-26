/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tandemplatform;

import java.util.ArrayList;

/**
 *
 * @author gshimabuko
 */
public class User {
    private Integer idUser = null;
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
    private ArrayList <Language> languages = new ArrayList();
    public void setidUser(Integer n)
    {
        idUser = n;
    }
    public Integer getidUser()
    {
        return(idUser);
    }
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
    public void setNewLanguage(int lang, int fluency, int interest, int nativity)
    {
        Language Lang = new Language(lang, fluency, interest, nativity);
        languages.add(Lang);
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
    public ArrayList getLanguages()
    {
        return(languages);
    }
    
}
