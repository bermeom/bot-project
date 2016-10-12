package co.edu.javeriana.bot.ast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.Stack;

public class Read implements ASTNode {

	private String name;
	
	public Read(String name) {
		super();
		this.name = name;
	}

	@Override
	public Object execute(Stack<Map<String, Object>> symbolTables, ProgramInfo programInfo) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			String s=br.readLine();
			for(int i=symbolTables.size()-1;i>=0;i--){
				if (symbolTables.get(i).containsKey(this.name)){
					try {
						symbolTables.get(i).put(this.name,Double.parseDouble(s));
					} catch (Exception e) {
						symbolTables.get(i).put(this.name,s);
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}

}
