package co.edu.javeriana.bot.ast;

import java.util.Map;
import java.util.Stack;

public class South implements ASTNode {

	
	private ASTNode expression;
	
	public South(ASTNode expression) {
		super();
		this.expression = expression;
	}


	@Override
	public Object execute(Stack<Map<String, Object>> symbolTables,
			ProgramInfo programInfo) {
		try{
			programInfo.getBot().down((int)((double)(this.expression.execute(symbolTables, programInfo))));
		} catch (Exception e) {
			 System.err.println("-> ERROR en South la expresion no es posible castear a entero");
			 System.exit(0);
		}
		return null;
	}

}
