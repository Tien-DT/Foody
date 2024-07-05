package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class NewMenuFood_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <link href=\"assets/css/MenuFood.css\" rel=\"stylesheet\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "Header.jsp", out, false);
      out.write("\n");
      out.write("    <body>\n");
      out.write("        <div class=\"container-fluid body-content\">\n");
      out.write("            <div class=\"row\">\n");
      out.write("                <div class=\"col-md-12 menu-title\">\n");
      out.write("                    <h1 id=\"title-list\">Tạo Thực Đơn Mới</h1>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"box-menu box-list\">\n");
      out.write("                <form action=\"MainController?action=insertmenu\" method=\"POST\">\n");
      out.write("                    <div class=\"mb-3\">\n");
      out.write("                        <label for=\"Tên Thực Đơn\" class=\"form-label\">Tên Thực Đơn</label>\n");
      out.write("                        <input type=\"text\" class=\"form-control\" id=\"formGroupExampleInput\" name=\"txtmenuname\" required>\n");
      out.write("                    </div>\n");
      out.write("                    <select type=\"text\" id=\"inputState\" class=\"form-control\" name=\"txtweek\" required>\n");
      out.write("                        <option selected>Chọn Tuần</option>\n");
      out.write("                        <option value=\"Tuần 1\">Tuần 1</option> \n");
      out.write("                        <option value=\"Tuần 2\">Tuần 2</option>\n");
      out.write("                        <option value=\"Tuần 3\">Tuần 3</option> \n");
      out.write("                        <option value=\"Tuần 4\">Tuần 4</option>\n");
      out.write("                        <option value=\"Tuần 5\">Tuần 5</option>\n");
      out.write("                    </select>\n");
      out.write("                    <div class=\"mb-3\">\n");
      out.write("                        <label for=\"Tên Nhãn\" class=\"form-label\">Tên Nhãn</label>\n");
      out.write("                        <input type=\"text\" class=\"form-control\" id=\"formGroupExampleInput\" name=\"txttag\" required>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"col-12\">\n");
      out.write("                        <button type=\"submit\" class=\"btn btn-primary\">Tạo Thực Đơn</button>\n");
      out.write("                    </div>\n");
      out.write("                </form>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("        <footer>\n");
      out.write("            ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "Footer.jsp", out, false);
      out.write("\n");
      out.write("        </footer>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
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
