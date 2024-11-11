package no.hvl.dat100.oppgave4;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import no.hvl.dat100.oppgave3.*;

public class SkrivBlogg {

	public static boolean skriv(Blogg samling, String mappe, String filnavn) {
		try {
			PrintWriter writer = new PrintWriter(mappe + "/" + filnavn);
			
			writer.println(samling.getAntall());
			
			for (int i = 0; i < samling.getAntall(); i++) {
				writer.println(samling.getSamling()[i].toString());
			}
			writer.close();
			return true;
		}catch (FileNotFoundException e) {
			System.err.println("Feil ved skriving til fil; " + e.getMessage());
			return false;
		}
	}
}
