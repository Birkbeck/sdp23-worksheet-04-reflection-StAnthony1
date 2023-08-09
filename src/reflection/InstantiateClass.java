package reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

//NB to run you ref a package with java package_name.class_name args
public class InstantiateClass {

    static Object constructUsingReflection(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException
    {
        if (args.length < 1)
            System.out.println("Usage: Constructs an object of the type of the \n " +
                    "first arg from cmd line using a constructor of\n " +
                    "that class which takes as its single parameter\n " +
                    "an arg. That parameter is the second arg from the\n " +
                    "cmd line");

        else {
            Class<?> cls = Class.forName(args[0]);
            Constructor<?>[] conArr = cls.getConstructors();//gets the constructor which takes a String arg
            // change the class of the arg for different constructor arg
            System.out.println(Arrays.asList(conArr));
            for (int i = 0; i < conArr.length; i++) {
                if (conArr[i].getParameterCount() == args.length - 1) //get correct num of params
                {
                    Object[] params = new Object[args.length - 1]; //create array for args tpe conversions
                    Class<?>[] ptypes = conArr[i].getParameterTypes();//get array of param types
                    for (int j = 0; j < ptypes.length; j++) {
                        params[j] = ptypes[j].getConstructor(String.class).newInstance(args[j + 1]);//convert String
                        // args on param line to correct types
                    }
                    return conArr[i].newInstance(params);//call constructor and with relevant typed params

                }

            }
        }
        throw new RuntimeException("no relevant constructor found.");
    }

    public static void main(String[] args) {
        try {
            System.out.println(constructUsingReflection(args));
        }
        catch (Exception e){
            System.err.println("The following eception was caught in main: " + e);
        }
    }
}
