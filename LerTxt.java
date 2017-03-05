import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.IllegalStateException;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.ResourceBundle;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
public class LerTxt{
	  private Scanner input;
	  ArrayList<AccountRecord> records = new ArrayList<>();
	  AccountRecord contaAtiva = new AccountRecord();
	  // enable user to open file
	    public void openFile()
	    {
	       try
	       {
	           input = new Scanner(  new File( "src/usuario.txt" ) );
	       } // end try
	       catch ( FileNotFoundException fileNotFoundException )
	       {
	          System.err.println( "Error opening file." );
	          System.exit( 1 );
	       } 
	    }
	    
	   public void readRecords()
	    { 	        
		   try {
				while (input.hasNext()) {
					AccountRecord acc = new AccountRecord();
					acc.setLogin(input.next());
					acc.setSenha(input.next());
					acc.setPerfil(input.next());
					records.add(acc);
					System.out.printf("%-12s%-12s%-12s\n", contaAtiva.getLogin(), contaAtiva.getSenha(), contaAtiva.getPerfil());
				}
	       } 
	       catch ( NoSuchElementException elementException )
	       {
	          System.err.println( "File improperly formed." );
	          input.close();
	          System.exit( 1 );
	       } 	       catch ( IllegalStateException stateException )
	       {
	          System.err.println( "Error reading from file." );
	          System.exit( 1 );
	       } 
	    }
	/*	public void comparar()
		{
			
			LoginGUI g = new LoginGUI();
			if(record.getLogin().equals(g.tLogin.getText() )&& record.getSenha().equals(g.tSenha.getPassword())) 
			{
				System.out.println("Rola");

				
			}else{
				JOptionPane.showMessageDialog(null,"Login e senha nao validos!");

			}

		}*/
	   public boolean existeLogin(AccountRecord usuario) {
			openFile();
			readRecords();
			closeFile();
			boolean existe = false;
			for(int i = 0; i < records.size(); i++){
				if(records.get(i).getLogin().equals(usuario.getLogin())){
					if(records.get(i).getSenha().equals(usuario.getSenha())){
						contaAtiva = records.get(i);
						existe = true;
					}
				}
			}
			return existe;
		}
	    public void closeFile()
	    {
	       if ( input != null )
	          input.close();
	    } 


	    

}
