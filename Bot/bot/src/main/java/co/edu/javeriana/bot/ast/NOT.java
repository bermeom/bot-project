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
		return !(boolean)this.operand1.execute(symbolTables, programInfo);
	}

}
