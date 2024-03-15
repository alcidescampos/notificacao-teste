FROM registry.cnj.jus.br/ia/cranium:1.5.0

RUN eval "$(pyenv init -)" && pyenv activate base && pip install nltk
RUN eval "$(pyenv init -)" && pyenv activate base && pip install gensim==3.8.1
RUN eval "$(pyenv init -)" && pyenv activate base && pip install numpy
RUN eval "$(pyenv init -)" && pyenv activate base && pip install tqdm
RUN eval "$(pyenv init -)" && pyenv activate base && pip install ia-utils
RUN eval "$(pyenv init -)" && pyenv activate base && pip install matplotlib

RUN eval "$(pyenv init -)" && pyenv activate base && pip install -U sinapses-cliente

ENV VERSAO_ID '10121985'