package br.com.webSchool.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter("TelefoneConverter")
public class TelefoneCnnverter implements Converter{

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {

			
		return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		// TODO Auto-generated method stub
		return null;
	}

}
