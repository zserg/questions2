package ru.zserg.questions;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.zserg.questions.models.Question;
import ru.zserg.questions.service.QuestionService;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class AppTest {

    @Autowired
    private QuestionService questionService;

    @Test
    public void createQuestionTest() {
        questionService.create(new Question());
        List<Question> list = questionService.getAll();
        assertEquals(1, list.size());
    }

    @Test
    public void getRandomQuestionTest() {
        questionService.create(new Question());
        questionService.create(new Question());
        Question q = questionService.getRandom();
        assertNotNull(q);
    }


}
