package com.epam.training.ediary.service;

import com.epam.training.ediary.domain.Credentials;
import com.epam.training.ediary.domain.User;

public interface UserService {
    /*--functions to be implemented--*/
    public User authenticate(Credentials p_credentials);
}
