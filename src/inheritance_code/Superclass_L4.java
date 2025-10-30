package inheritance_code;

public class Superclass_L4 {

    private int num = 1;
    protected int getNumber() {
        return num;
    }
}

class Subclass extends Superclass_L4 {

    private int num = 10;
    
    @Override
    protected int getNumber() {
        return num + 5;
    }

    public static void main(String[] args) {
        Subclass s = new Subclass();
        System.out.println(s.getNumber());
    }
}