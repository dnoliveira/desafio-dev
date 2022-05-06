package br.com.bycoders.desafiodev.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "tipo_transacao")
public class TipoTransacao {

    @Id
    private int id;

    @Column(length = 35, nullable = false)
    private String descricao;

    @Column(length = 25, nullable = false)
    @Enumerated(EnumType.STRING)
    private Natureza natureza;
}
