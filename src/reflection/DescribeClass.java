package reflection;
import javax.sound.midi.Soundbank;
import javax.swing.*;
import java.util.Arrays;
import java.lang.Integer;


public class DescribeClass {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException {
        if (args.length != 1)
            System.out.println("Usage: pass a class as the single argument of the call\n" +
                    "to main for information on the class' name, Modifiers\n" +
                    "Fields and Methods");

        else {
            Class<?> obj = Class.forName(args[0]);
            System.out.println(obj.getCanonicalName());
            System.out.printf("1. Constrictors of %s:%n", obj);
            System.out.println(Arrays.toString(obj.getDeclaredConstructors()));
            System.out.printf("2. Modifiers of %s:%n", obj);
            System.out.println(obj.getModifiers());
            System.out.printf("3. Fields of %s:%n", obj);
            System.out.println(Arrays.toString((obj.getDeclaredFields())));
            System.out.printf("4. Methods of %s:%n", obj);
            System.out.println(Arrays.toString(obj.getMethods()));

            }
    }
}
