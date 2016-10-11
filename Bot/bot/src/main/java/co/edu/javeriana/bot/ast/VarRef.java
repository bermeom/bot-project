package co.edu.javeriana.bot.ast;

import java.util.List;
import java.util.Map;

import com.google.common.collect.Lists;

public class VarRef implements ASTNode {

	private String name;
	
	public VarRef(String name) {
		super();
		this.name = name;
	}



	@Override
	public Object execute(List<Map<String,Object>>  symbolTables, ProgramInfo programInfo) {
		for (Map<String,Object> symbolTable:Lists.reverse(symbolTables) ){
			if (symbolTable.containsKey(this.name)){
				return symbolTable.get(name);
			}
		}
		return null;
	}

}
