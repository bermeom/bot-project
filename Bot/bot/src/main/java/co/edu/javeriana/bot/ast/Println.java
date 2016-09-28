package co.edu.javeriana.bot.ast;

import java.util.Map;

public class Println implements ASTNode {

	private ASTNode data;
	
	
	public Println(ASTNode data) {
		super();
		this.data = data;
	}


	@Override
	public Object execute(Map<String, Object> symbolTable, ProgramInfo programInfo) {
		System.out.println(data.execute(symbolTable, programInfo));
		return null;
	}

}
