package co.edu.javeriana.bot.ast;

import java.util.Map;

public class VarRef implements ASTNode {

	private String name;
	
	public VarRef(String name) {
		super();
		this.name = name;
	}



	@Override
	public Object execute(Map<String, Object> symbolTable, ProgramInfo programInfo) {
		return symbolTable.get(name);
	}

}
