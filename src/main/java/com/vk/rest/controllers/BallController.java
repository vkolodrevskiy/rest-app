package com.vk.rest.controllers;

import com.vk.dao.BallDao;
import com.vk.dao.domain.Ball;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.inject.Inject;
import java.util.List;

@Controller
@RequestMapping("/ball")
public class BallController {
    final static Logger logger = LoggerFactory.getLogger(BallController.class);

    @Inject
    private BallDao ballDao;

	@RequestMapping(value="list", method=RequestMethod.GET)
	public @ResponseBody List<Ball> list() {
        logger.info("Getting list of all balls.");
		return ballDao.findAll();
	}

    @RequestMapping(value="add", method=RequestMethod.POST, consumes="application/json")
    public String add(@RequestBody Ball ball) {
        logger.info("Adding new ball. color={} radius={}", ball.getColor(), ball.getRadius());
        ballDao.save(ball);
        return "redirect:/";
    }
}
