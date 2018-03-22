package irc.irc__client;

import javax.swing.*;
import java.awt.*;

public class LoginDialog extends JDialog {

    private String serverLabel = null;
    private String portLabel = null;
    private String nickLabel = null;
    private JTextField serverInput;
    private JTextField portInput;
    private JTextField nickInput;

    public LoginDialog(Frame owner, String title) {
        super(owner, title, true);

    }

}
