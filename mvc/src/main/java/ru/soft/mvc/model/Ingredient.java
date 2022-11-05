package ru.soft.mvc.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

//@Data
@Entity
@ToString
@Getter
@Setter
@EqualsAndHashCode
@RequiredArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public class Ingredient {

    @Id
    private final String id;
    private final String name;
    @Enumerated(value = EnumType.STRING)
    private final Type type;

    public enum Type {
        WRAP, PROTEIN, VEGGIES, CHEESE, SAUCE
    }

}

//@Data
//@Table
////@AllArgsConstructor
////@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
//public class Ingredient {
//
//    @Id
//    private final String id;
//    private final String name;
//    private final Type type;
//
//    public enum Type {
//        WRAP, PROTEIN, VEGGIES, CHEESE, SAUCE
//    }
//
//}