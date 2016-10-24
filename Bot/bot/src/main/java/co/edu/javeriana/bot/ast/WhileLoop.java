package co.edu.javeriana.bot.ast;


import java.util.Map;
import java.util.Stack;

public class WhileLoop implements ASTNode {
	
	private ASTNode condition;
	private CodeBlock  body;
	
	public WhileLoop(ASTNode condition, CodeBlock body) {
		super();
		this.condition = condition;
		this.body = body;
	}

	@Override
	public Object execute(Stack<Map<String, Object>>  symbolTables, ProgramInfo programInfo) {
		Object return_=null;
		while((boolean)this.condition.execute(symbolTables, null)){
			if(this.body!=null){
				return_=this.body.execute(symbolTables, programInfo);
				if(return_!=null && return_ instanceof Return){
					return return_;
				}
			}
		}
		return null;
	}

}
