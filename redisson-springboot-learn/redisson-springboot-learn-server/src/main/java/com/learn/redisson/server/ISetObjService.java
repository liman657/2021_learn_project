package com.learn.redisson.server;

import com.learn.redisson.module.entity.Problem;

import java.util.List;
import java.util.Set;

/**
 * autor:liman
 * createtime:2021/4/3
 * comment:
 */
public interface ISetObjService {

    public int addProblem(Problem problem);

    public Set<Problem> getProblems();

    public List<Object> getProblemsRandom();

    public Problem randomProblem();

    public int deleteProblem(final Integer id);
}
