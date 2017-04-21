package fr.pizzeria.domain;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)

public @interface ToString {
	boolean TopUpperCase();
}
