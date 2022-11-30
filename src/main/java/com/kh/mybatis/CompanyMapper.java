package com.kh.mybatis;

import org.apache.ibatis.annotations.*;

import java.util.List;

//어노테이션과 xml이 달라지는 부분이 여기이다.
@Mapper//인터페이스로 구현해야 한다. 상속은 없고 이 어노테이션만 붙이면 됨.
public interface CompanyMapper {
    @Insert("INSERT INTO company(company_name, company_address) VALUES(#{company.name}, #{company.address})")
    @Options(useGeneratedKeys = true, keyProperty = "id")//insert 를 통해서 아이디 네임을 받고 아이디는 자동생성
    int insert(@Param("company") Company company);

    @Select("SELECT * FROM company")//리스트가 넘어올 것.
    @Results({
            @Result(property = "name", column = "company_name"),
            @Result(property = "address", column = "company_address")
    })
    List<Company> getAll();
}
