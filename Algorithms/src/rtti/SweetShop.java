package rtti;

public class SweetShop {
    public static void main(String[] args) {
        System.out.println("inside main");
        new Candy();
        System.out.println("After candy");
       // new Gum();
        try{
            Class.forName("rtti.Gum");
        }catch(Exception e){
            System.out.println("not find Gum");
        }
        System.out.println("after Gum");
        new Cookie();
    }
}
class Candy{
    static{
        System.out.println("loading candy");
    }
}
class Gum {
    static{
        System.out.println("loading Gum");
    }
}
class Cookie{
    static{
        System.out.println("loading Cookie");
    }
}

