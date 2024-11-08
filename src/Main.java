import java.awt.*;

public class Main {
    public static void main(String[] args) {
        int width = 1920;
        int height = 1080;
        int distanceX = 100;
        int distanceY = 100;
        int heightX = 20;
        int widthY = 20;

        Frame frame = new Frame(width, height, distanceX, distanceY, heightX, widthY);

        frame.addFunction(new LinearFunction(width, height,3,-2,distanceX,distanceY, Color.ORANGE));
        frame.addFunction(new PowerFunction(width, height,2f,0,0,distanceX,distanceY, Color.BLUE));
        frame.addFunction(new Sinus(width, height,4f,distanceX,distanceY, Color.GREEN));
        frame.addFunction(new Cosine(width, height,2f,distanceX,distanceY, Color.RED));
        frame.addFunction(new ExponentialFunction(width, height,1/2f,distanceX,distanceY,0,0, Color.RED));
    }
}