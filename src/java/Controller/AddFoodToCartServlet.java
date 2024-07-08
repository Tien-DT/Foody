/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

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
public class AddFoodToCartServlet extends HttpServlet {

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

            // Retrieve food item from database
            FoodDAO foodDAO = new FoodDAO();
            ArrayList<Food> foodList = foodDAO.getFoodByID(foodID);

            // Get the session and cart from session
            HttpSession session = request.getSession();
            ArrayList<Food> cart = (ArrayList<Food>) session.getAttribute("cart");

            if (cart == null) {
                cart = new ArrayList<>();
              
            }

            // Add item to cart if not already present
            boolean found = false;
            for (Food food : cart) {
                if (food.getFoodID() == foodID) {
                    found = true;
                    break;
                }
            }

            if (!found && !foodList.isEmpty()) {
                // Add new food item to cart
                cart.add(foodList.get(0)); // Assuming foodList contains only one item
            }

            // Update session with the updated cart
            session.setAttribute("cart", cart);

            // Forward to Cart.jsp to display cart
            request.getRequestDispatcher("Cart.jsp").forward(request, response);
        } catch (NumberFormatException | ServletException | IOException e) {
            // Handle exceptions appropriately
            e.printStackTrace();
            // Optionally redirect to an error page
            response.sendRedirect("error.jsp");
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
