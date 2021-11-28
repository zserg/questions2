package ru.zserg.questions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import ru.zserg.questions.models.Question;
import ru.zserg.questions.service.QuestionService;

@Slf4j
@RestController
public class QuestionsController {

    private final QuestionService questionService;

    public QuestionsController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping("/")
    public Question getRandom() {
        return questionService.getRandom();
    }

    @PostMapping("/create")
    public void createQuestion(@RequestBody Question question) {
        questionService.create(question);
    }

    @PostMapping("/update")
    public void updateQuestion(@RequestBody Question question) {
        questionService.updateQuestion(question);
    }


}
