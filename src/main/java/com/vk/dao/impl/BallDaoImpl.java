package com.vk.dao.impl;

import com.googlecode.genericdao.dao.jpa.GenericDAOImpl;
import com.vk.dao.BallDao;
import com.vk.dao.domain.Ball;

import java.util.List;

/**
 * {@link BallDao} implementation.
 *
 * @author vkolodrevskiy
 */
public class BallDaoImpl extends GenericDAOImpl<Ball, Long> implements BallDao {
    @Override
    public List<Ball> findByColor(String color) {
        throw new UnsupportedOperationException("Not implemeted yet");
    }
}
