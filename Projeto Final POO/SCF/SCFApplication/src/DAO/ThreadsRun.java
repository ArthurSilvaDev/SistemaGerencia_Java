
package DAO;

import Views.SistemaCompletoView;
import java.lang.*;

public class ThreadsRun {
    
     public void executarNovaThread (Runnable tarefa){
         new Thread(tarefa).start();
     }
}
