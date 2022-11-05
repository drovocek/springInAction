package ru.soft.mvc.repository;

import ru.soft.mvc.model.TacoOrder;

public interface OrderRepository {
    TacoOrder save(TacoOrder order);
}