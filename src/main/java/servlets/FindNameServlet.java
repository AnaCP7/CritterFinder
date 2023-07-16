package servlets;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashMap;

@WebServlet("/find-name")
public class FindNameServlet extends HttpServlet {
    HashMap<String, String> miHashMap = new HashMap<>();

    @Override
    public void init() {
        miHashMap.put("rana", "snvlkdf");
        miHashMap.put("zorro", "Vulpes vulpes");
        miHashMap.put("lince", "Linx pardinus");
        miHashMap.put("lobo", "Canis lupus");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nombre = req.getParameter("animalNameInput");
        String answer = miHashMap.get(nombre.toLowerCase());

        if(answer != null){
            resp.getWriter().println("El nombre del animal es: " + answer);
        }else{
            resp.getWriter().println("No se ha encontrado" );
        }

    }
}
