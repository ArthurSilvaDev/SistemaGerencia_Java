/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Views;
import DTO.*;
import DAO.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Arthu
 */
public class Sistema {
    
   public static void Espera() throws IOException{
   System.out.println("Aperte Enter para continuar…");
   System.in.read();
   }
    
    
    public static void main(String[] args) throws IOException {
        
        FuncionarioDAO funDAO = new FuncionarioDAO();
        CaminhaoDAO camDAO = new CaminhaoDAO();
        FuncionarioCaminhaoDAO fcDAO = new FuncionarioCaminhaoDAO();
        
        Scanner menu = new Scanner (System.in);
        
        String temp;
        int cod;
        
        while (true){
            System.out.println("""
                               \n---------> Escolha uma Opção<------ 
                               1 - Mostrar lista de Funcionarios
                               2 - Mostrar lista de Veiculos
                               3 - Cadastrar Funcionario 
                               4 - Cadastrar Veiculo 
                               5 - Alterar cadastro de Funcionario 
                               6 - Alterar cadastro do Veiculo
                               7 - Excluir Funcionario
                               8 - Excluir Veiculo
                               9 - Mostrar 1 Funcionario
                               10 - Mostrar 1 Veiculo
                               11 - Atribuir autorizacao do funcionario ao Veiculo
                               12 - Remover autorizacao do funcionario ao Veiculo
                               0 - Sair
                               -----------------------------------------------\n
                               """);
            
            
            try{
                int opcao = menu.nextInt();
                if(opcao == 0 ){
                
                System.out.println("\n Até logo!");
                menu.close();
                break;
                }
            
            
                else switch (opcao){
                    case 1:
                        System.out.println("\n Opçaõ 1 - Mostrar lista de Funcionarios\n");
                        
                        ArrayList<FuncionarioDTO> listaFuncionarios = funDAO.list();
                        
                        for(int i = 0; i<listaFuncionarios.size(); i++){
                            
                            FuncionarioDTO f = listaFuncionarios.get(i);
                            
                            System.out.println("Codigo do Funcionario: "+ f.getCodFunc());
                            System.out.println("Nome do Funcionario: "+ f.getNomeFunc());
                            System.out.println("CPF do Funcionario: "+ f.getCpfFunc());
                            System.out.println("CNH do Funcionario: "+ f.getCnhFunc());
                            System.out.println("________________________________________");
                        }
                        Espera();
                        break;

                    case 2:
                        
                        System.out.println("\n Opcao 2 - Listar veiculos\n");
                        ArrayList<CaminhaoDTO> listaCaminhao = camDAO.list();
                        
                        for(int i=0; i<listaCaminhao.size(); i++){
                            
                            CaminhaoDTO c = listaCaminhao.get(i);
                            
                            System.out.println("Id do Veiculo: " + c.getIdVeic());
                            System.out.println("Modelo do veiculo: " + c.getModVeic());
                            System.out.println("Ano do veiculo: "+ c.getAnoVeic());
                            System.out.println("Placa do Veic: " + c.getPlacaVeic());
                            System.out.println("_____________________________________");
                        }
                        Espera();
                        
                        break;

                    case 3:
                        System.out.println("Opção 3 - Cadastrar Funcionario");
                        menu.nextLine();
                        System.out.println("Digite o nome completo do Funcionario: ");
                        String nome = menu.nextLine();
                        System.out.println("Digite o CPF do Funcionario: ");
                        String cpf = menu.nextLine();
                        System.out.println("Digite a CNH do Funcionario: ");
                        String cnh = menu.nextLine();
                        
                        FuncionarioDTO novo = new FuncionarioDTO (nome, cpf, cnh);
                        if(funDAO.insert(novo) > 0){
                            System.out.println("\n Novo Funcionario Cadastrado com sucesso!");
                        }else{
                            System.out.println("Não foi possível cadastrar o funcionario.");
                        }
                        Espera();
                        break;

                    case 4:
                        
                        System.out.println("Opcao 4 - Cadastrar Veiculo");
                        
                        menu.nextLine();
                        System.out.println("Digite o MODELO do Veiculo: ");
                        String modelo = menu.nextLine();
                        System.out.println("Digite o ANO do Veiculo: ");
                        String ano = menu.nextLine();
                        System.out.println("Digite a PLACA do Veiculo: ");
                        String placa = menu.nextLine();
                        
                        CaminhaoDTO novoC = new CaminhaoDTO(modelo, ano, placa);
                        
                        if(camDAO.insert(novoC) > 0){
                            System.out.println("Caminhao cadastrado com sucesso!");
                        }else{
                            System.out.println("Falha ao cadastrar caminhao.");
                        }
                        
                        break;

                    case 5:
                        System.out.println("Opção 5 - Alterar cadastro de funcionario");
                                                menu.nextLine();
                        System.out.println("Digite o codigo do Funcionario que deseja excluir: ");
                        temp = menu.nextLine();
                        cod = Integer.parseInt(temp);
                        FuncionarioDTO f = funDAO.read(cod);
                        
                        if (f == null){
                            System.out.println("\n Funcionario nao encontrado");
                        } else{
                            System.out.println("Voce deseja alterar o nome do funcionario? 1-Sim 2-Nao");
                            temp = menu.nextLine();
                            int resp = Integer.parseInt(temp);
                            if(resp == 1){
                                System.out.println("Digite o novo nome do Funcionario: ");
                                nome = menu.nextLine();
                                f.setNomeFunc(nome);
                            }
                            System.out.println("Voce deseja alterar o CPF do funcionario? 1-Sim 2-Nao");
                            temp = menu.nextLine();
                            resp = Integer.parseInt(temp);
                            if(resp == 1){
                                System.out.println("Digite o novo CPF do funcionario: ");
                                cpf = menu.nextLine();
                                f.setCpfFunc(cpf);
                            }
                            System.out.println("Voce deseja alterar a CNH do funcionario? 1-Sim 2-Nao");
                            temp = menu.nextLine();
                            resp = Integer.parseInt(temp);
                            if(resp == 1){
                                System.out.println("Digite a nova CNH do Funcionario: ");
                                cnh = menu.nextLine();
                                f.setCnhFunc(cnh);
                            }
                            
                            if (funDAO.update(f) > 0){
                                System.out.println("\n Funcionario atualizado com sucesso!");
                            } else{
                                System.out.println("Falha ao atualizar o funcionario,");
                            } 
                        }
                        
                        
                        break;

                    case 6:
                        
                        System.out.println("\n Opcao 6 -  Alterar cadastro de veiculo");
                        System.out.println("Digite o codigo do veiculo que deseja alterar: ");
                        cod = menu.nextInt();
                        menu.nextLine();
                        CaminhaoDTO c2 = camDAO.read(cod);
                        
                        if (c2 == null){
                            System.out.println("\nVeiculo nao encontrado");
                        }else{
                            System.out.println("\nVocê deseja alterar o MODELO do veiculo? 1-Sim 2-Nao");
                            temp = menu.nextLine();
                            int resp = Integer.parseInt(temp);
                            if(resp == 1){
                                System.out.println("\nDigite o novo modelo do veiculo: ");
                                modelo = menu.nextLine();
                                c2.setModVeic(modelo);
                            }
                            System.out.println("\n Voce deseja alterar o ANO do Veiculo? 1-Sim 2-Nao");
                            temp = menu.nextLine();
                            resp = Integer.parseInt(temp);
                            if(resp == 1){
                                System.out.println("\nDigite o novo ANO do veiculo: ");
                                ano = menu.nextLine();
                                c2.setAnoVeic(ano);
                            }
                            System.out.println("\n Voce deseja alterar a PLACA do Veiculo? 1-Sim 2-Nao");
                            temp = menu.nextLine();
                            resp = Integer.parseInt(temp);
                            if(resp == 1){
                                System.out.println("\nDigite a nova PLACA do veiculo: ");
                                placa = menu.nextLine();
                                c2.setPlacaVeic(placa);
                            }
                            
                            if(camDAO.update(c2) > 0){
                                System.out.println("\nVeiculo atualizado com sucesso!");
                            }else{
                                System.out.println("Falha na atualizacao do veiculo.");
                            }
                        }
                        Espera();
                        break;

                    case 7:
                        System.out.println("Opcao 7 -  excluir funcionario");
                        
                        System.out.println("Digite o codigo do funcionario que deseja excluir: ");
                        temp = menu.next();
                        cod = Integer.parseInt(temp);
                        
                        if(funDAO.delete(cod) > 0){
                            System.out.println("\n Funcionario excluido com sucesso! ");
                        }else{
                            System.out.println("\n Nao foi possivel excluir o funcionario.");
                        }
                        break;
                    case 8:
                        
                        System.out.println("Opcao 8 - Excluir veiculo");
                        
                        System.out.println("Digite o codigo do Veiculo que deseja excluir: ");
                        cod = menu.nextInt();
                        menu.nextLine();
                        if(camDAO.delete(cod) > 0){
                            System.out.println("Veiculo excluido com sucesso!");
                        }else{
                            System.out.println("Nao foi possivel excluir o veiculo");
                        }
                        
                        
                    case 9:
                        System.out.println("Opcao 9 - Mostrar 1 Funcionario");
                        
                        System.out.println("Digite o codigo do funcionario que deseja visualizar: ");
                        cod = menu.nextInt();
                        menu.nextLine();
                        FuncionarioDTO fun = funDAO.read(cod);
                        
                        if(fun != null){
                            System.out.println("--------> Funcionario Encontrado < ---------");
                            System.out.println("Nome: " + fun.getNomeFunc());
                            System.out.println("CPF: "+ fun.getCpfFunc());
                            System.out.println("CNH: " + fun.getCnhFunc());
                            System.out.println("______________________________________");
                            
                            System.out.println("Deseja ver os veiculos que este funcionario tem acesso? 1-Sim 2-Nao");
                            temp = menu.nextLine();
                            int op = Integer.parseInt(temp);
                            
                            if(op == 1){
                                listaCaminhao = fcDAO.buscarVeiculoPorFuncionario(cod);
                                
                                for (int i = 0; i<listaCaminhao.size(); i++){
                                    CaminhaoDTO c = listaCaminhao.get(i);
                                    
                                    System.out.println("Codigo do veiculo: " + c.getIdVeic());
                                    System.out.println("Modelo do veiculo: " + c.getModVeic());
                                    System.out.println("Ano do veiculo: " + c.getAnoVeic());
                                    System.out.println("Placa do veiculo: " + c.getPlacaVeic());
                                    System.out.println("____________________________________");
                                }
                            }  
                        }else{
                            System.out.println("Funcionario nao encontrado!");
                        }
                        Espera();
                        break;
                    case 10:
                        System.out.println("Opcao 10 - Mostrar 1 Veiculo");
                        System.out.println("Digite o codigo do veiculo que deseja visualizar: ");
                        cod = menu.nextInt();
                        menu.nextLine();
                        
                        CaminhaoDTO cam = camDAO.read(cod);
                        if(cam != null){
                            System.out.println("Modelo do veiculo: " + cam.getModVeic());
                            System.out.println("Ano do veiculo: " + cam.getAnoVeic());
                            System.out.println("Placa do veiculo: " + cam.getPlacaVeic());
                            System.out.println("____________________________________");
                            
                            System.out.println("Deseja ver os motoristas que tem acesso ao veiculo? 1-Sim 2-Nao");
                            temp = menu.nextLine();
                            int op = Integer.parseInt(temp);
                            
                            if (op == 1){
                                listaFuncionarios = fcDAO.buscarFuncionarioPorVeiculo(cod);
                                for(int i=0; i<listaFuncionarios.size(); i++){
                                    f = listaFuncionarios.get(i);
                                    
                                    System.out.println("Codigo do Funcionario: " + f.getCodFunc());
                                    System.out.println("Nome do Funcionario: " + f.getNomeFunc());
                                    System.out.println("CPF do Funcionario: " + f.getCpfFunc());
                                    System.out.println("CNH do Funcionario: " + f.getCnhFunc());
                                    System.out.println("_____________________________________________");
                                    
                                    
                                }
                            }
                            
                        }else{
                            System.out.println("Veiculo nao econtrado!");
                        }
                        Espera();
                        
                        
                        break;
                    case 11: 
                        System.out.println("Opcao 11 - Atribuir autorizacao do funcionario ao Veiculo");
                        System.out.println("Digite o codigo do veiculo que deseja autorizar: ");
                        cod = menu.nextInt();
                        menu.nextLine();
                        
                        CaminhaoDTO VeicAssoci = camDAO.read(cod);
                        if( VeicAssoci != null){
                            
                            int idVeic = VeicAssoci.getIdVeic();
                            
                            System.out.println("Digite o codigo do Funcionario que deseja autorizar: ");
                            cod = menu.nextInt();
                            menu.nextLine();
                            
                            FuncionarioDTO FuncAssoci = funDAO.read(cod);
                            
                            if(FuncAssoci != null){
                                
                                int idFunc = FuncAssoci.getCodFunc();
                                
                                fcDAO.associarFuncionarioCaminhao(idFunc, idVeic);
                                System.out.println("Autorizacao Realizada com sucesso!");
                                
                            }else{
                                System.out.println("Funcionario nao encontrado!");
                                VeicAssoci = null;
                            }
                            
                            
                        }else{
                            System.out.println("Veiculo nao encontrado!");
                        }
                        Espera();
                        
                        break;
                        
                    case 12: 
                        System.out.println("Opcao 12 - Remover autorizacao do funcionario ao Veiculo");
                        
                        System.out.println("Digite o codigo do Veiculo que deseja remover as autorizacoes: ");
                        cod = menu.nextInt();
                        menu.nextLine();
                        
                        listaFuncionarios = fcDAO.buscarFuncionarioPorVeiculo(cod);
                        System.out.println("Funcionario com autorizacao ativa: ");
                        for(int i =0; i<listaFuncionarios.size(); i++){
                            FuncionarioDTO funcionario = listaFuncionarios.get(i);
                            System.out.println("Codigo: " + funcionario.getCodFunc());
                            System.out.println("Nome: " + funcionario.getNomeFunc());
                            System.out.println("CNH: " + funcionario.getCnhFunc());
                            System.out.println("CPF: " + funcionario.getCpfFunc());
                            System.out.println("_______________________________");
                        }
                        System.out.println("Quantos funcionarios deseja remover a autorizacao? ");
                        temp = menu.nextLine();
                        int qtdFunc = Integer.parseInt(temp);
                        if(qtdFunc > 0){
                            for(int i=1; i<=qtdFunc; i++){
                                System.out.println("Digite o codigo do Funcionario: ");
                                temp = menu.nextLine();
                                int codFunc = Integer.parseInt(temp);
                                fcDAO.desassociarFuncionarioCaminhao(codFunc, cod);
                            }
                            System.out.println("Autorizacao revogada com sucesso!");
                        }
                        
                        
                        break;
                    default:
                        System.out.println("\n Opcão iválida");
                        Espera();
                        break;
                }  
            }catch(InputMismatchException err){
                System.out.println("Erro! O valor digitado não é válido. O Programa será encerrado!");
                return;
            }
                        
        }
        
        
    }
    
}
