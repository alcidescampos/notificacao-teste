package br.com.notificacao.infra;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;

import org.jboss.logging.Logger;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

@ApplicationScoped
public class ApplicationResources {
	
	@Inject
	Logger logger;
	
	@Produces
	@ApplicationScoped
	@Named("executorServiceCompilador")
	public ExecutorService produzExecutorServiceCompilador() {
		return Executors.newFixedThreadPool(10, new ThreadFactoryBuilder().setNameFormat("gizmo-pool-%d").build());
	}
	
}