package refactor;

import com.sun.xml.internal.ws.developer.MemberSubmissionAddressing;

public class StrategyModel {
    public interface ValidationStrategy{
        boolean execute(String s);
    }
    public class isAllLowerCase implements ValidationStrategy{
        public boolean execute(String s){
            return s.matches("[a-z]+");
        }
    }
    public class isNumeric implements ValidationStrategy{
        public boolean execute(String s){
            return s.matches("\\d+");
        }
    }
    public class Validator{
        private final ValidationStrategy strategy;

        public Validator(ValidationStrategy v){
            this.strategy = v;
        }
        public boolean validate(String s){
            return strategy.execute(s);
        }
    }
    public static  void main(String [] args){
        Validator numericValidator = new StrategyModel().new Validator(new StrategyModel().new isNumeric());
        boolean b1 = numericValidator.validate("aaaa");
        System.out.println(b1);
    }
}
