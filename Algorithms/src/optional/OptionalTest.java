package optional;

import java.util.Optional;

public class OptionalTest {
    public static void main(String[] args){
        //System.out.println(new Person().getCar().getInsurance().getName());
       // System.out.println(System.getenv("COMPUTERNAME"));
        //int a = null;
//        System.out.println(null);
        Insurance insurance = new Insurance();
        Optional<Insurance> optInsurance = Optional.ofNullable(insurance);
        Optional<String> name = optInsurance.map(Insurance::getName);
        System.out.println(name);

        Person person = new Person();
        Optional<Person> optPerson = Optional.ofNullable (person);
       // Optional<String> name = optPerson.map(Person::getCar)
        String name2 = optPerson.flatMap(Person::getCar)
                .flatMap(Car::getInsurance)
                .map(Insurance::getName)
                .orElse("Unknow");
        System.out.println(name2);
    }
}
