package br.carnaval.bean;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the fantasia database table.
 * 
 */
@Entity
@NamedQuery(name="Fantasia.findAll", query="SELECT f FROM Fantasia f")
public class Fantasia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idFantasia;

	private String descricao;

	private String nomeFantasia;

	private String pesoFantasia;

	private String urlImagem;

	//bi-directional many-to-many association to Ala
	@ManyToMany
	@JoinTable(
		name="alafantasia"
		, joinColumns={
			@JoinColumn(name="idFantasia")
			}
		, inverseJoinColumns={
			@JoinColumn(name="idAla")
			}
		)
	private List<Ala> alas;

	public Fantasia() {
	}

	public int getIdFantasia() {
		return this.idFantasia;
	}

	public void setIdFantasia(int idFantasia) {
		this.idFantasia = idFantasia;
	}

	public Object getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getNomeFantasia() {
		return this.nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public String getPesoFantasia() {
		return this.pesoFantasia;
	}

	public void setPesoFantasia(String pesoFantasia) {
		this.pesoFantasia = pesoFantasia;
	}

	public String getUrlImagem() {
		return this.urlImagem;
	}

	public void setUrlImagem(String urlImagem) {
		this.urlImagem = urlImagem;
	}

	public List<Ala> getAlas() {
		return this.alas;
	}

	public void setAlas(List<Ala> alas) {
		this.alas = alas;
	}

}