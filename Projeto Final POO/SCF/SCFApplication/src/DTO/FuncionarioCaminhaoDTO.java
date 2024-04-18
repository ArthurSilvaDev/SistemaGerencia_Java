/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;




public class FuncionarioCaminhaoDTO {
    
    private int atCodFunc, atCodVeic;
    
    //CONSTRUTOR

    public FuncionarioCaminhaoDTO(int atCodFunc, int atCodVeic) {
        this.atCodFunc = atCodFunc;
        this.atCodVeic = atCodVeic;
    }

    
    //GET E SET
    
    public int getAtCodFunc() {
        return atCodFunc;
    }

    public void setAtCodFunc(int atCodFunc) {
        this.atCodFunc = atCodFunc;
    }

    public int getAtCodVeic() {
        return atCodVeic;
    }

    public void setAtCodVeic(int atCodVeic) {
        this.atCodVeic = atCodVeic;
    }
    
    
    
}
