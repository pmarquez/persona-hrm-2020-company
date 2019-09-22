
package io.nordstar.personahrm.company.model.post;

//   Standard Libraries Imports

//   Third Party Libraries Imports

//   FENIX Framework Imports

//   Application Domain Imports

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * PostBaseRec.java<br/><br/>
 * Creation Date 2019-09-19 10:31 PT<br/><br/>
 * <b>DESCRIPTION:</b><br/><br/>
 * <p></p>
 *
 *<PRE>
 *<table width="90%" border="1" cellpadding="3" cellspacing="2">
 *<tr><th colspan="2">   History   </th></tr>
 *
 *<tr>
 *<td width="20%">Version 1.0<br/>
 * Version Date: 2019-09-19 10:31 PT<br/>
 * Version Creator: Paulo Márquez</td>
 *<td width="80%"><p>Creation</p></td>
 *</tr>
 *</table>
 *</PRE>
 * @author Paulo Márquez
 * @version 1.0 - 2019-09-19 10:31 PT
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostBaseRec {
    protected int     postCode;              //   AutoIncrement Post Code
    protected String  postId;                //   Internal Post Code
    protected String  postName;
    protected int     companyCode;
    protected int     departmentCode;
    protected String  departmentId;
    protected String  departmentName;
    protected int     supervisorPostCode;
    protected String  supervisorPostName;
    protected boolean active;

}
