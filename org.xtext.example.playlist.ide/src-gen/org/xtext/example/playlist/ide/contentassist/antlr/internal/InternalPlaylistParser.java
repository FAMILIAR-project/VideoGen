package org.xtext.example.playlist.ide.contentassist.antlr.internal;

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
import org.xtext.example.playlist.services.PlaylistGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalPlaylistParser extends AbstractInternalContentAssistParser {
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
    // InternalPlaylist.g:62:1: rulePlaylist : ( ( rule__Playlist__VideosAssignment )* ) ;
    public final void rulePlaylist() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPlaylist.g:66:2: ( ( ( rule__Playlist__VideosAssignment )* ) )
            // InternalPlaylist.g:67:2: ( ( rule__Playlist__VideosAssignment )* )
            {
            // InternalPlaylist.g:67:2: ( ( rule__Playlist__VideosAssignment )* )
            // InternalPlaylist.g:68:3: ( rule__Playlist__VideosAssignment )*
            {
             before(grammarAccess.getPlaylistAccess().getVideosAssignment()); 
            // InternalPlaylist.g:69:3: ( rule__Playlist__VideosAssignment )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==11) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalPlaylist.g:69:4: rule__Playlist__VideosAssignment
            	    {
            	    pushFollow(FOLLOW_3);
            	    rule__Playlist__VideosAssignment();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

             after(grammarAccess.getPlaylistAccess().getVideosAssignment()); 

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


    // $ANTLR start "entryRuleVideo"
    // InternalPlaylist.g:78:1: entryRuleVideo : ruleVideo EOF ;
    public final void entryRuleVideo() throws RecognitionException {
        try {
            // InternalPlaylist.g:79:1: ( ruleVideo EOF )
            // InternalPlaylist.g:80:1: ruleVideo EOF
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
    // InternalPlaylist.g:87:1: ruleVideo : ( ( rule__Video__Group__0 ) ) ;
    public final void ruleVideo() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPlaylist.g:91:2: ( ( ( rule__Video__Group__0 ) ) )
            // InternalPlaylist.g:92:2: ( ( rule__Video__Group__0 ) )
            {
            // InternalPlaylist.g:92:2: ( ( rule__Video__Group__0 ) )
            // InternalPlaylist.g:93:3: ( rule__Video__Group__0 )
            {
             before(grammarAccess.getVideoAccess().getGroup()); 
            // InternalPlaylist.g:94:3: ( rule__Video__Group__0 )
            // InternalPlaylist.g:94:4: rule__Video__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Video__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getVideoAccess().getGroup()); 

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


    // $ANTLR start "rule__Video__Group__0"
    // InternalPlaylist.g:102:1: rule__Video__Group__0 : rule__Video__Group__0__Impl rule__Video__Group__1 ;
    public final void rule__Video__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPlaylist.g:106:1: ( rule__Video__Group__0__Impl rule__Video__Group__1 )
            // InternalPlaylist.g:107:2: rule__Video__Group__0__Impl rule__Video__Group__1
            {
            pushFollow(FOLLOW_4);
            rule__Video__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Video__Group__1();

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
    // $ANTLR end "rule__Video__Group__0"


    // $ANTLR start "rule__Video__Group__0__Impl"
    // InternalPlaylist.g:114:1: rule__Video__Group__0__Impl : ( 'file' ) ;
    public final void rule__Video__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPlaylist.g:118:1: ( ( 'file' ) )
            // InternalPlaylist.g:119:1: ( 'file' )
            {
            // InternalPlaylist.g:119:1: ( 'file' )
            // InternalPlaylist.g:120:2: 'file'
            {
             before(grammarAccess.getVideoAccess().getFileKeyword_0()); 
            match(input,11,FOLLOW_2); 
             after(grammarAccess.getVideoAccess().getFileKeyword_0()); 

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
    // $ANTLR end "rule__Video__Group__0__Impl"


    // $ANTLR start "rule__Video__Group__1"
    // InternalPlaylist.g:129:1: rule__Video__Group__1 : rule__Video__Group__1__Impl ;
    public final void rule__Video__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPlaylist.g:133:1: ( rule__Video__Group__1__Impl )
            // InternalPlaylist.g:134:2: rule__Video__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Video__Group__1__Impl();

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
    // $ANTLR end "rule__Video__Group__1"


    // $ANTLR start "rule__Video__Group__1__Impl"
    // InternalPlaylist.g:140:1: rule__Video__Group__1__Impl : ( ( rule__Video__LocationAssignment_1 ) ) ;
    public final void rule__Video__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPlaylist.g:144:1: ( ( ( rule__Video__LocationAssignment_1 ) ) )
            // InternalPlaylist.g:145:1: ( ( rule__Video__LocationAssignment_1 ) )
            {
            // InternalPlaylist.g:145:1: ( ( rule__Video__LocationAssignment_1 ) )
            // InternalPlaylist.g:146:2: ( rule__Video__LocationAssignment_1 )
            {
             before(grammarAccess.getVideoAccess().getLocationAssignment_1()); 
            // InternalPlaylist.g:147:2: ( rule__Video__LocationAssignment_1 )
            // InternalPlaylist.g:147:3: rule__Video__LocationAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__Video__LocationAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getVideoAccess().getLocationAssignment_1()); 

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
    // $ANTLR end "rule__Video__Group__1__Impl"


    // $ANTLR start "rule__Playlist__VideosAssignment"
    // InternalPlaylist.g:156:1: rule__Playlist__VideosAssignment : ( ruleVideo ) ;
    public final void rule__Playlist__VideosAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPlaylist.g:160:1: ( ( ruleVideo ) )
            // InternalPlaylist.g:161:2: ( ruleVideo )
            {
            // InternalPlaylist.g:161:2: ( ruleVideo )
            // InternalPlaylist.g:162:3: ruleVideo
            {
             before(grammarAccess.getPlaylistAccess().getVideosVideoParserRuleCall_0()); 
            pushFollow(FOLLOW_2);
            ruleVideo();

            state._fsp--;

             after(grammarAccess.getPlaylistAccess().getVideosVideoParserRuleCall_0()); 

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
    // $ANTLR end "rule__Playlist__VideosAssignment"


    // $ANTLR start "rule__Video__LocationAssignment_1"
    // InternalPlaylist.g:171:1: rule__Video__LocationAssignment_1 : ( RULE_STRING ) ;
    public final void rule__Video__LocationAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPlaylist.g:175:1: ( ( RULE_STRING ) )
            // InternalPlaylist.g:176:2: ( RULE_STRING )
            {
            // InternalPlaylist.g:176:2: ( RULE_STRING )
            // InternalPlaylist.g:177:3: RULE_STRING
            {
             before(grammarAccess.getVideoAccess().getLocationSTRINGTerminalRuleCall_1_0()); 
            match(input,RULE_STRING,FOLLOW_2); 
             after(grammarAccess.getVideoAccess().getLocationSTRINGTerminalRuleCall_1_0()); 

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
    // $ANTLR end "rule__Video__LocationAssignment_1"

    // Delegated rules


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000802L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000010L});

}