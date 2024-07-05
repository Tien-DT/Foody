/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.MenuDAO;
import DTO.Menu;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author USER
 */
public class InsertNewMenuServlet extends HttpServlet {

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
        request.setCharacterEncoding("utf-8");

        try (PrintWriter out = response.getWriter()) {
            String newMenuName = request.getParameter("txtmenuname");
            String menuWeek = request.getParameter("txtweek");
            String menuTag = request.getParameter("txttag");
            HttpSession session = request.getSession();
            int userID = (int) session.getAttribute("LoginedUID");

            if (userID == 0) {
                request.setAttribute("Result", "Vui Lòng Đăng Nhập Lại");
                request.getRequestDispatcher("LoginForm.jsp").forward(request, response);
                
            }

            MenuDAO menuDAO = new MenuDAO();
            String menuCheck = menuDAO.checkWeekMenu(userID, menuWeek);

            if (menuCheck != null) {
                String checkInsert = menuDAO.insertWeekMenu(userID, menuWeek, newMenuName, menuTag);
                if (checkInsert != null) {
                    request.setAttribute("Result", "Đã tạo menu thành công");
                    request.getRequestDispatcher("NewMenuFood.jsp").forward(request, response);
                } else {
                    request.setAttribute("Result", "Có lỗi xảy ra trong quá trình tạo menu");
                    request.getRequestDispatcher("NewMenuFood.jsp").forward(request, response);
                }
            } else {
                request.setAttribute("Result", "Menu của tuần này đã tồn tại");
                request.getRequestDispatcher("NewMenuFood.jsp").forward(request, response);
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
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
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
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
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
