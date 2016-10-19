package co.edu.javeriana.bot.ast;

import java.util.Map;
import java.util.Stack;

public class Return implements ASTNode {

	private ASTNode expression;
	private Object return_;
	
	public Return(ASTNode expression) {
		super();
		this.expression = expression;
		this.return_=null;
	}

	@Override
	public Object execute(Stack<Map<String, Object>> symbolTables,
			ProgramInfo programInfo) {
		this.return_=this.expression.execute(symbolTables, programInfo);
		return this;
	}

	public Object getReturn_() {
		return return_;
	}

	public void setReturn_(Object return_) {
		this.return_ = return_;
	}

	
	
}
