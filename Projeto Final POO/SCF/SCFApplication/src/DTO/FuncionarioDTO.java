/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author Arthu
 */
public class FuncionarioDTO {
    
    private int codFunc;
    private String nomeFunc;
    private String cpfFunc;
    private String cnhFunc;
    
    // Construtores

    public FuncionarioDTO(int codFunc, String nomeFunc, String cpfFunc, String cnhFunc) {
        this.codFunc = codFunc;
        this.nomeFunc = nomeFunc;
        this.cpfFunc = cpfFunc;
        this.cnhFunc = cnhFunc;
    }

    public FuncionarioDTO(String nomeFunc, String cpfFunc, String cnhFunc) {
        this.nomeFunc = nomeFunc;
        this.cpfFunc = cpfFunc;
        this.cnhFunc = cnhFunc;
    }
    
    //GET E SET

    public int getCodFunc() {
        return codFunc;
    }

    public void setCodFunc(int codFunc) {
        this.codFunc = codFunc;
    }

    public String getNomeFunc() {
        return nomeFunc;
    }

    public void setNomeFunc(String nomeFunc) {
        this.nomeFunc = nomeFunc;
    }

    public String getCpfFunc() {
        return cpfFunc;
    }

    public void setCpfFunc(String cpfFunc) {
        this.cpfFunc = cpfFunc;
    }

    public String getCnhFunc() {
        return cnhFunc;
    }

    public void setCnhFunc(String cnhFunc) {
        this.cnhFunc = cnhFunc;
    }
    
    
    
    
    
    
}
