/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.FoodDAO;
import DAO.MenuDAO;
import DAO.OrderDAO;
import DAO.UserDAO;
import DTO.Food;
import DTO.Menu;
import DTO.Order;
import DTO.User;
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
            HttpSession session = request.getSession();

            String function = request.getParameter("menu");
            request.removeAttribute("Action");
            MenuDAO menu = new MenuDAO();
            UserDAO user = new UserDAO();
            FoodDAO food = new FoodDAO();
            OrderDAO order = new OrderDAO();
            switch (function) {
                case "addmenu":
                    ArrayList<User> list = user.getUser();
                    request.setAttribute("Function", "ADDMENU");
                    request.setAttribute("EmailTemp", list);
                    request.getRequestDispatcher("StaffDashBoard.jsp").forward(request, response);
                    break;
                case "addmenunow":
                    String email = request.getParameter("txtemail");
                    int menuWeek = Integer.parseInt(request.getParameter("txtweek"));
                    String menuName = request.getParameter("txtmenuname");
                    String menuTag = request.getParameter("txttag");
                    String check = menu.checkWeekMenuByEmail(email, menuWeek);
                    int emailValid = user.getUserID(email);
                    if (emailValid > 0) {
                        if (check != null) {
                            String result = menu.insertWeekMenuByStaff(email, menuWeek, menuName, menuTag);
                            if (result != null) {
                                request.setAttribute("ResultAll", "Thêm Menu Thành Công");
                                request.setAttribute("Function", "LISTMENU");
                                ArrayList<Menu> listMenu = menu.getMenuFoodByStaff();
                                request.setAttribute("MenuFood", listMenu);
                                request.getRequestDispatcher("StaffDashBoard.jsp").forward(request, response);
                            } else {
                                request.setAttribute("ResultAll", "Có Lỗi Trong quá trình thêm Menu");
                                request.setAttribute("Function", "ADDMENU");
                                request.getRequestDispatcher("StaffDashBoard.jsp").forward(request, response);
                            }
                        } else {
                            request.setAttribute("ResultAll", "Menu của Tuần này đã tồn tại, vui lòng xóa menu cũ trước khi thêm mới");
                            request.setAttribute("Function", "ADDMENU");
                            request.getRequestDispatcher("StaffDashBoard.jsp").forward(request, response);
                        }
                    } else {
                        request.setAttribute("ResultAll", "Email không tồn tại");
                        request.setAttribute("Function", "ADDMENU");
                        request.getRequestDispatcher("StaffDashBoard.jsp").forward(request, response);
                    }
                    break;
                case "deletemenu":
                    request.setAttribute("Function", "DELETEMENU");
                    request.setAttribute("Action", "deletemenunow");
                    ArrayList<Menu> allMenu = menu.getAllMenuFood();
                    request.setAttribute("MenuFoodStaff", allMenu);
                    request.getRequestDispatcher("StaffDashBoard.jsp").forward(request, response);
                    break;
                case "deletemenunow":
                    int menuID = Integer.parseInt(request.getParameter("menuid"));
                    int checkDeleteMenu = menu.deleteWeekMenu(menuID);
                    if (checkDeleteMenu == 1) {
                        request.setAttribute("Function", "MenuFoodStaff");
                        ArrayList<Menu> allMenuAfter = menu.getAllMenuFood();
                        request.setAttribute("MenuFoodStaff", allMenuAfter);
                        request.setAttribute("ResultAll", "Xóa Menu Thành Công");
                        request.getRequestDispatcher("StaffDashBoard.jsp").forward(request, response);
                    } else {
                        request.setAttribute("ResultAll", "Xóa Menu Thất Bại");
                        request.setAttribute("Function", "MenuFoodStaff");
                        ArrayList<Menu> allMenuAfter = menu.getAllMenuFood();
                        request.setAttribute("MenuFoodStaff", allMenuAfter);
                        request.getRequestDispatcher("StaffDashBoard.jsp").forward(request, response);
                    }

                    break;
                case "listuser":
                    request.setAttribute("Function", "LISTUSER");
                    ArrayList<User> listUser = user.getUser();
                    request.setAttribute("ListAllUser", listUser);
                    request.getRequestDispatcher("StaffDashBoard.jsp").forward(request, response);
                    break;
                case "deleteusernow":
                    String userIDString = request.getParameter("userid");
                    int userID = Integer.parseInt(userIDString);

                    // request.setAttribute("Function", "LISTUSER");
                    user.deleteUserByID(userID);
                    request.setAttribute("ResultAll", "Xóa Người Dùng Thành Công");
                    request.getRequestDispatcher("StaffDashBoard.jsp").forward(request, response);
                    break;

                case "listmenu":
                    ArrayList<Menu> listMenu = menu.getMenuFoodByStaff();
                    request.setAttribute("MenuFood", listMenu);
                    request.getRequestDispatcher("StaffDashBoard.jsp").forward(request, response);
                    break;

                case "disableuser":
                    int userIDToDelete = Integer.parseInt(request.getParameter("userid"));

                    if (userIDToDelete > 0) {
                        boolean checkUserDisble = user.disableUser(userIDToDelete);
                        ArrayList<User> listUserAfter = user.getUser();
                        request.setAttribute("ListAllUser", listUserAfter);
                        request.setAttribute("ResultAll", "Bạn đã vô hiệu hóa tài khoản: " + userIDToDelete + " thành công");
                        request.setAttribute("Function", "LISTUSER");
                        request.getRequestDispatcher("StaffDashBoard.jsp").forward(request, response);
                    } else {
                        ArrayList<User> listUserAfter = user.getUser();
                        request.setAttribute("ListAllUser", listUserAfter);
                        request.setAttribute("Function", "LISTUSER");
                        request.setAttribute("ResultAll", "Có lỗi xảy ra");
                        request.getRequestDispatcher("StaffDashBoard.jsp").forward(request, response);
                    }
                    break;
                case "enableuser":
                    int userIDToEnable = Integer.parseInt(request.getParameter("userid"));
                    boolean checkUserEnable = user.enableUser(userIDToEnable);
                    if (checkUserEnable) {
                        ArrayList<User> listUserAfter = user.getUser();
                        request.setAttribute("ListAllUser", listUserAfter);
                        request.setAttribute("Function", "LISTUSER");
                        request.setAttribute("ResultAll", "Bạn đã mở khóa tài khoản: "+userIDToEnable+ " thành công");
                        request.getRequestDispatcher("StaffDashBoard.jsp").forward(request, response);
                    } else {

                        request.getRequestDispatcher("StaffDashBoard.jsp").forward(request, response);
                    }
                    break;
                case "addfoodlist":
                    request.setAttribute("Function", "ADDFOODLISTFORM");
                    request.getRequestDispatcher("StaffDashBoard.jsp").forward(request, response);
                    break;
                case "addfoodlistnow":
                    String foodName = request.getParameter("txtname");
                    String foodStep = request.getParameter("txtfoodstep");
                    int foodPrice = Integer.parseInt(request.getParameter("txtprice"));
                    String foodImage = request.getParameter("txtpath");
                    boolean checkAddFoodList = food.insertFoodList(foodName, foodStep, foodPrice, foodImage);
                    if (checkAddFoodList) {
                        request.setAttribute("ResultAll", "Thêm Món Ăn Thành Công");
                        request.getRequestDispatcher("StaffDashBoard.jsp").forward(request, response);
                    } else {
                        request.setAttribute("ResultAll", "Thêm Món Ăn Thất Bại");
                        request.getRequestDispatcher("StaffDashBoard.jsp").forward(request, response);
                    }
                    break;
                case "disablefoodlist":
                    ArrayList<Food> disableFoodList = food.getAllFood();
                    request.setAttribute("DisableFoodList", disableFoodList);
                    request.setAttribute("Function", "DISABLEFOODLIST");
                    request.getRequestDispatcher("StaffDashBoard.jsp").forward(request, response);
                    break;
                case "disablefoodlistnow":
                    int foodID = Integer.parseInt(request.getParameter("foodid"));
                    boolean checkDeleteFood = food.deleteFoodByID(foodID);
                    if (checkDeleteFood) {
                        request.setAttribute("ResultAll", "Đã ẩn món ăn thành công");
                        ArrayList<Food> disableFoodListAfter = food.getAllFood();
                        request.setAttribute("DisableFoodList", disableFoodListAfter);
                        request.setAttribute("Function", "DISABLEFOODLIST");
                        request.getRequestDispatcher("StaffDashBoard.jsp").forward(request, response);
                    } else {
                        request.getRequestDispatcher("Index.jsp").forward(request, response);
                    }
                    break;

                case "enablefoodlistnow":
                    int foodIDEnable = Integer.parseInt(request.getParameter("foodid"));
                    boolean checkEnableFood = food.enableFoodByID(foodIDEnable);
                    if (checkEnableFood) {
                        request.setAttribute("ResultAll", "Đã hiện món ăn thành công");
                        ArrayList<Food> enableFoodList = food.getAllFood();
                        request.setAttribute("DisableFoodList", enableFoodList);
                        request.setAttribute("Function", "DISABLEFOODLIST");
                        request.getRequestDispatcher("StaffDashBoard.jsp").forward(request, response);
                    } else {
                        request.getRequestDispatcher("Index.jsp").forward(request, response);
                    }
                    break;

                case "updateinfofood":
                    int foodIDUpdate = Integer.parseInt(request.getParameter("foodid"));
                    Food foodUpdate = food.updateFood(foodIDUpdate);
                    request.setAttribute("FoodUpdate", foodUpdate);
                    request.setAttribute("Function", "UPDATEFOOD");
                    request.getRequestDispatcher("StaffDashBoard.jsp").forward(request, response);
                    break;

                case "updateinfofoodnow":
                    int foodIDUpdateNow = Integer.parseInt(request.getParameter("foodid"));
                    String foodNameUpdate = request.getParameter("txtname");
                    String foodStepUpdate = request.getParameter("txtfoodstep");
                    int foodPriceUpdate = Integer.parseInt(request.getParameter("txtprice"));
                    String foodImageUpdate = request.getParameter("txtpath");
                    boolean checkFoodUpdate = food.updateInfoFood(foodNameUpdate, foodStepUpdate, foodPriceUpdate, foodImageUpdate, foodIDUpdateNow);
                    if (checkFoodUpdate) {
                        request.setAttribute("ResultAll", "Cập Nhật Thông tin món ăn thành công");
                        ArrayList<Food> foodListUpdated = food.getAllFood();
                        request.setAttribute("DisableFoodList", foodListUpdated);
                        request.setAttribute("Function", "DISABLEFOODLIST");
                        request.getRequestDispatcher("StaffDashBoard.jsp").forward(request, response);
                    }else{
                        request.setAttribute("ResultAll", "Có lỗi xảy ra trong quá trình cập nhật thông tin món ăn");
                        ArrayList<Food> foodListUpdated = food.getAllFood();
                        request.setAttribute("DisableFoodList", foodListUpdated);
                        request.setAttribute("Function", "DISABLEFOODLIST");
                        request.getRequestDispatcher("StaffDashBoard.jsp").forward(request, response);
                    }
                    break;

                case "listorder":
                    ArrayList<Order> listOrder = order.getAllUserOrder();
                    if (listOrder != null) {
                        request.setAttribute("ListOrder", listOrder);
                        request.getRequestDispatcher("StaffDashBoard.jsp").forward(request, response);
                    } else {
                        request.setAttribute("ResultAll", "Không có đơn hàng nào");
                        request.getRequestDispatcher("StaffDashBoard.jsp").forward(request, response);
                    }
                    break;

                case "updateorder":
                    int orderStatus = Integer.parseInt(request.getParameter("orderstatus"));
                    int orderID = Integer.parseInt(request.getParameter("orderid"));
                    order.updateStatusOrder(orderStatus, orderID);

                    ArrayList<Order> listOrderAfter = order.getAllUserOrder();
                    request.setAttribute("ListOrder", listOrderAfter);
                    request.getRequestDispatcher("StaffDashBoard.jsp").forward(request, response);
                    break;

                case "cancelorder":
                    int orderIDCancel = Integer.parseInt(request.getParameter("orderid"));
                    order.cancelOrder(orderIDCancel);
                    ArrayList<Order> listOrderCancel = order.getAllUserOrder();
                    request.setAttribute("ListOrder", listOrderCancel);
                    request.setAttribute("ResultAll", "Đã hủy thành công đơn hàng: " + orderIDCancel);
                    request.getRequestDispatcher("StaffDashBoard.jsp").forward(request, response);
                    break;

                case "searchorder":
                    String searchOrder = request.getParameter("txtsearchorder");
                    ArrayList<Order> listOrderSearch = order.searchOrder(searchOrder);
                    request.setAttribute("ListOrder", listOrderSearch);
                    request.getRequestDispatcher("StaffDashBoard.jsp").forward(request, response);
                    break;

                case "setstaff":
                    int userIDSet = Integer.parseInt(request.getParameter("userid"));
                    int role = Integer.parseInt(request.getParameter("role"));
                    boolean checkUserSet = user.setStaff(role, userIDSet);
                    if (checkUserSet) {
                        request.setAttribute("ResultAll", "Bạn đã phân quyền thành công cho User ID: " + userIDSet);
                        ArrayList<User> listUserAfter = user.getUser();
                        request.setAttribute("Function", "LISTUSER");
                        request.setAttribute("ListAllUser", listUserAfter);
                        request.getRequestDispatcher("StaffDashBoard.jsp").forward(request, response);
                    } else {
                        ArrayList<User> listUserAfter = user.getUser();
                        request.setAttribute("ListAllUser", listUserAfter);
                        request.setAttribute("Function", "LISTUSER");
                        request.setAttribute("ResultAll", "Có lỗi trong quá trình phân quyền");
                        request.getRequestDispatcher("StaffDashBoard.jsp").forward(request, response);
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
