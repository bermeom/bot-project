package co.edu.javeriana.bot.ast;

import java.util.List;
import java.util.Map;



public class Constant implements ASTNode {

	private Object value;

	public Constant(Object value) {
		super();
		this.value = value;
	}

	@Override
	public Object execute(List<Map<String,Object>>  symbolTables, ProgramInfo programInfo) {
		return this.value;
	}

}
