package co.edu.javeriana.bot.ast;

import java.util.Map;
import java.util.Stack;

public class North implements ASTNode {

	
	private ASTNode expression;
	
	public North(ASTNode expression) {
		super();
		this.expression = expression;
	}


	@Override
	public Object execute(Stack<Map<String, Object>> symbolTables,
			ProgramInfo programInfo) {
		programInfo.getBot().up((int)((double)(this.expression.execute(symbolTables, programInfo))));
		return null;
	}

}
