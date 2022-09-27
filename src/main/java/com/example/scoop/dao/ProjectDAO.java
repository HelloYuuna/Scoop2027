package com.example.scoop.dao;

import com.example.scoop.domain.Project;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * projectName     :Scoop
 * fileName        :ProjectDAO
 * author          :yuuna
 * since           :2022/09/27
 */
@Mapper
public interface ProjectDAO {

    List<Project> findByWsid(int wsid);
}
