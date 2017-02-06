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
    // InternalPlaylist.g:87:1: ruleMediaFile : ( ( rule__MediaFile__Group__0 ) ) ;
    public final void ruleMediaFile() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPlaylist.g:91:2: ( ( ( rule__MediaFile__Group__0 ) ) )
            // InternalPlaylist.g:92:2: ( ( rule__MediaFile__Group__0 ) )
            {
            // InternalPlaylist.g:92:2: ( ( rule__MediaFile__Group__0 ) )
            // InternalPlaylist.g:93:3: ( rule__MediaFile__Group__0 )
            {
             before(grammarAccess.getMediaFileAccess().getGroup()); 
            // InternalPlaylist.g:94:3: ( rule__MediaFile__Group__0 )
            // InternalPlaylist.g:94:4: rule__MediaFile__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__MediaFile__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getMediaFileAccess().getGroup()); 

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


    // $ANTLR start "rule__MediaFile__Group__0"
    // InternalPlaylist.g:102:1: rule__MediaFile__Group__0 : rule__MediaFile__Group__0__Impl rule__MediaFile__Group__1 ;
    public final void rule__MediaFile__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPlaylist.g:106:1: ( rule__MediaFile__Group__0__Impl rule__MediaFile__Group__1 )
            // InternalPlaylist.g:107:2: rule__MediaFile__Group__0__Impl rule__MediaFile__Group__1
            {
            pushFollow(FOLLOW_4);
            rule__MediaFile__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__MediaFile__Group__1();

            state._fsp--;


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
    // $ANTLR end "rule__MediaFile__Group__0"


    // $ANTLR start "rule__MediaFile__Group__0__Impl"
    // InternalPlaylist.g:114:1: rule__MediaFile__Group__0__Impl : ( ( rule__MediaFile__LocationAssignment_0 ) ) ;
    public final void rule__MediaFile__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPlaylist.g:118:1: ( ( ( rule__MediaFile__LocationAssignment_0 ) ) )
            // InternalPlaylist.g:119:1: ( ( rule__MediaFile__LocationAssignment_0 ) )
            {
            // InternalPlaylist.g:119:1: ( ( rule__MediaFile__LocationAssignment_0 ) )
            // InternalPlaylist.g:120:2: ( rule__MediaFile__LocationAssignment_0 )
            {
             before(grammarAccess.getMediaFileAccess().getLocationAssignment_0()); 
            // InternalPlaylist.g:121:2: ( rule__MediaFile__LocationAssignment_0 )
            // InternalPlaylist.g:121:3: rule__MediaFile__LocationAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__MediaFile__LocationAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getMediaFileAccess().getLocationAssignment_0()); 

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
    // $ANTLR end "rule__MediaFile__Group__0__Impl"


    // $ANTLR start "rule__MediaFile__Group__1"
    // InternalPlaylist.g:129:1: rule__MediaFile__Group__1 : rule__MediaFile__Group__1__Impl ;
    public final void rule__MediaFile__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPlaylist.g:133:1: ( rule__MediaFile__Group__1__Impl )
            // InternalPlaylist.g:134:2: rule__MediaFile__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__MediaFile__Group__1__Impl();

            state._fsp--;


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
    // $ANTLR end "rule__MediaFile__Group__1"


    // $ANTLR start "rule__MediaFile__Group__1__Impl"
    // InternalPlaylist.g:140:1: rule__MediaFile__Group__1__Impl : ( ( rule__MediaFile__DurationAssignment_1 ) ) ;
    public final void rule__MediaFile__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPlaylist.g:144:1: ( ( ( rule__MediaFile__DurationAssignment_1 ) ) )
            // InternalPlaylist.g:145:1: ( ( rule__MediaFile__DurationAssignment_1 ) )
            {
            // InternalPlaylist.g:145:1: ( ( rule__MediaFile__DurationAssignment_1 ) )
            // InternalPlaylist.g:146:2: ( rule__MediaFile__DurationAssignment_1 )
            {
             before(grammarAccess.getMediaFileAccess().getDurationAssignment_1()); 
            // InternalPlaylist.g:147:2: ( rule__MediaFile__DurationAssignment_1 )
            // InternalPlaylist.g:147:3: rule__MediaFile__DurationAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__MediaFile__DurationAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getMediaFileAccess().getDurationAssignment_1()); 

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
    // $ANTLR end "rule__MediaFile__Group__1__Impl"


    // $ANTLR start "rule__Playlist__VidsAssignment"
    // InternalPlaylist.g:156:1: rule__Playlist__VidsAssignment : ( ruleMediaFile ) ;
    public final void rule__Playlist__VidsAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPlaylist.g:160:1: ( ( ruleMediaFile ) )
            // InternalPlaylist.g:161:2: ( ruleMediaFile )
            {
            // InternalPlaylist.g:161:2: ( ruleMediaFile )
            // InternalPlaylist.g:162:3: ruleMediaFile
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


    // $ANTLR start "rule__MediaFile__LocationAssignment_0"
    // InternalPlaylist.g:171:1: rule__MediaFile__LocationAssignment_0 : ( RULE_STRING ) ;
    public final void rule__MediaFile__LocationAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPlaylist.g:175:1: ( ( RULE_STRING ) )
            // InternalPlaylist.g:176:2: ( RULE_STRING )
            {
            // InternalPlaylist.g:176:2: ( RULE_STRING )
            // InternalPlaylist.g:177:3: RULE_STRING
            {
             before(grammarAccess.getMediaFileAccess().getLocationSTRINGTerminalRuleCall_0_0()); 
            match(input,RULE_STRING,FOLLOW_2); 
             after(grammarAccess.getMediaFileAccess().getLocationSTRINGTerminalRuleCall_0_0()); 

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
    // $ANTLR end "rule__MediaFile__LocationAssignment_0"


    // $ANTLR start "rule__MediaFile__DurationAssignment_1"
    // InternalPlaylist.g:186:1: rule__MediaFile__DurationAssignment_1 : ( RULE_INT ) ;
    public final void rule__MediaFile__DurationAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPlaylist.g:190:1: ( ( RULE_INT ) )
            // InternalPlaylist.g:191:2: ( RULE_INT )
            {
            // InternalPlaylist.g:191:2: ( RULE_INT )
            // InternalPlaylist.g:192:3: RULE_INT
            {
             before(grammarAccess.getMediaFileAccess().getDurationINTTerminalRuleCall_1_0()); 
            match(input,RULE_INT,FOLLOW_2); 
             after(grammarAccess.getMediaFileAccess().getDurationINTTerminalRuleCall_1_0()); 

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
    // $ANTLR end "rule__MediaFile__DurationAssignment_1"

    // Delegated rules


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000020L});

}