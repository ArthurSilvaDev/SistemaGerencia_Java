/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.*;
import java.util.ArrayList;
import DTO.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class FuncionarioCaminhaoDAO {
    
    Connection conn;
    PreparedStatement pstm;
    ResultSet rs;
    
    public void cadastrarFuncionarioCaminhao (FuncionarioCaminhaoDTO objfuncionariocaminhaodto){
        
        try{
            
            conn = ConexaoDAO.getConexaoMySQL();
            pstm = conn.prepareStatement("INSERT INTO FuncionarioCaminhao (atCodFunc, atCodVeic) VALUES (?,?)");
            pstm.setInt(1, objfuncionariocaminhaodto.getAtCodFunc());
            pstm.setInt(2, objfuncionariocaminhaodto.getAtCodVeic());
            
            pstm.execute();
            pstm.close();
        }catch (SQLException erro) {
            JOptionPane.showMessageDialog(null,"FuncionarioCaminhaoDAO - Cadastrar: " + erro);
        }
        
    }
    
    
    public ArrayList<FuncionarioCaminhaoDTO> pesquisarFuncionarioCaminhao(){
        
        String sql = "SELECT * FROM FuncionarioCaminhaoView;";
        
        conn = ConexaoDAO.getConexaoMySQL();
        
        ArrayList<FuncionarioCaminhaoDTO> lista = new ArrayList<>();
        
        try {
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();
            
            while(rs.next()){
                FuncionarioCaminhaoDTO objfuncionariocaminhaodto = new FuncionarioCaminhaoDTO();
                objfuncionariocaminhaodto.setAtCodFunc(rs.getInt("atCodFunc"));
                objfuncionariocaminhaodto.setAtCodVeic(rs.getInt("atCodVeic"));
                objfuncionariocaminhaodto.setAtModVeic(rs.getString("placaVeic"));
                objfuncionariocaminhaodto.setAtNomeFunc(rs.getString("nomeFunc"));
                
                lista.add(objfuncionariocaminhaodto);
            }
            
        } catch (SQLException erro) {
            
            JOptionPane.showMessageDialog(null,"FuncionarioCaminhaoDAO - Listar: " + erro);
            
        }
        return lista;
    }
    
    
    
    
    public void ExcluirFuncionarioCaminhao (int idFuncionario, int idVeiculo){
        
        try{
            conn = ConexaoDAO.getConexaoMySQL();
            pstm = conn.prepareStatement("DELETE FROM FuncionarioCaminhao WHERE atCodFunc=? AND atCodVeic=?");
            pstm.setInt(1, idFuncionario);
            pstm.setInt(2, idVeiculo);
            
            pstm.execute();
            pstm.close();
        }catch (SQLException ex) {
            Logger.getLogger(CaminhaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
//    
//    public ArrayList <FuncionarioDTO> buscarFuncionarioPorVeiculo (int idVeiculo){
//        
//        ArrayList<FuncionarioDTO> funcionarios = new ArrayList<>();
//        
//        try{
//            
//            Connection conn = ConexaoDAO.getConexaoMySQL();
//            PreparedStatement ps = conn.prepareStatement("SELECT Funcionario.*, FuncionarioCaminhao.atCodVeic FROM FuncionarioCaminhao " + 
//                    "INNER JOIN Funcionario ON FuncionarioCaminhao.atCodFunc=Funcionario.codFunc WHERE FuncionarioCaminhao.atCodVeic=?");
//            ps.setInt(1, idVeiculo);
//            ResultSet rs = ps.executeQuery();
//            
//            while(rs.next()){
//                FuncionarioDTO f = new FuncionarioDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
//                funcionarios.add(f);
//            }
//            
//        }catch (SQLException ex) {
//            Logger.getLogger(CaminhaoDAO.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return funcionarios;
//    }
//    
//    public ArrayList <CaminhaoDTO> buscarVeiculoPorFuncionario (int idFuncionario){
//        
//        ArrayList<CaminhaoDTO> veiculos = new ArrayList<>();
//        
//        try {
//            
//            Connection conn = ConexaoDAO.getConexaoMySQL();
//            PreparedStatement ps = conn.prepareStatement("SELECT caminhao.*, FuncionarioCaminhao.atCodFunc FROM FuncionarioCaminhao "
//                    + "INNER JOIN caminhao ON FuncionarioCaminhao.atCodVeic = caminhao.codVeic WHERE FuncionarioCaminhao.atCodFunc = ?");
//            ps.setInt (1, idFuncionario);
//            ResultSet rs = ps.executeQuery();
//            
//            while (rs.next()){
//                CaminhaoDTO c = new CaminhaoDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
//                veiculos.add(c);
//            }       
//        }catch (SQLException ex) {
//            Logger.getLogger(CaminhaoDAO.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return veiculos;
//    }
    
    
}
