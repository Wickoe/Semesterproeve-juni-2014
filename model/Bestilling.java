package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Bestilling {
	private LocalDate dato;
	private boolean betalt;

	private ArrayList<BestillingsLinje> linjer = new ArrayList<>();

	public Bestilling(LocalDate enDato, boolean harBetalt, Gæst enGæst) {
		this.dato = enDato;
		this.betalt = harBetalt;
		enGæst.addBestilling(this);
	}

	public LocalDate getDato() {
		return dato;
	}

	public void setDato(LocalDate dato) {
		this.dato = dato;
	}

	public boolean isBetalt() {
		return betalt;
	}

	public void setBetalt(boolean betalt) {
		this.betalt = betalt;
	}

	public void addBestillingsLinje(BestillingsLinje linje) {
		linjer.add(linje);
		if (linje.getBestilling() != this) {
			linje.setBestilling(this);
		}
	}

	public void removeBestillingslinje(BestillingsLinje linje) {
		linjer.remove(linje);
		if (linje.getBestilling() == this) {
			linje.setBestilling(null);
		}
	}

	public ArrayList<BestillingsLinje> getBestillingsLinjer() {
		return new ArrayList<>(linjer);
	}

	public double pris() {
		double prisTotal = 0;

		for (int i = 0; i < linjer.size(); i++) {
			prisTotal += linjer.get(i).pris();
		}

		return prisTotal;
	}
}