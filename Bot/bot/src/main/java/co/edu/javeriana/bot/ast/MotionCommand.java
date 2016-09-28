package co.edu.javeriana.bot.ast;

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
	public Object execute(Map<String, Object> symbolTable, ProgramInfo programInfo) {
		
		switch (commandName) {
		case "north":
			programInfo.getBot().up((int)this.expression.execute(symbolTable, programInfo));
			break;
		case "east":
			programInfo.getBot().left((int)this.expression.execute(symbolTable, programInfo));
			break;
		case "west":
			programInfo.getBot().right((int)this.expression.execute(symbolTable, programInfo));
			break;
		case "south":
			programInfo.getBot().down((int)this.expression.execute(symbolTable, programInfo));
			break;
		}
		return null;
	}

}
