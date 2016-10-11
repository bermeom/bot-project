package co.edu.javeriana.bot.ast;

import java.util.List;
import java.util.Map;

public class Println implements ASTNode {

	private ASTNode data;
	
	
	public Println(ASTNode data) {
		super();
		this.data = data;
	}


	@Override
	public Object execute(List<Map<String,Object>>  symbolTables, ProgramInfo programInfo) {
		System.out.println(data.execute(symbolTables, programInfo));
		return null;
	}

}
