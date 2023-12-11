/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Sarah
 */
public class ModelProduitDao {
    
    Connection con;
    Conexion cn = new Conexion();
    PreparedStatement pst;
    ResultSet rs;
    
    
    public boolean Enregistrer(ModelProduit mp){
        String sql = "insert into gestion (id, produit, categorie, quantite, prix)values "
                + "(?,?,?,?,?)";
        
        try{
            pst = cn.getConnection().prepareStatement(sql);
            pst.setString(1, mp.getId());
            pst.setString(2, mp.getNomProduit());
            pst.setString(3, mp.getCategorie());
            pst.setString(4, mp.getQuantite());
            pst.setString(5, mp.getPrix());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Produit ajouté");
            return true;
        } catch (Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage());
            return false;
        }finally{
            try{
            con.close();
            }catch (Exception e){
                e.printStackTrace();
                
            }
            
        }
    }
    
    
    public List Liste(){
        List<ModelProduit> lis = new ArrayList<>();
        String sql = "select * from gestion";
        try{
           con = cn.getConnection();
           pst = con.prepareStatement(sql);
           rs = pst.executeQuery();
           
           while (rs.next()){
               ModelProduit mo = new ModelProduit();
               mo.setId(rs.getString("id"));
               mo.setNomProduit(rs.getString("produit"));
               mo.setCategorie(rs.getString("categorie"));
               mo.setQuantite(rs.getString("quantite"));

               lis.add(mo);
           }
            }catch (Exception e){
                e.printStackTrace();
                
            }
            return lis;
    }
}
