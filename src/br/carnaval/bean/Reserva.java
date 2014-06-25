package br.carnaval.bean;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Time;
import java.util.Date;


/**
 * The persistent class for the reserva database table.
 * 
 */
@Entity
@NamedQuery(name="Reserva.findAll", query="SELECT r FROM Reserva r")
public class Reserva implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int numeroReserva;

	@Temporal(TemporalType.DATE)
	private Date dataDaReserva;

	private Time hora;

	//bi-directional many-to-one association to Ala
	@ManyToOne
	@JoinColumn(name="idAla")
	private Ala ala;

	//bi-directional many-to-one association to Foliao
	@ManyToOne
	@JoinColumn(name="idFoliao")
	private Foliao foliao;

	public Reserva() {
	}

	public int getNumeroReserva() {
		return this.numeroReserva;
	}

	public void setNumeroReserva(int numeroReserva) {
		this.numeroReserva = numeroReserva;
	}

	public Date getDataDaReserva() {
		return this.dataDaReserva;
	}

	public void setDataDaReserva(Date dataDaReserva) {
		this.dataDaReserva = dataDaReserva;
	}

	public Time getHora() {
		return this.hora;
	}

	public void setHora(Time hora) {
		this.hora = hora;
	}

	public Ala getAla() {
		return this.ala;
	}

	public void setAla(Ala ala) {
		this.ala = ala;
	}

	public Foliao getFoliao() {
		return this.foliao;
	}

	public void setFoliao(Foliao foliao) {
		this.foliao = foliao;
	}

}