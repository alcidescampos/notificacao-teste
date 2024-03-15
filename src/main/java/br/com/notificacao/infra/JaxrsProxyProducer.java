package br.com.notificacao.infra;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Default;
import javax.enterprise.inject.Produces;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;

@ApplicationScoped
public class JaxrsProxyProducer {

		
	@RequestScoped
	@Produces
	@Default
	public Client produzClient() {
		return ClientBuilder.newBuilder().build();
	}
}