package com.vk.service;

import com.vk.dao.domain.Ball;

import java.util.List;

/**
 * Manage balls.
 *
 * @author vkolodrevskiy
 */
public interface BallManager {
    List<Ball> findAllBalls();
    Ball createNewBall(Ball ball);
}
