package com.kh.mybatis;

import lombok.Data;

import java.util.List;

//DB Table과 매핑할 객체 생성
@Data
//@Data 넣으면 아래의 어노테이션이 다 포함되어있다.(혼자쓸경우 써도 되고 다른 어노테이션이 있는경우
//쓸때 순서를 잘 정해서 써야해서 꼭 써야할 어노테이션만 쓰는게 좋다.
//@GETTER @SETTER @CONSTRUCT @TOSTRING 등을 다 포함하고 있다
public class Company {
    private int id;
    private String name;
    private String address;
    private List<Employee> employeeList; //조인하는 과정 ?
}
