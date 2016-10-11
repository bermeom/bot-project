package co.edu.javeriana.bot.ast;

import java.util.List;
import java.util.Map;

public interface ASTNode {
	public Object execute(List<Map<String,Object>>  symbolTables, ProgramInfo programInfo);
}
