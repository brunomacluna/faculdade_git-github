package ufpb.dcx.aula.perguntaserespostas.jwt.dtos;

import lombok.Data;

@Data
public class RespostaDTO {
	private String texto;

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}
	
	
}
