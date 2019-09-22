
package io.nordstar.personahrm.company.model.post;

//   Standard Libraries Imports
import java.time.LocalDate;
import java.time.LocalDateTime;

//   Third Party Libraries Imports
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//   FENIX Framework Imports

//   Application Domain Imports


/**
 * ContractPostRec.java<br/><br/>
 * Creation Date 2019-09-19 11:31 PT<br/><br/>
 * <b>DESCRIPTION:</b><br/><br/>
 * <p></p>
 *
 *<PRE>
 *<table width="90%" border="1" cellpadding="3" cellspacing="2">
 *<tr><th colspan="2">   History   </th></tr>
 *
 *<tr>
 *<td width="20%">Version 1.0<br/>
 * Version Date: 2019-09-19 11:31 PT<br/>
 * Version Creator: Paulo Márquez</td>
 *<td width="80%"><p>Creation</p></td>
 *</tr>
 *</table>
 *</PRE>
 * @author Paulo Márquez
 * @version 1.0 - 2019-09-19 11:31 PT
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContractPostRec {
    private int           contractPostCode;
    private int           contractCode;
    private int           departmentCode;
    private String        departmentName;
    private int           postCode;
    private String        postName;
    private int           supervisorPostCode;
    private String        supervisorPostName;
    private int           supervisorPersonCode;   //  Future Expansion
    private LocalDateTime creationDate;
    private LocalDate     activationDate;
    private LocalDate     terminationDate;
    private boolean       active;
}
