package co.edu.javeriana.bot.ast;

import java.util.Map;
import java.util.Stack;

public class MotionCommand implements ASTNode {

	private String commandName;
	private ASTNode expression;
	
	public MotionCommand(String commandName, ASTNode expression) {
		super();
		this.commandName = commandName;
		this.expression = expression;
	}

	@Override
	public Object execute(Stack<Map<String, Object>>  symbolTables, ProgramInfo programInfo) {
		switch (commandName) {
		case "north": 
			programInfo.getBot().up((int)((double)(this.expression.execute(symbolTables, programInfo))));
			break;
		case "east":
			programInfo.getBot().left((int)((double)(this.expression.execute(symbolTables, programInfo))));
			break;
		case "west":
			programInfo.getBot().right((int)((double)(this.expression.execute(symbolTables, programInfo))));
			break;
		case "south":
			programInfo.getBot().down((int)((double)(this.expression.execute(symbolTables, programInfo))));;
			break;
		}
		return null;
	}

}
