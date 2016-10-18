package co.edu.javeriana.bot.ast;

import java.util.Map;
import java.util.Stack;

public class Pick implements ASTNode {

	
	
	@Override
	public Object execute(Stack<Map<String, Object>> symbolTables,
			ProgramInfo programInfo) {
		programInfo.getBot().pick();
		return null;
	}

}
