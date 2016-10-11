package co.edu.javeriana.bot.ast;

import java.util.List;
import java.util.Map;


public class Addition implements ASTNode {

	protected ASTNode operand1;
	protected ASTNode operand2;
	
	public Addition(ASTNode operand1, ASTNode operand2) {
		super();
		this.operand1 = operand1;
		this.operand2 = operand2;
	}

	@Override
	public Object execute(List<Map<String,Object>>  symbolTables, ProgramInfo programInfo) {
		return (int)this.operand1.execute(symbolTables, programInfo)+(int)this.operand2.execute(symbolTables, programInfo);
	}

}
