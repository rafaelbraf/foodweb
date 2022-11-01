package Util;

import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;

public class GerenteDeJanelas {
    
    private static JDesktopPane jDesktopPane;
    int idRestaurante;
    
    public GerenteDeJanelas(JDesktopPane jDesktopPane) {
        GerenteDeJanelas.jDesktopPane = jDesktopPane;
    }
    
    public void abrirJanelas(JInternalFrame jInternalFrame) {
        if (jInternalFrame.isVisible()) {
            jInternalFrame.toFront();
            jInternalFrame.requestFocus();  
        } else {
            jDesktopPane.add(jInternalFrame);
            jInternalFrame.setVisible(true);
            jInternalFrame.setClosable(true);
        }
    }
    
}
