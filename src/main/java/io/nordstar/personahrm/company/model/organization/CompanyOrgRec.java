
package io.nordstar.personahrm.company.model.organization;

//   Standard Libraries Imports

//   Third Party Libraries Imports

//   FENIX Framework Imports

//   Application Domain Imports


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * CompanyOrgRec.java<br><br>
 * Creation Date 2019-00-18 14:19 PT<br><br>
 * <b>DESCRIPTION:</b><br><br>
 * <p></p>
 *
 *<PRE>
 *<table width="90%" border="1" cellpadding="3" cellspacing="2">
 *<tr><th colspan="2">   History   </th></tr>
 *
 *<tr>
 *<td width="20%">Version 1.0<br>
 * Version Date: 2019-00-18 14:19 PT<br>
 * Version Creator: Paulo Márquez</td>
 *<td width="80%"><p>Creation</p></td>
 *</tr>
 *</table>
 *</PRE>
 * @author Paulo Márquez Herrero
 * @version 1.0 - 2019-00-18 14:19 PT
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompanyOrgRec {
    private int     companyCode;
    private String  companyName;
    private int     departmentCode;
    private String  departmentName;
    private int     postCode; 
    private String  postId;
    private String  postName;
    private int     numPostOpenings;
    private int     supervisorPostCode;
    private boolean active;
}
