package com.vk.service.impl;

import com.vk.dao.BallDao;
import com.vk.dao.domain.Ball;
import com.vk.service.BallManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.List;

/**
 * {@link BallManager} implementation.
 *
 * @author vkolodrevskiy
 */
@Service
@Transactional
public class BallManagerImpl implements BallManager {
    private final static Logger logger = LoggerFactory.getLogger(BallManagerImpl.class);

    @Inject
    private BallDao ballDao;

    @Override
    public List<Ball> findAllBalls() {
        logger.debug("Getting list of all balls.");
        return ballDao.findAll();
    }

    @Override
    public Ball createNewBall(Ball ball) {
        logger.debug("Adding new ball. color={} radius={}", ball.getColor(), ball.getRadius());
        return ballDao.save(ball);
    }
}
