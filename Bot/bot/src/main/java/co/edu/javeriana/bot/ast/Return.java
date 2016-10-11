package co.edu.javeriana.bot.ast;

import java.util.List;
import java.util.Map;

public class Return implements ASTNode {

	private ASTNode expression;
	
	public Return(ASTNode expression) {
		super();
		this.expression = expression;
	}

	@Override
	public Object execute(List<Map<String, Object>> symbolTables,
			ProgramInfo programInfo) {
		return this.expression.execute(symbolTables, programInfo);
	}

}
