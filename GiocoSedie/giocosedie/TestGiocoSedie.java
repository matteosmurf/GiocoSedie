/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package giocosedie;

import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Logger;
import java.util.Scanner;

/**
 *
 * @author matteosmurf
 */
public class TestGiocoSedie {
    private final static int NUMPARTECIPANTI = 0;
    private static Logger logger = Logger.getLogger("GiocoSedie.TestGiocoSedie");
    
    /**
     * @param args the command line arguments
     */
    @SuppressWarnings("deprecation")
public static void main(String[] args) {

        System.out.println("Inserisci il numero di partecipanti: ");
        Scanner scanner = new Scanner(System.in);
        int NUMPARTECIPANTI = scanner.nextInt();
        scanner.close();

        Posto sedie[] = new Posto[NUMPARTECIPANTI - 1];
	for (int k = 0; k < sedie.length; k++)
		sedie[k] = new Posto();

	Display display = new Display(sedie);
	//System.out.println("Sto facendo partire il Display.");
        logger.info("Sto facendo partire il Display.\n");
	display.start();
        
        try {
                FileWriter scrittore = new FileWriter("risultato.txt");
                scrittore.write("");
                scrittore.close();
        } catch (IOException e) {
                System.out.println("file azzerato");
                e.printStackTrace();
        }

	Partecipante array[] = new Partecipante[NUMPARTECIPANTI];
	for (int i = 0; i < NUMPARTECIPANTI; i++) {
		array[i] = new Partecipante(sedie);
                //System.out.println("Sto facendo partire il thread n." + array[i].getId());
                logger.info("Sto facendo partire il thread id: " + array[i].getId()+" name: "+array[i].getName()+"\n");
                array[i].start();
                }
	}
    }