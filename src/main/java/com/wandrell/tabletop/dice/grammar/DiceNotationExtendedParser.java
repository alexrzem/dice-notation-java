package com.wandrell.tabletop.dice.grammar;

// Generated from DiceNotationExtended.g4 by ANTLR 4.5
import org.antlr.v4.runtime.NoViableAltException;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.RuntimeMetaData;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.Vocabulary;
import org.antlr.v4.runtime.VocabularyImpl;
import org.antlr.v4.runtime.atn.ATN;
import org.antlr.v4.runtime.atn.ATNDeserializer;
import org.antlr.v4.runtime.atn.ParserATNSimulator;
import org.antlr.v4.runtime.atn.PredictionContextCache;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.TerminalNode;

@SuppressWarnings({ "all", "warnings", "unchecked", "unused", "cast" })
public class DiceNotationExtendedParser extends Parser {
    static {
        RuntimeMetaData.checkVersion("4.5", RuntimeMetaData.VERSION);
    }

    protected static final DFA[]                  _decisionToDFA;
    protected static final PredictionContextCache _sharedContextCache = new PredictionContextCache();
    public static final int                       T__0                = 1,
            T__1 = 2, DiceHeader = 3, GROUP_MODIFIER = 4, FUNCTION = 5,
            OPERATOR_ADD = 6, OPERATOR_DIV = 7, TIMES = 8, SIGN = 9,
            SEPARATOR = 10, PERCENTILE = 11, FUDGE = 12, LPAREN = 13,
            RPAREN = 14, NUMBER = 15;
    public static final int                       RULE_notation       = 0,
            RULE_expression = 1, RULE_operand = 2,
            RULE_operationParenthesis = 3, RULE_dice = 4, RULE_integerDice = 5,
            RULE_percentileDice = 6, RULE_fudgeDice = 7;
    public static final String[]                  ruleNames           = {
            "notation", "expression", "operand", "operationParenthesis",
            "dice", "integerDice", "percentileDice", "fudgeDice"     };

    private static final String[]                 _LITERAL_NAMES      = { null,
            "'+'", "'-'", null, null, null, null, null, "'x'", null, null,
            "'%'", "'F'", "'('", "')'"                               };
    private static final String[]                 _SYMBOLIC_NAMES     = { null,
            null, null, "DiceHeader", "GROUP_MODIFIER", "FUNCTION",
            "OPERATOR_ADD", "OPERATOR_DIV", "TIMES", "SIGN", "SEPARATOR",
            "PERCENTILE", "FUDGE", "LPAREN", "RPAREN", "NUMBER"      };
    public static final Vocabulary                VOCABULARY          = new VocabularyImpl(
                                                                              _LITERAL_NAMES,
                                                                              _SYMBOLIC_NAMES);

    /**
     * @deprecated Use {@link #VOCABULARY} instead.
     */
    @Deprecated
    public static final String[]                  tokenNames;
    static {
        tokenNames = new String[_SYMBOLIC_NAMES.length];
        for (int i = 0; i < tokenNames.length; i++) {
            tokenNames[i] = VOCABULARY.getLiteralName(i);
            if (tokenNames[i] == null) {
                tokenNames[i] = VOCABULARY.getSymbolicName(i);
            }

            if (tokenNames[i] == null) {
                tokenNames[i] = "<INVALID>";
            }
        }
    }

    @Override
    @Deprecated
    public String[] getTokenNames() {
        return tokenNames;
    }

    @Override
    public Vocabulary getVocabulary() {
        return VOCABULARY;
    }

    @Override
    public String getGrammarFileName() {
        return "DiceNotationExtended.g4";
    }

    @Override
    public String[] getRuleNames() {
        return ruleNames;
    }

    @Override
    public String getSerializedATN() {
        return _serializedATN;
    }

    @Override
    public ATN getATN() {
        return _ATN;
    }

    public DiceNotationExtendedParser(TokenStream input) {
        super(input);
        _interp = new ParserATNSimulator(this, _ATN, _decisionToDFA,
                _sharedContextCache);
    }

    public static class NotationContext extends ParserRuleContext {
        public ExpressionContext expression() {
            return getRuleContext(ExpressionContext.class, 0);
        }

