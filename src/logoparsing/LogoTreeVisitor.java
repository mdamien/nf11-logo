package logoparsing;

import java.util.Random;
import java.util.Stack;

import javafx.scene.Group;
import logogui.Log;
import logogui.Traceur;
import logoparsing.LogoParser.AruleContext;
import logoparsing.LogoParser.AvContext;
import logoparsing.LogoParser.BcContext;
import logoparsing.LogoParser.BooleanExprContext;
import logoparsing.LogoParser.DonneExprContext;
import logoparsing.LogoParser.DoubleContext;
import logoparsing.LogoParser.FccContext;
import logoparsing.LogoParser.FposContext;
import logoparsing.LogoParser.HasardContext;
import logoparsing.LogoParser.IntContext;
import logoparsing.LogoParser.LcContext;
import logoparsing.LogoParser.LoopContext;
import logoparsing.LogoParser.MultContext;
import logoparsing.LogoParser.ParentContext;
import logoparsing.LogoParser.ReContext;
import logoparsing.LogoParser.RepeteContext;
import logoparsing.LogoParser.SiContext;
import logoparsing.LogoParser.SumContext;
import logoparsing.LogoParser.TdContext;
import logoparsing.LogoParser.TgContext;
import logoparsing.LogoParser.VarContext;
import logoparsing.LogoParser.VeContext;

import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeProperty;

public class LogoTreeVisitor extends LogoBaseVisitor<Integer> {
	Traceur traceur;
	ParseTreeProperty<Object> atts = new ParseTreeProperty<Object>();
	Stack<Integer> loops = new Stack<Integer>();
	SymbolesTable table = new SymbolesTable();

	public LogoTreeVisitor() {
		super();
	}
	public void initialize(Group g) {
	      traceur = new Traceur();
	      traceur.setGraphics(g);
    }
	public void setValue(ParseTree node, Object value) { 
		atts.put(node, value);
	}
	public Double getDoubleValue(ParseTree node) { return (Double)atts.get(node); }
	public Boolean getBooleanValue(ParseTree node) { return (Boolean)atts.get(node); }
	
	public Integer visitInt(IntContext ctx) {
		String intText = ctx.INT().getText();
		setValue(ctx, Double.valueOf(intText));
		return 0;
	}
	
	public Integer visitDouble(DoubleContext ctx) {
		setValue(ctx, Double.parseDouble(ctx.getText()));
		Log.appendnl("visitDouble "+ctx.getText());
		return 0;
	}
	
	public Integer visitLoop(LoopContext ctx) {
		setValue(ctx, loops.peek().doubleValue());
		return 0;
	}
	
	public Integer visitDonneExpr(DonneExprContext ctx) {
		visit(ctx.expr());
		String var = ctx.DECL_VAR().getText().substring(1);
		Double val = getDoubleValue(ctx.expr());
		table.set(var,val);
		Log.appendnl("visitDonneExpr "+ctx.getText());
		return 0;
	}
	
	public Integer visitVar(VarContext ctx) {
		String var = ctx.USE_VAR().getText().substring(1);
		setValue(ctx, table.get(var));
		Log.appendnl("visitVar "+ctx.getText());
		return 0;
	}
	
	public Integer visitRepete(RepeteContext ctx){
		visit(ctx.expr());
		Integer nbRep = getDoubleValue(ctx.expr()).intValue();
		loops.add(0);
		for (int i = 0; i < nbRep ; ++i){
			loops.pop();
			loops.add(i);
			visit(ctx.liste_instructions());
		}
		loops.pop();
		return 0;
	}
	
	public Integer visitSi(SiContext ctx){
		visit(ctx.booleanExpr());
		Boolean cond = getBooleanValue(ctx.booleanExpr());
		if(cond){
			visit(ctx.liste_instructions());
		}
		return 0;
	}
	
