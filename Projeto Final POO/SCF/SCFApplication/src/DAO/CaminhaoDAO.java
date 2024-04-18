
package DAO;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import DTO.CaminhaoDTO;

public class CaminhaoDAO {
    
    public int insert (CaminhaoDTO c){
        
        try{
            int rowCount;
            Connection conn = ConexaoDAO.getConexaoMySQL();
            PreparedStatement ps = conn.prepareStatement("INSERT INTO Caminhao (modVeic, anoVeic, placaVeic) VALUE (?,?,?)");
            ps.setString(1, c.getModVeic());
            ps.setString(2, c.getAnoVeic());
            ps.setString(3, c.getPlacaVeic());
            
            rowCount = ps.executeUpdate();
            
            return rowCount;
        
        
        } catch (SQLException ex) {
            Logger.getLogger(CaminhaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0; // FALHOU
    }
    
    public CaminhaoDTO read (int codVeic){
        
        try{
            Connection conn = ConexaoDAO.getConexaoMySQL();
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM caminhao WHERE codVeic=?");
            ps.setInt(1, codVeic);
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
                int id = rs.getInt(1);
                String modelo = rs.getString(2);
                String ano = rs.getString(3);
                String placa = rs.getString(4);
                CaminhaoDTO c =  new CaminhaoDTO(id, modelo, ano, placa);
                
                return c;
            }
            
            
        }catch (SQLException ex) {
            Logger.getLogger(CaminhaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    
    public ArrayList<CaminhaoDTO> list(){
        
        ArrayList<CaminhaoDTO> minhaLista =  new ArrayList<>();
        
        try{
            Connection conn =  ConexaoDAO.getConexaoMySQL();
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM caminhao");
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                int id = rs.getInt(1);
                String modelo = rs.getString(2);
                String ano = rs.getString(3);
                String placa = rs.getString(4);
                CaminhaoDTO c =  new CaminhaoDTO(id, modelo, ano, placa);
                
                minhaLista.add(c);
                
            }
            
        }catch (SQLException ex) {
            Logger.getLogger(CaminhaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return minhaLista;
        
    }
    
    public int update (CaminhaoDTO c){
        
        try{
            
            int rowCount;
            Connection conn = ConexaoDAO.getConexaoMySQL();
            PreparedStatement ps = conn.prepareStatement("UPDATE caminhao SET modVeic=?, anoVeic=?, placaVeic=? WHERE codVeic=?");
            ps.setString(1, c.getModVeic());
            ps.setString(2, c.getAnoVeic());
            ps.setString(3, c.getPlacaVeic());
            ps.setInt(4, c.getIdVeic());
            rowCount = ps.executeUpdate();
            
            return rowCount;
            
        }catch (SQLException ex) {
            Logger.getLogger(CaminhaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    
    public int delete (int codVeic){
        
        try{
            int rowCount;
            Connection conn = ConexaoDAO.getConexaoMySQL();
            PreparedStatement ps = conn.prepareStatement("DELETE FROM caminhao WHERE codVeic=?");
            ps.setInt(1, codVeic);
            rowCount = ps.executeUpdate();
            
            return rowCount;
            
        }catch (SQLException ex) {
            Logger.getLogger(CaminhaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return 0;// EM CASO DE FALHA
    }
    
    
}
