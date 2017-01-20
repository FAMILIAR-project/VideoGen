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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_LEFT_BRACKET", "RULE_RIGHT_BRACKET", "RULE_STRING", "RULE_ID", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'VideoGen'", "'@author'", "'@version'", "'@creation'", "'mandatory'", "'optional'", "'alternatives'", "'videoseq'", "'duration'", "'probability'", "'size'", "'textIncrust'", "'filter'", "'description'"
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
    public static final int T__26=26;
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


    // $ANTLR start "rule__VideoSeq__Alternatives"
    // InternalVideoGen.g:256:1: rule__VideoSeq__Alternatives : ( ( ruleMandatoryVideoSeq ) | ( ruleOptionalVideoSeq ) | ( ruleAlternativeVideoSeq ) );
    public final void rule__VideoSeq__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:260:1: ( ( ruleMandatoryVideoSeq ) | ( ruleOptionalVideoSeq ) | ( ruleAlternativeVideoSeq ) )
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
                    // InternalVideoGen.g:261:1: ( ruleMandatoryVideoSeq )
                    {
                    // InternalVideoGen.g:261:1: ( ruleMandatoryVideoSeq )
                    // InternalVideoGen.g:262:1: ruleMandatoryVideoSeq
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
                    // InternalVideoGen.g:267:6: ( ruleOptionalVideoSeq )
                    {
                    // InternalVideoGen.g:267:6: ( ruleOptionalVideoSeq )
                    // InternalVideoGen.g:268:1: ruleOptionalVideoSeq
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
                    // InternalVideoGen.g:273:6: ( ruleAlternativeVideoSeq )
                    {
                    // InternalVideoGen.g:273:6: ( ruleAlternativeVideoSeq )
                    // InternalVideoGen.g:274:1: ruleAlternativeVideoSeq
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
    // InternalVideoGen.g:286:1: rule__VideoGeneratorModel__Group__0 : rule__VideoGeneratorModel__Group__0__Impl rule__VideoGeneratorModel__Group__1 ;
    public final void rule__VideoGeneratorModel__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:290:1: ( rule__VideoGeneratorModel__Group__0__Impl rule__VideoGeneratorModel__Group__1 )
            // InternalVideoGen.g:291:2: rule__VideoGeneratorModel__Group__0__Impl rule__VideoGeneratorModel__Group__1
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
    // InternalVideoGen.g:298:1: rule__VideoGeneratorModel__Group__0__Impl : ( () ) ;
    public final void rule__VideoGeneratorModel__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:302:1: ( ( () ) )
            // InternalVideoGen.g:303:1: ( () )
            {
            // InternalVideoGen.g:303:1: ( () )
            // InternalVideoGen.g:304:1: ()
            {
             before(grammarAccess.getVideoGeneratorModelAccess().getVideoGeneratorModelAction_0()); 
            // InternalVideoGen.g:305:1: ()
            // InternalVideoGen.g:307:1: 
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
    // InternalVideoGen.g:317:1: rule__VideoGeneratorModel__Group__1 : rule__VideoGeneratorModel__Group__1__Impl rule__VideoGeneratorModel__Group__2 ;
    public final void rule__VideoGeneratorModel__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:321:1: ( rule__VideoGeneratorModel__Group__1__Impl rule__VideoGeneratorModel__Group__2 )
            // InternalVideoGen.g:322:2: rule__VideoGeneratorModel__Group__1__Impl rule__VideoGeneratorModel__Group__2
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
    // InternalVideoGen.g:329:1: rule__VideoGeneratorModel__Group__1__Impl : ( ( rule__VideoGeneratorModel__InformationAssignment_1 )? ) ;
    public final void rule__VideoGeneratorModel__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:333:1: ( ( ( rule__VideoGeneratorModel__InformationAssignment_1 )? ) )
            // InternalVideoGen.g:334:1: ( ( rule__VideoGeneratorModel__InformationAssignment_1 )? )
            {
            // InternalVideoGen.g:334:1: ( ( rule__VideoGeneratorModel__InformationAssignment_1 )? )
            // InternalVideoGen.g:335:1: ( rule__VideoGeneratorModel__InformationAssignment_1 )?
            {
             before(grammarAccess.getVideoGeneratorModelAccess().getInformationAssignment_1()); 
            // InternalVideoGen.g:336:1: ( rule__VideoGeneratorModel__InformationAssignment_1 )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==14) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // InternalVideoGen.g:336:2: rule__VideoGeneratorModel__InformationAssignment_1
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
    // InternalVideoGen.g:346:1: rule__VideoGeneratorModel__Group__2 : rule__VideoGeneratorModel__Group__2__Impl rule__VideoGeneratorModel__Group__3 ;
    public final void rule__VideoGeneratorModel__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:350:1: ( rule__VideoGeneratorModel__Group__2__Impl rule__VideoGeneratorModel__Group__3 )
            // InternalVideoGen.g:351:2: rule__VideoGeneratorModel__Group__2__Impl rule__VideoGeneratorModel__Group__3
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
    // InternalVideoGen.g:358:1: rule__VideoGeneratorModel__Group__2__Impl : ( 'VideoGen' ) ;
    public final void rule__VideoGeneratorModel__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:362:1: ( ( 'VideoGen' ) )
            // InternalVideoGen.g:363:1: ( 'VideoGen' )
            {
            // InternalVideoGen.g:363:1: ( 'VideoGen' )
            // InternalVideoGen.g:364:1: 'VideoGen'
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
    // InternalVideoGen.g:377:1: rule__VideoGeneratorModel__Group__3 : rule__VideoGeneratorModel__Group__3__Impl rule__VideoGeneratorModel__Group__4 ;
    public final void rule__VideoGeneratorModel__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:381:1: ( rule__VideoGeneratorModel__Group__3__Impl rule__VideoGeneratorModel__Group__4 )
            // InternalVideoGen.g:382:2: rule__VideoGeneratorModel__Group__3__Impl rule__VideoGeneratorModel__Group__4
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
    // InternalVideoGen.g:389:1: rule__VideoGeneratorModel__Group__3__Impl : ( RULE_LEFT_BRACKET ) ;
    public final void rule__VideoGeneratorModel__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:393:1: ( ( RULE_LEFT_BRACKET ) )
            // InternalVideoGen.g:394:1: ( RULE_LEFT_BRACKET )
            {
            // InternalVideoGen.g:394:1: ( RULE_LEFT_BRACKET )
            // InternalVideoGen.g:395:1: RULE_LEFT_BRACKET
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
    // InternalVideoGen.g:406:1: rule__VideoGeneratorModel__Group__4 : rule__VideoGeneratorModel__Group__4__Impl rule__VideoGeneratorModel__Group__5 ;
    public final void rule__VideoGeneratorModel__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:410:1: ( rule__VideoGeneratorModel__Group__4__Impl rule__VideoGeneratorModel__Group__5 )
            // InternalVideoGen.g:411:2: rule__VideoGeneratorModel__Group__4__Impl rule__VideoGeneratorModel__Group__5
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
    // InternalVideoGen.g:418:1: rule__VideoGeneratorModel__Group__4__Impl : ( ( ( rule__VideoGeneratorModel__VideoseqsAssignment_4 ) ) ( ( rule__VideoGeneratorModel__VideoseqsAssignment_4 )* ) ) ;
    public final void rule__VideoGeneratorModel__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:422:1: ( ( ( ( rule__VideoGeneratorModel__VideoseqsAssignment_4 ) ) ( ( rule__VideoGeneratorModel__VideoseqsAssignment_4 )* ) ) )
            // InternalVideoGen.g:423:1: ( ( ( rule__VideoGeneratorModel__VideoseqsAssignment_4 ) ) ( ( rule__VideoGeneratorModel__VideoseqsAssignment_4 )* ) )
            {
            // InternalVideoGen.g:423:1: ( ( ( rule__VideoGeneratorModel__VideoseqsAssignment_4 ) ) ( ( rule__VideoGeneratorModel__VideoseqsAssignment_4 )* ) )
            // InternalVideoGen.g:424:1: ( ( rule__VideoGeneratorModel__VideoseqsAssignment_4 ) ) ( ( rule__VideoGeneratorModel__VideoseqsAssignment_4 )* )
            {
            // InternalVideoGen.g:424:1: ( ( rule__VideoGeneratorModel__VideoseqsAssignment_4 ) )
            // InternalVideoGen.g:425:1: ( rule__VideoGeneratorModel__VideoseqsAssignment_4 )
            {
             before(grammarAccess.getVideoGeneratorModelAccess().getVideoseqsAssignment_4()); 
            // InternalVideoGen.g:426:1: ( rule__VideoGeneratorModel__VideoseqsAssignment_4 )
            // InternalVideoGen.g:426:2: rule__VideoGeneratorModel__VideoseqsAssignment_4
            {
            pushFollow(FOLLOW_7);
            rule__VideoGeneratorModel__VideoseqsAssignment_4();

            state._fsp--;


            }

             after(grammarAccess.getVideoGeneratorModelAccess().getVideoseqsAssignment_4()); 

            }

            // InternalVideoGen.g:429:1: ( ( rule__VideoGeneratorModel__VideoseqsAssignment_4 )* )
            // InternalVideoGen.g:430:1: ( rule__VideoGeneratorModel__VideoseqsAssignment_4 )*
            {
             before(grammarAccess.getVideoGeneratorModelAccess().getVideoseqsAssignment_4()); 
            // InternalVideoGen.g:431:1: ( rule__VideoGeneratorModel__VideoseqsAssignment_4 )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0>=17 && LA3_0<=19)) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // InternalVideoGen.g:431:2: rule__VideoGeneratorModel__VideoseqsAssignment_4
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
    // InternalVideoGen.g:442:1: rule__VideoGeneratorModel__Group__5 : rule__VideoGeneratorModel__Group__5__Impl ;
    public final void rule__VideoGeneratorModel__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:446:1: ( rule__VideoGeneratorModel__Group__5__Impl )
            // InternalVideoGen.g:447:2: rule__VideoGeneratorModel__Group__5__Impl
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
    // InternalVideoGen.g:453:1: rule__VideoGeneratorModel__Group__5__Impl : ( RULE_RIGHT_BRACKET ) ;
    public final void rule__VideoGeneratorModel__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:457:1: ( ( RULE_RIGHT_BRACKET ) )
            // InternalVideoGen.g:458:1: ( RULE_RIGHT_BRACKET )
            {
            // InternalVideoGen.g:458:1: ( RULE_RIGHT_BRACKET )
            // InternalVideoGen.g:459:1: RULE_RIGHT_BRACKET
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
    // InternalVideoGen.g:482:1: rule__VideoGenInformation__Group__0 : rule__VideoGenInformation__Group__0__Impl rule__VideoGenInformation__Group__1 ;
    public final void rule__VideoGenInformation__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:486:1: ( rule__VideoGenInformation__Group__0__Impl rule__VideoGenInformation__Group__1 )
            // InternalVideoGen.g:487:2: rule__VideoGenInformation__Group__0__Impl rule__VideoGenInformation__Group__1
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
    // InternalVideoGen.g:494:1: rule__VideoGenInformation__Group__0__Impl : ( () ) ;
    public final void rule__VideoGenInformation__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:498:1: ( ( () ) )
            // InternalVideoGen.g:499:1: ( () )
            {
            // InternalVideoGen.g:499:1: ( () )
            // InternalVideoGen.g:500:1: ()
            {
             before(grammarAccess.getVideoGenInformationAccess().getVideoGenInformationAction_0()); 
            // InternalVideoGen.g:501:1: ()
            // InternalVideoGen.g:503:1: 
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
    // InternalVideoGen.g:513:1: rule__VideoGenInformation__Group__1 : rule__VideoGenInformation__Group__1__Impl rule__VideoGenInformation__Group__2 ;
    public final void rule__VideoGenInformation__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:517:1: ( rule__VideoGenInformation__Group__1__Impl rule__VideoGenInformation__Group__2 )
            // InternalVideoGen.g:518:2: rule__VideoGenInformation__Group__1__Impl rule__VideoGenInformation__Group__2
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
    // InternalVideoGen.g:525:1: rule__VideoGenInformation__Group__1__Impl : ( ( rule__VideoGenInformation__Group_1__0 ) ) ;
    public final void rule__VideoGenInformation__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:529:1: ( ( ( rule__VideoGenInformation__Group_1__0 ) ) )
            // InternalVideoGen.g:530:1: ( ( rule__VideoGenInformation__Group_1__0 ) )
            {
            // InternalVideoGen.g:530:1: ( ( rule__VideoGenInformation__Group_1__0 ) )
            // InternalVideoGen.g:531:1: ( rule__VideoGenInformation__Group_1__0 )
            {
             before(grammarAccess.getVideoGenInformationAccess().getGroup_1()); 
            // InternalVideoGen.g:532:1: ( rule__VideoGenInformation__Group_1__0 )
            // InternalVideoGen.g:532:2: rule__VideoGenInformation__Group_1__0
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
    // InternalVideoGen.g:542:1: rule__VideoGenInformation__Group__2 : rule__VideoGenInformation__Group__2__Impl rule__VideoGenInformation__Group__3 ;
    public final void rule__VideoGenInformation__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:546:1: ( rule__VideoGenInformation__Group__2__Impl rule__VideoGenInformation__Group__3 )
            // InternalVideoGen.g:547:2: rule__VideoGenInformation__Group__2__Impl rule__VideoGenInformation__Group__3
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
    // InternalVideoGen.g:554:1: rule__VideoGenInformation__Group__2__Impl : ( ( rule__VideoGenInformation__Group_2__0 )? ) ;
    public final void rule__VideoGenInformation__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:558:1: ( ( ( rule__VideoGenInformation__Group_2__0 )? ) )
            // InternalVideoGen.g:559:1: ( ( rule__VideoGenInformation__Group_2__0 )? )
            {
            // InternalVideoGen.g:559:1: ( ( rule__VideoGenInformation__Group_2__0 )? )
            // InternalVideoGen.g:560:1: ( rule__VideoGenInformation__Group_2__0 )?
            {
             before(grammarAccess.getVideoGenInformationAccess().getGroup_2()); 
            // InternalVideoGen.g:561:1: ( rule__VideoGenInformation__Group_2__0 )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==15) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // InternalVideoGen.g:561:2: rule__VideoGenInformation__Group_2__0
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
    // InternalVideoGen.g:571:1: rule__VideoGenInformation__Group__3 : rule__VideoGenInformation__Group__3__Impl ;
    public final void rule__VideoGenInformation__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:575:1: ( rule__VideoGenInformation__Group__3__Impl )
            // InternalVideoGen.g:576:2: rule__VideoGenInformation__Group__3__Impl
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
    // InternalVideoGen.g:582:1: rule__VideoGenInformation__Group__3__Impl : ( ( rule__VideoGenInformation__Group_3__0 )? ) ;
    public final void rule__VideoGenInformation__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:586:1: ( ( ( rule__VideoGenInformation__Group_3__0 )? ) )
            // InternalVideoGen.g:587:1: ( ( rule__VideoGenInformation__Group_3__0 )? )
            {
            // InternalVideoGen.g:587:1: ( ( rule__VideoGenInformation__Group_3__0 )? )
            // InternalVideoGen.g:588:1: ( rule__VideoGenInformation__Group_3__0 )?
            {
             before(grammarAccess.getVideoGenInformationAccess().getGroup_3()); 
            // InternalVideoGen.g:589:1: ( rule__VideoGenInformation__Group_3__0 )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==16) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // InternalVideoGen.g:589:2: rule__VideoGenInformation__Group_3__0
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
    // InternalVideoGen.g:607:1: rule__VideoGenInformation__Group_1__0 : rule__VideoGenInformation__Group_1__0__Impl rule__VideoGenInformation__Group_1__1 ;
    public final void rule__VideoGenInformation__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:611:1: ( rule__VideoGenInformation__Group_1__0__Impl rule__VideoGenInformation__Group_1__1 )
            // InternalVideoGen.g:612:2: rule__VideoGenInformation__Group_1__0__Impl rule__VideoGenInformation__Group_1__1
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
    // InternalVideoGen.g:619:1: rule__VideoGenInformation__Group_1__0__Impl : ( '@author' ) ;
    public final void rule__VideoGenInformation__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:623:1: ( ( '@author' ) )
            // InternalVideoGen.g:624:1: ( '@author' )
            {
            // InternalVideoGen.g:624:1: ( '@author' )
            // InternalVideoGen.g:625:1: '@author'
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
    // InternalVideoGen.g:638:1: rule__VideoGenInformation__Group_1__1 : rule__VideoGenInformation__Group_1__1__Impl ;
    public final void rule__VideoGenInformation__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:642:1: ( rule__VideoGenInformation__Group_1__1__Impl )
            // InternalVideoGen.g:643:2: rule__VideoGenInformation__Group_1__1__Impl
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
    // InternalVideoGen.g:649:1: rule__VideoGenInformation__Group_1__1__Impl : ( ( rule__VideoGenInformation__AuthorNameAssignment_1_1 ) ) ;
    public final void rule__VideoGenInformation__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:653:1: ( ( ( rule__VideoGenInformation__AuthorNameAssignment_1_1 ) ) )
            // InternalVideoGen.g:654:1: ( ( rule__VideoGenInformation__AuthorNameAssignment_1_1 ) )
            {
            // InternalVideoGen.g:654:1: ( ( rule__VideoGenInformation__AuthorNameAssignment_1_1 ) )
            // InternalVideoGen.g:655:1: ( rule__VideoGenInformation__AuthorNameAssignment_1_1 )
            {
             before(grammarAccess.getVideoGenInformationAccess().getAuthorNameAssignment_1_1()); 
            // InternalVideoGen.g:656:1: ( rule__VideoGenInformation__AuthorNameAssignment_1_1 )
            // InternalVideoGen.g:656:2: rule__VideoGenInformation__AuthorNameAssignment_1_1
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
    // InternalVideoGen.g:670:1: rule__VideoGenInformation__Group_2__0 : rule__VideoGenInformation__Group_2__0__Impl rule__VideoGenInformation__Group_2__1 ;
    public final void rule__VideoGenInformation__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:674:1: ( rule__VideoGenInformation__Group_2__0__Impl rule__VideoGenInformation__Group_2__1 )
            // InternalVideoGen.g:675:2: rule__VideoGenInformation__Group_2__0__Impl rule__VideoGenInformation__Group_2__1
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
    // InternalVideoGen.g:682:1: rule__VideoGenInformation__Group_2__0__Impl : ( '@version' ) ;
    public final void rule__VideoGenInformation__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:686:1: ( ( '@version' ) )
            // InternalVideoGen.g:687:1: ( '@version' )
            {
            // InternalVideoGen.g:687:1: ( '@version' )
            // InternalVideoGen.g:688:1: '@version'
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
    // InternalVideoGen.g:701:1: rule__VideoGenInformation__Group_2__1 : rule__VideoGenInformation__Group_2__1__Impl ;
    public final void rule__VideoGenInformation__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:705:1: ( rule__VideoGenInformation__Group_2__1__Impl )
            // InternalVideoGen.g:706:2: rule__VideoGenInformation__Group_2__1__Impl
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
    // InternalVideoGen.g:712:1: rule__VideoGenInformation__Group_2__1__Impl : ( ( rule__VideoGenInformation__VersionAssignment_2_1 ) ) ;
    public final void rule__VideoGenInformation__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:716:1: ( ( ( rule__VideoGenInformation__VersionAssignment_2_1 ) ) )
            // InternalVideoGen.g:717:1: ( ( rule__VideoGenInformation__VersionAssignment_2_1 ) )
            {
            // InternalVideoGen.g:717:1: ( ( rule__VideoGenInformation__VersionAssignment_2_1 ) )
            // InternalVideoGen.g:718:1: ( rule__VideoGenInformation__VersionAssignment_2_1 )
            {
             before(grammarAccess.getVideoGenInformationAccess().getVersionAssignment_2_1()); 
            // InternalVideoGen.g:719:1: ( rule__VideoGenInformation__VersionAssignment_2_1 )
            // InternalVideoGen.g:719:2: rule__VideoGenInformation__VersionAssignment_2_1
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
    // InternalVideoGen.g:733:1: rule__VideoGenInformation__Group_3__0 : rule__VideoGenInformation__Group_3__0__Impl rule__VideoGenInformation__Group_3__1 ;
    public final void rule__VideoGenInformation__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:737:1: ( rule__VideoGenInformation__Group_3__0__Impl rule__VideoGenInformation__Group_3__1 )
            // InternalVideoGen.g:738:2: rule__VideoGenInformation__Group_3__0__Impl rule__VideoGenInformation__Group_3__1
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
    // InternalVideoGen.g:745:1: rule__VideoGenInformation__Group_3__0__Impl : ( '@creation' ) ;
    public final void rule__VideoGenInformation__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:749:1: ( ( '@creation' ) )
            // InternalVideoGen.g:750:1: ( '@creation' )
            {
            // InternalVideoGen.g:750:1: ( '@creation' )
            // InternalVideoGen.g:751:1: '@creation'
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
    // InternalVideoGen.g:764:1: rule__VideoGenInformation__Group_3__1 : rule__VideoGenInformation__Group_3__1__Impl ;
    public final void rule__VideoGenInformation__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:768:1: ( rule__VideoGenInformation__Group_3__1__Impl )
            // InternalVideoGen.g:769:2: rule__VideoGenInformation__Group_3__1__Impl
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
    // InternalVideoGen.g:775:1: rule__VideoGenInformation__Group_3__1__Impl : ( ( rule__VideoGenInformation__CreationDateAssignment_3_1 ) ) ;
    public final void rule__VideoGenInformation__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:779:1: ( ( ( rule__VideoGenInformation__CreationDateAssignment_3_1 ) ) )
            // InternalVideoGen.g:780:1: ( ( rule__VideoGenInformation__CreationDateAssignment_3_1 ) )
            {
            // InternalVideoGen.g:780:1: ( ( rule__VideoGenInformation__CreationDateAssignment_3_1 ) )
            // InternalVideoGen.g:781:1: ( rule__VideoGenInformation__CreationDateAssignment_3_1 )
            {
             before(grammarAccess.getVideoGenInformationAccess().getCreationDateAssignment_3_1()); 
            // InternalVideoGen.g:782:1: ( rule__VideoGenInformation__CreationDateAssignment_3_1 )
            // InternalVideoGen.g:782:2: rule__VideoGenInformation__CreationDateAssignment_3_1
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
    // InternalVideoGen.g:796:1: rule__MandatoryVideoSeq__Group__0 : rule__MandatoryVideoSeq__Group__0__Impl rule__MandatoryVideoSeq__Group__1 ;
    public final void rule__MandatoryVideoSeq__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:800:1: ( rule__MandatoryVideoSeq__Group__0__Impl rule__MandatoryVideoSeq__Group__1 )
            // InternalVideoGen.g:801:2: rule__MandatoryVideoSeq__Group__0__Impl rule__MandatoryVideoSeq__Group__1
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
    // InternalVideoGen.g:808:1: rule__MandatoryVideoSeq__Group__0__Impl : ( 'mandatory' ) ;
    public final void rule__MandatoryVideoSeq__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:812:1: ( ( 'mandatory' ) )
            // InternalVideoGen.g:813:1: ( 'mandatory' )
            {
            // InternalVideoGen.g:813:1: ( 'mandatory' )
            // InternalVideoGen.g:814:1: 'mandatory'
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
    // InternalVideoGen.g:827:1: rule__MandatoryVideoSeq__Group__1 : rule__MandatoryVideoSeq__Group__1__Impl ;
    public final void rule__MandatoryVideoSeq__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:831:1: ( rule__MandatoryVideoSeq__Group__1__Impl )
            // InternalVideoGen.g:832:2: rule__MandatoryVideoSeq__Group__1__Impl
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
    // InternalVideoGen.g:838:1: rule__MandatoryVideoSeq__Group__1__Impl : ( ( rule__MandatoryVideoSeq__DescriptionAssignment_1 ) ) ;
    public final void rule__MandatoryVideoSeq__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:842:1: ( ( ( rule__MandatoryVideoSeq__DescriptionAssignment_1 ) ) )
            // InternalVideoGen.g:843:1: ( ( rule__MandatoryVideoSeq__DescriptionAssignment_1 ) )
            {
            // InternalVideoGen.g:843:1: ( ( rule__MandatoryVideoSeq__DescriptionAssignment_1 ) )
            // InternalVideoGen.g:844:1: ( rule__MandatoryVideoSeq__DescriptionAssignment_1 )
            {
             before(grammarAccess.getMandatoryVideoSeqAccess().getDescriptionAssignment_1()); 
            // InternalVideoGen.g:845:1: ( rule__MandatoryVideoSeq__DescriptionAssignment_1 )
            // InternalVideoGen.g:845:2: rule__MandatoryVideoSeq__DescriptionAssignment_1
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
    // InternalVideoGen.g:859:1: rule__OptionalVideoSeq__Group__0 : rule__OptionalVideoSeq__Group__0__Impl rule__OptionalVideoSeq__Group__1 ;
    public final void rule__OptionalVideoSeq__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:863:1: ( rule__OptionalVideoSeq__Group__0__Impl rule__OptionalVideoSeq__Group__1 )
            // InternalVideoGen.g:864:2: rule__OptionalVideoSeq__Group__0__Impl rule__OptionalVideoSeq__Group__1
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
    // InternalVideoGen.g:871:1: rule__OptionalVideoSeq__Group__0__Impl : ( 'optional' ) ;
    public final void rule__OptionalVideoSeq__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:875:1: ( ( 'optional' ) )
            // InternalVideoGen.g:876:1: ( 'optional' )
            {
            // InternalVideoGen.g:876:1: ( 'optional' )
            // InternalVideoGen.g:877:1: 'optional'
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
    // InternalVideoGen.g:890:1: rule__OptionalVideoSeq__Group__1 : rule__OptionalVideoSeq__Group__1__Impl ;
    public final void rule__OptionalVideoSeq__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:894:1: ( rule__OptionalVideoSeq__Group__1__Impl )
            // InternalVideoGen.g:895:2: rule__OptionalVideoSeq__Group__1__Impl
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
    // InternalVideoGen.g:901:1: rule__OptionalVideoSeq__Group__1__Impl : ( ( rule__OptionalVideoSeq__DescriptionAssignment_1 ) ) ;
    public final void rule__OptionalVideoSeq__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:905:1: ( ( ( rule__OptionalVideoSeq__DescriptionAssignment_1 ) ) )
            // InternalVideoGen.g:906:1: ( ( rule__OptionalVideoSeq__DescriptionAssignment_1 ) )
            {
            // InternalVideoGen.g:906:1: ( ( rule__OptionalVideoSeq__DescriptionAssignment_1 ) )
            // InternalVideoGen.g:907:1: ( rule__OptionalVideoSeq__DescriptionAssignment_1 )
            {
             before(grammarAccess.getOptionalVideoSeqAccess().getDescriptionAssignment_1()); 
            // InternalVideoGen.g:908:1: ( rule__OptionalVideoSeq__DescriptionAssignment_1 )
            // InternalVideoGen.g:908:2: rule__OptionalVideoSeq__DescriptionAssignment_1
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
    // InternalVideoGen.g:922:1: rule__AlternativeVideoSeq__Group__0 : rule__AlternativeVideoSeq__Group__0__Impl rule__AlternativeVideoSeq__Group__1 ;
    public final void rule__AlternativeVideoSeq__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:926:1: ( rule__AlternativeVideoSeq__Group__0__Impl rule__AlternativeVideoSeq__Group__1 )
            // InternalVideoGen.g:927:2: rule__AlternativeVideoSeq__Group__0__Impl rule__AlternativeVideoSeq__Group__1
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
    // InternalVideoGen.g:934:1: rule__AlternativeVideoSeq__Group__0__Impl : ( 'alternatives' ) ;
    public final void rule__AlternativeVideoSeq__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:938:1: ( ( 'alternatives' ) )
            // InternalVideoGen.g:939:1: ( 'alternatives' )
            {
            // InternalVideoGen.g:939:1: ( 'alternatives' )
            // InternalVideoGen.g:940:1: 'alternatives'
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
    // InternalVideoGen.g:953:1: rule__AlternativeVideoSeq__Group__1 : rule__AlternativeVideoSeq__Group__1__Impl rule__AlternativeVideoSeq__Group__2 ;
    public final void rule__AlternativeVideoSeq__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:957:1: ( rule__AlternativeVideoSeq__Group__1__Impl rule__AlternativeVideoSeq__Group__2 )
            // InternalVideoGen.g:958:2: rule__AlternativeVideoSeq__Group__1__Impl rule__AlternativeVideoSeq__Group__2
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
    // InternalVideoGen.g:965:1: rule__AlternativeVideoSeq__Group__1__Impl : ( ( rule__AlternativeVideoSeq__VideoidAssignment_1 )? ) ;
    public final void rule__AlternativeVideoSeq__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:969:1: ( ( ( rule__AlternativeVideoSeq__VideoidAssignment_1 )? ) )
            // InternalVideoGen.g:970:1: ( ( rule__AlternativeVideoSeq__VideoidAssignment_1 )? )
            {
            // InternalVideoGen.g:970:1: ( ( rule__AlternativeVideoSeq__VideoidAssignment_1 )? )
            // InternalVideoGen.g:971:1: ( rule__AlternativeVideoSeq__VideoidAssignment_1 )?
            {
             before(grammarAccess.getAlternativeVideoSeqAccess().getVideoidAssignment_1()); 
            // InternalVideoGen.g:972:1: ( rule__AlternativeVideoSeq__VideoidAssignment_1 )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==RULE_ID) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // InternalVideoGen.g:972:2: rule__AlternativeVideoSeq__VideoidAssignment_1
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
    // InternalVideoGen.g:982:1: rule__AlternativeVideoSeq__Group__2 : rule__AlternativeVideoSeq__Group__2__Impl rule__AlternativeVideoSeq__Group__3 ;
    public final void rule__AlternativeVideoSeq__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:986:1: ( rule__AlternativeVideoSeq__Group__2__Impl rule__AlternativeVideoSeq__Group__3 )
            // InternalVideoGen.g:987:2: rule__AlternativeVideoSeq__Group__2__Impl rule__AlternativeVideoSeq__Group__3
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
    // InternalVideoGen.g:994:1: rule__AlternativeVideoSeq__Group__2__Impl : ( RULE_LEFT_BRACKET ) ;
    public final void rule__AlternativeVideoSeq__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:998:1: ( ( RULE_LEFT_BRACKET ) )
            // InternalVideoGen.g:999:1: ( RULE_LEFT_BRACKET )
            {
            // InternalVideoGen.g:999:1: ( RULE_LEFT_BRACKET )
            // InternalVideoGen.g:1000:1: RULE_LEFT_BRACKET
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
    // InternalVideoGen.g:1011:1: rule__AlternativeVideoSeq__Group__3 : rule__AlternativeVideoSeq__Group__3__Impl rule__AlternativeVideoSeq__Group__4 ;
    public final void rule__AlternativeVideoSeq__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:1015:1: ( rule__AlternativeVideoSeq__Group__3__Impl rule__AlternativeVideoSeq__Group__4 )
            // InternalVideoGen.g:1016:2: rule__AlternativeVideoSeq__Group__3__Impl rule__AlternativeVideoSeq__Group__4
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
    // InternalVideoGen.g:1023:1: rule__AlternativeVideoSeq__Group__3__Impl : ( ( ( rule__AlternativeVideoSeq__VideodescsAssignment_3 ) ) ( ( rule__AlternativeVideoSeq__VideodescsAssignment_3 )* ) ) ;
    public final void rule__AlternativeVideoSeq__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:1027:1: ( ( ( ( rule__AlternativeVideoSeq__VideodescsAssignment_3 ) ) ( ( rule__AlternativeVideoSeq__VideodescsAssignment_3 )* ) ) )
            // InternalVideoGen.g:1028:1: ( ( ( rule__AlternativeVideoSeq__VideodescsAssignment_3 ) ) ( ( rule__AlternativeVideoSeq__VideodescsAssignment_3 )* ) )
            {
            // InternalVideoGen.g:1028:1: ( ( ( rule__AlternativeVideoSeq__VideodescsAssignment_3 ) ) ( ( rule__AlternativeVideoSeq__VideodescsAssignment_3 )* ) )
            // InternalVideoGen.g:1029:1: ( ( rule__AlternativeVideoSeq__VideodescsAssignment_3 ) ) ( ( rule__AlternativeVideoSeq__VideodescsAssignment_3 )* )
            {
            // InternalVideoGen.g:1029:1: ( ( rule__AlternativeVideoSeq__VideodescsAssignment_3 ) )
            // InternalVideoGen.g:1030:1: ( rule__AlternativeVideoSeq__VideodescsAssignment_3 )
            {
             before(grammarAccess.getAlternativeVideoSeqAccess().getVideodescsAssignment_3()); 
            // InternalVideoGen.g:1031:1: ( rule__AlternativeVideoSeq__VideodescsAssignment_3 )
            // InternalVideoGen.g:1031:2: rule__AlternativeVideoSeq__VideodescsAssignment_3
            {
            pushFollow(FOLLOW_13);
            rule__AlternativeVideoSeq__VideodescsAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getAlternativeVideoSeqAccess().getVideodescsAssignment_3()); 

            }

            // InternalVideoGen.g:1034:1: ( ( rule__AlternativeVideoSeq__VideodescsAssignment_3 )* )
            // InternalVideoGen.g:1035:1: ( rule__AlternativeVideoSeq__VideodescsAssignment_3 )*
            {
             before(grammarAccess.getAlternativeVideoSeqAccess().getVideodescsAssignment_3()); 
            // InternalVideoGen.g:1036:1: ( rule__AlternativeVideoSeq__VideodescsAssignment_3 )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==20) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // InternalVideoGen.g:1036:2: rule__AlternativeVideoSeq__VideodescsAssignment_3
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
    // InternalVideoGen.g:1047:1: rule__AlternativeVideoSeq__Group__4 : rule__AlternativeVideoSeq__Group__4__Impl ;
    public final void rule__AlternativeVideoSeq__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:1051:1: ( rule__AlternativeVideoSeq__Group__4__Impl )
            // InternalVideoGen.g:1052:2: rule__AlternativeVideoSeq__Group__4__Impl
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
    // InternalVideoGen.g:1058:1: rule__AlternativeVideoSeq__Group__4__Impl : ( RULE_RIGHT_BRACKET ) ;
    public final void rule__AlternativeVideoSeq__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:1062:1: ( ( RULE_RIGHT_BRACKET ) )
            // InternalVideoGen.g:1063:1: ( RULE_RIGHT_BRACKET )
            {
            // InternalVideoGen.g:1063:1: ( RULE_RIGHT_BRACKET )
            // InternalVideoGen.g:1064:1: RULE_RIGHT_BRACKET
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
    // InternalVideoGen.g:1085:1: rule__VideoDescription__Group__0 : rule__VideoDescription__Group__0__Impl rule__VideoDescription__Group__1 ;
    public final void rule__VideoDescription__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:1089:1: ( rule__VideoDescription__Group__0__Impl rule__VideoDescription__Group__1 )
            // InternalVideoGen.g:1090:2: rule__VideoDescription__Group__0__Impl rule__VideoDescription__Group__1
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
    // InternalVideoGen.g:1097:1: rule__VideoDescription__Group__0__Impl : ( 'videoseq' ) ;
    public final void rule__VideoDescription__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:1101:1: ( ( 'videoseq' ) )
            // InternalVideoGen.g:1102:1: ( 'videoseq' )
            {
            // InternalVideoGen.g:1102:1: ( 'videoseq' )
            // InternalVideoGen.g:1103:1: 'videoseq'
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
    // InternalVideoGen.g:1116:1: rule__VideoDescription__Group__1 : rule__VideoDescription__Group__1__Impl rule__VideoDescription__Group__2 ;
    public final void rule__VideoDescription__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:1120:1: ( rule__VideoDescription__Group__1__Impl rule__VideoDescription__Group__2 )
            // InternalVideoGen.g:1121:2: rule__VideoDescription__Group__1__Impl rule__VideoDescription__Group__2
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
    // InternalVideoGen.g:1128:1: rule__VideoDescription__Group__1__Impl : ( ( rule__VideoDescription__VideoidAssignment_1 )? ) ;
    public final void rule__VideoDescription__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:1132:1: ( ( ( rule__VideoDescription__VideoidAssignment_1 )? ) )
            // InternalVideoGen.g:1133:1: ( ( rule__VideoDescription__VideoidAssignment_1 )? )
            {
            // InternalVideoGen.g:1133:1: ( ( rule__VideoDescription__VideoidAssignment_1 )? )
            // InternalVideoGen.g:1134:1: ( rule__VideoDescription__VideoidAssignment_1 )?
            {
             before(grammarAccess.getVideoDescriptionAccess().getVideoidAssignment_1()); 
            // InternalVideoGen.g:1135:1: ( rule__VideoDescription__VideoidAssignment_1 )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==RULE_ID) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // InternalVideoGen.g:1135:2: rule__VideoDescription__VideoidAssignment_1
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
    // InternalVideoGen.g:1145:1: rule__VideoDescription__Group__2 : rule__VideoDescription__Group__2__Impl rule__VideoDescription__Group__3 ;
    public final void rule__VideoDescription__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:1149:1: ( rule__VideoDescription__Group__2__Impl rule__VideoDescription__Group__3 )
            // InternalVideoGen.g:1150:2: rule__VideoDescription__Group__2__Impl rule__VideoDescription__Group__3
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
    // InternalVideoGen.g:1157:1: rule__VideoDescription__Group__2__Impl : ( ( rule__VideoDescription__LocationAssignment_2 ) ) ;
    public final void rule__VideoDescription__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:1161:1: ( ( ( rule__VideoDescription__LocationAssignment_2 ) ) )
            // InternalVideoGen.g:1162:1: ( ( rule__VideoDescription__LocationAssignment_2 ) )
            {
            // InternalVideoGen.g:1162:1: ( ( rule__VideoDescription__LocationAssignment_2 ) )
            // InternalVideoGen.g:1163:1: ( rule__VideoDescription__LocationAssignment_2 )
            {
             before(grammarAccess.getVideoDescriptionAccess().getLocationAssignment_2()); 
            // InternalVideoGen.g:1164:1: ( rule__VideoDescription__LocationAssignment_2 )
            // InternalVideoGen.g:1164:2: rule__VideoDescription__LocationAssignment_2
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
    // InternalVideoGen.g:1174:1: rule__VideoDescription__Group__3 : rule__VideoDescription__Group__3__Impl ;
    public final void rule__VideoDescription__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:1178:1: ( rule__VideoDescription__Group__3__Impl )
            // InternalVideoGen.g:1179:2: rule__VideoDescription__Group__3__Impl
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
    // InternalVideoGen.g:1185:1: rule__VideoDescription__Group__3__Impl : ( ( rule__VideoDescription__Group_3__0 )? ) ;
    public final void rule__VideoDescription__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:1189:1: ( ( ( rule__VideoDescription__Group_3__0 )? ) )
            // InternalVideoGen.g:1190:1: ( ( rule__VideoDescription__Group_3__0 )? )
            {
            // InternalVideoGen.g:1190:1: ( ( rule__VideoDescription__Group_3__0 )? )
            // InternalVideoGen.g:1191:1: ( rule__VideoDescription__Group_3__0 )?
            {
             before(grammarAccess.getVideoDescriptionAccess().getGroup_3()); 
            // InternalVideoGen.g:1192:1: ( rule__VideoDescription__Group_3__0 )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==RULE_LEFT_BRACKET) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // InternalVideoGen.g:1192:2: rule__VideoDescription__Group_3__0
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
    // InternalVideoGen.g:1210:1: rule__VideoDescription__Group_3__0 : rule__VideoDescription__Group_3__0__Impl rule__VideoDescription__Group_3__1 ;
    public final void rule__VideoDescription__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:1214:1: ( rule__VideoDescription__Group_3__0__Impl rule__VideoDescription__Group_3__1 )
            // InternalVideoGen.g:1215:2: rule__VideoDescription__Group_3__0__Impl rule__VideoDescription__Group_3__1
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
    // InternalVideoGen.g:1222:1: rule__VideoDescription__Group_3__0__Impl : ( RULE_LEFT_BRACKET ) ;
    public final void rule__VideoDescription__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:1226:1: ( ( RULE_LEFT_BRACKET ) )
            // InternalVideoGen.g:1227:1: ( RULE_LEFT_BRACKET )
            {
            // InternalVideoGen.g:1227:1: ( RULE_LEFT_BRACKET )
            // InternalVideoGen.g:1228:1: RULE_LEFT_BRACKET
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
    // InternalVideoGen.g:1239:1: rule__VideoDescription__Group_3__1 : rule__VideoDescription__Group_3__1__Impl rule__VideoDescription__Group_3__2 ;
    public final void rule__VideoDescription__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:1243:1: ( rule__VideoDescription__Group_3__1__Impl rule__VideoDescription__Group_3__2 )
            // InternalVideoGen.g:1244:2: rule__VideoDescription__Group_3__1__Impl rule__VideoDescription__Group_3__2
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
    // InternalVideoGen.g:1251:1: rule__VideoDescription__Group_3__1__Impl : ( ( rule__VideoDescription__Group_3_1__0 )? ) ;
    public final void rule__VideoDescription__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:1255:1: ( ( ( rule__VideoDescription__Group_3_1__0 )? ) )
            // InternalVideoGen.g:1256:1: ( ( rule__VideoDescription__Group_3_1__0 )? )
            {
            // InternalVideoGen.g:1256:1: ( ( rule__VideoDescription__Group_3_1__0 )? )
            // InternalVideoGen.g:1257:1: ( rule__VideoDescription__Group_3_1__0 )?
            {
             before(grammarAccess.getVideoDescriptionAccess().getGroup_3_1()); 
            // InternalVideoGen.g:1258:1: ( rule__VideoDescription__Group_3_1__0 )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==21) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // InternalVideoGen.g:1258:2: rule__VideoDescription__Group_3_1__0
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
    // InternalVideoGen.g:1268:1: rule__VideoDescription__Group_3__2 : rule__VideoDescription__Group_3__2__Impl rule__VideoDescription__Group_3__3 ;
    public final void rule__VideoDescription__Group_3__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:1272:1: ( rule__VideoDescription__Group_3__2__Impl rule__VideoDescription__Group_3__3 )
            // InternalVideoGen.g:1273:2: rule__VideoDescription__Group_3__2__Impl rule__VideoDescription__Group_3__3
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
    // InternalVideoGen.g:1280:1: rule__VideoDescription__Group_3__2__Impl : ( ( rule__VideoDescription__Group_3_2__0 )? ) ;
    public final void rule__VideoDescription__Group_3__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:1284:1: ( ( ( rule__VideoDescription__Group_3_2__0 )? ) )
            // InternalVideoGen.g:1285:1: ( ( rule__VideoDescription__Group_3_2__0 )? )
            {
            // InternalVideoGen.g:1285:1: ( ( rule__VideoDescription__Group_3_2__0 )? )
            // InternalVideoGen.g:1286:1: ( rule__VideoDescription__Group_3_2__0 )?
            {
             before(grammarAccess.getVideoDescriptionAccess().getGroup_3_2()); 
            // InternalVideoGen.g:1287:1: ( rule__VideoDescription__Group_3_2__0 )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==22) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // InternalVideoGen.g:1287:2: rule__VideoDescription__Group_3_2__0
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
    // InternalVideoGen.g:1297:1: rule__VideoDescription__Group_3__3 : rule__VideoDescription__Group_3__3__Impl rule__VideoDescription__Group_3__4 ;
    public final void rule__VideoDescription__Group_3__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:1301:1: ( rule__VideoDescription__Group_3__3__Impl rule__VideoDescription__Group_3__4 )
            // InternalVideoGen.g:1302:2: rule__VideoDescription__Group_3__3__Impl rule__VideoDescription__Group_3__4
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
    // InternalVideoGen.g:1309:1: rule__VideoDescription__Group_3__3__Impl : ( ( rule__VideoDescription__Group_3_3__0 )? ) ;
    public final void rule__VideoDescription__Group_3__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:1313:1: ( ( ( rule__VideoDescription__Group_3_3__0 )? ) )
            // InternalVideoGen.g:1314:1: ( ( rule__VideoDescription__Group_3_3__0 )? )
            {
            // InternalVideoGen.g:1314:1: ( ( rule__VideoDescription__Group_3_3__0 )? )
            // InternalVideoGen.g:1315:1: ( rule__VideoDescription__Group_3_3__0 )?
            {
             before(grammarAccess.getVideoDescriptionAccess().getGroup_3_3()); 
            // InternalVideoGen.g:1316:1: ( rule__VideoDescription__Group_3_3__0 )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==23) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // InternalVideoGen.g:1316:2: rule__VideoDescription__Group_3_3__0
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
    // InternalVideoGen.g:1326:1: rule__VideoDescription__Group_3__4 : rule__VideoDescription__Group_3__4__Impl rule__VideoDescription__Group_3__5 ;
    public final void rule__VideoDescription__Group_3__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:1330:1: ( rule__VideoDescription__Group_3__4__Impl rule__VideoDescription__Group_3__5 )
            // InternalVideoGen.g:1331:2: rule__VideoDescription__Group_3__4__Impl rule__VideoDescription__Group_3__5
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
    // InternalVideoGen.g:1338:1: rule__VideoDescription__Group_3__4__Impl : ( ( rule__VideoDescription__Group_3_4__0 )? ) ;
    public final void rule__VideoDescription__Group_3__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:1342:1: ( ( ( rule__VideoDescription__Group_3_4__0 )? ) )
            // InternalVideoGen.g:1343:1: ( ( rule__VideoDescription__Group_3_4__0 )? )
            {
            // InternalVideoGen.g:1343:1: ( ( rule__VideoDescription__Group_3_4__0 )? )
            // InternalVideoGen.g:1344:1: ( rule__VideoDescription__Group_3_4__0 )?
            {
             before(grammarAccess.getVideoDescriptionAccess().getGroup_3_4()); 
            // InternalVideoGen.g:1345:1: ( rule__VideoDescription__Group_3_4__0 )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==24) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // InternalVideoGen.g:1345:2: rule__VideoDescription__Group_3_4__0
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
    // InternalVideoGen.g:1355:1: rule__VideoDescription__Group_3__5 : rule__VideoDescription__Group_3__5__Impl rule__VideoDescription__Group_3__6 ;
    public final void rule__VideoDescription__Group_3__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:1359:1: ( rule__VideoDescription__Group_3__5__Impl rule__VideoDescription__Group_3__6 )
            // InternalVideoGen.g:1360:2: rule__VideoDescription__Group_3__5__Impl rule__VideoDescription__Group_3__6
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
    // InternalVideoGen.g:1367:1: rule__VideoDescription__Group_3__5__Impl : ( ( rule__VideoDescription__Group_3_5__0 )? ) ;
    public final void rule__VideoDescription__Group_3__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:1371:1: ( ( ( rule__VideoDescription__Group_3_5__0 )? ) )
            // InternalVideoGen.g:1372:1: ( ( rule__VideoDescription__Group_3_5__0 )? )
            {
            // InternalVideoGen.g:1372:1: ( ( rule__VideoDescription__Group_3_5__0 )? )
            // InternalVideoGen.g:1373:1: ( rule__VideoDescription__Group_3_5__0 )?
            {
             before(grammarAccess.getVideoDescriptionAccess().getGroup_3_5()); 
            // InternalVideoGen.g:1374:1: ( rule__VideoDescription__Group_3_5__0 )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==25) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // InternalVideoGen.g:1374:2: rule__VideoDescription__Group_3_5__0
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
    // InternalVideoGen.g:1384:1: rule__VideoDescription__Group_3__6 : rule__VideoDescription__Group_3__6__Impl rule__VideoDescription__Group_3__7 ;
    public final void rule__VideoDescription__Group_3__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:1388:1: ( rule__VideoDescription__Group_3__6__Impl rule__VideoDescription__Group_3__7 )
            // InternalVideoGen.g:1389:2: rule__VideoDescription__Group_3__6__Impl rule__VideoDescription__Group_3__7
            {
            pushFollow(FOLLOW_15);
            rule__VideoDescription__Group_3__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__VideoDescription__Group_3__7();

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
    // InternalVideoGen.g:1396:1: rule__VideoDescription__Group_3__6__Impl : ( ( rule__VideoDescription__Group_3_6__0 )? ) ;
    public final void rule__VideoDescription__Group_3__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:1400:1: ( ( ( rule__VideoDescription__Group_3_6__0 )? ) )
            // InternalVideoGen.g:1401:1: ( ( rule__VideoDescription__Group_3_6__0 )? )
            {
            // InternalVideoGen.g:1401:1: ( ( rule__VideoDescription__Group_3_6__0 )? )
            // InternalVideoGen.g:1402:1: ( rule__VideoDescription__Group_3_6__0 )?
            {
             before(grammarAccess.getVideoDescriptionAccess().getGroup_3_6()); 
            // InternalVideoGen.g:1403:1: ( rule__VideoDescription__Group_3_6__0 )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==26) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // InternalVideoGen.g:1403:2: rule__VideoDescription__Group_3_6__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__VideoDescription__Group_3_6__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getVideoDescriptionAccess().getGroup_3_6()); 

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


    // $ANTLR start "rule__VideoDescription__Group_3__7"
    // InternalVideoGen.g:1413:1: rule__VideoDescription__Group_3__7 : rule__VideoDescription__Group_3__7__Impl ;
    public final void rule__VideoDescription__Group_3__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:1417:1: ( rule__VideoDescription__Group_3__7__Impl )
            // InternalVideoGen.g:1418:2: rule__VideoDescription__Group_3__7__Impl
            {
            pushFollow(FOLLOW_2);
            rule__VideoDescription__Group_3__7__Impl();

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
    // $ANTLR end "rule__VideoDescription__Group_3__7"


    // $ANTLR start "rule__VideoDescription__Group_3__7__Impl"
    // InternalVideoGen.g:1424:1: rule__VideoDescription__Group_3__7__Impl : ( RULE_RIGHT_BRACKET ) ;
    public final void rule__VideoDescription__Group_3__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:1428:1: ( ( RULE_RIGHT_BRACKET ) )
            // InternalVideoGen.g:1429:1: ( RULE_RIGHT_BRACKET )
            {
            // InternalVideoGen.g:1429:1: ( RULE_RIGHT_BRACKET )
            // InternalVideoGen.g:1430:1: RULE_RIGHT_BRACKET
            {
             before(grammarAccess.getVideoDescriptionAccess().getRIGHT_BRACKETTerminalRuleCall_3_7()); 
            match(input,RULE_RIGHT_BRACKET,FOLLOW_2); 
             after(grammarAccess.getVideoDescriptionAccess().getRIGHT_BRACKETTerminalRuleCall_3_7()); 

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
    // $ANTLR end "rule__VideoDescription__Group_3__7__Impl"


    // $ANTLR start "rule__VideoDescription__Group_3_1__0"
    // InternalVideoGen.g:1457:1: rule__VideoDescription__Group_3_1__0 : rule__VideoDescription__Group_3_1__0__Impl rule__VideoDescription__Group_3_1__1 ;
    public final void rule__VideoDescription__Group_3_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:1461:1: ( rule__VideoDescription__Group_3_1__0__Impl rule__VideoDescription__Group_3_1__1 )
            // InternalVideoGen.g:1462:2: rule__VideoDescription__Group_3_1__0__Impl rule__VideoDescription__Group_3_1__1
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
    // InternalVideoGen.g:1469:1: rule__VideoDescription__Group_3_1__0__Impl : ( 'duration' ) ;
    public final void rule__VideoDescription__Group_3_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:1473:1: ( ( 'duration' ) )
            // InternalVideoGen.g:1474:1: ( 'duration' )
            {
            // InternalVideoGen.g:1474:1: ( 'duration' )
            // InternalVideoGen.g:1475:1: 'duration'
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
    // InternalVideoGen.g:1488:1: rule__VideoDescription__Group_3_1__1 : rule__VideoDescription__Group_3_1__1__Impl ;
    public final void rule__VideoDescription__Group_3_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:1492:1: ( rule__VideoDescription__Group_3_1__1__Impl )
            // InternalVideoGen.g:1493:2: rule__VideoDescription__Group_3_1__1__Impl
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
    // InternalVideoGen.g:1499:1: rule__VideoDescription__Group_3_1__1__Impl : ( ( rule__VideoDescription__DurationAssignment_3_1_1 ) ) ;
    public final void rule__VideoDescription__Group_3_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:1503:1: ( ( ( rule__VideoDescription__DurationAssignment_3_1_1 ) ) )
            // InternalVideoGen.g:1504:1: ( ( rule__VideoDescription__DurationAssignment_3_1_1 ) )
            {
            // InternalVideoGen.g:1504:1: ( ( rule__VideoDescription__DurationAssignment_3_1_1 ) )
            // InternalVideoGen.g:1505:1: ( rule__VideoDescription__DurationAssignment_3_1_1 )
            {
             before(grammarAccess.getVideoDescriptionAccess().getDurationAssignment_3_1_1()); 
            // InternalVideoGen.g:1506:1: ( rule__VideoDescription__DurationAssignment_3_1_1 )
            // InternalVideoGen.g:1506:2: rule__VideoDescription__DurationAssignment_3_1_1
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
    // InternalVideoGen.g:1520:1: rule__VideoDescription__Group_3_2__0 : rule__VideoDescription__Group_3_2__0__Impl rule__VideoDescription__Group_3_2__1 ;
    public final void rule__VideoDescription__Group_3_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:1524:1: ( rule__VideoDescription__Group_3_2__0__Impl rule__VideoDescription__Group_3_2__1 )
            // InternalVideoGen.g:1525:2: rule__VideoDescription__Group_3_2__0__Impl rule__VideoDescription__Group_3_2__1
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
    // InternalVideoGen.g:1532:1: rule__VideoDescription__Group_3_2__0__Impl : ( 'probability' ) ;
    public final void rule__VideoDescription__Group_3_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:1536:1: ( ( 'probability' ) )
            // InternalVideoGen.g:1537:1: ( 'probability' )
            {
            // InternalVideoGen.g:1537:1: ( 'probability' )
            // InternalVideoGen.g:1538:1: 'probability'
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
    // InternalVideoGen.g:1551:1: rule__VideoDescription__Group_3_2__1 : rule__VideoDescription__Group_3_2__1__Impl ;
    public final void rule__VideoDescription__Group_3_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:1555:1: ( rule__VideoDescription__Group_3_2__1__Impl )
            // InternalVideoGen.g:1556:2: rule__VideoDescription__Group_3_2__1__Impl
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
    // InternalVideoGen.g:1562:1: rule__VideoDescription__Group_3_2__1__Impl : ( ( rule__VideoDescription__ProbabilityAssignment_3_2_1 ) ) ;
    public final void rule__VideoDescription__Group_3_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:1566:1: ( ( ( rule__VideoDescription__ProbabilityAssignment_3_2_1 ) ) )
            // InternalVideoGen.g:1567:1: ( ( rule__VideoDescription__ProbabilityAssignment_3_2_1 ) )
            {
            // InternalVideoGen.g:1567:1: ( ( rule__VideoDescription__ProbabilityAssignment_3_2_1 ) )
            // InternalVideoGen.g:1568:1: ( rule__VideoDescription__ProbabilityAssignment_3_2_1 )
            {
             before(grammarAccess.getVideoDescriptionAccess().getProbabilityAssignment_3_2_1()); 
            // InternalVideoGen.g:1569:1: ( rule__VideoDescription__ProbabilityAssignment_3_2_1 )
            // InternalVideoGen.g:1569:2: rule__VideoDescription__ProbabilityAssignment_3_2_1
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
    // InternalVideoGen.g:1583:1: rule__VideoDescription__Group_3_3__0 : rule__VideoDescription__Group_3_3__0__Impl rule__VideoDescription__Group_3_3__1 ;
    public final void rule__VideoDescription__Group_3_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:1587:1: ( rule__VideoDescription__Group_3_3__0__Impl rule__VideoDescription__Group_3_3__1 )
            // InternalVideoGen.g:1588:2: rule__VideoDescription__Group_3_3__0__Impl rule__VideoDescription__Group_3_3__1
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
    // InternalVideoGen.g:1595:1: rule__VideoDescription__Group_3_3__0__Impl : ( 'size' ) ;
    public final void rule__VideoDescription__Group_3_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:1599:1: ( ( 'size' ) )
            // InternalVideoGen.g:1600:1: ( 'size' )
            {
            // InternalVideoGen.g:1600:1: ( 'size' )
            // InternalVideoGen.g:1601:1: 'size'
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
    // InternalVideoGen.g:1614:1: rule__VideoDescription__Group_3_3__1 : rule__VideoDescription__Group_3_3__1__Impl ;
    public final void rule__VideoDescription__Group_3_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:1618:1: ( rule__VideoDescription__Group_3_3__1__Impl )
            // InternalVideoGen.g:1619:2: rule__VideoDescription__Group_3_3__1__Impl
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
    // InternalVideoGen.g:1625:1: rule__VideoDescription__Group_3_3__1__Impl : ( ( rule__VideoDescription__SizeAssignment_3_3_1 ) ) ;
    public final void rule__VideoDescription__Group_3_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:1629:1: ( ( ( rule__VideoDescription__SizeAssignment_3_3_1 ) ) )
            // InternalVideoGen.g:1630:1: ( ( rule__VideoDescription__SizeAssignment_3_3_1 ) )
            {
            // InternalVideoGen.g:1630:1: ( ( rule__VideoDescription__SizeAssignment_3_3_1 ) )
            // InternalVideoGen.g:1631:1: ( rule__VideoDescription__SizeAssignment_3_3_1 )
            {
             before(grammarAccess.getVideoDescriptionAccess().getSizeAssignment_3_3_1()); 
            // InternalVideoGen.g:1632:1: ( rule__VideoDescription__SizeAssignment_3_3_1 )
            // InternalVideoGen.g:1632:2: rule__VideoDescription__SizeAssignment_3_3_1
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
    // InternalVideoGen.g:1646:1: rule__VideoDescription__Group_3_4__0 : rule__VideoDescription__Group_3_4__0__Impl rule__VideoDescription__Group_3_4__1 ;
    public final void rule__VideoDescription__Group_3_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:1650:1: ( rule__VideoDescription__Group_3_4__0__Impl rule__VideoDescription__Group_3_4__1 )
            // InternalVideoGen.g:1651:2: rule__VideoDescription__Group_3_4__0__Impl rule__VideoDescription__Group_3_4__1
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
    // InternalVideoGen.g:1658:1: rule__VideoDescription__Group_3_4__0__Impl : ( 'textIncrust' ) ;
    public final void rule__VideoDescription__Group_3_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:1662:1: ( ( 'textIncrust' ) )
            // InternalVideoGen.g:1663:1: ( 'textIncrust' )
            {
            // InternalVideoGen.g:1663:1: ( 'textIncrust' )
            // InternalVideoGen.g:1664:1: 'textIncrust'
            {
             before(grammarAccess.getVideoDescriptionAccess().getTextIncrustKeyword_3_4_0()); 
            match(input,24,FOLLOW_2); 
             after(grammarAccess.getVideoDescriptionAccess().getTextIncrustKeyword_3_4_0()); 

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
    // InternalVideoGen.g:1677:1: rule__VideoDescription__Group_3_4__1 : rule__VideoDescription__Group_3_4__1__Impl ;
    public final void rule__VideoDescription__Group_3_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:1681:1: ( rule__VideoDescription__Group_3_4__1__Impl )
            // InternalVideoGen.g:1682:2: rule__VideoDescription__Group_3_4__1__Impl
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
    // InternalVideoGen.g:1688:1: rule__VideoDescription__Group_3_4__1__Impl : ( ( rule__VideoDescription__TextIncrustAssignment_3_4_1 ) ) ;
    public final void rule__VideoDescription__Group_3_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:1692:1: ( ( ( rule__VideoDescription__TextIncrustAssignment_3_4_1 ) ) )
            // InternalVideoGen.g:1693:1: ( ( rule__VideoDescription__TextIncrustAssignment_3_4_1 ) )
            {
            // InternalVideoGen.g:1693:1: ( ( rule__VideoDescription__TextIncrustAssignment_3_4_1 ) )
            // InternalVideoGen.g:1694:1: ( rule__VideoDescription__TextIncrustAssignment_3_4_1 )
            {
             before(grammarAccess.getVideoDescriptionAccess().getTextIncrustAssignment_3_4_1()); 
            // InternalVideoGen.g:1695:1: ( rule__VideoDescription__TextIncrustAssignment_3_4_1 )
            // InternalVideoGen.g:1695:2: rule__VideoDescription__TextIncrustAssignment_3_4_1
            {
            pushFollow(FOLLOW_2);
            rule__VideoDescription__TextIncrustAssignment_3_4_1();

            state._fsp--;


            }

             after(grammarAccess.getVideoDescriptionAccess().getTextIncrustAssignment_3_4_1()); 

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
    // InternalVideoGen.g:1709:1: rule__VideoDescription__Group_3_5__0 : rule__VideoDescription__Group_3_5__0__Impl rule__VideoDescription__Group_3_5__1 ;
    public final void rule__VideoDescription__Group_3_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:1713:1: ( rule__VideoDescription__Group_3_5__0__Impl rule__VideoDescription__Group_3_5__1 )
            // InternalVideoGen.g:1714:2: rule__VideoDescription__Group_3_5__0__Impl rule__VideoDescription__Group_3_5__1
            {
            pushFollow(FOLLOW_10);
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
    // InternalVideoGen.g:1721:1: rule__VideoDescription__Group_3_5__0__Impl : ( 'filter' ) ;
    public final void rule__VideoDescription__Group_3_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:1725:1: ( ( 'filter' ) )
            // InternalVideoGen.g:1726:1: ( 'filter' )
            {
            // InternalVideoGen.g:1726:1: ( 'filter' )
            // InternalVideoGen.g:1727:1: 'filter'
            {
             before(grammarAccess.getVideoDescriptionAccess().getFilterKeyword_3_5_0()); 
            match(input,25,FOLLOW_2); 
             after(grammarAccess.getVideoDescriptionAccess().getFilterKeyword_3_5_0()); 

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
    // InternalVideoGen.g:1740:1: rule__VideoDescription__Group_3_5__1 : rule__VideoDescription__Group_3_5__1__Impl ;
    public final void rule__VideoDescription__Group_3_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:1744:1: ( rule__VideoDescription__Group_3_5__1__Impl )
            // InternalVideoGen.g:1745:2: rule__VideoDescription__Group_3_5__1__Impl
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
    // InternalVideoGen.g:1751:1: rule__VideoDescription__Group_3_5__1__Impl : ( ( rule__VideoDescription__FilterAssignment_3_5_1 ) ) ;
    public final void rule__VideoDescription__Group_3_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:1755:1: ( ( ( rule__VideoDescription__FilterAssignment_3_5_1 ) ) )
            // InternalVideoGen.g:1756:1: ( ( rule__VideoDescription__FilterAssignment_3_5_1 ) )
            {
            // InternalVideoGen.g:1756:1: ( ( rule__VideoDescription__FilterAssignment_3_5_1 ) )
            // InternalVideoGen.g:1757:1: ( rule__VideoDescription__FilterAssignment_3_5_1 )
            {
             before(grammarAccess.getVideoDescriptionAccess().getFilterAssignment_3_5_1()); 
            // InternalVideoGen.g:1758:1: ( rule__VideoDescription__FilterAssignment_3_5_1 )
            // InternalVideoGen.g:1758:2: rule__VideoDescription__FilterAssignment_3_5_1
            {
            pushFollow(FOLLOW_2);
            rule__VideoDescription__FilterAssignment_3_5_1();

            state._fsp--;


            }

             after(grammarAccess.getVideoDescriptionAccess().getFilterAssignment_3_5_1()); 

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


    // $ANTLR start "rule__VideoDescription__Group_3_6__0"
    // InternalVideoGen.g:1772:1: rule__VideoDescription__Group_3_6__0 : rule__VideoDescription__Group_3_6__0__Impl rule__VideoDescription__Group_3_6__1 ;
    public final void rule__VideoDescription__Group_3_6__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:1776:1: ( rule__VideoDescription__Group_3_6__0__Impl rule__VideoDescription__Group_3_6__1 )
            // InternalVideoGen.g:1777:2: rule__VideoDescription__Group_3_6__0__Impl rule__VideoDescription__Group_3_6__1
            {
            pushFollow(FOLLOW_10);
            rule__VideoDescription__Group_3_6__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__VideoDescription__Group_3_6__1();

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
    // $ANTLR end "rule__VideoDescription__Group_3_6__0"


    // $ANTLR start "rule__VideoDescription__Group_3_6__0__Impl"
    // InternalVideoGen.g:1784:1: rule__VideoDescription__Group_3_6__0__Impl : ( 'description' ) ;
    public final void rule__VideoDescription__Group_3_6__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:1788:1: ( ( 'description' ) )
            // InternalVideoGen.g:1789:1: ( 'description' )
            {
            // InternalVideoGen.g:1789:1: ( 'description' )
            // InternalVideoGen.g:1790:1: 'description'
            {
             before(grammarAccess.getVideoDescriptionAccess().getDescriptionKeyword_3_6_0()); 
            match(input,26,FOLLOW_2); 
             after(grammarAccess.getVideoDescriptionAccess().getDescriptionKeyword_3_6_0()); 

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
    // $ANTLR end "rule__VideoDescription__Group_3_6__0__Impl"


    // $ANTLR start "rule__VideoDescription__Group_3_6__1"
    // InternalVideoGen.g:1803:1: rule__VideoDescription__Group_3_6__1 : rule__VideoDescription__Group_3_6__1__Impl ;
    public final void rule__VideoDescription__Group_3_6__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:1807:1: ( rule__VideoDescription__Group_3_6__1__Impl )
            // InternalVideoGen.g:1808:2: rule__VideoDescription__Group_3_6__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__VideoDescription__Group_3_6__1__Impl();

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
    // $ANTLR end "rule__VideoDescription__Group_3_6__1"


    // $ANTLR start "rule__VideoDescription__Group_3_6__1__Impl"
    // InternalVideoGen.g:1814:1: rule__VideoDescription__Group_3_6__1__Impl : ( ( rule__VideoDescription__DescriptionAssignment_3_6_1 ) ) ;
    public final void rule__VideoDescription__Group_3_6__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:1818:1: ( ( ( rule__VideoDescription__DescriptionAssignment_3_6_1 ) ) )
            // InternalVideoGen.g:1819:1: ( ( rule__VideoDescription__DescriptionAssignment_3_6_1 ) )
            {
            // InternalVideoGen.g:1819:1: ( ( rule__VideoDescription__DescriptionAssignment_3_6_1 ) )
            // InternalVideoGen.g:1820:1: ( rule__VideoDescription__DescriptionAssignment_3_6_1 )
            {
             before(grammarAccess.getVideoDescriptionAccess().getDescriptionAssignment_3_6_1()); 
            // InternalVideoGen.g:1821:1: ( rule__VideoDescription__DescriptionAssignment_3_6_1 )
            // InternalVideoGen.g:1821:2: rule__VideoDescription__DescriptionAssignment_3_6_1
            {
            pushFollow(FOLLOW_2);
            rule__VideoDescription__DescriptionAssignment_3_6_1();

            state._fsp--;


            }

             after(grammarAccess.getVideoDescriptionAccess().getDescriptionAssignment_3_6_1()); 

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
    // $ANTLR end "rule__VideoDescription__Group_3_6__1__Impl"


    // $ANTLR start "rule__VideoGeneratorModel__InformationAssignment_1"
    // InternalVideoGen.g:1836:1: rule__VideoGeneratorModel__InformationAssignment_1 : ( ruleVideoGenInformation ) ;
    public final void rule__VideoGeneratorModel__InformationAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:1840:1: ( ( ruleVideoGenInformation ) )
            // InternalVideoGen.g:1841:1: ( ruleVideoGenInformation )
            {
            // InternalVideoGen.g:1841:1: ( ruleVideoGenInformation )
            // InternalVideoGen.g:1842:1: ruleVideoGenInformation
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
    // InternalVideoGen.g:1851:1: rule__VideoGeneratorModel__VideoseqsAssignment_4 : ( ruleVideoSeq ) ;
    public final void rule__VideoGeneratorModel__VideoseqsAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:1855:1: ( ( ruleVideoSeq ) )
            // InternalVideoGen.g:1856:1: ( ruleVideoSeq )
            {
            // InternalVideoGen.g:1856:1: ( ruleVideoSeq )
            // InternalVideoGen.g:1857:1: ruleVideoSeq
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
    // InternalVideoGen.g:1866:1: rule__VideoGenInformation__AuthorNameAssignment_1_1 : ( RULE_STRING ) ;
    public final void rule__VideoGenInformation__AuthorNameAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:1870:1: ( ( RULE_STRING ) )
            // InternalVideoGen.g:1871:1: ( RULE_STRING )
            {
            // InternalVideoGen.g:1871:1: ( RULE_STRING )
            // InternalVideoGen.g:1872:1: RULE_STRING
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
    // InternalVideoGen.g:1881:1: rule__VideoGenInformation__VersionAssignment_2_1 : ( RULE_STRING ) ;
    public final void rule__VideoGenInformation__VersionAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:1885:1: ( ( RULE_STRING ) )
            // InternalVideoGen.g:1886:1: ( RULE_STRING )
            {
            // InternalVideoGen.g:1886:1: ( RULE_STRING )
            // InternalVideoGen.g:1887:1: RULE_STRING
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
    // InternalVideoGen.g:1896:1: rule__VideoGenInformation__CreationDateAssignment_3_1 : ( RULE_STRING ) ;
    public final void rule__VideoGenInformation__CreationDateAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:1900:1: ( ( RULE_STRING ) )
            // InternalVideoGen.g:1901:1: ( RULE_STRING )
            {
            // InternalVideoGen.g:1901:1: ( RULE_STRING )
            // InternalVideoGen.g:1902:1: RULE_STRING
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
    // InternalVideoGen.g:1911:1: rule__MandatoryVideoSeq__DescriptionAssignment_1 : ( ruleVideoDescription ) ;
    public final void rule__MandatoryVideoSeq__DescriptionAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:1915:1: ( ( ruleVideoDescription ) )
            // InternalVideoGen.g:1916:1: ( ruleVideoDescription )
            {
            // InternalVideoGen.g:1916:1: ( ruleVideoDescription )
            // InternalVideoGen.g:1917:1: ruleVideoDescription
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
    // InternalVideoGen.g:1926:1: rule__OptionalVideoSeq__DescriptionAssignment_1 : ( ruleVideoDescription ) ;
    public final void rule__OptionalVideoSeq__DescriptionAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:1930:1: ( ( ruleVideoDescription ) )
            // InternalVideoGen.g:1931:1: ( ruleVideoDescription )
            {
            // InternalVideoGen.g:1931:1: ( ruleVideoDescription )
            // InternalVideoGen.g:1932:1: ruleVideoDescription
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
    // InternalVideoGen.g:1941:1: rule__AlternativeVideoSeq__VideoidAssignment_1 : ( RULE_ID ) ;
    public final void rule__AlternativeVideoSeq__VideoidAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:1945:1: ( ( RULE_ID ) )
            // InternalVideoGen.g:1946:1: ( RULE_ID )
            {
            // InternalVideoGen.g:1946:1: ( RULE_ID )
            // InternalVideoGen.g:1947:1: RULE_ID
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
    // InternalVideoGen.g:1956:1: rule__AlternativeVideoSeq__VideodescsAssignment_3 : ( ruleVideoDescription ) ;
    public final void rule__AlternativeVideoSeq__VideodescsAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:1960:1: ( ( ruleVideoDescription ) )
            // InternalVideoGen.g:1961:1: ( ruleVideoDescription )
            {
            // InternalVideoGen.g:1961:1: ( ruleVideoDescription )
            // InternalVideoGen.g:1962:1: ruleVideoDescription
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
    // InternalVideoGen.g:1971:1: rule__VideoDescription__VideoidAssignment_1 : ( RULE_ID ) ;
    public final void rule__VideoDescription__VideoidAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:1975:1: ( ( RULE_ID ) )
            // InternalVideoGen.g:1976:1: ( RULE_ID )
            {
            // InternalVideoGen.g:1976:1: ( RULE_ID )
            // InternalVideoGen.g:1977:1: RULE_ID
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
    // InternalVideoGen.g:1986:1: rule__VideoDescription__LocationAssignment_2 : ( RULE_STRING ) ;
    public final void rule__VideoDescription__LocationAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:1990:1: ( ( RULE_STRING ) )
            // InternalVideoGen.g:1991:1: ( RULE_STRING )
            {
            // InternalVideoGen.g:1991:1: ( RULE_STRING )
            // InternalVideoGen.g:1992:1: RULE_STRING
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
    // InternalVideoGen.g:2001:1: rule__VideoDescription__DurationAssignment_3_1_1 : ( RULE_INT ) ;
    public final void rule__VideoDescription__DurationAssignment_3_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:2005:1: ( ( RULE_INT ) )
            // InternalVideoGen.g:2006:1: ( RULE_INT )
            {
            // InternalVideoGen.g:2006:1: ( RULE_INT )
            // InternalVideoGen.g:2007:1: RULE_INT
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
    // InternalVideoGen.g:2016:1: rule__VideoDescription__ProbabilityAssignment_3_2_1 : ( RULE_INT ) ;
    public final void rule__VideoDescription__ProbabilityAssignment_3_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:2020:1: ( ( RULE_INT ) )
            // InternalVideoGen.g:2021:1: ( RULE_INT )
            {
            // InternalVideoGen.g:2021:1: ( RULE_INT )
            // InternalVideoGen.g:2022:1: RULE_INT
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
    // InternalVideoGen.g:2031:1: rule__VideoDescription__SizeAssignment_3_3_1 : ( RULE_INT ) ;
    public final void rule__VideoDescription__SizeAssignment_3_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:2035:1: ( ( RULE_INT ) )
            // InternalVideoGen.g:2036:1: ( RULE_INT )
            {
            // InternalVideoGen.g:2036:1: ( RULE_INT )
            // InternalVideoGen.g:2037:1: RULE_INT
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


    // $ANTLR start "rule__VideoDescription__TextIncrustAssignment_3_4_1"
    // InternalVideoGen.g:2046:1: rule__VideoDescription__TextIncrustAssignment_3_4_1 : ( RULE_STRING ) ;
    public final void rule__VideoDescription__TextIncrustAssignment_3_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:2050:1: ( ( RULE_STRING ) )
            // InternalVideoGen.g:2051:1: ( RULE_STRING )
            {
            // InternalVideoGen.g:2051:1: ( RULE_STRING )
            // InternalVideoGen.g:2052:1: RULE_STRING
            {
             before(grammarAccess.getVideoDescriptionAccess().getTextIncrustSTRINGTerminalRuleCall_3_4_1_0()); 
            match(input,RULE_STRING,FOLLOW_2); 
             after(grammarAccess.getVideoDescriptionAccess().getTextIncrustSTRINGTerminalRuleCall_3_4_1_0()); 

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
    // $ANTLR end "rule__VideoDescription__TextIncrustAssignment_3_4_1"


    // $ANTLR start "rule__VideoDescription__FilterAssignment_3_5_1"
    // InternalVideoGen.g:2061:1: rule__VideoDescription__FilterAssignment_3_5_1 : ( RULE_STRING ) ;
    public final void rule__VideoDescription__FilterAssignment_3_5_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:2065:1: ( ( RULE_STRING ) )
            // InternalVideoGen.g:2066:1: ( RULE_STRING )
            {
            // InternalVideoGen.g:2066:1: ( RULE_STRING )
            // InternalVideoGen.g:2067:1: RULE_STRING
            {
             before(grammarAccess.getVideoDescriptionAccess().getFilterSTRINGTerminalRuleCall_3_5_1_0()); 
            match(input,RULE_STRING,FOLLOW_2); 
             after(grammarAccess.getVideoDescriptionAccess().getFilterSTRINGTerminalRuleCall_3_5_1_0()); 

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
    // $ANTLR end "rule__VideoDescription__FilterAssignment_3_5_1"


    // $ANTLR start "rule__VideoDescription__DescriptionAssignment_3_6_1"
    // InternalVideoGen.g:2076:1: rule__VideoDescription__DescriptionAssignment_3_6_1 : ( RULE_STRING ) ;
    public final void rule__VideoDescription__DescriptionAssignment_3_6_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:2080:1: ( ( RULE_STRING ) )
            // InternalVideoGen.g:2081:1: ( RULE_STRING )
            {
            // InternalVideoGen.g:2081:1: ( RULE_STRING )
            // InternalVideoGen.g:2082:1: RULE_STRING
            {
             before(grammarAccess.getVideoDescriptionAccess().getDescriptionSTRINGTerminalRuleCall_3_6_1_0()); 
            match(input,RULE_STRING,FOLLOW_2); 
             after(grammarAccess.getVideoDescriptionAccess().getDescriptionSTRINGTerminalRuleCall_3_6_1_0()); 

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
    // $ANTLR end "rule__VideoDescription__DescriptionAssignment_3_6_1"

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
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000007E00020L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000000100L});

}