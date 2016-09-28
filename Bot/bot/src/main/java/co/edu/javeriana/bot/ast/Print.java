package co.edu.javeriana.bot.ast;

import java.util.Map;

public class Print implements ASTNode {

	private ASTNode data;
	
	
	public Print(ASTNode data) {
		super();
		this.data = data;
	}


	@Override
	public Object execute(Map<String, Object> symbolTable, ProgramInfo programInfo) {
		System.out.print(data.execute(symbolTable, programInfo));
		return null;
	}

}
