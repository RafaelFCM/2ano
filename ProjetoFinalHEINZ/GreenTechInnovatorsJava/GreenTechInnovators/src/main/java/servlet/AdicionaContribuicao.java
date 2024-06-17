package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidade.Colaboracoes;
import dao.ColaboracoesDAO;
import util.Util;

/**
 * Servlet implementation class AgendaServlet
 */

// url maping vai no action=" " do form
//localhost:8080/ContextRoot/URLMap
//REQUISI��O: method=" "
//GET - dados aparecem na url do navegador
//POST - dados ficam no fim da pag

@WebServlet("/AdicionaContribuicao")
public class AdicionaContribuicao extends HttpServlet{
	private static final long serialVersionUID = 1L; 

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdicionaContribuicao() {
		super();
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		String telefone = request.getParameter("celular");
		String dataNasc = request.getParameter("dataNasc");
		String cep = request.getParameter("cep");
		String rua = request.getParameter("rua");
		String bairro = request.getParameter("bairro");
		String estado = request.getParameter("estado");
		String cidade = request.getParameter("cidade");
		String assunto = request.getParameter("assunto");
		String nota = request.getParameter("nota");
		String mensagem = request.getParameter("mensagem");
		
		Util util = new Util(); 
		
		String dataColab = util.dataHoje();
		
		int notaInt = Integer.parseInt(nota);
		
		ColaboracoesDAO daoColab = new ColaboracoesDAO();
		
		String dataNascForma = util.formatarData(dataNasc);
		
		int idProtocolo = util.gerarIdProtocolo();
		
		Colaboracoes colaboracoes = new Colaboracoes(nome, email, telefone, dataNascForma, idProtocolo, dataColab, notaInt, assunto, mensagem, cep, rua, bairro, estado, cidade);
		
		daoColab.inserir(colaboracoes);
		/*
		*essa forma seria igual a do professor, onde nao tem constructor e usa sequence, pois se usar sequence nao da pra usar constructor
		*entao fiz do meu jeito, no util fiz um gerador de id protocolo
		colaboracoes.setNome(request.getParameter("nome"));
		colaboracoes.setEmail(request.getParameter("email"));
		colaboracoes.setTelefone(request.getParameter("celular"));
		colaboracoes.setDataNascimento(dataNasc);
		colaboracoes.setData_colaboracao(dataColab);
		colaboracoes.setCep(request.getParameter("cep"));
		colaboracoes.setRua(request.getParameter("rua"));
		colaboracoes.setBairro(request.getParameter("bairro"));
		colaboracoes.setEstado(request.getParameter("estado"));
		colaboracoes.setCidade(request.getParameter("cidade"));
		colaboracoes.setTema_colaboracao(request.getParameter("assunto"));
		colaboracoes.setNota_avaliacao(notaInt);
		colaboracoes.setTexto_colaboracao(request.getParameter("mensagem"));
		*/
		
//		response.sendRedirect("html/cadastrado.html");
		
		
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>"
				+ "<html lang=pt-BR>"
				+ "<head>"
				+ "    <meta charset=UTF-8>"
				+ "    <meta name=viewport content=width=device-width, initial-scale=1.0>"
				+ "    <title>GreenTech Innovators</title>"
				+ "    <link rel='stylesheet' href='../css/cadastrado.css'>"
				+ "    <link href=https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css rel=stylesheet"
				+ "        integrity=sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6fzT crossorigin=anonymous>"
				+ "    <link rel=stylesheet href=https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css"
				+ "        integrity=sha512-KfkfwYDsLkIlwQp6LFnl8zNdLGxu9YAA1QvwINks4PhcElQSvqcyVLLD9aMhXd13uQjoXtEKNosOWaZqXgel0g=="
				+ "        crossorigin=anonymous referrerpolicy=no-referrer/>"
				+ "    <link rel=preconnect href=https://fonts.googleapis.com>"
				+ "    <link rel=preconnect href=https://fonts.gstatic.com crossorigin>"
				+ "    <link href=https://fonts.googleapis.com/css2?family=PlayfairDisplay&family=Poppins:wght@300;400;500;700;800;900&display=swap rel=stylesheet>"
				+ "</head>"
				
				+ "<style>"
				+ ":root {"
				+ "    --fonte-titulo: playfair display;"
				+ "    --fonte-texto: poppins;"
				+ "}"
				+ "* {"
				+ "    margin: 0;"
				+ "    padding: 0;"
			+ "    border: 0;"
				+ "    outline: none;"
				+ "    box-sizing: border-box;"
			+ "}"
			+ "body {"
			+ "    height: 100vh;"
			+ "    display: flex;"
			+ "    justify-content: center;"
			+ "    align-items: start;"
			+ "    background-image: url(images/logo.webp);"
				+ "    background-position: center;"
			+ "    background-repeat: no-repeat;"
				+ "}"
				+ "h1, h2 {"
				+ "    font-size: 2em;"
				+ "    font-family: var(--fonte-texto);"
				+ "    font-weight: lighter;"
			+ "}"
			+ ".texto {"
			+ "    margin-top: 10em;"
			+ "}"
			+ "</style>"
				
				+ "<body>"
				+ "    <section >"
				+ "        <div class = 'texto'>"
				+ "				<h1>Formulario enviado com sucesso. Obrigado!</h1>"
			+ "            	<h2>Numero de protocolo da sua colaboracao: "+idProtocolo+"</h2>"
			+ "			</div>"
			+ "		</section>"
			
			+ "    <script src=https://kit.fontawesome.com/1ebd5955d5.js crossorigin=anonymous></script>"
			+ "</body>"
			+ "</html>"
				
	);
	}
}
