package service;

import java.time.LocalDate;

import model.Bestilling;
import model.BestillingsLinje;
import model.G�st;
import model.Vare;
import storage.Storage;

public class Service {
	public static Bestilling createBestilling(LocalDate enDato, boolean harBetalt, G�st enG�st) {
		Bestilling bestilling = new Bestilling(enDato, harBetalt, enG�st);
		return bestilling;
	}

	public static BestillingsLinje createBestillingsLinje(int etAntal, Vare enVare, Bestilling enBestilling) {
		BestillingsLinje linje = new BestillingsLinje(etAntal, enVare, enBestilling);
		return linje;
	}

	public static Vare createVare(String etNavn, String etM�rke, double enM�ngde, double enPris) {
		Vare vare = new Vare(etNavn, etM�rke, enM�ngde, enPris);
		Storage.addVare(vare);
		return vare;
	}

	public static G�st createG�st(String etNavn, int etV�relsesNummer) {
		G�st g�st = new G�st(etNavn, etV�relsesNummer);
		Storage.addG�st(g�st);
		return g�st;
	}

	public static void createSomeObjects() {
		Vare cola = createVare("Cola", "CocaCola", 0.2, 28);
		Vare pepsi = createVare("Cola", "Pepsi", 0.5, 26);
		Vare tuborg = createVare("�l", "Tuborg", 0.33, 33);
		Vare carlsberg = createVare("�l", "Carlsberg", 0.57, 48);

		G�st ib = createG�st("Ib", 17);
		G�st eva = createG�st("Eva", 12);
		G�st lene = createG�st("Lene", 8);

		Bestilling ibBestillingTidlig = createBestilling(LocalDate.of(2014, 6, 15), false, ib);
		Bestilling ibBestillingSen = createBestilling(LocalDate.of(2014, 6, 16), false, ib);

		createBestillingsLinje(3, tuborg, ibBestillingTidlig);
		createBestillingsLinje(2, cola, ibBestillingTidlig);
		createBestillingsLinje(2, pepsi, ibBestillingTidlig);

		createBestillingsLinje(3, tuborg, ibBestillingSen);
		createBestillingsLinje(3, pepsi, ibBestillingSen);
		createBestillingsLinje(4, carlsberg, ibBestillingSen);
	}
}
