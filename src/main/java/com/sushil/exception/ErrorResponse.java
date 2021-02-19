package com.sushil.exception;

import com.sushil.entity.Department;
import lombok.Data;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.xml.bind.annotation.XmlRootElement;
import java.time.LocalDate;
import java.util.List;
@Data
@XmlRootElement(name = "error")
public class ErrorResponse {

    private String message;

    private LocalDate timeStamp;

    private String error;

    private Integer statusCode;

//    public ErrorResponse(String server_error, List<String> details) {
//    }
}
