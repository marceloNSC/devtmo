package br.carnaval.bean;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the ala database table.
 * 
 */
@Entity
@NamedQuery(name="Ala.findAll", query="SELECT a FROM Ala a")
public class Ala implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idAla;

	private String nomeAla;

	private int numeroIntegrantes;

	//bi-directional many-to-many association to Fantasia
	@ManyToMany(mappedBy="alas")
	private List<Fantasia> fantasias;

	//bi-directional many-to-one association to Reserva
	@OneToMany(mappedBy="ala")
	private List<Reserva> reservas;

	public Ala() {
	}

	public int getIdAla() {
		return this.idAla;
	}

	public void setIdAla(int idAla) {
		this.idAla = idAla;
	}

	public String getNomeAla() {
		return this.nomeAla;
	}

	public void setNomeAla(String nomeAla) {
		this.nomeAla = nomeAla;
	}

	public int getNumeroIntegrantes() {
		return this.numeroIntegrantes;
	}

	public void setNumeroIntegrantes(int numeroIntegrantes) {
		this.numeroIntegrantes = numeroIntegrantes;
	}

	public List<Fantasia> getFantasias() {
		return this.fantasias;
	}

	public void setFantasias(List<Fantasia> fantasias) {
		this.fantasias = fantasias;
	}

	public List<Reserva> getReservas() {
		return this.reservas;
	}

	public void setReservas(List<Reserva> reservas) {
		this.reservas = reservas;
	}

	public Reserva addReserva(Reserva reserva) {
		getReservas().add(reserva);
		reserva.setAla(this);

		return reserva;
	}

	public Reserva removeReserva(Reserva reserva) {
		getReservas().remove(reserva);
		reserva.setAla(null);

		return reserva;
	}

}