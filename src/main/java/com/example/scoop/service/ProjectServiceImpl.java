package com.example.scoop.service;

import com.example.scoop.dao.ProjectDAO;
import com.example.scoop.domain.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * projectName     :Scoop
 * fileName        :ProjectServiceImpl
 * author          :yuuna
 * since           :2022/09/27
 */

@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectDAO projectDAO;


    @Override
    public List<Project> findByWsid(int wsid) {
        return projectDAO.findByWsid(wsid);
    }

}
