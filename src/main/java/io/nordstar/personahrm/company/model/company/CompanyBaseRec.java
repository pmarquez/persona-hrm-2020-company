
package io.nordstar.personahrm.company.model.company;

//   Standard Libraries Imports

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.time.LocalDateTime;

//   Third Party Libraries Imports
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//   FENIX Framework Imports

//   Application Domain Imports


/**
 * CompanyBaseRec.java<br/><br/>
 * Creation Date 2019-09-18 10:19 PT<br/><br/>
 * <b>DESCRIPTION:</b><br/><br/>
 * <p></p>
 *
 *<PRE>
 *<table width="90%" border="1" cellpadding="3" cellspacing="2">
 *<tr><th colspan="2">   History   </th></tr>
 *
 *<tr>
 *<td width="20%">Version 1.0<br/>
 * Version Date: 2019-09-18 10:19 PT<br/>
 * Version Creator: Paulo Márquez</td>
 *<td width="80%"><p>Creation</p></td>
 *</tr>
 *</table>
 *</PRE>
 * @author Paulo Márquez
 * @version 1.0 - 2019-09-18 10:19 PT
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompanyBaseRec {
    
    protected int          companyCode;
    protected String       companyTaxId;
    protected String       companyName;

    protected int          companyTypeCode;
    protected String       companyTypeName;

    protected String       companySocialSecurityNumber;

    protected String       email;
    protected String       web;
    protected String       phone;
    protected String       fax;

    protected LocalDateTime creationDate;

    protected boolean      active;

}
