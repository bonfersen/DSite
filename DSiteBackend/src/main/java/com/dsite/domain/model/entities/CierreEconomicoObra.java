package com.dsite.domain.model.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the cierreEconomicoObra database table.
 * 
 */
@Entity
@Table(name = "cierreEconomicoObra")
@NamedQuery(name="CierreEconomicoObra.findAll", query="SELECT c FROM CierreEconomicoObra c")
public class CierreEconomicoObra implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idCierreEconomicoObra;

	//bi-directional many-to-one association to CierreEconomico
	@ManyToOne
	@JoinColumn(name="idCierreEconomico")
	private CierreEconomico cierreEconomico;

	//bi-directional many-to-one association to Obra
	@ManyToOne
	@JoinColumn(name="idObra")
	private Obra obra;

	public CierreEconomicoObra() {
	}

	public int getIdCierreEconomicoObra() {
		return this.idCierreEconomicoObra;
	}

	public void setIdCierreEconomicoObra(int idCierreEconomicoObra) {
		this.idCierreEconomicoObra = idCierreEconomicoObra;
	}

	public CierreEconomico getCierreEconomico() {
		return this.cierreEconomico;
	}

	public void setCierreEconomico(CierreEconomico cierreEconomico) {
		this.cierreEconomico = cierreEconomico;
	}

	public Obra getObra() {
		return this.obra;
	}

	public void setObra(Obra obra) {
		this.obra = obra;
	}

}