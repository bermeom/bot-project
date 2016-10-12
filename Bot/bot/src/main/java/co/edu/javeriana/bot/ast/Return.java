package co.edu.javeriana.bot.ast;

import java.util.Map;
import java.util.Stack;

public class Return implements ASTNode {

	private ASTNode expression;
	
	public Return(ASTNode expression) {
		super();
		this.expression = expression;
	}

	@Override
	public Object execute(Stack<Map<String, Object>> symbolTables,
			ProgramInfo programInfo) {
		return this.expression.execute(symbolTables, programInfo);
	}

}
