package org.xtext.example.mydsl.ui.contentassist.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.Lexer;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalVideoGenLexer extends Lexer {
    public static final int RULE_STRING=6;
    public static final int RULE_SL_COMMENT=12;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int RULE_RIGHT_BRACKET=5;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int EOF=-1;
    public static final int RULE_ID=7;
    public static final int RULE_WS=13;
    public static final int RULE_LEFT_BRACKET=4;
    public static final int RULE_ANY_OTHER=14;
    public static final int T__26=26;
    public static final int RULE_PERCENTAGE=9;
    public static final int RULE_INT=10;
    public static final int T__22=22;
    public static final int RULE_ML_COMMENT=11;
    public static final int T__23=23;
    public static final int RULE_FLOAT=8;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__20=20;
    public static final int T__21=21;

    // delegates
    // delegators

    public InternalVideoGenLexer() {;} 
    public InternalVideoGenLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public InternalVideoGenLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "InternalVideoGen.g"; }

    // $ANTLR start "T__15"
    public final void mT__15() throws RecognitionException {
        try {
            int _type = T__15;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalVideoGen.g:11:7: ( 'VideoGen' )
            // InternalVideoGen.g:11:9: 'VideoGen'
            {
            match("VideoGen"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__15"

    // $ANTLR start "T__16"
    public final void mT__16() throws RecognitionException {
        try {
            int _type = T__16;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalVideoGen.g:12:7: ( '@author' )
            // InternalVideoGen.g:12:9: '@author'
            {
            match("@author"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__16"

    // $ANTLR start "T__17"
    public final void mT__17() throws RecognitionException {
        try {
            int _type = T__17;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalVideoGen.g:13:7: ( '@version' )
            // InternalVideoGen.g:13:9: '@version'
            {
            match("@version"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__17"

    // $ANTLR start "T__18"
    public final void mT__18() throws RecognitionException {
        try {
            int _type = T__18;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalVideoGen.g:14:7: ( '@creation' )
            // InternalVideoGen.g:14:9: '@creation'
            {
            match("@creation"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__18"

    // $ANTLR start "T__19"
    public final void mT__19() throws RecognitionException {
        try {
            int _type = T__19;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalVideoGen.g:15:7: ( 'mandatory' )
            // InternalVideoGen.g:15:9: 'mandatory'
            {
            match("mandatory"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__19"

    // $ANTLR start "T__20"
    public final void mT__20() throws RecognitionException {
        try {
            int _type = T__20;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalVideoGen.g:16:7: ( 'optional' )
            // InternalVideoGen.g:16:9: 'optional'
            {
            match("optional"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__20"

    // $ANTLR start "T__21"
    public final void mT__21() throws RecognitionException {
        try {
            int _type = T__21;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalVideoGen.g:17:7: ( 'alternatives' )
            // InternalVideoGen.g:17:9: 'alternatives'
            {
            match("alternatives"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__21"

    // $ANTLR start "T__22"
    public final void mT__22() throws RecognitionException {
        try {
            int _type = T__22;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalVideoGen.g:18:7: ( 'videoseq' )
            // InternalVideoGen.g:18:9: 'videoseq'
            {
            match("videoseq"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__22"

    // $ANTLR start "T__23"
    public final void mT__23() throws RecognitionException {
        try {
            int _type = T__23;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalVideoGen.g:19:7: ( 'duration' )
            // InternalVideoGen.g:19:9: 'duration'
            {
            match("duration"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__23"

    // $ANTLR start "T__24"
    public final void mT__24() throws RecognitionException {
        try {
            int _type = T__24;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalVideoGen.g:20:7: ( 'probability' )
            // InternalVideoGen.g:20:9: 'probability'
            {
            match("probability"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__24"

    // $ANTLR start "T__25"
    public final void mT__25() throws RecognitionException {
        try {
            int _type = T__25;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalVideoGen.g:21:7: ( 'size' )
            // InternalVideoGen.g:21:9: 'size'
            {
            match("size"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__25"

    // $ANTLR start "T__26"
    public final void mT__26() throws RecognitionException {
        try {
            int _type = T__26;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalVideoGen.g:22:7: ( 'description' )
            // InternalVideoGen.g:22:9: 'description'
            {
            match("description"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__26"

    // $ANTLR start "RULE_PERCENTAGE"
    public final void mRULE_PERCENTAGE() throws RecognitionException {
        try {
            int _type = RULE_PERCENTAGE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalVideoGen.g:1874:17: ( ( '1' .. '9' ( '0' .. '9' )? | '100' ) )
            // InternalVideoGen.g:1874:19: ( '1' .. '9' ( '0' .. '9' )? | '100' )
            {
            // InternalVideoGen.g:1874:19: ( '1' .. '9' ( '0' .. '9' )? | '100' )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0=='1') ) {
                int LA2_1 = input.LA(2);

                if ( (LA2_1=='0') ) {
                    int LA2_3 = input.LA(3);

                    if ( (LA2_3=='0') ) {
                        alt2=2;
                    }
                    else {
                        alt2=1;}
                }
                else {
                    alt2=1;}
            }
            else if ( ((LA2_0>='2' && LA2_0<='9')) ) {
                alt2=1;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // InternalVideoGen.g:1874:20: '1' .. '9' ( '0' .. '9' )?
                    {
                    matchRange('1','9'); 
                    // InternalVideoGen.g:1874:29: ( '0' .. '9' )?
                    int alt1=2;
                    int LA1_0 = input.LA(1);

                    if ( ((LA1_0>='0' && LA1_0<='9')) ) {
                        alt1=1;
                    }
                    switch (alt1) {
                        case 1 :
                            // InternalVideoGen.g:1874:30: '0' .. '9'
                            {
                            matchRange('0','9'); 

                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // InternalVideoGen.g:1874:41: '100'
                    {
                    match("100"); 


                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_PERCENTAGE"

    // $ANTLR start "RULE_FLOAT"
    public final void mRULE_FLOAT() throws RecognitionException {
        try {
            int _type = RULE_FLOAT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalVideoGen.g:1876:12: ( RULE_INT '.' RULE_INT )
            // InternalVideoGen.g:1876:14: RULE_INT '.' RULE_INT
            {
            mRULE_INT(); 
            match('.'); 
            mRULE_INT(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_FLOAT"

    // $ANTLR start "RULE_LEFT_BRACKET"
    public final void mRULE_LEFT_BRACKET() throws RecognitionException {
        try {
            int _type = RULE_LEFT_BRACKET;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalVideoGen.g:1878:19: ( '{' )
            // InternalVideoGen.g:1878:21: '{'
            {
            match('{'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_LEFT_BRACKET"

    // $ANTLR start "RULE_RIGHT_BRACKET"
    public final void mRULE_RIGHT_BRACKET() throws RecognitionException {
        try {
            int _type = RULE_RIGHT_BRACKET;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalVideoGen.g:1880:20: ( '}' )
            // InternalVideoGen.g:1880:22: '}'
            {
            match('}'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_RIGHT_BRACKET"

    // $ANTLR start "RULE_ID"
    public final void mRULE_ID() throws RecognitionException {
        try {
            int _type = RULE_ID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalVideoGen.g:1882:9: ( ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* )
            // InternalVideoGen.g:1882:11: ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            {
            // InternalVideoGen.g:1882:11: ( '^' )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0=='^') ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // InternalVideoGen.g:1882:11: '^'
                    {
                    match('^'); 

                    }
                    break;

            }

            if ( (input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // InternalVideoGen.g:1882:40: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( ((LA4_0>='0' && LA4_0<='9')||(LA4_0>='A' && LA4_0<='Z')||LA4_0=='_'||(LA4_0>='a' && LA4_0<='z')) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // InternalVideoGen.g:
            	    {
            	    if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_ID"

    // $ANTLR start "RULE_INT"
    public final void mRULE_INT() throws RecognitionException {
        try {
            int _type = RULE_INT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalVideoGen.g:1884:10: ( ( '0' .. '9' )+ )
            // InternalVideoGen.g:1884:12: ( '0' .. '9' )+
            {
            // InternalVideoGen.g:1884:12: ( '0' .. '9' )+
            int cnt5=0;
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( ((LA5_0>='0' && LA5_0<='9')) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // InternalVideoGen.g:1884:13: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

            	    }
            	    break;

            	default :
            	    if ( cnt5 >= 1 ) break loop5;
                        EarlyExitException eee =
                            new EarlyExitException(5, input);
                        throw eee;
                }
                cnt5++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_INT"

    // $ANTLR start "RULE_STRING"
    public final void mRULE_STRING() throws RecognitionException {
        try {
            int _type = RULE_STRING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalVideoGen.g:1886:13: ( ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' ) )
            // InternalVideoGen.g:1886:15: ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            {
            // InternalVideoGen.g:1886:15: ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0=='\"') ) {
                alt8=1;
            }
            else if ( (LA8_0=='\'') ) {
                alt8=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }
            switch (alt8) {
                case 1 :
                    // InternalVideoGen.g:1886:16: '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"'
                    {
                    match('\"'); 
                    // InternalVideoGen.g:1886:20: ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )*
                    loop6:
                    do {
                        int alt6=3;
                        int LA6_0 = input.LA(1);

                        if ( (LA6_0=='\\') ) {
                            alt6=1;
                        }
                        else if ( ((LA6_0>='\u0000' && LA6_0<='!')||(LA6_0>='#' && LA6_0<='[')||(LA6_0>=']' && LA6_0<='\uFFFF')) ) {
                            alt6=2;
                        }


                        switch (alt6) {
                    	case 1 :
                    	    // InternalVideoGen.g:1886:21: '\\\\' .
                    	    {
                    	    match('\\'); 
                    	    matchAny(); 

                    	    }
                    	    break;
                    	case 2 :
                    	    // InternalVideoGen.g:1886:28: ~ ( ( '\\\\' | '\"' ) )
                    	    {
                    	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='!')||(input.LA(1)>='#' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\uFFFF') ) {
                    	        input.consume();

                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;}


                    	    }
                    	    break;

                    	default :
                    	    break loop6;
                        }
                    } while (true);

                    match('\"'); 

                    }
                    break;
                case 2 :
                    // InternalVideoGen.g:1886:48: '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\''
                    {
                    match('\''); 
                    // InternalVideoGen.g:1886:53: ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )*
                    loop7:
                    do {
                        int alt7=3;
                        int LA7_0 = input.LA(1);

                        if ( (LA7_0=='\\') ) {
                            alt7=1;
                        }
                        else if ( ((LA7_0>='\u0000' && LA7_0<='&')||(LA7_0>='(' && LA7_0<='[')||(LA7_0>=']' && LA7_0<='\uFFFF')) ) {
                            alt7=2;
                        }


                        switch (alt7) {
                    	case 1 :
                    	    // InternalVideoGen.g:1886:54: '\\\\' .
                    	    {
                    	    match('\\'); 
                    	    matchAny(); 

                    	    }
                    	    break;
                    	case 2 :
                    	    // InternalVideoGen.g:1886:61: ~ ( ( '\\\\' | '\\'' ) )
                    	    {
                    	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='&')||(input.LA(1)>='(' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\uFFFF') ) {
                    	        input.consume();

                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;}


                    	    }
                    	    break;

                    	default :
                    	    break loop7;
                        }
                    } while (true);

                    match('\''); 

                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_STRING"

    // $ANTLR start "RULE_ML_COMMENT"
    public final void mRULE_ML_COMMENT() throws RecognitionException {
        try {
            int _type = RULE_ML_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalVideoGen.g:1888:17: ( '/*' ( options {greedy=false; } : . )* '*/' )
            // InternalVideoGen.g:1888:19: '/*' ( options {greedy=false; } : . )* '*/'
            {
            match("/*"); 

            // InternalVideoGen.g:1888:24: ( options {greedy=false; } : . )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0=='*') ) {
                    int LA9_1 = input.LA(2);

                    if ( (LA9_1=='/') ) {
                        alt9=2;
                    }
                    else if ( ((LA9_1>='\u0000' && LA9_1<='.')||(LA9_1>='0' && LA9_1<='\uFFFF')) ) {
                        alt9=1;
                    }


                }
                else if ( ((LA9_0>='\u0000' && LA9_0<=')')||(LA9_0>='+' && LA9_0<='\uFFFF')) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // InternalVideoGen.g:1888:52: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);

            match("*/"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_ML_COMMENT"

    // $ANTLR start "RULE_SL_COMMENT"
    public final void mRULE_SL_COMMENT() throws RecognitionException {
        try {
            int _type = RULE_SL_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalVideoGen.g:1890:17: ( '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )? )
            // InternalVideoGen.g:1890:19: '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )?
            {
            match("//"); 

            // InternalVideoGen.g:1890:24: (~ ( ( '\\n' | '\\r' ) ) )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( ((LA10_0>='\u0000' && LA10_0<='\t')||(LA10_0>='\u000B' && LA10_0<='\f')||(LA10_0>='\u000E' && LA10_0<='\uFFFF')) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // InternalVideoGen.g:1890:24: ~ ( ( '\\n' | '\\r' ) )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='\t')||(input.LA(1)>='\u000B' && input.LA(1)<='\f')||(input.LA(1)>='\u000E' && input.LA(1)<='\uFFFF') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);

            // InternalVideoGen.g:1890:40: ( ( '\\r' )? '\\n' )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0=='\n'||LA12_0=='\r') ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // InternalVideoGen.g:1890:41: ( '\\r' )? '\\n'
                    {
                    // InternalVideoGen.g:1890:41: ( '\\r' )?
                    int alt11=2;
                    int LA11_0 = input.LA(1);

                    if ( (LA11_0=='\r') ) {
                        alt11=1;
                    }
                    switch (alt11) {
                        case 1 :
                            // InternalVideoGen.g:1890:41: '\\r'
                            {
                            match('\r'); 

                            }
                            break;

                    }

                    match('\n'); 

                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_SL_COMMENT"

    // $ANTLR start "RULE_WS"
    public final void mRULE_WS() throws RecognitionException {
        try {
            int _type = RULE_WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalVideoGen.g:1892:9: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
            // InternalVideoGen.g:1892:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            {
            // InternalVideoGen.g:1892:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            int cnt13=0;
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( ((LA13_0>='\t' && LA13_0<='\n')||LA13_0=='\r'||LA13_0==' ') ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // InternalVideoGen.g:
            	    {
            	    if ( (input.LA(1)>='\t' && input.LA(1)<='\n')||input.LA(1)=='\r'||input.LA(1)==' ' ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    if ( cnt13 >= 1 ) break loop13;
                        EarlyExitException eee =
                            new EarlyExitException(13, input);
                        throw eee;
                }
                cnt13++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_WS"

    // $ANTLR start "RULE_ANY_OTHER"
    public final void mRULE_ANY_OTHER() throws RecognitionException {
        try {
            int _type = RULE_ANY_OTHER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalVideoGen.g:1894:16: ( . )
            // InternalVideoGen.g:1894:18: .
            {
            matchAny(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_ANY_OTHER"

    public void mTokens() throws RecognitionException {
        // InternalVideoGen.g:1:8: ( T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | RULE_PERCENTAGE | RULE_FLOAT | RULE_LEFT_BRACKET | RULE_RIGHT_BRACKET | RULE_ID | RULE_INT | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER )
        int alt14=23;
        alt14 = dfa14.predict(input);
        switch (alt14) {
            case 1 :
                // InternalVideoGen.g:1:10: T__15
                {
                mT__15(); 

                }
                break;
            case 2 :
                // InternalVideoGen.g:1:16: T__16
                {
                mT__16(); 

                }
                break;
            case 3 :
                // InternalVideoGen.g:1:22: T__17
                {
                mT__17(); 

                }
                break;
            case 4 :
                // InternalVideoGen.g:1:28: T__18
                {
                mT__18(); 

                }
                break;
            case 5 :
                // InternalVideoGen.g:1:34: T__19
                {
                mT__19(); 

                }
                break;
            case 6 :
                // InternalVideoGen.g:1:40: T__20
                {
                mT__20(); 

                }
                break;
            case 7 :
                // InternalVideoGen.g:1:46: T__21
                {
                mT__21(); 

                }
                break;
            case 8 :
                // InternalVideoGen.g:1:52: T__22
                {
                mT__22(); 

                }
                break;
            case 9 :
                // InternalVideoGen.g:1:58: T__23
                {
                mT__23(); 

                }
                break;
            case 10 :
                // InternalVideoGen.g:1:64: T__24
                {
                mT__24(); 

                }
                break;
            case 11 :
                // InternalVideoGen.g:1:70: T__25
                {
                mT__25(); 

                }
                break;
            case 12 :
                // InternalVideoGen.g:1:76: T__26
                {
                mT__26(); 

                }
                break;
            case 13 :
                // InternalVideoGen.g:1:82: RULE_PERCENTAGE
                {
                mRULE_PERCENTAGE(); 

                }
                break;
            case 14 :
                // InternalVideoGen.g:1:98: RULE_FLOAT
                {
                mRULE_FLOAT(); 

                }
                break;
            case 15 :
                // InternalVideoGen.g:1:109: RULE_LEFT_BRACKET
                {
                mRULE_LEFT_BRACKET(); 

                }
                break;
            case 16 :
                // InternalVideoGen.g:1:127: RULE_RIGHT_BRACKET
                {
                mRULE_RIGHT_BRACKET(); 

                }
                break;
            case 17 :
                // InternalVideoGen.g:1:146: RULE_ID
                {
                mRULE_ID(); 

                }
                break;
            case 18 :
                // InternalVideoGen.g:1:154: RULE_INT
                {
                mRULE_INT(); 

                }
                break;
            case 19 :
                // InternalVideoGen.g:1:163: RULE_STRING
                {
                mRULE_STRING(); 

                }
                break;
            case 20 :
                // InternalVideoGen.g:1:175: RULE_ML_COMMENT
                {
                mRULE_ML_COMMENT(); 

                }
                break;
            case 21 :
                // InternalVideoGen.g:1:191: RULE_SL_COMMENT
                {
                mRULE_SL_COMMENT(); 

                }
                break;
            case 22 :
                // InternalVideoGen.g:1:207: RULE_WS
                {
                mRULE_WS(); 

                }
                break;
            case 23 :
                // InternalVideoGen.g:1:215: RULE_ANY_OTHER
                {
                mRULE_ANY_OTHER(); 

                }
                break;

        }

    }


    protected DFA14 dfa14 = new DFA14(this);
    static final String DFA14_eotS =
        "\1\uffff\1\27\1\25\7\27\2\44\1\47\2\uffff\1\25\1\uffff\3\25\2\uffff\1\27\4\uffff\10\27\1\44\1\uffff\1\44\2\uffff\1\47\6\uffff\11\27\1\44\10\27\1\112\10\27\1\uffff\20\27\1\143\1\27\1\145\1\27\1\147\1\150\2\27\1\uffff\1\153\1\uffff\1\27\2\uffff\2\27\1\uffff\4\27\1\163\1\164\1\165\3\uffff";
    static final String DFA14_eofS =
        "\166\uffff";
    static final String DFA14_minS =
        "\1\0\1\151\2\141\1\160\1\154\1\151\1\145\1\162\1\151\3\56\2\uffff\1\101\1\uffff\2\0\1\52\2\uffff\1\144\4\uffff\1\156\2\164\1\144\1\162\1\163\1\157\1\172\1\56\1\uffff\1\56\2\uffff\1\56\6\uffff\1\145\1\144\1\151\2\145\1\141\1\143\1\142\1\145\1\56\1\157\1\141\1\157\1\162\1\157\1\164\1\162\1\141\1\60\1\107\1\164\2\156\1\163\2\151\1\142\1\uffff\1\145\1\157\2\141\1\145\1\157\1\160\1\151\1\156\1\162\1\154\1\164\1\161\1\156\1\164\1\154\1\60\1\171\1\60\1\151\2\60\2\151\1\uffff\1\60\1\uffff\1\166\2\uffff\1\157\1\164\1\uffff\1\145\1\156\1\171\1\163\3\60\3\uffff";
    static final String DFA14_maxS =
        "\1\uffff\1\151\1\166\1\141\1\160\1\154\1\151\1\165\1\162\1\151\3\71\2\uffff\1\172\1\uffff\2\uffff\1\57\2\uffff\1\144\4\uffff\1\156\2\164\1\144\1\162\1\163\1\157\1\172\1\71\1\uffff\1\71\2\uffff\1\71\6\uffff\1\145\1\144\1\151\2\145\1\141\1\143\1\142\1\145\1\71\1\157\1\141\1\157\1\162\1\157\1\164\1\162\1\141\1\172\1\107\1\164\2\156\1\163\2\151\1\142\1\uffff\1\145\1\157\2\141\1\145\1\157\1\160\1\151\1\156\1\162\1\154\1\164\1\161\1\156\1\164\1\154\1\172\1\171\1\172\1\151\2\172\2\151\1\uffff\1\172\1\uffff\1\166\2\uffff\1\157\1\164\1\uffff\1\145\1\156\1\171\1\163\3\172\3\uffff";
    static final String DFA14_acceptS =
        "\15\uffff\1\17\1\20\1\uffff\1\21\3\uffff\1\26\1\27\1\uffff\1\21\1\2\1\3\1\4\11\uffff\1\15\1\uffff\1\16\1\22\1\uffff\1\17\1\20\1\23\1\24\1\25\1\26\33\uffff\1\13\30\uffff\1\1\1\uffff\1\6\1\uffff\1\10\1\11\2\uffff\1\5\7\uffff\1\14\1\12\1\7";
    static final String DFA14_specialS =
        "\1\1\20\uffff\1\2\1\0\143\uffff}>";
    static final String[] DFA14_transitionS = {
            "\11\25\2\24\2\25\1\24\22\25\1\24\1\25\1\21\4\25\1\22\7\25\1\23\1\14\1\12\10\13\6\25\1\2\25\20\1\1\4\20\3\25\1\17\1\20\1\25\1\5\2\20\1\7\10\20\1\3\1\20\1\4\1\10\2\20\1\11\2\20\1\6\4\20\1\15\1\25\1\16\uff82\25",
            "\1\26",
            "\1\30\1\uffff\1\32\22\uffff\1\31",
            "\1\33",
            "\1\34",
            "\1\35",
            "\1\36",
            "\1\40\17\uffff\1\37",
            "\1\41",
            "\1\42",
            "\1\46\1\uffff\1\43\11\45",
            "\1\46\1\uffff\12\45",
            "\1\46\1\uffff\12\50",
            "",
            "",
            "\32\27\4\uffff\1\27\1\uffff\32\27",
            "",
            "\0\53",
            "\0\53",
            "\1\54\4\uffff\1\55",
            "",
            "",
            "\1\57",
            "",
            "",
            "",
            "",
            "\1\60",
            "\1\61",
            "\1\62",
            "\1\63",
            "\1\64",
            "\1\65",
            "\1\66",
            "\1\67",
            "\1\46\1\uffff\1\70\11\50",
            "",
            "\1\46\1\uffff\12\50",
            "",
            "",
            "\1\46\1\uffff\12\50",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\71",
            "\1\72",
            "\1\73",
            "\1\74",
            "\1\75",
            "\1\76",
            "\1\77",
            "\1\100",
            "\1\101",
            "\1\46\1\uffff\12\50",
            "\1\102",
            "\1\103",
            "\1\104",
            "\1\105",
            "\1\106",
            "\1\107",
            "\1\110",
            "\1\111",
            "\12\27\7\uffff\32\27\4\uffff\1\27\1\uffff\32\27",
            "\1\113",
            "\1\114",
            "\1\115",
            "\1\116",
            "\1\117",
            "\1\120",
            "\1\121",
            "\1\122",
            "",
            "\1\123",
            "\1\124",
            "\1\125",
            "\1\126",
            "\1\127",
            "\1\130",
            "\1\131",
            "\1\132",
            "\1\133",
            "\1\134",
            "\1\135",
            "\1\136",
            "\1\137",
            "\1\140",
            "\1\141",
            "\1\142",
            "\12\27\7\uffff\32\27\4\uffff\1\27\1\uffff\32\27",
            "\1\144",
            "\12\27\7\uffff\32\27\4\uffff\1\27\1\uffff\32\27",
            "\1\146",
            "\12\27\7\uffff\32\27\4\uffff\1\27\1\uffff\32\27",
            "\12\27\7\uffff\32\27\4\uffff\1\27\1\uffff\32\27",
            "\1\151",
            "\1\152",
            "",
            "\12\27\7\uffff\32\27\4\uffff\1\27\1\uffff\32\27",
            "",
            "\1\154",
            "",
            "",
            "\1\155",
            "\1\156",
            "",
            "\1\157",
            "\1\160",
            "\1\161",
            "\1\162",
            "\12\27\7\uffff\32\27\4\uffff\1\27\1\uffff\32\27",
            "\12\27\7\uffff\32\27\4\uffff\1\27\1\uffff\32\27",
            "\12\27\7\uffff\32\27\4\uffff\1\27\1\uffff\32\27",
            "",
            "",
            ""
    };

    static final short[] DFA14_eot = DFA.unpackEncodedString(DFA14_eotS);
    static final short[] DFA14_eof = DFA.unpackEncodedString(DFA14_eofS);
    static final char[] DFA14_min = DFA.unpackEncodedStringToUnsignedChars(DFA14_minS);
    static final char[] DFA14_max = DFA.unpackEncodedStringToUnsignedChars(DFA14_maxS);
    static final short[] DFA14_accept = DFA.unpackEncodedString(DFA14_acceptS);
    static final short[] DFA14_special = DFA.unpackEncodedString(DFA14_specialS);
    static final short[][] DFA14_transition;

    static {
        int numStates = DFA14_transitionS.length;
        DFA14_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA14_transition[i] = DFA.unpackEncodedString(DFA14_transitionS[i]);
        }
    }

    class DFA14 extends DFA {

        public DFA14(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 14;
            this.eot = DFA14_eot;
            this.eof = DFA14_eof;
            this.min = DFA14_min;
            this.max = DFA14_max;
            this.accept = DFA14_accept;
            this.special = DFA14_special;
            this.transition = DFA14_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | RULE_PERCENTAGE | RULE_FLOAT | RULE_LEFT_BRACKET | RULE_RIGHT_BRACKET | RULE_ID | RULE_INT | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA14_18 = input.LA(1);

                        s = -1;
                        if ( ((LA14_18>='\u0000' && LA14_18<='\uFFFF')) ) {s = 43;}

                        else s = 21;

                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA14_0 = input.LA(1);

                        s = -1;
                        if ( (LA14_0=='V') ) {s = 1;}

                        else if ( (LA14_0=='@') ) {s = 2;}

                        else if ( (LA14_0=='m') ) {s = 3;}

                        else if ( (LA14_0=='o') ) {s = 4;}

                        else if ( (LA14_0=='a') ) {s = 5;}

                        else if ( (LA14_0=='v') ) {s = 6;}

                        else if ( (LA14_0=='d') ) {s = 7;}

                        else if ( (LA14_0=='p') ) {s = 8;}

                        else if ( (LA14_0=='s') ) {s = 9;}

                        else if ( (LA14_0=='1') ) {s = 10;}

                        else if ( ((LA14_0>='2' && LA14_0<='9')) ) {s = 11;}

                        else if ( (LA14_0=='0') ) {s = 12;}

                        else if ( (LA14_0=='{') ) {s = 13;}

                        else if ( (LA14_0=='}') ) {s = 14;}

                        else if ( (LA14_0=='^') ) {s = 15;}

                        else if ( ((LA14_0>='A' && LA14_0<='U')||(LA14_0>='W' && LA14_0<='Z')||LA14_0=='_'||(LA14_0>='b' && LA14_0<='c')||(LA14_0>='e' && LA14_0<='l')||LA14_0=='n'||(LA14_0>='q' && LA14_0<='r')||(LA14_0>='t' && LA14_0<='u')||(LA14_0>='w' && LA14_0<='z')) ) {s = 16;}

                        else if ( (LA14_0=='\"') ) {s = 17;}

                        else if ( (LA14_0=='\'') ) {s = 18;}

                        else if ( (LA14_0=='/') ) {s = 19;}

                        else if ( ((LA14_0>='\t' && LA14_0<='\n')||LA14_0=='\r'||LA14_0==' ') ) {s = 20;}

                        else if ( ((LA14_0>='\u0000' && LA14_0<='\b')||(LA14_0>='\u000B' && LA14_0<='\f')||(LA14_0>='\u000E' && LA14_0<='\u001F')||LA14_0=='!'||(LA14_0>='#' && LA14_0<='&')||(LA14_0>='(' && LA14_0<='.')||(LA14_0>=':' && LA14_0<='?')||(LA14_0>='[' && LA14_0<=']')||LA14_0=='`'||LA14_0=='|'||(LA14_0>='~' && LA14_0<='\uFFFF')) ) {s = 21;}

                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA14_17 = input.LA(1);

                        s = -1;
                        if ( ((LA14_17>='\u0000' && LA14_17<='\uFFFF')) ) {s = 43;}

                        else s = 21;

                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 14, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

}