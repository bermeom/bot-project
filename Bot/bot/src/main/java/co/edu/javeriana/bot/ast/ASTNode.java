package co.edu.javeriana.bot.ast;

import java.util.Map;
import java.util.Stack;

public interface ASTNode {
	public Object execute(Stack<Map<String, Object>>  symbolTables, ProgramInfo programInfo);
}
