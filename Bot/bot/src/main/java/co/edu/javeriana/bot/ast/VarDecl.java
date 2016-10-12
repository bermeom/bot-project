package co.edu.javeriana.bot.ast;


import java.util.Map;
import java.util.Stack;

public class VarDecl implements ASTNode {

	private String name;
	
	
	public VarDecl(String name) {
		super();
		this.name = name;
	}

	@Override
	public Object execute(Stack<Map<String, Object>>  symbolTables, ProgramInfo programInfo) {
		symbolTables.peek().put(this.name, 0);
		
		return null;
	}

}
