package Modelo;

public class CategoriaProdu {
    String id_cate;
    String nom_cate;

    public CategoriaProdu(String id_cate, String nom_cate) {
        this.id_cate = id_cate;
        this.nom_cate = nom_cate;
    }
    
    public String getId_cate() {
        return id_cate;
    }

    public void setId_cate(String id_cate) {
        this.id_cate = id_cate;
    }

    public String getNom_cate() {
        return nom_cate;
    }

    public void setNom_cate(String nom_cate) {
        this.nom_cate = nom_cate;
    }
}
