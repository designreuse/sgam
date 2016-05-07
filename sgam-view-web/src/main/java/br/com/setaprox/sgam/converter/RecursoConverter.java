package br.com.setaprox.sgam.converter;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import br.com.caelum.vraptor.Convert;
import br.com.caelum.vraptor.converter.Converter;
import br.com.setaprox.sgam.DAO.RecursoDAO;
import br.com.setaprox.sgam.model.Recurso;

@Convert(Recurso.class)
@ApplicationScoped
public class RecursoConverter implements Converter<Recurso> {

	@Inject
	private RecursoDAO recursoDAO;
	
	@Override
	public Recurso convert(String value, Class<? extends Recurso> type) {
		if(value != null && !value.isEmpty()){
			try {
				return recursoDAO.find(Long.parseLong(value));
			} catch (NumberFormatException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return new Recurso();
	}

}
