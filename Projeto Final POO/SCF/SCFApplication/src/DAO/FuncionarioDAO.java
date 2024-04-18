/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.FuncionarioDTO;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Arthu
 */
public class FuncionarioDAO {
    
    
    public int insert (FuncionarioDTO f){
        
        int rowCount;
        try( Connection conn = ConexaoDAO.getConexaoMySQL()){
            PreparedStatement ps = conn.prepareStatement("INSERT INTO funcionario (nomeFunc, cpfFunc, cnhFunc) VALUE (?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, f.getNomeFunc());
            ps.setString(2, f.getCpfFunc());
            ps.setString(3, f.getCnhFunc());
            rowCount = ps.executeUpdate();
            
            return  rowCount;
      
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return 0;
    }
    
    public FuncionarioDTO read (int cod){
        
        try{
            Connection conn = ConexaoDAO.getConexaoMySQL();
            PreparedStatement ps = conn.prepareStatement("SELECT * from Funcionario WHERE codFunc=?");
            ps.setInt(1, cod);
            
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
                String nome = rs.getString(2);
                String cpf = rs.getString(3);
                String cnh = rs.getString(4);
               
                
                FuncionarioDTO f = new FuncionarioDTO(cod, nome, cpf, cnh);
                return f;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public ArrayList<FuncionarioDTO> list(){
        
        ArrayList<FuncionarioDTO> minhaLista =  new ArrayList<>();
        
        try{
            Connection conn = ConexaoDAO.getConexaoMySQL();
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM Funcionario");
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()){
                int id = rs.getInt(1);
                String nome = rs.getString(2);
                String cpf = rs.getString(3);
                String cnh = rs.getString(4);
                
                FuncionarioDTO f = new FuncionarioDTO(id, nome, cpf, cnh);
                minhaLista.add(f);
            }
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return minhaLista;
    }
    
    public int update (FuncionarioDTO f){
        
        try{
            
            Connection conn = ConexaoDAO.getConexaoMySQL();
            
            PreparedStatement ps = conn.prepareStatement("UPDATE funcionario SET nomeFunc=?, cpfFunc=?, cnhFunc=? WHERE codFunc=?");
            ps.setString(1, f.getNomeFunc());
            ps.setString(2, f.getCpfFunc());
            ps.setString(3, f.getCnhFunc());
            ps.setInt(4, f.getCodFunc());
            
            int rowCount = ps.executeUpdate();
            conn.close();
            return rowCount;
            
        }catch (SQLException ex) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return 0; // EM CASO DE FALHA
    }
    
    
    public int delete (int id){
        
        try{
            Connection conn = ConexaoDAO.getConexaoMySQL();
            
            PreparedStatement ps =  conn.prepareStatement("DELETE FROM funcionario WHERE codFunc=?");
            ps.setInt(1, id);
            
            int rowCount = ps.executeUpdate();
            
            conn.close();
            
            return rowCount;
        }catch (SQLException ex) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return 0; // EM CASO DE FALHA
    }
    
}
