package com.vk.service.impl;

import com.vk.dao.BallDao;
import com.vk.dao.domain.Ball;
import com.vk.exception.AppException;
import com.vk.service.BallManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * {@link BallManager} implementation.
 *
 * @author vkolodrevskiy
 */
@Transactional
public class BallManagerImpl implements BallManager {
    private final static Logger logger = LoggerFactory.getLogger(BallManagerImpl.class);

    private BallDao ballDao;

    @Override
    public List<Ball> findAllBalls() {
        logger.debug("Getting list of all balls.");
        return ballDao.findAll();
    }

    @Override
    public Ball createNewBall(Ball ball) {
        if(ball.getRadius().compareTo(100D) > 0) {
            logger.error("Ball radius > 100.");
            throw new AppException("Ball radius > 100.");
        }

        logger.debug("Adding new ball. color={} radius={}", ball.getColor(), ball.getRadius());
        return ballDao.save(ball);
    }

    public void setBallDao(BallDao ballDao) {
        this.ballDao = ballDao;
    }
}
