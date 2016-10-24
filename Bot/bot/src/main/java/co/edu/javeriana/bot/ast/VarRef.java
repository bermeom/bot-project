package co.edu.javeriana.bot.ast;

import java.util.Map;
import java.util.Stack;


public class VarRef implements ASTNode {

	private String name;
	
	public VarRef(String name) {
		super();
		this.name = name;
	}



	@Override
	public Object execute(Stack<Map<String, Object>>  symbolTables, ProgramInfo programInfo) {
		for(int i=symbolTables.size()-1;i>=0;i--){
			if (symbolTables.get(i).containsKey(this.name)){
				return symbolTables.get(i).get(name);
			}
		}
		System.err.println("-> ERROR la variable "+this.name+" no fue declarada");
		System.exit(0);
		return null;
	}

}
