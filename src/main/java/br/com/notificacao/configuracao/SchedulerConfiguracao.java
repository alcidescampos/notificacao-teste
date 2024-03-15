package br.com.notificacao.configuracao;

import io.smallrye.config.ConfigMapping;

@ConfigMapping(prefix = "aplicacao.scheduler")
public interface SchedulerConfiguracao {
	
	public boolean habilitado();
}