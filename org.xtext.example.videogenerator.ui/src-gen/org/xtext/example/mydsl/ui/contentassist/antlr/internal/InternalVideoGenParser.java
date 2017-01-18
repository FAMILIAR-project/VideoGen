package org.xtext.example.mydsl.ui.contentassist.antlr.internal; 

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.DFA;
import org.xtext.example.mydsl.services.VideoGenGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalVideoGenParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_LEFT_BRACKET", "RULE_RIGHT_BRACKET", "RULE_STRING", "RULE_ID", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'VideoGen'", "'@author'", "'@version'", "'@creation'", "'mandatory'", "'optional'", "'alternatives'", "'videoseq'", "'duration'", "'probability'", "'size'", "'description'", "'filters'"
    };
    public static final int RULE_STRING=6;
    public static final int RULE_SL_COMMENT=10;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int RULE_RIGHT_BRACKET=5;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int EOF=-1;
    public static final int RULE_ID=7;
    public static final int RULE_WS=11;
    public static final int RULE_LEFT_BRACKET=4;
    public static final int RULE_ANY_OTHER=12;
    public static final int RULE_INT=8;
    public static final int T__22=22;
    public static final int RULE_ML_COMMENT=9;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__20=20;
    public static final int T__21=21;

    // delegates
    // delegators


        public InternalVideoGenParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalVideoGenParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalVideoGenParser.tokenNames; }
    public String getGrammarFileName() { return "InternalVideoGen.g"; }


     
     	private VideoGenGrammarAccess grammarAccess;
     	
        public void setGrammarAccess(VideoGenGrammarAccess grammarAccess) {
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




    // $ANTLR start "entryRuleVideoGeneratorModel"
    // InternalVideoGen.g:60:1: entryRuleVideoGeneratorModel : ruleVideoGeneratorModel EOF ;
    public final void entryRuleVideoGeneratorModel() throws RecognitionException {
        try {
            // InternalVideoGen.g:61:1: ( ruleVideoGeneratorModel EOF )
            // InternalVideoGen.g:62:1: ruleVideoGeneratorModel EOF
            {
             before(grammarAccess.getVideoGeneratorModelRule()); 
            pushFollow(FOLLOW_1);
            ruleVideoGeneratorModel();

            state._fsp--;

             after(grammarAccess.getVideoGeneratorModelRule()); 
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
    // $ANTLR end "entryRuleVideoGeneratorModel"


    // $ANTLR start "ruleVideoGeneratorModel"
    // InternalVideoGen.g:69:1: ruleVideoGeneratorModel : ( ( rule__VideoGeneratorModel__Group__0 ) ) ;
    public final void ruleVideoGeneratorModel() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:73:2: ( ( ( rule__VideoGeneratorModel__Group__0 ) ) )
            // InternalVideoGen.g:74:1: ( ( rule__VideoGeneratorModel__Group__0 ) )
            {
            // InternalVideoGen.g:74:1: ( ( rule__VideoGeneratorModel__Group__0 ) )
            // InternalVideoGen.g:75:1: ( rule__VideoGeneratorModel__Group__0 )
            {
             before(grammarAccess.getVideoGeneratorModelAccess().getGroup()); 
            // InternalVideoGen.g:76:1: ( rule__VideoGeneratorModel__Group__0 )
            // InternalVideoGen.g:76:2: rule__VideoGeneratorModel__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__VideoGeneratorModel__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getVideoGeneratorModelAccess().getGroup()); 

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
    // $ANTLR end "ruleVideoGeneratorModel"


    // $ANTLR start "entryRuleVideoGenInformation"
    // InternalVideoGen.g:88:1: entryRuleVideoGenInformation : ruleVideoGenInformation EOF ;
    public final void entryRuleVideoGenInformation() throws RecognitionException {
        try {
            // InternalVideoGen.g:89:1: ( ruleVideoGenInformation EOF )
            // InternalVideoGen.g:90:1: ruleVideoGenInformation EOF
            {
             before(grammarAccess.getVideoGenInformationRule()); 
            pushFollow(FOLLOW_1);
            ruleVideoGenInformation();

            state._fsp--;

             after(grammarAccess.getVideoGenInformationRule()); 
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
    // $ANTLR end "entryRuleVideoGenInformation"


    // $ANTLR start "ruleVideoGenInformation"
    // InternalVideoGen.g:97:1: ruleVideoGenInformation : ( ( rule__VideoGenInformation__Group__0 ) ) ;
    public final void ruleVideoGenInformation() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:101:2: ( ( ( rule__VideoGenInformation__Group__0 ) ) )
            // InternalVideoGen.g:102:1: ( ( rule__VideoGenInformation__Group__0 ) )
            {
            // InternalVideoGen.g:102:1: ( ( rule__VideoGenInformation__Group__0 ) )
            // InternalVideoGen.g:103:1: ( rule__VideoGenInformation__Group__0 )
            {
             before(grammarAccess.getVideoGenInformationAccess().getGroup()); 
            // InternalVideoGen.g:104:1: ( rule__VideoGenInformation__Group__0 )
            // InternalVideoGen.g:104:2: rule__VideoGenInformation__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__VideoGenInformation__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getVideoGenInformationAccess().getGroup()); 

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
    // $ANTLR end "ruleVideoGenInformation"


    // $ANTLR start "entryRuleVideoSeq"
    // InternalVideoGen.g:116:1: entryRuleVideoSeq : ruleVideoSeq EOF ;
    public final void entryRuleVideoSeq() throws RecognitionException {
        try {
            // InternalVideoGen.g:117:1: ( ruleVideoSeq EOF )
            // InternalVideoGen.g:118:1: ruleVideoSeq EOF
            {
             before(grammarAccess.getVideoSeqRule()); 
            pushFollow(FOLLOW_1);
            ruleVideoSeq();

            state._fsp--;

             after(grammarAccess.getVideoSeqRule()); 
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
    // $ANTLR end "entryRuleVideoSeq"


    // $ANTLR start "ruleVideoSeq"
    // InternalVideoGen.g:125:1: ruleVideoSeq : ( ( rule__VideoSeq__Alternatives ) ) ;
    public final void ruleVideoSeq() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:129:2: ( ( ( rule__VideoSeq__Alternatives ) ) )
            // InternalVideoGen.g:130:1: ( ( rule__VideoSeq__Alternatives ) )
            {
            // InternalVideoGen.g:130:1: ( ( rule__VideoSeq__Alternatives ) )
            // InternalVideoGen.g:131:1: ( rule__VideoSeq__Alternatives )
            {
             before(grammarAccess.getVideoSeqAccess().getAlternatives()); 
            // InternalVideoGen.g:132:1: ( rule__VideoSeq__Alternatives )
            // InternalVideoGen.g:132:2: rule__VideoSeq__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__VideoSeq__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getVideoSeqAccess().getAlternatives()); 

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
    // $ANTLR end "ruleVideoSeq"


    // $ANTLR start "entryRuleMandatoryVideoSeq"
    // InternalVideoGen.g:144:1: entryRuleMandatoryVideoSeq : ruleMandatoryVideoSeq EOF ;
    public final void entryRuleMandatoryVideoSeq() throws RecognitionException {
        try {
            // InternalVideoGen.g:145:1: ( ruleMandatoryVideoSeq EOF )
            // InternalVideoGen.g:146:1: ruleMandatoryVideoSeq EOF
            {
             before(grammarAccess.getMandatoryVideoSeqRule()); 
            pushFollow(FOLLOW_1);
            ruleMandatoryVideoSeq();

            state._fsp--;

             after(grammarAccess.getMandatoryVideoSeqRule()); 
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
    // $ANTLR end "entryRuleMandatoryVideoSeq"


    // $ANTLR start "ruleMandatoryVideoSeq"
    // InternalVideoGen.g:153:1: ruleMandatoryVideoSeq : ( ( rule__MandatoryVideoSeq__Group__0 ) ) ;
    public final void ruleMandatoryVideoSeq() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:157:2: ( ( ( rule__MandatoryVideoSeq__Group__0 ) ) )
            // InternalVideoGen.g:158:1: ( ( rule__MandatoryVideoSeq__Group__0 ) )
            {
            // InternalVideoGen.g:158:1: ( ( rule__MandatoryVideoSeq__Group__0 ) )
            // InternalVideoGen.g:159:1: ( rule__MandatoryVideoSeq__Group__0 )
            {
             before(grammarAccess.getMandatoryVideoSeqAccess().getGroup()); 
            // InternalVideoGen.g:160:1: ( rule__MandatoryVideoSeq__Group__0 )
            // InternalVideoGen.g:160:2: rule__MandatoryVideoSeq__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__MandatoryVideoSeq__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getMandatoryVideoSeqAccess().getGroup()); 

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
    // $ANTLR end "ruleMandatoryVideoSeq"


    // $ANTLR start "entryRuleOptionalVideoSeq"
    // InternalVideoGen.g:172:1: entryRuleOptionalVideoSeq : ruleOptionalVideoSeq EOF ;
    public final void entryRuleOptionalVideoSeq() throws RecognitionException {
        try {
            // InternalVideoGen.g:173:1: ( ruleOptionalVideoSeq EOF )
            // InternalVideoGen.g:174:1: ruleOptionalVideoSeq EOF
            {
             before(grammarAccess.getOptionalVideoSeqRule()); 
            pushFollow(FOLLOW_1);
            ruleOptionalVideoSeq();

            state._fsp--;

             after(grammarAccess.getOptionalVideoSeqRule()); 
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
    // $ANTLR end "entryRuleOptionalVideoSeq"


    // $ANTLR start "ruleOptionalVideoSeq"
    // InternalVideoGen.g:181:1: ruleOptionalVideoSeq : ( ( rule__OptionalVideoSeq__Group__0 ) ) ;
    public final void ruleOptionalVideoSeq() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:185:2: ( ( ( rule__OptionalVideoSeq__Group__0 ) ) )
            // InternalVideoGen.g:186:1: ( ( rule__OptionalVideoSeq__Group__0 ) )
            {
            // InternalVideoGen.g:186:1: ( ( rule__OptionalVideoSeq__Group__0 ) )
            // InternalVideoGen.g:187:1: ( rule__OptionalVideoSeq__Group__0 )
            {
             before(grammarAccess.getOptionalVideoSeqAccess().getGroup()); 
            // InternalVideoGen.g:188:1: ( rule__OptionalVideoSeq__Group__0 )
            // InternalVideoGen.g:188:2: rule__OptionalVideoSeq__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__OptionalVideoSeq__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getOptionalVideoSeqAccess().getGroup()); 

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
    // $ANTLR end "ruleOptionalVideoSeq"


    // $ANTLR start "entryRuleAlternativeVideoSeq"
    // InternalVideoGen.g:200:1: entryRuleAlternativeVideoSeq : ruleAlternativeVideoSeq EOF ;
    public final void entryRuleAlternativeVideoSeq() throws RecognitionException {
        try {
            // InternalVideoGen.g:201:1: ( ruleAlternativeVideoSeq EOF )
            // InternalVideoGen.g:202:1: ruleAlternativeVideoSeq EOF
            {
             before(grammarAccess.getAlternativeVideoSeqRule()); 
            pushFollow(FOLLOW_1);
            ruleAlternativeVideoSeq();

            state._fsp--;

             after(grammarAccess.getAlternativeVideoSeqRule()); 
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
    // $ANTLR end "entryRuleAlternativeVideoSeq"


    // $ANTLR start "ruleAlternativeVideoSeq"
    // InternalVideoGen.g:209:1: ruleAlternativeVideoSeq : ( ( rule__AlternativeVideoSeq__Group__0 ) ) ;
    public final void ruleAlternativeVideoSeq() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:213:2: ( ( ( rule__AlternativeVideoSeq__Group__0 ) ) )
            // InternalVideoGen.g:214:1: ( ( rule__AlternativeVideoSeq__Group__0 ) )
            {
            // InternalVideoGen.g:214:1: ( ( rule__AlternativeVideoSeq__Group__0 ) )
            // InternalVideoGen.g:215:1: ( rule__AlternativeVideoSeq__Group__0 )
            {
             before(grammarAccess.getAlternativeVideoSeqAccess().getGroup()); 
            // InternalVideoGen.g:216:1: ( rule__AlternativeVideoSeq__Group__0 )
            // InternalVideoGen.g:216:2: rule__AlternativeVideoSeq__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__AlternativeVideoSeq__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getAlternativeVideoSeqAccess().getGroup()); 

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
    // $ANTLR end "ruleAlternativeVideoSeq"


    // $ANTLR start "entryRuleVideoDescription"
    // InternalVideoGen.g:228:1: entryRuleVideoDescription : ruleVideoDescription EOF ;
    public final void entryRuleVideoDescription() throws RecognitionException {
        try {
            // InternalVideoGen.g:229:1: ( ruleVideoDescription EOF )
            // InternalVideoGen.g:230:1: ruleVideoDescription EOF
            {
             before(grammarAccess.getVideoDescriptionRule()); 
            pushFollow(FOLLOW_1);
            ruleVideoDescription();

            state._fsp--;

             after(grammarAccess.getVideoDescriptionRule()); 
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
    // $ANTLR end "entryRuleVideoDescription"


    // $ANTLR start "ruleVideoDescription"
    // InternalVideoGen.g:237:1: ruleVideoDescription : ( ( rule__VideoDescription__Group__0 ) ) ;
    public final void ruleVideoDescription() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:241:2: ( ( ( rule__VideoDescription__Group__0 ) ) )
            // InternalVideoGen.g:242:1: ( ( rule__VideoDescription__Group__0 ) )
            {
            // InternalVideoGen.g:242:1: ( ( rule__VideoDescription__Group__0 ) )
            // InternalVideoGen.g:243:1: ( rule__VideoDescription__Group__0 )
            {
             before(grammarAccess.getVideoDescriptionAccess().getGroup()); 
            // InternalVideoGen.g:244:1: ( rule__VideoDescription__Group__0 )
            // InternalVideoGen.g:244:2: rule__VideoDescription__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__VideoDescription__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getVideoDescriptionAccess().getGroup()); 

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
    // $ANTLR end "ruleVideoDescription"


    // $ANTLR start "entryRuleFilter"
    // InternalVideoGen.g:256:1: entryRuleFilter : ruleFilter EOF ;
    public final void entryRuleFilter() throws RecognitionException {
        try {
            // InternalVideoGen.g:257:1: ( ruleFilter EOF )
            // InternalVideoGen.g:258:1: ruleFilter EOF
            {
             before(grammarAccess.getFilterRule()); 
            pushFollow(FOLLOW_1);
            ruleFilter();

            state._fsp--;

             after(grammarAccess.getFilterRule()); 
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
    // $ANTLR end "entryRuleFilter"


    // $ANTLR start "ruleFilter"
    // InternalVideoGen.g:265:1: ruleFilter : ( ( rule__Filter__Group__0 ) ) ;
    public final void ruleFilter() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:269:2: ( ( ( rule__Filter__Group__0 ) ) )
            // InternalVideoGen.g:270:1: ( ( rule__Filter__Group__0 ) )
            {
            // InternalVideoGen.g:270:1: ( ( rule__Filter__Group__0 ) )
            // InternalVideoGen.g:271:1: ( rule__Filter__Group__0 )
            {
             before(grammarAccess.getFilterAccess().getGroup()); 
            // InternalVideoGen.g:272:1: ( rule__Filter__Group__0 )
            // InternalVideoGen.g:272:2: rule__Filter__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Filter__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getFilterAccess().getGroup()); 

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
    // $ANTLR end "ruleFilter"


    // $ANTLR start "rule__VideoSeq__Alternatives"
    // InternalVideoGen.g:284:1: rule__VideoSeq__Alternatives : ( ( ruleMandatoryVideoSeq ) | ( ruleOptionalVideoSeq ) | ( ruleAlternativeVideoSeq ) );
    public final void rule__VideoSeq__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:288:1: ( ( ruleMandatoryVideoSeq ) | ( ruleOptionalVideoSeq ) | ( ruleAlternativeVideoSeq ) )
            int alt1=3;
            switch ( input.LA(1) ) {
            case 17:
                {
                alt1=1;
                }
                break;
            case 18:
                {
                alt1=2;
                }
                break;
            case 19:
                {
                alt1=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }

            switch (alt1) {
                case 1 :
                    // InternalVideoGen.g:289:1: ( ruleMandatoryVideoSeq )
                    {
                    // InternalVideoGen.g:289:1: ( ruleMandatoryVideoSeq )
                    // InternalVideoGen.g:290:1: ruleMandatoryVideoSeq
                    {
                     before(grammarAccess.getVideoSeqAccess().getMandatoryVideoSeqParserRuleCall_0()); 
                    pushFollow(FOLLOW_2);
                    ruleMandatoryVideoSeq();

                    state._fsp--;

                     after(grammarAccess.getVideoSeqAccess().getMandatoryVideoSeqParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalVideoGen.g:295:6: ( ruleOptionalVideoSeq )
                    {
                    // InternalVideoGen.g:295:6: ( ruleOptionalVideoSeq )
                    // InternalVideoGen.g:296:1: ruleOptionalVideoSeq
                    {
                     before(grammarAccess.getVideoSeqAccess().getOptionalVideoSeqParserRuleCall_1()); 
                    pushFollow(FOLLOW_2);
                    ruleOptionalVideoSeq();

                    state._fsp--;

                     after(grammarAccess.getVideoSeqAccess().getOptionalVideoSeqParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalVideoGen.g:301:6: ( ruleAlternativeVideoSeq )
                    {
                    // InternalVideoGen.g:301:6: ( ruleAlternativeVideoSeq )
                    // InternalVideoGen.g:302:1: ruleAlternativeVideoSeq
                    {
                     before(grammarAccess.getVideoSeqAccess().getAlternativeVideoSeqParserRuleCall_2()); 
                    pushFollow(FOLLOW_2);
                    ruleAlternativeVideoSeq();

                    state._fsp--;

                     after(grammarAccess.getVideoSeqAccess().getAlternativeVideoSeqParserRuleCall_2()); 

                    }


                    }
                    break;

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
    // $ANTLR end "rule__VideoSeq__Alternatives"


    // $ANTLR start "rule__VideoGeneratorModel__Group__0"
    // InternalVideoGen.g:314:1: rule__VideoGeneratorModel__Group__0 : rule__VideoGeneratorModel__Group__0__Impl rule__VideoGeneratorModel__Group__1 ;
    public final void rule__VideoGeneratorModel__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:318:1: ( rule__VideoGeneratorModel__Group__0__Impl rule__VideoGeneratorModel__Group__1 )
            // InternalVideoGen.g:319:2: rule__VideoGeneratorModel__Group__0__Impl rule__VideoGeneratorModel__Group__1
            {
            pushFollow(FOLLOW_3);
            rule__VideoGeneratorModel__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__VideoGeneratorModel__Group__1();

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
    // $ANTLR end "rule__VideoGeneratorModel__Group__0"


    // $ANTLR start "rule__VideoGeneratorModel__Group__0__Impl"
    // InternalVideoGen.g:326:1: rule__VideoGeneratorModel__Group__0__Impl : ( () ) ;
    public final void rule__VideoGeneratorModel__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:330:1: ( ( () ) )
            // InternalVideoGen.g:331:1: ( () )
            {
            // InternalVideoGen.g:331:1: ( () )
            // InternalVideoGen.g:332:1: ()
            {
             before(grammarAccess.getVideoGeneratorModelAccess().getVideoGeneratorModelAction_0()); 
            // InternalVideoGen.g:333:1: ()
            // InternalVideoGen.g:335:1: 
            {
            }

             after(grammarAccess.getVideoGeneratorModelAccess().getVideoGeneratorModelAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VideoGeneratorModel__Group__0__Impl"


    // $ANTLR start "rule__VideoGeneratorModel__Group__1"
    // InternalVideoGen.g:345:1: rule__VideoGeneratorModel__Group__1 : rule__VideoGeneratorModel__Group__1__Impl rule__VideoGeneratorModel__Group__2 ;
    public final void rule__VideoGeneratorModel__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:349:1: ( rule__VideoGeneratorModel__Group__1__Impl rule__VideoGeneratorModel__Group__2 )
            // InternalVideoGen.g:350:2: rule__VideoGeneratorModel__Group__1__Impl rule__VideoGeneratorModel__Group__2
            {
            pushFollow(FOLLOW_3);
            rule__VideoGeneratorModel__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__VideoGeneratorModel__Group__2();

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
    // $ANTLR end "rule__VideoGeneratorModel__Group__1"


    // $ANTLR start "rule__VideoGeneratorModel__Group__1__Impl"
    // InternalVideoGen.g:357:1: rule__VideoGeneratorModel__Group__1__Impl : ( ( rule__VideoGeneratorModel__InformationAssignment_1 )? ) ;
    public final void rule__VideoGeneratorModel__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:361:1: ( ( ( rule__VideoGeneratorModel__InformationAssignment_1 )? ) )
            // InternalVideoGen.g:362:1: ( ( rule__VideoGeneratorModel__InformationAssignment_1 )? )
            {
            // InternalVideoGen.g:362:1: ( ( rule__VideoGeneratorModel__InformationAssignment_1 )? )
            // InternalVideoGen.g:363:1: ( rule__VideoGeneratorModel__InformationAssignment_1 )?
            {
             before(grammarAccess.getVideoGeneratorModelAccess().getInformationAssignment_1()); 
            // InternalVideoGen.g:364:1: ( rule__VideoGeneratorModel__InformationAssignment_1 )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==14) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // InternalVideoGen.g:364:2: rule__VideoGeneratorModel__InformationAssignment_1
                    {
                    pushFollow(FOLLOW_2);
                    rule__VideoGeneratorModel__InformationAssignment_1();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getVideoGeneratorModelAccess().getInformationAssignment_1()); 

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
    // $ANTLR end "rule__VideoGeneratorModel__Group__1__Impl"


    // $ANTLR start "rule__VideoGeneratorModel__Group__2"
    // InternalVideoGen.g:374:1: rule__VideoGeneratorModel__Group__2 : rule__VideoGeneratorModel__Group__2__Impl rule__VideoGeneratorModel__Group__3 ;
    public final void rule__VideoGeneratorModel__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:378:1: ( rule__VideoGeneratorModel__Group__2__Impl rule__VideoGeneratorModel__Group__3 )
            // InternalVideoGen.g:379:2: rule__VideoGeneratorModel__Group__2__Impl rule__VideoGeneratorModel__Group__3
            {
            pushFollow(FOLLOW_4);
            rule__VideoGeneratorModel__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__VideoGeneratorModel__Group__3();

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
    // $ANTLR end "rule__VideoGeneratorModel__Group__2"


    // $ANTLR start "rule__VideoGeneratorModel__Group__2__Impl"
    // InternalVideoGen.g:386:1: rule__VideoGeneratorModel__Group__2__Impl : ( 'VideoGen' ) ;
    public final void rule__VideoGeneratorModel__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:390:1: ( ( 'VideoGen' ) )
            // InternalVideoGen.g:391:1: ( 'VideoGen' )
            {
            // InternalVideoGen.g:391:1: ( 'VideoGen' )
            // InternalVideoGen.g:392:1: 'VideoGen'
            {
             before(grammarAccess.getVideoGeneratorModelAccess().getVideoGenKeyword_2()); 
            match(input,13,FOLLOW_2); 
             after(grammarAccess.getVideoGeneratorModelAccess().getVideoGenKeyword_2()); 

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
    // $ANTLR end "rule__VideoGeneratorModel__Group__2__Impl"


    // $ANTLR start "rule__VideoGeneratorModel__Group__3"
    // InternalVideoGen.g:405:1: rule__VideoGeneratorModel__Group__3 : rule__VideoGeneratorModel__Group__3__Impl rule__VideoGeneratorModel__Group__4 ;
    public final void rule__VideoGeneratorModel__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:409:1: ( rule__VideoGeneratorModel__Group__3__Impl rule__VideoGeneratorModel__Group__4 )
            // InternalVideoGen.g:410:2: rule__VideoGeneratorModel__Group__3__Impl rule__VideoGeneratorModel__Group__4
            {
            pushFollow(FOLLOW_5);
            rule__VideoGeneratorModel__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__VideoGeneratorModel__Group__4();

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
    // $ANTLR end "rule__VideoGeneratorModel__Group__3"


    // $ANTLR start "rule__VideoGeneratorModel__Group__3__Impl"
    // InternalVideoGen.g:417:1: rule__VideoGeneratorModel__Group__3__Impl : ( RULE_LEFT_BRACKET ) ;
    public final void rule__VideoGeneratorModel__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:421:1: ( ( RULE_LEFT_BRACKET ) )
            // InternalVideoGen.g:422:1: ( RULE_LEFT_BRACKET )
            {
            // InternalVideoGen.g:422:1: ( RULE_LEFT_BRACKET )
            // InternalVideoGen.g:423:1: RULE_LEFT_BRACKET
            {
             before(grammarAccess.getVideoGeneratorModelAccess().getLEFT_BRACKETTerminalRuleCall_3()); 
            match(input,RULE_LEFT_BRACKET,FOLLOW_2); 
             after(grammarAccess.getVideoGeneratorModelAccess().getLEFT_BRACKETTerminalRuleCall_3()); 

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
    // $ANTLR end "rule__VideoGeneratorModel__Group__3__Impl"


    // $ANTLR start "rule__VideoGeneratorModel__Group__4"
    // InternalVideoGen.g:434:1: rule__VideoGeneratorModel__Group__4 : rule__VideoGeneratorModel__Group__4__Impl rule__VideoGeneratorModel__Group__5 ;
    public final void rule__VideoGeneratorModel__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:438:1: ( rule__VideoGeneratorModel__Group__4__Impl rule__VideoGeneratorModel__Group__5 )
            // InternalVideoGen.g:439:2: rule__VideoGeneratorModel__Group__4__Impl rule__VideoGeneratorModel__Group__5
            {
            pushFollow(FOLLOW_6);
            rule__VideoGeneratorModel__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__VideoGeneratorModel__Group__5();

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
    // $ANTLR end "rule__VideoGeneratorModel__Group__4"


    // $ANTLR start "rule__VideoGeneratorModel__Group__4__Impl"
    // InternalVideoGen.g:446:1: rule__VideoGeneratorModel__Group__4__Impl : ( ( ( rule__VideoGeneratorModel__VideoseqsAssignment_4 ) ) ( ( rule__VideoGeneratorModel__VideoseqsAssignment_4 )* ) ) ;
    public final void rule__VideoGeneratorModel__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:450:1: ( ( ( ( rule__VideoGeneratorModel__VideoseqsAssignment_4 ) ) ( ( rule__VideoGeneratorModel__VideoseqsAssignment_4 )* ) ) )
            // InternalVideoGen.g:451:1: ( ( ( rule__VideoGeneratorModel__VideoseqsAssignment_4 ) ) ( ( rule__VideoGeneratorModel__VideoseqsAssignment_4 )* ) )
            {
            // InternalVideoGen.g:451:1: ( ( ( rule__VideoGeneratorModel__VideoseqsAssignment_4 ) ) ( ( rule__VideoGeneratorModel__VideoseqsAssignment_4 )* ) )
            // InternalVideoGen.g:452:1: ( ( rule__VideoGeneratorModel__VideoseqsAssignment_4 ) ) ( ( rule__VideoGeneratorModel__VideoseqsAssignment_4 )* )
            {
            // InternalVideoGen.g:452:1: ( ( rule__VideoGeneratorModel__VideoseqsAssignment_4 ) )
            // InternalVideoGen.g:453:1: ( rule__VideoGeneratorModel__VideoseqsAssignment_4 )
            {
             before(grammarAccess.getVideoGeneratorModelAccess().getVideoseqsAssignment_4()); 
            // InternalVideoGen.g:454:1: ( rule__VideoGeneratorModel__VideoseqsAssignment_4 )
            // InternalVideoGen.g:454:2: rule__VideoGeneratorModel__VideoseqsAssignment_4
            {
            pushFollow(FOLLOW_7);
            rule__VideoGeneratorModel__VideoseqsAssignment_4();

            state._fsp--;


            }

             after(grammarAccess.getVideoGeneratorModelAccess().getVideoseqsAssignment_4()); 

            }

            // InternalVideoGen.g:457:1: ( ( rule__VideoGeneratorModel__VideoseqsAssignment_4 )* )
            // InternalVideoGen.g:458:1: ( rule__VideoGeneratorModel__VideoseqsAssignment_4 )*
            {
             before(grammarAccess.getVideoGeneratorModelAccess().getVideoseqsAssignment_4()); 
            // InternalVideoGen.g:459:1: ( rule__VideoGeneratorModel__VideoseqsAssignment_4 )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0>=17 && LA3_0<=19)) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // InternalVideoGen.g:459:2: rule__VideoGeneratorModel__VideoseqsAssignment_4
            	    {
            	    pushFollow(FOLLOW_7);
            	    rule__VideoGeneratorModel__VideoseqsAssignment_4();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

             after(grammarAccess.getVideoGeneratorModelAccess().getVideoseqsAssignment_4()); 

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
    // $ANTLR end "rule__VideoGeneratorModel__Group__4__Impl"


    // $ANTLR start "rule__VideoGeneratorModel__Group__5"
    // InternalVideoGen.g:470:1: rule__VideoGeneratorModel__Group__5 : rule__VideoGeneratorModel__Group__5__Impl ;
    public final void rule__VideoGeneratorModel__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:474:1: ( rule__VideoGeneratorModel__Group__5__Impl )
            // InternalVideoGen.g:475:2: rule__VideoGeneratorModel__Group__5__Impl
            {
            pushFollow(FOLLOW_2);
            rule__VideoGeneratorModel__Group__5__Impl();

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
    // $ANTLR end "rule__VideoGeneratorModel__Group__5"


    // $ANTLR start "rule__VideoGeneratorModel__Group__5__Impl"
    // InternalVideoGen.g:481:1: rule__VideoGeneratorModel__Group__5__Impl : ( RULE_RIGHT_BRACKET ) ;
    public final void rule__VideoGeneratorModel__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:485:1: ( ( RULE_RIGHT_BRACKET ) )
            // InternalVideoGen.g:486:1: ( RULE_RIGHT_BRACKET )
            {
            // InternalVideoGen.g:486:1: ( RULE_RIGHT_BRACKET )
            // InternalVideoGen.g:487:1: RULE_RIGHT_BRACKET
            {
             before(grammarAccess.getVideoGeneratorModelAccess().getRIGHT_BRACKETTerminalRuleCall_5()); 
            match(input,RULE_RIGHT_BRACKET,FOLLOW_2); 
             after(grammarAccess.getVideoGeneratorModelAccess().getRIGHT_BRACKETTerminalRuleCall_5()); 

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
    // $ANTLR end "rule__VideoGeneratorModel__Group__5__Impl"


    // $ANTLR start "rule__VideoGenInformation__Group__0"
    // InternalVideoGen.g:510:1: rule__VideoGenInformation__Group__0 : rule__VideoGenInformation__Group__0__Impl rule__VideoGenInformation__Group__1 ;
    public final void rule__VideoGenInformation__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:514:1: ( rule__VideoGenInformation__Group__0__Impl rule__VideoGenInformation__Group__1 )
            // InternalVideoGen.g:515:2: rule__VideoGenInformation__Group__0__Impl rule__VideoGenInformation__Group__1
            {
            pushFollow(FOLLOW_8);
            rule__VideoGenInformation__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__VideoGenInformation__Group__1();

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
    // $ANTLR end "rule__VideoGenInformation__Group__0"


    // $ANTLR start "rule__VideoGenInformation__Group__0__Impl"
    // InternalVideoGen.g:522:1: rule__VideoGenInformation__Group__0__Impl : ( () ) ;
    public final void rule__VideoGenInformation__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:526:1: ( ( () ) )
            // InternalVideoGen.g:527:1: ( () )
            {
            // InternalVideoGen.g:527:1: ( () )
            // InternalVideoGen.g:528:1: ()
            {
             before(grammarAccess.getVideoGenInformationAccess().getVideoGenInformationAction_0()); 
            // InternalVideoGen.g:529:1: ()
            // InternalVideoGen.g:531:1: 
            {
            }

             after(grammarAccess.getVideoGenInformationAccess().getVideoGenInformationAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VideoGenInformation__Group__0__Impl"


    // $ANTLR start "rule__VideoGenInformation__Group__1"
    // InternalVideoGen.g:541:1: rule__VideoGenInformation__Group__1 : rule__VideoGenInformation__Group__1__Impl rule__VideoGenInformation__Group__2 ;
    public final void rule__VideoGenInformation__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:545:1: ( rule__VideoGenInformation__Group__1__Impl rule__VideoGenInformation__Group__2 )
            // InternalVideoGen.g:546:2: rule__VideoGenInformation__Group__1__Impl rule__VideoGenInformation__Group__2
            {
            pushFollow(FOLLOW_9);
            rule__VideoGenInformation__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__VideoGenInformation__Group__2();

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
    // $ANTLR end "rule__VideoGenInformation__Group__1"


    // $ANTLR start "rule__VideoGenInformation__Group__1__Impl"
    // InternalVideoGen.g:553:1: rule__VideoGenInformation__Group__1__Impl : ( ( rule__VideoGenInformation__Group_1__0 ) ) ;
    public final void rule__VideoGenInformation__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:557:1: ( ( ( rule__VideoGenInformation__Group_1__0 ) ) )
            // InternalVideoGen.g:558:1: ( ( rule__VideoGenInformation__Group_1__0 ) )
            {
            // InternalVideoGen.g:558:1: ( ( rule__VideoGenInformation__Group_1__0 ) )
            // InternalVideoGen.g:559:1: ( rule__VideoGenInformation__Group_1__0 )
            {
             before(grammarAccess.getVideoGenInformationAccess().getGroup_1()); 
            // InternalVideoGen.g:560:1: ( rule__VideoGenInformation__Group_1__0 )
            // InternalVideoGen.g:560:2: rule__VideoGenInformation__Group_1__0
            {
            pushFollow(FOLLOW_2);
            rule__VideoGenInformation__Group_1__0();

            state._fsp--;


            }

             after(grammarAccess.getVideoGenInformationAccess().getGroup_1()); 

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
    // $ANTLR end "rule__VideoGenInformation__Group__1__Impl"


    // $ANTLR start "rule__VideoGenInformation__Group__2"
    // InternalVideoGen.g:570:1: rule__VideoGenInformation__Group__2 : rule__VideoGenInformation__Group__2__Impl rule__VideoGenInformation__Group__3 ;
    public final void rule__VideoGenInformation__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:574:1: ( rule__VideoGenInformation__Group__2__Impl rule__VideoGenInformation__Group__3 )
            // InternalVideoGen.g:575:2: rule__VideoGenInformation__Group__2__Impl rule__VideoGenInformation__Group__3
            {
            pushFollow(FOLLOW_9);
            rule__VideoGenInformation__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__VideoGenInformation__Group__3();

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
    // $ANTLR end "rule__VideoGenInformation__Group__2"


    // $ANTLR start "rule__VideoGenInformation__Group__2__Impl"
    // InternalVideoGen.g:582:1: rule__VideoGenInformation__Group__2__Impl : ( ( rule__VideoGenInformation__Group_2__0 )? ) ;
    public final void rule__VideoGenInformation__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:586:1: ( ( ( rule__VideoGenInformation__Group_2__0 )? ) )
            // InternalVideoGen.g:587:1: ( ( rule__VideoGenInformation__Group_2__0 )? )
            {
            // InternalVideoGen.g:587:1: ( ( rule__VideoGenInformation__Group_2__0 )? )
            // InternalVideoGen.g:588:1: ( rule__VideoGenInformation__Group_2__0 )?
            {
             before(grammarAccess.getVideoGenInformationAccess().getGroup_2()); 
            // InternalVideoGen.g:589:1: ( rule__VideoGenInformation__Group_2__0 )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==15) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // InternalVideoGen.g:589:2: rule__VideoGenInformation__Group_2__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__VideoGenInformation__Group_2__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getVideoGenInformationAccess().getGroup_2()); 

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
    // $ANTLR end "rule__VideoGenInformation__Group__2__Impl"


    // $ANTLR start "rule__VideoGenInformation__Group__3"
    // InternalVideoGen.g:599:1: rule__VideoGenInformation__Group__3 : rule__VideoGenInformation__Group__3__Impl ;
    public final void rule__VideoGenInformation__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:603:1: ( rule__VideoGenInformation__Group__3__Impl )
            // InternalVideoGen.g:604:2: rule__VideoGenInformation__Group__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__VideoGenInformation__Group__3__Impl();

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
    // $ANTLR end "rule__VideoGenInformation__Group__3"


    // $ANTLR start "rule__VideoGenInformation__Group__3__Impl"
    // InternalVideoGen.g:610:1: rule__VideoGenInformation__Group__3__Impl : ( ( rule__VideoGenInformation__Group_3__0 )? ) ;
    public final void rule__VideoGenInformation__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:614:1: ( ( ( rule__VideoGenInformation__Group_3__0 )? ) )
            // InternalVideoGen.g:615:1: ( ( rule__VideoGenInformation__Group_3__0 )? )
            {
            // InternalVideoGen.g:615:1: ( ( rule__VideoGenInformation__Group_3__0 )? )
            // InternalVideoGen.g:616:1: ( rule__VideoGenInformation__Group_3__0 )?
            {
             before(grammarAccess.getVideoGenInformationAccess().getGroup_3()); 
            // InternalVideoGen.g:617:1: ( rule__VideoGenInformation__Group_3__0 )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==16) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // InternalVideoGen.g:617:2: rule__VideoGenInformation__Group_3__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__VideoGenInformation__Group_3__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getVideoGenInformationAccess().getGroup_3()); 

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
    // $ANTLR end "rule__VideoGenInformation__Group__3__Impl"


    // $ANTLR start "rule__VideoGenInformation__Group_1__0"
    // InternalVideoGen.g:635:1: rule__VideoGenInformation__Group_1__0 : rule__VideoGenInformation__Group_1__0__Impl rule__VideoGenInformation__Group_1__1 ;
    public final void rule__VideoGenInformation__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:639:1: ( rule__VideoGenInformation__Group_1__0__Impl rule__VideoGenInformation__Group_1__1 )
            // InternalVideoGen.g:640:2: rule__VideoGenInformation__Group_1__0__Impl rule__VideoGenInformation__Group_1__1
            {
            pushFollow(FOLLOW_10);
            rule__VideoGenInformation__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__VideoGenInformation__Group_1__1();

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
    // $ANTLR end "rule__VideoGenInformation__Group_1__0"


    // $ANTLR start "rule__VideoGenInformation__Group_1__0__Impl"
    // InternalVideoGen.g:647:1: rule__VideoGenInformation__Group_1__0__Impl : ( '@author' ) ;
    public final void rule__VideoGenInformation__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:651:1: ( ( '@author' ) )
            // InternalVideoGen.g:652:1: ( '@author' )
            {
            // InternalVideoGen.g:652:1: ( '@author' )
            // InternalVideoGen.g:653:1: '@author'
            {
             before(grammarAccess.getVideoGenInformationAccess().getAuthorKeyword_1_0()); 
            match(input,14,FOLLOW_2); 
             after(grammarAccess.getVideoGenInformationAccess().getAuthorKeyword_1_0()); 

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
    // $ANTLR end "rule__VideoGenInformation__Group_1__0__Impl"


    // $ANTLR start "rule__VideoGenInformation__Group_1__1"
    // InternalVideoGen.g:666:1: rule__VideoGenInformation__Group_1__1 : rule__VideoGenInformation__Group_1__1__Impl ;
    public final void rule__VideoGenInformation__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:670:1: ( rule__VideoGenInformation__Group_1__1__Impl )
            // InternalVideoGen.g:671:2: rule__VideoGenInformation__Group_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__VideoGenInformation__Group_1__1__Impl();

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
    // $ANTLR end "rule__VideoGenInformation__Group_1__1"


    // $ANTLR start "rule__VideoGenInformation__Group_1__1__Impl"
    // InternalVideoGen.g:677:1: rule__VideoGenInformation__Group_1__1__Impl : ( ( rule__VideoGenInformation__AuthorNameAssignment_1_1 ) ) ;
    public final void rule__VideoGenInformation__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:681:1: ( ( ( rule__VideoGenInformation__AuthorNameAssignment_1_1 ) ) )
            // InternalVideoGen.g:682:1: ( ( rule__VideoGenInformation__AuthorNameAssignment_1_1 ) )
            {
            // InternalVideoGen.g:682:1: ( ( rule__VideoGenInformation__AuthorNameAssignment_1_1 ) )
            // InternalVideoGen.g:683:1: ( rule__VideoGenInformation__AuthorNameAssignment_1_1 )
            {
             before(grammarAccess.getVideoGenInformationAccess().getAuthorNameAssignment_1_1()); 
            // InternalVideoGen.g:684:1: ( rule__VideoGenInformation__AuthorNameAssignment_1_1 )
            // InternalVideoGen.g:684:2: rule__VideoGenInformation__AuthorNameAssignment_1_1
            {
            pushFollow(FOLLOW_2);
            rule__VideoGenInformation__AuthorNameAssignment_1_1();

            state._fsp--;


            }

             after(grammarAccess.getVideoGenInformationAccess().getAuthorNameAssignment_1_1()); 

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
    // $ANTLR end "rule__VideoGenInformation__Group_1__1__Impl"


    // $ANTLR start "rule__VideoGenInformation__Group_2__0"
    // InternalVideoGen.g:698:1: rule__VideoGenInformation__Group_2__0 : rule__VideoGenInformation__Group_2__0__Impl rule__VideoGenInformation__Group_2__1 ;
    public final void rule__VideoGenInformation__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:702:1: ( rule__VideoGenInformation__Group_2__0__Impl rule__VideoGenInformation__Group_2__1 )
            // InternalVideoGen.g:703:2: rule__VideoGenInformation__Group_2__0__Impl rule__VideoGenInformation__Group_2__1
            {
            pushFollow(FOLLOW_10);
            rule__VideoGenInformation__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__VideoGenInformation__Group_2__1();

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
    // $ANTLR end "rule__VideoGenInformation__Group_2__0"


    // $ANTLR start "rule__VideoGenInformation__Group_2__0__Impl"
    // InternalVideoGen.g:710:1: rule__VideoGenInformation__Group_2__0__Impl : ( '@version' ) ;
    public final void rule__VideoGenInformation__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:714:1: ( ( '@version' ) )
            // InternalVideoGen.g:715:1: ( '@version' )
            {
            // InternalVideoGen.g:715:1: ( '@version' )
            // InternalVideoGen.g:716:1: '@version'
            {
             before(grammarAccess.getVideoGenInformationAccess().getVersionKeyword_2_0()); 
            match(input,15,FOLLOW_2); 
             after(grammarAccess.getVideoGenInformationAccess().getVersionKeyword_2_0()); 

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
    // $ANTLR end "rule__VideoGenInformation__Group_2__0__Impl"


    // $ANTLR start "rule__VideoGenInformation__Group_2__1"
    // InternalVideoGen.g:729:1: rule__VideoGenInformation__Group_2__1 : rule__VideoGenInformation__Group_2__1__Impl ;
    public final void rule__VideoGenInformation__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:733:1: ( rule__VideoGenInformation__Group_2__1__Impl )
            // InternalVideoGen.g:734:2: rule__VideoGenInformation__Group_2__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__VideoGenInformation__Group_2__1__Impl();

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
    // $ANTLR end "rule__VideoGenInformation__Group_2__1"


    // $ANTLR start "rule__VideoGenInformation__Group_2__1__Impl"
    // InternalVideoGen.g:740:1: rule__VideoGenInformation__Group_2__1__Impl : ( ( rule__VideoGenInformation__VersionAssignment_2_1 ) ) ;
    public final void rule__VideoGenInformation__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:744:1: ( ( ( rule__VideoGenInformation__VersionAssignment_2_1 ) ) )
            // InternalVideoGen.g:745:1: ( ( rule__VideoGenInformation__VersionAssignment_2_1 ) )
            {
            // InternalVideoGen.g:745:1: ( ( rule__VideoGenInformation__VersionAssignment_2_1 ) )
            // InternalVideoGen.g:746:1: ( rule__VideoGenInformation__VersionAssignment_2_1 )
            {
             before(grammarAccess.getVideoGenInformationAccess().getVersionAssignment_2_1()); 
            // InternalVideoGen.g:747:1: ( rule__VideoGenInformation__VersionAssignment_2_1 )
            // InternalVideoGen.g:747:2: rule__VideoGenInformation__VersionAssignment_2_1
            {
            pushFollow(FOLLOW_2);
            rule__VideoGenInformation__VersionAssignment_2_1();

            state._fsp--;


            }

             after(grammarAccess.getVideoGenInformationAccess().getVersionAssignment_2_1()); 

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
    // $ANTLR end "rule__VideoGenInformation__Group_2__1__Impl"


    // $ANTLR start "rule__VideoGenInformation__Group_3__0"
    // InternalVideoGen.g:761:1: rule__VideoGenInformation__Group_3__0 : rule__VideoGenInformation__Group_3__0__Impl rule__VideoGenInformation__Group_3__1 ;
    public final void rule__VideoGenInformation__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:765:1: ( rule__VideoGenInformation__Group_3__0__Impl rule__VideoGenInformation__Group_3__1 )
            // InternalVideoGen.g:766:2: rule__VideoGenInformation__Group_3__0__Impl rule__VideoGenInformation__Group_3__1
            {
            pushFollow(FOLLOW_10);
            rule__VideoGenInformation__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__VideoGenInformation__Group_3__1();

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
    // $ANTLR end "rule__VideoGenInformation__Group_3__0"


    // $ANTLR start "rule__VideoGenInformation__Group_3__0__Impl"
    // InternalVideoGen.g:773:1: rule__VideoGenInformation__Group_3__0__Impl : ( '@creation' ) ;
    public final void rule__VideoGenInformation__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:777:1: ( ( '@creation' ) )
            // InternalVideoGen.g:778:1: ( '@creation' )
            {
            // InternalVideoGen.g:778:1: ( '@creation' )
            // InternalVideoGen.g:779:1: '@creation'
            {
             before(grammarAccess.getVideoGenInformationAccess().getCreationKeyword_3_0()); 
            match(input,16,FOLLOW_2); 
             after(grammarAccess.getVideoGenInformationAccess().getCreationKeyword_3_0()); 

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
    // $ANTLR end "rule__VideoGenInformation__Group_3__0__Impl"


    // $ANTLR start "rule__VideoGenInformation__Group_3__1"
    // InternalVideoGen.g:792:1: rule__VideoGenInformation__Group_3__1 : rule__VideoGenInformation__Group_3__1__Impl ;
    public final void rule__VideoGenInformation__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:796:1: ( rule__VideoGenInformation__Group_3__1__Impl )
            // InternalVideoGen.g:797:2: rule__VideoGenInformation__Group_3__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__VideoGenInformation__Group_3__1__Impl();

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
    // $ANTLR end "rule__VideoGenInformation__Group_3__1"


    // $ANTLR start "rule__VideoGenInformation__Group_3__1__Impl"
    // InternalVideoGen.g:803:1: rule__VideoGenInformation__Group_3__1__Impl : ( ( rule__VideoGenInformation__CreationDateAssignment_3_1 ) ) ;
    public final void rule__VideoGenInformation__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:807:1: ( ( ( rule__VideoGenInformation__CreationDateAssignment_3_1 ) ) )
            // InternalVideoGen.g:808:1: ( ( rule__VideoGenInformation__CreationDateAssignment_3_1 ) )
            {
            // InternalVideoGen.g:808:1: ( ( rule__VideoGenInformation__CreationDateAssignment_3_1 ) )
            // InternalVideoGen.g:809:1: ( rule__VideoGenInformation__CreationDateAssignment_3_1 )
            {
             before(grammarAccess.getVideoGenInformationAccess().getCreationDateAssignment_3_1()); 
            // InternalVideoGen.g:810:1: ( rule__VideoGenInformation__CreationDateAssignment_3_1 )
            // InternalVideoGen.g:810:2: rule__VideoGenInformation__CreationDateAssignment_3_1
            {
            pushFollow(FOLLOW_2);
            rule__VideoGenInformation__CreationDateAssignment_3_1();

            state._fsp--;


            }

             after(grammarAccess.getVideoGenInformationAccess().getCreationDateAssignment_3_1()); 

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
    // $ANTLR end "rule__VideoGenInformation__Group_3__1__Impl"


    // $ANTLR start "rule__MandatoryVideoSeq__Group__0"
    // InternalVideoGen.g:824:1: rule__MandatoryVideoSeq__Group__0 : rule__MandatoryVideoSeq__Group__0__Impl rule__MandatoryVideoSeq__Group__1 ;
    public final void rule__MandatoryVideoSeq__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:828:1: ( rule__MandatoryVideoSeq__Group__0__Impl rule__MandatoryVideoSeq__Group__1 )
            // InternalVideoGen.g:829:2: rule__MandatoryVideoSeq__Group__0__Impl rule__MandatoryVideoSeq__Group__1
            {
            pushFollow(FOLLOW_11);
            rule__MandatoryVideoSeq__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__MandatoryVideoSeq__Group__1();

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
    // $ANTLR end "rule__MandatoryVideoSeq__Group__0"


    // $ANTLR start "rule__MandatoryVideoSeq__Group__0__Impl"
    // InternalVideoGen.g:836:1: rule__MandatoryVideoSeq__Group__0__Impl : ( 'mandatory' ) ;
    public final void rule__MandatoryVideoSeq__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:840:1: ( ( 'mandatory' ) )
            // InternalVideoGen.g:841:1: ( 'mandatory' )
            {
            // InternalVideoGen.g:841:1: ( 'mandatory' )
            // InternalVideoGen.g:842:1: 'mandatory'
            {
             before(grammarAccess.getMandatoryVideoSeqAccess().getMandatoryKeyword_0()); 
            match(input,17,FOLLOW_2); 
             after(grammarAccess.getMandatoryVideoSeqAccess().getMandatoryKeyword_0()); 

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
    // $ANTLR end "rule__MandatoryVideoSeq__Group__0__Impl"


    // $ANTLR start "rule__MandatoryVideoSeq__Group__1"
    // InternalVideoGen.g:855:1: rule__MandatoryVideoSeq__Group__1 : rule__MandatoryVideoSeq__Group__1__Impl ;
    public final void rule__MandatoryVideoSeq__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:859:1: ( rule__MandatoryVideoSeq__Group__1__Impl )
            // InternalVideoGen.g:860:2: rule__MandatoryVideoSeq__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__MandatoryVideoSeq__Group__1__Impl();

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
    // $ANTLR end "rule__MandatoryVideoSeq__Group__1"


    // $ANTLR start "rule__MandatoryVideoSeq__Group__1__Impl"
    // InternalVideoGen.g:866:1: rule__MandatoryVideoSeq__Group__1__Impl : ( ( rule__MandatoryVideoSeq__DescriptionAssignment_1 ) ) ;
    public final void rule__MandatoryVideoSeq__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:870:1: ( ( ( rule__MandatoryVideoSeq__DescriptionAssignment_1 ) ) )
            // InternalVideoGen.g:871:1: ( ( rule__MandatoryVideoSeq__DescriptionAssignment_1 ) )
            {
            // InternalVideoGen.g:871:1: ( ( rule__MandatoryVideoSeq__DescriptionAssignment_1 ) )
            // InternalVideoGen.g:872:1: ( rule__MandatoryVideoSeq__DescriptionAssignment_1 )
            {
             before(grammarAccess.getMandatoryVideoSeqAccess().getDescriptionAssignment_1()); 
            // InternalVideoGen.g:873:1: ( rule__MandatoryVideoSeq__DescriptionAssignment_1 )
            // InternalVideoGen.g:873:2: rule__MandatoryVideoSeq__DescriptionAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__MandatoryVideoSeq__DescriptionAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getMandatoryVideoSeqAccess().getDescriptionAssignment_1()); 

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
    // $ANTLR end "rule__MandatoryVideoSeq__Group__1__Impl"


    // $ANTLR start "rule__OptionalVideoSeq__Group__0"
    // InternalVideoGen.g:887:1: rule__OptionalVideoSeq__Group__0 : rule__OptionalVideoSeq__Group__0__Impl rule__OptionalVideoSeq__Group__1 ;
    public final void rule__OptionalVideoSeq__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:891:1: ( rule__OptionalVideoSeq__Group__0__Impl rule__OptionalVideoSeq__Group__1 )
            // InternalVideoGen.g:892:2: rule__OptionalVideoSeq__Group__0__Impl rule__OptionalVideoSeq__Group__1
            {
            pushFollow(FOLLOW_11);
            rule__OptionalVideoSeq__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__OptionalVideoSeq__Group__1();

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
    // $ANTLR end "rule__OptionalVideoSeq__Group__0"


    // $ANTLR start "rule__OptionalVideoSeq__Group__0__Impl"
    // InternalVideoGen.g:899:1: rule__OptionalVideoSeq__Group__0__Impl : ( 'optional' ) ;
    public final void rule__OptionalVideoSeq__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:903:1: ( ( 'optional' ) )
            // InternalVideoGen.g:904:1: ( 'optional' )
            {
            // InternalVideoGen.g:904:1: ( 'optional' )
            // InternalVideoGen.g:905:1: 'optional'
            {
             before(grammarAccess.getOptionalVideoSeqAccess().getOptionalKeyword_0()); 
            match(input,18,FOLLOW_2); 
             after(grammarAccess.getOptionalVideoSeqAccess().getOptionalKeyword_0()); 

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
    // $ANTLR end "rule__OptionalVideoSeq__Group__0__Impl"


    // $ANTLR start "rule__OptionalVideoSeq__Group__1"
    // InternalVideoGen.g:918:1: rule__OptionalVideoSeq__Group__1 : rule__OptionalVideoSeq__Group__1__Impl ;
    public final void rule__OptionalVideoSeq__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:922:1: ( rule__OptionalVideoSeq__Group__1__Impl )
            // InternalVideoGen.g:923:2: rule__OptionalVideoSeq__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__OptionalVideoSeq__Group__1__Impl();

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
    // $ANTLR end "rule__OptionalVideoSeq__Group__1"


    // $ANTLR start "rule__OptionalVideoSeq__Group__1__Impl"
    // InternalVideoGen.g:929:1: rule__OptionalVideoSeq__Group__1__Impl : ( ( rule__OptionalVideoSeq__DescriptionAssignment_1 ) ) ;
    public final void rule__OptionalVideoSeq__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:933:1: ( ( ( rule__OptionalVideoSeq__DescriptionAssignment_1 ) ) )
            // InternalVideoGen.g:934:1: ( ( rule__OptionalVideoSeq__DescriptionAssignment_1 ) )
            {
            // InternalVideoGen.g:934:1: ( ( rule__OptionalVideoSeq__DescriptionAssignment_1 ) )
            // InternalVideoGen.g:935:1: ( rule__OptionalVideoSeq__DescriptionAssignment_1 )
            {
             before(grammarAccess.getOptionalVideoSeqAccess().getDescriptionAssignment_1()); 
            // InternalVideoGen.g:936:1: ( rule__OptionalVideoSeq__DescriptionAssignment_1 )
            // InternalVideoGen.g:936:2: rule__OptionalVideoSeq__DescriptionAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__OptionalVideoSeq__DescriptionAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getOptionalVideoSeqAccess().getDescriptionAssignment_1()); 

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
    // $ANTLR end "rule__OptionalVideoSeq__Group__1__Impl"


    // $ANTLR start "rule__AlternativeVideoSeq__Group__0"
    // InternalVideoGen.g:950:1: rule__AlternativeVideoSeq__Group__0 : rule__AlternativeVideoSeq__Group__0__Impl rule__AlternativeVideoSeq__Group__1 ;
    public final void rule__AlternativeVideoSeq__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:954:1: ( rule__AlternativeVideoSeq__Group__0__Impl rule__AlternativeVideoSeq__Group__1 )
            // InternalVideoGen.g:955:2: rule__AlternativeVideoSeq__Group__0__Impl rule__AlternativeVideoSeq__Group__1
            {
            pushFollow(FOLLOW_12);
            rule__AlternativeVideoSeq__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__AlternativeVideoSeq__Group__1();

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
    // $ANTLR end "rule__AlternativeVideoSeq__Group__0"


    // $ANTLR start "rule__AlternativeVideoSeq__Group__0__Impl"
    // InternalVideoGen.g:962:1: rule__AlternativeVideoSeq__Group__0__Impl : ( 'alternatives' ) ;
    public final void rule__AlternativeVideoSeq__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:966:1: ( ( 'alternatives' ) )
            // InternalVideoGen.g:967:1: ( 'alternatives' )
            {
            // InternalVideoGen.g:967:1: ( 'alternatives' )
            // InternalVideoGen.g:968:1: 'alternatives'
            {
             before(grammarAccess.getAlternativeVideoSeqAccess().getAlternativesKeyword_0()); 
            match(input,19,FOLLOW_2); 
             after(grammarAccess.getAlternativeVideoSeqAccess().getAlternativesKeyword_0()); 

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
    // $ANTLR end "rule__AlternativeVideoSeq__Group__0__Impl"


    // $ANTLR start "rule__AlternativeVideoSeq__Group__1"
    // InternalVideoGen.g:981:1: rule__AlternativeVideoSeq__Group__1 : rule__AlternativeVideoSeq__Group__1__Impl rule__AlternativeVideoSeq__Group__2 ;
    public final void rule__AlternativeVideoSeq__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:985:1: ( rule__AlternativeVideoSeq__Group__1__Impl rule__AlternativeVideoSeq__Group__2 )
            // InternalVideoGen.g:986:2: rule__AlternativeVideoSeq__Group__1__Impl rule__AlternativeVideoSeq__Group__2
            {
            pushFollow(FOLLOW_12);
            rule__AlternativeVideoSeq__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__AlternativeVideoSeq__Group__2();

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
    // $ANTLR end "rule__AlternativeVideoSeq__Group__1"


    // $ANTLR start "rule__AlternativeVideoSeq__Group__1__Impl"
    // InternalVideoGen.g:993:1: rule__AlternativeVideoSeq__Group__1__Impl : ( ( rule__AlternativeVideoSeq__VideoidAssignment_1 )? ) ;
    public final void rule__AlternativeVideoSeq__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:997:1: ( ( ( rule__AlternativeVideoSeq__VideoidAssignment_1 )? ) )
            // InternalVideoGen.g:998:1: ( ( rule__AlternativeVideoSeq__VideoidAssignment_1 )? )
            {
            // InternalVideoGen.g:998:1: ( ( rule__AlternativeVideoSeq__VideoidAssignment_1 )? )
            // InternalVideoGen.g:999:1: ( rule__AlternativeVideoSeq__VideoidAssignment_1 )?
            {
             before(grammarAccess.getAlternativeVideoSeqAccess().getVideoidAssignment_1()); 
            // InternalVideoGen.g:1000:1: ( rule__AlternativeVideoSeq__VideoidAssignment_1 )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==RULE_ID) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // InternalVideoGen.g:1000:2: rule__AlternativeVideoSeq__VideoidAssignment_1
                    {
                    pushFollow(FOLLOW_2);
                    rule__AlternativeVideoSeq__VideoidAssignment_1();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getAlternativeVideoSeqAccess().getVideoidAssignment_1()); 

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
    // $ANTLR end "rule__AlternativeVideoSeq__Group__1__Impl"


    // $ANTLR start "rule__AlternativeVideoSeq__Group__2"
    // InternalVideoGen.g:1010:1: rule__AlternativeVideoSeq__Group__2 : rule__AlternativeVideoSeq__Group__2__Impl rule__AlternativeVideoSeq__Group__3 ;
    public final void rule__AlternativeVideoSeq__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:1014:1: ( rule__AlternativeVideoSeq__Group__2__Impl rule__AlternativeVideoSeq__Group__3 )
            // InternalVideoGen.g:1015:2: rule__AlternativeVideoSeq__Group__2__Impl rule__AlternativeVideoSeq__Group__3
            {
            pushFollow(FOLLOW_11);
            rule__AlternativeVideoSeq__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__AlternativeVideoSeq__Group__3();

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
    // $ANTLR end "rule__AlternativeVideoSeq__Group__2"


    // $ANTLR start "rule__AlternativeVideoSeq__Group__2__Impl"
    // InternalVideoGen.g:1022:1: rule__AlternativeVideoSeq__Group__2__Impl : ( RULE_LEFT_BRACKET ) ;
    public final void rule__AlternativeVideoSeq__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:1026:1: ( ( RULE_LEFT_BRACKET ) )
            // InternalVideoGen.g:1027:1: ( RULE_LEFT_BRACKET )
            {
            // InternalVideoGen.g:1027:1: ( RULE_LEFT_BRACKET )
            // InternalVideoGen.g:1028:1: RULE_LEFT_BRACKET
            {
             before(grammarAccess.getAlternativeVideoSeqAccess().getLEFT_BRACKETTerminalRuleCall_2()); 
            match(input,RULE_LEFT_BRACKET,FOLLOW_2); 
             after(grammarAccess.getAlternativeVideoSeqAccess().getLEFT_BRACKETTerminalRuleCall_2()); 

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
    // $ANTLR end "rule__AlternativeVideoSeq__Group__2__Impl"


    // $ANTLR start "rule__AlternativeVideoSeq__Group__3"
    // InternalVideoGen.g:1039:1: rule__AlternativeVideoSeq__Group__3 : rule__AlternativeVideoSeq__Group__3__Impl rule__AlternativeVideoSeq__Group__4 ;
    public final void rule__AlternativeVideoSeq__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:1043:1: ( rule__AlternativeVideoSeq__Group__3__Impl rule__AlternativeVideoSeq__Group__4 )
            // InternalVideoGen.g:1044:2: rule__AlternativeVideoSeq__Group__3__Impl rule__AlternativeVideoSeq__Group__4
            {
            pushFollow(FOLLOW_6);
            rule__AlternativeVideoSeq__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__AlternativeVideoSeq__Group__4();

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
    // $ANTLR end "rule__AlternativeVideoSeq__Group__3"


    // $ANTLR start "rule__AlternativeVideoSeq__Group__3__Impl"
    // InternalVideoGen.g:1051:1: rule__AlternativeVideoSeq__Group__3__Impl : ( ( ( rule__AlternativeVideoSeq__VideodescsAssignment_3 ) ) ( ( rule__AlternativeVideoSeq__VideodescsAssignment_3 )* ) ) ;
    public final void rule__AlternativeVideoSeq__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:1055:1: ( ( ( ( rule__AlternativeVideoSeq__VideodescsAssignment_3 ) ) ( ( rule__AlternativeVideoSeq__VideodescsAssignment_3 )* ) ) )
            // InternalVideoGen.g:1056:1: ( ( ( rule__AlternativeVideoSeq__VideodescsAssignment_3 ) ) ( ( rule__AlternativeVideoSeq__VideodescsAssignment_3 )* ) )
            {
            // InternalVideoGen.g:1056:1: ( ( ( rule__AlternativeVideoSeq__VideodescsAssignment_3 ) ) ( ( rule__AlternativeVideoSeq__VideodescsAssignment_3 )* ) )
            // InternalVideoGen.g:1057:1: ( ( rule__AlternativeVideoSeq__VideodescsAssignment_3 ) ) ( ( rule__AlternativeVideoSeq__VideodescsAssignment_3 )* )
            {
            // InternalVideoGen.g:1057:1: ( ( rule__AlternativeVideoSeq__VideodescsAssignment_3 ) )
            // InternalVideoGen.g:1058:1: ( rule__AlternativeVideoSeq__VideodescsAssignment_3 )
            {
             before(grammarAccess.getAlternativeVideoSeqAccess().getVideodescsAssignment_3()); 
            // InternalVideoGen.g:1059:1: ( rule__AlternativeVideoSeq__VideodescsAssignment_3 )
            // InternalVideoGen.g:1059:2: rule__AlternativeVideoSeq__VideodescsAssignment_3
            {
            pushFollow(FOLLOW_13);
            rule__AlternativeVideoSeq__VideodescsAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getAlternativeVideoSeqAccess().getVideodescsAssignment_3()); 

            }

            // InternalVideoGen.g:1062:1: ( ( rule__AlternativeVideoSeq__VideodescsAssignment_3 )* )
            // InternalVideoGen.g:1063:1: ( rule__AlternativeVideoSeq__VideodescsAssignment_3 )*
            {
             before(grammarAccess.getAlternativeVideoSeqAccess().getVideodescsAssignment_3()); 
            // InternalVideoGen.g:1064:1: ( rule__AlternativeVideoSeq__VideodescsAssignment_3 )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==20) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // InternalVideoGen.g:1064:2: rule__AlternativeVideoSeq__VideodescsAssignment_3
            	    {
            	    pushFollow(FOLLOW_13);
            	    rule__AlternativeVideoSeq__VideodescsAssignment_3();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);

             after(grammarAccess.getAlternativeVideoSeqAccess().getVideodescsAssignment_3()); 

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
    // $ANTLR end "rule__AlternativeVideoSeq__Group__3__Impl"


    // $ANTLR start "rule__AlternativeVideoSeq__Group__4"
    // InternalVideoGen.g:1075:1: rule__AlternativeVideoSeq__Group__4 : rule__AlternativeVideoSeq__Group__4__Impl ;
    public final void rule__AlternativeVideoSeq__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:1079:1: ( rule__AlternativeVideoSeq__Group__4__Impl )
            // InternalVideoGen.g:1080:2: rule__AlternativeVideoSeq__Group__4__Impl
            {
            pushFollow(FOLLOW_2);
            rule__AlternativeVideoSeq__Group__4__Impl();

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
    // $ANTLR end "rule__AlternativeVideoSeq__Group__4"


    // $ANTLR start "rule__AlternativeVideoSeq__Group__4__Impl"
    // InternalVideoGen.g:1086:1: rule__AlternativeVideoSeq__Group__4__Impl : ( RULE_RIGHT_BRACKET ) ;
    public final void rule__AlternativeVideoSeq__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:1090:1: ( ( RULE_RIGHT_BRACKET ) )
            // InternalVideoGen.g:1091:1: ( RULE_RIGHT_BRACKET )
            {
            // InternalVideoGen.g:1091:1: ( RULE_RIGHT_BRACKET )
            // InternalVideoGen.g:1092:1: RULE_RIGHT_BRACKET
            {
             before(grammarAccess.getAlternativeVideoSeqAccess().getRIGHT_BRACKETTerminalRuleCall_4()); 
            match(input,RULE_RIGHT_BRACKET,FOLLOW_2); 
             after(grammarAccess.getAlternativeVideoSeqAccess().getRIGHT_BRACKETTerminalRuleCall_4()); 

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
    // $ANTLR end "rule__AlternativeVideoSeq__Group__4__Impl"


    // $ANTLR start "rule__VideoDescription__Group__0"
    // InternalVideoGen.g:1113:1: rule__VideoDescription__Group__0 : rule__VideoDescription__Group__0__Impl rule__VideoDescription__Group__1 ;
    public final void rule__VideoDescription__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:1117:1: ( rule__VideoDescription__Group__0__Impl rule__VideoDescription__Group__1 )
            // InternalVideoGen.g:1118:2: rule__VideoDescription__Group__0__Impl rule__VideoDescription__Group__1
            {
            pushFollow(FOLLOW_14);
            rule__VideoDescription__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__VideoDescription__Group__1();

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
    // $ANTLR end "rule__VideoDescription__Group__0"


    // $ANTLR start "rule__VideoDescription__Group__0__Impl"
    // InternalVideoGen.g:1125:1: rule__VideoDescription__Group__0__Impl : ( 'videoseq' ) ;
    public final void rule__VideoDescription__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:1129:1: ( ( 'videoseq' ) )
            // InternalVideoGen.g:1130:1: ( 'videoseq' )
            {
            // InternalVideoGen.g:1130:1: ( 'videoseq' )
            // InternalVideoGen.g:1131:1: 'videoseq'
            {
             before(grammarAccess.getVideoDescriptionAccess().getVideoseqKeyword_0()); 
            match(input,20,FOLLOW_2); 
             after(grammarAccess.getVideoDescriptionAccess().getVideoseqKeyword_0()); 

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
    // $ANTLR end "rule__VideoDescription__Group__0__Impl"


    // $ANTLR start "rule__VideoDescription__Group__1"
    // InternalVideoGen.g:1144:1: rule__VideoDescription__Group__1 : rule__VideoDescription__Group__1__Impl rule__VideoDescription__Group__2 ;
    public final void rule__VideoDescription__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:1148:1: ( rule__VideoDescription__Group__1__Impl rule__VideoDescription__Group__2 )
            // InternalVideoGen.g:1149:2: rule__VideoDescription__Group__1__Impl rule__VideoDescription__Group__2
            {
            pushFollow(FOLLOW_14);
            rule__VideoDescription__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__VideoDescription__Group__2();

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
    // $ANTLR end "rule__VideoDescription__Group__1"


    // $ANTLR start "rule__VideoDescription__Group__1__Impl"
    // InternalVideoGen.g:1156:1: rule__VideoDescription__Group__1__Impl : ( ( rule__VideoDescription__VideoidAssignment_1 )? ) ;
    public final void rule__VideoDescription__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:1160:1: ( ( ( rule__VideoDescription__VideoidAssignment_1 )? ) )
            // InternalVideoGen.g:1161:1: ( ( rule__VideoDescription__VideoidAssignment_1 )? )
            {
            // InternalVideoGen.g:1161:1: ( ( rule__VideoDescription__VideoidAssignment_1 )? )
            // InternalVideoGen.g:1162:1: ( rule__VideoDescription__VideoidAssignment_1 )?
            {
             before(grammarAccess.getVideoDescriptionAccess().getVideoidAssignment_1()); 
            // InternalVideoGen.g:1163:1: ( rule__VideoDescription__VideoidAssignment_1 )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==RULE_ID) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // InternalVideoGen.g:1163:2: rule__VideoDescription__VideoidAssignment_1
                    {
                    pushFollow(FOLLOW_2);
                    rule__VideoDescription__VideoidAssignment_1();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getVideoDescriptionAccess().getVideoidAssignment_1()); 

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
    // $ANTLR end "rule__VideoDescription__Group__1__Impl"


    // $ANTLR start "rule__VideoDescription__Group__2"
    // InternalVideoGen.g:1173:1: rule__VideoDescription__Group__2 : rule__VideoDescription__Group__2__Impl rule__VideoDescription__Group__3 ;
    public final void rule__VideoDescription__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:1177:1: ( rule__VideoDescription__Group__2__Impl rule__VideoDescription__Group__3 )
            // InternalVideoGen.g:1178:2: rule__VideoDescription__Group__2__Impl rule__VideoDescription__Group__3
            {
            pushFollow(FOLLOW_4);
            rule__VideoDescription__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__VideoDescription__Group__3();

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
    // $ANTLR end "rule__VideoDescription__Group__2"


    // $ANTLR start "rule__VideoDescription__Group__2__Impl"
    // InternalVideoGen.g:1185:1: rule__VideoDescription__Group__2__Impl : ( ( rule__VideoDescription__LocationAssignment_2 ) ) ;
    public final void rule__VideoDescription__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:1189:1: ( ( ( rule__VideoDescription__LocationAssignment_2 ) ) )
            // InternalVideoGen.g:1190:1: ( ( rule__VideoDescription__LocationAssignment_2 ) )
            {
            // InternalVideoGen.g:1190:1: ( ( rule__VideoDescription__LocationAssignment_2 ) )
            // InternalVideoGen.g:1191:1: ( rule__VideoDescription__LocationAssignment_2 )
            {
             before(grammarAccess.getVideoDescriptionAccess().getLocationAssignment_2()); 
            // InternalVideoGen.g:1192:1: ( rule__VideoDescription__LocationAssignment_2 )
            // InternalVideoGen.g:1192:2: rule__VideoDescription__LocationAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__VideoDescription__LocationAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getVideoDescriptionAccess().getLocationAssignment_2()); 

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
    // $ANTLR end "rule__VideoDescription__Group__2__Impl"


    // $ANTLR start "rule__VideoDescription__Group__3"
    // InternalVideoGen.g:1202:1: rule__VideoDescription__Group__3 : rule__VideoDescription__Group__3__Impl ;
    public final void rule__VideoDescription__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:1206:1: ( rule__VideoDescription__Group__3__Impl )
            // InternalVideoGen.g:1207:2: rule__VideoDescription__Group__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__VideoDescription__Group__3__Impl();

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
    // $ANTLR end "rule__VideoDescription__Group__3"


    // $ANTLR start "rule__VideoDescription__Group__3__Impl"
    // InternalVideoGen.g:1213:1: rule__VideoDescription__Group__3__Impl : ( ( rule__VideoDescription__Group_3__0 )? ) ;
    public final void rule__VideoDescription__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:1217:1: ( ( ( rule__VideoDescription__Group_3__0 )? ) )
            // InternalVideoGen.g:1218:1: ( ( rule__VideoDescription__Group_3__0 )? )
            {
            // InternalVideoGen.g:1218:1: ( ( rule__VideoDescription__Group_3__0 )? )
            // InternalVideoGen.g:1219:1: ( rule__VideoDescription__Group_3__0 )?
            {
             before(grammarAccess.getVideoDescriptionAccess().getGroup_3()); 
            // InternalVideoGen.g:1220:1: ( rule__VideoDescription__Group_3__0 )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==RULE_LEFT_BRACKET) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // InternalVideoGen.g:1220:2: rule__VideoDescription__Group_3__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__VideoDescription__Group_3__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getVideoDescriptionAccess().getGroup_3()); 

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
    // $ANTLR end "rule__VideoDescription__Group__3__Impl"


    // $ANTLR start "rule__VideoDescription__Group_3__0"
    // InternalVideoGen.g:1238:1: rule__VideoDescription__Group_3__0 : rule__VideoDescription__Group_3__0__Impl rule__VideoDescription__Group_3__1 ;
    public final void rule__VideoDescription__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:1242:1: ( rule__VideoDescription__Group_3__0__Impl rule__VideoDescription__Group_3__1 )
            // InternalVideoGen.g:1243:2: rule__VideoDescription__Group_3__0__Impl rule__VideoDescription__Group_3__1
            {
            pushFollow(FOLLOW_15);
            rule__VideoDescription__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__VideoDescription__Group_3__1();

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
    // $ANTLR end "rule__VideoDescription__Group_3__0"


    // $ANTLR start "rule__VideoDescription__Group_3__0__Impl"
    // InternalVideoGen.g:1250:1: rule__VideoDescription__Group_3__0__Impl : ( RULE_LEFT_BRACKET ) ;
    public final void rule__VideoDescription__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:1254:1: ( ( RULE_LEFT_BRACKET ) )
            // InternalVideoGen.g:1255:1: ( RULE_LEFT_BRACKET )
            {
            // InternalVideoGen.g:1255:1: ( RULE_LEFT_BRACKET )
            // InternalVideoGen.g:1256:1: RULE_LEFT_BRACKET
            {
             before(grammarAccess.getVideoDescriptionAccess().getLEFT_BRACKETTerminalRuleCall_3_0()); 
            match(input,RULE_LEFT_BRACKET,FOLLOW_2); 
             after(grammarAccess.getVideoDescriptionAccess().getLEFT_BRACKETTerminalRuleCall_3_0()); 

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
    // $ANTLR end "rule__VideoDescription__Group_3__0__Impl"


    // $ANTLR start "rule__VideoDescription__Group_3__1"
    // InternalVideoGen.g:1267:1: rule__VideoDescription__Group_3__1 : rule__VideoDescription__Group_3__1__Impl rule__VideoDescription__Group_3__2 ;
    public final void rule__VideoDescription__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:1271:1: ( rule__VideoDescription__Group_3__1__Impl rule__VideoDescription__Group_3__2 )
            // InternalVideoGen.g:1272:2: rule__VideoDescription__Group_3__1__Impl rule__VideoDescription__Group_3__2
            {
            pushFollow(FOLLOW_15);
            rule__VideoDescription__Group_3__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__VideoDescription__Group_3__2();

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
    // $ANTLR end "rule__VideoDescription__Group_3__1"


    // $ANTLR start "rule__VideoDescription__Group_3__1__Impl"
    // InternalVideoGen.g:1279:1: rule__VideoDescription__Group_3__1__Impl : ( ( rule__VideoDescription__Group_3_1__0 )? ) ;
    public final void rule__VideoDescription__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:1283:1: ( ( ( rule__VideoDescription__Group_3_1__0 )? ) )
            // InternalVideoGen.g:1284:1: ( ( rule__VideoDescription__Group_3_1__0 )? )
            {
            // InternalVideoGen.g:1284:1: ( ( rule__VideoDescription__Group_3_1__0 )? )
            // InternalVideoGen.g:1285:1: ( rule__VideoDescription__Group_3_1__0 )?
            {
             before(grammarAccess.getVideoDescriptionAccess().getGroup_3_1()); 
            // InternalVideoGen.g:1286:1: ( rule__VideoDescription__Group_3_1__0 )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==21) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // InternalVideoGen.g:1286:2: rule__VideoDescription__Group_3_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__VideoDescription__Group_3_1__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getVideoDescriptionAccess().getGroup_3_1()); 

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
    // $ANTLR end "rule__VideoDescription__Group_3__1__Impl"


    // $ANTLR start "rule__VideoDescription__Group_3__2"
    // InternalVideoGen.g:1296:1: rule__VideoDescription__Group_3__2 : rule__VideoDescription__Group_3__2__Impl rule__VideoDescription__Group_3__3 ;
    public final void rule__VideoDescription__Group_3__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:1300:1: ( rule__VideoDescription__Group_3__2__Impl rule__VideoDescription__Group_3__3 )
            // InternalVideoGen.g:1301:2: rule__VideoDescription__Group_3__2__Impl rule__VideoDescription__Group_3__3
            {
            pushFollow(FOLLOW_15);
            rule__VideoDescription__Group_3__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__VideoDescription__Group_3__3();

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
    // $ANTLR end "rule__VideoDescription__Group_3__2"


    // $ANTLR start "rule__VideoDescription__Group_3__2__Impl"
    // InternalVideoGen.g:1308:1: rule__VideoDescription__Group_3__2__Impl : ( ( rule__VideoDescription__Group_3_2__0 )? ) ;
    public final void rule__VideoDescription__Group_3__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:1312:1: ( ( ( rule__VideoDescription__Group_3_2__0 )? ) )
            // InternalVideoGen.g:1313:1: ( ( rule__VideoDescription__Group_3_2__0 )? )
            {
            // InternalVideoGen.g:1313:1: ( ( rule__VideoDescription__Group_3_2__0 )? )
            // InternalVideoGen.g:1314:1: ( rule__VideoDescription__Group_3_2__0 )?
            {
             before(grammarAccess.getVideoDescriptionAccess().getGroup_3_2()); 
            // InternalVideoGen.g:1315:1: ( rule__VideoDescription__Group_3_2__0 )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==22) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // InternalVideoGen.g:1315:2: rule__VideoDescription__Group_3_2__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__VideoDescription__Group_3_2__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getVideoDescriptionAccess().getGroup_3_2()); 

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
    // $ANTLR end "rule__VideoDescription__Group_3__2__Impl"


    // $ANTLR start "rule__VideoDescription__Group_3__3"
    // InternalVideoGen.g:1325:1: rule__VideoDescription__Group_3__3 : rule__VideoDescription__Group_3__3__Impl rule__VideoDescription__Group_3__4 ;
    public final void rule__VideoDescription__Group_3__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:1329:1: ( rule__VideoDescription__Group_3__3__Impl rule__VideoDescription__Group_3__4 )
            // InternalVideoGen.g:1330:2: rule__VideoDescription__Group_3__3__Impl rule__VideoDescription__Group_3__4
            {
            pushFollow(FOLLOW_15);
            rule__VideoDescription__Group_3__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__VideoDescription__Group_3__4();

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
    // $ANTLR end "rule__VideoDescription__Group_3__3"


    // $ANTLR start "rule__VideoDescription__Group_3__3__Impl"
    // InternalVideoGen.g:1337:1: rule__VideoDescription__Group_3__3__Impl : ( ( rule__VideoDescription__Group_3_3__0 )? ) ;
    public final void rule__VideoDescription__Group_3__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:1341:1: ( ( ( rule__VideoDescription__Group_3_3__0 )? ) )
            // InternalVideoGen.g:1342:1: ( ( rule__VideoDescription__Group_3_3__0 )? )
            {
            // InternalVideoGen.g:1342:1: ( ( rule__VideoDescription__Group_3_3__0 )? )
            // InternalVideoGen.g:1343:1: ( rule__VideoDescription__Group_3_3__0 )?
            {
             before(grammarAccess.getVideoDescriptionAccess().getGroup_3_3()); 
            // InternalVideoGen.g:1344:1: ( rule__VideoDescription__Group_3_3__0 )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==23) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // InternalVideoGen.g:1344:2: rule__VideoDescription__Group_3_3__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__VideoDescription__Group_3_3__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getVideoDescriptionAccess().getGroup_3_3()); 

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
    // $ANTLR end "rule__VideoDescription__Group_3__3__Impl"


    // $ANTLR start "rule__VideoDescription__Group_3__4"
    // InternalVideoGen.g:1354:1: rule__VideoDescription__Group_3__4 : rule__VideoDescription__Group_3__4__Impl rule__VideoDescription__Group_3__5 ;
    public final void rule__VideoDescription__Group_3__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:1358:1: ( rule__VideoDescription__Group_3__4__Impl rule__VideoDescription__Group_3__5 )
            // InternalVideoGen.g:1359:2: rule__VideoDescription__Group_3__4__Impl rule__VideoDescription__Group_3__5
            {
            pushFollow(FOLLOW_15);
            rule__VideoDescription__Group_3__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__VideoDescription__Group_3__5();

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
    // $ANTLR end "rule__VideoDescription__Group_3__4"


    // $ANTLR start "rule__VideoDescription__Group_3__4__Impl"
    // InternalVideoGen.g:1366:1: rule__VideoDescription__Group_3__4__Impl : ( ( rule__VideoDescription__Group_3_4__0 )? ) ;
    public final void rule__VideoDescription__Group_3__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:1370:1: ( ( ( rule__VideoDescription__Group_3_4__0 )? ) )
            // InternalVideoGen.g:1371:1: ( ( rule__VideoDescription__Group_3_4__0 )? )
            {
            // InternalVideoGen.g:1371:1: ( ( rule__VideoDescription__Group_3_4__0 )? )
            // InternalVideoGen.g:1372:1: ( rule__VideoDescription__Group_3_4__0 )?
            {
             before(grammarAccess.getVideoDescriptionAccess().getGroup_3_4()); 
            // InternalVideoGen.g:1373:1: ( rule__VideoDescription__Group_3_4__0 )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==24) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // InternalVideoGen.g:1373:2: rule__VideoDescription__Group_3_4__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__VideoDescription__Group_3_4__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getVideoDescriptionAccess().getGroup_3_4()); 

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
    // $ANTLR end "rule__VideoDescription__Group_3__4__Impl"


    // $ANTLR start "rule__VideoDescription__Group_3__5"
    // InternalVideoGen.g:1383:1: rule__VideoDescription__Group_3__5 : rule__VideoDescription__Group_3__5__Impl rule__VideoDescription__Group_3__6 ;
    public final void rule__VideoDescription__Group_3__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:1387:1: ( rule__VideoDescription__Group_3__5__Impl rule__VideoDescription__Group_3__6 )
            // InternalVideoGen.g:1388:2: rule__VideoDescription__Group_3__5__Impl rule__VideoDescription__Group_3__6
            {
            pushFollow(FOLLOW_15);
            rule__VideoDescription__Group_3__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__VideoDescription__Group_3__6();

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
    // $ANTLR end "rule__VideoDescription__Group_3__5"


    // $ANTLR start "rule__VideoDescription__Group_3__5__Impl"
    // InternalVideoGen.g:1395:1: rule__VideoDescription__Group_3__5__Impl : ( ( rule__VideoDescription__Group_3_5__0 )? ) ;
    public final void rule__VideoDescription__Group_3__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:1399:1: ( ( ( rule__VideoDescription__Group_3_5__0 )? ) )
            // InternalVideoGen.g:1400:1: ( ( rule__VideoDescription__Group_3_5__0 )? )
            {
            // InternalVideoGen.g:1400:1: ( ( rule__VideoDescription__Group_3_5__0 )? )
            // InternalVideoGen.g:1401:1: ( rule__VideoDescription__Group_3_5__0 )?
            {
             before(grammarAccess.getVideoDescriptionAccess().getGroup_3_5()); 
            // InternalVideoGen.g:1402:1: ( rule__VideoDescription__Group_3_5__0 )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==25) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // InternalVideoGen.g:1402:2: rule__VideoDescription__Group_3_5__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__VideoDescription__Group_3_5__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getVideoDescriptionAccess().getGroup_3_5()); 

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
    // $ANTLR end "rule__VideoDescription__Group_3__5__Impl"


    // $ANTLR start "rule__VideoDescription__Group_3__6"
    // InternalVideoGen.g:1412:1: rule__VideoDescription__Group_3__6 : rule__VideoDescription__Group_3__6__Impl ;
    public final void rule__VideoDescription__Group_3__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:1416:1: ( rule__VideoDescription__Group_3__6__Impl )
            // InternalVideoGen.g:1417:2: rule__VideoDescription__Group_3__6__Impl
            {
            pushFollow(FOLLOW_2);
            rule__VideoDescription__Group_3__6__Impl();

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
    // $ANTLR end "rule__VideoDescription__Group_3__6"


    // $ANTLR start "rule__VideoDescription__Group_3__6__Impl"
    // InternalVideoGen.g:1423:1: rule__VideoDescription__Group_3__6__Impl : ( RULE_RIGHT_BRACKET ) ;
    public final void rule__VideoDescription__Group_3__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:1427:1: ( ( RULE_RIGHT_BRACKET ) )
            // InternalVideoGen.g:1428:1: ( RULE_RIGHT_BRACKET )
            {
            // InternalVideoGen.g:1428:1: ( RULE_RIGHT_BRACKET )
            // InternalVideoGen.g:1429:1: RULE_RIGHT_BRACKET
            {
             before(grammarAccess.getVideoDescriptionAccess().getRIGHT_BRACKETTerminalRuleCall_3_6()); 
            match(input,RULE_RIGHT_BRACKET,FOLLOW_2); 
             after(grammarAccess.getVideoDescriptionAccess().getRIGHT_BRACKETTerminalRuleCall_3_6()); 

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
    // $ANTLR end "rule__VideoDescription__Group_3__6__Impl"


    // $ANTLR start "rule__VideoDescription__Group_3_1__0"
    // InternalVideoGen.g:1454:1: rule__VideoDescription__Group_3_1__0 : rule__VideoDescription__Group_3_1__0__Impl rule__VideoDescription__Group_3_1__1 ;
    public final void rule__VideoDescription__Group_3_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:1458:1: ( rule__VideoDescription__Group_3_1__0__Impl rule__VideoDescription__Group_3_1__1 )
            // InternalVideoGen.g:1459:2: rule__VideoDescription__Group_3_1__0__Impl rule__VideoDescription__Group_3_1__1
            {
            pushFollow(FOLLOW_16);
            rule__VideoDescription__Group_3_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__VideoDescription__Group_3_1__1();

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
    // $ANTLR end "rule__VideoDescription__Group_3_1__0"


    // $ANTLR start "rule__VideoDescription__Group_3_1__0__Impl"
    // InternalVideoGen.g:1466:1: rule__VideoDescription__Group_3_1__0__Impl : ( 'duration' ) ;
    public final void rule__VideoDescription__Group_3_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:1470:1: ( ( 'duration' ) )
            // InternalVideoGen.g:1471:1: ( 'duration' )
            {
            // InternalVideoGen.g:1471:1: ( 'duration' )
            // InternalVideoGen.g:1472:1: 'duration'
            {
             before(grammarAccess.getVideoDescriptionAccess().getDurationKeyword_3_1_0()); 
            match(input,21,FOLLOW_2); 
             after(grammarAccess.getVideoDescriptionAccess().getDurationKeyword_3_1_0()); 

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
    // $ANTLR end "rule__VideoDescription__Group_3_1__0__Impl"


    // $ANTLR start "rule__VideoDescription__Group_3_1__1"
    // InternalVideoGen.g:1485:1: rule__VideoDescription__Group_3_1__1 : rule__VideoDescription__Group_3_1__1__Impl ;
    public final void rule__VideoDescription__Group_3_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:1489:1: ( rule__VideoDescription__Group_3_1__1__Impl )
            // InternalVideoGen.g:1490:2: rule__VideoDescription__Group_3_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__VideoDescription__Group_3_1__1__Impl();

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
    // $ANTLR end "rule__VideoDescription__Group_3_1__1"


    // $ANTLR start "rule__VideoDescription__Group_3_1__1__Impl"
    // InternalVideoGen.g:1496:1: rule__VideoDescription__Group_3_1__1__Impl : ( ( rule__VideoDescription__DurationAssignment_3_1_1 ) ) ;
    public final void rule__VideoDescription__Group_3_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:1500:1: ( ( ( rule__VideoDescription__DurationAssignment_3_1_1 ) ) )
            // InternalVideoGen.g:1501:1: ( ( rule__VideoDescription__DurationAssignment_3_1_1 ) )
            {
            // InternalVideoGen.g:1501:1: ( ( rule__VideoDescription__DurationAssignment_3_1_1 ) )
            // InternalVideoGen.g:1502:1: ( rule__VideoDescription__DurationAssignment_3_1_1 )
            {
             before(grammarAccess.getVideoDescriptionAccess().getDurationAssignment_3_1_1()); 
            // InternalVideoGen.g:1503:1: ( rule__VideoDescription__DurationAssignment_3_1_1 )
            // InternalVideoGen.g:1503:2: rule__VideoDescription__DurationAssignment_3_1_1
            {
            pushFollow(FOLLOW_2);
            rule__VideoDescription__DurationAssignment_3_1_1();

            state._fsp--;


            }

             after(grammarAccess.getVideoDescriptionAccess().getDurationAssignment_3_1_1()); 

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
    // $ANTLR end "rule__VideoDescription__Group_3_1__1__Impl"


    // $ANTLR start "rule__VideoDescription__Group_3_2__0"
    // InternalVideoGen.g:1517:1: rule__VideoDescription__Group_3_2__0 : rule__VideoDescription__Group_3_2__0__Impl rule__VideoDescription__Group_3_2__1 ;
    public final void rule__VideoDescription__Group_3_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:1521:1: ( rule__VideoDescription__Group_3_2__0__Impl rule__VideoDescription__Group_3_2__1 )
            // InternalVideoGen.g:1522:2: rule__VideoDescription__Group_3_2__0__Impl rule__VideoDescription__Group_3_2__1
            {
            pushFollow(FOLLOW_16);
            rule__VideoDescription__Group_3_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__VideoDescription__Group_3_2__1();

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
    // $ANTLR end "rule__VideoDescription__Group_3_2__0"


    // $ANTLR start "rule__VideoDescription__Group_3_2__0__Impl"
    // InternalVideoGen.g:1529:1: rule__VideoDescription__Group_3_2__0__Impl : ( 'probability' ) ;
    public final void rule__VideoDescription__Group_3_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:1533:1: ( ( 'probability' ) )
            // InternalVideoGen.g:1534:1: ( 'probability' )
            {
            // InternalVideoGen.g:1534:1: ( 'probability' )
            // InternalVideoGen.g:1535:1: 'probability'
            {
             before(grammarAccess.getVideoDescriptionAccess().getProbabilityKeyword_3_2_0()); 
            match(input,22,FOLLOW_2); 
             after(grammarAccess.getVideoDescriptionAccess().getProbabilityKeyword_3_2_0()); 

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
    // $ANTLR end "rule__VideoDescription__Group_3_2__0__Impl"


    // $ANTLR start "rule__VideoDescription__Group_3_2__1"
    // InternalVideoGen.g:1548:1: rule__VideoDescription__Group_3_2__1 : rule__VideoDescription__Group_3_2__1__Impl ;
    public final void rule__VideoDescription__Group_3_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:1552:1: ( rule__VideoDescription__Group_3_2__1__Impl )
            // InternalVideoGen.g:1553:2: rule__VideoDescription__Group_3_2__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__VideoDescription__Group_3_2__1__Impl();

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
    // $ANTLR end "rule__VideoDescription__Group_3_2__1"


    // $ANTLR start "rule__VideoDescription__Group_3_2__1__Impl"
    // InternalVideoGen.g:1559:1: rule__VideoDescription__Group_3_2__1__Impl : ( ( rule__VideoDescription__ProbabilityAssignment_3_2_1 ) ) ;
    public final void rule__VideoDescription__Group_3_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:1563:1: ( ( ( rule__VideoDescription__ProbabilityAssignment_3_2_1 ) ) )
            // InternalVideoGen.g:1564:1: ( ( rule__VideoDescription__ProbabilityAssignment_3_2_1 ) )
            {
            // InternalVideoGen.g:1564:1: ( ( rule__VideoDescription__ProbabilityAssignment_3_2_1 ) )
            // InternalVideoGen.g:1565:1: ( rule__VideoDescription__ProbabilityAssignment_3_2_1 )
            {
             before(grammarAccess.getVideoDescriptionAccess().getProbabilityAssignment_3_2_1()); 
            // InternalVideoGen.g:1566:1: ( rule__VideoDescription__ProbabilityAssignment_3_2_1 )
            // InternalVideoGen.g:1566:2: rule__VideoDescription__ProbabilityAssignment_3_2_1
            {
            pushFollow(FOLLOW_2);
            rule__VideoDescription__ProbabilityAssignment_3_2_1();

            state._fsp--;


            }

             after(grammarAccess.getVideoDescriptionAccess().getProbabilityAssignment_3_2_1()); 

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
    // $ANTLR end "rule__VideoDescription__Group_3_2__1__Impl"


    // $ANTLR start "rule__VideoDescription__Group_3_3__0"
    // InternalVideoGen.g:1580:1: rule__VideoDescription__Group_3_3__0 : rule__VideoDescription__Group_3_3__0__Impl rule__VideoDescription__Group_3_3__1 ;
    public final void rule__VideoDescription__Group_3_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:1584:1: ( rule__VideoDescription__Group_3_3__0__Impl rule__VideoDescription__Group_3_3__1 )
            // InternalVideoGen.g:1585:2: rule__VideoDescription__Group_3_3__0__Impl rule__VideoDescription__Group_3_3__1
            {
            pushFollow(FOLLOW_16);
            rule__VideoDescription__Group_3_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__VideoDescription__Group_3_3__1();

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
    // $ANTLR end "rule__VideoDescription__Group_3_3__0"


    // $ANTLR start "rule__VideoDescription__Group_3_3__0__Impl"
    // InternalVideoGen.g:1592:1: rule__VideoDescription__Group_3_3__0__Impl : ( 'size' ) ;
    public final void rule__VideoDescription__Group_3_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:1596:1: ( ( 'size' ) )
            // InternalVideoGen.g:1597:1: ( 'size' )
            {
            // InternalVideoGen.g:1597:1: ( 'size' )
            // InternalVideoGen.g:1598:1: 'size'
            {
             before(grammarAccess.getVideoDescriptionAccess().getSizeKeyword_3_3_0()); 
            match(input,23,FOLLOW_2); 
             after(grammarAccess.getVideoDescriptionAccess().getSizeKeyword_3_3_0()); 

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
    // $ANTLR end "rule__VideoDescription__Group_3_3__0__Impl"


    // $ANTLR start "rule__VideoDescription__Group_3_3__1"
    // InternalVideoGen.g:1611:1: rule__VideoDescription__Group_3_3__1 : rule__VideoDescription__Group_3_3__1__Impl ;
    public final void rule__VideoDescription__Group_3_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:1615:1: ( rule__VideoDescription__Group_3_3__1__Impl )
            // InternalVideoGen.g:1616:2: rule__VideoDescription__Group_3_3__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__VideoDescription__Group_3_3__1__Impl();

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
    // $ANTLR end "rule__VideoDescription__Group_3_3__1"


    // $ANTLR start "rule__VideoDescription__Group_3_3__1__Impl"
    // InternalVideoGen.g:1622:1: rule__VideoDescription__Group_3_3__1__Impl : ( ( rule__VideoDescription__SizeAssignment_3_3_1 ) ) ;
    public final void rule__VideoDescription__Group_3_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:1626:1: ( ( ( rule__VideoDescription__SizeAssignment_3_3_1 ) ) )
            // InternalVideoGen.g:1627:1: ( ( rule__VideoDescription__SizeAssignment_3_3_1 ) )
            {
            // InternalVideoGen.g:1627:1: ( ( rule__VideoDescription__SizeAssignment_3_3_1 ) )
            // InternalVideoGen.g:1628:1: ( rule__VideoDescription__SizeAssignment_3_3_1 )
            {
             before(grammarAccess.getVideoDescriptionAccess().getSizeAssignment_3_3_1()); 
            // InternalVideoGen.g:1629:1: ( rule__VideoDescription__SizeAssignment_3_3_1 )
            // InternalVideoGen.g:1629:2: rule__VideoDescription__SizeAssignment_3_3_1
            {
            pushFollow(FOLLOW_2);
            rule__VideoDescription__SizeAssignment_3_3_1();

            state._fsp--;


            }

             after(grammarAccess.getVideoDescriptionAccess().getSizeAssignment_3_3_1()); 

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
    // $ANTLR end "rule__VideoDescription__Group_3_3__1__Impl"


    // $ANTLR start "rule__VideoDescription__Group_3_4__0"
    // InternalVideoGen.g:1643:1: rule__VideoDescription__Group_3_4__0 : rule__VideoDescription__Group_3_4__0__Impl rule__VideoDescription__Group_3_4__1 ;
    public final void rule__VideoDescription__Group_3_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:1647:1: ( rule__VideoDescription__Group_3_4__0__Impl rule__VideoDescription__Group_3_4__1 )
            // InternalVideoGen.g:1648:2: rule__VideoDescription__Group_3_4__0__Impl rule__VideoDescription__Group_3_4__1
            {
            pushFollow(FOLLOW_10);
            rule__VideoDescription__Group_3_4__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__VideoDescription__Group_3_4__1();

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
    // $ANTLR end "rule__VideoDescription__Group_3_4__0"


    // $ANTLR start "rule__VideoDescription__Group_3_4__0__Impl"
    // InternalVideoGen.g:1655:1: rule__VideoDescription__Group_3_4__0__Impl : ( 'description' ) ;
    public final void rule__VideoDescription__Group_3_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:1659:1: ( ( 'description' ) )
            // InternalVideoGen.g:1660:1: ( 'description' )
            {
            // InternalVideoGen.g:1660:1: ( 'description' )
            // InternalVideoGen.g:1661:1: 'description'
            {
             before(grammarAccess.getVideoDescriptionAccess().getDescriptionKeyword_3_4_0()); 
            match(input,24,FOLLOW_2); 
             after(grammarAccess.getVideoDescriptionAccess().getDescriptionKeyword_3_4_0()); 

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
    // $ANTLR end "rule__VideoDescription__Group_3_4__0__Impl"


    // $ANTLR start "rule__VideoDescription__Group_3_4__1"
    // InternalVideoGen.g:1674:1: rule__VideoDescription__Group_3_4__1 : rule__VideoDescription__Group_3_4__1__Impl ;
    public final void rule__VideoDescription__Group_3_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:1678:1: ( rule__VideoDescription__Group_3_4__1__Impl )
            // InternalVideoGen.g:1679:2: rule__VideoDescription__Group_3_4__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__VideoDescription__Group_3_4__1__Impl();

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
    // $ANTLR end "rule__VideoDescription__Group_3_4__1"


    // $ANTLR start "rule__VideoDescription__Group_3_4__1__Impl"
    // InternalVideoGen.g:1685:1: rule__VideoDescription__Group_3_4__1__Impl : ( ( rule__VideoDescription__DescriptionAssignment_3_4_1 ) ) ;
    public final void rule__VideoDescription__Group_3_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:1689:1: ( ( ( rule__VideoDescription__DescriptionAssignment_3_4_1 ) ) )
            // InternalVideoGen.g:1690:1: ( ( rule__VideoDescription__DescriptionAssignment_3_4_1 ) )
            {
            // InternalVideoGen.g:1690:1: ( ( rule__VideoDescription__DescriptionAssignment_3_4_1 ) )
            // InternalVideoGen.g:1691:1: ( rule__VideoDescription__DescriptionAssignment_3_4_1 )
            {
             before(grammarAccess.getVideoDescriptionAccess().getDescriptionAssignment_3_4_1()); 
            // InternalVideoGen.g:1692:1: ( rule__VideoDescription__DescriptionAssignment_3_4_1 )
            // InternalVideoGen.g:1692:2: rule__VideoDescription__DescriptionAssignment_3_4_1
            {
            pushFollow(FOLLOW_2);
            rule__VideoDescription__DescriptionAssignment_3_4_1();

            state._fsp--;


            }

             after(grammarAccess.getVideoDescriptionAccess().getDescriptionAssignment_3_4_1()); 

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
    // $ANTLR end "rule__VideoDescription__Group_3_4__1__Impl"


    // $ANTLR start "rule__VideoDescription__Group_3_5__0"
    // InternalVideoGen.g:1706:1: rule__VideoDescription__Group_3_5__0 : rule__VideoDescription__Group_3_5__0__Impl rule__VideoDescription__Group_3_5__1 ;
    public final void rule__VideoDescription__Group_3_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:1710:1: ( rule__VideoDescription__Group_3_5__0__Impl rule__VideoDescription__Group_3_5__1 )
            // InternalVideoGen.g:1711:2: rule__VideoDescription__Group_3_5__0__Impl rule__VideoDescription__Group_3_5__1
            {
            pushFollow(FOLLOW_4);
            rule__VideoDescription__Group_3_5__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__VideoDescription__Group_3_5__1();

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
    // $ANTLR end "rule__VideoDescription__Group_3_5__0"


    // $ANTLR start "rule__VideoDescription__Group_3_5__0__Impl"
    // InternalVideoGen.g:1718:1: rule__VideoDescription__Group_3_5__0__Impl : ( 'filters' ) ;
    public final void rule__VideoDescription__Group_3_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:1722:1: ( ( 'filters' ) )
            // InternalVideoGen.g:1723:1: ( 'filters' )
            {
            // InternalVideoGen.g:1723:1: ( 'filters' )
            // InternalVideoGen.g:1724:1: 'filters'
            {
             before(grammarAccess.getVideoDescriptionAccess().getFiltersKeyword_3_5_0()); 
            match(input,25,FOLLOW_2); 
             after(grammarAccess.getVideoDescriptionAccess().getFiltersKeyword_3_5_0()); 

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
    // $ANTLR end "rule__VideoDescription__Group_3_5__0__Impl"


    // $ANTLR start "rule__VideoDescription__Group_3_5__1"
    // InternalVideoGen.g:1737:1: rule__VideoDescription__Group_3_5__1 : rule__VideoDescription__Group_3_5__1__Impl ;
    public final void rule__VideoDescription__Group_3_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:1741:1: ( rule__VideoDescription__Group_3_5__1__Impl )
            // InternalVideoGen.g:1742:2: rule__VideoDescription__Group_3_5__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__VideoDescription__Group_3_5__1__Impl();

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
    // $ANTLR end "rule__VideoDescription__Group_3_5__1"


    // $ANTLR start "rule__VideoDescription__Group_3_5__1__Impl"
    // InternalVideoGen.g:1748:1: rule__VideoDescription__Group_3_5__1__Impl : ( ( ( rule__VideoDescription__FiltersAssignment_3_5_1 ) ) ( ( rule__VideoDescription__FiltersAssignment_3_5_1 )* ) ) ;
    public final void rule__VideoDescription__Group_3_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:1752:1: ( ( ( ( rule__VideoDescription__FiltersAssignment_3_5_1 ) ) ( ( rule__VideoDescription__FiltersAssignment_3_5_1 )* ) ) )
            // InternalVideoGen.g:1753:1: ( ( ( rule__VideoDescription__FiltersAssignment_3_5_1 ) ) ( ( rule__VideoDescription__FiltersAssignment_3_5_1 )* ) )
            {
            // InternalVideoGen.g:1753:1: ( ( ( rule__VideoDescription__FiltersAssignment_3_5_1 ) ) ( ( rule__VideoDescription__FiltersAssignment_3_5_1 )* ) )
            // InternalVideoGen.g:1754:1: ( ( rule__VideoDescription__FiltersAssignment_3_5_1 ) ) ( ( rule__VideoDescription__FiltersAssignment_3_5_1 )* )
            {
            // InternalVideoGen.g:1754:1: ( ( rule__VideoDescription__FiltersAssignment_3_5_1 ) )
            // InternalVideoGen.g:1755:1: ( rule__VideoDescription__FiltersAssignment_3_5_1 )
            {
             before(grammarAccess.getVideoDescriptionAccess().getFiltersAssignment_3_5_1()); 
            // InternalVideoGen.g:1756:1: ( rule__VideoDescription__FiltersAssignment_3_5_1 )
            // InternalVideoGen.g:1756:2: rule__VideoDescription__FiltersAssignment_3_5_1
            {
            pushFollow(FOLLOW_17);
            rule__VideoDescription__FiltersAssignment_3_5_1();

            state._fsp--;


            }

             after(grammarAccess.getVideoDescriptionAccess().getFiltersAssignment_3_5_1()); 

            }

            // InternalVideoGen.g:1759:1: ( ( rule__VideoDescription__FiltersAssignment_3_5_1 )* )
            // InternalVideoGen.g:1760:1: ( rule__VideoDescription__FiltersAssignment_3_5_1 )*
            {
             before(grammarAccess.getVideoDescriptionAccess().getFiltersAssignment_3_5_1()); 
            // InternalVideoGen.g:1761:1: ( rule__VideoDescription__FiltersAssignment_3_5_1 )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==RULE_LEFT_BRACKET) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // InternalVideoGen.g:1761:2: rule__VideoDescription__FiltersAssignment_3_5_1
            	    {
            	    pushFollow(FOLLOW_17);
            	    rule__VideoDescription__FiltersAssignment_3_5_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop15;
                }
            } while (true);

             after(grammarAccess.getVideoDescriptionAccess().getFiltersAssignment_3_5_1()); 

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
    // $ANTLR end "rule__VideoDescription__Group_3_5__1__Impl"


    // $ANTLR start "rule__Filter__Group__0"
    // InternalVideoGen.g:1776:1: rule__Filter__Group__0 : rule__Filter__Group__0__Impl rule__Filter__Group__1 ;
    public final void rule__Filter__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:1780:1: ( rule__Filter__Group__0__Impl rule__Filter__Group__1 )
            // InternalVideoGen.g:1781:2: rule__Filter__Group__0__Impl rule__Filter__Group__1
            {
            pushFollow(FOLLOW_10);
            rule__Filter__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Filter__Group__1();

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
    // $ANTLR end "rule__Filter__Group__0"


    // $ANTLR start "rule__Filter__Group__0__Impl"
    // InternalVideoGen.g:1788:1: rule__Filter__Group__0__Impl : ( RULE_LEFT_BRACKET ) ;
    public final void rule__Filter__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:1792:1: ( ( RULE_LEFT_BRACKET ) )
            // InternalVideoGen.g:1793:1: ( RULE_LEFT_BRACKET )
            {
            // InternalVideoGen.g:1793:1: ( RULE_LEFT_BRACKET )
            // InternalVideoGen.g:1794:1: RULE_LEFT_BRACKET
            {
             before(grammarAccess.getFilterAccess().getLEFT_BRACKETTerminalRuleCall_0()); 
            match(input,RULE_LEFT_BRACKET,FOLLOW_2); 
             after(grammarAccess.getFilterAccess().getLEFT_BRACKETTerminalRuleCall_0()); 

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
    // $ANTLR end "rule__Filter__Group__0__Impl"


    // $ANTLR start "rule__Filter__Group__1"
    // InternalVideoGen.g:1805:1: rule__Filter__Group__1 : rule__Filter__Group__1__Impl rule__Filter__Group__2 ;
    public final void rule__Filter__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:1809:1: ( rule__Filter__Group__1__Impl rule__Filter__Group__2 )
            // InternalVideoGen.g:1810:2: rule__Filter__Group__1__Impl rule__Filter__Group__2
            {
            pushFollow(FOLLOW_6);
            rule__Filter__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Filter__Group__2();

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
    // $ANTLR end "rule__Filter__Group__1"


    // $ANTLR start "rule__Filter__Group__1__Impl"
    // InternalVideoGen.g:1817:1: rule__Filter__Group__1__Impl : ( ( rule__Filter__FilterAssignment_1 ) ) ;
    public final void rule__Filter__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:1821:1: ( ( ( rule__Filter__FilterAssignment_1 ) ) )
            // InternalVideoGen.g:1822:1: ( ( rule__Filter__FilterAssignment_1 ) )
            {
            // InternalVideoGen.g:1822:1: ( ( rule__Filter__FilterAssignment_1 ) )
            // InternalVideoGen.g:1823:1: ( rule__Filter__FilterAssignment_1 )
            {
             before(grammarAccess.getFilterAccess().getFilterAssignment_1()); 
            // InternalVideoGen.g:1824:1: ( rule__Filter__FilterAssignment_1 )
            // InternalVideoGen.g:1824:2: rule__Filter__FilterAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__Filter__FilterAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getFilterAccess().getFilterAssignment_1()); 

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
    // $ANTLR end "rule__Filter__Group__1__Impl"


    // $ANTLR start "rule__Filter__Group__2"
    // InternalVideoGen.g:1834:1: rule__Filter__Group__2 : rule__Filter__Group__2__Impl ;
    public final void rule__Filter__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:1838:1: ( rule__Filter__Group__2__Impl )
            // InternalVideoGen.g:1839:2: rule__Filter__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Filter__Group__2__Impl();

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
    // $ANTLR end "rule__Filter__Group__2"


    // $ANTLR start "rule__Filter__Group__2__Impl"
    // InternalVideoGen.g:1845:1: rule__Filter__Group__2__Impl : ( RULE_RIGHT_BRACKET ) ;
    public final void rule__Filter__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:1849:1: ( ( RULE_RIGHT_BRACKET ) )
            // InternalVideoGen.g:1850:1: ( RULE_RIGHT_BRACKET )
            {
            // InternalVideoGen.g:1850:1: ( RULE_RIGHT_BRACKET )
            // InternalVideoGen.g:1851:1: RULE_RIGHT_BRACKET
            {
             before(grammarAccess.getFilterAccess().getRIGHT_BRACKETTerminalRuleCall_2()); 
            match(input,RULE_RIGHT_BRACKET,FOLLOW_2); 
             after(grammarAccess.getFilterAccess().getRIGHT_BRACKETTerminalRuleCall_2()); 

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
    // $ANTLR end "rule__Filter__Group__2__Impl"


    // $ANTLR start "rule__VideoGeneratorModel__InformationAssignment_1"
    // InternalVideoGen.g:1869:1: rule__VideoGeneratorModel__InformationAssignment_1 : ( ruleVideoGenInformation ) ;
    public final void rule__VideoGeneratorModel__InformationAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:1873:1: ( ( ruleVideoGenInformation ) )
            // InternalVideoGen.g:1874:1: ( ruleVideoGenInformation )
            {
            // InternalVideoGen.g:1874:1: ( ruleVideoGenInformation )
            // InternalVideoGen.g:1875:1: ruleVideoGenInformation
            {
             before(grammarAccess.getVideoGeneratorModelAccess().getInformationVideoGenInformationParserRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleVideoGenInformation();

            state._fsp--;

             after(grammarAccess.getVideoGeneratorModelAccess().getInformationVideoGenInformationParserRuleCall_1_0()); 

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
    // $ANTLR end "rule__VideoGeneratorModel__InformationAssignment_1"


    // $ANTLR start "rule__VideoGeneratorModel__VideoseqsAssignment_4"
    // InternalVideoGen.g:1884:1: rule__VideoGeneratorModel__VideoseqsAssignment_4 : ( ruleVideoSeq ) ;
    public final void rule__VideoGeneratorModel__VideoseqsAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:1888:1: ( ( ruleVideoSeq ) )
            // InternalVideoGen.g:1889:1: ( ruleVideoSeq )
            {
            // InternalVideoGen.g:1889:1: ( ruleVideoSeq )
            // InternalVideoGen.g:1890:1: ruleVideoSeq
            {
             before(grammarAccess.getVideoGeneratorModelAccess().getVideoseqsVideoSeqParserRuleCall_4_0()); 
            pushFollow(FOLLOW_2);
            ruleVideoSeq();

            state._fsp--;

             after(grammarAccess.getVideoGeneratorModelAccess().getVideoseqsVideoSeqParserRuleCall_4_0()); 

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
    // $ANTLR end "rule__VideoGeneratorModel__VideoseqsAssignment_4"


    // $ANTLR start "rule__VideoGenInformation__AuthorNameAssignment_1_1"
    // InternalVideoGen.g:1899:1: rule__VideoGenInformation__AuthorNameAssignment_1_1 : ( RULE_STRING ) ;
    public final void rule__VideoGenInformation__AuthorNameAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:1903:1: ( ( RULE_STRING ) )
            // InternalVideoGen.g:1904:1: ( RULE_STRING )
            {
            // InternalVideoGen.g:1904:1: ( RULE_STRING )
            // InternalVideoGen.g:1905:1: RULE_STRING
            {
             before(grammarAccess.getVideoGenInformationAccess().getAuthorNameSTRINGTerminalRuleCall_1_1_0()); 
            match(input,RULE_STRING,FOLLOW_2); 
             after(grammarAccess.getVideoGenInformationAccess().getAuthorNameSTRINGTerminalRuleCall_1_1_0()); 

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
    // $ANTLR end "rule__VideoGenInformation__AuthorNameAssignment_1_1"


    // $ANTLR start "rule__VideoGenInformation__VersionAssignment_2_1"
    // InternalVideoGen.g:1914:1: rule__VideoGenInformation__VersionAssignment_2_1 : ( RULE_STRING ) ;
    public final void rule__VideoGenInformation__VersionAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:1918:1: ( ( RULE_STRING ) )
            // InternalVideoGen.g:1919:1: ( RULE_STRING )
            {
            // InternalVideoGen.g:1919:1: ( RULE_STRING )
            // InternalVideoGen.g:1920:1: RULE_STRING
            {
             before(grammarAccess.getVideoGenInformationAccess().getVersionSTRINGTerminalRuleCall_2_1_0()); 
            match(input,RULE_STRING,FOLLOW_2); 
             after(grammarAccess.getVideoGenInformationAccess().getVersionSTRINGTerminalRuleCall_2_1_0()); 

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
    // $ANTLR end "rule__VideoGenInformation__VersionAssignment_2_1"


    // $ANTLR start "rule__VideoGenInformation__CreationDateAssignment_3_1"
    // InternalVideoGen.g:1929:1: rule__VideoGenInformation__CreationDateAssignment_3_1 : ( RULE_STRING ) ;
    public final void rule__VideoGenInformation__CreationDateAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:1933:1: ( ( RULE_STRING ) )
            // InternalVideoGen.g:1934:1: ( RULE_STRING )
            {
            // InternalVideoGen.g:1934:1: ( RULE_STRING )
            // InternalVideoGen.g:1935:1: RULE_STRING
            {
             before(grammarAccess.getVideoGenInformationAccess().getCreationDateSTRINGTerminalRuleCall_3_1_0()); 
            match(input,RULE_STRING,FOLLOW_2); 
             after(grammarAccess.getVideoGenInformationAccess().getCreationDateSTRINGTerminalRuleCall_3_1_0()); 

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
    // $ANTLR end "rule__VideoGenInformation__CreationDateAssignment_3_1"


    // $ANTLR start "rule__MandatoryVideoSeq__DescriptionAssignment_1"
    // InternalVideoGen.g:1944:1: rule__MandatoryVideoSeq__DescriptionAssignment_1 : ( ruleVideoDescription ) ;
    public final void rule__MandatoryVideoSeq__DescriptionAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:1948:1: ( ( ruleVideoDescription ) )
            // InternalVideoGen.g:1949:1: ( ruleVideoDescription )
            {
            // InternalVideoGen.g:1949:1: ( ruleVideoDescription )
            // InternalVideoGen.g:1950:1: ruleVideoDescription
            {
             before(grammarAccess.getMandatoryVideoSeqAccess().getDescriptionVideoDescriptionParserRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleVideoDescription();

            state._fsp--;

             after(grammarAccess.getMandatoryVideoSeqAccess().getDescriptionVideoDescriptionParserRuleCall_1_0()); 

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
    // $ANTLR end "rule__MandatoryVideoSeq__DescriptionAssignment_1"


    // $ANTLR start "rule__OptionalVideoSeq__DescriptionAssignment_1"
    // InternalVideoGen.g:1959:1: rule__OptionalVideoSeq__DescriptionAssignment_1 : ( ruleVideoDescription ) ;
    public final void rule__OptionalVideoSeq__DescriptionAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:1963:1: ( ( ruleVideoDescription ) )
            // InternalVideoGen.g:1964:1: ( ruleVideoDescription )
            {
            // InternalVideoGen.g:1964:1: ( ruleVideoDescription )
            // InternalVideoGen.g:1965:1: ruleVideoDescription
            {
             before(grammarAccess.getOptionalVideoSeqAccess().getDescriptionVideoDescriptionParserRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleVideoDescription();

            state._fsp--;

             after(grammarAccess.getOptionalVideoSeqAccess().getDescriptionVideoDescriptionParserRuleCall_1_0()); 

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
    // $ANTLR end "rule__OptionalVideoSeq__DescriptionAssignment_1"


    // $ANTLR start "rule__AlternativeVideoSeq__VideoidAssignment_1"
    // InternalVideoGen.g:1974:1: rule__AlternativeVideoSeq__VideoidAssignment_1 : ( RULE_ID ) ;
    public final void rule__AlternativeVideoSeq__VideoidAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:1978:1: ( ( RULE_ID ) )
            // InternalVideoGen.g:1979:1: ( RULE_ID )
            {
            // InternalVideoGen.g:1979:1: ( RULE_ID )
            // InternalVideoGen.g:1980:1: RULE_ID
            {
             before(grammarAccess.getAlternativeVideoSeqAccess().getVideoidIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getAlternativeVideoSeqAccess().getVideoidIDTerminalRuleCall_1_0()); 

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
    // $ANTLR end "rule__AlternativeVideoSeq__VideoidAssignment_1"


    // $ANTLR start "rule__AlternativeVideoSeq__VideodescsAssignment_3"
    // InternalVideoGen.g:1989:1: rule__AlternativeVideoSeq__VideodescsAssignment_3 : ( ruleVideoDescription ) ;
    public final void rule__AlternativeVideoSeq__VideodescsAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:1993:1: ( ( ruleVideoDescription ) )
            // InternalVideoGen.g:1994:1: ( ruleVideoDescription )
            {
            // InternalVideoGen.g:1994:1: ( ruleVideoDescription )
            // InternalVideoGen.g:1995:1: ruleVideoDescription
            {
             before(grammarAccess.getAlternativeVideoSeqAccess().getVideodescsVideoDescriptionParserRuleCall_3_0()); 
            pushFollow(FOLLOW_2);
            ruleVideoDescription();

            state._fsp--;

             after(grammarAccess.getAlternativeVideoSeqAccess().getVideodescsVideoDescriptionParserRuleCall_3_0()); 

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
    // $ANTLR end "rule__AlternativeVideoSeq__VideodescsAssignment_3"


    // $ANTLR start "rule__VideoDescription__VideoidAssignment_1"
    // InternalVideoGen.g:2004:1: rule__VideoDescription__VideoidAssignment_1 : ( RULE_ID ) ;
    public final void rule__VideoDescription__VideoidAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:2008:1: ( ( RULE_ID ) )
            // InternalVideoGen.g:2009:1: ( RULE_ID )
            {
            // InternalVideoGen.g:2009:1: ( RULE_ID )
            // InternalVideoGen.g:2010:1: RULE_ID
            {
             before(grammarAccess.getVideoDescriptionAccess().getVideoidIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getVideoDescriptionAccess().getVideoidIDTerminalRuleCall_1_0()); 

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
    // $ANTLR end "rule__VideoDescription__VideoidAssignment_1"


    // $ANTLR start "rule__VideoDescription__LocationAssignment_2"
    // InternalVideoGen.g:2019:1: rule__VideoDescription__LocationAssignment_2 : ( RULE_STRING ) ;
    public final void rule__VideoDescription__LocationAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:2023:1: ( ( RULE_STRING ) )
            // InternalVideoGen.g:2024:1: ( RULE_STRING )
            {
            // InternalVideoGen.g:2024:1: ( RULE_STRING )
            // InternalVideoGen.g:2025:1: RULE_STRING
            {
             before(grammarAccess.getVideoDescriptionAccess().getLocationSTRINGTerminalRuleCall_2_0()); 
            match(input,RULE_STRING,FOLLOW_2); 
             after(grammarAccess.getVideoDescriptionAccess().getLocationSTRINGTerminalRuleCall_2_0()); 

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
    // $ANTLR end "rule__VideoDescription__LocationAssignment_2"


    // $ANTLR start "rule__VideoDescription__DurationAssignment_3_1_1"
    // InternalVideoGen.g:2034:1: rule__VideoDescription__DurationAssignment_3_1_1 : ( RULE_INT ) ;
    public final void rule__VideoDescription__DurationAssignment_3_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:2038:1: ( ( RULE_INT ) )
            // InternalVideoGen.g:2039:1: ( RULE_INT )
            {
            // InternalVideoGen.g:2039:1: ( RULE_INT )
            // InternalVideoGen.g:2040:1: RULE_INT
            {
             before(grammarAccess.getVideoDescriptionAccess().getDurationINTTerminalRuleCall_3_1_1_0()); 
            match(input,RULE_INT,FOLLOW_2); 
             after(grammarAccess.getVideoDescriptionAccess().getDurationINTTerminalRuleCall_3_1_1_0()); 

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
    // $ANTLR end "rule__VideoDescription__DurationAssignment_3_1_1"


    // $ANTLR start "rule__VideoDescription__ProbabilityAssignment_3_2_1"
    // InternalVideoGen.g:2049:1: rule__VideoDescription__ProbabilityAssignment_3_2_1 : ( RULE_INT ) ;
    public final void rule__VideoDescription__ProbabilityAssignment_3_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:2053:1: ( ( RULE_INT ) )
            // InternalVideoGen.g:2054:1: ( RULE_INT )
            {
            // InternalVideoGen.g:2054:1: ( RULE_INT )
            // InternalVideoGen.g:2055:1: RULE_INT
            {
             before(grammarAccess.getVideoDescriptionAccess().getProbabilityINTTerminalRuleCall_3_2_1_0()); 
            match(input,RULE_INT,FOLLOW_2); 
             after(grammarAccess.getVideoDescriptionAccess().getProbabilityINTTerminalRuleCall_3_2_1_0()); 

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
    // $ANTLR end "rule__VideoDescription__ProbabilityAssignment_3_2_1"


    // $ANTLR start "rule__VideoDescription__SizeAssignment_3_3_1"
    // InternalVideoGen.g:2064:1: rule__VideoDescription__SizeAssignment_3_3_1 : ( RULE_INT ) ;
    public final void rule__VideoDescription__SizeAssignment_3_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:2068:1: ( ( RULE_INT ) )
            // InternalVideoGen.g:2069:1: ( RULE_INT )
            {
            // InternalVideoGen.g:2069:1: ( RULE_INT )
            // InternalVideoGen.g:2070:1: RULE_INT
            {
             before(grammarAccess.getVideoDescriptionAccess().getSizeINTTerminalRuleCall_3_3_1_0()); 
            match(input,RULE_INT,FOLLOW_2); 
             after(grammarAccess.getVideoDescriptionAccess().getSizeINTTerminalRuleCall_3_3_1_0()); 

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
    // $ANTLR end "rule__VideoDescription__SizeAssignment_3_3_1"


    // $ANTLR start "rule__VideoDescription__DescriptionAssignment_3_4_1"
    // InternalVideoGen.g:2079:1: rule__VideoDescription__DescriptionAssignment_3_4_1 : ( RULE_STRING ) ;
    public final void rule__VideoDescription__DescriptionAssignment_3_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:2083:1: ( ( RULE_STRING ) )
            // InternalVideoGen.g:2084:1: ( RULE_STRING )
            {
            // InternalVideoGen.g:2084:1: ( RULE_STRING )
            // InternalVideoGen.g:2085:1: RULE_STRING
            {
             before(grammarAccess.getVideoDescriptionAccess().getDescriptionSTRINGTerminalRuleCall_3_4_1_0()); 
            match(input,RULE_STRING,FOLLOW_2); 
             after(grammarAccess.getVideoDescriptionAccess().getDescriptionSTRINGTerminalRuleCall_3_4_1_0()); 

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
    // $ANTLR end "rule__VideoDescription__DescriptionAssignment_3_4_1"


    // $ANTLR start "rule__VideoDescription__FiltersAssignment_3_5_1"
    // InternalVideoGen.g:2094:1: rule__VideoDescription__FiltersAssignment_3_5_1 : ( ruleFilter ) ;
    public final void rule__VideoDescription__FiltersAssignment_3_5_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:2098:1: ( ( ruleFilter ) )
            // InternalVideoGen.g:2099:1: ( ruleFilter )
            {
            // InternalVideoGen.g:2099:1: ( ruleFilter )
            // InternalVideoGen.g:2100:1: ruleFilter
            {
             before(grammarAccess.getVideoDescriptionAccess().getFiltersFilterParserRuleCall_3_5_1_0()); 
            pushFollow(FOLLOW_2);
            ruleFilter();

            state._fsp--;

             after(grammarAccess.getVideoDescriptionAccess().getFiltersFilterParserRuleCall_3_5_1_0()); 

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
    // $ANTLR end "rule__VideoDescription__FiltersAssignment_3_5_1"


    // $ANTLR start "rule__Filter__FilterAssignment_1"
    // InternalVideoGen.g:2109:1: rule__Filter__FilterAssignment_1 : ( RULE_STRING ) ;
    public final void rule__Filter__FilterAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:2113:1: ( ( RULE_STRING ) )
            // InternalVideoGen.g:2114:1: ( RULE_STRING )
            {
            // InternalVideoGen.g:2114:1: ( RULE_STRING )
            // InternalVideoGen.g:2115:1: RULE_STRING
            {
             before(grammarAccess.getFilterAccess().getFilterSTRINGTerminalRuleCall_1_0()); 
            match(input,RULE_STRING,FOLLOW_2); 
             after(grammarAccess.getFilterAccess().getFilterSTRINGTerminalRuleCall_1_0()); 

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
    // $ANTLR end "rule__Filter__FilterAssignment_1"

    // Delegated rules


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000006000L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x00000000000E0000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x00000000000E0002L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000018000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000000090L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x00000000000000C0L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000003E00020L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000000000012L});

}