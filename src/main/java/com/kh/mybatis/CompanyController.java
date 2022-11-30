package com.kh.mybatis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController//프론트 엔드로부터 커맨드를 받겠다. (뷰를 안달고 pi,postman 등으로 부터 커맨드를 받는다)
@RequestMapping("/company")
public class CompanyController {

    @Autowired
    private CompanyMapper companyMapper;
    @Autowired
    private CompanyService companyService;



    @PostMapping("")
    public int post(@RequestBody Company company){
        return companyMapper.insert(company); //Mapper 에 만들어 놓은 insert 문을 통해서 입력값을 db 에 넣음
    }
    @GetMapping("")
    public List<Company> getAll() {
        return companyService.getAll();
    }
}a
