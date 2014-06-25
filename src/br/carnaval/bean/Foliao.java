package br.carnaval.bean;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

/**
 * The persistent class for the foliao database table.
 * 
 */
@Entity
@NamedQuery(name = "Foliao.findAll", query = "SELECT f FROM Foliao f")
public class Foliao implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id

	@SequenceGenerator(initialValue = 1, sequenceName = "sequenciaId", name = "sequenceID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idFoliao;

	private int cpf;

	private int idade;

	private String nome;

	private int rg;

	// bi-directional many-to-one association to Reserva
	@OneToMany(mappedBy = "foliao")
	private List<Reserva> reservas;

	public Foliao() {
	}

	public int getIdFoliao() {
		return this.idFoliao;
	}

	public void setIdFoliao(int idFoliao) {
		this.idFoliao = idFoliao;
	}

	public int getCpf() {
		return this.cpf;
	}

	public void setCpf(int cpf) {
		this.cpf = cpf;
	}

	public int getIdade() {
		return this.idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getRg() {
		return this.rg;
	}

	public void setRg(int rg) {
		this.rg = rg;
	}

	public List<Reserva> getReservas() {
		return this.reservas;
	}

	public void setReservas(List<Reserva> reservas) {
		this.reservas = reservas;
	}

	public Reserva addReserva(Reserva reserva) {
		getReservas().add(reserva);
		reserva.setFoliao(this);

		return reserva;
	}

	public Reserva removeReserva(Reserva reserva) {
		getReservas().remove(reserva);
		reserva.setFoliao(null);

		return reserva;
	}

}