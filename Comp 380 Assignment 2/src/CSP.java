// ONLY EDIT THE GAC() METHOD BELOW
import java.util.List;
import java.util.ArrayList;


/*
 * STUDENT 1 NAME: Hunter Klassen
 * STUDENT 1 NUMBER: 300174049
 * 
 * 
 * STUDENT 2 NAME:
 * STUDENT 2 NUMBER
 */

/*
 * A class representing a CSP.
 * A CSP consists of Constraints and Arcs to the Variables involved.
 */

public class CSP
{

	//private Variable[] vars;
	private Constraint[] cons;
	private ArrayList<Arc> toDoArcs;
	
	// Constructor
	public CSP(Variable[] v, Constraint[] c)
	{
		//vars = v;
		cons = c;
		toDoArcs = new ArrayList<Arc>();
		for (Constraint constraint: cons)
		{
			for (Variable variable: constraint.getVariables())
			{
				Arc arc = new Arc(constraint, variable);
				toDoArcs.add(arc);
			}
		}
	}
	
	/*
	 * For binary constraints, return the other variable involved
	 * in Constraint c with Variable v1.
	 */
	public Variable getOtherVariable(Variable v1, Constraint c)
	{
		List<Variable> allConVars = c.getVariables();
		
		if (allConVars.size() == 2) {
			if (v1.equals(allConVars.get(0)))
				return allConVars.get(1);
			else if (v1.equals(allConVars.get(1)))
				return allConVars.get(0);
		}
		return null;
	}
	
	/*
	 * This is the only method you need to implement.
	 * Follow the provided pseudo-code.
	 */
	public void GAC()
	{
		// WHILE toDoArcs is not empty:
		while(toDoArcs.isEmpty() == false)
		{
			// GET an Arc from toDoArcs
			Arc arc = toDoArcs.get(0);
			toDoArcs.remove(0);			
			// Arc involves some Variable X and Constraint C
			Variable X = arc.getVariable();
			Constraint C = arc.getConstraint();
			
			// dx is domain of X
			List dx = arc.getVariable().getDomain();
			// ndx will be new domain of X
			List<Object> ndx = new ArrayList<Object>();
			
			// FOR EACH value val in dx:
			for(Object val: dx)
			{
				
				//	   boolean satisfied = false;
				boolean satisfied = false;
				//	   create new Assignment
				Assignment asn = new Assignment();
				//     SET assignment of X to val
				asn.setAssignment(X,val);
				
				//     IF C is binary constraint:
				if(C.getVariables().size() == 2)
				{
					//	       GET other variable O involved in C
					Variable O = getOtherVariable(X,C);
					
					//		   dO is domain of O
					List dO = O.getDomain();
					
					//	       FOR each value val2 in dO:
					for(Object val2: dO)
					{
						//			   SET assignment of O to val2
						asn.setAssignment(O,val2);
						
						//			   IF constraint is satisfied:
						if(C.constraintIsSatisfied(asn) == true)
						{
							//			       satisfied = true
							satisfied = true;
							
							//                 break
							break;
						}
					}
					
				}	
				//    ELSE: (is unary constraint)
				else {
					
					//		  IF constraint is satisfied:
					if(C.constraintIsSatisfied(asn) == true)
					{
						//			   satisfied = true
						satisfied = true;
					}
				}
				
				//    IF satisfied:
				if(satisfied == true)
				{
					//		   ADD val to ndx
					ndx.add(val);
				}
					// IF size of ndx < size of dx: (values have been removed)
				if(ndx.size() < dx.size())
				{
					//		set domain of X to ndx
					X.setDomain(ndx);
					
					//				update toDoArcs
					//		(add Arcs involving other variables involved in other
					//		constraints with X)
						for(Constraint c : cons)
						{
							if(c.getVariables().size() == 2 && c.getVariables().get(1) == X)
							{
								Arc redoArc = new Arc(c, c.getVariables().get(0));
								toDoArcs.add(redoArc);
							}
						}
				}
			
			}
		}	
	}
}
