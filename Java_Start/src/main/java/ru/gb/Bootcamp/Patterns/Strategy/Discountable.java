package ru.gb.Bootcamp.Patterns.Strategy;

import java.math.BigDecimal;

public interface Discountable {
    BigDecimal applyDiscount(BigDecimal value);
}
