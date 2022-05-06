package br.com.bycoders.desafiodev.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.Instant;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "transacao")
public class Transacao {

    @Id
    private int id;

    @ManyToOne
    @JoinColumn(name = "id_tipo", nullable = false, foreignKey = @ForeignKey(name = "fk_transacao_tipotransacao"))
    private TipoTransacao tipo;

    @Column(nullable = false)
    private Instant dtOcorrencia;

    @Column(nullable = false)
    private BigDecimal valor;

    @Column(length = 11, nullable = false)
    private String cpfBeneficiario;

    @Column(length = 12, nullable = false)
    private String cartao;

    @Column(length = 14, nullable = false)
    private String donoLoja;

    @Column(length = 19, nullable = false)
    private String nomeLoja;
}
