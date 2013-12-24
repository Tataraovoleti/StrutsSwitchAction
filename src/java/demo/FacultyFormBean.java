/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package demo;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

/**
 *
 * @author TATARAO
 */
public class FacultyFormBean extends org.apache.struts.action.ActionForm {
    
     private String id;

    /**
     * @return
     */
    public String getId() {
        return id;
    }

    /**
     * @param string
     */
    public void setId(String id) {
        this.id= id;
    }
}
