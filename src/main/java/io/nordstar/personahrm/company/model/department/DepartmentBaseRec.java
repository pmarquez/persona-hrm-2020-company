
package io.nordstar.personahrm.company.model.department;


//   Standard Libraries Imports

//   Third Party Libraries Imports
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//   FENIX Framework Imports

//   Application Domain Imports


/**
 * DepartmentBaseRec.java<br/><br/>
 * Creation Date 2019-09-19 10:26 PT<br/><br/>
 * <b>DESCRIPTION:</b><br/><br/>
 * <p></p>
 *
 *<PRE>
 *<table width="90%" border="1" cellpadding="3" cellspacing="2">
 *<tr><th colspan="2">   History   </th></tr>
 *
 *<tr>
 *<td width="20%">Version 1.0<br/>
 * Version Date: 2019-09-19 10:26 PT<br/>
 * Version Creator: Paulo Márquez</td>
 *<td width="80%"><p>Creation</p></td>
 *</tr>
 *</table>
 *</PRE>
 * @author Paulo Márquez
 * @version 1.0 - 2019-09-19 10:26 PT
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentBaseRec {
    protected int     departmentCode;
    protected String  departmentName;
    protected String  description;
    protected boolean active;

}
