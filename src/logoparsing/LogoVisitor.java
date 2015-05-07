// Generated from Logo.g4 by ANTLR 4.5

  package logoparsing;

import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link LogoParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface LogoVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link LogoParser#programme}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgramme(LogoParser.ProgrammeContext ctx);
	/**
	 * Visit a parse tree produced by {@link LogoParser#liste_instructions}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitListe_instructions(LogoParser.Liste_instructionsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code av}
	 * labeled alternative in {@link LogoParser#instruction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAv(LogoParser.AvContext ctx);
	/**
	 * Visit a parse tree produced by the {@code td}
	 * labeled alternative in {@link LogoParser#instruction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTd(LogoParser.TdContext ctx);
	/**
	 * Visit a parse tree produced by the {@code tg}
	 * labeled alternative in {@link LogoParser#instruction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTg(LogoParser.TgContext ctx);
	/**
	 * Visit a parse tree produced by the {@code lc}
	 * labeled alternative in {@link LogoParser#instruction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLc(LogoParser.LcContext ctx);
	/**
	 * Visit a parse tree produced by the {@code bc}
	 * labeled alternative in {@link LogoParser#instruction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBc(LogoParser.BcContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ve}
	 * labeled alternative in {@link LogoParser#instruction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVe(LogoParser.VeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code re}
	 * labeled alternative in {@link LogoParser#instruction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRe(LogoParser.ReContext ctx);
	/**
	 * Visit a parse tree produced by the {@code fpos}
	 * labeled alternative in {@link LogoParser#instruction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFpos(LogoParser.FposContext ctx);
	/**
	 * Visit a parse tree produced by the {@code fcc}
	 * labeled alternative in {@link LogoParser#instruction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFcc(LogoParser.FccContext ctx);
	/**
	 * Visit a parse tree produced by the {@code repete}
	 * labeled alternative in {@link LogoParser#instruction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRepete(LogoParser.RepeteContext ctx);
	/**
	 * Visit a parse tree produced by the {@code donneExpr}
	 * labeled alternative in {@link LogoParser#instruction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDonneExpr(LogoParser.DonneExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code si}
	 * labeled alternative in {@link LogoParser#instruction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSi(LogoParser.SiContext ctx);
	/**
	 * Visit a parse tree produced by the {@code siSinon}
	 * labeled alternative in {@link LogoParser#instruction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSiSinon(LogoParser.SiSinonContext ctx);
	/**
	 * Visit a parse tree produced by the {@code tantQue}
	 * labeled alternative in {@link LogoParser#instruction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTantQue(LogoParser.TantQueContext ctx);
	/**
	 * Visit a parse tree produced by {@link LogoParser#booleanExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBooleanExpr(LogoParser.BooleanExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code arule}
	 * labeled alternative in {@link LogoParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArule(LogoParser.AruleContext ctx);
	/**
	 * Visit a parse tree produced by the {@code mult}
	 * labeled alternative in {@link LogoParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMult(LogoParser.MultContext ctx);
	/**
	 * Visit a parse tree produced by the {@code var}
	 * labeled alternative in {@link LogoParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVar(LogoParser.VarContext ctx);
	/**
	 * Visit a parse tree produced by the {@code sum}
	 * labeled alternative in {@link LogoParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSum(LogoParser.SumContext ctx);
	/**
	 * Visit a parse tree produced by the {@code hasard}
	 * labeled alternative in {@link LogoParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHasard(LogoParser.HasardContext ctx);
	/**
	 * Visit a parse tree produced by the {@code int}
	 * labeled alternative in {@link LogoParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInt(LogoParser.IntContext ctx);
	/**
	 * Visit a parse tree produced by the {@code double}
	 * labeled alternative in {@link LogoParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDouble(LogoParser.DoubleContext ctx);
	/**
	 * Visit a parse tree produced by the {@code loop}
	 * labeled alternative in {@link LogoParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLoop(LogoParser.LoopContext ctx);
	/**
	 * Visit a parse tree produced by the {@code parent}
	 * labeled alternative in {@link LogoParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParent(LogoParser.ParentContext ctx);
}