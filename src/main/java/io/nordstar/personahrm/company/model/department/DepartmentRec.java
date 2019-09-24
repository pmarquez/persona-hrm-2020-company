package io.nordstar.personahrm.company.model.department;

//   Standard Libraries Imports

//   Third Party Libraries Imports
import io.nordstar.personahrm.company.model.post.PostBaseRec;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

//   FENIX Framework Imports

//   Application Domain Imports

/**
 * DepartmentRec.java<br/><br/>
 * Creation Date 2019-09-24 14:39 PT<br/><br/>
 * <b>DESCRIPTION:</b><br/><br/>
 * <p></p>
 *
 *<PRE>
 *<table width="90%" border="1" cellpadding="3" cellspacing="2">
 *<tr><th colspan="2">   History   </th></tr>
 *
 *<tr>
 *<td width="20%">Version 1.0<br/>
 * Version Date: 2019-09-24 14:39 PT<br/>
 * Version Creator: Paulo Márquez</td>
 *<td width="80%"><p>Creation</p></td>
 *</tr>
 *</table>
 *</PRE>
 * @author Paulo Márquez
 * @version 1.0 - 2019-09-24 14:39 PT
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentRec extends DepartmentBaseRec {
    List<PostBaseRec> departmentPosts;
}
