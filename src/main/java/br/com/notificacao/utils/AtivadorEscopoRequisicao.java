package br.com.notificacao.utils;

import java.util.concurrent.CompletableFuture;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.control.ActivateRequestContext;

@RequestScoped
public class AtivadorEscopoRequisicao {

	@ActivateRequestContext
	public void run(Runnable runnable) {
		runnable.run();
	}

	public CompletableFuture<Void> runAsync(Runnable runnable) {
		return CompletableFuture.runAsync(() -> this.run(runnable));
	}
}
