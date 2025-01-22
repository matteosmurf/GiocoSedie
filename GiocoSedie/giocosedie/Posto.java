package giocosedie;

/**
 * Classe che rappresenta la singola sedia nel gioco.
 */

class Posto {

	private boolean occupato;

	public Posto()

	{
		occupato = false;
	}

	/**
	 * Metodo sincronizzato per verificare se la sedia è libera.
	 * @return true se libera, false se occupata.
	 */
	public synchronized boolean libero() {
		return (!occupato);
	}

	/**
	 * Metodo sincronizzato per occupare una sedia.
	 * @return true se è stato possibile occupare la sedia, false se era già occupata.
	 */
	public synchronized boolean occupa() {
		if (occupato)
			return false;
		else
			return occupato = true;
	}
}