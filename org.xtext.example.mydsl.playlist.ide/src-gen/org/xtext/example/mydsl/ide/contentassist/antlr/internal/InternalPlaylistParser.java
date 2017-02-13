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



    // $ANTLR start "entryRulePlaylistGeneratorModel"
    // InternalPlaylist.g:53:1: entryRulePlaylistGeneratorModel : rulePlaylistGeneratorModel EOF ;
    public final void entryRulePlaylistGeneratorModel() throws RecognitionException {
        try {
            // InternalPlaylist.g:54:1: ( rulePlaylistGeneratorModel EOF )
            // InternalPlaylist.g:55:1: rulePlaylistGeneratorModel EOF
            {
             before(grammarAccess.getPlaylistGeneratorModelRule()); 
            pushFollow(FOLLOW_1);
            rulePlaylistGeneratorModel();

            state._fsp--;

             after(grammarAccess.getPlaylistGeneratorModelRule()); 
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
    // $ANTLR end "entryRulePlaylistGeneratorModel"


    // $ANTLR start "rulePlaylistGeneratorModel"
    // InternalPlaylist.g:62:1: rulePlaylistGeneratorModel : ( ( rule__PlaylistGeneratorModel__Group__0 ) ) ;
    public final void rulePlaylistGeneratorModel() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPlaylist.g:66:2: ( ( ( rule__PlaylistGeneratorModel__Group__0 ) ) )
            // InternalPlaylist.g:67:2: ( ( rule__PlaylistGeneratorModel__Group__0 ) )
            {
            // InternalPlaylist.g:67:2: ( ( rule__PlaylistGeneratorModel__Group__0 ) )
            // InternalPlaylist.g:68:3: ( rule__PlaylistGeneratorModel__Group__0 )
            {
             before(grammarAccess.getPlaylistGeneratorModelAccess().getGroup()); 
            // InternalPlaylist.g:69:3: ( rule__PlaylistGeneratorModel__Group__0 )
            // InternalPlaylist.g:69:4: rule__PlaylistGeneratorModel__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__PlaylistGeneratorModel__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getPlaylistGeneratorModelAccess().getGroup()); 

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
    // $ANTLR end "rulePlaylistGeneratorModel"


    // $ANTLR start "entryRuleMediafile"
    // InternalPlaylist.g:78:1: entryRuleMediafile : ruleMediafile EOF ;
    public final void entryRuleMediafile() throws RecognitionException {
        try {
            // InternalPlaylist.g:79:1: ( ruleMediafile EOF )
            // InternalPlaylist.g:80:1: ruleMediafile EOF
            {
             before(grammarAccess.getMediafileRule()); 
            pushFollow(FOLLOW_1);
            ruleMediafile();

            state._fsp--;

             after(grammarAccess.getMediafileRule()); 
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
    // $ANTLR end "entryRuleMediafile"


    // $ANTLR start "ruleMediafile"
    // InternalPlaylist.g:87:1: ruleMediafile : ( ( rule__Mediafile__Group__0 ) ) ;
    public final void ruleMediafile() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPlaylist.g:91:2: ( ( ( rule__Mediafile__Group__0 ) ) )
            // InternalPlaylist.g:92:2: ( ( rule__Mediafile__Group__0 ) )
            {
            // InternalPlaylist.g:92:2: ( ( rule__Mediafile__Group__0 ) )
            // InternalPlaylist.g:93:3: ( rule__Mediafile__Group__0 )
            {
             before(grammarAccess.getMediafileAccess().getGroup()); 
            // InternalPlaylist.g:94:3: ( rule__Mediafile__Group__0 )
            // InternalPlaylist.g:94:4: rule__Mediafile__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Mediafile__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getMediafileAccess().getGroup()); 

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
    // $ANTLR end "ruleMediafile"


    // $ANTLR start "rule__PlaylistGeneratorModel__Group__0"
    // InternalPlaylist.g:102:1: rule__PlaylistGeneratorModel__Group__0 : rule__PlaylistGeneratorModel__Group__0__Impl rule__PlaylistGeneratorModel__Group__1 ;
    public final void rule__PlaylistGeneratorModel__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPlaylist.g:106:1: ( rule__PlaylistGeneratorModel__Group__0__Impl rule__PlaylistGeneratorModel__Group__1 )
            // InternalPlaylist.g:107:2: rule__PlaylistGeneratorModel__Group__0__Impl rule__PlaylistGeneratorModel__Group__1
            {
            pushFollow(FOLLOW_3);
            rule__PlaylistGeneratorModel__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__PlaylistGeneratorModel__Group__1();

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
    // $ANTLR end "rule__PlaylistGeneratorModel__Group__0"


    // $ANTLR start "rule__PlaylistGeneratorModel__Group__0__Impl"
    // InternalPlaylist.g:114:1: rule__PlaylistGeneratorModel__Group__0__Impl : ( () ) ;
    public final void rule__PlaylistGeneratorModel__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPlaylist.g:118:1: ( ( () ) )
            // InternalPlaylist.g:119:1: ( () )
            {
            // InternalPlaylist.g:119:1: ( () )
            // InternalPlaylist.g:120:2: ()
            {
             before(grammarAccess.getPlaylistGeneratorModelAccess().getPlaylistGeneratorModelAction_0()); 
            // InternalPlaylist.g:121:2: ()
            // InternalPlaylist.g:121:3: 
            {
            }

             after(grammarAccess.getPlaylistGeneratorModelAccess().getPlaylistGeneratorModelAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PlaylistGeneratorModel__Group__0__Impl"


    // $ANTLR start "rule__PlaylistGeneratorModel__Group__1"
    // InternalPlaylist.g:129:1: rule__PlaylistGeneratorModel__Group__1 : rule__PlaylistGeneratorModel__Group__1__Impl rule__PlaylistGeneratorModel__Group__2 ;
    public final void rule__PlaylistGeneratorModel__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPlaylist.g:133:1: ( rule__PlaylistGeneratorModel__Group__1__Impl rule__PlaylistGeneratorModel__Group__2 )
            // InternalPlaylist.g:134:2: rule__PlaylistGeneratorModel__Group__1__Impl rule__PlaylistGeneratorModel__Group__2
            {
            pushFollow(FOLLOW_4);
            rule__PlaylistGeneratorModel__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__PlaylistGeneratorModel__Group__2();

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
    // $ANTLR end "rule__PlaylistGeneratorModel__Group__1"


    // $ANTLR start "rule__PlaylistGeneratorModel__Group__1__Impl"
    // InternalPlaylist.g:141:1: rule__PlaylistGeneratorModel__Group__1__Impl : ( 'Playlist' ) ;
    public final void rule__PlaylistGeneratorModel__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPlaylist.g:145:1: ( ( 'Playlist' ) )
            // InternalPlaylist.g:146:1: ( 'Playlist' )
            {
            // InternalPlaylist.g:146:1: ( 'Playlist' )
            // InternalPlaylist.g:147:2: 'Playlist'
            {
             before(grammarAccess.getPlaylistGeneratorModelAccess().getPlaylistKeyword_1()); 
            match(input,14,FOLLOW_2); 
             after(grammarAccess.getPlaylistGeneratorModelAccess().getPlaylistKeyword_1()); 

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
    // $ANTLR end "rule__PlaylistGeneratorModel__Group__1__Impl"


    // $ANTLR start "rule__PlaylistGeneratorModel__Group__2"
    // InternalPlaylist.g:156:1: rule__PlaylistGeneratorModel__Group__2 : rule__PlaylistGeneratorModel__Group__2__Impl rule__PlaylistGeneratorModel__Group__3 ;
    public final void rule__PlaylistGeneratorModel__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPlaylist.g:160:1: ( rule__PlaylistGeneratorModel__Group__2__Impl rule__PlaylistGeneratorModel__Group__3 )
            // InternalPlaylist.g:161:2: rule__PlaylistGeneratorModel__Group__2__Impl rule__PlaylistGeneratorModel__Group__3
            {
            pushFollow(FOLLOW_5);
            rule__PlaylistGeneratorModel__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__PlaylistGeneratorModel__Group__3();

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
    // $ANTLR end "rule__PlaylistGeneratorModel__Group__2"


    // $ANTLR start "rule__PlaylistGeneratorModel__Group__2__Impl"
    // InternalPlaylist.g:168:1: rule__PlaylistGeneratorModel__Group__2__Impl : ( RULE_LEFT_BRACKET ) ;
    public final void rule__PlaylistGeneratorModel__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPlaylist.g:172:1: ( ( RULE_LEFT_BRACKET ) )
            // InternalPlaylist.g:173:1: ( RULE_LEFT_BRACKET )
            {
            // InternalPlaylist.g:173:1: ( RULE_LEFT_BRACKET )
            // InternalPlaylist.g:174:2: RULE_LEFT_BRACKET
            {
             before(grammarAccess.getPlaylistGeneratorModelAccess().getLEFT_BRACKETTerminalRuleCall_2()); 
            match(input,RULE_LEFT_BRACKET,FOLLOW_2); 
             after(grammarAccess.getPlaylistGeneratorModelAccess().getLEFT_BRACKETTerminalRuleCall_2()); 

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
    // $ANTLR end "rule__PlaylistGeneratorModel__Group__2__Impl"


    // $ANTLR start "rule__PlaylistGeneratorModel__Group__3"
    // InternalPlaylist.g:183:1: rule__PlaylistGeneratorModel__Group__3 : rule__PlaylistGeneratorModel__Group__3__Impl rule__PlaylistGeneratorModel__Group__4 ;
    public final void rule__PlaylistGeneratorModel__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPlaylist.g:187:1: ( rule__PlaylistGeneratorModel__Group__3__Impl rule__PlaylistGeneratorModel__Group__4 )
            // InternalPlaylist.g:188:2: rule__PlaylistGeneratorModel__Group__3__Impl rule__PlaylistGeneratorModel__Group__4
            {
            pushFollow(FOLLOW_6);
            rule__PlaylistGeneratorModel__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__PlaylistGeneratorModel__Group__4();

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
    // $ANTLR end "rule__PlaylistGeneratorModel__Group__3"


    // $ANTLR start "rule__PlaylistGeneratorModel__Group__3__Impl"
    // InternalPlaylist.g:195:1: rule__PlaylistGeneratorModel__Group__3__Impl : ( ( ( rule__PlaylistGeneratorModel__MediafilesAssignment_3 ) ) ( ( rule__PlaylistGeneratorModel__MediafilesAssignment_3 )* ) ) ;
    public final void rule__PlaylistGeneratorModel__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPlaylist.g:199:1: ( ( ( ( rule__PlaylistGeneratorModel__MediafilesAssignment_3 ) ) ( ( rule__PlaylistGeneratorModel__MediafilesAssignment_3 )* ) ) )
            // InternalPlaylist.g:200:1: ( ( ( rule__PlaylistGeneratorModel__MediafilesAssignment_3 ) ) ( ( rule__PlaylistGeneratorModel__MediafilesAssignment_3 )* ) )
            {
            // InternalPlaylist.g:200:1: ( ( ( rule__PlaylistGeneratorModel__MediafilesAssignment_3 ) ) ( ( rule__PlaylistGeneratorModel__MediafilesAssignment_3 )* ) )
            // InternalPlaylist.g:201:2: ( ( rule__PlaylistGeneratorModel__MediafilesAssignment_3 ) ) ( ( rule__PlaylistGeneratorModel__MediafilesAssignment_3 )* )
            {
            // InternalPlaylist.g:201:2: ( ( rule__PlaylistGeneratorModel__MediafilesAssignment_3 ) )
            // InternalPlaylist.g:202:3: ( rule__PlaylistGeneratorModel__MediafilesAssignment_3 )
            {
             before(grammarAccess.getPlaylistGeneratorModelAccess().getMediafilesAssignment_3()); 
            // InternalPlaylist.g:203:3: ( rule__PlaylistGeneratorModel__MediafilesAssignment_3 )
            // InternalPlaylist.g:203:4: rule__PlaylistGeneratorModel__MediafilesAssignment_3
            {
            pushFollow(FOLLOW_7);
            rule__PlaylistGeneratorModel__MediafilesAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getPlaylistGeneratorModelAccess().getMediafilesAssignment_3()); 

            }

            // InternalPlaylist.g:206:2: ( ( rule__PlaylistGeneratorModel__MediafilesAssignment_3 )* )
            // InternalPlaylist.g:207:3: ( rule__PlaylistGeneratorModel__MediafilesAssignment_3 )*
            {
             before(grammarAccess.getPlaylistGeneratorModelAccess().getMediafilesAssignment_3()); 
            // InternalPlaylist.g:208:3: ( rule__PlaylistGeneratorModel__MediafilesAssignment_3 )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==15) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalPlaylist.g:208:4: rule__PlaylistGeneratorModel__MediafilesAssignment_3
            	    {
            	    pushFollow(FOLLOW_7);
            	    rule__PlaylistGeneratorModel__MediafilesAssignment_3();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

             after(grammarAccess.getPlaylistGeneratorModelAccess().getMediafilesAssignment_3()); 

            }


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
    // $ANTLR end "rule__PlaylistGeneratorModel__Group__3__Impl"


    // $ANTLR start "rule__PlaylistGeneratorModel__Group__4"
    // InternalPlaylist.g:217:1: rule__PlaylistGeneratorModel__Group__4 : rule__PlaylistGeneratorModel__Group__4__Impl ;
    public final void rule__PlaylistGeneratorModel__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPlaylist.g:221:1: ( rule__PlaylistGeneratorModel__Group__4__Impl )
            // InternalPlaylist.g:222:2: rule__PlaylistGeneratorModel__Group__4__Impl
            {
            pushFollow(FOLLOW_2);
            rule__PlaylistGeneratorModel__Group__4__Impl();

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
    // $ANTLR end "rule__PlaylistGeneratorModel__Group__4"


    // $ANTLR start "rule__PlaylistGeneratorModel__Group__4__Impl"
    // InternalPlaylist.g:228:1: rule__PlaylistGeneratorModel__Group__4__Impl : ( RULE_RIGHT_BRACKET ) ;
    public final void rule__PlaylistGeneratorModel__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPlaylist.g:232:1: ( ( RULE_RIGHT_BRACKET ) )
            // InternalPlaylist.g:233:1: ( RULE_RIGHT_BRACKET )
            {
            // InternalPlaylist.g:233:1: ( RULE_RIGHT_BRACKET )
            // InternalPlaylist.g:234:2: RULE_RIGHT_BRACKET
            {
             before(grammarAccess.getPlaylistGeneratorModelAccess().getRIGHT_BRACKETTerminalRuleCall_4()); 
            match(input,RULE_RIGHT_BRACKET,FOLLOW_2); 
             after(grammarAccess.getPlaylistGeneratorModelAccess().getRIGHT_BRACKETTerminalRuleCall_4()); 

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
    // $ANTLR end "rule__PlaylistGeneratorModel__Group__4__Impl"


    // $ANTLR start "rule__Mediafile__Group__0"
    // InternalPlaylist.g:244:1: rule__Mediafile__Group__0 : rule__Mediafile__Group__0__Impl rule__Mediafile__Group__1 ;
    public final void rule__Mediafile__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPlaylist.g:248:1: ( rule__Mediafile__Group__0__Impl rule__Mediafile__Group__1 )
            // InternalPlaylist.g:249:2: rule__Mediafile__Group__0__Impl rule__Mediafile__Group__1
            {
            pushFollow(FOLLOW_4);
            rule__Mediafile__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Mediafile__Group__1();

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
    // $ANTLR end "rule__Mediafile__Group__0"


    // $ANTLR start "rule__Mediafile__Group__0__Impl"
    // InternalPlaylist.g:256:1: rule__Mediafile__Group__0__Impl : ( 'mediafile' ) ;
    public final void rule__Mediafile__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPlaylist.g:260:1: ( ( 'mediafile' ) )
            // InternalPlaylist.g:261:1: ( 'mediafile' )
            {
            // InternalPlaylist.g:261:1: ( 'mediafile' )
            // InternalPlaylist.g:262:2: 'mediafile'
            {
             before(grammarAccess.getMediafileAccess().getMediafileKeyword_0()); 
            match(input,15,FOLLOW_2); 
             after(grammarAccess.getMediafileAccess().getMediafileKeyword_0()); 

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
    // $ANTLR end "rule__Mediafile__Group__0__Impl"


    // $ANTLR start "rule__Mediafile__Group__1"
    // InternalPlaylist.g:271:1: rule__Mediafile__Group__1 : rule__Mediafile__Group__1__Impl rule__Mediafile__Group__2 ;
    public final void rule__Mediafile__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPlaylist.g:275:1: ( rule__Mediafile__Group__1__Impl rule__Mediafile__Group__2 )
            // InternalPlaylist.g:276:2: rule__Mediafile__Group__1__Impl rule__Mediafile__Group__2
            {
            pushFollow(FOLLOW_8);
            rule__Mediafile__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Mediafile__Group__2();

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
    // $ANTLR end "rule__Mediafile__Group__1"


    // $ANTLR start "rule__Mediafile__Group__1__Impl"
    // InternalPlaylist.g:283:1: rule__Mediafile__Group__1__Impl : ( RULE_LEFT_BRACKET ) ;
    public final void rule__Mediafile__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPlaylist.g:287:1: ( ( RULE_LEFT_BRACKET ) )
            // InternalPlaylist.g:288:1: ( RULE_LEFT_BRACKET )
            {
            // InternalPlaylist.g:288:1: ( RULE_LEFT_BRACKET )
            // InternalPlaylist.g:289:2: RULE_LEFT_BRACKET
            {
             before(grammarAccess.getMediafileAccess().getLEFT_BRACKETTerminalRuleCall_1()); 
            match(input,RULE_LEFT_BRACKET,FOLLOW_2); 
             after(grammarAccess.getMediafileAccess().getLEFT_BRACKETTerminalRuleCall_1()); 

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
    // $ANTLR end "rule__Mediafile__Group__1__Impl"


    // $ANTLR start "rule__Mediafile__Group__2"
    // InternalPlaylist.g:298:1: rule__Mediafile__Group__2 : rule__Mediafile__Group__2__Impl rule__Mediafile__Group__3 ;
    public final void rule__Mediafile__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPlaylist.g:302:1: ( rule__Mediafile__Group__2__Impl rule__Mediafile__Group__3 )
            // InternalPlaylist.g:303:2: rule__Mediafile__Group__2__Impl rule__Mediafile__Group__3
            {
            pushFollow(FOLLOW_9);
            rule__Mediafile__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Mediafile__Group__3();

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
    // $ANTLR end "rule__Mediafile__Group__2"


    // $ANTLR start "rule__Mediafile__Group__2__Impl"
    // InternalPlaylist.g:310:1: rule__Mediafile__Group__2__Impl : ( 'id:' ) ;
    public final void rule__Mediafile__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPlaylist.g:314:1: ( ( 'id:' ) )
            // InternalPlaylist.g:315:1: ( 'id:' )
            {
            // InternalPlaylist.g:315:1: ( 'id:' )
            // InternalPlaylist.g:316:2: 'id:'
            {
             before(grammarAccess.getMediafileAccess().getIdKeyword_2()); 
            match(input,16,FOLLOW_2); 
             after(grammarAccess.getMediafileAccess().getIdKeyword_2()); 

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
    // $ANTLR end "rule__Mediafile__Group__2__Impl"


    // $ANTLR start "rule__Mediafile__Group__3"
    // InternalPlaylist.g:325:1: rule__Mediafile__Group__3 : rule__Mediafile__Group__3__Impl rule__Mediafile__Group__4 ;
    public final void rule__Mediafile__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPlaylist.g:329:1: ( rule__Mediafile__Group__3__Impl rule__Mediafile__Group__4 )
            // InternalPlaylist.g:330:2: rule__Mediafile__Group__3__Impl rule__Mediafile__Group__4
            {
            pushFollow(FOLLOW_10);
            rule__Mediafile__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Mediafile__Group__4();

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
    // $ANTLR end "rule__Mediafile__Group__3"


    // $ANTLR start "rule__Mediafile__Group__3__Impl"
    // InternalPlaylist.g:337:1: rule__Mediafile__Group__3__Impl : ( ( rule__Mediafile__IdAssignment_3 ) ) ;
    public final void rule__Mediafile__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPlaylist.g:341:1: ( ( ( rule__Mediafile__IdAssignment_3 ) ) )
            // InternalPlaylist.g:342:1: ( ( rule__Mediafile__IdAssignment_3 ) )
            {
            // InternalPlaylist.g:342:1: ( ( rule__Mediafile__IdAssignment_3 ) )
            // InternalPlaylist.g:343:2: ( rule__Mediafile__IdAssignment_3 )
            {
             before(grammarAccess.getMediafileAccess().getIdAssignment_3()); 
            // InternalPlaylist.g:344:2: ( rule__Mediafile__IdAssignment_3 )
            // InternalPlaylist.g:344:3: rule__Mediafile__IdAssignment_3
            {
            pushFollow(FOLLOW_2);
            rule__Mediafile__IdAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getMediafileAccess().getIdAssignment_3()); 

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
    // $ANTLR end "rule__Mediafile__Group__3__Impl"


    // $ANTLR start "rule__Mediafile__Group__4"
    // InternalPlaylist.g:352:1: rule__Mediafile__Group__4 : rule__Mediafile__Group__4__Impl rule__Mediafile__Group__5 ;
    public final void rule__Mediafile__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPlaylist.g:356:1: ( rule__Mediafile__Group__4__Impl rule__Mediafile__Group__5 )
            // InternalPlaylist.g:357:2: rule__Mediafile__Group__4__Impl rule__Mediafile__Group__5
            {
            pushFollow(FOLLOW_9);
            rule__Mediafile__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Mediafile__Group__5();

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
    // $ANTLR end "rule__Mediafile__Group__4"


    // $ANTLR start "rule__Mediafile__Group__4__Impl"
    // InternalPlaylist.g:364:1: rule__Mediafile__Group__4__Impl : ( 'path:' ) ;
    public final void rule__Mediafile__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPlaylist.g:368:1: ( ( 'path:' ) )
            // InternalPlaylist.g:369:1: ( 'path:' )
            {
            // InternalPlaylist.g:369:1: ( 'path:' )
            // InternalPlaylist.g:370:2: 'path:'
            {
             before(grammarAccess.getMediafileAccess().getPathKeyword_4()); 
            match(input,17,FOLLOW_2); 
             after(grammarAccess.getMediafileAccess().getPathKeyword_4()); 

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
    // $ANTLR end "rule__Mediafile__Group__4__Impl"


    // $ANTLR start "rule__Mediafile__Group__5"
    // InternalPlaylist.g:379:1: rule__Mediafile__Group__5 : rule__Mediafile__Group__5__Impl rule__Mediafile__Group__6 ;
    public final void rule__Mediafile__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPlaylist.g:383:1: ( rule__Mediafile__Group__5__Impl rule__Mediafile__Group__6 )
            // InternalPlaylist.g:384:2: rule__Mediafile__Group__5__Impl rule__Mediafile__Group__6
            {
            pushFollow(FOLLOW_11);
            rule__Mediafile__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Mediafile__Group__6();

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
    // $ANTLR end "rule__Mediafile__Group__5"


    // $ANTLR start "rule__Mediafile__Group__5__Impl"
    // InternalPlaylist.g:391:1: rule__Mediafile__Group__5__Impl : ( ( rule__Mediafile__LocationAssignment_5 ) ) ;
    public final void rule__Mediafile__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPlaylist.g:395:1: ( ( ( rule__Mediafile__LocationAssignment_5 ) ) )
            // InternalPlaylist.g:396:1: ( ( rule__Mediafile__LocationAssignment_5 ) )
            {
            // InternalPlaylist.g:396:1: ( ( rule__Mediafile__LocationAssignment_5 ) )
            // InternalPlaylist.g:397:2: ( rule__Mediafile__LocationAssignment_5 )
            {
             before(grammarAccess.getMediafileAccess().getLocationAssignment_5()); 
            // InternalPlaylist.g:398:2: ( rule__Mediafile__LocationAssignment_5 )
            // InternalPlaylist.g:398:3: rule__Mediafile__LocationAssignment_5
            {
            pushFollow(FOLLOW_2);
            rule__Mediafile__LocationAssignment_5();

            state._fsp--;


            }

             after(grammarAccess.getMediafileAccess().getLocationAssignment_5()); 

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
    // $ANTLR end "rule__Mediafile__Group__5__Impl"


    // $ANTLR start "rule__Mediafile__Group__6"
    // InternalPlaylist.g:406:1: rule__Mediafile__Group__6 : rule__Mediafile__Group__6__Impl rule__Mediafile__Group__7 ;
    public final void rule__Mediafile__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPlaylist.g:410:1: ( rule__Mediafile__Group__6__Impl rule__Mediafile__Group__7 )
            // InternalPlaylist.g:411:2: rule__Mediafile__Group__6__Impl rule__Mediafile__Group__7
            {
            pushFollow(FOLLOW_12);
            rule__Mediafile__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Mediafile__Group__7();

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
    // $ANTLR end "rule__Mediafile__Group__6"


    // $ANTLR start "rule__Mediafile__Group__6__Impl"
    // InternalPlaylist.g:418:1: rule__Mediafile__Group__6__Impl : ( 'duration:' ) ;
    public final void rule__Mediafile__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPlaylist.g:422:1: ( ( 'duration:' ) )
            // InternalPlaylist.g:423:1: ( 'duration:' )
            {
            // InternalPlaylist.g:423:1: ( 'duration:' )
            // InternalPlaylist.g:424:2: 'duration:'
            {
             before(grammarAccess.getMediafileAccess().getDurationKeyword_6()); 
            match(input,18,FOLLOW_2); 
             after(grammarAccess.getMediafileAccess().getDurationKeyword_6()); 

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
    // $ANTLR end "rule__Mediafile__Group__6__Impl"


    // $ANTLR start "rule__Mediafile__Group__7"
    // InternalPlaylist.g:433:1: rule__Mediafile__Group__7 : rule__Mediafile__Group__7__Impl rule__Mediafile__Group__8 ;
    public final void rule__Mediafile__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPlaylist.g:437:1: ( rule__Mediafile__Group__7__Impl rule__Mediafile__Group__8 )
            // InternalPlaylist.g:438:2: rule__Mediafile__Group__7__Impl rule__Mediafile__Group__8
            {
            pushFollow(FOLLOW_6);
            rule__Mediafile__Group__7__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Mediafile__Group__8();

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
    // $ANTLR end "rule__Mediafile__Group__7"


    // $ANTLR start "rule__Mediafile__Group__7__Impl"
    // InternalPlaylist.g:445:1: rule__Mediafile__Group__7__Impl : ( ( rule__Mediafile__DurationAssignment_7 ) ) ;
    public final void rule__Mediafile__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPlaylist.g:449:1: ( ( ( rule__Mediafile__DurationAssignment_7 ) ) )
            // InternalPlaylist.g:450:1: ( ( rule__Mediafile__DurationAssignment_7 ) )
            {
            // InternalPlaylist.g:450:1: ( ( rule__Mediafile__DurationAssignment_7 ) )
            // InternalPlaylist.g:451:2: ( rule__Mediafile__DurationAssignment_7 )
            {
             before(grammarAccess.getMediafileAccess().getDurationAssignment_7()); 
            // InternalPlaylist.g:452:2: ( rule__Mediafile__DurationAssignment_7 )
            // InternalPlaylist.g:452:3: rule__Mediafile__DurationAssignment_7
            {
            pushFollow(FOLLOW_2);
            rule__Mediafile__DurationAssignment_7();

            state._fsp--;


            }

             after(grammarAccess.getMediafileAccess().getDurationAssignment_7()); 

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
    // $ANTLR end "rule__Mediafile__Group__7__Impl"


    // $ANTLR start "rule__Mediafile__Group__8"
    // InternalPlaylist.g:460:1: rule__Mediafile__Group__8 : rule__Mediafile__Group__8__Impl ;
    public final void rule__Mediafile__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPlaylist.g:464:1: ( rule__Mediafile__Group__8__Impl )
            // InternalPlaylist.g:465:2: rule__Mediafile__Group__8__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Mediafile__Group__8__Impl();

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
    // $ANTLR end "rule__Mediafile__Group__8"


    // $ANTLR start "rule__Mediafile__Group__8__Impl"
    // InternalPlaylist.g:471:1: rule__Mediafile__Group__8__Impl : ( RULE_RIGHT_BRACKET ) ;
    public final void rule__Mediafile__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPlaylist.g:475:1: ( ( RULE_RIGHT_BRACKET ) )
            // InternalPlaylist.g:476:1: ( RULE_RIGHT_BRACKET )
            {
            // InternalPlaylist.g:476:1: ( RULE_RIGHT_BRACKET )
            // InternalPlaylist.g:477:2: RULE_RIGHT_BRACKET
            {
             before(grammarAccess.getMediafileAccess().getRIGHT_BRACKETTerminalRuleCall_8()); 
            match(input,RULE_RIGHT_BRACKET,FOLLOW_2); 
             after(grammarAccess.getMediafileAccess().getRIGHT_BRACKETTerminalRuleCall_8()); 

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
    // $ANTLR end "rule__Mediafile__Group__8__Impl"


    // $ANTLR start "rule__PlaylistGeneratorModel__MediafilesAssignment_3"
    // InternalPlaylist.g:487:1: rule__PlaylistGeneratorModel__MediafilesAssignment_3 : ( ruleMediafile ) ;
    public final void rule__PlaylistGeneratorModel__MediafilesAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPlaylist.g:491:1: ( ( ruleMediafile ) )
            // InternalPlaylist.g:492:2: ( ruleMediafile )
            {
            // InternalPlaylist.g:492:2: ( ruleMediafile )
            // InternalPlaylist.g:493:3: ruleMediafile
            {
             before(grammarAccess.getPlaylistGeneratorModelAccess().getMediafilesMediafileParserRuleCall_3_0()); 
            pushFollow(FOLLOW_2);
            ruleMediafile();

            state._fsp--;

             after(grammarAccess.getPlaylistGeneratorModelAccess().getMediafilesMediafileParserRuleCall_3_0()); 

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
    // $ANTLR end "rule__PlaylistGeneratorModel__MediafilesAssignment_3"


    // $ANTLR start "rule__Mediafile__IdAssignment_3"
    // InternalPlaylist.g:502:1: rule__Mediafile__IdAssignment_3 : ( RULE_STRING ) ;
    public final void rule__Mediafile__IdAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPlaylist.g:506:1: ( ( RULE_STRING ) )
            // InternalPlaylist.g:507:2: ( RULE_STRING )
            {
            // InternalPlaylist.g:507:2: ( RULE_STRING )
            // InternalPlaylist.g:508:3: RULE_STRING
            {
             before(grammarAccess.getMediafileAccess().getIdSTRINGTerminalRuleCall_3_0()); 
            match(input,RULE_STRING,FOLLOW_2); 
             after(grammarAccess.getMediafileAccess().getIdSTRINGTerminalRuleCall_3_0()); 

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
    // $ANTLR end "rule__Mediafile__IdAssignment_3"


    // $ANTLR start "rule__Mediafile__LocationAssignment_5"
    // InternalPlaylist.g:517:1: rule__Mediafile__LocationAssignment_5 : ( RULE_STRING ) ;
    public final void rule__Mediafile__LocationAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPlaylist.g:521:1: ( ( RULE_STRING ) )
            // InternalPlaylist.g:522:2: ( RULE_STRING )
            {
            // InternalPlaylist.g:522:2: ( RULE_STRING )
            // InternalPlaylist.g:523:3: RULE_STRING
            {
             before(grammarAccess.getMediafileAccess().getLocationSTRINGTerminalRuleCall_5_0()); 
            match(input,RULE_STRING,FOLLOW_2); 
             after(grammarAccess.getMediafileAccess().getLocationSTRINGTerminalRuleCall_5_0()); 

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
    // $ANTLR end "rule__Mediafile__LocationAssignment_5"


    // $ANTLR start "rule__Mediafile__DurationAssignment_7"
    // InternalPlaylist.g:532:1: rule__Mediafile__DurationAssignment_7 : ( RULE_FLOAT ) ;
    public final void rule__Mediafile__DurationAssignment_7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPlaylist.g:536:1: ( ( RULE_FLOAT ) )
            // InternalPlaylist.g:537:2: ( RULE_FLOAT )
            {
            // InternalPlaylist.g:537:2: ( RULE_FLOAT )
            // InternalPlaylist.g:538:3: RULE_FLOAT
            {
             before(grammarAccess.getMediafileAccess().getDurationFLOATTerminalRuleCall_7_0()); 
            match(input,RULE_FLOAT,FOLLOW_2); 
             after(grammarAccess.getMediafileAccess().getDurationFLOATTerminalRuleCall_7_0()); 

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
    // $ANTLR end "rule__Mediafile__DurationAssignment_7"

    // Delegated rules


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000000080L});

}