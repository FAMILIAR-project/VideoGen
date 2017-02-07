package org.xtext.example.playlist.m3u.ide.contentassist.antlr.internal;

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.DFA;
import org.xtext.example.playlist.m3u.services.M3UGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalM3UParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_ID", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER"
    };
    public static final int RULE_ID=5;
    public static final int RULE_WS=9;
    public static final int RULE_STRING=4;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_SL_COMMENT=8;
    public static final int RULE_INT=6;
    public static final int RULE_ML_COMMENT=7;
    public static final int EOF=-1;

    // delegates
    // delegators


        public InternalM3UParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalM3UParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalM3UParser.tokenNames; }
    public String getGrammarFileName() { return "InternalM3U.g"; }


    	private M3UGrammarAccess grammarAccess;

    	public void setGrammarAccess(M3UGrammarAccess grammarAccess) {
    		this.grammarAccess = grammarAccess;
    	}

    	@Override
    	protected Grammar getGrammar() {
    		return grammarAccess.getGrammar();
    	}

    	@Override
    	protected String getValueForTokenName(String tokenName) {
    		return tokenName;
    	}



    // $ANTLR start "entryRuleModel"
    // InternalM3U.g:53:1: entryRuleModel : ruleModel EOF ;
    public final void entryRuleModel() throws RecognitionException {
        try {
            // InternalM3U.g:54:1: ( ruleModel EOF )
            // InternalM3U.g:55:1: ruleModel EOF
            {
             before(grammarAccess.getModelRule()); 
            pushFollow(FOLLOW_1);
            ruleModel();

            state._fsp--;

             after(grammarAccess.getModelRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleModel"


    // $ANTLR start "ruleModel"
    // InternalM3U.g:62:1: ruleModel : ( ( rule__Model__ListVideoAssignment )* ) ;
    public final void ruleModel() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalM3U.g:66:2: ( ( ( rule__Model__ListVideoAssignment )* ) )
            // InternalM3U.g:67:2: ( ( rule__Model__ListVideoAssignment )* )
            {
            // InternalM3U.g:67:2: ( ( rule__Model__ListVideoAssignment )* )
            // InternalM3U.g:68:3: ( rule__Model__ListVideoAssignment )*
            {
             before(grammarAccess.getModelAccess().getListVideoAssignment()); 
            // InternalM3U.g:69:3: ( rule__Model__ListVideoAssignment )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==RULE_STRING) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalM3U.g:69:4: rule__Model__ListVideoAssignment
            	    {
            	    pushFollow(FOLLOW_3);
            	    rule__Model__ListVideoAssignment();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

             after(grammarAccess.getModelAccess().getListVideoAssignment()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleModel"


    // $ANTLR start "entryRuleVideo"
    // InternalM3U.g:78:1: entryRuleVideo : ruleVideo EOF ;
    public final void entryRuleVideo() throws RecognitionException {
        try {
            // InternalM3U.g:79:1: ( ruleVideo EOF )
            // InternalM3U.g:80:1: ruleVideo EOF
            {
             before(grammarAccess.getVideoRule()); 
            pushFollow(FOLLOW_1);
            ruleVideo();

            state._fsp--;

             after(grammarAccess.getVideoRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleVideo"


    // $ANTLR start "ruleVideo"
    // InternalM3U.g:87:1: ruleVideo : ( ( rule__Video__LocationAssignment ) ) ;
    public final void ruleVideo() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalM3U.g:91:2: ( ( ( rule__Video__LocationAssignment ) ) )
            // InternalM3U.g:92:2: ( ( rule__Video__LocationAssignment ) )
            {
            // InternalM3U.g:92:2: ( ( rule__Video__LocationAssignment ) )
            // InternalM3U.g:93:3: ( rule__Video__LocationAssignment )
            {
             before(grammarAccess.getVideoAccess().getLocationAssignment()); 
            // InternalM3U.g:94:3: ( rule__Video__LocationAssignment )
            // InternalM3U.g:94:4: rule__Video__LocationAssignment
            {
            pushFollow(FOLLOW_2);
            rule__Video__LocationAssignment();

            state._fsp--;


            }

             after(grammarAccess.getVideoAccess().getLocationAssignment()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleVideo"


    // $ANTLR start "rule__Model__ListVideoAssignment"
    // InternalM3U.g:102:1: rule__Model__ListVideoAssignment : ( ruleVideo ) ;
    public final void rule__Model__ListVideoAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalM3U.g:106:1: ( ( ruleVideo ) )
            // InternalM3U.g:107:2: ( ruleVideo )
            {
            // InternalM3U.g:107:2: ( ruleVideo )
            // InternalM3U.g:108:3: ruleVideo
            {
             before(grammarAccess.getModelAccess().getListVideoVideoParserRuleCall_0()); 
            pushFollow(FOLLOW_2);
            ruleVideo();

            state._fsp--;

             after(grammarAccess.getModelAccess().getListVideoVideoParserRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__ListVideoAssignment"


    // $ANTLR start "rule__Video__LocationAssignment"
    // InternalM3U.g:117:1: rule__Video__LocationAssignment : ( RULE_STRING ) ;
    public final void rule__Video__LocationAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalM3U.g:121:1: ( ( RULE_STRING ) )
            // InternalM3U.g:122:2: ( RULE_STRING )
            {
            // InternalM3U.g:122:2: ( RULE_STRING )
            // InternalM3U.g:123:3: RULE_STRING
            {
             before(grammarAccess.getVideoAccess().getLocationSTRINGTerminalRuleCall_0()); 
            match(input,RULE_STRING,FOLLOW_2); 
             after(grammarAccess.getVideoAccess().getLocationSTRINGTerminalRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Video__LocationAssignment"

    // Delegated rules


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000012L});

}