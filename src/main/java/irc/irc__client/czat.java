package irc.irc__client;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
	
	public class czat {
		 
		 //Note: Typically the main method will be in a
		 //separate class. As this is a simple one class
		 //example it's all in the one class.
		 public static void main(String[] args) {
		 
		 new czat();
		 }

		 public czat()
		 {
			 JFrame guiFrame = new JFrame();
			 
				
			 guiFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			 guiFrame.setTitle("Wiadomosci");
			 guiFrame.setSize(600,800);
			
			 guiFrame.setLocationRelativeTo(null);
			 
			 JPanel pnPanel0;
			 JTextField tfText;
			 JButton btWyslij;

			 JPanel pnPanel_uzyt;
			 JTable tbUzytkownicy;

			 JPanel pnPanel_wiad;
			 JTable tbWiadomosci;

			 pnPanel0 = new JPanel();
			 GridBagLayout gbPanel0 = new GridBagLayout();
			 GridBagConstraints gbcPanel0 = new GridBagConstraints();
			 pnPanel0.setLayout( gbPanel0 );

			 tfText = new JTextField( );
			 gbcPanel0.gridx = 1;
			 gbcPanel0.gridy = 1;
			 gbcPanel0.gridwidth = 1;
			 gbcPanel0.gridheight = 1;
			 gbcPanel0.fill = GridBagConstraints.BOTH;
			 gbcPanel0.weightx = 1;
			 gbcPanel0.weighty = 0;
			 gbcPanel0.anchor = GridBagConstraints.NORTH;
			 gbPanel0.setConstraints( tfText, gbcPanel0 );
			 pnPanel0.add( tfText );

			 btWyslij = new JButton( "Wyslij"  );
			 gbcPanel0.gridx = 0;
			 gbcPanel0.gridy = 1;
			 gbcPanel0.gridwidth = 1;
			 gbcPanel0.gridheight = 1;
			 gbcPanel0.fill = GridBagConstraints.BOTH;
			 gbcPanel0.weightx = 1;
			 gbcPanel0.weighty = 0;
			 gbcPanel0.anchor = GridBagConstraints.NORTH;
			 gbPanel0.setConstraints( btWyslij, gbcPanel0 );
			 pnPanel0.add( btWyslij );
			 
			 btWyslij.addActionListener(new ActionListener() {

		         public void actionPerformed(ActionEvent e) {
		            JToggleButton tBtn = (JToggleButton)e.getSource();
		            if (tBtn.isSelected()) {
		               //Akcje kiedy wcisniemy przycisk
		            }
		         }
		      });

			 pnPanel_uzyt = new JPanel();
			 pnPanel_uzyt.setBorder( BorderFactory.createTitledBorder( "Zalogowani Uzytkownicy" ) );
			 GridBagLayout gbPanel_uzyt = new GridBagLayout();
			 GridBagConstraints gbcPanel_uzyt = new GridBagConstraints();
			 pnPanel_uzyt.setLayout( gbPanel_uzyt );
			 int ilosc_user = 3; // podajemy ilosc zalogowanych uzytkownikow pobrana z servera
			 String[][] dataUzytkownicy = new String[ilosc_user][ilosc_user];
			 
			 // petla start
			 String user = "Uzytkownik  A";
			 dataUzytkownicy[0][0] = user;
			 user = "Uzytkownik  B";
			 dataUzytkownicy[1][0] = user;
			 user = "Uzytkownik  C";
			 dataUzytkownicy[2][0] = user;
			 //petla end
			 // petla pobierajaca nazwy uzytkownikow i wstawiajaca do tablicy
			 
			 
			 String []colsUzytkownicy = new String[] { ""};
			 tbUzytkownicy = new JTable(dataUzytkownicy, colsUzytkownicy);
			 gbcPanel_uzyt.gridx = 0;
			 gbcPanel_uzyt.gridy = 0;
			 gbcPanel_uzyt.gridwidth = 1;
			 gbcPanel_uzyt.gridheight = 1;
			 gbcPanel_uzyt.fill = GridBagConstraints.BOTH;
			 gbcPanel_uzyt.weightx = 1;
			 gbcPanel_uzyt.weighty = 1;
			 gbcPanel_uzyt.anchor = GridBagConstraints.NORTH;
			 gbPanel_uzyt.setConstraints( tbUzytkownicy, gbcPanel_uzyt );
			 pnPanel_uzyt.add( tbUzytkownicy );
			 gbcPanel0.gridx = 0;
			 gbcPanel0.gridy = 0;
			 gbcPanel0.gridwidth = 1;
			 gbcPanel0.gridheight = 1;
			 gbcPanel0.fill = GridBagConstraints.BOTH;
			 gbcPanel0.weightx = 1;
			 gbcPanel0.weighty = 0;
			 gbcPanel0.anchor = GridBagConstraints.NORTH;
			 gbPanel0.setConstraints( pnPanel_uzyt, gbcPanel0 );
			 pnPanel0.add( pnPanel_uzyt );

			 pnPanel_wiad = new JPanel();
			 pnPanel_wiad.setBorder( BorderFactory.createTitledBorder( "Wiadomosci" ) );
			 GridBagLayout gbPanel_wiad = new GridBagLayout();
			 GridBagConstraints gbcPanel_wiad = new GridBagConstraints();
			 pnPanel_wiad.setLayout( gbPanel_wiad );
			 
			 // dorzucanie na kolejny element tabeli nazwy urzytkownika i stringu z wiadomoscia
			 String [][]dataWiadomosci = new String[][] { new String[] {"Uzytkownik A", "elo"}, 
			                                              new String[] {"Uzytkownik A", "jest tu ktos?"}, 
			                                              new String[] {"Uzytkownik B", "ja"} };
			 
			 
			 String []colsWiadomosci = new String[] { "", "" };
			 tbWiadomosci = new JTable( dataWiadomosci, colsWiadomosci );
			 gbcPanel_wiad.gridx = 0;
			 gbcPanel_wiad.gridy = 0;
			 gbcPanel_wiad.gridwidth = 9;
			 gbcPanel_wiad.gridheight = 11;
			 gbcPanel_wiad.fill = GridBagConstraints.BOTH;
			 gbcPanel_wiad.weightx = 1;
			 gbcPanel_wiad.weighty = 1;
			 gbcPanel_wiad.anchor = GridBagConstraints.NORTH;
			 gbPanel_wiad.setConstraints( tbWiadomosci, gbcPanel_wiad );
			 pnPanel_wiad.add( tbWiadomosci );
			 gbcPanel0.gridx = 1;
			 gbcPanel0.gridy = 0;
			 gbcPanel0.gridwidth = 1;
			 gbcPanel0.gridheight = 1;
			 gbcPanel0.fill = GridBagConstraints.BOTH;
			 gbcPanel0.weightx = 1;
			 gbcPanel0.weighty = 0;
			 gbcPanel0.anchor = GridBagConstraints.NORTH;
			 gbPanel0.setConstraints( pnPanel_wiad, gbcPanel0 );
			 pnPanel0.add( pnPanel_wiad );
			 guiFrame.add(pnPanel0, BorderLayout.NORTH);
			 //make sure the JFrame is visible
			 guiFrame.setVisible(true);
			 
			 //trzeba dodac czasowe odswiezenie listy uzytkownikow i wiadomosci
		 }
		 
		}
	