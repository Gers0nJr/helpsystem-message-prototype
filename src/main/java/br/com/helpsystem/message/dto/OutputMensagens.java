package br.com.helpsystem.message.dto;

public class OutputMensagens {

	private String texto;
	private String de;
	private String para;
	private String dataHora;
	
	public OutputMensagens(String texto, String de, String para, String dataHora) {
		
		this.texto = texto;
		this.de = de;
		this.para = para;
		this.dataHora = dataHora;
		
	}
	
	public String getTexto() {
		return texto;
	}
	
	public String getDe() {
		return de;
	}
	
	public String getPara() {
		return para;
	}

	public String getDataHora() {
		return dataHora;
	}
}