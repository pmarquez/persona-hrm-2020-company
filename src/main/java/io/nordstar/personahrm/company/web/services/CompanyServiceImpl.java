package io.nordstar.personahrm.company.web.services;

import io.nordstar.personahrm.company.dao.CompanyDAO;
import io.nordstar.personahrm.company.model.company.CompanyBaseRec;
import io.nordstar.personahrm.company.model.company.CompanyRec;
import io.nordstar.personahrm.company.model.organization.CompanyOrgRec;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CompanyServiceImpl implements CompaniesService {

    @Override
    public List<CompanyBaseRec> retrieveCompanies ( ) {

        CompanyDAO companyDAO = new CompanyDAO ( );

        List<CompanyBaseRec> companies = companyDAO.retrieveCompanies ( );

        return companies;
    }

    @Override
    public CompanyRec retrieveCompany ( int companyCode ) {
        return null;
    }

    @Override
    public List<CompanyOrgRec> retrieveCompanyOrganization ( int companyCode ) {
        return null;
    }

}
