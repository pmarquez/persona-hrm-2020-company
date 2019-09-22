package io.nordstar.personahrm.company.web.services;

import io.nordstar.personahrm.company.model.company.CompanyBaseRec;
import io.nordstar.personahrm.company.model.company.CompanyRec;
import io.nordstar.personahrm.company.model.organization.CompanyOrgRec;

import java.util.List;

public interface CompaniesService {

    public List<CompanyBaseRec> retrieveCompanies ( );

    public CompanyRec retrieveCompany ( int companyCode );

    public List<CompanyOrgRec> retrieveCompanyOrganization ( int companyCode );

}
