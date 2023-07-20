package com.epam.training.ediary.domain;

import java.util.Objects;

public class SchoolClass {
    /*--properties--*/
    String name;

    /*--constructors--*/
    public SchoolClass() {
    }

    /*--methods--*/
    public String getName() {
        return name;
    }

    public void setName(String p_name) {
        this.name = p_name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SchoolClass t = (SchoolClass) o;
        return Objects.equals(name, t.name);
    }}
