package com.learn.redisson.server.impl;

import com.learn.redisson.common.RedisKeyConstant;
import com.learn.redisson.module.entity.Problem;
import com.learn.redisson.module.mapper.ProblemMapper;
import com.learn.redisson.server.ISetObjService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.redisson.api.RSet;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * autor:liman
 * createtime:2021/4/3
 * comment:set集合的service类
 */
@Service("setService")
@Slf4j
public class SetServiceImpl implements ISetObjService {

    @Autowired
    private ProblemMapper problemMapper;
    @Autowired
    private RedissonClient redissonClient;

    public int addProblem(Problem problem) {
        problem.setIsActive(Byte.valueOf("1"));
        int res = problemMapper.insertSelective(problem);
        if (0 < res) {
            this.cacheAllProblem();
            return problem.getId();
        }
        return -1;
    }

    /**
     * 获取所有试题的顺序
     *
     * @return
     */
    public Set<Problem> getProblems() {
//        this.cacheAllProblem();
        RSet<Problem> problemsRedisData = redissonClient.getSet(RedisKeyConstant.REDISSON_SET_REDIS_KEY);
        return problemsRedisData.readAll();
    }

    /**
     * 获取所有试题的顺序，随机
     *
     * @return
     */
    public List<Object> getProblemsRandom() {
//        this.cacheAllProblem();
        RSet<Problem> problemsRedisData = redissonClient.getSet(RedisKeyConstant.REDISSON_SET_REDIS_KEY);
        List<Object> problemRedisList = Arrays.asList(problemsRedisData.readAll().toArray());
        Collections.shuffle(problemRedisList);
        return problemRedisList;
    }

    /**
     * 随机获取一个试题
     *
     * @return
     */
    public Problem randomProblem() {
//        this.cacheAllProblem();
        RSet<Problem> problemsRedisData = redissonClient.getSet(RedisKeyConstant.REDISSON_SET_REDIS_KEY);
        return problemsRedisData.random();
    }

    /**
     * 删除一个题目
     *
     * @return
     */
    public int deleteProblem(final Integer id) {
        Problem problem = problemMapper.selectByPrimaryKey(id);
        if (null != problem) {
            int res = problemMapper.unactiveProblem(id);
            if (res > 0) {
                this.cacheAllProblem();

                return 1;
            }
        }
        return -1;
    }

    private void cacheAllProblem() {
        //缓存中的试题集合
        RSet<Problem> problemRedisSet = redissonClient.getSet(RedisKeyConstant.REDISSON_SET_REDIS_KEY);
        //数据库中的试题集合
        Set<Problem> problemsSet = problemMapper.selectAll();

        //如果缓存中集合不为空，需要删除集合，然后读取数据库中最新的数据，放入缓存
        if (!problemRedisSet.isEmpty()) {
            problemRedisSet.clear();

            //重新放入数据库中的数据
            if (CollectionUtils.isNotEmpty(problemsSet)) {//如果数据库中的数据不为空
                problemRedisSet.addAll(problemsSet);
            } else {
                //如果为空，则不做任何操作

            }
        } else {//如果缓存中的数据为空，则直接放入数据库中的数据
            if (CollectionUtils.isNotEmpty(problemsSet)) {
                problemRedisSet.addAll(problemsSet);
            }
        }
    }

}
