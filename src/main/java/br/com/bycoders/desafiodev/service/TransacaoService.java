package br.com.bycoders.desafiodev.service;

import br.com.bycoders.desafiodev.model.Transacao;
import br.com.bycoders.desafiodev.repository.TransacaoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransacaoService {
    private final Logger log = LoggerFactory.getLogger((TransacaoService.class));

    private final TransacaoRepository transacaoRepository;

    public TransacaoService(TransacaoRepository transacaoRepository){
        this.transacaoRepository = transacaoRepository;
    }

    public List<Transacao> saveAll(List<Transacao> transacoes) {
        log.debug("Request to save Transacao : {}", transacoes);
        transacoes = transacaoRepository.saveAll(transacoes);
        return transacoes;
    }

}
