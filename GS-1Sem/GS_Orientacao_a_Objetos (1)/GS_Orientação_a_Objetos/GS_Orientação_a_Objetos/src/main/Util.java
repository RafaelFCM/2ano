package main;
import static javax.swing.JOptionPane.*;

import java.util.ArrayList;

import static java.lang.Integer.parseInt;

import entidades.Beneficiario;
import entidades.Funcionario;
import entidades.ListaCestasBasicas;

public class Util {

    ArrayList <Beneficiario> listaBeneficiarios = new ArrayList<>();
    
    //OK
    public void geraMenu(){
        String aux = """
                Bem Vindo(a) a ONG Alimentando Esperancas

                Digite 1 para Gerar-Ticket
                Digite 2 para Acompanhar seu pedido
                Digite 3 para Gerenciar-Ticket (apenas funcionarios)
                Digite 4 para Sair
    			
                 """;
        aux += "Número de cestas restantes: ";
        int opcao = 0;
        int quant_cestas = 0;
        
        while(opcao>=0 && opcao<4){
        	quant_cestas = ListaCestasBasicas.getQuant_cestas() - listaBeneficiarios.size();
        	String aux_inicial = aux + quant_cestas;
            opcao =  parseInt(showInputDialog(aux_inicial));
            switch (opcao) {
                case 1:
                    cadastrar();
                    break;
                case 2:
                	int id = parseInt(showInputDialog("Digite o ID do seu pedido para saber qual a situacao do seu pedido: "));
                    pesquisar(id);
                    break;
                case 3:
                	if(fazerLogin()) {
                		gerenciarTicket();                		
                	}
                    break;
                case 4:
                    opcao = -1;
                    showMessageDialog(null,"Saindo do sistema...");
                    break;
                default:
                	showMessageDialog(null, "Opcao invalida");
                	opcao = 0;
                    break;
            }
            
        }         
        
    }
	//OK
    public void cadastrar(){
        String nome = showInputDialog(null,"Digite seu nome:");
        int idade = parseInt(showInputDialog(null,"Digite sua idade"));;
        long telefone = Long.parseLong(showInputDialog(null,"Digite seu telefone"));
        String endereco = showInputDialog(null,"Digite seu endereco");
        String verificacao = "" + nome + idade + telefone + endereco;
        int id = listaBeneficiarios.size()+1;
		  boolean achou = false;
    	  for(Beneficiario necessitado: listaBeneficiarios) {
    		  String verificaNecessitado = necessitado.getNome() + necessitado.getIdade() + necessitado.getTelefone()+  necessitado.getEndereco();
    		  if(verificaNecessitado.equals(verificacao)) {
    			  showMessageDialog(null, "Seu pedido já havia sido realizado!");
    			  showMessageDialog(null, "Pedido que havia sido feito: \n"+ necessitado);
    			  showMessageDialog(null, "Nenhum pedido adicionado!");
    			  achou = true;
    			  break;
    		  }
    	  }
    	  if(achou == false) {
    		  listaBeneficiarios.add(new Beneficiario(nome, idade, telefone, endereco,id));        		
    		  showMessageDialog(null,"Ticket Gerado!");
    		  showMessageDialog(null,"Seu numero de identificacao: " + id);
    	  }
    	  
    }
    	
    //OK
      private boolean pesquisar(int id) {
    	  boolean achou = Funcionario.pesquisar(listaBeneficiarios,id);
    	  if(achou == false) {
    		  showMessageDialog(null,"Solicitacao nao encontrada!!!");
    	  }
    	  return achou;
      }
      
      //OK
      private boolean fazerLogin() {
    	  String senha;
    	  boolean isCorreta = false; 
    	  int tentativas = 0;
    	  int tentativasRestantes = 3;
    	  do{
			senha = showInputDialog("Digite a senha: (Máximo de tentativas " + (tentativasRestantes-tentativas) +")");
    		if(Funcionario.fazerLogin(senha)) {
    			isCorreta = true;
    			break;
    		}
    		tentativas++;    			
    	  }while(!Funcionario.fazerLogin(senha) && tentativas<3);
    	  return isCorreta;
      }

    //OK
    private void gerenciarTicket() {
        int opcao  = 0;
                String aux =  """
                    Bem Vindo(a) Funcionario

                    Digite 1 para Pesquisar
                    Digite 2 para Alterar
                    Digite 3 para Remover
                    Digite 4 para voltar na tela inicial

                     """;
        while(opcao>=0 && opcao<4){
            opcao =  parseInt(showInputDialog(aux));
        switch (opcao) {
            case 1:
            	int id = parseInt(showInputDialog("Digite o ID para exibir pedido:"));
                pesquisar(id);
                break;
            case 2:
                alterar();
                break;
            case 3:
                remover();
                break;
            case 4:
                showMessageDialog(null,"Voltando para tela inicial...");
                opcao= -1;
         }
        }           
    }
    
    //OK
    private void remover() {
    	int id = parseInt(showInputDialog("Digite o ID do beneficiario a ser removido ou digite 0 para voltar para o MENU:"));
    	Funcionario.remover(listaBeneficiarios, id);
    }
    
    //OK
    private void alterar() {
    	int id = parseInt(showInputDialog("Digite o ID do Beneficiario a ser alterado ou digite 0 para voltar para o MENU:"));
    	Funcionario.alterar(listaBeneficiarios,id);
    }


}

