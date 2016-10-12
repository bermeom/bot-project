package co.edu.javeriana.bot.ast;

import java.util.Map;
import java.util.Stack;

public class Print implements ASTNode {

	private ASTNode data;
	
	
	public Print(ASTNode data) {
		super();
		this.data = data;
	}


	@Override
	public Object execute(Stack<Map<String, Object>>  symbolTables, ProgramInfo programInfo) {
		System.out.print(data.execute(symbolTables, programInfo));
		return null;
	}

}
