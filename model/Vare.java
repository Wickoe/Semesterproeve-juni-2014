package model;

import java.util.ArrayList;

public class Vare {
	private String navn;
	private String mærke;
	private double mængde;
	private double pris;

	private ArrayList<BestillingsLinje> bestillingslinjer = new ArrayList<>();

	public Vare(String etNavn, String etMærke, double enMængde, double enPris) {
		this.setNavn(etNavn);
		this.setMærke(etMærke);
		this.setMængde(enMængde);
		this.pris = enPris;
	}

	public String getNavn() {
		return navn;
	}

	public void setNavn(String navn) {
		this.navn = navn;
	}

	public String getMærke() {
		return mærke;
	}

	public void setMærke(String mærke) {
		this.mærke = mærke;
	}

	public double getMængde() {
		return mængde;
	}

	public void setMængde(double mængde) {
		this.mængde = mængde;
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