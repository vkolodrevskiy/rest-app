package com.vk.rest.controllers;

import com.vk.dao.BallDao;
import com.vk.dao.domain.Ball;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.inject.Inject;
import java.util.List;

@Controller
@RequestMapping("/ball")
public class BallController {
    @Inject
    private BallDao ballDao;

	@RequestMapping(value="list", method= RequestMethod.GET)
	public @ResponseBody List<Ball> getAll() {
		return ballDao.findAll();
	}
}
