package com.vk.service.impl;

import com.vk.dao.BallDao;
import com.vk.dao.domain.Ball;
import com.vk.exception.AppException;
import com.vk.service.BallManager;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.testng.Assert.assertEquals;

/**
 * {@link BallManagerImpl} unit tests.
 *
 * @author vkolodrevskiy
 */
public class BallManagerImplTest {

	@InjectMocks
	private BallManager ballManager = new BallManagerImpl();
	@Mock
	BallDao ballDao;

	@BeforeMethod
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);

		when(ballDao.findAll()).thenReturn(new ArrayList<Ball>() {{
			add(new Ball());
			add(new Ball());
			add(new Ball());
		}});
	}

	@Test
	public void testFindAllBalls() {
		List<Ball> balls = ballManager.findAllBalls();
		assertEquals(balls.size(), 3);
		verify(ballDao, times(1)).findAll();
	}

	@Test
	public void testCreateNewBall() {
		Ball ball = new Ball();
		ball.setColor("red");
		ball.setRadius(50d);

		ballManager.createNewBall(ball);
		verify(ballDao, times(1)).save(ball);
	}

	@Test(expectedExceptions = AppException.class)
	public void testCreateNewBallInvalidRadius() {
		Ball ball = new Ball();
		ball.setColor("red");
		// invalid radius
		ball.setRadius(150d);

		ballManager.createNewBall(ball);
	}
}
