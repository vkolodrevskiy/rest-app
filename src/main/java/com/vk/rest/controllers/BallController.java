package com.vk.rest.controllers;

import com.vk.dao.domain.Ball;
import com.vk.service.BallManager;
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
    @Inject
    private BallManager ballManager;

	@RequestMapping(value="list", method=RequestMethod.GET, produces="application/json")
	public @ResponseBody List<Ball> list() {
		return ballManager.findAllBalls();
	}

    @RequestMapping(value="add", method=RequestMethod.POST, consumes="application/json")
    public String add(@RequestBody Ball ball) {
        ballManager.createNewBall(ball);
        return "redirect:/";
    }
}
