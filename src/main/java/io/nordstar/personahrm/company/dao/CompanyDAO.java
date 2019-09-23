package io.nordstar.personahrm.company.dao;

import io.nordstar.personahrm.company.model.company.CompanyBaseRec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.InvalidResultSetAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CompanyDAO {

    @Autowired (required = true)
    private JdbcTemplate jdbcTemplate;

    private static final String RETRIEVE_COMPANIES_SQL_QUERY = "SELECT hrm_comp_companyentity.companyCode, "                                            +
                                                                      "IFNULL(hrm_comp_companyentity.taxId,'') AS TAX_ID, "                             +
                                                                      "IFNULL(hrm_comp_companyentity.name,'') AS COMPANY_NAME, "                        +
                                                                      "hrm_comp_companyentity.companyTypeCode, "                                        +
                                                                      "IFNULL(hrm_comp_companytypeentity.name,'') AS COMPANY_TYPE, "                    +
                                                                      "IFNULL(hrm_comp_companyentity.companySocialSecurityNumber,'') AS COMPANY_SSN, "  +
                                                                      "IFNULL(hrm_comp_companyentity.web,'') AS WEB, "                                  +
                                                                      "IFNULL(hrm_comp_companyentity.creationDate,'') AS CREATION_DATE, "               +
                                                                      "IFNULL(hrm_comp_companyentity.active,'') AS ACTIVE "                             +

                                                               "FROM hrm_comp_companyentity "                                                           +

                                                               "LEFT OUTER JOIN hrm_comp_companytypeentity ON hrm_comp_companytypeentity.companyTypeCode = hrm_comp_companyentity.companyTypeCode " +

                                                               "ORDER BY hrm_comp_companyentity.name";

    /**
     *
     * @return
     */
    public List<CompanyBaseRec> retrieveCompanies ( ) throws InvalidResultSetAccessException, DataAccessException {

        List<CompanyBaseRec> companies = this.jdbcTemplate.queryForList ( RETRIEVE_COMPANIES_SQL_QUERY, CompanyBaseRec.class );

        return companies;

    }
}