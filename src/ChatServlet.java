import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

public class ChatServlet extends HttpServlet {
    private List<String> messages;

    @Override
    public void init() throws ServletException {
        messages = Collections.synchronizedList(new ArrayList<>());
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");
        PrintWriter out = response.getWriter();

        // Build JSON array manually
        StringBuilder json = new StringBuilder();
        json.append("[");

        synchronized (messages) {
            for (int i = 0; i < messages.size(); i++) {
                json.append("\"").append(escapeJson(messages.get(i))).append("\"");
                if (i < messages.size() - 1) {
                    json.append(",");
                }
            }
        }

        json.append("]");

        // Write JSON array to output
        out.println(json.toString());
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String user = request.getParameter("user");
        String message = request.getParameter("message");

        if (user != null && message != null) {
            String fullMessage = user + ": " + message;
            synchronized (messages) {
                messages.add(fullMessage);
            }
        }
    }

    // Helper method to escape JSON special characters
    private String escapeJson(String text) {
        if (text == null) {
            return "";
        }
        return text.replace("\"", "\\\"")
                .replace("\\", "\\\\")
                .replace("/", "\\/")
                .replace("\b", "\\b")
                .replace("\f", "\\f")
                .replace("\n", "\\n")
                .replace("\r", "\\r")
                .replace("\t", "\\t");
    }
}
