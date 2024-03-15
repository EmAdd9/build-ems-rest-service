package com.springboot.buildemsrestservice.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "manager")
public class Manager {
    @Id
    @Column(name = "manager_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer managerId;

    @Column(name = "employee_id")
    private Integer employeeId;

    @ElementCollection
    @CollectionTable(name = "emp_ms_team_managed", joinColumns = @JoinColumn(name = "manager_id"))
    @Column(name = "employee_id")
    private List<Long> teamManaged;

    @Override
    public String toString() {
        return "Manager{" +
                "managerId=" + managerId +
                ", employeeId=" + employeeId +
                ", teamManaged=" + teamManaged +
                '}';
    }

    public Integer getManagerId() {
        return managerId;
    }

    public void setManagerId(Integer managerId) {
        this.managerId = managerId;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public List<Long> getTeamManaged() {
        return teamManaged;
    }

    public void setTeamManaged(List<Long> teamManaged) {
        this.teamManaged = teamManaged;
    }

    public Manager() {
    }

    public Manager(Integer managerId, Integer employeeId, List<Long> teamManaged) {
        this.managerId = managerId;
        this.employeeId = employeeId;
        this.teamManaged = teamManaged;
    }
}