package org.xtext.example.mydsl.ide.contentassist.antlr.internal;

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
import org.xtext.example.mydsl.services.PlaylistGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalPlaylistParser extends AbstractInternalContentAssistParser {
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


        public InternalPlaylistParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalPlaylistParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalPlaylistParser.tokenNames; }
    public String getGrammarFileName() { return "InternalPlaylist.g"; }


    	private PlaylistGrammarAccess grammarAccess;

    	public void setGrammarAccess(PlaylistGrammarAccess grammarAccess) {
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



    // $ANTLR start "entryRulePlaylist"
    // InternalPlaylist.g:53:1: entryRulePlaylist : rulePlaylist EOF ;
    public final void entryRulePlaylist() throws RecognitionException {
        try {
            // InternalPlaylist.g:54:1: ( rulePlaylist EOF )
            // InternalPlaylist.g:55:1: rulePlaylist EOF
            {
             before(grammarAccess.getPlaylistRule()); 
            pushFollow(FOLLOW_1);
            rulePlaylist();

            state._fsp--;

             after(grammarAccess.getPlaylistRule()); 
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
    // $ANTLR end "entryRulePlaylist"


    // $ANTLR start "rulePlaylist"
    // InternalPlaylist.g:62:1: rulePlaylist : ( ( rule__Playlist__VidsAssignment )* ) ;
    public final void rulePlaylist() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPlaylist.g:66:2: ( ( ( rule__Playlist__VidsAssignment )* ) )
            // InternalPlaylist.g:67:2: ( ( rule__Playlist__VidsAssignment )* )
            {
            // InternalPlaylist.g:67:2: ( ( rule__Playlist__VidsAssignment )* )
            // InternalPlaylist.g:68:3: ( rule__Playlist__VidsAssignment )*
            {
             before(grammarAccess.getPlaylistAccess().getVidsAssignment()); 
            // InternalPlaylist.g:69:3: ( rule__Playlist__VidsAssignment )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==RULE_STRING) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalPlaylist.g:69:4: rule__Playlist__VidsAssignment
            	    {
            	    pushFollow(FOLLOW_3);
            	    rule__Playlist__VidsAssignment();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

             after(grammarAccess.getPlaylistAccess().getVidsAssignment()); 

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
    // $ANTLR end "rulePlaylist"


    // $ANTLR start "entryRuleMediaFile"
    // InternalPlaylist.g:78:1: entryRuleMediaFile : ruleMediaFile EOF ;
    public final void entryRuleMediaFile() throws RecognitionException {
        try {
            // InternalPlaylist.g:79:1: ( ruleMediaFile EOF )
            // InternalPlaylist.g:80:1: ruleMediaFile EOF
            {
             before(grammarAccess.getMediaFileRule()); 
            pushFollow(FOLLOW_1);
            ruleMediaFile();

            state._fsp--;

             after(grammarAccess.getMediaFileRule()); 
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
    // $ANTLR end "entryRuleMediaFile"


    // $ANTLR start "ruleMediaFile"
    // InternalPlaylist.g:87:1: ruleMediaFile : ( ( rule__MediaFile__LocationAssignment ) ) ;
    public final void ruleMediaFile() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPlaylist.g:91:2: ( ( ( rule__MediaFile__LocationAssignment ) ) )
            // InternalPlaylist.g:92:2: ( ( rule__MediaFile__LocationAssignment ) )
            {
            // InternalPlaylist.g:92:2: ( ( rule__MediaFile__LocationAssignment ) )
            // InternalPlaylist.g:93:3: ( rule__MediaFile__LocationAssignment )
            {
             before(grammarAccess.getMediaFileAccess().getLocationAssignment()); 
            // InternalPlaylist.g:94:3: ( rule__MediaFile__LocationAssignment )
            // InternalPlaylist.g:94:4: rule__MediaFile__LocationAssignment
            {
            pushFollow(FOLLOW_2);
            rule__MediaFile__LocationAssignment();

            state._fsp--;


            }

             after(grammarAccess.getMediaFileAccess().getLocationAssignment()); 

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
    // $ANTLR end "ruleMediaFile"


    // $ANTLR start "rule__Playlist__VidsAssignment"
    // InternalPlaylist.g:102:1: rule__Playlist__VidsAssignment : ( ruleMediaFile ) ;
    public final void rule__Playlist__VidsAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPlaylist.g:106:1: ( ( ruleMediaFile ) )
            // InternalPlaylist.g:107:2: ( ruleMediaFile )
            {
            // InternalPlaylist.g:107:2: ( ruleMediaFile )
            // InternalPlaylist.g:108:3: ruleMediaFile
            {
             before(grammarAccess.getPlaylistAccess().getVidsMediaFileParserRuleCall_0()); 
            pushFollow(FOLLOW_2);
            ruleMediaFile();

            state._fsp--;

             after(grammarAccess.getPlaylistAccess().getVidsMediaFileParserRuleCall_0()); 

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
    // $ANTLR end "rule__Playlist__VidsAssignment"


    // $ANTLR start "rule__MediaFile__LocationAssignment"
    // InternalPlaylist.g:117:1: rule__MediaFile__LocationAssignment : ( RULE_STRING ) ;
    public final void rule__MediaFile__LocationAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPlaylist.g:121:1: ( ( RULE_STRING ) )
            // InternalPlaylist.g:122:2: ( RULE_STRING )
            {
            // InternalPlaylist.g:122:2: ( RULE_STRING )
            // InternalPlaylist.g:123:3: RULE_STRING
            {
             before(grammarAccess.getMediaFileAccess().getLocationSTRINGTerminalRuleCall_0()); 
            match(input,RULE_STRING,FOLLOW_2); 
             after(grammarAccess.getMediaFileAccess().getLocationSTRINGTerminalRuleCall_0()); 

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
    // $ANTLR end "rule__MediaFile__LocationAssignment"

    // Delegated rules


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000012L});

}