package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.http.HttpSession;

public final class LoginForm_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("    ");
      out.write("\n");
      out.write("\n");
      out.write("    \n");
      out.write("    \n");
      out.write("    <!DOCTYPE html>\n");
      out.write("    <html lang=\"en\">\n");
      out.write("    <head>\n");
      out.write("        <meta charset=\"UTF-8\">\n");
      out.write("        <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("        <title>Login and Register Form</title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"assets/css/LoginForm.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"assets/css/Main.css\">\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "Header.jsp", out, false);
      out.write("\n");
      out.write("        \n");
      out.write("        <video src=\"assets/video/tvc.mp4\" autoplay loop muted></video>\n");
      out.write("        \n");
      out.write("        <div class=\"container box-input-div\">\n");
      out.write("            <!-- Login Form -->\n");
      out.write("            <div class=\"login-box\" id=\"login-form\">\n");
      out.write("                <form action=\"MainController?action=login\" method=\"POST\">\n");
      out.write("                    <div class=\"inputBox\">\n");
      out.write("                        <input type=\"text\" name=\"txtusername\" required>\n");
      out.write("                        <label>Username</label>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"inputBox\">\n");
      out.write("                        <input type=\"password\" name=\"txtpassword\" required>\n");
      out.write("                        <label>Password</label>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"remember\" name=\"checkbox\">\n");
      out.write("                        <input type=\"checkbox\">Remember me\n");
      out.write("                    </div>\n");
      out.write("                    ");

                        String msg =(String)session.getAttribute("LoginError");
                        if(msg.contains("Sai")){                        
                    
      out.write("<p>");
out.print(msg);
      out.write("</p>");

                        session.removeAttribute("LoginError");
                        }
                        
                    
      out.write("\n");
      out.write("                    \n");
      out.write("                    <div class=\"button\">\n");
      out.write("                        <input type=\"submit\" value=\"Login\">\n");
      out.write("                    </div>\n");
      out.write("                   \n");
      out.write("                    <div class=\"register\">\n");
      out.write("                        <a href=\"#\" onclick=\"toggleForm()\">Register</a>\n");
      out.write("                    </div>\n");
      out.write("                </form>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <!-- Register Form -->\n");
      out.write("            <div class=\"login-box\" id=\"register-form\" style=\"display: none;\">\n");
      out.write("                <form action=\"MainController?action=register\" method=\"POST\">\n");
      out.write("                    <div class=\"inputBox\">\n");
      out.write("                        <input type=\"text\" name=\"txtfullname\" required>\n");
      out.write("                        <label>Full Name</label>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"inputBox\">\n");
      out.write("                        <input type=\"email\" name=\"txtemail\" required>\n");
      out.write("                        <label>Email</label>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"inputBox\">\n");
      out.write("                        <input type=\"text\" name=\"txtusername\" required>\n");
      out.write("                        <label>Username</label>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"inputBox\">\n");
      out.write("                        <input type=\"password\" name=\"txtpassword\" required>\n");
      out.write("                        <label>Password</label>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"button\">\n");
      out.write("                        <input type=\"submit\" value=\"Register\">\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"register\">\n");
      out.write("                        <a href=\"#\" onclick=\"toggleForm()\">Login</a>\n");
      out.write("                    </div>\n");
      out.write("                </form>\n");
      out.write("                \n");
      out.write("            </div>\n");
      out.write("            </div>\n");
      out.write("            \n");
      out.write("        <script>\n");
      out.write("            function toggleForm() {\n");
      out.write("                var loginForm = document.getElementById(\"login-form\");\n");
      out.write("                var registerForm = document.getElementById(\"register-form\");\n");
      out.write("                if (loginForm.style.display === \"none\") {\n");
      out.write("                    loginForm.style.display = \"block\";\n");
      out.write("                    registerForm.style.display = \"none\";\n");
      out.write("                } else {\n");
      out.write("                    loginForm.style.display = \"none\";\n");
      out.write("                    registerForm.style.display = \"block\";\n");
      out.write("                }\n");
      out.write("            }\n");
      out.write("        </script>\n");
      out.write(" \n");
      out.write("        \n");
      out.write("    </body>\n");
      out.write("        \n");
      out.write("    </html>\n");
      out.write("\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
