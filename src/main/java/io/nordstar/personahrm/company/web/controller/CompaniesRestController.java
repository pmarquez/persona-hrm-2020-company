
package io.nordstar.personahrm.company.web.controller;


//   Standard Libraries Imports
import javax.servlet.http.HttpServletRequest;
import java.util.List;

//   Third Party Libraries Imports
import io.nordstar.personahrm.company.model.company.CompanyRec;
import io.nordstar.personahrm.company.model.organization.CompanyOrgRec;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//   FENIX Framework Imports


//   Application Domain Imports
import io.nordstar.personahrm.company.model.company.CompanyBaseRec;
import io.nordstar.personahrm.company.web.services.CompaniesService;

/**
 * CompaniesRestController.java<br><br>
 * Creation Date 2019-09-18 13:58 PT<br><br>
 * <b>DESCRIPTION:</b><br><br>
 * <p>Rest Controller for all things COMPANY</p>
 *
 *<PRE>
 *<table width="90%" border="1" cellpadding="3" cellspacing="2">
 *<tr><th colspan="2">   History   </th></tr>
 *
 *<tr>
 *<td width="20%">Version 1.0<br>
 * Version Date: 2019-09-18 13:58 PT<br>
 * Version Creator: Paulo Márquez</td>
 *<td width="80%"><p>Creation</p></td>
 *</tr>
 *</table>
 *</PRE>
 * @author Paulo Márquez
 * @version 1.0 - 2019-09-18 13:58 PT
 */
@RestController
public class CompaniesRestController {

    private static final Logger logger = LogManager.getLogger ( CompaniesRestController.class );

//   Controller Constants
    private static final int EMPTY_COMPANY_LIST      = 0;
    private static final int EMPTY_COMPANY_REC       = 0;
    private static final int EMPTY_ORG_REC_NODE_LIST = 0;
    
//   Response Status
    private static final String OPERATION_SUCCESSFUL                            = "COMPANIES_001";   //   The requested operation was successfully completed.
    private static final String NO_COMPANY_FOUND                                = "COMPANIES_002";   //   Could not find requested company.
    private static final String NO_COMPANIES_FOUND                              = "COMPANIES_003";   //   The requested list of companies is empty.
    private static final String INVALID_USER_PRIVILEGES                         = "COMPANIES_004";   //   User does not have the required privileges for this call.
    private static final String INVALID_AUTHORIZATION_TOKEN                     = "COMPANIES_005";   //   Authorization token received is not valid.
    private static final String INTERNAL_ERROR_ENCOUNTERED                      = "COMPANIES_006";   //   An internal error was encountered.
    private static final String REQUESTED_COMPANY_EXISTS                        = "COMPANIES_007";   //   The requested company exists.
    private static final String REQUESTED_COMPANY_DOES_NOT_EXIST                = "COMPANIES_008";   //   The requested company does not exist.
    private static final String NO_ORG_REC_NODES_FOUND                          = "COMPANIES_009";   //   The requested list of organizational nodes is empty.

    private final CompaniesService companiesService;

/**
 * Constructor
 *
 * @param companiesService
 */
public CompaniesRestController ( CompaniesService companiesService ) {
        this.companiesService = companiesService;
    }

    /**
     *
     * @param company
     * @return
     */
    @PostMapping ( value = "/companiesAPI/1.0/companies/companies" )
    public ResponseEntity createCompany ( @RequestBody CompanyRec company ) {
        return new ResponseEntity ( HttpStatus.CREATED );
    }

