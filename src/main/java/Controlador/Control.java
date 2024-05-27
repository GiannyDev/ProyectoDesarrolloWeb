package Controlador;

import Dao.Negocio;
import Modelo.*;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Control extends HttpServlet {
    Negocio obj = new Negocio();
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int opc = Integer.parseInt(request.getParameter("opc"));
        if (opc == 1)borrarProducto(request, response);
        if (opc == 2)ingresarProducto(request, response);
        if (opc == 3)editarProducto(request, response);
    }
    
    protected void borrarProducto(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id_produ = request.getParameter("id_produ");
        String volver = "PagProductoCRUD.jsp", verdadero = "Producto eliminado correctamente", falso = "Hubo un error en la eliminacion";
        request.setAttribute("resultado", obj.elimProducto(id_produ));
        request.setAttribute("volver", volver);
        request.setAttribute("verdadero", verdadero);
        request.setAttribute("falso", falso);
        String pag = "/PagResultado.jsp";
        request.getRequestDispatcher(pag).forward(request, response);
    }
    
    protected void ingresarProducto(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String volver = "PagProductoCRUD.jsp", verdadero = "Producto agregado correctamente", falso = "Hubo un error en la agregación";
        Producto p = new Producto(request.getParameter("nom_produ"), request.getParameter("desc_produ"), Double.parseDouble(request.getParameter("monto_produ")), request.getParameter("id_tipo_produ"), request.getParameter("ruta_imagen"));
        request.setAttribute("resultado", obj.agregarProducto(p));
        request.setAttribute("volver", volver);
        request.setAttribute("verdadero", verdadero);
        request.setAttribute("falso", falso);
        String pag = "/PagResultado.jsp";
        request.getRequestDispatcher(pag).forward(request, response);
    }
    
    protected void editarProducto(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String volver = "PagProductoCRUD.jsp", verdadero = "Producto editado correctamente", falso = "Hubo un error en la edición";
        Producto p = new Producto(request.getParameter("id_produ"), request.getParameter("nom_produ"), request.getParameter("desc_produ"), Double.parseDouble(request.getParameter("monto_produ")), request.getParameter("id_tipo_produ"), request.getParameter("ruta_imagen"));
        request.setAttribute("resultado", obj.actuProducto(p));
        request.setAttribute("volver", volver);
        request.setAttribute("verdadero", verdadero);
        request.setAttribute("falso", falso);
        String pag = "/PagResultado.jsp";
        request.getRequestDispatcher(pag).forward(request, response);
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
