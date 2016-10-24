package co.edu.javeriana.bot.ast;

import java.util.Map;
import java.util.Stack;


public class Addition implements ASTNode {

	protected ASTNode operand1;
	protected ASTNode operand2;
	
	public Addition(ASTNode operand1, ASTNode operand2) {
		super();
		this.operand1 = operand1;
		this.operand2 = operand2;
	}

	@Override
	public Object execute(Stack<Map<String, Object>>  symbolTables, ProgramInfo programInfo) {
		try {
			Object oper1=this.operand1.execute(symbolTables, programInfo);
			Object oper2=this.operand2.execute(symbolTables, programInfo);
			if(oper1 instanceof String){
				return (String)oper1+oper2+"";
			}else if(oper2 instanceof String){
				return oper1+(String)oper2+"";
			}
			return (double)oper1+(double)oper2;
				
		} catch (Exception e) {
			 System.err.println("-> ERROR esta tratando de sumar dos tipos de datos que no se pueden sumar");
			 System.exit(0);
		}
		return null;
	}

}
