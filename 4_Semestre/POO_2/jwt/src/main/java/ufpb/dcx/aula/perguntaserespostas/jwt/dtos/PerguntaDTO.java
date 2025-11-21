package ufpb.dcx.aula.perguntaserespostas.jwt.dtos;

import java.util.Arrays;
import java.util.List;

import lombok.Data;

@Data
public class PerguntaDTO {
	private String texto;
	private String palavrasChave;
	private String separador = ",";
	
	public List<String> extraiPalavrasChave() {
		return Arrays.asList(palavrasChave.split(separador));
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public String getPalavrasChave() {
		return palavrasChave;
	}

	public void setPalavrasChave(String palavrasChave) {
		this.palavrasChave = palavrasChave;
	}

	public String getSeparador() {
		return separador;
	}

	public void setSeparador(String separador) {
		this.separador = separador;
	}
	
	
}
