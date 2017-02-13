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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_LEFT_BRACKET", "RULE_RIGHT_BRACKET", "RULE_STRING", "RULE_FLOAT", "RULE_INT", "RULE_ID", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'Playlist'", "'mediafile'", "'id:'", "'path:'", "'duration:'"
    };
    public static final int RULE_ID=9;
    public static final int RULE_WS=12;
    public static final int RULE_STRING=6;
    public static final int RULE_LEFT_BRACKET=4;
    public static final int RULE_ANY_OTHER=13;
    public static final int RULE_SL_COMMENT=11;
    public static final int T__15=15;
    public static final int RULE_RIGHT_BRACKET=5;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int RULE_INT=8;
    public static final int T__18=18;
    public static final int RULE_ML_COMMENT=10;
    public static final int RULE_FLOAT=7;
    public static final int T__14=14;
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
        	return "PlaylistGeneratorModel";
       	}

       	@Override
       	protected PlaylistGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRulePlaylistGeneratorModel"
    // InternalPlaylist.g:64:1: entryRulePlaylistGeneratorModel returns [EObject current=null] : iv_rulePlaylistGeneratorModel= rulePlaylistGeneratorModel EOF ;
    public final EObject entryRulePlaylistGeneratorModel() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePlaylistGeneratorModel = null;


        try {
            // InternalPlaylist.g:64:63: (iv_rulePlaylistGeneratorModel= rulePlaylistGeneratorModel EOF )
            // InternalPlaylist.g:65:2: iv_rulePlaylistGeneratorModel= rulePlaylistGeneratorModel EOF
            {
             newCompositeNode(grammarAccess.getPlaylistGeneratorModelRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePlaylistGeneratorModel=rulePlaylistGeneratorModel();

            state._fsp--;

             current =iv_rulePlaylistGeneratorModel; 
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
    // $ANTLR end "entryRulePlaylistGeneratorModel"


    // $ANTLR start "rulePlaylistGeneratorModel"
    // InternalPlaylist.g:71:1: rulePlaylistGeneratorModel returns [EObject current=null] : ( () otherlv_1= 'Playlist' this_LEFT_BRACKET_2= RULE_LEFT_BRACKET ( (lv_mediafiles_3_0= ruleMediafile ) )+ this_RIGHT_BRACKET_4= RULE_RIGHT_BRACKET ) ;
    public final EObject rulePlaylistGeneratorModel() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token this_LEFT_BRACKET_2=null;
        Token this_RIGHT_BRACKET_4=null;
        EObject lv_mediafiles_3_0 = null;



        	enterRule();

        try {
            // InternalPlaylist.g:77:2: ( ( () otherlv_1= 'Playlist' this_LEFT_BRACKET_2= RULE_LEFT_BRACKET ( (lv_mediafiles_3_0= ruleMediafile ) )+ this_RIGHT_BRACKET_4= RULE_RIGHT_BRACKET ) )
            // InternalPlaylist.g:78:2: ( () otherlv_1= 'Playlist' this_LEFT_BRACKET_2= RULE_LEFT_BRACKET ( (lv_mediafiles_3_0= ruleMediafile ) )+ this_RIGHT_BRACKET_4= RULE_RIGHT_BRACKET )
            {
            // InternalPlaylist.g:78:2: ( () otherlv_1= 'Playlist' this_LEFT_BRACKET_2= RULE_LEFT_BRACKET ( (lv_mediafiles_3_0= ruleMediafile ) )+ this_RIGHT_BRACKET_4= RULE_RIGHT_BRACKET )
            // InternalPlaylist.g:79:3: () otherlv_1= 'Playlist' this_LEFT_BRACKET_2= RULE_LEFT_BRACKET ( (lv_mediafiles_3_0= ruleMediafile ) )+ this_RIGHT_BRACKET_4= RULE_RIGHT_BRACKET
            {
            // InternalPlaylist.g:79:3: ()
            // InternalPlaylist.g:80:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getPlaylistGeneratorModelAccess().getPlaylistGeneratorModelAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,14,FOLLOW_3); 

            			newLeafNode(otherlv_1, grammarAccess.getPlaylistGeneratorModelAccess().getPlaylistKeyword_1());
            		
            this_LEFT_BRACKET_2=(Token)match(input,RULE_LEFT_BRACKET,FOLLOW_4); 

            			newLeafNode(this_LEFT_BRACKET_2, grammarAccess.getPlaylistGeneratorModelAccess().getLEFT_BRACKETTerminalRuleCall_2());
            		
            // InternalPlaylist.g:94:3: ( (lv_mediafiles_3_0= ruleMediafile ) )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==15) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalPlaylist.g:95:4: (lv_mediafiles_3_0= ruleMediafile )
            	    {
            	    // InternalPlaylist.g:95:4: (lv_mediafiles_3_0= ruleMediafile )
            	    // InternalPlaylist.g:96:5: lv_mediafiles_3_0= ruleMediafile
            	    {

            	    					newCompositeNode(grammarAccess.getPlaylistGeneratorModelAccess().getMediafilesMediafileParserRuleCall_3_0());
            	    				
            	    pushFollow(FOLLOW_5);
            	    lv_mediafiles_3_0=ruleMediafile();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getPlaylistGeneratorModelRule());
            	    					}
            	    					add(
            	    						current,
            	    						"mediafiles",
            	    						lv_mediafiles_3_0,
            	    						"org.xtext.example.mydsl.Playlist.Mediafile");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt1 >= 1 ) break loop1;
                        EarlyExitException eee =
                            new EarlyExitException(1, input);
                        throw eee;
                }
                cnt1++;
            } while (true);

            this_RIGHT_BRACKET_4=(Token)match(input,RULE_RIGHT_BRACKET,FOLLOW_2); 

            			newLeafNode(this_RIGHT_BRACKET_4, grammarAccess.getPlaylistGeneratorModelAccess().getRIGHT_BRACKETTerminalRuleCall_4());
            		

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
    // $ANTLR end "rulePlaylistGeneratorModel"


    // $ANTLR start "entryRuleMediafile"
    // InternalPlaylist.g:121:1: entryRuleMediafile returns [EObject current=null] : iv_ruleMediafile= ruleMediafile EOF ;
    public final EObject entryRuleMediafile() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMediafile = null;


        try {
            // InternalPlaylist.g:121:50: (iv_ruleMediafile= ruleMediafile EOF )
            // InternalPlaylist.g:122:2: iv_ruleMediafile= ruleMediafile EOF
            {
             newCompositeNode(grammarAccess.getMediafileRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleMediafile=ruleMediafile();

            state._fsp--;

             current =iv_ruleMediafile; 
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
    // $ANTLR end "entryRuleMediafile"


    // $ANTLR start "ruleMediafile"
    // InternalPlaylist.g:128:1: ruleMediafile returns [EObject current=null] : (otherlv_0= 'mediafile' this_LEFT_BRACKET_1= RULE_LEFT_BRACKET otherlv_2= 'id:' ( (lv_id_3_0= RULE_STRING ) ) otherlv_4= 'path:' ( (lv_location_5_0= RULE_STRING ) ) otherlv_6= 'duration:' ( (lv_duration_7_0= RULE_FLOAT ) ) this_RIGHT_BRACKET_8= RULE_RIGHT_BRACKET ) ;
    public final EObject ruleMediafile() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token this_LEFT_BRACKET_1=null;
        Token otherlv_2=null;
        Token lv_id_3_0=null;
        Token otherlv_4=null;
        Token lv_location_5_0=null;
        Token otherlv_6=null;
        Token lv_duration_7_0=null;
        Token this_RIGHT_BRACKET_8=null;


        	enterRule();

        try {
            // InternalPlaylist.g:134:2: ( (otherlv_0= 'mediafile' this_LEFT_BRACKET_1= RULE_LEFT_BRACKET otherlv_2= 'id:' ( (lv_id_3_0= RULE_STRING ) ) otherlv_4= 'path:' ( (lv_location_5_0= RULE_STRING ) ) otherlv_6= 'duration:' ( (lv_duration_7_0= RULE_FLOAT ) ) this_RIGHT_BRACKET_8= RULE_RIGHT_BRACKET ) )
            // InternalPlaylist.g:135:2: (otherlv_0= 'mediafile' this_LEFT_BRACKET_1= RULE_LEFT_BRACKET otherlv_2= 'id:' ( (lv_id_3_0= RULE_STRING ) ) otherlv_4= 'path:' ( (lv_location_5_0= RULE_STRING ) ) otherlv_6= 'duration:' ( (lv_duration_7_0= RULE_FLOAT ) ) this_RIGHT_BRACKET_8= RULE_RIGHT_BRACKET )
            {
            // InternalPlaylist.g:135:2: (otherlv_0= 'mediafile' this_LEFT_BRACKET_1= RULE_LEFT_BRACKET otherlv_2= 'id:' ( (lv_id_3_0= RULE_STRING ) ) otherlv_4= 'path:' ( (lv_location_5_0= RULE_STRING ) ) otherlv_6= 'duration:' ( (lv_duration_7_0= RULE_FLOAT ) ) this_RIGHT_BRACKET_8= RULE_RIGHT_BRACKET )
            // InternalPlaylist.g:136:3: otherlv_0= 'mediafile' this_LEFT_BRACKET_1= RULE_LEFT_BRACKET otherlv_2= 'id:' ( (lv_id_3_0= RULE_STRING ) ) otherlv_4= 'path:' ( (lv_location_5_0= RULE_STRING ) ) otherlv_6= 'duration:' ( (lv_duration_7_0= RULE_FLOAT ) ) this_RIGHT_BRACKET_8= RULE_RIGHT_BRACKET
            {
            otherlv_0=(Token)match(input,15,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getMediafileAccess().getMediafileKeyword_0());
            		
            this_LEFT_BRACKET_1=(Token)match(input,RULE_LEFT_BRACKET,FOLLOW_6); 

            			newLeafNode(this_LEFT_BRACKET_1, grammarAccess.getMediafileAccess().getLEFT_BRACKETTerminalRuleCall_1());
            		
            otherlv_2=(Token)match(input,16,FOLLOW_7); 

            			newLeafNode(otherlv_2, grammarAccess.getMediafileAccess().getIdKeyword_2());
            		
            // InternalPlaylist.g:148:3: ( (lv_id_3_0= RULE_STRING ) )
            // InternalPlaylist.g:149:4: (lv_id_3_0= RULE_STRING )
            {
            // InternalPlaylist.g:149:4: (lv_id_3_0= RULE_STRING )
            // InternalPlaylist.g:150:5: lv_id_3_0= RULE_STRING
            {
            lv_id_3_0=(Token)match(input,RULE_STRING,FOLLOW_8); 

            					newLeafNode(lv_id_3_0, grammarAccess.getMediafileAccess().getIdSTRINGTerminalRuleCall_3_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getMediafileRule());
            					}
            					setWithLastConsumed(
            						current,
            						"id",
            						lv_id_3_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            otherlv_4=(Token)match(input,17,FOLLOW_7); 

            			newLeafNode(otherlv_4, grammarAccess.getMediafileAccess().getPathKeyword_4());
            		
            // InternalPlaylist.g:170:3: ( (lv_location_5_0= RULE_STRING ) )
            // InternalPlaylist.g:171:4: (lv_location_5_0= RULE_STRING )
            {
            // InternalPlaylist.g:171:4: (lv_location_5_0= RULE_STRING )
            // InternalPlaylist.g:172:5: lv_location_5_0= RULE_STRING
            {
            lv_location_5_0=(Token)match(input,RULE_STRING,FOLLOW_9); 

            					newLeafNode(lv_location_5_0, grammarAccess.getMediafileAccess().getLocationSTRINGTerminalRuleCall_5_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getMediafileRule());
            					}
            					setWithLastConsumed(
            						current,
            						"location",
            						lv_location_5_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            otherlv_6=(Token)match(input,18,FOLLOW_10); 

            			newLeafNode(otherlv_6, grammarAccess.getMediafileAccess().getDurationKeyword_6());
            		
            // InternalPlaylist.g:192:3: ( (lv_duration_7_0= RULE_FLOAT ) )
            // InternalPlaylist.g:193:4: (lv_duration_7_0= RULE_FLOAT )
            {
            // InternalPlaylist.g:193:4: (lv_duration_7_0= RULE_FLOAT )
            // InternalPlaylist.g:194:5: lv_duration_7_0= RULE_FLOAT
            {
            lv_duration_7_0=(Token)match(input,RULE_FLOAT,FOLLOW_11); 

            					newLeafNode(lv_duration_7_0, grammarAccess.getMediafileAccess().getDurationFLOATTerminalRuleCall_7_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getMediafileRule());
            					}
            					setWithLastConsumed(
            						current,
            						"duration",
            						lv_duration_7_0,
            						"org.xtext.example.mydsl.Playlist.FLOAT");
            				

            }


            }

            this_RIGHT_BRACKET_8=(Token)match(input,RULE_RIGHT_BRACKET,FOLLOW_2); 

            			newLeafNode(this_RIGHT_BRACKET_8, grammarAccess.getMediafileAccess().getRIGHT_BRACKETTerminalRuleCall_8());
            		

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
    // $ANTLR end "ruleMediafile"

    // Delegated rules


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000008020L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000000020L});

}