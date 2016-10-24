package co.edu.javeriana.bot.ast;

import java.util.Map;
import java.util.Stack;

public class NOT implements ASTNode {

	protected ASTNode operand1;
	
	public NOT(ASTNode operand1) {
		super();
		this.operand1 = operand1;
	}

	@Override
	public Object execute(Stack<Map<String, Object>> symbolTables, ProgramInfo programInfo) {
		try{
			return !(boolean)this.operand1.execute(symbolTables, programInfo);
		} catch (Exception e) {
			 System.err.println("-> ERROR esta tratando de hacer una operacion booleana con dos tipos de datos que uno o los dos no son booleanos");
			 System.exit(0);
		}
		return null;
	}

}
