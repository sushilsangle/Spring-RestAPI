package com.sushil.controller;


import com.sushil.entity.Department;
import com.sushil.exception.ErrorResponse;
import com.sushil.exception.RecordNotFoundException;
import com.sushil.exception.SuccessResponse;
import com.sushil.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api")
public class DeptController {

    @Autowired
    private DeptService deptService;

    @PostMapping("/addDeptInfo")
    public Department addDeptInfo(@RequestBody Department department)
    {
        return deptService.saveDeptInfo(department);
    }
    @PostMapping("/addDeptInfos")
    public List<Department> addDeptInfos(@RequestBody List<Department> departments)
    {
        return deptService.saveDepAllInfo(departments);
    }
    @GetMapping("/getInfo")
    public List<Department> findAllDeptInfo()
    {
        return deptService.getDeptInfo();
    }


    @GetMapping("/getInfos/{id}")
    public ResponseEntity<Department> findDepInfoById(@PathVariable Integer id)
    {
        Department dept = deptService.getDepInfoById(id);
        ErrorResponse responseErr  = new ErrorResponse();
        if (dept==null)
        {
            responseErr.setMessage("Data not available");
            responseErr.setTimeStamp(LocalDate.now());
            responseErr.setStatusCode(HttpStatus.OK.value());
            responseErr.setError("Data is not available for given input");
            //throw new RecordNotFoundException("Invalid Department id : " + id);
            return new ResponseEntity(responseErr,HttpStatus.NOT_FOUND);
        }
//        SuccessResponse successResponse = new SuccessResponse();
//        successResponse.
        return new ResponseEntity<Department>(dept,HttpStatus.OK);

    }


    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateDeptInof(@RequestBody Department department, @PathVariable Integer id)
    {

           try{

               SuccessResponse response = new SuccessResponse();
                Department existDept=deptService.getDepInfoById(id);
                if (existDept==null)
                {
                    throw new RecordNotFoundException("Department id not found: " + id);
                }
            Department department1 = deptService.updatedeptInfo(department);
                response.setMessage("Data successfully updated");
                response.setTimeStamp(LocalDate.now());
                response.setStatusCode(HttpStatus.OK.value());
                response.setData(department1);

            return new ResponseEntity<>(response,HttpStatus.OK);
        }catch (NoSuchElementException e)
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        //return deptService.updatedeptInfo(department);
    }
    @DeleteMapping("/delete/{id}")
    public String deleteInfo(@PathVariable Integer id)
    {
        return deptService.deleteDepInfo(id);

    }
}
