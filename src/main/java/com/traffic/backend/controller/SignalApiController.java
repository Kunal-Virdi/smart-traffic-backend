package com.traffic.backend.controller;

import com.traffic.backend.model.Signal;
import com.traffic.backend.service.SignalController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/signals")
public class SignalApiController {
    private final SignalController signalController;

    public SignalApiController(SignalController signalController){
        this.signalController = signalController;
    }

    @PostMapping("/optimize")
    public Signal optimizeSignal(@RequestBody SignalRequest request){

        signalController.optimizeSignal(
                request.getSignal(),
                request.getRoad()
        );

        return request.getSignal();
    }
}
