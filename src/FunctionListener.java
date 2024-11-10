import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FunctionListener implements ActionListener {
    Frame frame;

    public FunctionListener(Frame frame) {
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if (event.getActionCommand().equals("Add Linear Function")) {
            Function linearFunction = new LinearFunction(frame.width, frame.height,1,0,frame.distanceX, frame.distanceY, Color.ORANGE);
            frame.addFunction(linearFunction);
        }
        if (event.getActionCommand().equals("Add Power Function")) {
            Function powerFunction = new PowerFunction(frame.width, frame.height,2,0,0,frame.distanceX, frame.distanceY, Color.ORANGE);
            frame.addFunction(powerFunction);
        }
        if (event.getActionCommand().equals("Add Exponential Function")) {
            Function exponentialFunction = new ExponentialFunction(frame.width, frame.height,2, frame.distanceX, frame.distanceY, 0, 0, Color.ORANGE);
            frame.addFunction(exponentialFunction);
        }
        if (event.getActionCommand().equals("Add Sinus Function")) {
            Function sinusFunction = new Sinus(frame.width, frame.height,3, frame.distanceX, frame.distanceY, Color.ORANGE);
            frame.addFunction(sinusFunction);
        }
        if (event.getActionCommand().equals("Add Cosine Function")) {
            Function cosineFunction = new Cosine(frame.width, frame.height,2, frame.distanceX, frame.distanceY, Color.ORANGE);
            frame.addFunction(cosineFunction);
        }
    }
}
