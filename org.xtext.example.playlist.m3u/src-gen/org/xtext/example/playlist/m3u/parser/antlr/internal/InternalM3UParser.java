package org.xtext.example.playlist.m3u.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.xtext.example.playlist.m3u.services.M3UGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalM3UParser extends AbstractInternalAntlrParser {
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

        public InternalM3UParser(TokenStream input, M3UGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }

        @Override
        protected String getFirstRuleName() {
        	return "Model";
       	}

       	@Override
       	protected M3UGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRuleModel"
    // InternalM3U.g:64:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // InternalM3U.g:64:46: (iv_ruleModel= ruleModel EOF )
            // InternalM3U.g:65:2: iv_ruleModel= ruleModel EOF
            {
             newCompositeNode(grammarAccess.getModelRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleModel=ruleModel();

            state._fsp--;

             current =iv_ruleModel; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleModel"


    // $ANTLR start "ruleModel"
    // InternalM3U.g:71:1: ruleModel returns [EObject current=null] : ( (lv_listVideo_0_0= ruleVideo ) )* ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        EObject lv_listVideo_0_0 = null;



        	enterRule();

        try {
            // InternalM3U.g:77:2: ( ( (lv_listVideo_0_0= ruleVideo ) )* )
            // InternalM3U.g:78:2: ( (lv_listVideo_0_0= ruleVideo ) )*
            {
            // InternalM3U.g:78:2: ( (lv_listVideo_0_0= ruleVideo ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==RULE_STRING) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalM3U.g:79:3: (lv_listVideo_0_0= ruleVideo )
            	    {
            	    // InternalM3U.g:79:3: (lv_listVideo_0_0= ruleVideo )
            	    // InternalM3U.g:80:4: lv_listVideo_0_0= ruleVideo
            	    {

            	    				newCompositeNode(grammarAccess.getModelAccess().getListVideoVideoParserRuleCall_0());
            	    			
            	    pushFollow(FOLLOW_3);
            	    lv_listVideo_0_0=ruleVideo();

            	    state._fsp--;


            	    				if (current==null) {
            	    					current = createModelElementForParent(grammarAccess.getModelRule());
            	    				}
            	    				add(
            	    					current,
            	    					"listVideo",
            	    					lv_listVideo_0_0,
            	    					"org.xtext.example.playlist.m3u.M3U.Video");
            	    				afterParserOrEnumRuleCall();
            	    			

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleModel"


    // $ANTLR start "entryRuleVideo"
    // InternalM3U.g:100:1: entryRuleVideo returns [EObject current=null] : iv_ruleVideo= ruleVideo EOF ;
    public final EObject entryRuleVideo() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVideo = null;


        try {
            // InternalM3U.g:100:46: (iv_ruleVideo= ruleVideo EOF )
            // InternalM3U.g:101:2: iv_ruleVideo= ruleVideo EOF
            {
             newCompositeNode(grammarAccess.getVideoRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleVideo=ruleVideo();

            state._fsp--;

             current =iv_ruleVideo; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleVideo"


    // $ANTLR start "ruleVideo"
    // InternalM3U.g:107:1: ruleVideo returns [EObject current=null] : ( (lv_location_0_0= RULE_STRING ) ) ;
    public final EObject ruleVideo() throws RecognitionException {
        EObject current = null;

        Token lv_location_0_0=null;


        	enterRule();

        try {
            // InternalM3U.g:113:2: ( ( (lv_location_0_0= RULE_STRING ) ) )
            // InternalM3U.g:114:2: ( (lv_location_0_0= RULE_STRING ) )
            {
            // InternalM3U.g:114:2: ( (lv_location_0_0= RULE_STRING ) )
            // InternalM3U.g:115:3: (lv_location_0_0= RULE_STRING )
            {
            // InternalM3U.g:115:3: (lv_location_0_0= RULE_STRING )
            // InternalM3U.g:116:4: lv_location_0_0= RULE_STRING
            {
            lv_location_0_0=(Token)match(input,RULE_STRING,FOLLOW_2); 

            				newLeafNode(lv_location_0_0, grammarAccess.getVideoAccess().getLocationSTRINGTerminalRuleCall_0());
            			

            				if (current==null) {
            					current = createModelElement(grammarAccess.getVideoRule());
            				}
            				setWithLastConsumed(
            					current,
            					"location",
            					lv_location_0_0,
            					"org.eclipse.xtext.common.Terminals.STRING");
            			

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleVideo"

    // Delegated rules


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000012L});

}