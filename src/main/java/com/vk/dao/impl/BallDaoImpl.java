package com.vk.dao.impl;

import com.vk.dao.BallDao;
import com.vk.dao.domain.Ball;
import org.springframework.orm.hibernate3.HibernateTemplate;

import java.util.List;

/**
 * {@link BallDao} implementation.
 *
 * @author vkolodrevskiy
 */
public class BallDaoImpl implements BallDao {
    private HibernateTemplate hibernateTemplate;

    @Override
    public List<Ball> findAll() {
        return hibernateTemplate.find("from " + Ball.class.getName());
    }

    @Override
    public Ball save(Ball ball) {
        hibernateTemplate.save(ball);
        return ball;
    }

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
}
