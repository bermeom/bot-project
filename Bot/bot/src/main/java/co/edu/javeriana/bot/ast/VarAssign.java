package co.edu.javeriana.bot.ast;

import java.util.List;
import java.util.Map;

import com.google.common.collect.Lists;

public class VarAssign implements ASTNode {

	private String name;
	private ASTNode expression;
	
	public VarAssign(String name, ASTNode expression) {
		super();
		this.name = name;
		this.expression = expression;
	}

	@Override
	public Object execute(List<Map<String,Object>>  symbolTables, ProgramInfo programInfo) {
		for (Map<String,Object> symbolTable:Lists.reverse(symbolTables) ){
			if (symbolTable.containsKey(this.name)){
				symbolTable.put(this.name, this.expression.execute(symbolTables, programInfo));
				break;
			}
		}
		System.out.println("hooola "+symbolTables.size()+" -> "+name);
		symbolTables.get(symbolTables.size()-1).put(this.name, this.expression.execute(symbolTables, programInfo));
		return null;
	}

}
