package com.vk.rest.controllers;

import com.vk.dao.domain.Ball;
import com.vk.exception.AppException;
import com.vk.service.BallManager;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Ball management controller.
 *
 * @author vkolodrevskiy
 */
@RequestMapping("/ball")
public class BallController {
    private BallManager ballManager;

    @RequestMapping(value="list", method=RequestMethod.GET, produces="application/json")
    public @ResponseBody List<Ball> list() {
        return ballManager.findAllBalls();
    }

    @RequestMapping(value="add", method=RequestMethod.POST, consumes="application/json")
    public @ResponseBody String add(@RequestBody Ball ball) {
        ballManager.createNewBall(ball);
        return "{\"status\":\"ok\"}";
    }

    @ExceptionHandler(AppException.class)
    public @ResponseBody String handle(AppException e) {
        return "{\"error\":\"" + e.getMessage() + "\"}";
    }

    public void setBallManager(BallManager ballManager) {
        this.ballManager = ballManager;
    }
}
