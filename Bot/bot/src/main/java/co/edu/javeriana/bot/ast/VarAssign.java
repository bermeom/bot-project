package co.edu.javeriana.bot.ast;

import java.util.Map;
import java.util.Stack;


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
		Object expressionResult=this.expression.execute(symbolTables, programInfo);
		for(int i=symbolTables.size()-1;i>=0;i--){
			if (symbolTables.get(i).containsKey(this.name)){
				symbolTables.get(i).put(this.name,expressionResult );
				return null;
			}
		}
		System.err.println("-> ERROR la variable "+this.name+" no fue declarada");
		System.exit(0);
		return null;
	}

}
