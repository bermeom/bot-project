package co.edu.javeriana.bot.ast;

import java.util.Map;

public class VarDecl implements ASTNode {

	private String name;
	
	
	public VarDecl(String name) {
		super();
		this.name = name;
	}

	@Override
	public Object execute(Map<String, Object> symbolTable, ProgramInfo programInfo) {
		symbolTable.put(this.name, 0);
		return null;
	}

}
