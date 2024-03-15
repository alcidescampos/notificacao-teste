package br.com.notificacao.infra;


import java.io.Serializable;
import java.util.concurrent.CompletionStage;

import javax.annotation.Priority;
import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import javax.ws.rs.WebApplicationException;

import org.jboss.logging.Logger;

import com.github.maestro.core.annotation.HandlesError;

import br.jus.cnj.canivete.suico.exception.RuntimeExceptionInCtrl;
import br.jus.cnj.canivete.suico.quarkus.ExceptionUtils;


@Priority(0)
@HandlesError
@Interceptor
public class HandlesErrorInterceptor implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	Logger logger; 
	
	@AroundInvoke
	public Object managerError(InvocationContext ctx) throws Exception {
		try {
			Object retorno = ctx.proceed();
			
			if (retorno instanceof CompletionStage) {
				// Substitui o throwable nao tratado por um RuntimeExceptionInCtrl ou por um WebApplicationException
				retorno = ((CompletionStage<?>) retorno).exceptionally((t) -> { 
					throw tratarThrowable(t.getCause()); 
				});
			}
			
			return retorno;
		} catch (Throwable t) {
			throw tratarThrowable(t);
		}
	}
	
	public RuntimeException tratarThrowable(Throwable t) {
		if (t instanceof WebApplicationException) {
			return (WebApplicationException) t;
		} else {
			this.logger.error("", t);
			
			return new RuntimeExceptionInCtrl(ExceptionUtils.getCause(t));
		}
	}
}