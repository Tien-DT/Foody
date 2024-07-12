/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.CartDAO;
import DAO.OrderDAO;
import DTO.Cart;
import DTO.ItemCart;
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
public class OrderFormServlet extends HttpServlet {

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
            HttpSession session = request.getSession();
            Object loginedUID = session.getAttribute("LoginedUID");
            String function = request.getParameter("function");
            //request.setAttribute("Temp1", function);
            // request.getRequestDispatcher("TestPage.jsp").forward(request, response);
            int userID = Integer.parseInt(loginedUID.toString());
            CartDAO cart = new CartDAO();
            String totalPrice = request.getParameter("totalprice");
            
            switch (function) {
                case "orderform":
                    ArrayList<ItemCart> list = cart.getAllCart(userID);
                    request.setAttribute("OrderItem", list);
                    request.getRequestDispatcher("OrderForm.jsp").forward(request, response);
                    break;
                case "ORDERNOW":
                    String orderAddress = request.getParameter("txtaddress");
                    String orderPhone = request.getParameter("txtnumber");
                    StringBuilder orderDetail = new StringBuilder();
                    ArrayList<ItemCart> listOrder = cart.getAllCart(userID);

                    if (listOrder != null && !listOrder.isEmpty()) {
                        for (ItemCart itemCart : listOrder) {
                            orderDetail.append(itemCart.toString()).append("<br>");                        
                        }
                         
                    }
                        
                    OrderDAO orderDAO = new OrderDAO();
                    String checkAddOrder = orderDAO.insertNewOrder(userID, orderDetail.toString(), orderPhone, orderAddress);
                    if(checkAddOrder != null){
                        request.setAttribute("Result", "Cảm ơn Bạn đã đặt hàng, đơn hàng sẽ được giao cho bạn trong thời gian sớm nhất !");
                        cart.deleteUserCart(userID);
                        request.getRequestDispatcher("Index.jsp").forward(request, response);
                    }else{
                        request.setAttribute("Result", "Xin lỗi ! Có lỗi xảy ra trong quá trình đặt hàng, vui lòng thử lại.");
                        request.getRequestDispatcher("MenuFood.jsp").forward(request, response);
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
