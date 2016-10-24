package co.edu.javeriana.bot.ast;


import java.util.Map;
import java.util.Stack;

public class VarDecl implements ASTNode {

	private String name;
	private ASTNode value;

	public VarDecl(String name, ASTNode value) {
		super();
		this.name = name;
		this.value = value;
	}



	@Override
	public Object execute(Stack<Map<String, Object>>  symbolTables, ProgramInfo programInfo) {
		if(symbolTables.peek().containsKey(this.name)){
			System.err.println("-> ERROR la variable "+this.name+" ya fue declarada");
			System.exit(0);
		}
		
		if(this.value instanceof Constant){
			symbolTables.peek().put(this.name, this.value.execute(symbolTables, programInfo));
		}else{
			symbolTables.peek().put(this.name, 0);
			this.value.execute(symbolTables, programInfo);
		}
		return null;
	}

}
