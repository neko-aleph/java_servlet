import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class VolumeCalculatorServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/plain;charset=UTF-8");
        PrintWriter out = response.getWriter();

        try {
            String shape = request.getParameter("shape");

            double volume = 0;
            switch (shape.toLowerCase()) {
                case "cube":
                    double side = Double.parseDouble(request.getParameter("side"));
                    volume = Math.pow(side, 3);
                    break;
                case "parallelepiped":
                    double length = Double.parseDouble(request.getParameter("length"));
                    double width = Double.parseDouble(request.getParameter("width"));
                    double height = Double.parseDouble(request.getParameter("height"));
                    volume = length * width * height;
                    break;
                case "sphere":
                    double radius = Double.parseDouble(request.getParameter("radius"));
                    volume = (4.0 / 3.0) * Math.PI * Math.pow(radius, 3);
                    break;
                case "tetrahedron":
                    double edge = Double.parseDouble(request.getParameter("edge"));
                    volume = (Math.pow(edge, 3) / (6 * Math.sqrt(2)));
                    break;
                case "torus":
                    double majorRadius = Double.parseDouble(request.getParameter("majorRadius"));
                    double minorRadius = Double.parseDouble(request.getParameter("minorRadius"));
                    volume = 2 * Math.PI * Math.PI * majorRadius * Math.pow(minorRadius, 2);
                    break;
                case "ellipsoid":
                    double a = Double.parseDouble(request.getParameter("a"));
                    double b = Double.parseDouble(request.getParameter("b"));
                    double c = Double.parseDouble(request.getParameter("c"));
                    volume = (4.0 / 3.0) * Math.PI * a * b * c;
                    break;
                default:
                    out.println("Unknown shape: " + shape);
                    return;
            }

            out.println("Volume of " + shape + " = " + volume);
        } catch (Exception e) {
            out.println("Invalid parameters: " + e.getMessage());
        }
    }
}