        public NotationContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_notation;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof DiceNotationExtendedListener)
                ((DiceNotationExtendedListener) listener).enterNotation(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof DiceNotationExtendedListener)
                ((DiceNotationExtendedListener) listener).exitNotation(this);
        }
    }

    public final NotationContext notation() throws RecognitionException {
        NotationContext _localctx = new NotationContext(_ctx, getState());
        enterRule(_localctx, 0, RULE_notation);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(16);
                expression();
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class ExpressionContext extends ParserRuleContext {
        public OperandContext operand() {
            return getRuleContext(OperandContext.class, 0);
        }

        public ExpressionContext expression() {
            return getRuleContext(ExpressionContext.class, 0);
        }

        public TerminalNode OPERATOR_DIV() {
            return getToken(DiceNotationExtendedParser.OPERATOR_DIV, 0);
        }

        public DiceContext dice() {
            return getRuleContext(DiceContext.class, 0);
        }

        public TerminalNode FUNCTION() {
            return getToken(DiceNotationExtendedParser.FUNCTION, 0);
        }

        public ExpressionContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_expression;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof DiceNotationExtendedListener)
                ((DiceNotationExtendedListener) listener).enterExpression(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof DiceNotationExtendedListener)
                ((DiceNotationExtendedListener) listener).exitExpression(this);
        }
    }

    public final ExpressionContext expression() throws RecognitionException {
        ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
        enterRule(_localctx, 2, RULE_expression);
        int _la;
        try {
            setState(31);
            switch (getInterpreter().adaptivePredict(_input, 1, _ctx)) {
                case 1:
                    enterOuterAlt(_localctx, 1);
                    {
                        setState(18);
                        operand();
                        setState(21);
                        switch (_input.LA(1)) {
                            case OPERATOR_DIV: {
                                setState(19);
                                match(OPERATOR_DIV);
                            }
                                break;
                            case T__0:
                            case T__1: {
                                setState(20);
                                _la = _input.LA(1);
                                if (!(_la == T__0 || _la == T__1)) {
                                    _errHandler.recoverInline(this);
                                } else {
                                    consume();
                                }
                            }
                                break;
                            default:
                                throw new NoViableAltException(this);
                        }
                        setState(23);
                        expression();
                    }
                    break;
                case 2:
                    enterOuterAlt(_localctx, 2);
                    {
                        setState(25);
                        dice();
                        setState(26);
                        match(FUNCTION);
                    }
                    break;
                case 3:
                    enterOuterAlt(_localctx, 3);
                    {
                        setState(28);
                        operand();
                    }
                    break;
                case 4:
                    enterOuterAlt(_localctx, 4);
                    {
                        setState(29);
                        _la = _input.LA(1);
                        if (!(_la == T__0 || _la == T__1)) {
                            _errHandler.recoverInline(this);
                        } else {
                            consume();
                        }
                        setState(30);
                        operand();
                    }
                    break;
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class OperandContext extends ParserRuleContext {
        public DiceContext dice() {
            return getRuleContext(DiceContext.class, 0);
        }

        public TerminalNode NUMBER() {
            return getToken(DiceNotationExtendedParser.NUMBER, 0);
        }

        public OperationParenthesisContext operationParenthesis() {
            return getRuleContext(OperationParenthesisContext.class, 0);
        }

        public OperandContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_operand;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof DiceNotationExtendedListener)
                ((DiceNotationExtendedListener) listener).enterOperand(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof DiceNotationExtendedListener)
                ((DiceNotationExtendedListener) listener).exitOperand(this);
        }
    }

    public final OperandContext operand() throws RecognitionException {
        OperandContext _localctx = new OperandContext(_ctx, getState());
        enterRule(_localctx, 4, RULE_operand);
        try {
            setState(36);
            switch (_input.LA(1)) {
                case DiceHeader:
                    enterOuterAlt(_localctx, 1);
                    {
                        setState(33);
                        dice();
                    }
                    break;
                case NUMBER:
                    enterOuterAlt(_localctx, 2);
                    {
                        setState(34);
                        match(NUMBER);
                    }
                    break;
                case GROUP_MODIFIER:
                case LPAREN:
                    enterOuterAlt(_localctx, 3);
                    {
                        setState(35);
                        operationParenthesis();
                    }
                    break;
                default:
                    throw new NoViableAltException(this);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class OperationParenthesisContext extends ParserRuleContext {
        public TerminalNode LPAREN() {
            return getToken(DiceNotationExtendedParser.LPAREN, 0);
        }

        public ExpressionContext expression() {
            return getRuleContext(ExpressionContext.class, 0);
        }

        public TerminalNode RPAREN() {
            return getToken(DiceNotationExtendedParser.RPAREN, 0);
        }

        public TerminalNode GROUP_MODIFIER() {
            return getToken(DiceNotationExtendedParser.GROUP_MODIFIER, 0);
        }

        public OperationParenthesisContext operationParenthesis() {
            return getRuleContext(OperationParenthesisContext.class, 0);
        }

        public OperationParenthesisContext(ParserRuleContext parent,
                int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_operationParenthesis;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof DiceNotationExtendedListener)
                ((DiceNotationExtendedListener) listener)
                        .enterOperationParenthesis(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof DiceNotationExtendedListener)
                ((DiceNotationExtendedListener) listener)
                        .exitOperationParenthesis(this);
        }
    }

    public final OperationParenthesisContext operationParenthesis()
            throws RecognitionException {
        OperationParenthesisContext _localctx = new OperationParenthesisContext(
                _ctx, getState());
        enterRule(_localctx, 6, RULE_operationParenthesis);
        try {
            setState(44);
            switch (_input.LA(1)) {
                case LPAREN:
                    enterOuterAlt(_localctx, 1);
                    {
                        setState(38);
                        match(LPAREN);
                        setState(39);
                        expression();
                        setState(40);
                        match(RPAREN);
                    }
                    break;
                case GROUP_MODIFIER:
                    enterOuterAlt(_localctx, 2);
                    {
                        setState(42);
                        match(GROUP_MODIFIER);
                        setState(43);
                        operationParenthesis();
                    }
                    break;
                default:
                    throw new NoViableAltException(this);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class DiceContext extends ParserRuleContext {
        public IntegerDiceContext integerDice() {
            return getRuleContext(IntegerDiceContext.class, 0);
        }

        public PercentileDiceContext percentileDice() {
            return getRuleContext(PercentileDiceContext.class, 0);
        }

        public FudgeDiceContext fudgeDice() {
            return getRuleContext(FudgeDiceContext.class, 0);
        }

        public DiceContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_dice;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof DiceNotationExtendedListener)
                ((DiceNotationExtendedListener) listener).enterDice(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof DiceNotationExtendedListener)
                ((DiceNotationExtendedListener) listener).exitDice(this);
        }
    }

    public final DiceContext dice() throws RecognitionException {
        DiceContext _localctx = new DiceContext(_ctx, getState());
        enterRule(_localctx, 8, RULE_dice);
        try {
            setState(49);
            switch (getInterpreter().adaptivePredict(_input, 4, _ctx)) {
                case 1:
                    enterOuterAlt(_localctx, 1);
                    {
                        setState(46);
                        integerDice();
                    }
                    break;
                case 2:
                    enterOuterAlt(_localctx, 2);
                    {
                        setState(47);
                        percentileDice();
                    }
                    break;
                case 3:
                    enterOuterAlt(_localctx, 3);
                    {
                        setState(48);
                        fudgeDice();
                    }
                    break;
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class IntegerDiceContext extends ParserRuleContext {
        public TerminalNode DiceHeader() {
            return getToken(DiceNotationExtendedParser.DiceHeader, 0);
        }

        public TerminalNode NUMBER() {
            return getToken(DiceNotationExtendedParser.NUMBER, 0);
        }

        public IntegerDiceContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_integerDice;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof DiceNotationExtendedListener)
                ((DiceNotationExtendedListener) listener)
                        .enterIntegerDice(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof DiceNotationExtendedListener)
                ((DiceNotationExtendedListener) listener).exitIntegerDice(this);
        }
    }

    public final IntegerDiceContext integerDice() throws RecognitionException {
        IntegerDiceContext _localctx = new IntegerDiceContext(_ctx, getState());
        enterRule(_localctx, 10, RULE_integerDice);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(51);
                match(DiceHeader);
                setState(52);
                match(NUMBER);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class PercentileDiceContext extends ParserRuleContext {
        public TerminalNode DiceHeader() {
            return getToken(DiceNotationExtendedParser.DiceHeader, 0);
        }

        public TerminalNode PERCENTILE() {
            return getToken(DiceNotationExtendedParser.PERCENTILE, 0);
        }

        public PercentileDiceContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_percentileDice;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof DiceNotationExtendedListener)
                ((DiceNotationExtendedListener) listener)
                        .enterPercentileDice(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof DiceNotationExtendedListener)
                ((DiceNotationExtendedListener) listener)
                        .exitPercentileDice(this);
        }
    }

    public final PercentileDiceContext percentileDice()
            throws RecognitionException {
        PercentileDiceContext _localctx = new PercentileDiceContext(_ctx,
                getState());
        enterRule(_localctx, 12, RULE_percentileDice);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(54);
                match(DiceHeader);
                setState(55);
                match(PERCENTILE);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class FudgeDiceContext extends ParserRuleContext {
        public TerminalNode DiceHeader() {
            return getToken(DiceNotationExtendedParser.DiceHeader, 0);
        }

        public TerminalNode FUDGE() {
            return getToken(DiceNotationExtendedParser.FUDGE, 0);
        }

        public FudgeDiceContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_fudgeDice;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof DiceNotationExtendedListener)
                ((DiceNotationExtendedListener) listener).enterFudgeDice(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof DiceNotationExtendedListener)
                ((DiceNotationExtendedListener) listener).exitFudgeDice(this);
        }
    }

    public final FudgeDiceContext fudgeDice() throws RecognitionException {
        FudgeDiceContext _localctx = new FudgeDiceContext(_ctx, getState());
        enterRule(_localctx, 14, RULE_fudgeDice);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(57);
                match(DiceHeader);
                setState(58);
                match(FUDGE);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static final String _serializedATN = "\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\21?\4\2\t\2\4\3\t"
                                                      + "\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\3\2\3\2\3\3\3\3\3\3"
                                                      + "\5\3\30\n\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3\"\n\3\3\4\3\4\3\4\5\4"
                                                      + "\'\n\4\3\5\3\5\3\5\3\5\3\5\3\5\5\5/\n\5\3\6\3\6\3\6\5\6\64\n\6\3\7\3\7"
                                                      + "\3\7\3\b\3\b\3\b\3\t\3\t\3\t\3\t\2\2\n\2\4\6\b\n\f\16\20\2\3\3\2\3\4?"
                                                      + "\2\22\3\2\2\2\4!\3\2\2\2\6&\3\2\2\2\b.\3\2\2\2\n\63\3\2\2\2\f\65\3\2\2"
                                                      + "\2\168\3\2\2\2\20;\3\2\2\2\22\23\5\4\3\2\23\3\3\2\2\2\24\27\5\6\4\2\25"
                                                      + "\30\7\t\2\2\26\30\t\2\2\2\27\25\3\2\2\2\27\26\3\2\2\2\30\31\3\2\2\2\31"
                                                      + "\32\5\4\3\2\32\"\3\2\2\2\33\34\5\n\6\2\34\35\7\7\2\2\35\"\3\2\2\2\36\""
                                                      + "\5\6\4\2\37 \t\2\2\2 \"\5\6\4\2!\24\3\2\2\2!\33\3\2\2\2!\36\3\2\2\2!\37"
                                                      + "\3\2\2\2\"\5\3\2\2\2#\'\5\n\6\2$\'\7\21\2\2%\'\5\b\5\2&#\3\2\2\2&$\3\2"
                                                      + "\2\2&%\3\2\2\2\'\7\3\2\2\2()\7\17\2\2)*\5\4\3\2*+\7\20\2\2+/\3\2\2\2,"
                                                      + "-\7\6\2\2-/\5\b\5\2.(\3\2\2\2.,\3\2\2\2/\t\3\2\2\2\60\64\5\f\7\2\61\64"
                                                      + "\5\16\b\2\62\64\5\20\t\2\63\60\3\2\2\2\63\61\3\2\2\2\63\62\3\2\2\2\64"
                                                      + "\13\3\2\2\2\65\66\7\5\2\2\66\67\7\21\2\2\67\r\3\2\2\289\7\5\2\29:\7\r"
                                                      + "\2\2:\17\3\2\2\2;<\7\5\2\2<=\7\16\2\2=\21\3\2\2\2\7\27!&.\63";
    public static final ATN    _ATN           = new ATNDeserializer()
                                                      .deserialize(_serializedATN
                                                              .toCharArray());
    static {
        _decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
        for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
            _decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
        }
    }
}