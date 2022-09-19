package com.example.scoop.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * projectName     :Scoop
 * fileName        :TaskController
 * author          :yuuna
 * since           :2022/09/19
 */

@Controller
@RequestMapping("/task")
@Slf4j
public class TaskController {

    @GetMapping("/myTask")
    public String taskHome() {
        // 모델로 테스크 테이블 가져오기 (status not-finished)

        return "/myTaskView/myTask";
    }
}
