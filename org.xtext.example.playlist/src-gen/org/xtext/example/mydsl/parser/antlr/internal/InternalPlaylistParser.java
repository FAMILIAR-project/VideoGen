package org.xtext.example.mydsl.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.xtext.example.mydsl.services.PlaylistGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalPlaylistParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_INT", "RULE_ID", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER"
    };
    public static final int RULE_ID=6;
    public static final int RULE_WS=9;
    public static final int RULE_STRING=4;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_SL_COMMENT=8;
    public static final int RULE_INT=5;
    public static final int RULE_ML_COMMENT=7;
    public static final int EOF=-1;

    // delegates
    // delegators


        public InternalPlaylistParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalPlaylistParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalPlaylistParser.tokenNames; }
    public String getGrammarFileName() { return "InternalPlaylist.g"; }



     	private PlaylistGrammarAccess grammarAccess;

        public InternalPlaylistParser(TokenStream input, PlaylistGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }

        @Override
        protected String getFirstRuleName() {
        	return "Playlist";
       	}

       	@Override
       	protected PlaylistGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRulePlaylist"
    // InternalPlaylist.g:64:1: entryRulePlaylist returns [EObject current=null] : iv_rulePlaylist= rulePlaylist EOF ;
    public final EObject entryRulePlaylist() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePlaylist = null;


        try {
            // InternalPlaylist.g:64:49: (iv_rulePlaylist= rulePlaylist EOF )
            // InternalPlaylist.g:65:2: iv_rulePlaylist= rulePlaylist EOF
            {
             newCompositeNode(grammarAccess.getPlaylistRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePlaylist=rulePlaylist();

            state._fsp--;

             current =iv_rulePlaylist; 
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
    // $ANTLR end "entryRulePlaylist"


    // $ANTLR start "rulePlaylist"
    // InternalPlaylist.g:71:1: rulePlaylist returns [EObject current=null] : ( (lv_vids_0_0= ruleMediaFile ) )* ;
    public final EObject rulePlaylist() throws RecognitionException {
        EObject current = null;

        EObject lv_vids_0_0 = null;



        	enterRule();

        try {
            // InternalPlaylist.g:77:2: ( ( (lv_vids_0_0= ruleMediaFile ) )* )
            // InternalPlaylist.g:78:2: ( (lv_vids_0_0= ruleMediaFile ) )*
            {
            // InternalPlaylist.g:78:2: ( (lv_vids_0_0= ruleMediaFile ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==RULE_STRING) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalPlaylist.g:79:3: (lv_vids_0_0= ruleMediaFile )
            	    {
            	    // InternalPlaylist.g:79:3: (lv_vids_0_0= ruleMediaFile )
            	    // InternalPlaylist.g:80:4: lv_vids_0_0= ruleMediaFile
            	    {

            	    				newCompositeNode(grammarAccess.getPlaylistAccess().getVidsMediaFileParserRuleCall_0());
            	    			
            	    pushFollow(FOLLOW_3);
            	    lv_vids_0_0=ruleMediaFile();

            	    state._fsp--;


            	    				if (current==null) {
            	    					current = createModelElementForParent(grammarAccess.getPlaylistRule());
            	    				}
            	    				add(
            	    					current,
            	    					"vids",
            	    					lv_vids_0_0,
            	    					"org.xtext.example.mydsl.Playlist.MediaFile");
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
    // $ANTLR end "rulePlaylist"


    // $ANTLR start "entryRuleMediaFile"
    // InternalPlaylist.g:100:1: entryRuleMediaFile returns [EObject current=null] : iv_ruleMediaFile= ruleMediaFile EOF ;
    public final EObject entryRuleMediaFile() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMediaFile = null;


        try {
            // InternalPlaylist.g:100:50: (iv_ruleMediaFile= ruleMediaFile EOF )
            // InternalPlaylist.g:101:2: iv_ruleMediaFile= ruleMediaFile EOF
            {
             newCompositeNode(grammarAccess.getMediaFileRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleMediaFile=ruleMediaFile();

            state._fsp--;

             current =iv_ruleMediaFile; 
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
    // $ANTLR end "entryRuleMediaFile"


    // $ANTLR start "ruleMediaFile"
    // InternalPlaylist.g:107:1: ruleMediaFile returns [EObject current=null] : ( ( (lv_location_0_0= RULE_STRING ) ) ( (lv_duration_1_0= RULE_INT ) ) ) ;
    public final EObject ruleMediaFile() throws RecognitionException {
        EObject current = null;

        Token lv_location_0_0=null;
        Token lv_duration_1_0=null;


        	enterRule();

        try {
            // InternalPlaylist.g:113:2: ( ( ( (lv_location_0_0= RULE_STRING ) ) ( (lv_duration_1_0= RULE_INT ) ) ) )
            // InternalPlaylist.g:114:2: ( ( (lv_location_0_0= RULE_STRING ) ) ( (lv_duration_1_0= RULE_INT ) ) )
            {
            // InternalPlaylist.g:114:2: ( ( (lv_location_0_0= RULE_STRING ) ) ( (lv_duration_1_0= RULE_INT ) ) )
            // InternalPlaylist.g:115:3: ( (lv_location_0_0= RULE_STRING ) ) ( (lv_duration_1_0= RULE_INT ) )
            {
            // InternalPlaylist.g:115:3: ( (lv_location_0_0= RULE_STRING ) )
            // InternalPlaylist.g:116:4: (lv_location_0_0= RULE_STRING )
            {
            // InternalPlaylist.g:116:4: (lv_location_0_0= RULE_STRING )
            // InternalPlaylist.g:117:5: lv_location_0_0= RULE_STRING
            {
            lv_location_0_0=(Token)match(input,RULE_STRING,FOLLOW_4); 

            					newLeafNode(lv_location_0_0, grammarAccess.getMediaFileAccess().getLocationSTRINGTerminalRuleCall_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getMediaFileRule());
            					}
            					setWithLastConsumed(
            						current,
            						"location",
            						lv_location_0_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            // InternalPlaylist.g:133:3: ( (lv_duration_1_0= RULE_INT ) )
            // InternalPlaylist.g:134:4: (lv_duration_1_0= RULE_INT )
            {
            // InternalPlaylist.g:134:4: (lv_duration_1_0= RULE_INT )
            // InternalPlaylist.g:135:5: lv_duration_1_0= RULE_INT
            {
            lv_duration_1_0=(Token)match(input,RULE_INT,FOLLOW_2); 

            					newLeafNode(lv_duration_1_0, grammarAccess.getMediaFileAccess().getDurationINTTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getMediaFileRule());
            					}
            					setWithLastConsumed(
            						current,
            						"duration",
            						lv_duration_1_0,
            						"org.eclipse.xtext.common.Terminals.INT");
            				

            }


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
    // $ANTLR end "ruleMediaFile"

    // Delegated rules


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000020L});

}