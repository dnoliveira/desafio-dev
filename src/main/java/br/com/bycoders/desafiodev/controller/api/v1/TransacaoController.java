package br.com.bycoders.desafiodev.controller.api.v1;

import br.com.bycoders.desafiodev.model.Transacao;
import br.com.bycoders.desafiodev.service.TransacaoService;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "v1/transacao")
@Api(tags = "Pessoa")
public class TransacaoController {
    private final Logger log = LoggerFactory.getLogger((TransacaoController.class));

    private final TransacaoService transacaoService;

    public TransacaoController(TransacaoService transacaoService){
        this.transacaoService = transacaoService;
    }


    @PostMapping(value = "/csv", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public List<Transacao> upload(@RequestPart("data") MultipartFile csv) throws IOException {
        List<Transacao> savedNotes = new ArrayList<>();
        List<Transacao> notes = new BufferedReader(
                new InputStreamReader(Objects.requireNonNull(csv).getInputStream(), StandardCharsets.UTF_8)).lines()
                .map(Transacao::parseNote).collect(Collectors.toList());
        transacaoService.saveAll(notes).forEach(savedNotes::add);
        return savedNotes;
    }
}
