package modelo;


import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

/**
 * Classe utilizada para representar um Endereço.
 */
@Entity
@SequenceGenerator(name = "ENDERECO_SEQ",
        sequenceName = "END_SEQ", initialValue = 1,
        allocationSize = 1)
public class Endereco implements Serializable {

    private static final long serialVersionUID
            = 5331450149454053703L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "ENDERECO_SEQ")
    private Long id;
    private String estado;
    private String cidade;
    private String bairro;
    private String logradouro;
    private String complemento;

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }
}

