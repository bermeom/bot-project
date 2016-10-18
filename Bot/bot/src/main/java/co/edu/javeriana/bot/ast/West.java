package co.edu.javeriana.bot.ast;

import java.util.Map;
import java.util.Stack;

public class West implements ASTNode {

	
	private ASTNode expression;
	
	public West(ASTNode expression) {
		super();
		this.expression = expression;
	}


	@Override
	public Object execute(Stack<Map<String, Object>> symbolTables,
			ProgramInfo programInfo) {
		programInfo.getBot().right((int)((double)(this.expression.execute(symbolTables, programInfo))));
		return null;
	}

}
