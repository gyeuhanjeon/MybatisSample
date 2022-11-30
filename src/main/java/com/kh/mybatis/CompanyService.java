package com.kh.mybatis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyService {
    @Autowired
    private CompanyMapper companyMapper;
    @Autowired
    private EmployeeMapper employeeMapper;
    public List<Company> getAll(){//실제 conpany 의 getall 과 employee 의 get all 이 호출되게끔.
        List<Company> companyList = companyMapper.getAll();
        if(companyList !=null && companyList.size() > 0) {
            for(Company company : companyList){
                company.setEmployeeList(employeeMapper.getByCompanyId(company.getId()));
            }
        }
        return companyList;
    }
}
