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
    
    private static int[] questionSrNo = null;

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
            databaseConnectionManager.closeConnection();    // can close connection even at the end
            
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM questionBank");
            
            while (resultSet.next()) {
                
               question = new Question();
               
               question.setSrno(Integer.parseInt(resultSet.getString("SrNo")));
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
        
        for (Criteria criteria : template) {
            questionsByCategoryList = getQuestionByCategory(criteria.getCategory(), list);  // get according to category passed
            questionsByComplexityList = getQuestionByComplexity(criteria.getComplexity(), questionsByCategoryList);  // get from matching category list, the ones with matching complexity
            
            for (int i = 0; i < criteria.getNoOfQuestion(); i++) {  // number of questions needed 
                questionsSet.add(questionsByComplexityList.get(i)); 
                
            }
            
            questionsByCategoryList.clear();
            questionsByComplexityList.clear();
        }
        
        return questionsSet;
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