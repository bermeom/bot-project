package co.edu.javeriana.bot.ast;

import java.util.Map;
import java.util.Stack;

public class LEQ implements ASTNode {

	protected ASTNode operand1;
	protected ASTNode operand2;
	
	public LEQ(ASTNode operand1, ASTNode operand2) {
		super();
		this.operand1 = operand1;
		this.operand2 = operand2;
	}

	@Override
	public Object execute(Stack<Map<String, Object>> symbolTables, ProgramInfo programInfo) {
		try{
			return (double)this.operand1.execute(symbolTables, programInfo) <= (double)this.operand2.execute(symbolTables, programInfo);
		} catch (Exception e) {
			 System.err.println("-> ERROR esta tratando de usar el operar menor igual en dos tipos de datos, donde uno o los dos no soportan este operador");
			 System.exit(0);
		}
		return null;
	}

}
