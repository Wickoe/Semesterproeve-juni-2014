package model;

public class BestillingsLinje {
	private int antal;
	private Vare vare;

	private Bestilling bestilling;

	public BestillingsLinje(int etAntal, Vare enVare, Bestilling enBestilling) {
		this.antal = etAntal;
		this.vare = enVare;
		this.bestilling = enBestilling;
	}

	public int getAntal() {
		return antal;
	}

	public void setAntal(int antal) {
		this.antal = antal;
	}

	public Vare getVare() {
		return vare;
	}

	public void setVare(Vare enVare) {
		Vare oldVare = vare;
		if (oldVare.getBestilingsLinjer().contains(this)) {
			oldVare.removeBestillingsLinje(this);
		}
		this.vare = enVare;
		if (enVare != null && !enVare.getBestilingsLinjer().contains(this)) {
			enVare.addBestillingsLinje(this);
		}
	}

	public Bestilling getBestilling() {
		return bestilling;
	}

	public void setBestilling(Bestilling enBestilling) {
		Bestilling oldBestilling = bestilling;
		if (oldBestilling.getBestillingsLinjer().contains(this)) {
			oldBestilling.removeBestillingslinje(this);
		}
		this.bestilling = enBestilling;
		if (bestilling != null && !bestilling.getBestillingsLinjer().contains(this)) {
			bestilling.addBestillingsLinje(this);
		}
	}

	public double pris() {
		return vare.getPris() * antal;
	}
}