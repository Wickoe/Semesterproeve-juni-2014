package storage;

import java.util.ArrayList;

import model.G�st;
import model.Vare;

public class Storage {
	private static ArrayList<Vare> vare = new ArrayList<>();
	private static ArrayList<G�st> g�ster = new ArrayList<>();

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

	public static void addG�st(G�st enG�st) {
		g�ster.add(enG�st);
	}

	public static void removeG�st(G�st enG�st) {
		g�ster.remove(enG�st);
	}

	public static ArrayList<G�st> getG�ster() {
		return new ArrayList<>(g�ster);
	}
}
