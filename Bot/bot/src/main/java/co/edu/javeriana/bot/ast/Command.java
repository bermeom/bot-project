package co.edu.javeriana.bot.ast;

import java.util.List;
import java.util.Map;


public class Command implements ASTNode {

	private String commandName;
	
	public Command(String commandName) {
		super();
		this.commandName = commandName;
	}

	@Override
	public Object execute(List<Map<String,Object>>  symbolTables, ProgramInfo programInfo) {
		switch (commandName) {
		case "pick":
			programInfo.getBot().pick();
			break;
		case "look":
			programInfo.getBot().look();
			break;
		case "drop":
			programInfo.getBot().drop();
			break;
		}
		return null;
	}

}
