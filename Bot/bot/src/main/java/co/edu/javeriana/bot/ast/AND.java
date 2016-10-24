package co.edu.javeriana.bot.ast;

import java.util.Map;
import java.util.Stack;

public class AND implements ASTNode {

	protected ASTNode operand1;
	protected ASTNode operand2;
	
	public AND(ASTNode operand1, ASTNode operand2) {
		super();
		this.operand1 = operand1;
		this.operand2 = operand2;
	}

	@Override
	public Object execute(Stack<Map<String, Object>> symbolTables, ProgramInfo programInfo) {
		try{
			return (boolean)this.operand1.execute(symbolTables, programInfo)&&(boolean)this.operand2.execute(symbolTables, programInfo);
		} catch (Exception e) {
			 System.err.println("-> ERROR esta tratando de hacer una operacion booleana con dos tipos de datos que uno o los dos no son booleanos");
			 System.exit(0);
		}
		return null;
	}

}
