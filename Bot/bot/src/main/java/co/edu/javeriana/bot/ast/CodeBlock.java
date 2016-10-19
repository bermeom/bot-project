package co.edu.javeriana.bot.ast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class CodeBlock implements ASTNode {
	
	private List<ASTNode>  body;
	
	
	
	public CodeBlock() {
		super();
		this.body= new ArrayList<ASTNode>();
	}

	public CodeBlock(List<ASTNode> body) {
		super();
		this.body = body;
	}

	@Override
	public Object execute(Stack<Map<String, Object>>  symbolTables, ProgramInfo programInfo) {
		Object return_=null;
			if(this.body!=null){
				symbolTables.push(new HashMap<String, Object>());
				for(ASTNode n: this.body){
					return_=n.execute(symbolTables, programInfo);
					if(return_!=null && return_ instanceof Return){
						symbolTables.pop();
						return return_;
					}
				}
				symbolTables.pop();
			}
		return null;
	}
	
	public void add(ASTNode node){
		this.body.add(node);
	}

}
