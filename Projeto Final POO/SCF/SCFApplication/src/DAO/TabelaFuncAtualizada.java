/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Views.SistemaCompletoView;
import java.util.ArrayList;

/**
 *
 * @author Arthu
 */
public class TabelaFuncAtualizada extends Thread {
    
     private SistemaCompletoView minhaViewLocal;
     
     public TabelaFuncAtualizada(SistemaCompletoView minhaView){
         this.minhaViewLocal = minhaView;
     }
    @Override
     public void run(){
         
         minhaViewLocal.listarValoresFuncionarios();
         
                 
     }
     
}
