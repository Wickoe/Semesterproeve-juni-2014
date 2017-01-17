package service;

import java.time.LocalDate;

import model.Bestilling;
import model.BestillingsLinje;
import model.Gæst;
import model.Vare;
import storage.Storage;

public class Service {
	public static Bestilling createBestilling(LocalDate enDato, boolean harBetalt, Gæst enGæst) {
		Bestilling bestilling = new Bestilling(enDato, harBetalt, enGæst);
		return bestilling;
	}

	public static BestillingsLinje createBestillingsLinje(int etAntal, Vare enVare, Bestilling enBestilling) {
		BestillingsLinje linje = new BestillingsLinje(etAntal, enVare, enBestilling);
		return linje;
	}

	public static Vare createVare(String etNavn, String etMærke, double enMængde, double enPris) {
		Vare vare = new Vare(etNavn, etMærke, enMængde, enPris);
		Storage.addVare(vare);
		return vare;
	}

	public static Gæst createGæst(String etNavn, int etVærelsesNummer) {
		Gæst gæst = new Gæst(etNavn, etVærelsesNummer);
		Storage.addGæst(gæst);
		return gæst;
	}

	public static void createSomeObjects() {
		Vare cola = createVare("Cola", "CocaCola", 0.2, 28);
		Vare pepsi = createVare("Cola", "Pepsi", 0.5, 26);
		Vare tuborg = createVare("Øl", "Tuborg", 0.33, 33);
		Vare carlsberg = createVare("Øl", "Carlsberg", 0.57, 48);

		Gæst ib = createGæst("Ib", 17);
		Gæst eva = createGæst("Eva", 12);
		Gæst lene = createGæst("Lene", 8);

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
