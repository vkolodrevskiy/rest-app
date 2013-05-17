package com.vk.dao.impl;

import com.vk.dao.BallDao;
import com.vk.dao.domain.Ball;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import java.util.List;

/**
 * {@link BallDao} implementation.
 *
 * @author vkolodrevskiy
 */
@Repository
public class BallDaoImpl implements BallDao {

    @Inject
    HibernateTemplate hibernateTemplate;

    @Override
    public List<Ball> findAll() {
        return hibernateTemplate.find("from " + Ball.class.getName());
    }

    @Override
    public Ball save(Ball ball) {
        hibernateTemplate.save(ball);
        return ball;
    }
}
