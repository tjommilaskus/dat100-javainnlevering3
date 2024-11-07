package no.hvl.dat100.oppgave5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import no.hvl.dat100.common.TODO;
import no.hvl.dat100.oppgave1.*;
import no.hvl.dat100.oppgave2.*;
import no.hvl.dat100.oppgave3.*;

import javax.swing.JOptionPane;

public class LesBlogg {

	private static String TEKST = "TEKST";
	private static String BILDE = "BILDE";

	public static Blogg les(String mappe, String filnavn) {
		try {
			File fil = new File(mappe, filnavn);

			BufferedReader reader = new BufferedReader(new FileReader(fil));

			int antallInnlegg = Integer.parseInt(reader.readLine());

			Blogg blogg = new Blogg(antallInnlegg);

			for (int i = 0; i < antallInnlegg; i++) {
				String type = reader.readLine();
				int id = Integer.parseInt(reader.readLine());
				String bruker = reader.readLine();
				String dato = reader.readLine();
				int likes = Integer.parseInt(reader.readLine());

				if (type.equals(TEKST)) {
					String tekst = reader.readLine();
					Innlegg innlegg = new Tekst(id, bruker, likes, tekst);
					blogg.leggTil(innlegg);
				} else if (type.equals(BILDE)) {
					String tekst = reader.readLine();
					String url = reader.readLine();
					Innlegg innlegg = new Bilde(id, bruker, dato, likes, tekst, url);
					blogg.leggTil(innlegg);
				}
			}
			reader.close();
			return blogg;
		} catch (IOException e) {
			System.err.println("Feil ved lesning fra fil: " + e.getMessage());
			return null;
		}

	}
}
