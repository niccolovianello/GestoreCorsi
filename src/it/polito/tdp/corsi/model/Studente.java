package it.polito.tdp.corsi.model;

public class Studente {
	
	private int matricole;
	private String nome;
	private String cognome;

	private String CDS;
	
	public Studente(int matricole, String nome, String cognome, String CDS) {
		this.matricole = matricole;
		this.nome = nome;
		this.cognome = cognome;
		this.CDS = CDS;
	}

	public int getMatricole() {
		return matricole;
	}

	public String getNome() {
		return nome;
	}

	public String getCognome() {
		return cognome;
	}

	public String getCDS() {
		return CDS;
	}
	
	@Override
	public String toString() {
		return "Studente [matricole=" + matricole + ", nome=" + nome + ", cognome=" + cognome + ", CDS=" + CDS + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + matricole;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Studente other = (Studente) obj;
		if (matricole != other.matricole)
			return false;
		return true;
	}
	
	
	
	
	

}
