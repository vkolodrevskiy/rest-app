package com.vk.dao;

import com.googlecode.genericdao.dao.jpa.GenericDAO;
import com.vk.dao.domain.Ball;

import java.util.List;

/**
 * TODO: add description
 *
 * @author vkolodrevskiy
 */
public interface BallDao extends GenericDAO<Ball, Long> {
    List<Ball> findByColor(String color);
}
