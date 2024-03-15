package br.com.notificacao.manager;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import br.jus.pdpj.commons.models.dtos.webhooks.WebhookWrapperMessage;

@RequestScoped
public class EventoManager {	
	
	
	@Inject
	public EventoManager() {}

	public String consumirMensagem(WebhookWrapperMessage evento) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
