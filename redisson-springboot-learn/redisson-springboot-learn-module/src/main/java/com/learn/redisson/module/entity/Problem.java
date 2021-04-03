package com.learn.redisson.module.entity;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import java.io.Serializable;

@Data
public class Problem implements Serializable {
    private Integer id;

    @NotBlank(message = "标题不能为空！")
    private String title;

    private String choiceA;

    private String choiceB;

    private Byte isActive;

    private Byte orderBy;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Problem problem = (Problem) o;

        return title.equals(problem.title);
    }

    @Override
    public int hashCode() {
        return title.hashCode();
    }
}