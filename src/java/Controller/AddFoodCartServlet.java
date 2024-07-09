/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.CartDAO;
import DAO.FoodDAO;
import DTO.Food;
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
public class AddFoodCartServlet extends HttpServlet {

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
            String foodIDString = request.getParameter("foodid");
            int foodID = Integer.parseInt(foodIDString);
            HttpSession session = request.getSession();
            int UID = (int) session.getAttribute("LoginedUID");
            CartDAO cart = new CartDAO();
            int CartID = cart.checkCart(UID);
            if(CartID == 0){
                int checkInsert = cart.insertCart(UID);
                cart.insertFoodCart(CartID, foodID);
                request.getRequestDispatcher("GetCartServlet").forward(request, response);
            }else{
                int quantity = cart.checkFoodCart(CartID, foodID);
                if(quantity >= 1){
                    int quantityUpdate = quantity + 1;       
                    cart.updateFoodQuantity(CartID, foodID, quantityUpdate);
                    request.getRequestDispatcher("GetCartServlet").forward(request, response);
                }else{
                    cart.insertFoodCart(CartID, foodID);
                    request.getRequestDispatcher("GetCartServlet").forward(request, response);
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
