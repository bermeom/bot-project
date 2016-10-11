package co.edu.javeriana.bot.ast;

import java.util.List;
import java.util.Map;

public class AdditionString extends Addition {

	public AdditionString(ASTNode operand1, ASTNode operand2) {
		super(operand1, operand2);
	}
	
	@Override
	public Object execute(List<Map<String,Object>>  symbolTables, ProgramInfo programInfo) {
		return this.operand1.execute(symbolTables, programInfo).toString()+this.operand2.execute(symbolTables, programInfo).toString()+" ";
	}

}
