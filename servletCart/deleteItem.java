import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
@WebServlet("/addtocart")
public class Addtocart extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        cart shoppingCart;
        shoppingCart = (cart) session.getAttribute("cart");
        if(shoppingCart == null){
          shoppingCart = new cart();
          session.setAttribute("cart", shoppingCart);
        }
        String name = request.getParameter("name");
        String d_key = request.getParameter("key");
        String s2=request.getParameter("delete");
        /*if(s2.equals("delete")){
        	shoppingCart.deleteFromCart(d_key);
        	//update
        	session.setAttribute("cart", shoppingCart);
        	// now fetch
        	shoppingCart = (cart) session.getAttribute("cart");
        }*/
        Integer price = Integer.parseInt(request.getParameter("price"));
        shoppingCart.addToCart(name, price);
        session.setAttribute("cart", shoppingCart);
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Item Deleted</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Pizza successfully added to cart </h1>");
            out.println("<form action='index.html'>Add more pizza item<br/><input type='submit' value='go'></form>");
            out.println("<hr>");
            out.println("<h2>Cart</h2>");
            HashMap<String, Integer> items = shoppingCart.getCartItems();
            out.println("<table border='1px'>");
             
            for(String key: items.keySet()){
                out.println("<tr><td>"+key+" - </td><td>"+"$"+items.get(key)+"</td>"
                		+ "<td><form action='deleteItem'><input type='hidden' name='key' value='"+key+"'><input type='submit' value='delete' name='delete'></form></td></tr>");
            }
            out.println("<table>");
            out.println("</body>");
            out.println("</html>");
             
        }
    }
}
