package co.edu.javeriana.bot.ast;

import java.util.List;
import java.util.Map;

public class Print implements ASTNode {

	private ASTNode data;
	
	
	public Print(ASTNode data) {
		super();
		this.data = data;
	}


	@Override
	public Object execute(List<Map<String,Object>>  symbolTables, ProgramInfo programInfo) {
		System.out.print(data.execute(symbolTables, programInfo));
		return null;
	}

}
