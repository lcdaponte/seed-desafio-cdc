package com.github.lcdaponte.desafiocasadocodigo.aplicacao.response;

public class Response<T> {
	
	private T payload;
	
	public Response() {
		
	}
	
	public Response(final T payload) {
		this.payload = payload;
	}

	public T getPayload() {
		return payload;
	}

}
