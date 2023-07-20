package com.epam.training.ediary.service;

import com.epam.training.ediary.domain.Credentials;
import com.epam.training.ediary.domain.Student;
import com.epam.training.ediary.domain.Teacher;
import com.epam.training.ediary.domain.User;
import com.epam.training.ediary.persistence.DataStore;

public class DefaultUserService implements UserService{
    /*--properties--*/
    DataStore dataStore;

    /*--constructors--*/
    public DefaultUserService(DataStore p_dataStore) {
        this.dataStore = p_dataStore;
    }

    /*--methods--*/
    @Override
    public User authenticate(Credentials p_credentials) {

        for (Teacher t: this.dataStore.getTeachers()) {

            if(p_credentials.getLoginName().equals((t.getCredentials().getLoginName()))
            && p_credentials.getPassword().equals((t.getCredentials().getPassword()))) {
                return t;
            }          
        }

        for (Student s: this.dataStore.getStudents()) {
            
            if(p_credentials.getLoginName().equals((s.getCredentials().getLoginName()))
            && p_credentials.getPassword().equals((s.getCredentials().getPassword()))) {
                return s;
            }            
        }
        throw new AuthenticationException();
    }
}
