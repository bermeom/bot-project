package co.edu.javeriana.bot.ast;

import java.util.Map;
import java.util.Stack;

public class OR implements ASTNode {

	protected ASTNode operand1;
	protected ASTNode operand2;
	
	public OR(ASTNode operand1, ASTNode operand2) {
		super();
		this.operand1 = operand1;
		this.operand2 = operand2;
	}

	@Override
	public Object execute(Stack<Map<String, Object>> symbolTables, ProgramInfo programInfo) {
		return (boolean)this.operand1.execute(symbolTables, programInfo)||(boolean)this.operand2.execute(symbolTables, programInfo);
	}

}
