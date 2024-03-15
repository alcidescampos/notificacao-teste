package br.com.notificacao.controle;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.github.maestro.core.annotation.HandlesError;

import br.com.notificacao.configuracao.AplicacaoConfiguracao;
import br.jus.cnj.canivete.suico.SistemaFactory;
import br.jus.cnj.canivete.suico.api.Aplicacao;
import br.jus.cnj.canivete.suico.api.Sistema;

@Path(value = "aplicacao")
@HandlesError
public class AplicacaoCtrl {

	@Inject
	AplicacaoConfiguracao configuracao;
	
	@GET
	@Path("dados")
	@Produces(MediaType.APPLICATION_JSON)
	public Aplicacao getDados() {
		return this.configuracao.toAplicacao(false);
	}
	
	@GET
	@Path("sistema")
	@Produces(MediaType.APPLICATION_JSON)
	public Sistema getSistema() {
		return SistemaFactory.sistema();
	}
}