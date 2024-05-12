package org.generation.italy;

import java.util.Random;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		Random rnd = new Random();
		String[][] campo = new String[8][8];
		String[][] campoPlayer = new String[8][8];
		int versoNave, ordinateNave, ascisseNave, counter = 0, ordinateSparo, ascisseSparo, colpiSparati = 0,
				conteggioNavi = 0;

		for (int i = 0; i < 8; i++) {// scrivi griglia base
			for (int j = 0; j < 8; j++) {
				campo[i][j] = "~";
				campoPlayer[i][j] = "~";
			}

		}
		do {
			conteggioNavi = 0;
			versoNave = rnd.nextInt(2);// posizionamento nave vericale/orizzontale 2 blocchi
			if (versoNave == 0) {// verticale
				ordinateNave = rnd.nextInt(7);
				ascisseNave = rnd.nextInt(8);
				if (campo[ordinateNave][ascisseNave].equals("~") && campo[ordinateNave + 1][ascisseNave].equals("~")) {
					campo[ordinateNave][ascisseNave] = "A"; // potevo usare un for
					campo[ordinateNave + 1][ascisseNave] = "V";
				}
			} else {// orizzontale
				ordinateNave = rnd.nextInt(8);
				ascisseNave = rnd.nextInt(7);
				if (campo[ordinateNave][ascisseNave].equals("~") && campo[ordinateNave][ascisseNave + 1].equals("~")) {
					campo[ordinateNave][ascisseNave] = "<";
					campo[ordinateNave][ascisseNave + 1] = ">";
				}
			}
			for (int i = 0; i < 8; i++) {// conta navi
				for (int j = 0; j < 8; j++) {
					if (!campo[i][j].equals("~"))
						conteggioNavi++;
				}
			}
		} while (conteggioNavi < 4);
		
		do {
			conteggioNavi = 0;
			versoNave = rnd.nextInt(2);// posizionamento nave vericale/orizzontale da 3 blocchi
			if (versoNave == 0) {// verticale
				ordinateNave = rnd.nextInt(6);
				ascisseNave = rnd.nextInt(8);
				if (campo[ordinateNave][ascisseNave].equals("~") && campo[ordinateNave + 1][ascisseNave].equals("~")
						&& campo[ordinateNave + 2][ascisseNave].equals("~")) {
					campo[ordinateNave][ascisseNave] = "A"; // potevo usare un for
					campo[ordinateNave + 1][ascisseNave] = "o";
					campo[ordinateNave + 2][ascisseNave] = "V";
				}
			} else {// orizzontale
				ordinateNave = rnd.nextInt(8);
				ascisseNave = rnd.nextInt(6);
				if (campo[ordinateNave][ascisseNave].equals("~") && campo[ordinateNave][ascisseNave + 1].equals("~")
						&& campo[ordinateNave][ascisseNave + 2].equals("~")) {
					campo[ordinateNave][ascisseNave] = "<";
					campo[ordinateNave][ascisseNave + 1] = "o";
					campo[ordinateNave][ascisseNave + 2] = ">";
				}
			}
			for (int i = 0; i < 8; i++) {// conta navi
				for (int j = 0; j < 8; j++) {
					if (!campo[i][j].equals("~"))
						conteggioNavi++;
				}
			}
		} while (conteggioNavi < 10);

		do {
		conteggioNavi = 0;
		versoNave = rnd.nextInt(2);// posizionamento nave vericale/orizzontale da 3 blocchi
		if (versoNave == 0) {// verticale
			ordinateNave = rnd.nextInt(5);
			ascisseNave = rnd.nextInt(8);
			if (campo[ordinateNave][ascisseNave].equals("~") && campo[ordinateNave + 1][ascisseNave].equals("~")
					&& campo[ordinateNave + 2][ascisseNave].equals("~") && campo[ordinateNave + 3][ascisseNave].equals("~")) {
				campo[ordinateNave][ascisseNave] = "A"; // potevo usare un for
				campo[ordinateNave + 1][ascisseNave] = "o";
				campo[ordinateNave + 2][ascisseNave] = "o";
				campo[ordinateNave + 3][ascisseNave] = "V";
			}
		} else {// orizzontale
			ordinateNave = rnd.nextInt(8);
			ascisseNave = rnd.nextInt(5);
			if (campo[ordinateNave][ascisseNave].equals("~") && campo[ordinateNave][ascisseNave + 1].equals("~")
					&& campo[ordinateNave][ascisseNave + 2].equals("~") 
					&& campo[ordinateNave][ascisseNave + 3].equals("~")) {
				campo[ordinateNave][ascisseNave] = "<";
				campo[ordinateNave][ascisseNave + 1] = "o";
				campo[ordinateNave][ascisseNave + 2] = "o";
				campo[ordinateNave][ascisseNave + 3] = ">";
			}
		}
		for (int i = 0; i < 8; i++) {// conta navi
			for (int j = 0; j < 8; j++) {
				if (!campo[i][j].equals("~"))
					conteggioNavi++;
			}
		}
		} while (conteggioNavi < 10);
//inizio ciclo mossa spari
		do {

			System.out.println("Dove vuoi sparare?");
			System.out.println("Inserisci ordinate: ");
			ordinateSparo = sc.nextInt();
			System.out.println("Inserisci ascisse: ");
			ascisseSparo = sc.nextInt();
			if (ascisseSparo < 8 && ordinateSparo < 8) {
				if (!campo[ordinateSparo][ascisseSparo].equals("~")) {
					campoPlayer[ordinateSparo][ascisseSparo] = "X";
					counter++;
					colpiSparati++;
					if (counter < conteggioNavi)
						System.out.println("Colpito!!");
					else
						System.out.println("Affondato!");
				} else {
					System.out.println("Acqua!");
					campoPlayer[ordinateSparo][ascisseSparo] = "o";
					colpiSparati++;
				}
			} else if (ascisseSparo == 420 && ordinateSparo == 420) {// stampa griglia delle navi per debugging più
																		// facile
				for (int i = 0; i < 8; i++) {
					for (int j = 0; j < 8; j++) {
						System.out.print(campo[i][j]);
					}
					System.out.println();
				}
				System.out.println("ADMIN CHECK");
			} else
				System.out.println("Fuori dal campo!");
			for (int i = 0; i < 8; i++) {// stampa griglia
				for (int j = 0; j < 8; j++) {
					System.out.print(campoPlayer[i][j]);
				}
				System.out.println();
			}
		} while (counter < conteggioNavi);
		System.out.println("\r\n" + "██   ██  █████  ██     ██    ██ ██ ███    ██ ████████  ██████  ██ \r\n"
				+ "██   ██ ██   ██ ██     ██    ██ ██ ████   ██    ██    ██    ██ ██ \r\n"
				+ "███████ ███████ ██     ██    ██ ██ ██ ██  ██    ██    ██    ██ ██ \r\n"
				+ "██   ██ ██   ██ ██      ██  ██  ██ ██  ██ ██    ██    ██    ██    \r\n"
				+ "██   ██ ██   ██ ██       ████   ██ ██   ████    ██     ██████  ██ \r\n"
				+ "                                                                  \r\n"
				+ "                                                                  \r\n" + "");
		System.out.println("Colpi sparati: " + colpiSparati);
	}
}