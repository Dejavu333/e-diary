package com.epam.training.ediary.domain;

public class Credentials {
    /*--properties--*/
    String loginName;
    String password;

    /*--constructors--*/
    public Credentials() {
    }

    /*--methods--*/
    public String getLoginName() {
        return this.loginName;
    }

    public void setLoginName(String p_loginName) {
        this.loginName = p_loginName;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String p_password) {
        this.password = p_password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Credentials t = (Credentials) o;
        return loginName.equals(t.loginName) && password.equals(t.password);
    }
}
