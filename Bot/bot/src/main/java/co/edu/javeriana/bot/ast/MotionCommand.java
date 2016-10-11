package co.edu.javeriana.bot.ast;

import java.util.List;
import java.util.Map;

public class MotionCommand implements ASTNode {

	private String commandName;
	private ASTNode expression;
	
	public MotionCommand(String commandName, ASTNode expression) {
		super();
		this.commandName = commandName;
		this.expression = expression;
	}

	@Override
	public Object execute(List<Map<String,Object>>  symbolTables, ProgramInfo programInfo) {
		
		switch (commandName) {
		case "north":
			programInfo.getBot().up((int)this.expression.execute(symbolTables, programInfo));
			break;
		case "east":
			programInfo.getBot().left((int)this.expression.execute(symbolTables, programInfo));
			break;
		case "west":
			programInfo.getBot().right((int)this.expression.execute(symbolTables, programInfo));
			break;
		case "south":
			programInfo.getBot().down((int)this.expression.execute(symbolTables, programInfo));
			break;
		}
		return null;
	}

}
