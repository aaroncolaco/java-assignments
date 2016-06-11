package com.psl;

import com.bean.Category;
import com.bean.Complexity;
import com.bean.Criteria;
import com.bean.Question;
import com.util.DataManagerImpl;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Client {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        // Call your functionalities from here to test your code.
        
        List <Question> questionsList = new ArrayList<>(), questionsByCategoryList = new ArrayList<>();
        List<Question> questionsByComplexityList = new ArrayList<>();
        List <Criteria> criteriasList = new ArrayList<>();
        
        Set <Question> questionsSet = new LinkedHashSet<>();
        
        DataManagerImpl dataManagerImpl = new DataManagerImpl();
        
        questionsList = dataManagerImpl.populateData();
        
        questionsByCategoryList = dataManagerImpl.getQuestionByCategory(Category.History, questionsList);
        
        questionsByComplexityList = dataManagerImpl.getQuestionByComplexity(Complexity.Complex, questionsList);
        
        criteriasList.add(new Criteria(Category.History, Complexity.Complex, 1));
        criteriasList.add(new Criteria(Category.History, Complexity.Simple, 2));
        criteriasList.add(new Criteria(Category.Science, Complexity.Complex, 1));
        criteriasList.add(new Criteria(Category.GK, Complexity.Complex, 1));
        criteriasList.add(new Criteria(Category.Geography, Complexity.Simple, 2));
        
        questionsSet = dataManagerImpl.generateQuestionPaper(questionsList, criteriasList);
        for (Question question1 : questionsSet) {
            System.out.println(question1.getSrno());
        }
        
        criteriasList.clear();
        questionsSet.clear();
        
        System.out.println(". . . . . .");
        // same thing again to test if unique questions
        criteriasList.add(new Criteria(Category.History, Complexity.Complex, 1));
        criteriasList.add(new Criteria(Category.History, Complexity.Simple, 2));
        criteriasList.add(new Criteria(Category.Science, Complexity.Complex, 1));
        criteriasList.add(new Criteria(Category.GK, Complexity.Complex, 1));
        criteriasList.add(new Criteria(Category.Geography, Complexity.Simple, 2));

        questionsSet = dataManagerImpl.generateQuestionPaper(questionsList, criteriasList);
        for (Question question1 : questionsSet) {
            System.out.println(question1.getSrno());
        }
    }
}
