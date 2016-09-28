package co.edu.javeriana.bot.ast;

import java.util.Map;

public class VarAssign implements ASTNode {

	private String name;
	private ASTNode expression;
	
	public VarAssign(String name, ASTNode expression) {
		super();
		this.name = name;
		this.expression = expression;
	}

	@Override
	public Object execute(Map<String, Object> symbolTable, ProgramInfo programInfo) {
		symbolTable.put(this.name, this.expression.execute(symbolTable, programInfo));
		return null;
	}

}
