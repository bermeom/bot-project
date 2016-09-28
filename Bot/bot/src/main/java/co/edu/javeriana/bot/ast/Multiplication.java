package co.edu.javeriana.bot.ast;

import java.util.Map;

public class Multiplication implements ASTNode {

	private ASTNode operand1;
	private ASTNode operand2;
	
	public Multiplication(ASTNode operand1, ASTNode operand2) {
		super();
		this.operand1 = operand1;
		this.operand2 = operand2;
	}

	@Override
	public Object execute(Map<String, Object> symbolTable, ProgramInfo programInfo) {
		return (int)this.operand1.execute(symbolTable, programInfo)*(int)this.operand2.execute(symbolTable, programInfo);
	}

}
