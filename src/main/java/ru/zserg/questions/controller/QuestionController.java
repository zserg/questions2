package ru.zserg.questions.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.zserg.questions.models.Question;
import ru.zserg.questions.service.QuestionService;

@Controller
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @GetMapping(value = "/q")
    public String getQuestion(Model model) {
        Question question = questionService.getRandom();
        model.addAttribute("question", question.getQuestion());
        return "question";
    }


}
