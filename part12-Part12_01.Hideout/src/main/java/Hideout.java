
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author kevin
 */
public class Hideout<T> {
    
    T hideout;
    
    public Hideout() {
        
    }
    
    public void putIntoHideout(T toHide) {
        this.hideout = toHide;
    }
    
    public T takeFromHideout() {
        T ret = hideout;
        hideout = null;
        return ret;
    }
    
    public boolean isInHideout() {
        if(this.hideout != null) {
            return true;
        }
        return false;
    }
    
}
