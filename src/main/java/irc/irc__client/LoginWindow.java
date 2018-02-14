package irc.irc__client;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.Socket;

import javax.swing.*;

public class LoginWindow {


    private String Nazwa;
    private String Serwer;
    private String Port;

    JPanel pnPanel0;
    ButtonGroup rbgPanel0;
    JToggleButton tbtTglBut0;

    JPanel pnPanel6;
    JLabel lbLabel3;
    JLabel lbLabel4;
    JLabel lbLabel5;
    JTextField tfNazwa;
    JTextField tfSerwer;
    JTextField tfPort;

    public LoginWindow()
    {
        JFrame guiFrame = new JFrame();

        guiFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        guiFrame.setTitle("Login");
        guiFrame.setSize(400,150);

        guiFrame.setLocationRelativeTo(null);

        pnPanel0 = new JPanel();
        rbgPanel0 = new ButtonGroup();
        GridBagLayout gbPanel0 = new GridBagLayout();
        GridBagConstraints gbcPanel0 = new GridBagConstraints();
        pnPanel0.setLayout( gbPanel0 );

        tbtTglBut0 = new JToggleButton( "Login"  );
        tbtTglBut0.setSelected( true );
        rbgPanel0.add( tbtTglBut0 );
        gbcPanel0.gridx = 0;
        gbcPanel0.gridy = 1;
        gbcPanel0.gridwidth = 3;
        gbcPanel0.gridheight = 1;
        gbcPanel0.fill = GridBagConstraints.BOTH;
        gbcPanel0.weightx = 1;
        gbcPanel0.weighty = 0;
        gbcPanel0.anchor = GridBagConstraints.NORTH;
        gbPanel0.setConstraints( tbtTglBut0, gbcPanel0 );
        pnPanel0.add( tbtTglBut0 );
        tbtTglBut0.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                JToggleButton tBtn = (JToggleButton)e.getSource();
                if (tBtn.isSelected()) {
                    //Akcje kiedy wcisniemy przycisk
                    Socket s = null;

                    Nazwa = tfNazwa.getText();
                    Serwer = tfSerwer.getText();
                    Port = tfPort.getText();

                    try {

                        s = new Socket(getSerwer(), Integer.parseInt(getPort()));

                        Thread listener = new ServerListener(s);
                        listener.start();

                        Thread sender = new ServerSender(s);
                        sender.start();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }

                }
            }
        });

        pnPanel6 = new JPanel();
        pnPanel6.setBorder( BorderFactory.createTitledBorder( "Dane" ) );
        GridBagLayout gbPanel6 = new GridBagLayout();
        GridBagConstraints gbcPanel6 = new GridBagConstraints();
        pnPanel6.setLayout( gbPanel6 );

        lbLabel3 = new JLabel( "Nazwa Użytkownika"  );
        gbcPanel6.gridx = 0;
        gbcPanel6.gridy = 0;
        gbcPanel6.gridwidth = 3;
        gbcPanel6.gridheight = 1;
        gbcPanel6.fill = GridBagConstraints.BOTH;
        gbcPanel6.weightx = 1;
        gbcPanel6.weighty = 1;
        gbcPanel6.anchor = GridBagConstraints.NORTH;
        gbPanel6.setConstraints( lbLabel3, gbcPanel6 );
        pnPanel6.add( lbLabel3 );

        lbLabel4 = new JLabel( "Serwer"  );
        gbcPanel6.gridx = 0;
        gbcPanel6.gridy = 1;
        gbcPanel6.gridwidth = 3;
        gbcPanel6.gridheight = 1;
        gbcPanel6.fill = GridBagConstraints.BOTH;
        gbcPanel6.weightx = 1;
        gbcPanel6.weighty = 1;
        gbcPanel6.anchor = GridBagConstraints.NORTH;
        gbPanel6.setConstraints( lbLabel4, gbcPanel6 );
        pnPanel6.add( lbLabel4 );

        lbLabel5 = new JLabel( "Port"  );
        gbcPanel6.gridx = 0;
        gbcPanel6.gridy = 2;
        gbcPanel6.gridwidth = 1;
        gbcPanel6.gridheight = 1;
        gbcPanel6.fill = GridBagConstraints.BOTH;
        gbcPanel6.weightx = 1;
        gbcPanel6.weighty = 1;
        gbcPanel6.anchor = GridBagConstraints.NORTH;
        gbPanel6.setConstraints( lbLabel5, gbcPanel6 );
        pnPanel6.add( lbLabel5 );

        tfNazwa = new JTextField( );
        gbcPanel6.gridx = 1;
        gbcPanel6.gridy = 0;
        gbcPanel6.gridwidth = 1;
        gbcPanel6.gridheight = 1;
        gbcPanel6.fill = GridBagConstraints.BOTH;
        gbcPanel6.weightx = 1;
        gbcPanel6.weighty = 0;
        gbcPanel6.anchor = GridBagConstraints.NORTH;
        gbPanel6.setConstraints( tfNazwa, gbcPanel6 );
        pnPanel6.add( tfNazwa );

        tfSerwer = new JTextField( );
        gbcPanel6.gridx = 1;
        gbcPanel6.gridy = 1;
        gbcPanel6.gridwidth = 1;
        gbcPanel6.gridheight = 1;
        gbcPanel6.fill = GridBagConstraints.BOTH;
        gbcPanel6.weightx = 1;
        gbcPanel6.weighty = 0;
        gbcPanel6.anchor = GridBagConstraints.NORTH;
        gbPanel6.setConstraints( tfSerwer, gbcPanel6 );
        pnPanel6.add( tfSerwer );

        tfPort = new JTextField( );
        gbcPanel6.gridx = 1;
        gbcPanel6.gridy = 2;
        gbcPanel6.gridwidth = 1;
        gbcPanel6.gridheight = 1;
        gbcPanel6.fill = GridBagConstraints.BOTH;
        gbcPanel6.weightx = 1;
        gbcPanel6.weighty = 0;
        gbcPanel6.anchor = GridBagConstraints.NORTH;
        gbPanel6.setConstraints( tfPort, gbcPanel6 );
        pnPanel6.add( tfPort );
        gbcPanel0.gridx = 0;
        gbcPanel0.gridy = 0;
        gbcPanel0.gridwidth = 1;
        gbcPanel0.gridheight = 1;
        gbcPanel0.fill = GridBagConstraints.BOTH;
        gbcPanel0.weightx = 1;
        gbcPanel0.weighty = 0;
        gbcPanel0.anchor = GridBagConstraints.NORTH;
        gbPanel0.setConstraints( pnPanel6, gbcPanel0 );
        pnPanel0.add( pnPanel6 );

        guiFrame.add(pnPanel0, BorderLayout.NORTH);
        //make sure the JFrame is visible
        guiFrame.setVisible(true);

    }

    public String getNazwa() {
        return Nazwa;
    }

    public String getSerwer() {
        return Serwer;
    }

    public String getPort() {
        return Port;
    }


}