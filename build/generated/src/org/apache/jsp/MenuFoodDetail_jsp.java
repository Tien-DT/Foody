package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class MenuFoodDetail_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <link href=\"assets/css/MenuFoodDetail.css\" rel=\"stylesheet\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("\n");
      out.write("    ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "Header.jsp", out, false);
      out.write("\n");
      out.write("    <body>\n");
      out.write("        <div class=\"container-fluid body-content\">\n");
      out.write("\n");
      out.write("            <div class=\"box-menu col-md-12 box-body\">\n");
      out.write("                <h1 class=\"text-center my-4\">Thực Đơn Chi Tiết</h1>\n");
      out.write("                <!-- Header Row -->\n");
      out.write("                <div class=\"row schedule\">\n");
      out.write("                    <div class=\"col-12 col-md-2 day\">Thứ Hai</div>\n");
      out.write("                    <div class=\"col-12 col-md-2 day\">Thứ Ba</div>\n");
      out.write("                    <div class=\"col-12 col-md-2 day\">Thứ Tư</div>\n");
      out.write("                    <div class=\"col-12 col-md-2 day\">Thứ Năm</div>\n");
      out.write("                    <div class=\"col-12 col-md-2 day\">Thứ Sáu</div>\n");
      out.write("                    <div class=\"col-12 col-md-2 day\">Thứ Bảy</div>\n");
      out.write("                </div>\n");
      out.write("                <!-- Time Slots -->\n");
      out.write("                <div class=\"row schedule\">\n");
      out.write("                    <!-- Thứ Hai -->\n");
      out.write("                    <div class=\"col-12 col-md-2\">\n");
      out.write("                        <div class=\"time-slot\">Sáng</div>\n");
      out.write("                        <div class=\"period\">Thu 2 <a href=\"#\" class=\"btn btn-secondary btn-sm\">X</a></div>\n");
      out.write("                        \n");
      out.write("                    </div>\n");
      out.write("                    <!-- Thứ Ba -->\n");
      out.write("                    <div class=\"col-12 col-md-2\">\n");
      out.write("                        <div class=\"time-slot\">Sáng</div>\n");
      out.write("                        <div class=\"period\">Món 1 <a href=\"#\" class=\"btn btn-secondary btn-sm\">X</a></div>\n");
      out.write("                        <div class=\"period\">Món 2 <a href=\"#\" class=\"btn btn-secondary btn-sm\">X</a></div>\n");
      out.write("                        <div class=\"time-slot\">Trưa</div>\n");
      out.write("                        <div class=\"period\">Món 1 <a href=\"#\" class=\"btn btn-secondary btn-sm\">X</a></div>\n");
      out.write("                        <div class=\"period\">Món 2 <a href=\"#\" class=\"btn btn-secondary btn-sm\">X</a></div>\n");
      out.write("                        <div class=\"time-slot\">Chiều</div>\n");
      out.write("                        <div class=\"period\">Món 1 <a href=\"#\" class=\"btn btn-secondary btn-sm\">X</a></div>\n");
      out.write("                        <div class=\"period\">Món 2 <a href=\"#\" class=\"btn btn-secondary btn-sm\">X</a></div>\n");
      out.write("                        <div class=\"time-slot\">Tối</div>\n");
      out.write("                        <div class=\"period\">Món 1 <a href=\"#\" class=\"btn btn-secondary btn-sm\">X</a></div>\n");
      out.write("                        <div class=\"period\">Món 2 <a href=\"#\" class=\"btn btn-secondary btn-sm\">X</a></div>\n");
      out.write("                        <div class=\"time-slot\">Đêm</div>\n");
      out.write("                        <div class=\"period\">Món 1 <a href=\"#\" class=\"btn btn-secondary btn-sm\">X</a></div>\n");
      out.write("                    </div>\n");
      out.write("                    <!-- Thứ Tư -->\n");
      out.write("                    <div class=\"col-12 col-md-2\">\n");
      out.write("                        <div class=\"time-slot\">Sáng</div>\n");
      out.write("                        <div class=\"period\">Món 1 <a href=\"#\" class=\"btn btn-secondary btn-sm\">X</a></div>\n");
      out.write("                        <div class=\"period\">Món 2 <a href=\"#\" class=\"btn btn-secondary btn-sm\">X</a></div>\n");
      out.write("                        <div class=\"time-slot\">Trưa</div>\n");
      out.write("                        <div class=\"period\">Món 1 <a href=\"#\" class=\"btn btn-secondary btn-sm\">X</a></div>\n");
      out.write("                        <div class=\"period\">Món 2 <a href=\"#\" class=\"btn btn-secondary btn-sm\">X</a></div>\n");
      out.write("                        <div class=\"time-slot\">Chiều</div>\n");
      out.write("                        <div class=\"period\">Món 1 <a href=\"#\" class=\"btn btn-secondary btn-sm\">X</a></div>\n");
      out.write("                        <div class=\"period\">Món 2 <a href=\"#\" class=\"btn btn-secondary btn-sm\">X</a></div>\n");
      out.write("                        <div class=\"time-slot\">Tối</div>\n");
      out.write("                        <div class=\"period\">Món 1 <a href=\"#\" class=\"btn btn-secondary btn-sm\">X</a></div>\n");
      out.write("                        <div class=\"period\">Món 2 <a href=\"#\" class=\"btn btn-secondary btn-sm\">X</a></div>\n");
      out.write("                        <div class=\"time-slot\">Đêm</div>\n");
      out.write("                        <div class=\"period\">Món 1 <a href=\"#\" class=\"btn btn-secondary btn-sm\">X</a></div>\n");
      out.write("                    </div>\n");
      out.write("                    <!-- Thứ Năm -->\n");
      out.write("                    <div class=\"col-12 col-md-2\">\n");
      out.write("                        <div class=\"time-slot\">Sáng</div>\n");
      out.write("                        <div class=\"period\">Món 1 <a href=\"#\" class=\"btn btn-secondary btn-sm\">X</a></div>\n");
      out.write("                        <div class=\"period\">Món 2 <a href=\"#\" class=\"btn btn-secondary btn-sm\">X</a></div>\n");
      out.write("                        <div class=\"time-slot\">Trưa</div>\n");
      out.write("                        <div class=\"period\">Món 1 <a href=\"#\" class=\"btn btn-secondary btn-sm\">X</a></div>\n");
      out.write("                        <div class=\"period\">Món 2 <a href=\"#\" class=\"btn btn-secondary btn-sm\">X</a></div>\n");
      out.write("                        <div class=\"time-slot\">Chiều</div>\n");
      out.write("                        <div class=\"period\">Món 1 <a href=\"#\" class=\"btn btn-secondary btn-sm\">X</a></div>\n");
      out.write("                        <div class=\"period\">Món 2 <a href=\"#\" class=\"btn btn-secondary btn-sm\">X</a></div>\n");
      out.write("                        <div class=\"time-slot\">Tối</div>\n");
      out.write("                        <div class=\"period\">Món 1 <a href=\"#\" class=\"btn btn-secondary btn-sm\">X</a></div>\n");
      out.write("                        <div class=\"period\">Món 2 <a href=\"#\" class=\"btn btn-secondary btn-sm\">X</a></div>\n");
      out.write("                        <div class=\"time-slot\">Đêm</div>\n");
      out.write("                        <div class=\"period\">Món 1 <a href=\"#\" class=\"btn btn-secondary btn-sm\">X</a></div>\n");
      out.write("                    </div>\n");
      out.write("                    <!-- Thứ Sáu -->\n");
      out.write("                    <div class=\"col-12 col-md-2\">\n");
      out.write("                        <div class=\"time-slot\">Sáng</div>\n");
      out.write("                        <div class=\"period\">Món 1 <a href=\"#\" class=\"btn btn-secondary btn-sm\">X</a></div>\n");
      out.write("                        <div class=\"period\">Món 2 <a href=\"#\" class=\"btn btn-secondary btn-sm\">X</a></div>\n");
      out.write("                        <div class=\"time-slot\">Trưa</div>\n");
      out.write("                        <div class=\"period\">Món 1 <a href=\"#\" class=\"btn btn-secondary btn-sm\">X</a></div>\n");
      out.write("                        <div class=\"period\">Món 2 <a href=\"#\" class=\"btn btn-secondary btn-sm\">X</a></div>\n");
      out.write("                        <div class=\"time-slot\">Chiều</div>\n");
      out.write("                        <div class=\"period\">Món 1 <a href=\"#\" class=\"btn btn-secondary btn-sm\">X</a></div>\n");
      out.write("                        <div class=\"period\">Món 2 <a href=\"#\" class=\"btn btn-secondary btn-sm\">X</a></div>\n");
      out.write("                        <div class=\"time-slot\">Tối</div>\n");
      out.write("                        <div class=\"period\">Món 1 <a href=\"#\" class=\"btn btn-secondary btn-sm\">X</a></div>\n");
      out.write("                        <div class=\"period\">Món 2 <a href=\"#\" class=\"btn btn-secondary btn-sm\">X</a></div>\n");
      out.write("                        <div class=\"time-slot\">Đêm</div>\n");
      out.write("                        <div class=\"period\">Món 1 <a href=\"#\" class=\"btn btn-secondary btn-sm\">X</a></div>\n");
      out.write("                    </div>\n");
      out.write("                    <!-- Thứ Bảy -->\n");
      out.write("                    <div class=\"col-12 col-md-2\">\n");
      out.write("                        <div class=\"time-slot\">Sáng</div>\n");
      out.write("                        <div class=\"period\">Món 1 <a href=\"#\" class=\"btn btn-secondary btn-sm\">X</a></div>\n");
      out.write("                        <div class=\"period\">Món 2 <a href=\"#\" class=\"btn btn-secondary btn-sm\">X</a></div>\n");
      out.write("                        <div class=\"time-slot\">Trưa</div>\n");
      out.write("                        <div class=\"period\">Món 1 <a href=\"#\" class=\"btn btn-secondary btn-sm\">X</a></div>\n");
      out.write("                        <div class=\"period\">Món 2 <a href=\"#\" class=\"btn btn-secondary btn-sm\">X</a></div>\n");
      out.write("                        <div class=\"time-slot\">Chiều</div>\n");
      out.write("                        <div class=\"period\">Món 1 <a href=\"#\" class=\"btn btn-secondary btn-sm\">X</a></div>\n");
      out.write("                        <div class=\"period\">Món 2 <a href=\"#\" class=\"btn btn-secondary btn-sm\">X</a></div>\n");
      out.write("                        <div class=\"time-slot\">Tối</div>\n");
      out.write("                        <div class=\"period\">Món 1 <a href=\"#\" class=\"btn btn-secondary btn-sm\">X</a></div>\n");
      out.write("                        <div class=\"period\">Món 2 <a href=\"#\" class=\"btn btn-secondary btn-sm\">X</a></div>\n");
      out.write("                        <div class=\"time-slot\">Đêm</div>\n");
      out.write("                        <div class=\"period\">Món 1 <a href=\"#\" class=\"btn btn-secondary btn-sm\">X</a></div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <footer>\n");
      out.write("            ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "Footer.jsp", out, false);
      out.write("\n");
      out.write("        </footer>\n");
      out.write("    </body>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
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
