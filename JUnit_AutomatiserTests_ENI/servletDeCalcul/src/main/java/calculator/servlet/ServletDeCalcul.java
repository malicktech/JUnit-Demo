package calculator.servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import calculator.math.PGCDImpl;
import calculator.math.PPCMImpl;

public class ServletDeCalcul extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        Long a = new Long (request.getParameter("a"));
        Long b = new Long (request.getParameter("b"));
        Long resultat;

        if (request.getParameter("operation").equals("ppcm"))   {
            PPCMImpl operation = new PPCMImpl();
            resultat = operation.calculer(a,b);
        } else {
            PGCDImpl operation = new PGCDImpl();
            resultat = operation.calculer(a,b);
        }

        PrintWriter out = response.getWriter();
        out.println("{\"resultat\":"+resultat.toString()+"}");
        out.flush();
        out.close();
    }
}
