package br.com.notificacao.controle;

import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.github.maestro.core.annotation.HandlesError;

import br.com.notificacao.manager.EventoManager;
import br.jus.pdpj.commons.models.dtos.webhooks.WebhookWrapperMessage;

@Path(value = "/evento")
@HandlesError
public class EventoCtrl {
	
	@Inject
	EventoManager manager;
	
	@POST
	@Path("/consumirMensagem")
	@Produces(MediaType.APPLICATION_JSON)
	public String consumirMensagem(WebhookWrapperMessage evento) {
		return this.manager.consumirMensagem(evento);
	}
}
