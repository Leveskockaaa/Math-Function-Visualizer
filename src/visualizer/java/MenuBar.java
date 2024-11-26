import javax.swing.*;
import java.awt.*;
import java.util.List;

public class MenuBar extends JMenuBar {
    Frame frame;

    // Creates the menu bar, which can be added to the frame
    public MenuBar(Frame frame, List<String> menuTitles, List<String[]> subMenuTitles, List<String[]> subMenuIcons) {
        this.frame = frame;

        setPreferredSize(new Dimension(getWidth(), 30));

        for (int iter = 0; iter < menuTitles.size(); iter++) {
            String menuTitle = menuTitles.get(iter);
            String[] subMenuTitleList = subMenuTitles.get(iter);
            String[] subMenuIconList = subMenuIcons.get(iter);

            Menu menu = new Menu(frame ,menuTitle, subMenuTitleList, subMenuIconList);
            add(menu);
        }
    }
}
