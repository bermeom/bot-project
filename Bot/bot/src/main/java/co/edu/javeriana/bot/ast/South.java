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
		programInfo.getBot().down((int)((double)(this.expression.execute(symbolTables, programInfo))));
		return null;
	}

}
