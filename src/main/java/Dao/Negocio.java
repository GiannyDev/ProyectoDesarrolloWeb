package Dao;

import Modelo.*;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import Util.MySQLConexion;

public class Negocio {

    public List<CategoriaProdu> listCategoria() {
        List<CategoriaProdu> lista = new ArrayList();
        try {
            Connection cn = MySQLConexion.getConexion();
            CategoriaProdu cat;
            String sql = "SELECT id_tipo_producto, nom_tipo_producto FROM tipo_producto";
            PreparedStatement stm = cn.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                cat = new CategoriaProdu(rs.getString(1), rs.getString(2));
                lista.add(cat);
            }
        } catch (Exception e) {
            System.err.println(e.toString());
        }
        return lista;
    }

    public List<Producto> listProducto(String tipo) {
        List<Producto> lista = new ArrayList();
        try {
            Producto pro;
            Connection cn = MySQLConexion.getConexion();
            String sql = "SELECT id_producto, nom_producto, monto_producto, id_tipo_producto, ruta_imagen FROM producto WHERE id_tipo_producto = ?";
            PreparedStatement stm = cn.prepareStatement(sql);
            stm.setString(1, tipo);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                pro = new Producto(rs.getString(1), rs.getString(2), rs.getDouble(3), rs.getString(4), rs.getString(5));
                lista.add(pro);
            }

        } catch (Exception e) {
            System.err.println(e.toString());
        }
        return lista;
    }
}
