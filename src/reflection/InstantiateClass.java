package reflection;

import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
//NB to run you ref a package with java package_name.class_name args
public class InstantiateClass {


    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException,
            InstantiationException, IllegalAccessException {
        if (args.length < 1)
            System.out.println("Usage: Constructs an object of the type of the \n " +
                    "first arg from cmd line using a constructor of\n " +
                    "that class which takes as its single parameter\n " +
                    "an arg. That parameter is the second arg from the\n " +
                    "cmd line");

        else{
            Class<?> obj = Class.forName(args[0]);
            Constructor<?> constructor = obj.getConstructor(String.class); //gets the constructor
            // which takes this type of arg
            var new_obj = constructor.newInstance(args[1]);
            System.out.println(new_obj);

        }
    }
}
