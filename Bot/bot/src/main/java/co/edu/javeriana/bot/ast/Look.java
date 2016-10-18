package co.edu.javeriana.bot.ast;

import java.util.Map;
import java.util.Stack;

public class Look implements ASTNode {

	
	
	@Override
	public Object execute(Stack<Map<String, Object>> symbolTables,
			ProgramInfo programInfo) {
		programInfo.getBot().look();
		return null;
	}

}
