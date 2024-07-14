/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.MenuDAO;
import DAO.UserDAO;
import DTO.Menu;
import DTO.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author USER
 */
public class StaffDashBoardServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String function = request.getParameter("menu");
            request.removeAttribute("Action");
            MenuDAO menu = new MenuDAO();
            UserDAO user = new UserDAO();
            switch (function) {
                case "addmenu":
                    ArrayList<User> list = user.getUser();
                    request.setAttribute("Function","ADDMENU");
                    request.setAttribute("EmailTemp",list);
                    request.getRequestDispatcher("StaffDashBoard.jsp").forward(request, response);
                    break;
                case "addmenunow":
                    String email = request.getParameter("txtemail");
                    int menuWeek =Integer.parseInt(request.getParameter("txtweek"));
                    String menuName = request.getParameter("txtmenuname");
                    String menuTag = request.getParameter("txttag");  
                    String check = menu.checkWeekMenuByEmail(email, menuWeek);
                    if(check != null){
                    String result = menu.insertWeekMenuByStaff(email, menuWeek, menuName, menuTag);
                    if(result != null){
                        request.setAttribute("Result","Thêm Menu Thành Công");
                        request.getRequestDispatcher("StaffDashBoard.jsp").forward(request, response);
                    }else{
                        request.setAttribute("Result","Có Lỗi Trong quá trình thêm Menu");
                        request.getRequestDispatcher("StaffDashBoard.jsp").forward(request, response);
                    }
                    }else{
                        request.setAttribute("Result","Menu của Tuần này đã tồn tại, vui lòng xóa menu cũ trước khi thêm mới");
                        request.getRequestDispatcher("StaffDashBoard.jsp").forward(request, response);
                    }
                    break;
                case "deletemenu":
                    request.setAttribute("Function","DELETEMENU");
                    request.setAttribute("Action","deletemenunow");
                    ArrayList<Menu> allMenu = menu.getAllMenuFood();
                    request.setAttribute("MenuFoodStaff",allMenu);
                    request.getRequestDispatcher("StaffDashBoard.jsp").forward(request, response);
                break;
                case "deletemenunow":                  
                    int menuID = Integer.parseInt(request.getParameter("menuid"));
                    boolean checkDeleteMenu = menu.deleteWeekMenu(menuID);
                    if(!checkDeleteMenu){
                        request.setAttribute("Result", "Xóa Menu Thành Công");
                    }else{
                        request.setAttribute("Result", "Xóa Menu Thất Bại");
                    }
                    request.getRequestDispatcher("StaffDashBoard.jsp").forward(request, response);
                break;
                case "listuser":
                    request.setAttribute("Function", "LISTUSER");
                    ArrayList<User> listUser = user.getUser();
                    request.setAttribute("ListAllUser",listUser);
                   request.getRequestDispatcher("StaffDashBoard.jsp").forward(request, response);
                   break;
                case "deleteusernow":
                    String userIDString = request.getParameter("userid");
                    int userID = Integer.parseInt(userIDString);
                        
                   // request.setAttribute("Function", "LISTUSER");
                    user.deleteUserByID(userID);
                    request.setAttribute("Result","Xóa Người Dùng Thành Công");
                   request.getRequestDispatcher("StaffDashBoard.jsp").forward(request, response);
                   break;
                   
                 case "listmenu":
                    ArrayList<Menu> listMenu = menu.getMenuFoodByStaff();
                    request.setAttribute("MenuFood",listMenu);
                   request.getRequestDispatcher("StaffDashBoard.jsp").forward(request, response);
                   break;
                   
                 case "disableuser":
                     int userIDToDelete = Integer.parseInt(request.getParameter("userid"));
                     boolean checkUserDisble = user.disableUser(userIDToDelete);
                     if(checkUserDisble){
                     ArrayList<User> listUserAfter = user.getUser();
                    request.setAttribute("ListAllUser",listUserAfter);
                    request.getRequestDispatcher("StaffDashBoard.jsp").forward(request, response);
                     }else{
                         request.getRequestDispatcher("Index.jsp").forward(request, response);
                     }
                     break;
                 case "enableuser":
                     int userIDToEnable = Integer.parseInt(request.getParameter("userid"));
                     boolean checkUserEnable = user.enableUser(userIDToEnable);
                     if(checkUserEnable){
                     ArrayList<User> listUserAfter = user.getUser();
                    request.setAttribute("ListAllUser",listUserAfter);
                    request.getRequestDispatcher("StaffDashBoard.jsp").forward(request, response);
                     }else{
                         request.getRequestDispatcher("Index.jsp").forward(request, response);
                     }
                     break;
                
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
