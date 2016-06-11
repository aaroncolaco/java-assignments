package com.util;

// Override and implement all the methods of DataManager Interface here

import com.bean.Category;
import com.bean.Complexity;
import com.bean.Criteria;
import com.bean.Question;
import java.util.List;
import java.util.Set;

public class DataManagerImpl implements DataManager {

    @Override
    public List<Question> populateData() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Question> getQuestionByCategory(Category category, List<Question> questionsList) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Question> getQuestionByComplexity(Complexity complexity, List<Question> questionsList) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Set<Question> generateQuestionPaper(List<Question> list, List<Criteria> template) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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