package io.nordstar.personahrm.company.dao;

import io.nordstar.personahrm.company.model.company.CompanyBaseRec;
import io.nordstar.personahrm.company.model.company.CompanyRec;
import io.nordstar.personahrm.company.model.department.DepartmentBaseRec;
import io.nordstar.personahrm.company.model.department.DepartmentRec;

import java.util.List;

/**
 * CompanyRepository.java<br><br>
 * Creation Date 2019-09-24 14:10 PT<br><br>
 * <b>DESCRIPTION:</b><br><br>
 * <p>Rest Controller for all things COMPANY</p>
 *
 *<PRE>
 *<table width="90%" border="1" cellpadding="3" cellspacing="2">
 *<tr><th colspan="2">   History   </th></tr>
 *
 *<tr>
 *<td width="20%">Version 1.0<br>
 * Version Date: 2019-09-24 14:10 PT<br>
 * Version Creator: Paulo Márquez</td>
 *<td width="80%"><p>Creation</p></td>
 *</tr>
 *</table>
 *</PRE>
 * @author Paulo Márquez
 * @version 1.0 - 2019-09-24 14:10 PT
 */
public interface CompanyRepository {

//   Company CRUD
    public void createCompany ( CompanyRec company );

    public CompanyRec retrieveCompanyByCode ( int companyCode );

    public List<CompanyBaseRec> retrieveCompanies ( );

    public void updateCompany ( int companyCode, CompanyRec company );

    public void deleteCompany ( int companyCode );


//   Departments CRUD
    public void createDepartment ( DepartmentRec department );

    public DepartmentRec retrieveDepartmentByCode ( int departmentCode );

    public List<DepartmentBaseRec> retrieveDepartments ( );

    public void updateDepartment ( int departmentCode, DepartmentRec department );

    public void deleteDepartment ( int departmentCode );


//   Department Posts

//   ...

}
