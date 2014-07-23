package model;

import lombok.Value;

@Value
public class Person {

    private final Long id;
    private final String firstName;
    private final String lastName;

    public Person(){
        id=0l;
        firstName="";
        lastName="";
    }
}
