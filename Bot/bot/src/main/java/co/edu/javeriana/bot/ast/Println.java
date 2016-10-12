package co.edu.javeriana.bot.ast;

import java.util.Map;
import java.util.Stack;

public class Println implements ASTNode {

	private ASTNode data;
	
	
	public Println(ASTNode data) {
		super();
		this.data = data;
	}


	@Override
	public Object execute(Stack<Map<String, Object>>  symbolTables, ProgramInfo programInfo) {
		System.out.println(data.execute(symbolTables, programInfo));
		return null;
	}

}
