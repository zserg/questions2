package ru.zserg.questions.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.zserg.questions.models.IdsOnly;
import ru.zserg.questions.models.Question;
import ru.zserg.questions.repositories.QuestionRepository;

import java.util.*;

@Service
public class QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    public List<Question> getAll() {
        ArrayList<Question> list = new ArrayList<>();
        questionRepository.findAll().forEach(list::add);
        return list;
    }

    public void create(Question question){
        Question save = questionRepository.save(question);
    }

    public Question getRandom(){
        Collection<IdsOnly> allQuestions = questionRepository.findAllProjectedBy();
        Random random = new Random();
        if(allQuestions.isEmpty()){
            return null;
        }
        int idx = random.nextInt(allQuestions.size());

        ArrayList<Question> list = new ArrayList<>();
        questionRepository.findAll().forEach(list::add);
        Long randomId = list.get(idx).getId();
        Question randomQuestion = questionRepository.findById(randomId).orElse(new Question());
        return randomQuestion;
    }


    public void updateQuestion(Question question){
        questionRepository.findById(question.getId()).ifPresent(existingQuestion -> {
            existingQuestion.update(question);
            questionRepository.save(existingQuestion);
        });
    }
}
