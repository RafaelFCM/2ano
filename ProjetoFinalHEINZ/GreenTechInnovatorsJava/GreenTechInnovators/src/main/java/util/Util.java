package util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class Util {
	
	public String formatarData(String dataString) {
		String[] aux = dataString.split("-");
		dataString = "";
		dataString = aux[2] + "/" + aux[1] + "/" + aux[0];
//		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
//		LocalDate data = LocalDate.parse(dataString, formato);
		return dataString;
	}
	
	public String dataHoje() {
		LocalDate dataAtual = LocalDate.now();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String dataFormatada = dataAtual.format(formato);
//        LocalDate data = LocalDate.parse(dataFormatada, formato);
		return dataFormatada;
	}
	
	public int gerarIdProtocolo() {
		Random random = new Random();
	    int idProtocolo;
	    idProtocolo = random.nextInt(990001) + 10000;
		return idProtocolo;
	}
}
