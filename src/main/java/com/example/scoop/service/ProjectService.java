package com.example.scoop.service;

import com.example.scoop.domain.Project;

import java.util.List;

/**
 * projectName     :Scoop
 * fileName        :ProjectService
 * author          :yuuna
 * since           :2022/09/27
 */
public interface ProjectService {

    List<Project> findByWsid(int wsid);
}
