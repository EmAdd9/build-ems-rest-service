package com.springboot.buildemsrestservice.service;

import com.springboot.buildemsrestservice.entity.Manager;
import com.springboot.buildemsrestservice.repository.EmployeeRepository;
import com.springboot.buildemsrestservice.repository.ManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManagerService {
    @Autowired
    ManagerRepository managerRepository;

    @Autowired
    EmployeeRepository employeeRepository;


    public Integer addTeam(Manager manager){
        try {
            Integer managerEmployeeId = employeeRepository.findById(manager.getEmployeeId()).get().getEmployeeId();
            if (managerEmployeeId==null) throw new Exception();
        }catch (Exception e){
            return null;
        }
        return managerRepository.save(manager).getManagerId();
    }

    public Boolean deleteTeam(Integer managerId){
        managerRepository.deleteById(managerId);
        return true;
    }

    public Boolean addTeamMembers(List<Integer> employeeList){
        return null;
    }
}

