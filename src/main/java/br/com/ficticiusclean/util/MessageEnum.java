package br.com.ficticiusclean.util;

public enum MessageEnum {

	ENTITY_NOT_FOUND("Não foi encontrado registro para o veículo informado.");
    
    private final String value;
    
    MessageEnum(String value){
    	this.value = value;
    }
    public String getValue(){
        return this.value;
    }
}
