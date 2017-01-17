package storage;

import java.util.ArrayList;

import model.Gæst;
import model.Vare;

public class Storage {
	private static ArrayList<Vare> vare = new ArrayList<>();
	private static ArrayList<Gæst> gæster = new ArrayList<>();

	// ---------------------------------------------------------------------------------------------

	public static void addVare(Vare enVare) {
		vare.add(enVare);
	}

	public static void removeVare(Vare enVare) {
		vare.remove(enVare);
	}

	public static ArrayList<Vare> getVare() {
		return new ArrayList<>(vare);
	}

	// ---------------------------------------------------------------------------------------------

	public static void addGæst(Gæst enGæst) {
		gæster.add(enGæst);
	}

	public static void removeGæst(Gæst enGæst) {
		gæster.remove(enGæst);
	}

	public static ArrayList<Gæst> getGæster() {
		return new ArrayList<>(gæster);
	}
}
