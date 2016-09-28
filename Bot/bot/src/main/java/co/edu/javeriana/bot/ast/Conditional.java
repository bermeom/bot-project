package co.edu.javeriana.bot.ast;


import java.util.List;
import java.util.Map;

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
	public Object execute(Map<String, Object> symbolTable, ProgramInfo programInfo) {
		if((boolean)this.condition.execute(symbolTable, null)){
			if(this.body!=null){
				for(ASTNode n: this.body){
					n.execute(symbolTable, programInfo);
				}
			}
		}else{
			if(this.elsebody!=null){
				for(ASTNode n: this.elsebody){
					n.execute(symbolTable, programInfo);
				}
			}
		}
		return null;
	}

}
