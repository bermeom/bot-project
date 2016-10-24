package co.edu.javeriana.bot.ast;

import java.util.Map;
import java.util.Stack;

public class Division implements ASTNode {

	private ASTNode operand1;
	private ASTNode operand2;
	
	public Division(ASTNode operand1, ASTNode operand2) {
		super();
		this.operand1 = operand1;
		this.operand2 = operand2;
	}

	@Override
	public Object execute(Stack<Map<String, Object>>  symbolTables, ProgramInfo programInfo) {
		try{
			return (double)this.operand1.execute(symbolTables, programInfo)/(double)this.operand2.execute(symbolTables, programInfo);
		} catch (Exception e) {
			 System.err.println("-> ERROR esta tratando de dividir dos tipos de datos que no se pueden dividir");
			 System.exit(0);
		}
		return null;
	}

}
