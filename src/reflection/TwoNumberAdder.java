package reflection;

public class TwoNumberAdder {
    Number a;
    Number b;


    public TwoNumberAdder(Integer first, Integer second){
        a = first;
        b = second;
    }

    public TwoNumberAdder(Integer only){
        a = only;
        b = only;
    }

    @Override
    public String toString(){
        return ("" + (a.intValue()+b.intValue()));
    }

    public static void main(String[] args) {
        System.out.println(new TwoNumberAdder(2));
    }
}
