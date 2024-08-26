/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Views.SistemaCompletoView;

/**
 *
 * @author Arthu
 */
public class TabelaCamAtualizada extends Thread {
    
     private SistemaCompletoView minhaViewLocal;
     
     public TabelaCamAtualizada(SistemaCompletoView minhaView){
         this.minhaViewLocal = minhaView;
     }
    @Override
     public void run(){
         
         minhaViewLocal.listarValoresCaminhoes();
         
                 
     }
     
}
