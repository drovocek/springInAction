package ru.soft.mvc.repository;

import org.springframework.data.repository.CrudRepository;
import ru.soft.mvc.model.TacoOrder;

public interface OrderRepositoryJDBC extends CrudRepository<TacoOrder, Long> {
}
