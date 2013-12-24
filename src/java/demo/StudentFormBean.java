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
public class StudentFormBean extends org.apache.struts.action.ActionForm {
    
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

    /**
     * @return
     */
    
    public StudentFormBean() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * This is the action called from the Struts framework.
     * @param mapping The ActionMapping used to select this instance.
     * @param request The HTTP Request we are processing.
     * @return
     */
    public ActionErrors validate(ActionMapping mapping,HttpServletRequest request)
    {
        ActionErrors aes=new ActionErrors();
        if(getId()==null && getId().length()<1)
        {
            aes.add("id",new ActionMessage("ID is Required"));
        }
    return aes;
    }
    
}
