import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import java.util.logging.Logger;

@WebServlet("/emailList")
public class EmailListSerlvet extends HttpServlet {

    private static final Logger logger = Logger.getLogger(EmailListSerlvet.class.getName());

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");
        if (action == null) {
            action = "join"; // mặc định
        }

        // Debug console + log
        System.out.println("DEBUG: action = " + action);
        logger.info("Servlet action = " + action);

        String url = "/index.html";   // mặc định quay lại form

        if (action.equals("join")) {
            url = "/index.html";
        } else if (action.equals("add")) {
            // Lấy các parameter từ form
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String email = request.getParameter("email");
            String dateOfBirth = request.getParameter("dateOfBirth");
            String heardFrom = request.getParameter("heard");
            String wantsUpdates = request.getParameter("announcement");
            String emailOK = request.getParameter("emailAnnouncement");
            String contactVia = request.getParameter("contact");

            // Kiểm tra bắt buộc
            if (firstName == null || lastName == null || email == null ||
                firstName.isEmpty() || lastName.isEmpty() || email.isEmpty()) {
                url = "/index.html";  // nếu thiếu dữ liệu → quay về form
            } else {
                // Đưa dữ liệu sang confirmation.jsp
                request.setAttribute("firstName", firstName);
                request.setAttribute("lastName", lastName);
                request.setAttribute("email", email);
                request.setAttribute("dateOfBirth", dateOfBirth);
                request.setAttribute("heard", heardFrom);
                request.setAttribute("announcement", wantsUpdates != null ? "Yes" : "No");
                request.setAttribute("emailAnnouncement", emailOK != null ? "Yes" : "No");
                request.setAttribute("contactVia", contactVia);

                url = "/confirmation.jsp";
            }
        }

        // Forward đến trang tương ứng
        getServletContext()
            .getRequestDispatcher(url)
            .forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
}
