package co.edu.javeriana.bot.ast;

import java.util.Map;

public class Constant implements ASTNode {

	private Object value;

	public Constant(Object value) {
		super();
		this.value = value;
	}

	@Override
	public Object execute(Map<String, Object> symbolTable, ProgramInfo programInfo) {
		// TODO Auto-generated method stub
		return this.value;
	}

}
