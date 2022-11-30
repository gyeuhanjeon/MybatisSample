package com.kh.mybatis;

import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface EmployeeMapper {
    @Insert("INSERT INTO employee(company_id, employee_name, employee_address) " +
            "VALUES(#{employee.companyId},#{employee.name},#{employee.address})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(@Param("employee") Employee employee);

    @Select("SELECT * FROM employee")
    @Results(id="EmployeeMap", value = {
            @Result(property = "companyId", column = "company_id"),
            @Result(property = "name", column ="employee_name"),
            @Result(property = "address", column = "employee_address")
    })
    //한번 만들어 놓으면 계속 반복으로 사용이 가능하다.
    List<Employee> getALL();

    @Select("SELECT * FROM EMPLOYEE WHERE ID=#{id}")
    @ResultMap("EmployeeMap")
    Employee getById(@Param("id") int id);

    @Select("SELECT * FROM EMPLOYEE WHERE COMPANY_ID=#{companyId}")
    @ResultMap("EmployeeMap")//위에서 만들어 놓은 Results 가져다가 사용.
    List<Employee> getByCompanyId(@Param("companyId") int companyId);

}
