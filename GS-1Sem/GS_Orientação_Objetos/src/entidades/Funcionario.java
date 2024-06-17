package entidades;

import static java.lang.Integer.parseInt;
import static javax.swing.JOptionPane.showInputDialog;
import static javax.swing.JOptionPane.showMessageDialog;

import java.util.ArrayList;

public class Funcionario {
    private static String senha= "@1234";
    
    public static boolean fazerLogin(String senha){
    	boolean loginFeito = false;
			if(Funcionario.senha.equals(senha)) {
				loginFeito = true;
			}
    	return loginFeito;
    }
    
    public static boolean pesquisar(ArrayList<Beneficiario> listaBeneficiarios,int id) {
    	boolean achou = false;
    	for(Beneficiario necessitado: listaBeneficiarios) {
    		if(necessitado.getId() == id) {
    			showMessageDialog(null, necessitado);
    			achou = true;
    			break;
    		}
    	}
		return achou;
	}
    
    public static void remover(ArrayList<Beneficiario>listaBeneficiarios,int id) {
    	if(id == 0) {
    		showMessageDialog(null, "Voltando para o menu...");         
    	}else {
    		boolean achou_Necessitado = pesquisar(listaBeneficiarios,id);
    		if(achou_Necessitado) {
    			String remove = showInputDialog("Digite \"SIM\" para remover Beneficiario e \"NAO\" para voltar para o MENU: ");
    			if(remove.equalsIgnoreCase("SIM")) {
    				for(Beneficiario beneficiario : listaBeneficiarios) {
    					if(id == beneficiario.getId()) {
    						id = listaBeneficiarios.indexOf(beneficiario);
    					}
    				}
    				int index_ultimo = listaBeneficiarios.size()-1;
    				listaBeneficiarios.set(id,listaBeneficiarios.get(index_ultimo));
    				listaBeneficiarios.remove(index_ultimo);
    				showMessageDialog(null,"Beneciario removido com sucesso!");
    			}else if(remove.equalsIgnoreCase("NAO")) {
    				showMessageDialog(null, "Beneficiario nao removido!!!");
    			}else {
    				showMessageDialog(null, "Comando invalido!");
    				showMessageDialog(null, "Voltando para o menu...");
    			}
    		}   
    	}
    }
    
    public static void alterar(ArrayList<Beneficiario>listaBeneficiarios,int id) {
    	if(id == 0) {
    		showMessageDialog(null, "Voltando para o menu...");         
    	}else {
    		boolean achou_Necessitado = pesquisar(listaBeneficiarios,id);
    		if(achou_Necessitado) {
    			String altera = showInputDialog("Digite \"SIM\" para alterar dados desse Beneficiario e \"NAO\" para voltar para o MENU: ");
    			if(altera.equalsIgnoreCase("SIM")) {
    				id--;
    	            int opcao;
    	            do {
    	            	String aux = ("*** Alterando dados do beneficiario " + listaBeneficiarios.get(id).getNome() + " ***").toUpperCase();
    	            	aux += 
    	            			"""
    	            			
    	            			
    	            			-Digite 1 para alterar o Nome
    	            			-Digite 2 para alterar a Idade
    	            			-Digite 3 para alterar o Telefone
    	            			-Digite 4 para alterar o Endereco
    	            			-Digite 5 para voltar para o Menu
    	            			
    	            			""";
    	            	opcao = parseInt(showInputDialog(aux));    	            	
    	            	switch (opcao) {
    	            	case 1: 
    	            		String nome = showInputDialog("Digite o novo nome:");
    	            		listaBeneficiarios.get(id).setNome(nome);						
    	            		break;
    	            	case 2: 
    	            		int idade = parseInt(showInputDialog("Digite a nova idade:"));
    	            		listaBeneficiarios.get(id).setIdade(idade);
    	            		break;
    	            	case 3:
    	            		long telefone = Long.parseLong(showInputDialog("Digite o novo telefone:"));
    	            		listaBeneficiarios.get(id).setTelefone(telefone);
    	            		break;
    	            	case 4:
    	            		String endereco = showInputDialog("Digite o novo endereco:");
    	            		listaBeneficiarios.get(id).setEndereco(endereco);
    	            		break;
    	            	case 5:
    	            		showMessageDialog(null, "Voltando para o menu...");
    	            		break;
    	            	default:
    	            		showMessageDialog(null, "Comando invalido!");
    	            		showMessageDialog(null, "Voltando para o menu...");
    	            	}
    	            }while(opcao>=0 && opcao<5);
    			}else if(altera.equalsIgnoreCase("NAO")) {
    				showMessageDialog(null, "Nenhum beneficiario alterado!!!");
    			}else {
    				showMessageDialog(null, "Comando invalido!");
    				showMessageDialog(null, "Voltando para o menu...");
    			}
    		}    		
    	}
    }
    
    
}








