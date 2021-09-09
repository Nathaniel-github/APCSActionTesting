import kchandra423.kTesting.KException;
import processing.core.PApplet;
import yea.ok.Shape;

import java.io.File;
import java.lang.reflect.InvocationTargetException;

import static kchandra423.kTesting.KAssertion.*;

public class ShapesTest {

    public static void main(String[] args) throws Exception {
        existsGetAreaRectangle();
        existsGetPerimeterRectangle();
        existsIsPointInsideRectangle();
        isPointInsideRectangleEdges();
        isPointInsideRectangleInside();
        isPointInsideRectangleOutside();
        getPerimeterRectangle();
        getAreaRectangle();


//        String choice = args[0];
//        Method m = ShapesTest.class.getMethod(choice);
//        m.invoke(null);
    }
    private static void existsNoArgConstructorRectangle(){
        Object rec1 = getRectangle();
        try {
            rec1.getClass().getConstructor();
        } catch (NoSuchMethodException e) {
            throw new KException("No arg constructor", rec1);
        }
    }
    private static void existsConstructorRectangle(){
        Object rec1 = getRectangle(0, 0, 10, 20);
        try {
            rec1.getClass().getConstructor();
        } catch (NoSuchMethodException e) {
            throw new KException("No arg constructor", rec1);
        }
    }
    private static void existsIsPointInsideRectangle(){
        Object rec1 = getRectangle(0, 0, 10, 20);
        kAssertTrue("isPointInside", rec1, 0., 5.);
    }
    private static void existsGetPerimeterRectangle(){
        Object rec1 = getRectangle(0, 0, 10, 20);
        kAssertEquals("getPerimeter", rec1, 60.);
    }
    private static void existsGetAreaRectangle(){
        Object rec1 = getRectangle(0, 0, 10, 20);
        kAssertEquals("getArea", rec1, 200.);
    }

    private static void isPointInsideRectangleEdges() {
        Object rec1 = getRectangle(0, 0, 10, 20);
        kAssertTrue("isPointInside", rec1, 0., 5.);
        kAssertTrue("isPointInside", rec1, 10., 0.);
        kAssertTrue("isPointInside", rec1, 10., 20.);
        kAssertTrue("isPointInside", rec1, 0., 20.);
        kAssertTrue("isPointInside", rec1, 5., 20.);
    }
    private static void isPointInsideRectangleInside() {
        Object rec1 = getRectangle(0, 0, 10, 20);
        kAssertTrue("isPointInside", rec1, 5., 10.);
        kAssertTrue("isPointInside", rec1, 7., 15.);
        kAssertTrue("isPointInside", rec1, 2., 5.);
    }
    private static void isPointInsideRectangleOutside() {
        Object rec1 = getRectangle(0, 0, 10, 20);
        kAssertFalse("isPointInside", rec1, 11., 10.);
        kAssertFalse("isPointInside", rec1, -1., 10.);
        kAssertFalse("isPointInside", rec1, 5., -1.);
        kAssertFalse("isPointInside", rec1, 5., 21.);
        kAssertFalse("isPointInside", rec1, 11., -1.);
        kAssertFalse("isPointInside", rec1, 11., 21.);
    }
    private static void getPerimeterRectangle() {
        Object rec1 = getRectangle(0, 0, 10, 20);
        kAssertEquals("getPerimeter", rec1, 60.);
        rec1 = getRectangle(0, 0, 10, 10);
        kAssertEquals("getPerimeter", rec1, 40.);
        rec1 = getRectangle(0, 0, 20, 20);
        kAssertEquals("getPerimeter", rec1, 80.);
        rec1 = getRectangle(0, 0, 10, 5);
        kAssertEquals("getPerimeter", rec1, 30.);
    }
    private static void getAreaRectangle() {
        Object rec1 = getRectangle(0, 0, 10, 20);
        kAssertEquals("getArea", rec1, 200.);
        rec1 = getRectangle(0, 0, 10, 10);
        kAssertEquals("getArea", rec1, 100.);
        rec1 = getRectangle(0, 0, 20, 20);
        kAssertEquals("getArea", rec1, 400.);
        rec1 = getRectangle(0, 0, 10, 5);
        kAssertEquals("getArea", rec1, 50.);
    }

    private static Object getCircle(double x, double y, double width, double height) {
        try {
            return Class.forName(getFullyQualifiedName("Circle")).getConstructor(double.class, double.class, double.class, double.class).newInstance(x, y, width, height);
        } catch (ClassNotFoundException | NoSuchMethodException | InvocationTargetException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
    private static Object getRectangle() {
        try {
            return Class.forName(getFullyQualifiedName("Rectangle")).newInstance();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
    private static Object getRectangle(double x, double y, double width, double height) {
        try {
            return Class.forName(getFullyQualifiedName("Rectangle")).getConstructor(double.class, double.class, double.class, double.class).newInstance(x, y, width, height);
        } catch (ClassNotFoundException | NoSuchMethodException | InvocationTargetException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static String getFullyQualifiedName(String className) {
        File src = new File(System.getProperty("user.dir") + "/src");
        return getFullyQualifiedName(src, className, "");
    }

    private static String getFullyQualifiedName(File dir, String className, String current) {
        for (File file : dir.listFiles()) {
            if (file.isDirectory()) {
                String val = getFullyQualifiedName(file, className, current + file.getName() + ".");
                if(val != null){
                    return val;
                }
            } else if (file.getName().equals(className + ".java")) {
                return current + className;
            }
        }
        return null;
    }


}
