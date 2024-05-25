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
                System.out.println(rs.getString(1));
                lista.add(pro);
            }

        } catch (Exception e) {
            System.err.println(e.toString());
        }
        return lista;
    }
    public Producto getProducto(String id_produ) {
        Producto p = new Producto();
        try {
            Connection cn = MySQLConexion.getConexion();
            String sql = "SELECT id_producto, desc_producto, nom_producto, monto_producto, id_tipo_producto, ruta_imagen FROM producto WHERE id_producto = ?";
            PreparedStatement stm = cn.prepareStatement(sql);
            stm.setString(1, id_produ);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                p = new Producto(rs.getString(1), rs.getString(3), rs.getDouble(4), rs.getString(5), rs.getString(6));
                p.setDes_producto(rs.getString(2));
            }
            sql = "SELECT porcen_descuento, DAY(fec_fin_descuento), MONTH(fec_fin_descuento), YEAR(fec_fin_descuento) FROM descuento WHERE fec_ini_descuento <= CURRENT_DATE() AND fec_fin_descuento >= CURRENT_DATE() AND id_producto = ?";
            stm = cn.prepareStatement(sql);
            stm.setString(1, id_produ);
            rs = stm.executeQuery();
            if (rs.next()) {
                p.Oferta(true, rs.getDouble(1), rs.getInt(2), rs.getInt(3), rs.getInt(4));
            } else {
                p.setOferta_producto(false);
            }
        } catch (Exception e) {
            System.err.println(e.toString());
        }
        return p;
    }
}
