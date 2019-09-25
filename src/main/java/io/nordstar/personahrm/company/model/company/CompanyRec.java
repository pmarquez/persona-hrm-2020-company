
package io.nordstar.personahrm.company.model.company;

//   Standard Libraries Imports
import java.time.LocalDateTime;
import java.util.List;
//   Third Party Libraries Imports
import lombok.Data;

//   FENIX Framework Imports


//   Application Domain Imports
import io.nordstar.personahrm.company.model.postalAddress.PostalAddressRec;
import lombok.NoArgsConstructor;

/**
 * CompanyRec.java<br/><br/>
 * Creation Date 2019-09-18 10:21 PT<br/><br/>
 * <b>DESCRIPTION:</b><br/><br/>
 * <p></p>
 *
 *<PRE>
 *<table width="90%" border="1" cellpadding="3" cellspacing="2">
 *<tr><th colspan="2">   History   </th></tr>
 *
 *<tr>
 *<td width="20%">Version 1.0<br/>
 * Version Date: 2019-09-18 10:21 PT<br/>
 * Version Creator: Paulo Márquez</td>
 *<td width="80%"><p>Creation</p></td>
 *</tr>
 *</table>
 *</PRE>
 * @author Paulo Márquez
 * @version 1.0 - 2019-09-18 10:21 PT
 */
@Data
@NoArgsConstructor
public class CompanyRec extends CompanyBaseRec {
//    private List<CompanyContactRec>  contacts;
    private List<PostalAddressRec> postalAddresses;

    /**
     * All Args Constructor
     * @param companyCode
     * @param companyTaxId
     * @param companyName
     * @param companyTypeCode
     * @param companyTypeName
     * @param companySocialSecurityNumber
     * @param email
     * @param web
     * @param phone
     * @param fax
     * @param creationDate
     * @param active
     * @param postalAddresses
     */
    public CompanyRec ( int companyCode,
                        String companyTaxId,
                        String companyName,
                        int companyTypeCode,
                        String companyTypeName,
                        String companySocialSecurityNumber,
                        String email,
                        String web,
                        String phone,
                        String fax,
                        LocalDateTime creationDate,
                        boolean active,
                        List<PostalAddressRec> postalAddresses ) {

        super ( companyCode,
                companyTaxId,
                companyName,
                companyTypeCode,
                companyTypeName,
                companySocialSecurityNumber,
                email,
                web,
                phone,
                fax,
                creationDate,
                active );

        this.postalAddresses = postalAddresses;

    }

}
