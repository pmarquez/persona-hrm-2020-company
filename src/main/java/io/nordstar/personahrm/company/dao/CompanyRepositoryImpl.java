package io.nordstar.personahrm.company.dao;

import io.nordstar.personahrm.company.model.company.CompanyBaseRec;
import io.nordstar.personahrm.company.model.company.CompanyRec;
import io.nordstar.personahrm.company.model.department.DepartmentBaseRec;
import io.nordstar.personahrm.company.model.department.DepartmentRec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.InvalidResultSetAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * CompanyRepositoryImpl.java<br><br>
 * Creation Date 2019-09-24 14:11 PT<br><br>
 * <b>DESCRIPTION:</b><br><br>
 * <p>Rest Controller for all things COMPANY</p>
 *
 *<PRE>
 *<table width="90%" border="1" cellpadding="3" cellspacing="2">
 *<tr><th colspan="2">   History   </th></tr>
 *
 *<tr>
 *<td width="20%">Version 1.0<br>
 * Version Date: 2019-09-24 14:11 PT<br>
 * Version Creator: Paulo Márquez</td>
 *<td width="80%"><p>Creation</p></td>
 *</tr>
 *</table>
 *</PRE>
 * @author Paulo Márquez
 * @version 1.0 - 2019-09-24 14:11 PT
 */
@Repository
public class CompanyRepositoryImpl implements CompanyRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private NamedParameterJdbcTemplate npJdbcTemplate;


//   Companies CRUD
    private static final String RETRIEVE_COMPANIES_SQL_QUERY = "SELECT hrm-comp-companyentity.companyCode, "                                            +
                                                                      "IFNULL(hrm-comp-companyentity.companyTaxId,'') AS TAX_ID, "                      +
                                                                      "IFNULL(hrm-comp-companyentity.companyName,'') AS COMPANY_NAME, "                 +
                                                                      "hrm-comp-companyentity.companyTypeCode, "                                        +
                                                                      "IFNULL(hrm-comp-companytypeentity.name,'') AS COMPANY_TYPE, "                    +
                                                                      "IFNULL(hrm-comp-companyentity.companySocialSecurityNumber,'') AS COMPANY_SSN, "  +
                                                                      "IFNULL(hrm-comp-companyentity.web,'') AS WEB, "                                  +
                                                                      "IFNULL(hrm-comp-companyentity.creationDate,'') AS CREATION_DATE, "               +
                                                                      "IFNULL(hrm-comp-companyentity.active,'') AS ACTIVE "                             +

                                                               "FROM hrm-comp-companyentity "                                                           +

                                                               "LEFT OUTER JOIN hrm-comp-companytypeentity ON hrm-comp-companytypeentity.companyTypeCode = hrm-comp-companyentity.companyTypeCode " +

                                                               "ORDER BY hrm-comp-companyentity.companyName";

    private static final String RETRIEVE_COMPANY_BY_CODE_SQL_QUERY = "SELECT hrm-comp-companyentity.companyCode, "                                            +
                                                                            "IFNULL(hrm-comp-companyentity.companyTaxId,'') AS TAX_ID, "                      +
                                                                            "IFNULL(hrm-comp-companyentity.companyName,'') AS COMPANY_NAME, "                 +
                                                                            "hrm_comp-companyentity.companyTypeCode, "                                        +
                                                                            "IFNULL(hrm-comp-companytypeentity.name,'') AS COMPANY_TYPE, "                    +
                                                                            "IFNULL(hrm-comp-companyentity.companySocialSecurityNumber,'') AS COMPANY_SSN, "  +
                                                                            "IFNULL(hrm-comp-companyentity.web,'') AS WEB, "                                  +
                                                                            "IFNULL(hrm-comp-companyentity.creationDate,'') AS CREATION_DATE, "               +
                                                                            "IFNULL(hrm-comp-companyentity.active,'') AS ACTIVE "                             +

                                                                     "FROM hrm-comp-companyentity "                                                           +

                                                                     "LEFT OUTER JOIN hrm-comp-companytypeentity ON hrm-comp-companytypeentity.companyTypeCode = hrm-comp-companyentity.companyTypeCode " +

                                                                     "WHERE hrm-comp-companyentity.companyCode = :companyCode";


    /**
     *
     */
    @Override
    public void createCompany ( CompanyRec company ) {

    }

    /**
     *
     * @param companyCode
     * @return
     */
    @Override
    public CompanyRec retrieveCompanyByCode ( int companyCode ) {

        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
        mapSqlParameterSource.addValue( "companyCode", companyCode );

        return npJdbcTemplate.queryForObject ( RETRIEVE_COMPANY_BY_CODE_SQL_QUERY,
                mapSqlParameterSource,
                ( rs, rowNum ) -> new CompanyRec ( rs.getInt        ( "companyCode"                 ),
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
                                                   rs.getBoolean    ( "ACTIVE"                      ),
                                                   null
                                                 )
                                           );
    }

    /**
     * retrieveCompanies
     * @return
     */
    public List<CompanyBaseRec> retrieveCompanies ( ) throws InvalidResultSetAccessException, DataAccessException {

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

    /**
     *
     * @param CompanyCode
     * @param companyRec
     */
    @Override
    public void updateCompany ( int CompanyCode, CompanyRec companyRec ) {

    }

    /**
     *
     * @param companyCode
     */
    @Override
    public void deleteCompany ( int companyCode ) {

    }


    //   Departments CRUD

    private static final String RETRIEVE_COMPANY_DEPARTMENTS_SQL_QUERY = "SELECT hrm_comp_departmententity.departmentCode, "                                                                            +
                                                                                "hrm_comp_departmententity.companyCode, "                                                                               +
                                                                                "hrm_comp_companyentity.companyName, "                                                                                  +
                                                                                "hrm_comp_departmententity.departmentName "                                                                             +

                                                                                "FROM hrm_comp_departmententity "                                                                                       +

                                                                                "LEFT OUTER JOIN hrm_comp_companyentity ON hrm_comp_companyentity.companyCode = hrm_comp_departmententity.companyCode " +

                                                                                "WHERE hrm_comp_departmententity.active = TRUE";

    /**
     *
     * @param department
     */
    @Override
    public void createDepartment ( DepartmentRec department ) {

    }

    /**
     *
     * @param departmentCode
     * @return
     */
    @Override
    public DepartmentRec retrieveDepartmentByCode ( int departmentCode ) {
        return null;
    }

    /**
     *
     * @return
     */
    @Override
    public List<DepartmentBaseRec> retrieveDepartments ( ) {
        return null;
    }

    /**
     *
     * @param departmentCode
     * @param department
     */
    @Override
    public void updateDepartment ( int departmentCode, DepartmentRec department ) {

    }

    /**
     *
     * @param departmentCode
     */
    @Override
    public void deleteDepartment ( int departmentCode ) {

    }


    //   Posts CRUD


}