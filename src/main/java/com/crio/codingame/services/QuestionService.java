package com.crio.codingame.services;

import java.util.List;

import com.crio.codingame.entities.Level;
import com.crio.codingame.entities.Question;
import com.crio.codingame.repositories.IQuestionRepository;
// import com.crio.codingame.repositories.QuestionRepository;

public class QuestionService implements IQuestionService{
    private final IQuestionRepository questionRepository;
    // private final QuestionRepository storeQuestions = new QuestionRepository();
    public QuestionService(IQuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    // TODO: CRIO_TASK_MODULE_SERVICES
    // Create and store Question into the repository.

    @Override
    public Question create(String title, Level level, Integer difficultyScore) {
        Question question = new Question(title, level, difficultyScore);
        return questionRepository.save(question);
        // return question; 
    }
    public Question create(String id,String title, Level level, Integer difficultyScore) {
        Question question = new Question(id,title, level, difficultyScore);
        return questionRepository.save(question);
        // return question; 
    }
    // TODO: CRIO_TASK_MODULE_SERVICES
    // Get All Questions if level is not specified.
    // Or
    // Get List of Question which matches the level provided.

    @Override
    public List<Question> getAllQuestionLevelWise(Level level) {
        if(level==null) return questionRepository.findAll();
        return questionRepository.findAllQuestionLevelWise(level);
    }
    
}
