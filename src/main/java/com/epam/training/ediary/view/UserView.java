package com.epam.training.ediary.view;

import com.epam.training.ediary.domain.Credentials;

public interface UserView {
    /*--functions to be implemented--*/
    public Credentials readCredentials();
    
    public void printInvalidCredentials();
}
