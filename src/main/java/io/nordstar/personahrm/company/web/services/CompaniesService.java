package io.nordstar.personahrm.company.web.services;

import io.nordstar.personahrm.company.model.company.CompanyBaseRec;
import io.nordstar.personahrm.company.model.company.CompanyRec;
import io.nordstar.personahrm.company.model.organization.CompanyOrgRec;

import java.util.List;

public interface CompaniesService {

    /**
     *
     * @return
     */
    public List<CompanyBaseRec> retrieveCompanies ( );

    /**
     *
     * @param companyCode
     * @return
     */
    public CompanyRec retrieveCompanyByCode ( int companyCode );

    /**
     *
     * @param companyCode
     * @return
     */
    public List<CompanyOrgRec> retrieveCompanyOrganization ( int companyCode );

}
