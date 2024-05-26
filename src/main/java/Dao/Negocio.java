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

    public List<Producto> listMasVendidos() {
        List<Producto> lista = new ArrayList();
        try {
            Producto pro;
            Connection cn = new MySQLConexion().getConexion();
            String sql = "SELECT p.id_producto, p.nom_producto, SUM(bp.cant) cantidad FROM producto p join boleta_producto bp on p.id_producto = bp.id_producto group by p.id_producto order by cantidad desc limit 1,8";
            PreparedStatement stm = cn.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                pro = new Producto(rs.getString(1), rs.getString(2), rs.getInt(3));
                lista.add(pro);
            }
        } catch (Exception e) {
            System.err.println(e.toString());
        }
        return lista;
    }

    public List<Producto> listMasCaros() {
        List<Producto> lista = new ArrayList();
        try {
            Producto pro;
            Connection cn = new MySQLConexion().getConexion();
            String sql = "SELECT id_producto , nom_producto, monto_producto FROM producto ORDER BY producto.monto_producto DESC LIMIT 1,8";
            PreparedStatement stm = cn.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                pro = new Producto(rs.getString(1), rs.getString(2), rs.getDouble(3));
                lista.add(pro);
            }
        } catch (Exception e) {
            System.err.println(e.toString());
        }
        return lista;
    }

    public List<Boleta_Cliente> listVentaEdad() {
        List<Boleta_Cliente> lista = new ArrayList();
        try {
            Boleta_Cliente bc;
            Connection cn = new MySQLConexion().getConexion();
            String sql = "SELECT c.edad_cliente edad, SUM(b.monto_tot_boleta) TOT FROM boleta b join cliente c on b.id_cliente=c.id_cliente GROUP BY edad ORDER BY edad DESC LIMIT 1,8";
            PreparedStatement stm = cn.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                bc = new Boleta_Cliente(rs.getInt(1), rs.getDouble(2));
                lista.add(bc);
            }
        } catch (Exception e) {
            System.err.println(e.toString());
        }
        return lista;
    }

    public List<Cliente> getClientes() {
        List<Cliente> lista = new ArrayList();
        try {
            Connection cn = new MySQLConexion().getConexion();
            String sql = "SELECT id_cliente, nom_cliente, ape_cliente, telf_cliente FROM cliente";
            PreparedStatement stm = cn.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Cliente c = new Cliente();
                c.setDni_cliente(rs.getString(1));
                c.setNom_cliente(rs.getString(2));
                c.setApe_cliente(rs.getString(3));
                c.setEdad_cliente(rs.getInt(4));
                c.setTelf_cliente(rs.getString(4));
                lista.add(c);
            }
        } catch (Exception e) {
            System.err.println(e.toString());
        }

        return lista;
    }

    public List<Direccion> getDirecciones(String clienteID) {
        List<Direccion> lista = new ArrayList();
        try {
            Connection cn = new MySQLConexion().getConexion();
            String sql = "SELECT id_direccion, nom_com_direccion, dni_direccion, telf_direccion, dir_direccion, ref_direccion FROM direccion WHERE id_cliente = ?";
            PreparedStatement stm = cn.prepareStatement(sql);
            stm.setString(1, clienteID);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Direccion c = new Direccion();
                c.setId_direccion(rs.getString(1));
                c.setNom_com_direccion(rs.getString(2));
                c.setDni_direccion(rs.getString(3));
                c.setTelf_direccion(rs.getString(4));
                c.setDir_direccion(rs.getString(5));
                c.setRef_direccion(rs.getString(6));
                lista.add(c);
            }
        } catch (Exception e) {
            System.err.println(e.toString());
        }

        return lista;
    }

    public boolean updateDireccion(Direccion dir) {
        boolean estado = false;
        try {
            Connection cn = new MySQLConexion().getConexion();
            String sql = "UPDATE direccion SET nom_com_direccion = ?, dni_direccion = ?, telf_direccion = ?, dir_direccion = ?, ref_direccion = ? where id_direccion = ?";
            PreparedStatement stm = cn.prepareStatement(sql);
            stm.setString(1, dir.getNom_com_direccion());
            stm.setString(2, dir.getDni_direccion());
            stm.setString(3, dir.getTelf_direccion());
            stm.setString(4, dir.getDir_direccion());
            stm.setString(5, dir.getRef_direccion());
            stm.setString(6, dir.getId_direccion());
            if (stm.executeUpdate() > 0) {
                estado = true;
            }
            cn.close();
        } catch (Exception e) {
            System.err.println(e.toString());
        }
        
        return estado;
    }
}
