#!/bin/bash
echo '-- 200 - Configurando o docker...'
echo ''

DOCKER_SOCK=/var/run/docker.sock

echo "- Verificando se o arquivo externo: $DOCKER_SOCK existe?"
if [ -e "$DOCKER_SOCK" ] ; then
	echo "--> Arquivo encontrado"
	
	echo "- Recuperando o id do grupo do arquivo externo: $DOCKER_SOCK..."
	GRUPO_ID=$(stat -c %g /var/run/docker.sock)
	echo "--> O id encontrado foi: $GRUPO_ID"
	
	echo "- Criando o grupo docker com o mesmo id externo para permitir acesso ao arquivo: $DOCKER_SOCK..."
	groupadd -o -g $GRUPO_ID docker


	echo "- Adicionando o usuário 'app' no grupo 'docker'..."
	usermod -aG docker app
else
	echo "   ==> O arquivo externo: $DOCKER_SOCK não foi encontrado por favor montar o arquivo no container"
	exit 1
fi
