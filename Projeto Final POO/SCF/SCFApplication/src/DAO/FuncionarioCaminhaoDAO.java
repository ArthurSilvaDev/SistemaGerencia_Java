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


public class FuncionarioCaminhaoDAO {
    
    public void associarFuncionarioCaminhao (int idFuncionario, int idVeiculo){
        
        try{
            
            Connection conn = ConexaoDAO.getConexaoMySQL();
            PreparedStatement ps = conn.prepareStatement("INSERT INTO FuncionarioCaminhao (atCodFunc, atCodVeic) VALUES (?,?)");
            ps.setInt(1, idFuncionario);
            ps.setInt(2, idVeiculo);
            
            ps.executeUpdate();
        }catch (SQLException ex) {
            Logger.getLogger(CaminhaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void desassociarFuncionarioCaminhao (int idFuncionario, int idVeiculo){
        
        try{
            Connection conn = ConexaoDAO.getConexaoMySQL();
            PreparedStatement ps = conn.prepareStatement("DELETE FROM FuncionarioCaminhao WHERE atCodFunc=? AND atCodVeic=?");
            ps.setInt(1, idFuncionario);
            ps.setInt(2, idVeiculo);
            
            ps.executeUpdate();            
        }catch (SQLException ex) {
            Logger.getLogger(CaminhaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ArrayList <FuncionarioDTO> buscarFuncionarioPorVeiculo (int idVeiculo){
        
        ArrayList<FuncionarioDTO> funcionarios = new ArrayList<>();
        
        try{
            
            Connection conn = ConexaoDAO.getConexaoMySQL();
            PreparedStatement ps = conn.prepareStatement("SELECT Funcionario.*, FuncionarioCaminhao.atCodVeic FROM FuncionarioCaminhao " + 
                    "INNER JOIN Funcionario ON FuncionarioCaminhao.atCodFunc=Funcionario.codFunc WHERE FuncionarioCaminhao.atCodVeic=?");
            ps.setInt(1, idVeiculo);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                FuncionarioDTO f = new FuncionarioDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
                funcionarios.add(f);
            }
            
        }catch (SQLException ex) {
            Logger.getLogger(CaminhaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return funcionarios;
    }
    
    public ArrayList <CaminhaoDTO> buscarVeiculoPorFuncionario (int idFuncionario){
        
        ArrayList<CaminhaoDTO> veiculos = new ArrayList<>();
        
        try {
            
            Connection conn = ConexaoDAO.getConexaoMySQL();
            PreparedStatement ps = conn.prepareStatement("SELECT caminhao.*, FuncionarioCaminhao.atCodFunc FROM FuncionarioCaminhao "
                    + "INNER JOIN caminhao ON FuncionarioCaminhao.atCodVeic = caminhao.codVeic WHERE FuncionarioCaminhao.atCodFunc = ?");
            ps.setInt (1, idFuncionario);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()){
                CaminhaoDTO c = new CaminhaoDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
                veiculos.add(c);
            }       
        }catch (SQLException ex) {
            Logger.getLogger(CaminhaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return veiculos;
    }
    
    
}
