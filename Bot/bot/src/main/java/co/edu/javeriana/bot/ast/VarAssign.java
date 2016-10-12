package co.edu.javeriana.bot.ast;

import java.util.Map;
import java.util.Stack;

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
	public Object execute(Stack<Map<String, Object>>  symbolTables, ProgramInfo programInfo) {
		for (Map<String,Object> symbolTable:Lists.reverse(symbolTables) ){
			if (symbolTable.containsKey(this.name)){
				symbolTable.put(this.name, this.expression.execute(symbolTables, programInfo));
				break;
			}
		}
		symbolTables.peek().put(this.name, this.expression.execute(symbolTables, programInfo));
		return null;
	}

}
