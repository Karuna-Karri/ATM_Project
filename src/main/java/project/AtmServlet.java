package project;
  

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AtmServlet")
public class AtmServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private AtmOperationInterf atmOperation = new AtmOperationImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String action = request.getParameter("action");

        out.println("<html><head>");
        out.println("<title>ATM Transaction</title>");
        out.println("<style>");
        out.println("body { display: flex; justify-content: center; align-items: center; height: 100vh; background-color: #f4f4f4; font-family: Arial, sans-serif; margin: 0; }");
        out.println(".container { text-align: center; background: white; padding: 30px; border-radius: 10px; box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.2); width: 350px; }");
        out.println("h2 { color: #333; margin-bottom: 20px; }");
        out.println("h3 { color: #007bff; }");
        out.println("a { text-decoration: none; display: inline-block; margin-top: 20px; padding: 10px 20px; color: white; background: #007bff; border-radius: 5px; }");
        out.println("a:hover { background: #0056b3; }");
        out.println("</style>");
        out.println("</head><body>");

        out.println("<div class='container'>");
        out.println("<h2>ATM Transaction</h2>");

        if ("View Balance".equals(action)) {
            out.println("<h3>Available Balance: " + atmOperation.viewBalance() + "</h3>");
        } else if ("Withdraw".equals(action)) {
            double withdrawAmount = Double.parseDouble(request.getParameter("amount"));
            out.println("<h3>" + atmOperation.withdrawAmount(withdrawAmount) + "</h3>");
        } else if ("Deposit".equals(action)) {
            double depositAmount = Double.parseDouble(request.getParameter("amount"));
            out.println("<h3>" + atmOperation.depositAmount(depositAmount) + "</h3>");
        } else if ("Mini Statement".equals(action)) {
            out.println("<h3>Mini Statement:</h3>");
            out.println(atmOperation.viewMiniStatement());
        }

        out.println("<a href='index.html'>Back to Menu</a>");
        out.println("</div>");

        out.println("</body></html>");
    }
}

