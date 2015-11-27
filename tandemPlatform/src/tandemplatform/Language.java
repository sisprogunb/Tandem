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
public class Language 
{
    private int ID;
    private int fluency;
    private int interest;
    private int nativity;
    private String langName;
    
    public Language()
    {
        
    }
    public Language(String lan,int idLang, int Fluenc, int inter, int nat)
    {
        setID(idLang);
        setFluency(Fluenc);
        setInterest(inter);
        setNativity(nat);
        setName(lan);
    }
    public void setID(int idLang)
    {
        ID = idLang;
    }
    public void setName(String lang)
    {
        langName = lang;
    }
    public void setFluency(int Fluenc)
    {
        fluency = Fluenc;
    }
    public void setInterest(int Inter)
    {
        interest = Inter;
    }
    public void setNativity(int Nat)
    {
        nativity = Nat;
    }
    public int getID()
    {
        return(ID);
    }
    public int getFluency()
    {
        return(fluency);
    }
    public int getInterest()
    {
        return(interest);
    }
    public int getNativity()
    {
        return(nativity);
    }
    public String getName()
    {
        return (langName);
    }
}
