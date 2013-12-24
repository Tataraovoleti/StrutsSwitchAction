/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 *
 * @author TATARAO
 */
public class FacultyAction extends org.apache.struts.action.Action {

    /* forward name="success" path="" */
  

    /**
     * This is the action called from the Struts framework.
     * @param mapping The ActionMapping used to select this instance.
     * @param form The optional ActionForm bean for this request.
     * @param request The HTTP Request we are processing.
     * @param response The HTTP Response we are processing.
     * @throws java.lang.Exception
     * @return
     */
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        
        ArrayList al=new ArrayList();
       FacultyFormBean sfb=(FacultyFormBean)form;
        
        String id=sfb.getId();
                Class.forName("org.gjt.mm.mysql.Driver");
               Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/rao","root","");
                PreparedStatement ps=con.prepareStatement("select * from faculty where id=?");
                ps.setString(1, id);
                ResultSet rs=ps.executeQuery();
                int count=0;
                while(rs.next())
                {
                    count=1;
                    bean.Faculty ft=new bean.Faculty();
                    ft.setId(rs.getString(1));
                    ft.setName(rs.getString(2));
                    ft.setSub(rs.getString(3));
                    ft.setQualification(rs.getString(4));
                    al.add(ft);
                }
                
                if(count==0)
                    return mapping.findForward("fail");
                HttpSession session=request.getSession();
                session.setAttribute("resf",al);
        
        return mapping.findForward("succ");
    }
}
