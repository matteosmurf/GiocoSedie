package giocosedie;

import java.io.FileWriter;
import java.io.IOException;

/**
 * classe che rappresenta un partecipante al gioco.
 * Ogni partecipante è un thread.
 */


class Partecipante extends Thread {

	Posto sedie[];

	/**
	 * Costruttore per inizializzare un partecipante.
	 * @param sedie[] Array delle sedie libere.
	 */
	public Partecipante(Posto sedie[]) {

		this.sedie = sedie;

	}

	/**
	 * Metodo avvio thread partecipante.
	 * Controlla la disponibilità di un posto libero per il thread.
	 */
	public void run() {

		try {
			sleep((int) (Math.random() * 1000));

			for (int i = 0; i < sedie.length; i++) {
				if (sedie[i].occupa()) {
					System.out.println("Sono il Thread " + this.getName() + ". Sono riuscito a sedermi sul posto " + i);
					scriviFile(i);
					return;
				}
			}
			System.out.println("Sono il Thread " + this.getName() + ". Ho perso :((((");

		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * Metodo per scrivere il risultato del gioco in un file output.
	 * @param i indice della sedia occupata.
	 */
	public void scriviFile(int i) {
		try{
			FileWriter scrittore = new FileWriter("risultato.txt", true);
			scrittore.write("Thread: " + this.getId() + ", posto: " + i + "\n");
			scrittore.close();
			System.out.println("yy");
		} catch (IOException e) {
			System.out.println("nn");
			e.printStackTrace();
		} 
	}
}