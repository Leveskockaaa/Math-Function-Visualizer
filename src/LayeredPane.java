import javax.swing.*;
import java.awt.*;

public class LayeredPane extends JLayeredPane {
    public LayeredPane() {
        super();
        setBackground(new Color(0,0,0,0));
        setPreferredSize(new Dimension(getWidth(), getHeight()));
        setBounds(0,0,getWidth(), getHeight());
    }
}