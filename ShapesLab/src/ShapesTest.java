import kchandra423.kTesting.KException;
import processing.core.PApplet;

public class ShapesTest {
    public static void main(String[] args) throws Exception {
        exists_constructor();
        exists_getArea();
        exists_getPerimeter();
        exists_draw();
        exists_isPointInside();
//        String choice = args[0];
//        Method m = ShapesTest.class.getMethod(choice);
//        m.invoke(null);
    }
    private static void exists_constructor() throws NoSuchMethodException {
        try {
           Shape.class.getConstructor(double.class, double.class);
        } catch (Exception e) {
            throw new NoSuchMethodException();
        }
    }
    private static void exists_getPerimeter() throws NoSuchMethodException {
        try {
            Shape.class.getMethod("getPerimeter");
        } catch (Exception e) {
            throw new NoSuchMethodException();
        }
    }

    private static void exists_getArea() throws NoSuchMethodException {
        try {
            Shape.class.getMethod("getArea");
        } catch (Exception e) {
            throw new NoSuchMethodException();
        }
    }

    private static void exists_isPointInside() throws NoSuchMethodException {
        try {
            Shape.class.getMethod("isPointInside", double.class, double.class);
        } catch (Exception e) {
            throw new NoSuchMethodException();
        }
    }
    private static void exists_draw() throws NoSuchMethodException {
        try {
            Shape.class.getMethod("draw", PApplet.class);
        } catch (Exception e) {
            throw new NoSuchMethodException("Draw method with ");
        }
    }
    private static void exists(String className, String methodName, Class... params) throws ClassNotFoundException, NoSuchMethodException {
        Class.forName(className).getMethod(methodName, params);
    }





}
