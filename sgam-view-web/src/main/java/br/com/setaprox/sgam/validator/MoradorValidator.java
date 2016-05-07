package br.com.setaprox.sgam.validator;

import br.com.caelum.vraptor.validator.Validator;
import br.com.setaprox.sgam.model.Morador;

public class MoradorValidator {
	private Validator validator;
	
	public MoradorValidator(Validator validator){
		this.validator = validator;
	}
	
	public void validate(Morador morador){
		validator.validate(morador);
	}
	
	public <T> T onErrorRedirectTo(T controller) {
		return validator.onErrorRedirectTo(controller);
	}
}
