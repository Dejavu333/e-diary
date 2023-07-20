package com.epam.training.ediary.domain;

import java.util.Objects;

public class User {
    /*--properties--*/
    long id;
    String name;
    Credentials credentials;

    /*--constructors--*/
    public User() {
    }

    /*--methods--*/
    public long getId() {
        return id;
    }

    public void setId(long p_id) {
        this.id = p_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String p_name) {
        this.name = p_name;
    }

    public Credentials getCredentials() {
        return credentials;
    }

    public void setCredentials(Credentials p_credentials) {
        this.credentials = p_credentials;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;
        
        return Objects.equals(id, user.id) && Objects.equals(name, user.name) && Objects.equals(credentials, user.credentials);
    }
}
