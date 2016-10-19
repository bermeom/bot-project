package co.edu.javeriana.bot.ast;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class Function implements ASTNode {
	
	
	private String functionName;
	private List<String> inputParameters;
	private CodeBlock body;
	
	
	public Function(String functionName, List<String> inputParameters,
			CodeBlock body) {
		super();
		this.functionName = functionName;
		this.inputParameters = inputParameters;
		this.body = body;
	}

	@Override
	public Object execute(Stack<Map<String, Object>>  symbolTables, ProgramInfo programInfo) {
		programInfo.addFunction(this);
		return null;
	}

	public Object executeFunction(List<ASTNode> inputParameters,Stack<Map<String,Object>>  symbolTables,ProgramInfo programInfo){
		Map<String,Object> symbolTable = new HashMap<String, Object>();
		for (int i=0;i<inputParameters.size();i++){
			symbolTable.put(this.inputParameters.get(i), inputParameters.get(i).execute(symbolTables, programInfo));
		}
		symbolTables.push(symbolTable);
		Object return_=this.body.execute(symbolTables, programInfo);
		symbolTables.pop();
		if(return_!=null && return_ instanceof Return){
			return ((Return) return_).getReturn_();
		}
		return null;
	}

	public String getFunctionName() {
		return functionName;
	}

	public void setFunctionName(String functionName) {
		this.functionName = functionName;
	}

	public CodeBlock getBody() {
		return body;
	}

	public void setBody(CodeBlock body) {
		this.body = body;
	}
	
}
