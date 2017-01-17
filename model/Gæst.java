package model;

import java.util.ArrayList;

public class Gæst {
	private String navn;
	private int værelsesNummer;

	private ArrayList<Bestilling> bestillinger = new ArrayList<>();

	public Gæst(String etNavn, int etVærelsesNummer) {
		this.navn = etNavn;
		this.værelsesNummer = etVærelsesNummer;
	}

	public String getNavn() {
		return navn;
	}

	public void setNavn(String navn) {
		this.navn = navn;
	}

	public int getVærelsesNummer() {
		return værelsesNummer;
	}

	public void setVærelsesNummer(int værelsesNummer) {
		this.værelsesNummer = værelsesNummer;
	}

	public void addBestilling(Bestilling enBestilling) {
		bestillinger.add(enBestilling);
	}

	public void removeBestilling(Bestilling enBestilling) {
		bestillinger.remove(enBestilling);
	}

	public ArrayList<Bestilling> getBestillinger() {
		return new ArrayList<>(bestillinger);
	}

	public double pris() {
		double prisTotal = 0;

		for (int i = 0; i < bestillinger.size(); i++) {
			prisTotal += bestillinger.get(i).pris();
		}

		return prisTotal;
	}

	public boolean harBestilt(Vare vare) {
		boolean found = false;
		int i = 0;
		while (!found && i < bestillinger.size()) {
			Bestilling k = bestillinger.get(i);
			int j = 0;

			while (!found && j < k.getBestillingsLinjer().size()) {
				Vare voresVare = k.getBestillingsLinjer().get(j).getVare();

				if (voresVare == vare) {
					found = true;
				} else {
					j++;
				}
			}
			i++;
		}
		return false;
	}

	public ArrayList<String> ikkeBetalteBestillinger() {
		ArrayList<String> ikkeBetalt = new ArrayList<>();
		for (Bestilling b : bestillinger) {
			if (!b.isBetalt()) {
				String information = b.getDato().toString();
				for (BestillingsLinje bl : b.getBestillingsLinjer()) {
					String l = information + ", " + bl.getAntal() + " " + bl.getVare().getNavn() + " "
							+ bl.getVare().getMængde() + " " + bl.getVare().getPris();
					ikkeBetalt.add(l);
				}
			}
		}
		return ikkeBetalt;
	}
}