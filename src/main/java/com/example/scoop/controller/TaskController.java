package com.example.scoop.controller;

import com.example.scoop.domain.Project;
import com.example.scoop.domain.User;
import com.example.scoop.service.ProjectService;
import com.example.scoop.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

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

    @Autowired
    private UserService userService;

    @Autowired
    private ProjectService projectService;

    @GetMapping("/myTask")
    public String taskHome(Model model) {
        // 등록된 태스크 리스트업

        // 해당 워크스페이스의 멤버 가져오기
        int wsid = 0;                                       // 테스트용 0번
        List<User> users = userService.findByWsid(wsid);
        log.debug("가져온 멤버 리스트: {}", users);
        model.addAttribute("members", users);

        // 해당 워크스페이스의 프로젝트 가져오기
        List<Project> projects = projectService.findByWsid(wsid);
        log.debug("가져온 프로젝트 리스트: {}", projects);
        model.addAttribute("projects", projects);

        return "/myTaskView/myTask";
    }
}
