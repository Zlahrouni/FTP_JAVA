import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintStream;

/**
 * Cette classe représente une commande "get" qui permet de récupérer le contenu d'un fichier.
 * Cette commande hérite de la classe Commande et implémente la méthode execute().
 * 
 * @author Ziad Lahrouni
 */
public class CommandeGET extends Commande {
	
	/**
	 * Constructeur de la classe CommandeGET.
	 * 
	 * @param ps          Le flux de sortie où les résultats de la commande doivent
	 *                    être imprimés.
	 * @param commandeStr La chaîne de caractères qui représente la commande "get".
	 */
	public CommandeGET(PrintStream ps, String commandeStr) {
		super(ps, commandeStr);
	}

	/**
	 * Cette méthode exécute la commande "get" en affichant le contenu du fichier spécifié
	 * dans les arguments de la commande dans le flux de sortie spécifié dans le constructeur.
	 */
	public void execute() {
		if(this.commandeArgs.length != 0) {
			File fichier = new File(this.commandeArgs[0]);
			try {
				FileInputStream in = new FileInputStream(System.getProperty("user.dir") + "\\" +fichier);
				BufferedInputStream bis = new BufferedInputStream(in);
				
				// Lire le contenu du fichier et l'écrire dans le PrintStream
		        byte[] buffer = new byte[1024];
		        int count;
		        while ((count = bis.read(buffer)) != -1) {
		            ps.write(buffer, 0, count);
		        }
		        
		        ps.println("0 File download finished successfully.");
		        bis.close();
		        
			} catch ( IOException e) {
				ps.println("2 Unable to complete command due to error.");
				e.printStackTrace();
			}
		
			
		} else {
			ps.println("2 USAGE : GET [file]");
		}
		
	}

}
