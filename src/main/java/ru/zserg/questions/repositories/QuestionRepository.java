package ru.zserg.questions.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.zserg.questions.models.IdsOnly;
import ru.zserg.questions.models.Question;

import java.util.Collection;

@Repository
public interface QuestionRepository extends CrudRepository<Question, Long> {
    Collection<IdsOnly> findAllProjectedBy();
}
