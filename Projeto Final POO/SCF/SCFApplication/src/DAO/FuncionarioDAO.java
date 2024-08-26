/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.SQLException;
import DTO.FuncionarioDTO;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Arthu
 */
public class FuncionarioDAO {
    
    Connection conn;
    PreparedStatement pstm;
    ResultSet rs;
    
    
    
    public void cadastrarFuncionario (FuncionarioDTO f){
        conn = ConexaoDAO.getConexaoMySQL();
        try{
            pstm = conn.prepareStatement("INSERT INTO funcionario (nomeFunc, cpfFunc, cnhFunc) VALUE (?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
            pstm.setString(1, f.getNomeFunc());
            pstm.setString(2, f.getCpfFunc());
            pstm.setString(3, f.getCnhFunc());
            
            pstm.execute();
            pstm.close();
           
      
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null,"FuncionarioDAO - Cadastrar: " + erro);
        }
    }

    public ArrayList<FuncionarioDTO> PesquisarFuncionario(){
        String sql ="SELECT * FROM Funcionario";
        conn = ConexaoDAO.getConexaoMySQL();
        ArrayList<FuncionarioDTO> lista = new ArrayList<>();
        
        try{
            
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();
            
            while (rs.next()){
                
                FuncionarioDTO objfuncionariodto = new FuncionarioDTO();
                objfuncionariodto.setCodFunc(rs.getInt("codFunc"));
                objfuncionariodto.setNomeFunc(rs.getString("nomeFunc"));
                objfuncionariodto.setCpfFunc(rs.getString("cpfFunc"));
                objfuncionariodto.setCnhFunc(rs.getString("cnhFunc"));
         
                lista.add(objfuncionariodto);
            }
            conn.close();
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null,"FuncionarioDAO - Pesquisar: " + erro);
        }
        return lista;
    }
    
    public void alterarFuncionario (FuncionarioDTO f){
        
        String sql = "UPDATE funcionario SET nomeFunc=?, cpfFunc=?, cnhFunc=? WHERE codFunc=?";
        
        try{
            
            conn = ConexaoDAO.getConexaoMySQL();
            
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, f.getNomeFunc());
            pstm.setString(2, f.getCpfFunc());
            pstm.setString(3, f.getCnhFunc());
            pstm.setInt(4, f.getCodFunc());
            
            pstm.execute();
            pstm.close();
            
        }catch (SQLException erro) {
            JOptionPane.showMessageDialog(null,"FuncionarioDAO - Alterar: " + erro);
        }
        
    }
    
    
    public void excluirFuncionario (int id){
        
        String sql = "DELETE FROM funcionario WHERE codFunc=?";
        
        
        try{
            conn = ConexaoDAO.getConexaoMySQL();
            
            pstm =  conn.prepareStatement(sql);
            pstm.setInt(1, id);
            
            pstm.execute();
            pstm.close();
            
        }catch (SQLException erro) {
            JOptionPane.showMessageDialog(null,"FuncionarioDAO - Excluir: " + erro);
        }
    }
    
    public void limparTabelaCompleta(){
        
        String sql = "SET FOREIGN_KEY_CHECKS = 0";
        String sql2 = "TRUNCATE TABLE funcionario";
        
        
        
        try{
            conn = ConexaoDAO.getConexaoMySQL();
            
            pstm = conn.prepareStatement(sql);
            pstm.execute();
            
            pstm.close();
            
            pstm = conn.prepareStatement(sql2);
            pstm.execute();
            
            pstm.close();
            
////            pstm = conn.prepareStatement(sql3);
////            pstm.execute();
            
            pstm.close();
            
        }catch(SQLException erro){
            JOptionPane.showMessageDialog(null,"FuncionarioDAO - LimparTodaTabela: " + erro);
            
        }
        
    }

}
