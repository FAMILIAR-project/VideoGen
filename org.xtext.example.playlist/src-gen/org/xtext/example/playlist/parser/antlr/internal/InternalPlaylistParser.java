package org.xtext.example.playlist.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.xtext.example.playlist.services.PlaylistGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalPlaylistParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_ID", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'file'"
    };
    public static final int RULE_ID=5;
    public static final int RULE_WS=9;
    public static final int RULE_STRING=4;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_SL_COMMENT=8;
    public static final int RULE_INT=6;
    public static final int T__11=11;
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
    // InternalPlaylist.g:71:1: rulePlaylist returns [EObject current=null] : ( (lv_videos_0_0= ruleVideo ) )* ;
    public final EObject rulePlaylist() throws RecognitionException {
        EObject current = null;

        EObject lv_videos_0_0 = null;



        	enterRule();

        try {
            // InternalPlaylist.g:77:2: ( ( (lv_videos_0_0= ruleVideo ) )* )
            // InternalPlaylist.g:78:2: ( (lv_videos_0_0= ruleVideo ) )*
            {
            // InternalPlaylist.g:78:2: ( (lv_videos_0_0= ruleVideo ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==11) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalPlaylist.g:79:3: (lv_videos_0_0= ruleVideo )
            	    {
            	    // InternalPlaylist.g:79:3: (lv_videos_0_0= ruleVideo )
            	    // InternalPlaylist.g:80:4: lv_videos_0_0= ruleVideo
            	    {

            	    				newCompositeNode(grammarAccess.getPlaylistAccess().getVideosVideoParserRuleCall_0());
            	    			
            	    pushFollow(FOLLOW_3);
            	    lv_videos_0_0=ruleVideo();

            	    state._fsp--;


            	    				if (current==null) {
            	    					current = createModelElementForParent(grammarAccess.getPlaylistRule());
            	    				}
            	    				add(
            	    					current,
            	    					"videos",
            	    					lv_videos_0_0,
            	    					"org.xtext.example.playlist.Playlist.Video");
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


    // $ANTLR start "entryRuleVideo"
    // InternalPlaylist.g:100:1: entryRuleVideo returns [EObject current=null] : iv_ruleVideo= ruleVideo EOF ;
    public final EObject entryRuleVideo() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVideo = null;


        try {
            // InternalPlaylist.g:100:46: (iv_ruleVideo= ruleVideo EOF )
            // InternalPlaylist.g:101:2: iv_ruleVideo= ruleVideo EOF
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
    // InternalPlaylist.g:107:1: ruleVideo returns [EObject current=null] : (otherlv_0= 'file' ( (lv_location_1_0= RULE_STRING ) ) ) ;
    public final EObject ruleVideo() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_location_1_0=null;


        	enterRule();

        try {
            // InternalPlaylist.g:113:2: ( (otherlv_0= 'file' ( (lv_location_1_0= RULE_STRING ) ) ) )
            // InternalPlaylist.g:114:2: (otherlv_0= 'file' ( (lv_location_1_0= RULE_STRING ) ) )
            {
            // InternalPlaylist.g:114:2: (otherlv_0= 'file' ( (lv_location_1_0= RULE_STRING ) ) )
            // InternalPlaylist.g:115:3: otherlv_0= 'file' ( (lv_location_1_0= RULE_STRING ) )
            {
            otherlv_0=(Token)match(input,11,FOLLOW_4); 

            			newLeafNode(otherlv_0, grammarAccess.getVideoAccess().getFileKeyword_0());
            		
            // InternalPlaylist.g:119:3: ( (lv_location_1_0= RULE_STRING ) )
            // InternalPlaylist.g:120:4: (lv_location_1_0= RULE_STRING )
            {
            // InternalPlaylist.g:120:4: (lv_location_1_0= RULE_STRING )
            // InternalPlaylist.g:121:5: lv_location_1_0= RULE_STRING
            {
            lv_location_1_0=(Token)match(input,RULE_STRING,FOLLOW_2); 

            					newLeafNode(lv_location_1_0, grammarAccess.getVideoAccess().getLocationSTRINGTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getVideoRule());
            					}
            					setWithLastConsumed(
            						current,
            						"location",
            						lv_location_1_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

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
    // $ANTLR end "ruleVideo"

    // Delegated rules


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000802L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000010L});

}