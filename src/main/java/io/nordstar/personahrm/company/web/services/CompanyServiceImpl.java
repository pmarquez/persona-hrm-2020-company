package io.nordstar.personahrm.company.web.services;

//   Standard Libraries Imports
import java.util.List;

//   Third Party Libraries Imports
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//   FENIX Framework Imports

//   Application Domain Imports
import io.nordstar.personahrm.company.dao.CompanyDAO;
import io.nordstar.personahrm.company.model.company.CompanyBaseRec;
import io.nordstar.personahrm.company.model.company.CompanyRec;
import io.nordstar.personahrm.company.model.organization.CompanyOrgRec;

/**
 * CompanyServiceImpl.java<br/><br/>
 * Creation Date 2019-09-24 11:16 PT<br/><br/>
 * <b>DESCRIPTION:</b><br/><br/>
 * <p></p>
 *
 *<PRE>
 *<table width="90%" border="1" cellpadding="3" cellspacing="2">
 *<tr><th colspan="2">   History   </th></tr>
 *
 *<tr>
 *<td width="20%">Version 1.0<br/>
 * Version Date: 2019-09-24 11:16 PT<br/>
 * Version Creator: Paulo Márquez</td>
 *<td width="80%"><p>Creation</p></td>
 *</tr>
 *</table>
 *</PRE>
 * @author Paulo Márquez
 * @version 1.0 - 2019-09-24 11:16 PT
 */
@Service
public class CompanyServiceImpl implements CompaniesService {

    @Autowired
    private CompanyDAO companyDAO;

    @Override
    public List<CompanyBaseRec> retrieveCompanies ( ) {

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
