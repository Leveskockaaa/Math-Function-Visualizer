import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.awt.*;

public class FunctionTest {
    @Test
    void sameObjectTest() {
        Frame frame = new Frame(1920,1080, 100, 100, 10, 10);
        LinearFunction linearFunction = new LinearFunction(1920,1080,2,0,100,100, Color.RED);
        linearFunction.calculatePolygon();
        frame.addFunction(linearFunction);

        assertTrue(frame.functions.containsKey(linearFunction));
    }

    @Test
    void emptyAfterRemoveTest() {
        Frame frame = new Frame(1920,1080, 100, 100, 10, 10);
        LinearFunction linearFunction = new LinearFunction(1920,1080,2,0,100,100, Color.RED);
        linearFunction.calculatePolygon();
        frame.addFunction(linearFunction);
        frame.removeFunction(linearFunction);

        assertEquals(0, frame.functions.size());
        assertNull(frame.functions.get(linearFunction));
    }

    @Test
    void checkLinearFunction() {
        LinearFunction function = new LinearFunction(1920,1080,2,0,100,100, Color.RED);
        function.calculatePolygon();

        assertEquals(540, function.polygon.ypoints[960]);
        assertEquals(Color.RED, function.color);
    }

    @Test
    void checkPowerFunction() {
        PowerFunction function = new PowerFunction(1920, 1080, 2, 0, 0, 100, 100, Color.BLUE);
        function.calculatePolygon();

        assertEquals(440, function.polygon.ypoints[1060]);
        assertEquals(Color.BLUE, function.color);
    }

    @Test
    void checkExponentialFunction() {
        ExponentialFunction function = new ExponentialFunction(1920, 1080, 2, 100, 100, 0, 0, Color.GREEN);
        function.calculatePolygon();

        assertEquals(440, function.polygon.ypoints[960]);
        assertEquals(Color.GREEN, function.color);
    }

    @Test
    void checkSinusFunction() {
        Sinus function = new Sinus(1920,1080,2,100,100,Color.ORANGE);
        function.calculatePolygon();

        assertEquals(540, function.polygon.ypoints[960]);
        assertEquals(Color.ORANGE, function.color);
    }

    @Test
    void checkCosineFunction() {
        Cosine function = new Cosine(1920,1080,2,100,100,Color.PINK);
        function.calculatePolygon();

        assertEquals(340, function.polygon.ypoints[960]);
        assertEquals(Color.PINK, function.color);
    }
}
