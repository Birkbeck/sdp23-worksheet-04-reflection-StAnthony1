package reflection;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import java.lang.reflect.*;
import java.util.ArrayList;


public class Autograder {

    static final String CLASS_NAME = "java.lang.Void"; // TODO: How would you best get
    // TODO this field to mirror the class which is passed to it? Create another class
    //TODO handles reading of the student's class file?

    //TODO can use @BeforeAll or is it @Beforeall? to implement a field (c)
    // which can refer to the class thereafter you can also use @Beforeeach - which

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
    public void noMorethan2privatehelpers() throws ClassNotFoundException {
        Class<?> testclass = Class.forName(CLASS_NAME);
        Method[] methods = testclass.getDeclaredMethods();
        int num_helpers = 0;
        for (Method m : methods) {
            if (Modifier.PROTECTED == m.getModifiers() | m.getModifiers() == Modifier.PRIVATE)
            {
                num_helpers += 1;
            }
            assert (num_helpers < 3);
            // TODO: find out how to distinguish a helper method from another private method

        }
    }

    @Test
    public void hasMethodThatThrows() throws ClassNotFoundException{
        Class<?> testclass = Class.forName(CLASS_NAME);
        Method[] methods = testclass.getDeclaredMethods();
        boolean pass = true;
        for(Method m: methods){
            Type[] ex_arr = m.getGenericExceptionTypes();
            if (ex_arr.length > 0) {
                pass = false;
                break;
            }
        }
        assert (pass);
    }

    @Test
    public void noMethodReturnsInt() throws ClassNotFoundException{
        Class<?> testclass = Class.forName(CLASS_NAME);
        Method[] methods = testclass.getDeclaredMethods();
        boolean pass = true;
        for(Method m: methods){
            if(m.getAnnotatedReturnType().getType().equals(int.class)) pass = false;
        }
        assert (pass);
    }

    @Test
    public void noZeroArgConstructor() throws ClassNotFoundException{
        Class<?> testclass = Class.forName(CLASS_NAME);
        Constructor<?>[] constructors = testclass.getDeclaredConstructors();
        boolean pass = true;
        for(Constructor<?> c : constructors) {
           if (c.getGenericParameterTypes().length < 1) pass = false;
        }
        assert (pass);
    }
}

