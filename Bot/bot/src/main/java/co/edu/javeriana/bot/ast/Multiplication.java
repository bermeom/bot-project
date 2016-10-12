package co.edu.javeriana.bot.ast;

import java.util.Map;
import java.util.Stack;

public class Multiplication implements ASTNode {

	private ASTNode operand1;
	private ASTNode operand2;
	
	public Multiplication(ASTNode operand1, ASTNode operand2) {
		super();
		this.operand1 = operand1;
		this.operand2 = operand2;
	}

	@Override
	public Object execute(Stack<Map<String, Object>>  symbolTables, ProgramInfo programInfo) {
		return (double)this.operand1.execute(symbolTables, programInfo)*(double)this.operand2.execute(symbolTables, programInfo);
	}

}
