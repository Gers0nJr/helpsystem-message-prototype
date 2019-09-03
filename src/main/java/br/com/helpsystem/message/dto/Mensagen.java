package br.com.helpsystem.message.dto;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "mensagens")
public class Mensagen {

	private String texto;
	private String de;
	private String para;
	private String dataHora;
	private int totalMsg;

	public String getTexto() {
		return texto;
	}
	
	public void setTexto(String texto) {
		this.texto = texto;
	}
	
	public String getDe() {
		return de;
	}
	
	public void setDe(String de) {
		this.de = de;
	}
	
	public String getPara() {
		return para;
	}
	
	public void setPara(String para) {
		this.para = para;
	}

	public String getDataHora() {
		return dataHora;
	}

	public void setDataHora(String dataHora) {
		this.dataHora = dataHora;
	}

	public int getTotalMsg() {
		return totalMsg;
	}

	public void setTotalMsg(int totalMsg) {
		this.totalMsg = totalMsg;
	}
}