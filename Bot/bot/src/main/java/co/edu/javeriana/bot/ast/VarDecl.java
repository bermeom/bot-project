package co.edu.javeriana.bot.ast;


import java.util.List;
import java.util.Map;

public class VarDecl implements ASTNode {

	private String name;
	
	
	public VarDecl(String name) {
		super();
		this.name = name;
	}

	@Override
	public Object execute(List<Map<String,Object>>  symbolTables, ProgramInfo programInfo) {
		symbolTables.get(symbolTables.size()-1).put(this.name, 0);
		return null;
	}

}
