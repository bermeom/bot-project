package co.edu.javeriana.bot.ast;

import java.util.Map;
import java.util.Stack;

public class East implements ASTNode {

	
	private ASTNode expression;
	
	public East(ASTNode expression) {
		super();
		this.expression = expression;
	}


	@Override
	public Object execute(Stack<Map<String, Object>> symbolTables,
			ProgramInfo programInfo) {
		programInfo.getBot().left((int)((double)(this.expression.execute(symbolTables, programInfo))));
		return null;
	}

}
