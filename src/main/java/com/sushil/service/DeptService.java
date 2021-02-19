package com.sushil.service;

import com.sushil.entity.Department;
import com.sushil.repository.DeptRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptService {

    @Autowired
    private DeptRepository repository;


    //add single record into DB
    public Department saveDeptInfo(Department department)
    {
        department.setStatus(Boolean.TRUE);
        department.setDel_flg(1);
      return   repository.save(department);
    }

    //add multiple records into DB
    public List<Department> saveDepAllInfo(List<Department> departments)
    {
        return repository.saveAll(departments);
    }

    //fetch object from DB
    public List<Department> getDeptInfo()
    {
        return repository.findAllRecord();
    }

    //fetch records based on ID.
    public Department getDepInfoById(Integer id)
    {
        return repository.findById(id).orElse(null);
    }

    //delete records based on id

    public String deleteDepInfo(Integer id)
    {
        repository.softDelete(id);
        return "Records remove from successfully : "+id;
    }

    //update info

    public Department updatedeptInfo(Department department)
    {
        Department existingInfo=repository.findById(department.getId()).orElse(null);
        existingInfo.setDeptName(department.getDeptName());
        existingInfo.setNoOfEmployees(department.getNoOfEmployees());
        existingInfo.setDel_flg(department.getDel_flg());
        return repository.save(existingInfo);
    }
}
