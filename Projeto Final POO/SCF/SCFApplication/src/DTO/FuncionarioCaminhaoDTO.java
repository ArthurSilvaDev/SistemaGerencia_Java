/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;




public class FuncionarioCaminhaoDTO {
    
    private int atCodFunc, atCodVeic;
    private String atNomeFunc, atModVeic;
    
    //CONSTRUTOR

//    public FuncionarioCaminhaoDTO(int atCodFunc, int atCodVeic) {
//        this.atCodFunc = atCodFunc;
//        this.atCodVeic = atCodVeic;
//    }

   

    
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
    
     public String getAtNomeFunc() {
        return atNomeFunc;
    }

    public void setAtNomeFunc(String atNomeFunc) {
        this.atNomeFunc = atNomeFunc;
    }

    public String getAtModVeic() {
        return atModVeic;
    }

    public void setAtModVeic(String atModVeic) {
        this.atModVeic = atModVeic;
    }
    
    
}
