package co.edu.javeriana.bot.ast;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jpavlich.bot.Bot;

public class ProgramInfo {
	
	private Map<String,Function> functions;
	Map<String,Object> symbolTable;
	private Bot bot;
	public ProgramInfo(Bot bot) {
		super();
		this.functions = new HashMap<String, Function>();
		this.symbolTable = new HashMap<String, Object>();
		this.bot = bot;
	}
	
	public void addFunction(Function function){
		this.functions.put(function.getFunctionName(), function);
	}

	public void executeFunction(String FunctionName,List<Object> inputParameters){
		this.functions.get(FunctionName).executeFunction(inputParameters,this.symbolTable);
	}

	public Map<String, Function> getFunctions() {
		return functions;
	}

	public void setFunctions(Map<String, Function> functions) {
		this.functions = functions;
	}

	public Map<String, Object> getSymbolTable() {
		return symbolTable;
	}

	public void setSymbolTable(Map<String, Object> symbolTable) {
		this.symbolTable = symbolTable;
	}

	public Bot getBot() {
		return bot;
	}

	public void setBot(Bot bot) {
		this.bot = bot;
	}
	
}
