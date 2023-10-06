package com.crio.codingame.commands;

import java.util.List;

import com.crio.codingame.entities.Level;
import com.crio.codingame.entities.Question;
import com.crio.codingame.services.IQuestionService;

public class ListQuestionCommand implements ICommand{

    private final IQuestionService questionService;
    
    public ListQuestionCommand(IQuestionService questionService) {
        this.questionService = questionService;
    }

    // TODO: CRIO_TASK_MODULE_CONTROLLER
    // Execute getAllQuestionLevelWise method of IQuestionService and print the result.
    // Look for the unit tests to see the expected output.
    // Sample Input Token List:- ["LIST_QUESTION","HIGH"]
    // or
    // ["LIST_QUESTION"]

    @Override
    public void execute(List<String> tokens) {
        Level level = (tokens.size()==1)?null:Level.valueOf(tokens.get(1));
        List<Question> listOfQuestions = questionService.getAllQuestionLevelWise(level);
        String toPrint = "";
        for(Question q:listOfQuestions){
            toPrint += q.toString()+", ";
        }
        System.out.print("["+toPrint.substring(0,toPrint.length()-2)+"]");
    }
    
}
