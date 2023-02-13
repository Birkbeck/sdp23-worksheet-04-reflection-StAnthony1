package reflection;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.ArrayList;


public class Autograder {

    static final String CLASS_NAME = "java.lang.Integer"; // TODO: insert the class name to be tested

    @Test
    public void testMoreThanFourFields() throws ClassNotFoundException {
        Class<?> testClass = Class.forName(CLASS_NAME);
        assert (5 > testClass.getDeclaredFields().length);
    }

    @Test
    public void testNonPrivateFields() throws ClassNotFoundException {
        Class<?> testClass = Class.forName(CLASS_NAME);
        Field[] fields = testClass.getDeclaredFields();
        for (Field f : fields) {
            Assertions.assertNotEquals(2, f.getModifiers());
        }
    }

    @Test
    public void testNoArrayListField() throws ClassNotFoundException {
        Class<?> testClass = Class.forName(CLASS_NAME);
        Field[] fields = testClass.getDeclaredFields();
        for (Field f : fields) {
            Assertions.assertNotEquals(f.getGenericType(), ArrayList.class);
        }
    }

    @Test
    public void fewerthan2privatehelpers() throws ClassNotFoundException{
        Class<?> testclass = Class.forName(CLASS_NAME);
        // TODO: find out how to distinguish a helper method from another private method

    }
}