    /**
     * Returns a list of all the companies available to the current role.
     * @return ResponseRec<List<CompanyBaseRec>>
     */
    @GetMapping ( value = "/companiesAPI/1.0/companies/companies" )
    public ResponseEntity<List<CompanyBaseRec>> retrieveCompanies ( ) {

        List<CompanyBaseRec> l = companiesService.retrieveCompanies ( );

        ResponseEntity response = null;

        if ( l.size ( ) > CompaniesRestController.EMPTY_COMPANY_LIST ) {
            response = new ResponseEntity ( l, HttpStatus.OK );
            logger.info ( "Hello from Log4j 2 - num : {}",  "YES FOUND" );

        } else {
            response = new ResponseEntity ( l, HttpStatus.NOT_FOUND );
            logger.info ( "Hello from Log4j 2 - num : {}",  "NOT FOUND" );

        }

        logger.trace ( "Hello from Log4j2",  "-TRACE-" );
        logger.debug ( "Hello from Log4j2",  "-DEBUG-" );
        logger.error ( "Hello from Log4j2",  "-ERROR Hello, Hola, Halo, Ça va, Ciao, Aloha." );
        logger.info ( "Hello from Log4j2",  "-INFO-" );

        return response;
    }

    /**
     * Returns all the relevant information for a company identified by <code>companyCode</code>
     * @param companyCode the ID that uniquely identifies a given company.
     * @return ResponseRec<CompanyRec>
     */
    @GetMapping ( value = "/companiesAPI/1.0/companies/company/{companyCode}" )
    public ResponseEntity<CompanyRec> retrieveCompanyByCode ( @PathVariable int companyCode ) {

        CompanyRec r = companiesService.retrieveCompanyByCode ( companyCode );

        ResponseEntity response = null;

        if ( r.getCompanyCode ( ) > CompaniesRestController.EMPTY_COMPANY_REC ) {
            response = new ResponseEntity ( r, HttpStatus.OK );

        } else {
            response = new ResponseEntity ( r, HttpStatus.NOT_FOUND );

        }

        return response;

    }

    /**
     * Checks whether a company exists in storage.
     * @param companyCode
     * @param request
     * @return ResponseRec<Boolean>
     * @since 1.o
     */
    @RequestMapping ( value = "/companiesAPI/1.0/companies/exists/{companyCode}", method = RequestMethod.GET )
    public ResponseEntity companyExists ( @PathVariable int companyCode, HttpServletRequest request ) {

        CompanyRec r = companiesService.retrieveCompanyByCode ( companyCode );

        ResponseEntity response = null;

        if ( r.getCompanyCode ( ) > CompaniesRestController.EMPTY_COMPANY_REC ) {
            response = new ResponseEntity ( HttpStatus.FOUND );

        } else {
            response = new ResponseEntity ( HttpStatus.NOT_FOUND );

        }

        return response;

    }

    /**
     * Retrieves a list of Organizational Rec Nodes for the requested company.
     * @param companyCode
     * @return
     */
    @GetMapping ( value = "/companiesAPI/1.0/companies/organization/{companyCode}" )
    public ResponseEntity<List<CompanyOrgRec>> retrieveCompanyOrganization ( @PathVariable int companyCode ) {

        List<CompanyOrgRec> l = companiesService.retrieveCompanyOrganization ( companyCode );

        ResponseEntity response = null;

        if ( l.size ( ) > CompaniesRestController.EMPTY_ORG_REC_NODE_LIST ) {
            response = new ResponseEntity ( l, HttpStatus.OK );

        } else {
            response = new ResponseEntity ( l, HttpStatus.NOT_FOUND );

        }

        return response;

    }

    /**
     *
     * @param companyCode
     * @param company
     */
    @PutMapping ( value = "/companiesAPI/1.0/companies/company/{companyCode}" )
    public ResponseEntity updateCompany ( @PathVariable int companyCode, @RequestBody CompanyRec company ) {
        return new ResponseEntity ( HttpStatus.NO_CONTENT );
    }

    /**
     *
     * @param companyCode
     */
    @DeleteMapping ( value = "/companiesAPI/1.0/companies/company/{companyCode}" )
    public ResponseEntity deleteCompany ( @PathVariable int companyCode ) {
        return new ResponseEntity ( HttpStatus.NO_CONTENT );
    }

}
