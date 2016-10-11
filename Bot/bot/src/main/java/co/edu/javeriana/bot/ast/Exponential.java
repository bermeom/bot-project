package co.edu.javeriana.bot.ast;

import java.util.List;
import java.util.Map;

public class Exponential implements ASTNode {

	private ASTNode operand1;
	private ASTNode operand2;
	
	public Exponential(ASTNode operand1, ASTNode operand2) {
		super();
		this.operand1 = operand1;
		this.operand2 = operand2;
	}

	@Override
	public Object execute(List<Map<String,Object>>  symbolTables, ProgramInfo programInfo) {
		return Math.pow((int)this.operand1.execute(symbolTables, programInfo),(int)this.operand2.execute(symbolTables, programInfo));
	}

}
