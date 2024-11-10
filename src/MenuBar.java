import javax.swing.*;
import java.awt.*;
import java.util.List;

public class MenuBar extends JMenuBar {
    public MenuBar(List<String> menuTitles, List<String[]> subMenuTitles, List<String[]> subMenuIcons) {
        setPreferredSize(new Dimension(getWidth(), 30));

        for (int iter = 0; iter < menuTitles.size(); iter++) {
            String menuTitle = menuTitles.get(iter);
            String[] subMenuTitleList = subMenuTitles.get(iter);
            String[] subMenuIconList = subMenuIcons.get(iter);

            Menu menu = new Menu(menuTitle, subMenuTitleList, subMenuIconList);
            add(menu);
        }
    }
}
