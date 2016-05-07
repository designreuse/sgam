package br.com.setaprox.sgam.converter;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import br.com.caelum.vraptor.Convert;
import br.com.caelum.vraptor.converter.Converter;
import br.com.setaprox.sgam.DAO.FornecedorDAO;
import br.com.setaprox.sgam.model.Fornecedor;

@Convert(Fornecedor.class)
@ApplicationScoped
public class FornecedorConverter implements Converter<Fornecedor> {

	@Inject
	private FornecedorDAO fornecedorDAO;
	
	@Override
	public Fornecedor convert(String value, Class<? extends Fornecedor> type) {
		if(value != null && !value.isEmpty()){
			try {
				return fornecedorDAO.find(Long.parseLong(value));
			} catch (NumberFormatException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return new Fornecedor();
	}

}
