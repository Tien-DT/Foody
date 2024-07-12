/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author USER
 */
public class MainController extends HttpServlet {

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
            String a = request.getParameter("action");
            String url = "";
            if (a == null) {
                a = "welcome";
            }

            switch (a) {
                case "welcome":
                    url = "Index.jsp";
                    break;
                case "foodlist":
                    url = "GetFoodListServlet";
                    break;
                case "viewcart":
                  
                    url = "GetCartServlet";
                    
                    break;
                case "vieworder":
                    url = "Order.jsp";
                    break;
                case "mydashboard":
                    url = "Dashboard.jsp";
                    break;
                case "loginform":
                    url = "LoginForm.jsp";
                    break;

                case "login":
                    url = "LoginServlet";
                    break;

                case "register":
                    url = "RegisterServlet";
                    break;
                case "logout":
                    url = "LogOutServlet";
                    break;
                case "menu":
                    url = "GetMenuFoodServlet";
                    break;
                case "buyfood":
                    url = "BuyFoodServlet";
                    break;
                case "createmenu":
                    url = "NewMenuFood.jsp";
                    break;
                case "insertmenu":
                    url = "InsertNewMenuServlet";
                    break;
                case "addfoodtocart":
                    url ="AddFoodCartServlet";
                    break;
                case "addproductcart":
                    url="AddProductToCartServlet";
                    break;
                case "menudetail":
                    url="GetMenuDetailServlet";
                    break;
                case "viewfood":
                    url="GetFoodDetailServlet";
                    break;
                case "addfoodtomenu":
                    url="AddFoodToMenuFormServlet";
                    break;
                case "deletemenu":
                    url="DeleteMenuServlet";
                    break;
                case "staffdashboard":
                    url="StaffDashBoard.jsp";
                    break;
                case "funcdashboard":
                    url="StaffDashBoardServlet";
                    break;
                case "deletecart":
                    url="DeleteCartServlet";
                    break;
                case "searchmenu":
                    url="SearchMenuServlet";
                    break;
               
            }
            request.getRequestDispatcher(url).forward(request, response);
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
