import java.io.PrintStream;

public abstract class Commande {
	
	protected PrintStream ps;
	protected String commandeNom = "";
	protected String [] commandeArgs ;
	InformationClient cl;
	
	public Commande(PrintStream ps, String commandeStr,InformationClient cl ) {
		this.ps = ps ;
		String [] args = commandeStr.split(" ");
		commandeNom = args[0];
		commandeArgs = new String[args.length-1];
		
		for(int i=0; i<commandeArgs.length; i++) {
			commandeArgs[i] = args[i+1];
		}
		this.cl = cl;
	}
	
	public abstract void execute();

}
