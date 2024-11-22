import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class ButtonListener implements ActionListener {
    Frame frame;
    Map<Button, Function> buttons;

    public ButtonListener(Frame frame, Map<Button, Function> buttons) {
        this.frame = frame;
        this.buttons = buttons;
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        Button clickedButton = (Button) event.getSource();
        List<Map.Entry<Button, Function>> toRemove = new ArrayList<>();

        for (Map.Entry<Button, Function> entry : buttons.entrySet()) {
            Button button = entry.getKey();

            if (clickedButton.equals(button)) {
                toRemove.add(entry);
            }
        }

        for (Map.Entry<Button, Function> entry : toRemove) {
            frame.removeFunction(entry.getValue());
            buttons.remove(entry.getKey());
        }
    }
}
