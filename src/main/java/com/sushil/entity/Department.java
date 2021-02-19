package com.sushil.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Data
@ToString
@Table(name = "Department")
//@SQLDelete(sql = "UPDATE user SET deleted=true WHERE id=?")
//@Where(clause = "deleted = false")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String deptName;

    private String noOfEmployees;

    private Integer del_flg;

    private Boolean status;

}
