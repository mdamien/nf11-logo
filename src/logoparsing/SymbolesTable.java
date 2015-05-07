package logoparsing;

import java.util.Hashtable;
import java.util.Stack;

public class SymbolesTable {
	
	Stack<Hashtable<String, Object>> vars = new Stack<>();
	
	public SymbolesTable() {
		this.enterBlock();
	}

	public void exitBlock() {
		vars.pop();
	}

	public void enterBlock() {
		vars.add(new Hashtable<String, Object>());
	}

	public Object get(String var) {
		System.out.println("get "+var);
		return vars.peek().get(var);
	}

	public void set(String var, Object val) {
		System.out.println("set "+var+ " "+ val);
		vars.peek().put(var, val);
	}
	
}
