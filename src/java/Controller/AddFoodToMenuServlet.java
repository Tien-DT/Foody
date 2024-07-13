/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.MenuDAO;
import DTO.Menu;
import DTO.MenuDetail;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author USER
 */
public class AddFoodToMenuServlet extends HttpServlet {

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
          
            MenuDAO menu = new MenuDAO();
            ServletContext context = getServletContext();
            int menuID = (int)context.getAttribute("MenuIDTemp");
            int menuDate = (int)context.getAttribute("MenuDayTemp");
            int foodID = Integer.parseInt(request.getParameter("foodid"));
            if(menuID >0 && menuDate >0 && foodID >0){
            boolean check = menu.insertFoodToMenu(menuID, menuDate, foodID);
            ArrayList<MenuDetail> list = menu.getMenuDetail(menuID);
            if(check){
                request.setAttribute("AddResult", "Đã thêm món ăn thành công");
                request.setAttribute("MenuDetail", list);
                request.getRequestDispatcher("MenuFoodDetail.jsp").forward(request, response);
            }else{
               
                request.setAttribute("MenuDetail", list);
                request.setAttribute("AddResult", "Món ăn đã có trong ngày đó, vui lòng chọn món khác");
                request.getRequestDispatcher("MenuFoodDetail.jsp").forward(request, response);
            }
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
