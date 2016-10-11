package co.edu.javeriana.bot.ast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jpavlich.bot.Bot;

public class ProgramInfo {
	
	private Map<String,Function> functions;
	List<Map<String,Object>> symbolTables;
	private Bot bot;
	public ProgramInfo(Bot bot) {
		super();
		this.functions = new HashMap<String, Function>();
		this.symbolTables = new ArrayList<Map<String,Object>>();
		this.symbolTables.add(new HashMap<String, Object>());
		//this.symbolTable = new HashMap<String, Object>();
		this.bot = bot;
	}
	
	public void addFunction(Function function){
		this.functions.put(function.getFunctionName(), function);
	}

	public Object executeFunction(String FunctionName,List<ASTNode> inputParameters){
		return this.functions.get(FunctionName).executeFunction(inputParameters,this.symbolTables,this);
	}

	public Map<String, Function> getFunctions() {
		return functions;
	}

	public void setFunctions(Map<String, Function> functions) {
		this.functions = functions;
	}
	
	public List<Map<String, Object>> getSymbolTables() {
		return symbolTables;
	}

	public void setSymbolTables(List<Map<String, Object>> symbolTables) {
		this.symbolTables = symbolTables;
	}

	public Bot getBot() {
		return bot;
	}

	public void setBot(Bot bot) {
		this.bot = bot;
	}
	
}
