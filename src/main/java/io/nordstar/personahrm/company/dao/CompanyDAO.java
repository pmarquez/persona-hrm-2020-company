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

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static final String RETRIEVE_COMPANIES_SQL_QUERY = "SELECT hrm_comp_companyentity.companyCode, "                                            +
                                                                      "IFNULL(hrm_comp_companyentity.companyTaxId,'') AS TAX_ID, "                      +
                                                                      "IFNULL(hrm_comp_companyentity.companyName,'') AS COMPANY_NAME, "                 +
                                                                      "hrm_comp_companyentity.companyTypeCode, "                                        +
                                                                      "IFNULL(hrm_comp_companytypeentity.name,'') AS COMPANY_TYPE, "                    +
                                                                      "IFNULL(hrm_comp_companyentity.companySocialSecurityNumber,'') AS COMPANY_SSN, "  +
                                                                      "IFNULL(hrm_comp_companyentity.web,'') AS WEB, "                                  +
                                                                      "IFNULL(hrm_comp_companyentity.creationDate,'') AS CREATION_DATE, "               +
                                                                      "IFNULL(hrm_comp_companyentity.active,'') AS ACTIVE "                             +

                                                               "FROM hrm_comp_companyentity "                                                           +

                                                               "LEFT OUTER JOIN hrm_comp_companytypeentity ON hrm_comp_companytypeentity.companyTypeCode = hrm_comp_companyentity.companyTypeCode " +

                                                               "ORDER BY hrm_comp_companyentity.companyName";

    /**
     * retrieveCompanies
     * @return
     */
    public List<CompanyBaseRec> retrieveCompanies ( ) throws InvalidResultSetAccessException, DataAccessException {

        System.out.println ( "SQLQuery: " + RETRIEVE_COMPANIES_SQL_QUERY );

//        List<CompanyBaseRec> companies = this.jdbcTemplate.query ( RETRIEVE_COMPANIES_SQL_QUERY, CompanyBaseRec.class );

        return jdbcTemplate.query ( RETRIEVE_COMPANIES_SQL_QUERY,
                                                              ( rs, rowNum ) -> new CompanyBaseRec ( rs.getInt        ( "companyCode"                 ),
                                                                                                     rs.getString     ( "TAX_ID"                      ),
                                                                                                     rs.getString     ( "COMPANY_NAME"                ),
                                                                                                     rs.getInt        ( "companyTypeCode"             ),
                                                                                                     rs.getString     ( "COMPANY_TYPE"                ),
                                                                                                     rs.getString     ( "COMPANY_SSN"                 ),
                                                                                                    null,
                                                                                                     rs.getString     ( "WEB"                         ),
                                                                                                    null,
                                                                                                    null,
                                                                                                    null,
                                                                                                     rs.getBoolean    ( "ACTIVE"                      )
                                                                                                   )
                                                            );

    }

}