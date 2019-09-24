package io.nordstar.personahrm.company.dao;

import io.nordstar.personahrm.company.model.company.CompanyBaseRec;
import io.nordstar.personahrm.company.model.company.CompanyRec;
import io.nordstar.personahrm.company.model.department.DepartmentBaseRec;
import io.nordstar.personahrm.company.model.department.DepartmentRec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.InvalidResultSetAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
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

//   Companies CRUD

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
        return null;
    }

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