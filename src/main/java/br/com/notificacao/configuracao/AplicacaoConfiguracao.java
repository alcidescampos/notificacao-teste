package br.com.notificacao.configuracao;

import java.util.LinkedHashMap;

import br.jus.cnj.canivete.suico.api.Aplicacao;
import br.jus.cnj.canivete.suico.configuracao.BaseAplicacaoConfiguracao;
import io.quarkus.runtime.annotations.RegisterForReflection;
import io.smallrye.config.ConfigMapping;

@RegisterForReflection
@ConfigMapping(prefix = "aplicacao")
public interface AplicacaoConfiguracao extends BaseAplicacaoConfiguracao {
			
	public String endereco();
	public SchedulerConfiguracao scheduler();
	
	@Override
	public default Aplicacao toAplicacao(boolean incluirSistema) {
				
		Aplicacao aplicacao = this.toAplicacaoBase(incluirSistema);
		
		LinkedHashMap<String, Object> scheduler = new LinkedHashMap<>();
		
		scheduler.put("habilitado", this.scheduler().habilitado());
		
		
		aplicacao.getConfiguracoes().put("scheduler", scheduler);		

		return aplicacao;
	}
	
	public default String getPathSemRest(String path) {
		return path.replace("/rest", "");
	}
}
