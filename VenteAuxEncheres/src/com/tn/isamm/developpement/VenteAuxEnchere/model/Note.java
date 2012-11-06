package com.tn.isamm.developpement.VenteAuxEnchere.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * Entity implementation class for Entity: Note
 *
 */
@Entity
@Table(name = "Note")
public class Note implements Serializable {

	   
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idNote;
	private long idObj;
	private long idMbr;
	private String note;
	@OneToOne(cascade = CascadeType.MERGE)
	private Membre membre;
	private static final long serialVersionUID = 1L;

	public Note() {
		super();
	}   
	public long getIdNote() {
		return this.idNote;
	}

	public void setIdNote(long idNote) {
		this.idNote = idNote;
	}   
	public long getIdObj() {
		return this.idObj;
	}

	public void setIdObj(long idObj) {
		this.idObj = idObj;
	}   
	public long getIdMbr() {
		return this.idMbr;
	}

	public void setIdMbr(long idMbr) {
		this.idMbr = idMbr;
	}   
	public String getNote() {
		return this.note;
	}

	public void setNote(String note) {
		this.note = note;
	}
	public Membre getMembre() {
		return membre;
	}
	public void setMembre(Membre membre) {
		this.membre = membre;
	}
   
}

