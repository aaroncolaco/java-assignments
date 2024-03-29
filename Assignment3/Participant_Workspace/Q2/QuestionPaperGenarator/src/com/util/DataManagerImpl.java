package com.util;

// Override and implement all the methods of DataManager Interface here

import com.bean.Category;
import com.bean.Complexity;
import com.bean.Criteria;
import com.bean.Question;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DataManagerImpl implements DataManager {
    
    // list of questions added to paper already
    static ArrayList <Integer> questionSrNosList = new ArrayList<>();
    
    @Override
    public List<Question> populateData() {
        
        List <Question> questionsList = new ArrayList<>();
        Question question = null;
        
        DatabaseConnectionManager databaseConnectionManager = new DatabaseConnectionManager();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        
        try {
            connection = databaseConnectionManager.getConnection(); // returns a connection object

            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM questionBank");

            databaseConnectionManager.closeConnection();  // after all queries

            while (resultSet.next()) {
                
               question = new Question();
               
               question.setSrno(resultSet.getInt("SrNo"));  // or get as string & parse Int 
               question.setQuestion(resultSet.getString("Question"));
               question.setOption1(resultSet.getString("optionA"));
               question.setOption2(resultSet.getString("optionB"));
               question.setOption3(resultSet.getString("optionC"));
               question.setOption4(resultSet.getString("OptionD"));
               question.setCorrectAns(resultSet.getString("CorrectAns"));
               // enum types
               question.setType(Category.valueOf(resultSet.getString("Category")));
               question.setComplexity(Complexity.valueOf(resultSet.getString("Complexity")));
               
               questionsList.add(question);

            }
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DataManagerImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DataManagerImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return questionsList;
        
    }

    @Override
    public List<Question> getQuestionByCategory(Category category, List<Question> questionsList) {
        
        List <Question> questions = new ArrayList<>();
        
        for (Question question : questionsList) {
            if (question.getCategory().equals(category)) {
                questions.add(question);
            }
        }
        
        return questions;
    }

    @Override
    public List<Question> getQuestionByComplexity(Complexity complexity, List<Question> questionsList) {
       
        List<Question> questions = new ArrayList<>();

        for (Question question : questionsList) {
            if (question.getComplexity().equals(complexity)) {
                questions.add(question);
            }
        }

        return questions;
    }

    @Override
    public Set<Question> generateQuestionPaper(List<Question> list, List<Criteria> template) {
        
        Set <Question> questionsSet = new LinkedHashSet<>();
        List<Question> questionsByComplexityList = new ArrayList<>(), questionsByCategoryList = new ArrayList<>();
        Question question = null;
        
        int count = 0;  // to keep count of number of questions added
        
        for (Criteria criteria : template) {
            questionsByCategoryList = getQuestionByCategory(criteria.getCategory(), list);  // get according to category passed
            questionsByComplexityList = getQuestionByComplexity(criteria.getComplexity(), questionsByCategoryList);  // get from matching category list, the ones with matching complexity
            
            count = 0;
            for (int i = 0; i < questionsByComplexityList.size(); i++) {  // for size of list 
                
                question = questionsByComplexityList.get(i);
                
                // if not already added, add
                if (! alreadyAdded(question)) {
                    questionsSet.add(question); // add quest to set
                    questionSrNosList.add(question.getSrno()); // add SrNo to list of added quest
                    count++;
                    
                    // if required no of quest obtained, break
                    if (count >= criteria.getNoOfQuestion()) {
                        break;
                    }
                }
            }
            
            questionsByCategoryList.clear();
            questionsByComplexityList.clear();
        }
        
        return questionsSet;
    }
    
    // to check if question already added to set 
    private boolean alreadyAdded(Question question) {
        boolean added = false;
        
        // if question SrNo already there in list of quest added
        if (questionSrNosList.contains(question.getSrno())) {
            added = true;
        }
        
        return added;
    }

    @Override
    public void sortByCategory(List<Question> questionList) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void sortByComplexity(List<Question> questionList) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


}