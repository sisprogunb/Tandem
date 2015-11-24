
import java.io.Serializable;

public class UserLanguages implements Serializable {

    private int language1;
    private int language2;
    private int fluencylevel1;
    private int fluencylevel2;
    
    public void setLanguage1(int language1){
        this.language1 = language1;
    }
    
    public void setLanguage2(int language2){
        this.language2 = language2;
    }
    
    public void setFluencyLevel1(int fluencylevel1){
        this.fluencylevel1 = fluencylevel1;
    }
    
    public void setFluencyLevel2(int fluencylevel2){
        this.fluencylevel2 = fluencylevel2;
    }
    
    public int getLanguage1(){
        return language1;
    }
    
    public int getLanguage2(){
        return language2;
    }
    
    public int getFluencyLevel1(){
        return fluencylevel1;
    }
    
    public int getFluencyLevel2(){
        return fluencylevel2;
    }
}
