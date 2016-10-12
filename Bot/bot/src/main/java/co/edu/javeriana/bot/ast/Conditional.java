package co.edu.javeriana.bot.ast;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class Conditional implements ASTNode {
	
	private ASTNode condition;
	private List<ASTNode>  body;
	private List<ASTNode>  elsebody;
	
	public Conditional(ASTNode condition, List<ASTNode> body, List<ASTNode> elsebody) {
		super();
		this.condition = condition;
		this.body = body;
		this.elsebody = elsebody;
	}

	@Override
	public Object execute(Stack<Map<String, Object>>  symbolTables, ProgramInfo programInfo) {
		if((boolean)this.condition.execute(symbolTables, null)){
			if(this.body!=null){
				symbolTables.push(new HashMap<String, Object>());
				for(ASTNode n: this.body){
					n.execute(symbolTables, programInfo);
				}
				symbolTables.pop();
			}
		}else{
			if(this.elsebody!=null){
				symbolTables.push(new HashMap<String, Object>());
				for(ASTNode n: this.elsebody){
					n.execute(symbolTables, programInfo);
				}
				symbolTables.pop();
			}
		}
		return null;
	}

}
