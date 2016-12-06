package br.com.webSchool.validation;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("checkBoxValidator")
public class CheckBoxValidator implements Validator{

	@Override
	public void validate(FacesContext context, UIComponent component, Object object) throws ValidatorException {
		if(object.equals(Boolean.FALSE)) {
			String requiredMessage = ((UIInput)component).getRequiredMessage();
			
			throw new ValidatorException(
	                new FacesMessage(FacesMessage.SEVERITY_ERROR, requiredMessage, requiredMessage));
		}
	}

}
