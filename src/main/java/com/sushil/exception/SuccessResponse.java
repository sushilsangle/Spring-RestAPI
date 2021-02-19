package com.sushil.exception;

import com.sushil.entity.Department;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

@Data
public class SuccessResponse {

    private String message;

    private LocalDate timeStamp;

    private Department data;

    private Integer statusCode;


}
