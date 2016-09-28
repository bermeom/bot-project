package co.edu.javeriana.bot.ast;


import java.util.List;
import java.util.Map;

public class WhileLoop implements ASTNode {
	
	private ASTNode condition;
	private List<ASTNode>  body;
	
	public WhileLoop(ASTNode condition, List<ASTNode> body) {
		super();
		this.condition = condition;
		this.body = body;
	}

	@Override
	public Object execute(Map<String, Object> symbolTable, ProgramInfo programInfo) {
		while((boolean)this.condition.execute(symbolTable, null)){
			if(this.body!=null){
				for(ASTNode n: this.body){
					n.execute(symbolTable, programInfo);
				}
			}
		}
		return null;
	}

}
