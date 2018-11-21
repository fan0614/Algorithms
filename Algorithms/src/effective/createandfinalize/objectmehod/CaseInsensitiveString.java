package effective.createandfinalize.objectmehod;

import java.util.ArrayList;
import java.util.List;

public class CaseInsensitiveString {
    private final String s;
    public CaseInsensitiveString(String s){
        if(s == null) throw new NullPointerException();
        this.s = s;
    }

    @Override
    public boolean equals(Object obj) {
//        if(obj instanceof CaseInsensitiveString){
//            return s.equalsIgnoreCase(((CaseInsensitiveString) obj).s);
//        }
//        if(obj instanceof String){
//            return s.equalsIgnoreCase((String) obj);
//        }
//        return false;
        return obj instanceof CaseInsensitiveString && ((CaseInsensitiveString)obj).s.equalsIgnoreCase(s);
    }

    public static void main(String[] args) {
        CaseInsensitiveString cis = new CaseInsensitiveString("Hello");
        String s = "hello";
        System.out.println(cis.equals(s));
        System.out.println(s.equals(cis));

        List<CaseInsensitiveString> list = new ArrayList<CaseInsensitiveString>();
        list.add(cis);
        System.out.println(list.contains(s));

    }
}