	public Integer visitBooleanExpr(BooleanExprContext ctx){
		visitChildren(ctx);
		double left = getDoubleValue(ctx.expr(0));
		double right = getDoubleValue(ctx.expr(0));
		boolean result = true;
		String op = ctx.BOOLEAN_OPERATOR().getText();
		if(op.equals("<")){
			result = left < right;
		}
		if(op.equals(">")){
			result = left > right;
		}
		if(op.equals("==")){
			result = left == right;
		}
		if(op.equals("!=")){
			result = left != right;
		}
		if(op.equals( "<=")){
			result = left <= right;
		}
		if(op.equals(">=")){
			result = left >= right;
		}
		setValue(ctx, new Boolean(result));
		Log.appendnl("visitBooleanExpr "+ctx.getText());
		return 0;
	}
	
	public Integer visitParent(ParentContext ctx) {
		visit(ctx.expr());
		setValue(ctx, getDoubleValue(ctx.expr()));
		return 0;
	}
	
	public Integer visitArule(AruleContext ctx) {
		visit(ctx.atom());
		setValue(ctx, getDoubleValue(ctx.atom()));
		return 0;
	}
	
	public Integer visitSum(SumContext ctx) {
		visitChildren(ctx);
		Double left = getDoubleValue(ctx.expr(0));
		Double right = getDoubleValue(ctx.expr(1));
		setValue(ctx, ctx.getChild(1).getText().equals("+") ?
			left + right : left - right);
		return 0;
	}
	
	public Integer visitMult(MultContext ctx) {
		visitChildren(ctx);
		Double left = getDoubleValue(ctx.expr(0));
		Double right = getDoubleValue(ctx.expr(1));
		setValue(ctx, ctx.getChild(1).getText().equals("*") ?
			left * right : left / right);
		return 0;
	}
	
	public Integer visitHasard(HasardContext ctx){
		visitChildren(ctx);
		Double v = getDoubleValue(ctx.expr());
		Double hasardV = new Random().nextDouble()*v;
		setValue(ctx, hasardV);
		return 0;
	}
	
	@Override
	public Integer visitAv(AvContext ctx) {
		visitChildren(ctx);
		Double value = getDoubleValue(ctx.expr());
		traceur.avance(value);
		Log.appendnl("visitAv ; V = " + value);
		return 0;
	}
	@Override
	public Integer visitTd(TdContext ctx) {
		visitChildren(ctx);
		Double value = getDoubleValue(ctx.expr());
		traceur.td(value);
		Log.appendnl("visitTd" );
		return 0;
	}
	@Override
	public Integer visitTg(TgContext ctx) {
		visitChildren(ctx);
		Double value = getDoubleValue(ctx.expr());
		traceur.tg(value);
		Log.appendnl("visitTg" );
		return 0;
	}
	@Override
	public Integer visitLc(LcContext ctx) {
		visitChildren(ctx);
		traceur.lc();
		Log.appendnl("visitLc");
		return 0;
	}
	@Override
	public Integer visitBc(BcContext ctx) {
		visitChildren(ctx);
		traceur.bc();
		Log.appendnl("visitBc");
		return 0;
	}
	@Override
	public Integer visitVe(VeContext ctx) {
		visitChildren(ctx);
		traceur.ve();
		Log.appendnl("ClearScreen");
		return 0;
	}
	@Override
	public Integer visitRe(ReContext ctx) {
		visitChildren(ctx);
		Double value = getDoubleValue(ctx.expr());
		traceur.re(value);
		Log.appendnl("visitRe");
		return 0;
	}
	@Override
	public Integer visitFpos(FposContext ctx) {
		visitChildren(ctx);
		if (ctx.expr().size() != 2){
			Log.appendnl("visitFpos - oops, too few arguments");
		}else{
			Double valueX = getDoubleValue(ctx.expr(0));
			Double valueY = getDoubleValue(ctx.expr(1));
			traceur.fpos(valueX, valueY);
			Log.appendnl("visitFpos");
		}
		return 0;
	}
	@Override
	public Integer visitFcc(FccContext ctx) {
		visitChildren(ctx);
		Double value = getDoubleValue(ctx.expr());
		traceur.fcc(value.intValue());
		Log.appendnl("visitFcc" );
		return 0;
	}

}
