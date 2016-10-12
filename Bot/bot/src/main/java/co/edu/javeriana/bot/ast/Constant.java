package co.edu.javeriana.bot.ast;

import java.util.Map;
import java.util.Stack;



public class Constant implements ASTNode {

	private Object value;

	public Constant(Object value) {
		super();
		this.value = value;
	}

	@Override
	public Object execute(Stack<Map<String, Object>>  symbolTables, ProgramInfo programInfo) {
		return this.value;
	}

}
