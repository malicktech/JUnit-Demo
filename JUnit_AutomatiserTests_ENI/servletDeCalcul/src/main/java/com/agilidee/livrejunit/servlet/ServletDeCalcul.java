package com.agilidee.livrejunit.servlet;

import com.agilidee.livrejunit.math.PGCDImpl;
import com.agilidee.livrejunit.math.PPCMImpl;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ServletDeCalcul extends HttpServlet {
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
