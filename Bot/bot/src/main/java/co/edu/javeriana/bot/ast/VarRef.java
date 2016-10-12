package co.edu.javeriana.bot.ast;

import java.util.Map;
import java.util.Stack;

import com.google.common.collect.Lists;

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
		return null;
	}

}
