
package DAO;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import DTO.CaminhaoDTO;
import javax.swing.JOptionPane;
import java.sql.SQLException;


public class CaminhaoDAO {
    
    Connection conn;
    PreparedStatement pstm;
    ResultSet rs;
    
    public void cadastrarCaminhao (CaminhaoDTO c){
        
        
        
        try{
            conn = ConexaoDAO.getConexaoMySQL();
            pstm = conn.prepareStatement("INSERT INTO Caminhao (modVeic, anoVeic, placaVeic) VALUE (?,?,?)");
            pstm.setString(1, c.getModVeic());
            pstm.setString(2, c.getAnoVeic());
            pstm.setString(3, c.getPlacaVeic());
            
            pstm.execute();
            pstm.close();
            
        
        
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null,"CaminhaoDAO - Cadastrar: " + erro);
        }
    }
//    
//    public CaminhaoDTO read (int codVeic){
//        
//        try{
//            Connection conn = ConexaoDAO.getConexaoMySQL();
//            PreparedStatement ps = conn.prepareStatement("SELECT * FROM caminhao WHERE codVeic=?");
//            ps.setInt(1, codVeic);
//            ResultSet rs = ps.executeQuery();
//            
//            if(rs.next()){
//                int id = rs.getInt(1);
//                String modelo = rs.getString(2);
//                String ano = rs.getString(3);
//                String placa = rs.getString(4);
//                CaminhaoDTO c =  new CaminhaoDTO(id, modelo, ano, placa);
//                
//                return c;
//            }
//            
//            
//        }catch (SQLException ex) {
//            Logger.getLogger(CaminhaoDAO.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return null;
//    }
//    
//    
    public ArrayList<CaminhaoDTO> PesquisarCaminhao(){
        
        ArrayList<CaminhaoDTO> minhaLista =  new ArrayList<>();
        
        try{
            conn =  ConexaoDAO.getConexaoMySQL();
            pstm = conn.prepareStatement("SELECT * FROM caminhao");
            rs = pstm.executeQuery();
            
            while(rs.next()){
                CaminhaoDTO objcaminhaodto = new CaminhaoDTO();
                objcaminhaodto.setIdVeic(rs.getInt("codVeic"));
                objcaminhaodto.setModVeic(rs.getString("modVeic"));
                objcaminhaodto.setAnoVeic(rs.getString("anoVeic"));
                objcaminhaodto.setPlacaVeic(rs.getString("placaVeic"));
                
                
                minhaLista.add(objcaminhaodto);
                
            }
            
        }catch (SQLException erro) {
            JOptionPane.showMessageDialog(null,"CaminhaoDAO - Pesquisar: " + erro);
        }
        
        return minhaLista;
        
    }
    
    public void alterarCaminhao (CaminhaoDTO c){
        
        conn = ConexaoDAO.getConexaoMySQL();
        try{
            
          
            
            pstm = conn.prepareStatement("UPDATE caminhao SET modVeic=?, anoVeic=?, placaVeic=? WHERE codVeic=?");
            pstm.setString(1, c.getModVeic());
            pstm.setString(2, c.getAnoVeic());
            pstm.setString(3, c.getPlacaVeic());
            pstm.setInt(4, c.getIdVeic());
            pstm.executeUpdate();
            pstm.close();
            
            
        }catch (SQLException erro) {
            JOptionPane.showMessageDialog(null,"CaminhaoDAO - Alterar: " + erro);
        }
    }
    
    public void excluirCaminhao (int codVeic){
        
        try{
            conn = ConexaoDAO.getConexaoMySQL();
            pstm = conn.prepareStatement("DELETE FROM caminhao WHERE codVeic=?");
            pstm.setInt(1, codVeic);
            pstm.executeUpdate();
            pstm.close();
            
            
        }catch (SQLException erro) {
            JOptionPane.showMessageDialog(null,"CaminhaoDAO - Excluir: " + erro);
        }
       
    }
    
    
}
