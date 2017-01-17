package model;

import java.util.ArrayList;

public class Vare {
	private String navn;
	private String m�rke;
	private double m�ngde;
	private double pris;

	private ArrayList<BestillingsLinje> bestillingslinjer = new ArrayList<>();

	public Vare(String etNavn, String etM�rke, double enM�ngde, double enPris) {
		this.setNavn(etNavn);
		this.setM�rke(etM�rke);
		this.setM�ngde(enM�ngde);
		this.pris = enPris;
	}

	public String getNavn() {
		return navn;
	}

	public void setNavn(String navn) {
		this.navn = navn;
	}

	public String getM�rke() {
		return m�rke;
	}

	public void setM�rke(String m�rke) {
		this.m�rke = m�rke;
	}

	public double getM�ngde() {
		return m�ngde;
	}

	public void setM�ngde(double m�ngde) {
		this.m�ngde = m�ngde;
	}

	public double getPris() {
		return pris;
	}

	public void setPris(double pris) {
		this.pris = pris;
	}

	public void addBestillingsLinje(BestillingsLinje linje) {
		bestillingslinjer.add(linje);
		if (linje.getVare() != this) {
			linje.setVare(this);
		}
	}

	public void removeBestillingsLinje(BestillingsLinje linje) {
		bestillingslinjer.remove(linje);
		if (linje.getVare() == this) {
			linje.setVare(null);
		}
	}

	public ArrayList<BestillingsLinje> getBestilingsLinjer() {
		return new ArrayList<>(bestillingslinjer);
	}
}