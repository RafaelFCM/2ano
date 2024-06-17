package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import conexao.Conexao;
import entidade.Colaboracoes;

public class ColaboracoesDAO {
	// definicao das variaveis para manipular os dados do banco
		private PreparedStatement ps;
		private ResultSet rs;
		private String sql;
		private Conexao conexao;

		public ColaboracoesDAO() {
			conexao = new Conexao();
		}

		// metodo para pesquisar um colaboracao pelo ID
//		public Colaboracoes pesquisar(int id) {
//			Colaboracoes colaboracoes = null;
//			sql = "select id_protocolo, data_colaboracao, nota_avaliacao, tema_colaboracao, id_cliente"
//					+ "as clientes from gti_colaboracoes";
//			//tentei de tudo e nao ta indo, nao consigo fazer com que apareca as infos do cliente 
//			//no pesquisar e listar das colaboracoes
//			
//			try(Connection connection = conexao.conectar()) {
//				ps = connection.prepareStatement(sql);
//				ps.setInt(1, id);
//				rs = ps.executeQuery();
//				if(rs.next()) {
//					int id_protocolo = rs.getInt("id_protocolo");
//					String data_colaboracao = rs.getString("data_colaboracao");
//					String nota_avaliacao = rs.getString("nota_avaliacao");
//					String tema_colaboracao = rs.getString("tema_colaboracao");
//					String texto_colaboracao = rs.getString("texto_colaboracao");
//					int id_cliente = rs.getInt("clientes");
//					Clientes clientes = new Clientes(id_cliente, null, null, null, null, null);
//					colaboracoes = new Colaboracoes(id_protocolo, data_colaboracao, nota_avaliacao, tema_colaboracao, texto_colaboracao, clientes);
//				}
//				rs.close();
//				ps.close();
//				connection.close();
//			} catch (SQLException e) {
//				System.out.println("Erro ao pesquisar colaboracoes\n" + e);
//			}		
//			return colaboracoes;
//		}

		// metodo para inserir um colaboracoes na base de dados
		public void inserir(Colaboracoes colaboracoes) {
			sql = "insert into gti values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

			try(Connection connection = conexao.conectar()) {
				ps = connection.prepareStatement(sql);
				ps.setString(1, colaboracoes.getNome());
				ps.setString(2, colaboracoes.getEmail());
				ps.setString(3, colaboracoes.getTelefone());
				ps.setString(4, colaboracoes.getData_nascimento());
				ps.setInt(5, colaboracoes.getId_protocolo());
				ps.setString(6, colaboracoes.getData_colaboracao());
				ps.setInt(7, colaboracoes.getNota_avaliacao());
				ps.setString(8, colaboracoes.getTema_colaboracao());
				ps.setString(9, colaboracoes.getTexto_colaboracao());
				ps.setString(10, colaboracoes.getCep());
				ps.setString(11, colaboracoes.getRua());
				ps.setString(12, colaboracoes.getBairro());
				ps.setString(13, colaboracoes.getEstado());
				ps.setString(14, colaboracoes.getCidade());
				ps.execute();
				ps.close();
				connection.close();
			} catch (SQLException e) {
				System.out.println("Erro ao inserir colaboracoes\n" + e);
			}		
			
		}

//		// metodo para remover um colaboracoes pelo seu ID
//		public void remover(int id) {
//			sql = "delete from gti_colaboracoes where id_protocolo = ?";
//			
//			try(Connection connection = conexao.conectar()) {
//				ps = connection.prepareStatement(sql);
//				ps.setInt(1, id);
//				ps.execute();
//				ps.close();
//				connection.close();
//			} catch (SQLException e) {
//				System.out.println("Erro ao pesquisar colaboracoes\n" + e);
//			}		
//		}
//		
//		// metodo para listar todos os colaboracoess do banco de dados
//		public List<Colaboracoes> listar() {
//			List<Colaboracoes> lista = new ArrayList<>();
//			sql = "select id_protocolo, data_colaboracao, nota_avaliacao, tema_colaboracao, id_cliente as clientes "
//					+ "from gti_colaboracoes order by id_protocolo";
//			
//			try(Connection connection = conexao.conectar()) {
//				ps = connection.prepareStatement(sql);
//				rs = ps.executeQuery();
//				while(rs.next()) {
////					int id_protocolo = rs.getInt("id_protocolo");
////					String data_colaboracao = rs.getString("data_colaboracao");
////					int nota_avaliacao = rs.getInt("nota_avaliacao");
////					int tema_colaboracao = rs.getInt("tema_colaboracao");
//					int idCliente = rs.getInt("clientes");
//					Clientes clientes = new Clientes(idCliente, null, null, null, null, null);
////					Colaboracoes colaboracoes = new Colaboracoes(id_protocolo, data_colaboracao, nota_avaliacao, tema_colaboracao, clientes);
////					lista.add(colaboracoes);
//					lista.add(new Colaboracoes(rs.getInt("id_protocolo"), rs.getString("data_colaboracao"), rs.getString("nova_avaliacao"), rs.getString("tema_colaboracao"), rs.getString("texto_colaboracao"), clientes));
//					
//				}			
//				rs.close();
//				ps.close();
//				connection.close();
//			} catch (SQLException e) {
//				System.out.println("Erro ao listar colaboracoes\n" + e);
//			}
//			return lista;
//		}
//
//		// metodo para atualizar os dados do colaboracoes pelo ID
//		public void atualizar(Colaboracoes colaboracoes) {
//			sql = "update gti_colaboracoes set data_colaboracao = ?, nota_avaliacao = ?, tema_colaboracao = ?, texto_colaboracao = ? where id_protocolo = ?";
//			
//			try(Connection connection = conexao.conectar()) {
//				ps = connection.prepareStatement(sql);
//				ps.setString(1, colaboracoes.getData_colaboracao());
//				ps.setString(2, colaboracoes.getNota_avaliacao());
//				ps.setString(3, colaboracoes.getTema_colaboracao());
//				ps.setString(4, colaboracoes.getTexto_colaboracao());
//				ps.setInt(5, colaboracoes.getId_protocolo());
//				ps.execute();
//				ps.close();
//				connection.close();
//			} catch (SQLException e) {
//				System.out.println("Erro ao pesquisar colaboracoes\n" + e);
//			}	
//			
//		}
}
