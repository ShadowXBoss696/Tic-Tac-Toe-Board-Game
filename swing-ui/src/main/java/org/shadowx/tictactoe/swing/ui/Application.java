package org.shadowx.tictactoe.swing.ui;

import java.util.Optional;
import java.util.stream.Stream;
import javax.swing.*;

import static javax.swing.UIManager.LookAndFeelInfo;

import org.shadowx.tictactoe.swing.ui.menu.MainMenu;

public class Application {
    
    private static final String DEFAULT_LOOK_AND_FEEL_NAME = "Nimbus";
    
    private static void initLookAndFeel() {
        try {
            LookAndFeelInfo[] installedLookAndFeels = UIManager.getInstalledLookAndFeels();
            
            Optional<LookAndFeelInfo> selectedLookAndFeel = Stream.of(installedLookAndFeels)
                    .filter(info -> DEFAULT_LOOK_AND_FEEL_NAME.equalsIgnoreCase(info.getName()))
                    .findFirst();
            
            if (selectedLookAndFeel.isPresent()) {
                LookAndFeelInfo info = selectedLookAndFeel.get();
                UIManager.setLookAndFeel(info.getClassName());
            }
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        initLookAndFeel();
        
        // Display Main Menu (Use Separate Thread for GUI)
        SwingUtilities.invokeLater(() -> {
            MainMenu.getInstance().setVisible(true);
        });
    }
}
