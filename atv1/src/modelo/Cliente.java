
package modelo;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import javax.persistence.SequenceGenerator;
/**
* Classe utilizada para representar um Cliente.
*/
@Entity
@SequenceGenerator(name = "CLIENTE_SEQ",
sequenceName = "CLI_SEQ", initialValue = 1,
allocationSize = 1)
public class Cliente implements Serializable {
private static final long serialVersionUID
= 4521490124826140567L;
@Id
@GeneratedValue(strategy = GenerationType.SEQUENCE,
generator = "CLIENTE_SEQ")
private Long id;
private String nome;
@OneToOne(cascade=CascadeType.ALL)
private Endereco endereco;
public Endereco getEndereco() { return endereco; }
public void setEndereco(Endereco endereco) {
this.endereco = endereco;
}
public Long getId() { return id; }
public void setId(Long id) { this.id = id; }
public String getNome() { return nome; }
public void setNome(String nome) { this.nome = nome; }
}