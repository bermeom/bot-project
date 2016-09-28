package co.edu.javeriana.bot.ast;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Function implements ASTNode {
	
	
	private String functionName;
	private List<String> inputParameters;
	private Map<String,Object> symbolTable;
	private List<ASTNode> body;
	
	public Function(String functionName, List<ASTNode> body) {
		super();
		this.symbolTable = new HashMap<String, Object>();
		this.functionName = functionName;
		this.body = body;
	}

	@Override
	public Object execute(Map<String, Object> symbolTable, ProgramInfo programInfo) {
		programInfo.addFunction(this);
		return null;
	}

	public void executeFunction(List<Object> inputParameters,Map<String,Object> symbolTable){
		
	}

	public String getFunctionName() {
		return functionName;
	}

	public void setFunctionName(String functionName) {
		this.functionName = functionName;
	}

	public Map<String, Object> getSymbolTable() {
		return symbolTable;
	}

	public void setSymbolTable(Map<String, Object> symbolTable) {
		this.symbolTable = symbolTable;
	}

	public List<ASTNode> getBody() {
		return body;
	}

	public void setBody(List<ASTNode> body) {
		this.body = body;
	}
	
}
