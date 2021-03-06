package org.wso2.carbon.sample;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.wso2.carbon.sample.util.HazelcastCache;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class CacheWriteServlet extends HttpServlet {

    private static final Log wso2Log = LogFactory.getLog(CacheWriteServlet.class);

    public void init(ServletConfig servletConfig) throws ServletException {
        super.init(servletConfig);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String cachedKey = request.getParameter("cacheKey");
        String cachedValue = request.getParameter("cacheValue");

        //request.setAttribute("cacheValue", cachedValue);
        //request.getRequestDispatcher("/WEB-INF/page.jsp").forward(request, response);


        HazelcastCache.write(cachedKey,cachedValue);

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<HTML>");
        out.println("<HEAD><TITLE>Cache Response</TITLE></HEAD>");
        out.println("<BODY>");
        out.println("<H1> Cache WRITE SUCCESSFUL </H1");
        out.println("<BR/>");
        out.println("<BR/>");
        out.println("Input Cache Key = " + cachedKey);
        out.println("<BR/>");
        out.println("Input Cache Value = " + cachedValue);
        out.println("</BODY></HTML>");
    }
}
