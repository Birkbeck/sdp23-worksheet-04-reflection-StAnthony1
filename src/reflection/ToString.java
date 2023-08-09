package reflection;
import javax.sound.midi.Soundbank;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ToString {
    public static String toString(Object obj) {
        //TODO: return Fields which the user has access to/capacity to set
        // So you want access to the getters of this object type and
        // you want to invoke the getter; do you make use of the isAccessible() method of Refelect?
        String printable = "";
        Class<?> c = obj.getClass();
        Field[] fields = c.getDeclaredFields();
        for (Field f: fields){
            try{
                Object f_val = f.get(obj);
                String f_name = f.getName();
                String printable_field = f_name + ": " + f_val.toString() + "\n";
                printable += printable_field;
            }
            catch (IllegalAccessException ignored){
                //TODO do you always want to skip these?
            }
        }
        return printable;
    }

    public static void main(String[] args) {
        Integer i = 10;
        Integer i2 = 2023;
        System.out.println(toString(i));
        System.out.println(toString(i2));
        System.out.println(i);
        System.out.println(i2);
    }
}
