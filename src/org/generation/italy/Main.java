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
		int versoNave, ordinateNave, ascisseNave, counter = 0, ordinateSparo, ascisseSparo;

		for (int i = 0; i < 8; i++) {// scrivi griglia base
			for (int j = 0; j < 8; j++) {
				campo[i][j] = "~";
				campoPlayer[i][j] = "~";
			}

		}

		versoNave = rnd.nextInt(2);// posizionamento nave vericale/orizzontale con random
		if (versoNave == 0) {//verticale
			ordinateNave = rnd.nextInt(6);
			ascisseNave = rnd.nextInt(8);
			campo[ordinateNave][ascisseNave] = "^"; //potevo usare un for
			campo[ordinateNave + 1][ascisseNave] = "o";
			campo[ordinateNave + 2][ascisseNave] = "V";
		} else {//orizzontale
			ordinateNave = rnd.nextInt(8);
			ascisseNave = rnd.nextInt(6);
			campo[ordinateNave][ascisseNave] = "<";
			campo[ordinateNave][ascisseNave + 1] = "o";
			campo[ordinateNave][ascisseNave + 2] = ">";
		}
//ripetizione mossa fino a counter colpiti 3
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
					if (counter < 3)
						System.out.println("Colpito!!");
					else
						System.out.println("Affondato!");
				} else {
					System.out.println("Acqua!");
					campoPlayer[ordinateSparo][ascisseSparo] = "o";
				}
			} else
				System.out.println("Fuori dal campo!");
			for (int i = 0; i < 8; i++) {// stampa griglia
				for (int j = 0; j < 8; j++) {
					System.out.print(campoPlayer[i][j]);
				}
				System.out.println();
			}
		} while (counter < 3);
		System.out.println("\r\n"
				+ "██   ██  █████  ██     ██    ██ ██ ███    ██ ████████  ██████  ██ \r\n"
				+ "██   ██ ██   ██ ██     ██    ██ ██ ████   ██    ██    ██    ██ ██ \r\n"
				+ "███████ ███████ ██     ██    ██ ██ ██ ██  ██    ██    ██    ██ ██ \r\n"
				+ "██   ██ ██   ██ ██      ██  ██  ██ ██  ██ ██    ██    ██    ██    \r\n"
				+ "██   ██ ██   ██ ██       ████   ██ ██   ████    ██     ██████  ██ \r\n"
				+ "                                                                  \r\n"
				+ "                                                                  \r\n"
				+ "");
	}
}