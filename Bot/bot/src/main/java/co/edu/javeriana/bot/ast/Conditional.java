package co.edu.javeriana.bot.ast;



import java.util.Map;
import java.util.Stack;

public class Conditional implements ASTNode {
	
	private ASTNode condition;
	private CodeBlock  body;
	private CodeBlock  elsebody;
	
	public Conditional(ASTNode condition, CodeBlock body, CodeBlock elsebody) {
		super();
		this.condition = condition;
		this.body = body;
		this.elsebody = elsebody;
	}

	@Override
	public Object execute(Stack<Map<String, Object>>  symbolTables, ProgramInfo programInfo) {
		if((boolean)this.condition.execute(symbolTables, null)){
			if(this.body!=null){
				return this.body.execute(symbolTables, programInfo);
			}
		}else{
			if(this.elsebody!=null){
				return this.elsebody.execute(symbolTables, programInfo);
			}
		}
		return null;
	}

}
