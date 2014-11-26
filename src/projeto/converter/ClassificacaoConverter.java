package projeto.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import projeto.dao.ClassificacaoDao;
import projeto.entity.Classificacao;

@FacesConverter(forClass = Classificacao.class)
public class ClassificacaoConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent uiComponent,
			String value) {
		Long id = Long.parseLong(value);
		ClassificacaoDao dao = new ClassificacaoDao();
		return dao.buscarPorId(id);
	}

	@Override
	public String getAsString(FacesContext context, UIComponent uiComponent,
			Object value) {
		Classificacao classificacao = (Classificacao) value;
		return classificacao.getId().toString();
	}
}
