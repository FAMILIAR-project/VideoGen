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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_LEFT_BRACKET", "RULE_RIGHT_BRACKET", "RULE_STRING", "RULE_ID", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'h'", "'horizontal'", "'v'", "'vertical'", "'VideoGen'", "'@author'", "'@version'", "'@creation'", "'mandatory'", "'optional'", "'alternatives'", "'videoseq'", "'duration'", "'probability'", "'size'", "'description'", "'filter'", "'b&w'", "'negate'", "'flip'"
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
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int RULE_ID=7;
    public static final int RULE_WS=11;
    public static final int RULE_LEFT_BRACKET=4;
    public static final int RULE_ANY_OTHER=12;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int RULE_INT=8;
    public static final int T__29=29;
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
    // InternalVideoGen.g:265:1: ruleFilter : ( ( rule__Filter__Alternatives ) ) ;
    public final void ruleFilter() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:269:2: ( ( ( rule__Filter__Alternatives ) ) )
            // InternalVideoGen.g:270:1: ( ( rule__Filter__Alternatives ) )
            {
            // InternalVideoGen.g:270:1: ( ( rule__Filter__Alternatives ) )
            // InternalVideoGen.g:271:1: ( rule__Filter__Alternatives )
            {
             before(grammarAccess.getFilterAccess().getAlternatives()); 
            // InternalVideoGen.g:272:1: ( rule__Filter__Alternatives )
            // InternalVideoGen.g:272:2: rule__Filter__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__Filter__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getFilterAccess().getAlternatives()); 

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


    // $ANTLR start "entryRuleBlackWhiteFilter"
    // InternalVideoGen.g:284:1: entryRuleBlackWhiteFilter : ruleBlackWhiteFilter EOF ;
    public final void entryRuleBlackWhiteFilter() throws RecognitionException {
        try {
            // InternalVideoGen.g:285:1: ( ruleBlackWhiteFilter EOF )
            // InternalVideoGen.g:286:1: ruleBlackWhiteFilter EOF
            {
             before(grammarAccess.getBlackWhiteFilterRule()); 
            pushFollow(FOLLOW_1);
            ruleBlackWhiteFilter();

            state._fsp--;

             after(grammarAccess.getBlackWhiteFilterRule()); 
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
    // $ANTLR end "entryRuleBlackWhiteFilter"


    // $ANTLR start "ruleBlackWhiteFilter"
    // InternalVideoGen.g:293:1: ruleBlackWhiteFilter : ( ( rule__BlackWhiteFilter__Group__0 ) ) ;
    public final void ruleBlackWhiteFilter() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:297:2: ( ( ( rule__BlackWhiteFilter__Group__0 ) ) )
            // InternalVideoGen.g:298:1: ( ( rule__BlackWhiteFilter__Group__0 ) )
            {
            // InternalVideoGen.g:298:1: ( ( rule__BlackWhiteFilter__Group__0 ) )
            // InternalVideoGen.g:299:1: ( rule__BlackWhiteFilter__Group__0 )
            {
             before(grammarAccess.getBlackWhiteFilterAccess().getGroup()); 
            // InternalVideoGen.g:300:1: ( rule__BlackWhiteFilter__Group__0 )
            // InternalVideoGen.g:300:2: rule__BlackWhiteFilter__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__BlackWhiteFilter__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getBlackWhiteFilterAccess().getGroup()); 

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
    // $ANTLR end "ruleBlackWhiteFilter"


    // $ANTLR start "entryRuleNegateFilter"
    // InternalVideoGen.g:312:1: entryRuleNegateFilter : ruleNegateFilter EOF ;
    public final void entryRuleNegateFilter() throws RecognitionException {
        try {
            // InternalVideoGen.g:313:1: ( ruleNegateFilter EOF )
            // InternalVideoGen.g:314:1: ruleNegateFilter EOF
            {
             before(grammarAccess.getNegateFilterRule()); 
            pushFollow(FOLLOW_1);
            ruleNegateFilter();

            state._fsp--;

             after(grammarAccess.getNegateFilterRule()); 
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
    // $ANTLR end "entryRuleNegateFilter"


    // $ANTLR start "ruleNegateFilter"
    // InternalVideoGen.g:321:1: ruleNegateFilter : ( ( rule__NegateFilter__Group__0 ) ) ;
    public final void ruleNegateFilter() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:325:2: ( ( ( rule__NegateFilter__Group__0 ) ) )
            // InternalVideoGen.g:326:1: ( ( rule__NegateFilter__Group__0 ) )
            {
            // InternalVideoGen.g:326:1: ( ( rule__NegateFilter__Group__0 ) )
            // InternalVideoGen.g:327:1: ( rule__NegateFilter__Group__0 )
            {
             before(grammarAccess.getNegateFilterAccess().getGroup()); 
            // InternalVideoGen.g:328:1: ( rule__NegateFilter__Group__0 )
            // InternalVideoGen.g:328:2: rule__NegateFilter__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__NegateFilter__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getNegateFilterAccess().getGroup()); 

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
    // $ANTLR end "ruleNegateFilter"


    // $ANTLR start "entryRuleFlipFilter"
    // InternalVideoGen.g:340:1: entryRuleFlipFilter : ruleFlipFilter EOF ;
    public final void entryRuleFlipFilter() throws RecognitionException {
        try {
            // InternalVideoGen.g:341:1: ( ruleFlipFilter EOF )
            // InternalVideoGen.g:342:1: ruleFlipFilter EOF
            {
             before(grammarAccess.getFlipFilterRule()); 
            pushFollow(FOLLOW_1);
            ruleFlipFilter();

            state._fsp--;

             after(grammarAccess.getFlipFilterRule()); 
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
    // $ANTLR end "entryRuleFlipFilter"


    // $ANTLR start "ruleFlipFilter"
    // InternalVideoGen.g:349:1: ruleFlipFilter : ( ( rule__FlipFilter__Group__0 ) ) ;
    public final void ruleFlipFilter() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:353:2: ( ( ( rule__FlipFilter__Group__0 ) ) )
            // InternalVideoGen.g:354:1: ( ( rule__FlipFilter__Group__0 ) )
            {
            // InternalVideoGen.g:354:1: ( ( rule__FlipFilter__Group__0 ) )
            // InternalVideoGen.g:355:1: ( rule__FlipFilter__Group__0 )
            {
             before(grammarAccess.getFlipFilterAccess().getGroup()); 
            // InternalVideoGen.g:356:1: ( rule__FlipFilter__Group__0 )
            // InternalVideoGen.g:356:2: rule__FlipFilter__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__FlipFilter__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getFlipFilterAccess().getGroup()); 

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
    // $ANTLR end "ruleFlipFilter"


    // $ANTLR start "rule__VideoSeq__Alternatives"
    // InternalVideoGen.g:368:1: rule__VideoSeq__Alternatives : ( ( ruleMandatoryVideoSeq ) | ( ruleOptionalVideoSeq ) | ( ruleAlternativeVideoSeq ) );
    public final void rule__VideoSeq__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:372:1: ( ( ruleMandatoryVideoSeq ) | ( ruleOptionalVideoSeq ) | ( ruleAlternativeVideoSeq ) )
            int alt1=3;
            switch ( input.LA(1) ) {
            case 21:
                {
                alt1=1;
                }
                break;
            case 22:
                {
                alt1=2;
                }
                break;
            case 23:
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
                    // InternalVideoGen.g:373:1: ( ruleMandatoryVideoSeq )
                    {
                    // InternalVideoGen.g:373:1: ( ruleMandatoryVideoSeq )
                    // InternalVideoGen.g:374:1: ruleMandatoryVideoSeq
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
                    // InternalVideoGen.g:379:6: ( ruleOptionalVideoSeq )
                    {
                    // InternalVideoGen.g:379:6: ( ruleOptionalVideoSeq )
                    // InternalVideoGen.g:380:1: ruleOptionalVideoSeq
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
                    // InternalVideoGen.g:385:6: ( ruleAlternativeVideoSeq )
                    {
                    // InternalVideoGen.g:385:6: ( ruleAlternativeVideoSeq )
                    // InternalVideoGen.g:386:1: ruleAlternativeVideoSeq
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


    // $ANTLR start "rule__Filter__Alternatives"
    // InternalVideoGen.g:396:1: rule__Filter__Alternatives : ( ( ruleFlipFilter ) | ( ruleNegateFilter ) | ( ruleBlackWhiteFilter ) );
    public final void rule__Filter__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:400:1: ( ( ruleFlipFilter ) | ( ruleNegateFilter ) | ( ruleBlackWhiteFilter ) )
            int alt2=3;
            switch ( input.LA(1) ) {
            case 32:
                {
                alt2=1;
                }
                break;
            case 31:
                {
                alt2=2;
                }
                break;
            case 30:
                {
                alt2=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }

            switch (alt2) {
                case 1 :
                    // InternalVideoGen.g:401:1: ( ruleFlipFilter )
                    {
                    // InternalVideoGen.g:401:1: ( ruleFlipFilter )
                    // InternalVideoGen.g:402:1: ruleFlipFilter
                    {
                     before(grammarAccess.getFilterAccess().getFlipFilterParserRuleCall_0()); 
                    pushFollow(FOLLOW_2);
                    ruleFlipFilter();

                    state._fsp--;

                     after(grammarAccess.getFilterAccess().getFlipFilterParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalVideoGen.g:407:6: ( ruleNegateFilter )
                    {
                    // InternalVideoGen.g:407:6: ( ruleNegateFilter )
                    // InternalVideoGen.g:408:1: ruleNegateFilter
                    {
                     before(grammarAccess.getFilterAccess().getNegateFilterParserRuleCall_1()); 
                    pushFollow(FOLLOW_2);
                    ruleNegateFilter();

                    state._fsp--;

                     after(grammarAccess.getFilterAccess().getNegateFilterParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalVideoGen.g:413:6: ( ruleBlackWhiteFilter )
                    {
                    // InternalVideoGen.g:413:6: ( ruleBlackWhiteFilter )
                    // InternalVideoGen.g:414:1: ruleBlackWhiteFilter
                    {
                     before(grammarAccess.getFilterAccess().getBlackWhiteFilterParserRuleCall_2()); 
                    pushFollow(FOLLOW_2);
                    ruleBlackWhiteFilter();

                    state._fsp--;

                     after(grammarAccess.getFilterAccess().getBlackWhiteFilterParserRuleCall_2()); 

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
    // $ANTLR end "rule__Filter__Alternatives"


    // $ANTLR start "rule__FlipFilter__OrientationAlternatives_1_0"
    // InternalVideoGen.g:424:1: rule__FlipFilter__OrientationAlternatives_1_0 : ( ( 'h' ) | ( 'horizontal' ) | ( 'v' ) | ( 'vertical' ) );
    public final void rule__FlipFilter__OrientationAlternatives_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:428:1: ( ( 'h' ) | ( 'horizontal' ) | ( 'v' ) | ( 'vertical' ) )
            int alt3=4;
            switch ( input.LA(1) ) {
            case 13:
                {
                alt3=1;
                }
                break;
            case 14:
                {
                alt3=2;
                }
                break;
            case 15:
                {
                alt3=3;
                }
                break;
            case 16:
                {
                alt3=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }

            switch (alt3) {
                case 1 :
                    // InternalVideoGen.g:429:1: ( 'h' )
                    {
                    // InternalVideoGen.g:429:1: ( 'h' )
                    // InternalVideoGen.g:430:1: 'h'
                    {
                     before(grammarAccess.getFlipFilterAccess().getOrientationHKeyword_1_0_0()); 
                    match(input,13,FOLLOW_2); 
                     after(grammarAccess.getFlipFilterAccess().getOrientationHKeyword_1_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalVideoGen.g:437:6: ( 'horizontal' )
                    {
                    // InternalVideoGen.g:437:6: ( 'horizontal' )
                    // InternalVideoGen.g:438:1: 'horizontal'
                    {
                     before(grammarAccess.getFlipFilterAccess().getOrientationHorizontalKeyword_1_0_1()); 
                    match(input,14,FOLLOW_2); 
                     after(grammarAccess.getFlipFilterAccess().getOrientationHorizontalKeyword_1_0_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalVideoGen.g:445:6: ( 'v' )
                    {
                    // InternalVideoGen.g:445:6: ( 'v' )
                    // InternalVideoGen.g:446:1: 'v'
                    {
                     before(grammarAccess.getFlipFilterAccess().getOrientationVKeyword_1_0_2()); 
                    match(input,15,FOLLOW_2); 
                     after(grammarAccess.getFlipFilterAccess().getOrientationVKeyword_1_0_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalVideoGen.g:453:6: ( 'vertical' )
                    {
                    // InternalVideoGen.g:453:6: ( 'vertical' )
                    // InternalVideoGen.g:454:1: 'vertical'
                    {
                     before(grammarAccess.getFlipFilterAccess().getOrientationVerticalKeyword_1_0_3()); 
                    match(input,16,FOLLOW_2); 
                     after(grammarAccess.getFlipFilterAccess().getOrientationVerticalKeyword_1_0_3()); 

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
    // $ANTLR end "rule__FlipFilter__OrientationAlternatives_1_0"


    // $ANTLR start "rule__VideoGeneratorModel__Group__0"
    // InternalVideoGen.g:468:1: rule__VideoGeneratorModel__Group__0 : rule__VideoGeneratorModel__Group__0__Impl rule__VideoGeneratorModel__Group__1 ;
    public final void rule__VideoGeneratorModel__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:472:1: ( rule__VideoGeneratorModel__Group__0__Impl rule__VideoGeneratorModel__Group__1 )
            // InternalVideoGen.g:473:2: rule__VideoGeneratorModel__Group__0__Impl rule__VideoGeneratorModel__Group__1
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
    // InternalVideoGen.g:480:1: rule__VideoGeneratorModel__Group__0__Impl : ( () ) ;
    public final void rule__VideoGeneratorModel__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:484:1: ( ( () ) )
            // InternalVideoGen.g:485:1: ( () )
            {
            // InternalVideoGen.g:485:1: ( () )
            // InternalVideoGen.g:486:1: ()
            {
             before(grammarAccess.getVideoGeneratorModelAccess().getVideoGeneratorModelAction_0()); 
            // InternalVideoGen.g:487:1: ()
            // InternalVideoGen.g:489:1: 
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
    // InternalVideoGen.g:499:1: rule__VideoGeneratorModel__Group__1 : rule__VideoGeneratorModel__Group__1__Impl rule__VideoGeneratorModel__Group__2 ;
    public final void rule__VideoGeneratorModel__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:503:1: ( rule__VideoGeneratorModel__Group__1__Impl rule__VideoGeneratorModel__Group__2 )
            // InternalVideoGen.g:504:2: rule__VideoGeneratorModel__Group__1__Impl rule__VideoGeneratorModel__Group__2
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
    // InternalVideoGen.g:511:1: rule__VideoGeneratorModel__Group__1__Impl : ( ( rule__VideoGeneratorModel__InformationAssignment_1 )? ) ;
    public final void rule__VideoGeneratorModel__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:515:1: ( ( ( rule__VideoGeneratorModel__InformationAssignment_1 )? ) )
            // InternalVideoGen.g:516:1: ( ( rule__VideoGeneratorModel__InformationAssignment_1 )? )
            {
            // InternalVideoGen.g:516:1: ( ( rule__VideoGeneratorModel__InformationAssignment_1 )? )
            // InternalVideoGen.g:517:1: ( rule__VideoGeneratorModel__InformationAssignment_1 )?
            {
             before(grammarAccess.getVideoGeneratorModelAccess().getInformationAssignment_1()); 
            // InternalVideoGen.g:518:1: ( rule__VideoGeneratorModel__InformationAssignment_1 )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==18) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // InternalVideoGen.g:518:2: rule__VideoGeneratorModel__InformationAssignment_1
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
    // InternalVideoGen.g:528:1: rule__VideoGeneratorModel__Group__2 : rule__VideoGeneratorModel__Group__2__Impl rule__VideoGeneratorModel__Group__3 ;
    public final void rule__VideoGeneratorModel__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:532:1: ( rule__VideoGeneratorModel__Group__2__Impl rule__VideoGeneratorModel__Group__3 )
            // InternalVideoGen.g:533:2: rule__VideoGeneratorModel__Group__2__Impl rule__VideoGeneratorModel__Group__3
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
    // InternalVideoGen.g:540:1: rule__VideoGeneratorModel__Group__2__Impl : ( 'VideoGen' ) ;
    public final void rule__VideoGeneratorModel__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:544:1: ( ( 'VideoGen' ) )
            // InternalVideoGen.g:545:1: ( 'VideoGen' )
            {
            // InternalVideoGen.g:545:1: ( 'VideoGen' )
            // InternalVideoGen.g:546:1: 'VideoGen'
            {
             before(grammarAccess.getVideoGeneratorModelAccess().getVideoGenKeyword_2()); 
            match(input,17,FOLLOW_2); 
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
    // InternalVideoGen.g:559:1: rule__VideoGeneratorModel__Group__3 : rule__VideoGeneratorModel__Group__3__Impl rule__VideoGeneratorModel__Group__4 ;
    public final void rule__VideoGeneratorModel__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:563:1: ( rule__VideoGeneratorModel__Group__3__Impl rule__VideoGeneratorModel__Group__4 )
            // InternalVideoGen.g:564:2: rule__VideoGeneratorModel__Group__3__Impl rule__VideoGeneratorModel__Group__4
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
    // InternalVideoGen.g:571:1: rule__VideoGeneratorModel__Group__3__Impl : ( RULE_LEFT_BRACKET ) ;
    public final void rule__VideoGeneratorModel__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:575:1: ( ( RULE_LEFT_BRACKET ) )
            // InternalVideoGen.g:576:1: ( RULE_LEFT_BRACKET )
            {
            // InternalVideoGen.g:576:1: ( RULE_LEFT_BRACKET )
            // InternalVideoGen.g:577:1: RULE_LEFT_BRACKET
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
    // InternalVideoGen.g:588:1: rule__VideoGeneratorModel__Group__4 : rule__VideoGeneratorModel__Group__4__Impl rule__VideoGeneratorModel__Group__5 ;
    public final void rule__VideoGeneratorModel__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:592:1: ( rule__VideoGeneratorModel__Group__4__Impl rule__VideoGeneratorModel__Group__5 )
            // InternalVideoGen.g:593:2: rule__VideoGeneratorModel__Group__4__Impl rule__VideoGeneratorModel__Group__5
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
    // InternalVideoGen.g:600:1: rule__VideoGeneratorModel__Group__4__Impl : ( ( ( rule__VideoGeneratorModel__VideoseqsAssignment_4 ) ) ( ( rule__VideoGeneratorModel__VideoseqsAssignment_4 )* ) ) ;
    public final void rule__VideoGeneratorModel__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:604:1: ( ( ( ( rule__VideoGeneratorModel__VideoseqsAssignment_4 ) ) ( ( rule__VideoGeneratorModel__VideoseqsAssignment_4 )* ) ) )
            // InternalVideoGen.g:605:1: ( ( ( rule__VideoGeneratorModel__VideoseqsAssignment_4 ) ) ( ( rule__VideoGeneratorModel__VideoseqsAssignment_4 )* ) )
            {
            // InternalVideoGen.g:605:1: ( ( ( rule__VideoGeneratorModel__VideoseqsAssignment_4 ) ) ( ( rule__VideoGeneratorModel__VideoseqsAssignment_4 )* ) )
            // InternalVideoGen.g:606:1: ( ( rule__VideoGeneratorModel__VideoseqsAssignment_4 ) ) ( ( rule__VideoGeneratorModel__VideoseqsAssignment_4 )* )
            {
            // InternalVideoGen.g:606:1: ( ( rule__VideoGeneratorModel__VideoseqsAssignment_4 ) )
            // InternalVideoGen.g:607:1: ( rule__VideoGeneratorModel__VideoseqsAssignment_4 )
            {
             before(grammarAccess.getVideoGeneratorModelAccess().getVideoseqsAssignment_4()); 
            // InternalVideoGen.g:608:1: ( rule__VideoGeneratorModel__VideoseqsAssignment_4 )
            // InternalVideoGen.g:608:2: rule__VideoGeneratorModel__VideoseqsAssignment_4
            {
            pushFollow(FOLLOW_7);
            rule__VideoGeneratorModel__VideoseqsAssignment_4();

            state._fsp--;


            }

             after(grammarAccess.getVideoGeneratorModelAccess().getVideoseqsAssignment_4()); 

            }

            // InternalVideoGen.g:611:1: ( ( rule__VideoGeneratorModel__VideoseqsAssignment_4 )* )
            // InternalVideoGen.g:612:1: ( rule__VideoGeneratorModel__VideoseqsAssignment_4 )*
            {
             before(grammarAccess.getVideoGeneratorModelAccess().getVideoseqsAssignment_4()); 
            // InternalVideoGen.g:613:1: ( rule__VideoGeneratorModel__VideoseqsAssignment_4 )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( ((LA5_0>=21 && LA5_0<=23)) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // InternalVideoGen.g:613:2: rule__VideoGeneratorModel__VideoseqsAssignment_4
            	    {
            	    pushFollow(FOLLOW_7);
            	    rule__VideoGeneratorModel__VideoseqsAssignment_4();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop5;
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
    // InternalVideoGen.g:624:1: rule__VideoGeneratorModel__Group__5 : rule__VideoGeneratorModel__Group__5__Impl ;
    public final void rule__VideoGeneratorModel__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:628:1: ( rule__VideoGeneratorModel__Group__5__Impl )
            // InternalVideoGen.g:629:2: rule__VideoGeneratorModel__Group__5__Impl
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
    // InternalVideoGen.g:635:1: rule__VideoGeneratorModel__Group__5__Impl : ( RULE_RIGHT_BRACKET ) ;
    public final void rule__VideoGeneratorModel__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:639:1: ( ( RULE_RIGHT_BRACKET ) )
            // InternalVideoGen.g:640:1: ( RULE_RIGHT_BRACKET )
            {
            // InternalVideoGen.g:640:1: ( RULE_RIGHT_BRACKET )
            // InternalVideoGen.g:641:1: RULE_RIGHT_BRACKET
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
    // InternalVideoGen.g:664:1: rule__VideoGenInformation__Group__0 : rule__VideoGenInformation__Group__0__Impl rule__VideoGenInformation__Group__1 ;
    public final void rule__VideoGenInformation__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:668:1: ( rule__VideoGenInformation__Group__0__Impl rule__VideoGenInformation__Group__1 )
            // InternalVideoGen.g:669:2: rule__VideoGenInformation__Group__0__Impl rule__VideoGenInformation__Group__1
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
    // InternalVideoGen.g:676:1: rule__VideoGenInformation__Group__0__Impl : ( () ) ;
    public final void rule__VideoGenInformation__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:680:1: ( ( () ) )
            // InternalVideoGen.g:681:1: ( () )
            {
            // InternalVideoGen.g:681:1: ( () )
            // InternalVideoGen.g:682:1: ()
            {
             before(grammarAccess.getVideoGenInformationAccess().getVideoGenInformationAction_0()); 
            // InternalVideoGen.g:683:1: ()
            // InternalVideoGen.g:685:1: 
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
    // InternalVideoGen.g:695:1: rule__VideoGenInformation__Group__1 : rule__VideoGenInformation__Group__1__Impl rule__VideoGenInformation__Group__2 ;
    public final void rule__VideoGenInformation__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:699:1: ( rule__VideoGenInformation__Group__1__Impl rule__VideoGenInformation__Group__2 )
            // InternalVideoGen.g:700:2: rule__VideoGenInformation__Group__1__Impl rule__VideoGenInformation__Group__2
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
    // InternalVideoGen.g:707:1: rule__VideoGenInformation__Group__1__Impl : ( ( rule__VideoGenInformation__Group_1__0 ) ) ;
    public final void rule__VideoGenInformation__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:711:1: ( ( ( rule__VideoGenInformation__Group_1__0 ) ) )
            // InternalVideoGen.g:712:1: ( ( rule__VideoGenInformation__Group_1__0 ) )
            {
            // InternalVideoGen.g:712:1: ( ( rule__VideoGenInformation__Group_1__0 ) )
            // InternalVideoGen.g:713:1: ( rule__VideoGenInformation__Group_1__0 )
            {
             before(grammarAccess.getVideoGenInformationAccess().getGroup_1()); 
            // InternalVideoGen.g:714:1: ( rule__VideoGenInformation__Group_1__0 )
            // InternalVideoGen.g:714:2: rule__VideoGenInformation__Group_1__0
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
    // InternalVideoGen.g:724:1: rule__VideoGenInformation__Group__2 : rule__VideoGenInformation__Group__2__Impl rule__VideoGenInformation__Group__3 ;
    public final void rule__VideoGenInformation__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:728:1: ( rule__VideoGenInformation__Group__2__Impl rule__VideoGenInformation__Group__3 )
            // InternalVideoGen.g:729:2: rule__VideoGenInformation__Group__2__Impl rule__VideoGenInformation__Group__3
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
    // InternalVideoGen.g:736:1: rule__VideoGenInformation__Group__2__Impl : ( ( rule__VideoGenInformation__Group_2__0 )? ) ;
    public final void rule__VideoGenInformation__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:740:1: ( ( ( rule__VideoGenInformation__Group_2__0 )? ) )
            // InternalVideoGen.g:741:1: ( ( rule__VideoGenInformation__Group_2__0 )? )
            {
            // InternalVideoGen.g:741:1: ( ( rule__VideoGenInformation__Group_2__0 )? )
            // InternalVideoGen.g:742:1: ( rule__VideoGenInformation__Group_2__0 )?
            {
             before(grammarAccess.getVideoGenInformationAccess().getGroup_2()); 
            // InternalVideoGen.g:743:1: ( rule__VideoGenInformation__Group_2__0 )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==19) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // InternalVideoGen.g:743:2: rule__VideoGenInformation__Group_2__0
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
    // InternalVideoGen.g:753:1: rule__VideoGenInformation__Group__3 : rule__VideoGenInformation__Group__3__Impl ;
    public final void rule__VideoGenInformation__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:757:1: ( rule__VideoGenInformation__Group__3__Impl )
            // InternalVideoGen.g:758:2: rule__VideoGenInformation__Group__3__Impl
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
    // InternalVideoGen.g:764:1: rule__VideoGenInformation__Group__3__Impl : ( ( rule__VideoGenInformation__Group_3__0 )? ) ;
    public final void rule__VideoGenInformation__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:768:1: ( ( ( rule__VideoGenInformation__Group_3__0 )? ) )
            // InternalVideoGen.g:769:1: ( ( rule__VideoGenInformation__Group_3__0 )? )
            {
            // InternalVideoGen.g:769:1: ( ( rule__VideoGenInformation__Group_3__0 )? )
            // InternalVideoGen.g:770:1: ( rule__VideoGenInformation__Group_3__0 )?
            {
             before(grammarAccess.getVideoGenInformationAccess().getGroup_3()); 
            // InternalVideoGen.g:771:1: ( rule__VideoGenInformation__Group_3__0 )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==20) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // InternalVideoGen.g:771:2: rule__VideoGenInformation__Group_3__0
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
    // InternalVideoGen.g:789:1: rule__VideoGenInformation__Group_1__0 : rule__VideoGenInformation__Group_1__0__Impl rule__VideoGenInformation__Group_1__1 ;
    public final void rule__VideoGenInformation__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:793:1: ( rule__VideoGenInformation__Group_1__0__Impl rule__VideoGenInformation__Group_1__1 )
            // InternalVideoGen.g:794:2: rule__VideoGenInformation__Group_1__0__Impl rule__VideoGenInformation__Group_1__1
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
    // InternalVideoGen.g:801:1: rule__VideoGenInformation__Group_1__0__Impl : ( '@author' ) ;
    public final void rule__VideoGenInformation__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:805:1: ( ( '@author' ) )
            // InternalVideoGen.g:806:1: ( '@author' )
            {
            // InternalVideoGen.g:806:1: ( '@author' )
            // InternalVideoGen.g:807:1: '@author'
            {
             before(grammarAccess.getVideoGenInformationAccess().getAuthorKeyword_1_0()); 
            match(input,18,FOLLOW_2); 
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
    // InternalVideoGen.g:820:1: rule__VideoGenInformation__Group_1__1 : rule__VideoGenInformation__Group_1__1__Impl ;
    public final void rule__VideoGenInformation__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:824:1: ( rule__VideoGenInformation__Group_1__1__Impl )
            // InternalVideoGen.g:825:2: rule__VideoGenInformation__Group_1__1__Impl
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
    // InternalVideoGen.g:831:1: rule__VideoGenInformation__Group_1__1__Impl : ( ( rule__VideoGenInformation__AuthorNameAssignment_1_1 ) ) ;
    public final void rule__VideoGenInformation__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:835:1: ( ( ( rule__VideoGenInformation__AuthorNameAssignment_1_1 ) ) )
            // InternalVideoGen.g:836:1: ( ( rule__VideoGenInformation__AuthorNameAssignment_1_1 ) )
            {
            // InternalVideoGen.g:836:1: ( ( rule__VideoGenInformation__AuthorNameAssignment_1_1 ) )
            // InternalVideoGen.g:837:1: ( rule__VideoGenInformation__AuthorNameAssignment_1_1 )
            {
             before(grammarAccess.getVideoGenInformationAccess().getAuthorNameAssignment_1_1()); 
            // InternalVideoGen.g:838:1: ( rule__VideoGenInformation__AuthorNameAssignment_1_1 )
            // InternalVideoGen.g:838:2: rule__VideoGenInformation__AuthorNameAssignment_1_1
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
    // InternalVideoGen.g:852:1: rule__VideoGenInformation__Group_2__0 : rule__VideoGenInformation__Group_2__0__Impl rule__VideoGenInformation__Group_2__1 ;
    public final void rule__VideoGenInformation__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:856:1: ( rule__VideoGenInformation__Group_2__0__Impl rule__VideoGenInformation__Group_2__1 )
            // InternalVideoGen.g:857:2: rule__VideoGenInformation__Group_2__0__Impl rule__VideoGenInformation__Group_2__1
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
    // InternalVideoGen.g:864:1: rule__VideoGenInformation__Group_2__0__Impl : ( '@version' ) ;
    public final void rule__VideoGenInformation__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:868:1: ( ( '@version' ) )
            // InternalVideoGen.g:869:1: ( '@version' )
            {
            // InternalVideoGen.g:869:1: ( '@version' )
            // InternalVideoGen.g:870:1: '@version'
            {
             before(grammarAccess.getVideoGenInformationAccess().getVersionKeyword_2_0()); 
            match(input,19,FOLLOW_2); 
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
    // InternalVideoGen.g:883:1: rule__VideoGenInformation__Group_2__1 : rule__VideoGenInformation__Group_2__1__Impl ;
    public final void rule__VideoGenInformation__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:887:1: ( rule__VideoGenInformation__Group_2__1__Impl )
            // InternalVideoGen.g:888:2: rule__VideoGenInformation__Group_2__1__Impl
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
    // InternalVideoGen.g:894:1: rule__VideoGenInformation__Group_2__1__Impl : ( ( rule__VideoGenInformation__VersionAssignment_2_1 ) ) ;
    public final void rule__VideoGenInformation__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:898:1: ( ( ( rule__VideoGenInformation__VersionAssignment_2_1 ) ) )
            // InternalVideoGen.g:899:1: ( ( rule__VideoGenInformation__VersionAssignment_2_1 ) )
            {
            // InternalVideoGen.g:899:1: ( ( rule__VideoGenInformation__VersionAssignment_2_1 ) )
            // InternalVideoGen.g:900:1: ( rule__VideoGenInformation__VersionAssignment_2_1 )
            {
             before(grammarAccess.getVideoGenInformationAccess().getVersionAssignment_2_1()); 
            // InternalVideoGen.g:901:1: ( rule__VideoGenInformation__VersionAssignment_2_1 )
            // InternalVideoGen.g:901:2: rule__VideoGenInformation__VersionAssignment_2_1
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
    // InternalVideoGen.g:915:1: rule__VideoGenInformation__Group_3__0 : rule__VideoGenInformation__Group_3__0__Impl rule__VideoGenInformation__Group_3__1 ;
    public final void rule__VideoGenInformation__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:919:1: ( rule__VideoGenInformation__Group_3__0__Impl rule__VideoGenInformation__Group_3__1 )
            // InternalVideoGen.g:920:2: rule__VideoGenInformation__Group_3__0__Impl rule__VideoGenInformation__Group_3__1
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
    // InternalVideoGen.g:927:1: rule__VideoGenInformation__Group_3__0__Impl : ( '@creation' ) ;
    public final void rule__VideoGenInformation__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:931:1: ( ( '@creation' ) )
            // InternalVideoGen.g:932:1: ( '@creation' )
            {
            // InternalVideoGen.g:932:1: ( '@creation' )
            // InternalVideoGen.g:933:1: '@creation'
            {
             before(grammarAccess.getVideoGenInformationAccess().getCreationKeyword_3_0()); 
            match(input,20,FOLLOW_2); 
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
    // InternalVideoGen.g:946:1: rule__VideoGenInformation__Group_3__1 : rule__VideoGenInformation__Group_3__1__Impl ;
    public final void rule__VideoGenInformation__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:950:1: ( rule__VideoGenInformation__Group_3__1__Impl )
            // InternalVideoGen.g:951:2: rule__VideoGenInformation__Group_3__1__Impl
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
    // InternalVideoGen.g:957:1: rule__VideoGenInformation__Group_3__1__Impl : ( ( rule__VideoGenInformation__CreationDateAssignment_3_1 ) ) ;
    public final void rule__VideoGenInformation__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:961:1: ( ( ( rule__VideoGenInformation__CreationDateAssignment_3_1 ) ) )
            // InternalVideoGen.g:962:1: ( ( rule__VideoGenInformation__CreationDateAssignment_3_1 ) )
            {
            // InternalVideoGen.g:962:1: ( ( rule__VideoGenInformation__CreationDateAssignment_3_1 ) )
            // InternalVideoGen.g:963:1: ( rule__VideoGenInformation__CreationDateAssignment_3_1 )
            {
             before(grammarAccess.getVideoGenInformationAccess().getCreationDateAssignment_3_1()); 
            // InternalVideoGen.g:964:1: ( rule__VideoGenInformation__CreationDateAssignment_3_1 )
            // InternalVideoGen.g:964:2: rule__VideoGenInformation__CreationDateAssignment_3_1
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
    // InternalVideoGen.g:978:1: rule__MandatoryVideoSeq__Group__0 : rule__MandatoryVideoSeq__Group__0__Impl rule__MandatoryVideoSeq__Group__1 ;
    public final void rule__MandatoryVideoSeq__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:982:1: ( rule__MandatoryVideoSeq__Group__0__Impl rule__MandatoryVideoSeq__Group__1 )
            // InternalVideoGen.g:983:2: rule__MandatoryVideoSeq__Group__0__Impl rule__MandatoryVideoSeq__Group__1
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
    // InternalVideoGen.g:990:1: rule__MandatoryVideoSeq__Group__0__Impl : ( 'mandatory' ) ;
    public final void rule__MandatoryVideoSeq__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:994:1: ( ( 'mandatory' ) )
            // InternalVideoGen.g:995:1: ( 'mandatory' )
            {
            // InternalVideoGen.g:995:1: ( 'mandatory' )
            // InternalVideoGen.g:996:1: 'mandatory'
            {
             before(grammarAccess.getMandatoryVideoSeqAccess().getMandatoryKeyword_0()); 
            match(input,21,FOLLOW_2); 
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
    // InternalVideoGen.g:1009:1: rule__MandatoryVideoSeq__Group__1 : rule__MandatoryVideoSeq__Group__1__Impl ;
    public final void rule__MandatoryVideoSeq__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:1013:1: ( rule__MandatoryVideoSeq__Group__1__Impl )
            // InternalVideoGen.g:1014:2: rule__MandatoryVideoSeq__Group__1__Impl
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
    // InternalVideoGen.g:1020:1: rule__MandatoryVideoSeq__Group__1__Impl : ( ( rule__MandatoryVideoSeq__DescriptionAssignment_1 ) ) ;
    public final void rule__MandatoryVideoSeq__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:1024:1: ( ( ( rule__MandatoryVideoSeq__DescriptionAssignment_1 ) ) )
            // InternalVideoGen.g:1025:1: ( ( rule__MandatoryVideoSeq__DescriptionAssignment_1 ) )
            {
            // InternalVideoGen.g:1025:1: ( ( rule__MandatoryVideoSeq__DescriptionAssignment_1 ) )
            // InternalVideoGen.g:1026:1: ( rule__MandatoryVideoSeq__DescriptionAssignment_1 )
            {
             before(grammarAccess.getMandatoryVideoSeqAccess().getDescriptionAssignment_1()); 
            // InternalVideoGen.g:1027:1: ( rule__MandatoryVideoSeq__DescriptionAssignment_1 )
            // InternalVideoGen.g:1027:2: rule__MandatoryVideoSeq__DescriptionAssignment_1
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
    // InternalVideoGen.g:1041:1: rule__OptionalVideoSeq__Group__0 : rule__OptionalVideoSeq__Group__0__Impl rule__OptionalVideoSeq__Group__1 ;
    public final void rule__OptionalVideoSeq__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:1045:1: ( rule__OptionalVideoSeq__Group__0__Impl rule__OptionalVideoSeq__Group__1 )
            // InternalVideoGen.g:1046:2: rule__OptionalVideoSeq__Group__0__Impl rule__OptionalVideoSeq__Group__1
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
    // InternalVideoGen.g:1053:1: rule__OptionalVideoSeq__Group__0__Impl : ( 'optional' ) ;
    public final void rule__OptionalVideoSeq__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:1057:1: ( ( 'optional' ) )
            // InternalVideoGen.g:1058:1: ( 'optional' )
            {
            // InternalVideoGen.g:1058:1: ( 'optional' )
            // InternalVideoGen.g:1059:1: 'optional'
            {
             before(grammarAccess.getOptionalVideoSeqAccess().getOptionalKeyword_0()); 
            match(input,22,FOLLOW_2); 
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
    // InternalVideoGen.g:1072:1: rule__OptionalVideoSeq__Group__1 : rule__OptionalVideoSeq__Group__1__Impl ;
    public final void rule__OptionalVideoSeq__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:1076:1: ( rule__OptionalVideoSeq__Group__1__Impl )
            // InternalVideoGen.g:1077:2: rule__OptionalVideoSeq__Group__1__Impl
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
    // InternalVideoGen.g:1083:1: rule__OptionalVideoSeq__Group__1__Impl : ( ( rule__OptionalVideoSeq__DescriptionAssignment_1 ) ) ;
    public final void rule__OptionalVideoSeq__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:1087:1: ( ( ( rule__OptionalVideoSeq__DescriptionAssignment_1 ) ) )
            // InternalVideoGen.g:1088:1: ( ( rule__OptionalVideoSeq__DescriptionAssignment_1 ) )
            {
            // InternalVideoGen.g:1088:1: ( ( rule__OptionalVideoSeq__DescriptionAssignment_1 ) )
            // InternalVideoGen.g:1089:1: ( rule__OptionalVideoSeq__DescriptionAssignment_1 )
            {
             before(grammarAccess.getOptionalVideoSeqAccess().getDescriptionAssignment_1()); 
            // InternalVideoGen.g:1090:1: ( rule__OptionalVideoSeq__DescriptionAssignment_1 )
            // InternalVideoGen.g:1090:2: rule__OptionalVideoSeq__DescriptionAssignment_1
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
    // InternalVideoGen.g:1104:1: rule__AlternativeVideoSeq__Group__0 : rule__AlternativeVideoSeq__Group__0__Impl rule__AlternativeVideoSeq__Group__1 ;
    public final void rule__AlternativeVideoSeq__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:1108:1: ( rule__AlternativeVideoSeq__Group__0__Impl rule__AlternativeVideoSeq__Group__1 )
            // InternalVideoGen.g:1109:2: rule__AlternativeVideoSeq__Group__0__Impl rule__AlternativeVideoSeq__Group__1
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
    // InternalVideoGen.g:1116:1: rule__AlternativeVideoSeq__Group__0__Impl : ( 'alternatives' ) ;
    public final void rule__AlternativeVideoSeq__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:1120:1: ( ( 'alternatives' ) )
            // InternalVideoGen.g:1121:1: ( 'alternatives' )
            {
            // InternalVideoGen.g:1121:1: ( 'alternatives' )
            // InternalVideoGen.g:1122:1: 'alternatives'
            {
             before(grammarAccess.getAlternativeVideoSeqAccess().getAlternativesKeyword_0()); 
            match(input,23,FOLLOW_2); 
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
    // InternalVideoGen.g:1135:1: rule__AlternativeVideoSeq__Group__1 : rule__AlternativeVideoSeq__Group__1__Impl rule__AlternativeVideoSeq__Group__2 ;
    public final void rule__AlternativeVideoSeq__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:1139:1: ( rule__AlternativeVideoSeq__Group__1__Impl rule__AlternativeVideoSeq__Group__2 )
            // InternalVideoGen.g:1140:2: rule__AlternativeVideoSeq__Group__1__Impl rule__AlternativeVideoSeq__Group__2
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
    // InternalVideoGen.g:1147:1: rule__AlternativeVideoSeq__Group__1__Impl : ( ( rule__AlternativeVideoSeq__VideoidAssignment_1 )? ) ;
    public final void rule__AlternativeVideoSeq__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:1151:1: ( ( ( rule__AlternativeVideoSeq__VideoidAssignment_1 )? ) )
            // InternalVideoGen.g:1152:1: ( ( rule__AlternativeVideoSeq__VideoidAssignment_1 )? )
            {
            // InternalVideoGen.g:1152:1: ( ( rule__AlternativeVideoSeq__VideoidAssignment_1 )? )
            // InternalVideoGen.g:1153:1: ( rule__AlternativeVideoSeq__VideoidAssignment_1 )?
            {
             before(grammarAccess.getAlternativeVideoSeqAccess().getVideoidAssignment_1()); 
            // InternalVideoGen.g:1154:1: ( rule__AlternativeVideoSeq__VideoidAssignment_1 )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==RULE_ID) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // InternalVideoGen.g:1154:2: rule__AlternativeVideoSeq__VideoidAssignment_1
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
    // InternalVideoGen.g:1164:1: rule__AlternativeVideoSeq__Group__2 : rule__AlternativeVideoSeq__Group__2__Impl rule__AlternativeVideoSeq__Group__3 ;
    public final void rule__AlternativeVideoSeq__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:1168:1: ( rule__AlternativeVideoSeq__Group__2__Impl rule__AlternativeVideoSeq__Group__3 )
            // InternalVideoGen.g:1169:2: rule__AlternativeVideoSeq__Group__2__Impl rule__AlternativeVideoSeq__Group__3
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
    // InternalVideoGen.g:1176:1: rule__AlternativeVideoSeq__Group__2__Impl : ( RULE_LEFT_BRACKET ) ;
    public final void rule__AlternativeVideoSeq__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:1180:1: ( ( RULE_LEFT_BRACKET ) )
            // InternalVideoGen.g:1181:1: ( RULE_LEFT_BRACKET )
            {
            // InternalVideoGen.g:1181:1: ( RULE_LEFT_BRACKET )
            // InternalVideoGen.g:1182:1: RULE_LEFT_BRACKET
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
    // InternalVideoGen.g:1193:1: rule__AlternativeVideoSeq__Group__3 : rule__AlternativeVideoSeq__Group__3__Impl rule__AlternativeVideoSeq__Group__4 ;
    public final void rule__AlternativeVideoSeq__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:1197:1: ( rule__AlternativeVideoSeq__Group__3__Impl rule__AlternativeVideoSeq__Group__4 )
            // InternalVideoGen.g:1198:2: rule__AlternativeVideoSeq__Group__3__Impl rule__AlternativeVideoSeq__Group__4
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
    // InternalVideoGen.g:1205:1: rule__AlternativeVideoSeq__Group__3__Impl : ( ( ( rule__AlternativeVideoSeq__VideodescsAssignment_3 ) ) ( ( rule__AlternativeVideoSeq__VideodescsAssignment_3 )* ) ) ;
    public final void rule__AlternativeVideoSeq__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:1209:1: ( ( ( ( rule__AlternativeVideoSeq__VideodescsAssignment_3 ) ) ( ( rule__AlternativeVideoSeq__VideodescsAssignment_3 )* ) ) )
            // InternalVideoGen.g:1210:1: ( ( ( rule__AlternativeVideoSeq__VideodescsAssignment_3 ) ) ( ( rule__AlternativeVideoSeq__VideodescsAssignment_3 )* ) )
            {
            // InternalVideoGen.g:1210:1: ( ( ( rule__AlternativeVideoSeq__VideodescsAssignment_3 ) ) ( ( rule__AlternativeVideoSeq__VideodescsAssignment_3 )* ) )
            // InternalVideoGen.g:1211:1: ( ( rule__AlternativeVideoSeq__VideodescsAssignment_3 ) ) ( ( rule__AlternativeVideoSeq__VideodescsAssignment_3 )* )
            {
            // InternalVideoGen.g:1211:1: ( ( rule__AlternativeVideoSeq__VideodescsAssignment_3 ) )
            // InternalVideoGen.g:1212:1: ( rule__AlternativeVideoSeq__VideodescsAssignment_3 )
            {
             before(grammarAccess.getAlternativeVideoSeqAccess().getVideodescsAssignment_3()); 
            // InternalVideoGen.g:1213:1: ( rule__AlternativeVideoSeq__VideodescsAssignment_3 )
            // InternalVideoGen.g:1213:2: rule__AlternativeVideoSeq__VideodescsAssignment_3
            {
            pushFollow(FOLLOW_13);
            rule__AlternativeVideoSeq__VideodescsAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getAlternativeVideoSeqAccess().getVideodescsAssignment_3()); 

            }

            // InternalVideoGen.g:1216:1: ( ( rule__AlternativeVideoSeq__VideodescsAssignment_3 )* )
            // InternalVideoGen.g:1217:1: ( rule__AlternativeVideoSeq__VideodescsAssignment_3 )*
            {
             before(grammarAccess.getAlternativeVideoSeqAccess().getVideodescsAssignment_3()); 
            // InternalVideoGen.g:1218:1: ( rule__AlternativeVideoSeq__VideodescsAssignment_3 )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==24) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // InternalVideoGen.g:1218:2: rule__AlternativeVideoSeq__VideodescsAssignment_3
            	    {
            	    pushFollow(FOLLOW_13);
            	    rule__AlternativeVideoSeq__VideodescsAssignment_3();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop9;
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
    // InternalVideoGen.g:1229:1: rule__AlternativeVideoSeq__Group__4 : rule__AlternativeVideoSeq__Group__4__Impl ;
    public final void rule__AlternativeVideoSeq__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:1233:1: ( rule__AlternativeVideoSeq__Group__4__Impl )
            // InternalVideoGen.g:1234:2: rule__AlternativeVideoSeq__Group__4__Impl
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
    // InternalVideoGen.g:1240:1: rule__AlternativeVideoSeq__Group__4__Impl : ( RULE_RIGHT_BRACKET ) ;
    public final void rule__AlternativeVideoSeq__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:1244:1: ( ( RULE_RIGHT_BRACKET ) )
            // InternalVideoGen.g:1245:1: ( RULE_RIGHT_BRACKET )
            {
            // InternalVideoGen.g:1245:1: ( RULE_RIGHT_BRACKET )
            // InternalVideoGen.g:1246:1: RULE_RIGHT_BRACKET
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
    // InternalVideoGen.g:1267:1: rule__VideoDescription__Group__0 : rule__VideoDescription__Group__0__Impl rule__VideoDescription__Group__1 ;
    public final void rule__VideoDescription__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:1271:1: ( rule__VideoDescription__Group__0__Impl rule__VideoDescription__Group__1 )
            // InternalVideoGen.g:1272:2: rule__VideoDescription__Group__0__Impl rule__VideoDescription__Group__1
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
    // InternalVideoGen.g:1279:1: rule__VideoDescription__Group__0__Impl : ( 'videoseq' ) ;
    public final void rule__VideoDescription__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:1283:1: ( ( 'videoseq' ) )
            // InternalVideoGen.g:1284:1: ( 'videoseq' )
            {
            // InternalVideoGen.g:1284:1: ( 'videoseq' )
            // InternalVideoGen.g:1285:1: 'videoseq'
            {
             before(grammarAccess.getVideoDescriptionAccess().getVideoseqKeyword_0()); 
            match(input,24,FOLLOW_2); 
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
    // InternalVideoGen.g:1298:1: rule__VideoDescription__Group__1 : rule__VideoDescription__Group__1__Impl rule__VideoDescription__Group__2 ;
    public final void rule__VideoDescription__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:1302:1: ( rule__VideoDescription__Group__1__Impl rule__VideoDescription__Group__2 )
            // InternalVideoGen.g:1303:2: rule__VideoDescription__Group__1__Impl rule__VideoDescription__Group__2
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
    // InternalVideoGen.g:1310:1: rule__VideoDescription__Group__1__Impl : ( ( rule__VideoDescription__VideoidAssignment_1 )? ) ;
    public final void rule__VideoDescription__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:1314:1: ( ( ( rule__VideoDescription__VideoidAssignment_1 )? ) )
            // InternalVideoGen.g:1315:1: ( ( rule__VideoDescription__VideoidAssignment_1 )? )
            {
            // InternalVideoGen.g:1315:1: ( ( rule__VideoDescription__VideoidAssignment_1 )? )
            // InternalVideoGen.g:1316:1: ( rule__VideoDescription__VideoidAssignment_1 )?
            {
             before(grammarAccess.getVideoDescriptionAccess().getVideoidAssignment_1()); 
            // InternalVideoGen.g:1317:1: ( rule__VideoDescription__VideoidAssignment_1 )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==RULE_ID) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // InternalVideoGen.g:1317:2: rule__VideoDescription__VideoidAssignment_1
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
    // InternalVideoGen.g:1327:1: rule__VideoDescription__Group__2 : rule__VideoDescription__Group__2__Impl rule__VideoDescription__Group__3 ;
    public final void rule__VideoDescription__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:1331:1: ( rule__VideoDescription__Group__2__Impl rule__VideoDescription__Group__3 )
            // InternalVideoGen.g:1332:2: rule__VideoDescription__Group__2__Impl rule__VideoDescription__Group__3
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
    // InternalVideoGen.g:1339:1: rule__VideoDescription__Group__2__Impl : ( ( rule__VideoDescription__LocationAssignment_2 ) ) ;
    public final void rule__VideoDescription__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:1343:1: ( ( ( rule__VideoDescription__LocationAssignment_2 ) ) )
            // InternalVideoGen.g:1344:1: ( ( rule__VideoDescription__LocationAssignment_2 ) )
            {
            // InternalVideoGen.g:1344:1: ( ( rule__VideoDescription__LocationAssignment_2 ) )
            // InternalVideoGen.g:1345:1: ( rule__VideoDescription__LocationAssignment_2 )
            {
             before(grammarAccess.getVideoDescriptionAccess().getLocationAssignment_2()); 
            // InternalVideoGen.g:1346:1: ( rule__VideoDescription__LocationAssignment_2 )
            // InternalVideoGen.g:1346:2: rule__VideoDescription__LocationAssignment_2
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
    // InternalVideoGen.g:1356:1: rule__VideoDescription__Group__3 : rule__VideoDescription__Group__3__Impl ;
    public final void rule__VideoDescription__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:1360:1: ( rule__VideoDescription__Group__3__Impl )
            // InternalVideoGen.g:1361:2: rule__VideoDescription__Group__3__Impl
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
    // InternalVideoGen.g:1367:1: rule__VideoDescription__Group__3__Impl : ( ( rule__VideoDescription__Group_3__0 )? ) ;
    public final void rule__VideoDescription__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:1371:1: ( ( ( rule__VideoDescription__Group_3__0 )? ) )
            // InternalVideoGen.g:1372:1: ( ( rule__VideoDescription__Group_3__0 )? )
            {
            // InternalVideoGen.g:1372:1: ( ( rule__VideoDescription__Group_3__0 )? )
            // InternalVideoGen.g:1373:1: ( rule__VideoDescription__Group_3__0 )?
            {
             before(grammarAccess.getVideoDescriptionAccess().getGroup_3()); 
            // InternalVideoGen.g:1374:1: ( rule__VideoDescription__Group_3__0 )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==RULE_LEFT_BRACKET) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // InternalVideoGen.g:1374:2: rule__VideoDescription__Group_3__0
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
    // InternalVideoGen.g:1392:1: rule__VideoDescription__Group_3__0 : rule__VideoDescription__Group_3__0__Impl rule__VideoDescription__Group_3__1 ;
    public final void rule__VideoDescription__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:1396:1: ( rule__VideoDescription__Group_3__0__Impl rule__VideoDescription__Group_3__1 )
            // InternalVideoGen.g:1397:2: rule__VideoDescription__Group_3__0__Impl rule__VideoDescription__Group_3__1
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
    // InternalVideoGen.g:1404:1: rule__VideoDescription__Group_3__0__Impl : ( RULE_LEFT_BRACKET ) ;
    public final void rule__VideoDescription__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:1408:1: ( ( RULE_LEFT_BRACKET ) )
            // InternalVideoGen.g:1409:1: ( RULE_LEFT_BRACKET )
            {
            // InternalVideoGen.g:1409:1: ( RULE_LEFT_BRACKET )
            // InternalVideoGen.g:1410:1: RULE_LEFT_BRACKET
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
    // InternalVideoGen.g:1421:1: rule__VideoDescription__Group_3__1 : rule__VideoDescription__Group_3__1__Impl rule__VideoDescription__Group_3__2 ;
    public final void rule__VideoDescription__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:1425:1: ( rule__VideoDescription__Group_3__1__Impl rule__VideoDescription__Group_3__2 )
            // InternalVideoGen.g:1426:2: rule__VideoDescription__Group_3__1__Impl rule__VideoDescription__Group_3__2
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
    // InternalVideoGen.g:1433:1: rule__VideoDescription__Group_3__1__Impl : ( ( rule__VideoDescription__Group_3_1__0 )? ) ;
    public final void rule__VideoDescription__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:1437:1: ( ( ( rule__VideoDescription__Group_3_1__0 )? ) )
            // InternalVideoGen.g:1438:1: ( ( rule__VideoDescription__Group_3_1__0 )? )
            {
            // InternalVideoGen.g:1438:1: ( ( rule__VideoDescription__Group_3_1__0 )? )
            // InternalVideoGen.g:1439:1: ( rule__VideoDescription__Group_3_1__0 )?
            {
             before(grammarAccess.getVideoDescriptionAccess().getGroup_3_1()); 
            // InternalVideoGen.g:1440:1: ( rule__VideoDescription__Group_3_1__0 )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==25) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // InternalVideoGen.g:1440:2: rule__VideoDescription__Group_3_1__0
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
    // InternalVideoGen.g:1450:1: rule__VideoDescription__Group_3__2 : rule__VideoDescription__Group_3__2__Impl rule__VideoDescription__Group_3__3 ;
    public final void rule__VideoDescription__Group_3__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:1454:1: ( rule__VideoDescription__Group_3__2__Impl rule__VideoDescription__Group_3__3 )
            // InternalVideoGen.g:1455:2: rule__VideoDescription__Group_3__2__Impl rule__VideoDescription__Group_3__3
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
    // InternalVideoGen.g:1462:1: rule__VideoDescription__Group_3__2__Impl : ( ( rule__VideoDescription__Group_3_2__0 )? ) ;
    public final void rule__VideoDescription__Group_3__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:1466:1: ( ( ( rule__VideoDescription__Group_3_2__0 )? ) )
            // InternalVideoGen.g:1467:1: ( ( rule__VideoDescription__Group_3_2__0 )? )
            {
            // InternalVideoGen.g:1467:1: ( ( rule__VideoDescription__Group_3_2__0 )? )
            // InternalVideoGen.g:1468:1: ( rule__VideoDescription__Group_3_2__0 )?
            {
             before(grammarAccess.getVideoDescriptionAccess().getGroup_3_2()); 
            // InternalVideoGen.g:1469:1: ( rule__VideoDescription__Group_3_2__0 )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==26) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // InternalVideoGen.g:1469:2: rule__VideoDescription__Group_3_2__0
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
    // InternalVideoGen.g:1479:1: rule__VideoDescription__Group_3__3 : rule__VideoDescription__Group_3__3__Impl rule__VideoDescription__Group_3__4 ;
    public final void rule__VideoDescription__Group_3__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:1483:1: ( rule__VideoDescription__Group_3__3__Impl rule__VideoDescription__Group_3__4 )
            // InternalVideoGen.g:1484:2: rule__VideoDescription__Group_3__3__Impl rule__VideoDescription__Group_3__4
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
    // InternalVideoGen.g:1491:1: rule__VideoDescription__Group_3__3__Impl : ( ( rule__VideoDescription__Group_3_3__0 )? ) ;
    public final void rule__VideoDescription__Group_3__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:1495:1: ( ( ( rule__VideoDescription__Group_3_3__0 )? ) )
            // InternalVideoGen.g:1496:1: ( ( rule__VideoDescription__Group_3_3__0 )? )
            {
            // InternalVideoGen.g:1496:1: ( ( rule__VideoDescription__Group_3_3__0 )? )
            // InternalVideoGen.g:1497:1: ( rule__VideoDescription__Group_3_3__0 )?
            {
             before(grammarAccess.getVideoDescriptionAccess().getGroup_3_3()); 
            // InternalVideoGen.g:1498:1: ( rule__VideoDescription__Group_3_3__0 )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==27) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // InternalVideoGen.g:1498:2: rule__VideoDescription__Group_3_3__0
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
    // InternalVideoGen.g:1508:1: rule__VideoDescription__Group_3__4 : rule__VideoDescription__Group_3__4__Impl rule__VideoDescription__Group_3__5 ;
    public final void rule__VideoDescription__Group_3__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:1512:1: ( rule__VideoDescription__Group_3__4__Impl rule__VideoDescription__Group_3__5 )
            // InternalVideoGen.g:1513:2: rule__VideoDescription__Group_3__4__Impl rule__VideoDescription__Group_3__5
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
    // InternalVideoGen.g:1520:1: rule__VideoDescription__Group_3__4__Impl : ( ( rule__VideoDescription__Group_3_4__0 )? ) ;
    public final void rule__VideoDescription__Group_3__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:1524:1: ( ( ( rule__VideoDescription__Group_3_4__0 )? ) )
            // InternalVideoGen.g:1525:1: ( ( rule__VideoDescription__Group_3_4__0 )? )
            {
            // InternalVideoGen.g:1525:1: ( ( rule__VideoDescription__Group_3_4__0 )? )
            // InternalVideoGen.g:1526:1: ( rule__VideoDescription__Group_3_4__0 )?
            {
             before(grammarAccess.getVideoDescriptionAccess().getGroup_3_4()); 
            // InternalVideoGen.g:1527:1: ( rule__VideoDescription__Group_3_4__0 )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==28) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // InternalVideoGen.g:1527:2: rule__VideoDescription__Group_3_4__0
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
    // InternalVideoGen.g:1537:1: rule__VideoDescription__Group_3__5 : rule__VideoDescription__Group_3__5__Impl rule__VideoDescription__Group_3__6 ;
    public final void rule__VideoDescription__Group_3__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:1541:1: ( rule__VideoDescription__Group_3__5__Impl rule__VideoDescription__Group_3__6 )
            // InternalVideoGen.g:1542:2: rule__VideoDescription__Group_3__5__Impl rule__VideoDescription__Group_3__6
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
    // InternalVideoGen.g:1549:1: rule__VideoDescription__Group_3__5__Impl : ( ( rule__VideoDescription__Group_3_5__0 )? ) ;
    public final void rule__VideoDescription__Group_3__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:1553:1: ( ( ( rule__VideoDescription__Group_3_5__0 )? ) )
            // InternalVideoGen.g:1554:1: ( ( rule__VideoDescription__Group_3_5__0 )? )
            {
            // InternalVideoGen.g:1554:1: ( ( rule__VideoDescription__Group_3_5__0 )? )
            // InternalVideoGen.g:1555:1: ( rule__VideoDescription__Group_3_5__0 )?
            {
             before(grammarAccess.getVideoDescriptionAccess().getGroup_3_5()); 
            // InternalVideoGen.g:1556:1: ( rule__VideoDescription__Group_3_5__0 )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==29) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // InternalVideoGen.g:1556:2: rule__VideoDescription__Group_3_5__0
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
    // InternalVideoGen.g:1566:1: rule__VideoDescription__Group_3__6 : rule__VideoDescription__Group_3__6__Impl ;
    public final void rule__VideoDescription__Group_3__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:1570:1: ( rule__VideoDescription__Group_3__6__Impl )
            // InternalVideoGen.g:1571:2: rule__VideoDescription__Group_3__6__Impl
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
    // InternalVideoGen.g:1577:1: rule__VideoDescription__Group_3__6__Impl : ( RULE_RIGHT_BRACKET ) ;
    public final void rule__VideoDescription__Group_3__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:1581:1: ( ( RULE_RIGHT_BRACKET ) )
            // InternalVideoGen.g:1582:1: ( RULE_RIGHT_BRACKET )
            {
            // InternalVideoGen.g:1582:1: ( RULE_RIGHT_BRACKET )
            // InternalVideoGen.g:1583:1: RULE_RIGHT_BRACKET
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
    // InternalVideoGen.g:1608:1: rule__VideoDescription__Group_3_1__0 : rule__VideoDescription__Group_3_1__0__Impl rule__VideoDescription__Group_3_1__1 ;
    public final void rule__VideoDescription__Group_3_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:1612:1: ( rule__VideoDescription__Group_3_1__0__Impl rule__VideoDescription__Group_3_1__1 )
            // InternalVideoGen.g:1613:2: rule__VideoDescription__Group_3_1__0__Impl rule__VideoDescription__Group_3_1__1
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
    // InternalVideoGen.g:1620:1: rule__VideoDescription__Group_3_1__0__Impl : ( 'duration' ) ;
    public final void rule__VideoDescription__Group_3_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:1624:1: ( ( 'duration' ) )
            // InternalVideoGen.g:1625:1: ( 'duration' )
            {
            // InternalVideoGen.g:1625:1: ( 'duration' )
            // InternalVideoGen.g:1626:1: 'duration'
            {
             before(grammarAccess.getVideoDescriptionAccess().getDurationKeyword_3_1_0()); 
            match(input,25,FOLLOW_2); 
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
    // InternalVideoGen.g:1639:1: rule__VideoDescription__Group_3_1__1 : rule__VideoDescription__Group_3_1__1__Impl ;
    public final void rule__VideoDescription__Group_3_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:1643:1: ( rule__VideoDescription__Group_3_1__1__Impl )
            // InternalVideoGen.g:1644:2: rule__VideoDescription__Group_3_1__1__Impl
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
    // InternalVideoGen.g:1650:1: rule__VideoDescription__Group_3_1__1__Impl : ( ( rule__VideoDescription__DurationAssignment_3_1_1 ) ) ;
    public final void rule__VideoDescription__Group_3_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:1654:1: ( ( ( rule__VideoDescription__DurationAssignment_3_1_1 ) ) )
            // InternalVideoGen.g:1655:1: ( ( rule__VideoDescription__DurationAssignment_3_1_1 ) )
            {
            // InternalVideoGen.g:1655:1: ( ( rule__VideoDescription__DurationAssignment_3_1_1 ) )
            // InternalVideoGen.g:1656:1: ( rule__VideoDescription__DurationAssignment_3_1_1 )
            {
             before(grammarAccess.getVideoDescriptionAccess().getDurationAssignment_3_1_1()); 
            // InternalVideoGen.g:1657:1: ( rule__VideoDescription__DurationAssignment_3_1_1 )
            // InternalVideoGen.g:1657:2: rule__VideoDescription__DurationAssignment_3_1_1
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
    // InternalVideoGen.g:1671:1: rule__VideoDescription__Group_3_2__0 : rule__VideoDescription__Group_3_2__0__Impl rule__VideoDescription__Group_3_2__1 ;
    public final void rule__VideoDescription__Group_3_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:1675:1: ( rule__VideoDescription__Group_3_2__0__Impl rule__VideoDescription__Group_3_2__1 )
            // InternalVideoGen.g:1676:2: rule__VideoDescription__Group_3_2__0__Impl rule__VideoDescription__Group_3_2__1
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
    // InternalVideoGen.g:1683:1: rule__VideoDescription__Group_3_2__0__Impl : ( 'probability' ) ;
    public final void rule__VideoDescription__Group_3_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:1687:1: ( ( 'probability' ) )
            // InternalVideoGen.g:1688:1: ( 'probability' )
            {
            // InternalVideoGen.g:1688:1: ( 'probability' )
            // InternalVideoGen.g:1689:1: 'probability'
            {
             before(grammarAccess.getVideoDescriptionAccess().getProbabilityKeyword_3_2_0()); 
            match(input,26,FOLLOW_2); 
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
    // InternalVideoGen.g:1702:1: rule__VideoDescription__Group_3_2__1 : rule__VideoDescription__Group_3_2__1__Impl ;
    public final void rule__VideoDescription__Group_3_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:1706:1: ( rule__VideoDescription__Group_3_2__1__Impl )
            // InternalVideoGen.g:1707:2: rule__VideoDescription__Group_3_2__1__Impl
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
    // InternalVideoGen.g:1713:1: rule__VideoDescription__Group_3_2__1__Impl : ( ( rule__VideoDescription__ProbabilityAssignment_3_2_1 ) ) ;
    public final void rule__VideoDescription__Group_3_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:1717:1: ( ( ( rule__VideoDescription__ProbabilityAssignment_3_2_1 ) ) )
            // InternalVideoGen.g:1718:1: ( ( rule__VideoDescription__ProbabilityAssignment_3_2_1 ) )
            {
            // InternalVideoGen.g:1718:1: ( ( rule__VideoDescription__ProbabilityAssignment_3_2_1 ) )
            // InternalVideoGen.g:1719:1: ( rule__VideoDescription__ProbabilityAssignment_3_2_1 )
            {
             before(grammarAccess.getVideoDescriptionAccess().getProbabilityAssignment_3_2_1()); 
            // InternalVideoGen.g:1720:1: ( rule__VideoDescription__ProbabilityAssignment_3_2_1 )
            // InternalVideoGen.g:1720:2: rule__VideoDescription__ProbabilityAssignment_3_2_1
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
    // InternalVideoGen.g:1734:1: rule__VideoDescription__Group_3_3__0 : rule__VideoDescription__Group_3_3__0__Impl rule__VideoDescription__Group_3_3__1 ;
    public final void rule__VideoDescription__Group_3_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:1738:1: ( rule__VideoDescription__Group_3_3__0__Impl rule__VideoDescription__Group_3_3__1 )
            // InternalVideoGen.g:1739:2: rule__VideoDescription__Group_3_3__0__Impl rule__VideoDescription__Group_3_3__1
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
    // InternalVideoGen.g:1746:1: rule__VideoDescription__Group_3_3__0__Impl : ( 'size' ) ;
    public final void rule__VideoDescription__Group_3_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:1750:1: ( ( 'size' ) )
            // InternalVideoGen.g:1751:1: ( 'size' )
            {
            // InternalVideoGen.g:1751:1: ( 'size' )
            // InternalVideoGen.g:1752:1: 'size'
            {
             before(grammarAccess.getVideoDescriptionAccess().getSizeKeyword_3_3_0()); 
            match(input,27,FOLLOW_2); 
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
    // InternalVideoGen.g:1765:1: rule__VideoDescription__Group_3_3__1 : rule__VideoDescription__Group_3_3__1__Impl ;
    public final void rule__VideoDescription__Group_3_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:1769:1: ( rule__VideoDescription__Group_3_3__1__Impl )
            // InternalVideoGen.g:1770:2: rule__VideoDescription__Group_3_3__1__Impl
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
    // InternalVideoGen.g:1776:1: rule__VideoDescription__Group_3_3__1__Impl : ( ( rule__VideoDescription__SizeAssignment_3_3_1 ) ) ;
    public final void rule__VideoDescription__Group_3_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:1780:1: ( ( ( rule__VideoDescription__SizeAssignment_3_3_1 ) ) )
            // InternalVideoGen.g:1781:1: ( ( rule__VideoDescription__SizeAssignment_3_3_1 ) )
            {
            // InternalVideoGen.g:1781:1: ( ( rule__VideoDescription__SizeAssignment_3_3_1 ) )
            // InternalVideoGen.g:1782:1: ( rule__VideoDescription__SizeAssignment_3_3_1 )
            {
             before(grammarAccess.getVideoDescriptionAccess().getSizeAssignment_3_3_1()); 
            // InternalVideoGen.g:1783:1: ( rule__VideoDescription__SizeAssignment_3_3_1 )
            // InternalVideoGen.g:1783:2: rule__VideoDescription__SizeAssignment_3_3_1
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
    // InternalVideoGen.g:1797:1: rule__VideoDescription__Group_3_4__0 : rule__VideoDescription__Group_3_4__0__Impl rule__VideoDescription__Group_3_4__1 ;
    public final void rule__VideoDescription__Group_3_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:1801:1: ( rule__VideoDescription__Group_3_4__0__Impl rule__VideoDescription__Group_3_4__1 )
            // InternalVideoGen.g:1802:2: rule__VideoDescription__Group_3_4__0__Impl rule__VideoDescription__Group_3_4__1
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
    // InternalVideoGen.g:1809:1: rule__VideoDescription__Group_3_4__0__Impl : ( 'description' ) ;
    public final void rule__VideoDescription__Group_3_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:1813:1: ( ( 'description' ) )
            // InternalVideoGen.g:1814:1: ( 'description' )
            {
            // InternalVideoGen.g:1814:1: ( 'description' )
            // InternalVideoGen.g:1815:1: 'description'
            {
             before(grammarAccess.getVideoDescriptionAccess().getDescriptionKeyword_3_4_0()); 
            match(input,28,FOLLOW_2); 
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
    // InternalVideoGen.g:1828:1: rule__VideoDescription__Group_3_4__1 : rule__VideoDescription__Group_3_4__1__Impl ;
    public final void rule__VideoDescription__Group_3_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:1832:1: ( rule__VideoDescription__Group_3_4__1__Impl )
            // InternalVideoGen.g:1833:2: rule__VideoDescription__Group_3_4__1__Impl
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
    // InternalVideoGen.g:1839:1: rule__VideoDescription__Group_3_4__1__Impl : ( ( rule__VideoDescription__DescriptionAssignment_3_4_1 ) ) ;
    public final void rule__VideoDescription__Group_3_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:1843:1: ( ( ( rule__VideoDescription__DescriptionAssignment_3_4_1 ) ) )
            // InternalVideoGen.g:1844:1: ( ( rule__VideoDescription__DescriptionAssignment_3_4_1 ) )
            {
            // InternalVideoGen.g:1844:1: ( ( rule__VideoDescription__DescriptionAssignment_3_4_1 ) )
            // InternalVideoGen.g:1845:1: ( rule__VideoDescription__DescriptionAssignment_3_4_1 )
            {
             before(grammarAccess.getVideoDescriptionAccess().getDescriptionAssignment_3_4_1()); 
            // InternalVideoGen.g:1846:1: ( rule__VideoDescription__DescriptionAssignment_3_4_1 )
            // InternalVideoGen.g:1846:2: rule__VideoDescription__DescriptionAssignment_3_4_1
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
    // InternalVideoGen.g:1860:1: rule__VideoDescription__Group_3_5__0 : rule__VideoDescription__Group_3_5__0__Impl rule__VideoDescription__Group_3_5__1 ;
    public final void rule__VideoDescription__Group_3_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:1864:1: ( rule__VideoDescription__Group_3_5__0__Impl rule__VideoDescription__Group_3_5__1 )
            // InternalVideoGen.g:1865:2: rule__VideoDescription__Group_3_5__0__Impl rule__VideoDescription__Group_3_5__1
            {
            pushFollow(FOLLOW_17);
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
    // InternalVideoGen.g:1872:1: rule__VideoDescription__Group_3_5__0__Impl : ( 'filter' ) ;
    public final void rule__VideoDescription__Group_3_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:1876:1: ( ( 'filter' ) )
            // InternalVideoGen.g:1877:1: ( 'filter' )
            {
            // InternalVideoGen.g:1877:1: ( 'filter' )
            // InternalVideoGen.g:1878:1: 'filter'
            {
             before(grammarAccess.getVideoDescriptionAccess().getFilterKeyword_3_5_0()); 
            match(input,29,FOLLOW_2); 
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
    // InternalVideoGen.g:1891:1: rule__VideoDescription__Group_3_5__1 : rule__VideoDescription__Group_3_5__1__Impl ;
    public final void rule__VideoDescription__Group_3_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:1895:1: ( rule__VideoDescription__Group_3_5__1__Impl )
            // InternalVideoGen.g:1896:2: rule__VideoDescription__Group_3_5__1__Impl
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
    // InternalVideoGen.g:1902:1: rule__VideoDescription__Group_3_5__1__Impl : ( ( rule__VideoDescription__FilterAssignment_3_5_1 ) ) ;
    public final void rule__VideoDescription__Group_3_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:1906:1: ( ( ( rule__VideoDescription__FilterAssignment_3_5_1 ) ) )
            // InternalVideoGen.g:1907:1: ( ( rule__VideoDescription__FilterAssignment_3_5_1 ) )
            {
            // InternalVideoGen.g:1907:1: ( ( rule__VideoDescription__FilterAssignment_3_5_1 ) )
            // InternalVideoGen.g:1908:1: ( rule__VideoDescription__FilterAssignment_3_5_1 )
            {
             before(grammarAccess.getVideoDescriptionAccess().getFilterAssignment_3_5_1()); 
            // InternalVideoGen.g:1909:1: ( rule__VideoDescription__FilterAssignment_3_5_1 )
            // InternalVideoGen.g:1909:2: rule__VideoDescription__FilterAssignment_3_5_1
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


    // $ANTLR start "rule__BlackWhiteFilter__Group__0"
    // InternalVideoGen.g:1923:1: rule__BlackWhiteFilter__Group__0 : rule__BlackWhiteFilter__Group__0__Impl rule__BlackWhiteFilter__Group__1 ;
    public final void rule__BlackWhiteFilter__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:1927:1: ( rule__BlackWhiteFilter__Group__0__Impl rule__BlackWhiteFilter__Group__1 )
            // InternalVideoGen.g:1928:2: rule__BlackWhiteFilter__Group__0__Impl rule__BlackWhiteFilter__Group__1
            {
            pushFollow(FOLLOW_17);
            rule__BlackWhiteFilter__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__BlackWhiteFilter__Group__1();

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
    // $ANTLR end "rule__BlackWhiteFilter__Group__0"


    // $ANTLR start "rule__BlackWhiteFilter__Group__0__Impl"
    // InternalVideoGen.g:1935:1: rule__BlackWhiteFilter__Group__0__Impl : ( () ) ;
    public final void rule__BlackWhiteFilter__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:1939:1: ( ( () ) )
            // InternalVideoGen.g:1940:1: ( () )
            {
            // InternalVideoGen.g:1940:1: ( () )
            // InternalVideoGen.g:1941:1: ()
            {
             before(grammarAccess.getBlackWhiteFilterAccess().getBlackWhiteFilterAction_0()); 
            // InternalVideoGen.g:1942:1: ()
            // InternalVideoGen.g:1944:1: 
            {
            }

             after(grammarAccess.getBlackWhiteFilterAccess().getBlackWhiteFilterAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BlackWhiteFilter__Group__0__Impl"


    // $ANTLR start "rule__BlackWhiteFilter__Group__1"
    // InternalVideoGen.g:1954:1: rule__BlackWhiteFilter__Group__1 : rule__BlackWhiteFilter__Group__1__Impl ;
    public final void rule__BlackWhiteFilter__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:1958:1: ( rule__BlackWhiteFilter__Group__1__Impl )
            // InternalVideoGen.g:1959:2: rule__BlackWhiteFilter__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__BlackWhiteFilter__Group__1__Impl();

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
    // $ANTLR end "rule__BlackWhiteFilter__Group__1"


    // $ANTLR start "rule__BlackWhiteFilter__Group__1__Impl"
    // InternalVideoGen.g:1965:1: rule__BlackWhiteFilter__Group__1__Impl : ( 'b&w' ) ;
    public final void rule__BlackWhiteFilter__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:1969:1: ( ( 'b&w' ) )
            // InternalVideoGen.g:1970:1: ( 'b&w' )
            {
            // InternalVideoGen.g:1970:1: ( 'b&w' )
            // InternalVideoGen.g:1971:1: 'b&w'
            {
             before(grammarAccess.getBlackWhiteFilterAccess().getBWKeyword_1()); 
            match(input,30,FOLLOW_2); 
             after(grammarAccess.getBlackWhiteFilterAccess().getBWKeyword_1()); 

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
    // $ANTLR end "rule__BlackWhiteFilter__Group__1__Impl"


    // $ANTLR start "rule__NegateFilter__Group__0"
    // InternalVideoGen.g:1988:1: rule__NegateFilter__Group__0 : rule__NegateFilter__Group__0__Impl rule__NegateFilter__Group__1 ;
    public final void rule__NegateFilter__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:1992:1: ( rule__NegateFilter__Group__0__Impl rule__NegateFilter__Group__1 )
            // InternalVideoGen.g:1993:2: rule__NegateFilter__Group__0__Impl rule__NegateFilter__Group__1
            {
            pushFollow(FOLLOW_18);
            rule__NegateFilter__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__NegateFilter__Group__1();

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
    // $ANTLR end "rule__NegateFilter__Group__0"


    // $ANTLR start "rule__NegateFilter__Group__0__Impl"
    // InternalVideoGen.g:2000:1: rule__NegateFilter__Group__0__Impl : ( () ) ;
    public final void rule__NegateFilter__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:2004:1: ( ( () ) )
            // InternalVideoGen.g:2005:1: ( () )
            {
            // InternalVideoGen.g:2005:1: ( () )
            // InternalVideoGen.g:2006:1: ()
            {
             before(grammarAccess.getNegateFilterAccess().getNegateFilterAction_0()); 
            // InternalVideoGen.g:2007:1: ()
            // InternalVideoGen.g:2009:1: 
            {
            }

             after(grammarAccess.getNegateFilterAccess().getNegateFilterAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NegateFilter__Group__0__Impl"


    // $ANTLR start "rule__NegateFilter__Group__1"
    // InternalVideoGen.g:2019:1: rule__NegateFilter__Group__1 : rule__NegateFilter__Group__1__Impl ;
    public final void rule__NegateFilter__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:2023:1: ( rule__NegateFilter__Group__1__Impl )
            // InternalVideoGen.g:2024:2: rule__NegateFilter__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__NegateFilter__Group__1__Impl();

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
    // $ANTLR end "rule__NegateFilter__Group__1"


    // $ANTLR start "rule__NegateFilter__Group__1__Impl"
    // InternalVideoGen.g:2030:1: rule__NegateFilter__Group__1__Impl : ( 'negate' ) ;
    public final void rule__NegateFilter__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:2034:1: ( ( 'negate' ) )
            // InternalVideoGen.g:2035:1: ( 'negate' )
            {
            // InternalVideoGen.g:2035:1: ( 'negate' )
            // InternalVideoGen.g:2036:1: 'negate'
            {
             before(grammarAccess.getNegateFilterAccess().getNegateKeyword_1()); 
            match(input,31,FOLLOW_2); 
             after(grammarAccess.getNegateFilterAccess().getNegateKeyword_1()); 

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
    // $ANTLR end "rule__NegateFilter__Group__1__Impl"


    // $ANTLR start "rule__FlipFilter__Group__0"
    // InternalVideoGen.g:2053:1: rule__FlipFilter__Group__0 : rule__FlipFilter__Group__0__Impl rule__FlipFilter__Group__1 ;
    public final void rule__FlipFilter__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:2057:1: ( rule__FlipFilter__Group__0__Impl rule__FlipFilter__Group__1 )
            // InternalVideoGen.g:2058:2: rule__FlipFilter__Group__0__Impl rule__FlipFilter__Group__1
            {
            pushFollow(FOLLOW_19);
            rule__FlipFilter__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__FlipFilter__Group__1();

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
    // $ANTLR end "rule__FlipFilter__Group__0"


    // $ANTLR start "rule__FlipFilter__Group__0__Impl"
    // InternalVideoGen.g:2065:1: rule__FlipFilter__Group__0__Impl : ( 'flip' ) ;
    public final void rule__FlipFilter__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:2069:1: ( ( 'flip' ) )
            // InternalVideoGen.g:2070:1: ( 'flip' )
            {
            // InternalVideoGen.g:2070:1: ( 'flip' )
            // InternalVideoGen.g:2071:1: 'flip'
            {
             before(grammarAccess.getFlipFilterAccess().getFlipKeyword_0()); 
            match(input,32,FOLLOW_2); 
             after(grammarAccess.getFlipFilterAccess().getFlipKeyword_0()); 

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
    // $ANTLR end "rule__FlipFilter__Group__0__Impl"


    // $ANTLR start "rule__FlipFilter__Group__1"
    // InternalVideoGen.g:2084:1: rule__FlipFilter__Group__1 : rule__FlipFilter__Group__1__Impl ;
    public final void rule__FlipFilter__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:2088:1: ( rule__FlipFilter__Group__1__Impl )
            // InternalVideoGen.g:2089:2: rule__FlipFilter__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__FlipFilter__Group__1__Impl();

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
    // $ANTLR end "rule__FlipFilter__Group__1"


    // $ANTLR start "rule__FlipFilter__Group__1__Impl"
    // InternalVideoGen.g:2095:1: rule__FlipFilter__Group__1__Impl : ( ( rule__FlipFilter__OrientationAssignment_1 ) ) ;
    public final void rule__FlipFilter__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:2099:1: ( ( ( rule__FlipFilter__OrientationAssignment_1 ) ) )
            // InternalVideoGen.g:2100:1: ( ( rule__FlipFilter__OrientationAssignment_1 ) )
            {
            // InternalVideoGen.g:2100:1: ( ( rule__FlipFilter__OrientationAssignment_1 ) )
            // InternalVideoGen.g:2101:1: ( rule__FlipFilter__OrientationAssignment_1 )
            {
             before(grammarAccess.getFlipFilterAccess().getOrientationAssignment_1()); 
            // InternalVideoGen.g:2102:1: ( rule__FlipFilter__OrientationAssignment_1 )
            // InternalVideoGen.g:2102:2: rule__FlipFilter__OrientationAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__FlipFilter__OrientationAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getFlipFilterAccess().getOrientationAssignment_1()); 

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
    // $ANTLR end "rule__FlipFilter__Group__1__Impl"


    // $ANTLR start "rule__VideoGeneratorModel__InformationAssignment_1"
    // InternalVideoGen.g:2117:1: rule__VideoGeneratorModel__InformationAssignment_1 : ( ruleVideoGenInformation ) ;
    public final void rule__VideoGeneratorModel__InformationAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:2121:1: ( ( ruleVideoGenInformation ) )
            // InternalVideoGen.g:2122:1: ( ruleVideoGenInformation )
            {
            // InternalVideoGen.g:2122:1: ( ruleVideoGenInformation )
            // InternalVideoGen.g:2123:1: ruleVideoGenInformation
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
    // InternalVideoGen.g:2132:1: rule__VideoGeneratorModel__VideoseqsAssignment_4 : ( ruleVideoSeq ) ;
    public final void rule__VideoGeneratorModel__VideoseqsAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:2136:1: ( ( ruleVideoSeq ) )
            // InternalVideoGen.g:2137:1: ( ruleVideoSeq )
            {
            // InternalVideoGen.g:2137:1: ( ruleVideoSeq )
            // InternalVideoGen.g:2138:1: ruleVideoSeq
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
    // InternalVideoGen.g:2147:1: rule__VideoGenInformation__AuthorNameAssignment_1_1 : ( RULE_STRING ) ;
    public final void rule__VideoGenInformation__AuthorNameAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:2151:1: ( ( RULE_STRING ) )
            // InternalVideoGen.g:2152:1: ( RULE_STRING )
            {
            // InternalVideoGen.g:2152:1: ( RULE_STRING )
            // InternalVideoGen.g:2153:1: RULE_STRING
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
    // InternalVideoGen.g:2162:1: rule__VideoGenInformation__VersionAssignment_2_1 : ( RULE_STRING ) ;
    public final void rule__VideoGenInformation__VersionAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:2166:1: ( ( RULE_STRING ) )
            // InternalVideoGen.g:2167:1: ( RULE_STRING )
            {
            // InternalVideoGen.g:2167:1: ( RULE_STRING )
            // InternalVideoGen.g:2168:1: RULE_STRING
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
    // InternalVideoGen.g:2177:1: rule__VideoGenInformation__CreationDateAssignment_3_1 : ( RULE_STRING ) ;
    public final void rule__VideoGenInformation__CreationDateAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:2181:1: ( ( RULE_STRING ) )
            // InternalVideoGen.g:2182:1: ( RULE_STRING )
            {
            // InternalVideoGen.g:2182:1: ( RULE_STRING )
            // InternalVideoGen.g:2183:1: RULE_STRING
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
    // InternalVideoGen.g:2192:1: rule__MandatoryVideoSeq__DescriptionAssignment_1 : ( ruleVideoDescription ) ;
    public final void rule__MandatoryVideoSeq__DescriptionAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:2196:1: ( ( ruleVideoDescription ) )
            // InternalVideoGen.g:2197:1: ( ruleVideoDescription )
            {
            // InternalVideoGen.g:2197:1: ( ruleVideoDescription )
            // InternalVideoGen.g:2198:1: ruleVideoDescription
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
    // InternalVideoGen.g:2207:1: rule__OptionalVideoSeq__DescriptionAssignment_1 : ( ruleVideoDescription ) ;
    public final void rule__OptionalVideoSeq__DescriptionAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:2211:1: ( ( ruleVideoDescription ) )
            // InternalVideoGen.g:2212:1: ( ruleVideoDescription )
            {
            // InternalVideoGen.g:2212:1: ( ruleVideoDescription )
            // InternalVideoGen.g:2213:1: ruleVideoDescription
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
    // InternalVideoGen.g:2222:1: rule__AlternativeVideoSeq__VideoidAssignment_1 : ( RULE_ID ) ;
    public final void rule__AlternativeVideoSeq__VideoidAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:2226:1: ( ( RULE_ID ) )
            // InternalVideoGen.g:2227:1: ( RULE_ID )
            {
            // InternalVideoGen.g:2227:1: ( RULE_ID )
            // InternalVideoGen.g:2228:1: RULE_ID
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
    // InternalVideoGen.g:2237:1: rule__AlternativeVideoSeq__VideodescsAssignment_3 : ( ruleVideoDescription ) ;
    public final void rule__AlternativeVideoSeq__VideodescsAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:2241:1: ( ( ruleVideoDescription ) )
            // InternalVideoGen.g:2242:1: ( ruleVideoDescription )
            {
            // InternalVideoGen.g:2242:1: ( ruleVideoDescription )
            // InternalVideoGen.g:2243:1: ruleVideoDescription
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
    // InternalVideoGen.g:2252:1: rule__VideoDescription__VideoidAssignment_1 : ( RULE_ID ) ;
    public final void rule__VideoDescription__VideoidAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:2256:1: ( ( RULE_ID ) )
            // InternalVideoGen.g:2257:1: ( RULE_ID )
            {
            // InternalVideoGen.g:2257:1: ( RULE_ID )
            // InternalVideoGen.g:2258:1: RULE_ID
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
    // InternalVideoGen.g:2267:1: rule__VideoDescription__LocationAssignment_2 : ( RULE_STRING ) ;
    public final void rule__VideoDescription__LocationAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:2271:1: ( ( RULE_STRING ) )
            // InternalVideoGen.g:2272:1: ( RULE_STRING )
            {
            // InternalVideoGen.g:2272:1: ( RULE_STRING )
            // InternalVideoGen.g:2273:1: RULE_STRING
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
    // InternalVideoGen.g:2282:1: rule__VideoDescription__DurationAssignment_3_1_1 : ( RULE_INT ) ;
    public final void rule__VideoDescription__DurationAssignment_3_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:2286:1: ( ( RULE_INT ) )
            // InternalVideoGen.g:2287:1: ( RULE_INT )
            {
            // InternalVideoGen.g:2287:1: ( RULE_INT )
            // InternalVideoGen.g:2288:1: RULE_INT
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
    // InternalVideoGen.g:2297:1: rule__VideoDescription__ProbabilityAssignment_3_2_1 : ( RULE_INT ) ;
    public final void rule__VideoDescription__ProbabilityAssignment_3_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:2301:1: ( ( RULE_INT ) )
            // InternalVideoGen.g:2302:1: ( RULE_INT )
            {
            // InternalVideoGen.g:2302:1: ( RULE_INT )
            // InternalVideoGen.g:2303:1: RULE_INT
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
    // InternalVideoGen.g:2312:1: rule__VideoDescription__SizeAssignment_3_3_1 : ( RULE_INT ) ;
    public final void rule__VideoDescription__SizeAssignment_3_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:2316:1: ( ( RULE_INT ) )
            // InternalVideoGen.g:2317:1: ( RULE_INT )
            {
            // InternalVideoGen.g:2317:1: ( RULE_INT )
            // InternalVideoGen.g:2318:1: RULE_INT
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
    // InternalVideoGen.g:2327:1: rule__VideoDescription__DescriptionAssignment_3_4_1 : ( RULE_STRING ) ;
    public final void rule__VideoDescription__DescriptionAssignment_3_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:2331:1: ( ( RULE_STRING ) )
            // InternalVideoGen.g:2332:1: ( RULE_STRING )
            {
            // InternalVideoGen.g:2332:1: ( RULE_STRING )
            // InternalVideoGen.g:2333:1: RULE_STRING
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


    // $ANTLR start "rule__VideoDescription__FilterAssignment_3_5_1"
    // InternalVideoGen.g:2342:1: rule__VideoDescription__FilterAssignment_3_5_1 : ( ruleFilter ) ;
    public final void rule__VideoDescription__FilterAssignment_3_5_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:2346:1: ( ( ruleFilter ) )
            // InternalVideoGen.g:2347:1: ( ruleFilter )
            {
            // InternalVideoGen.g:2347:1: ( ruleFilter )
            // InternalVideoGen.g:2348:1: ruleFilter
            {
             before(grammarAccess.getVideoDescriptionAccess().getFilterFilterParserRuleCall_3_5_1_0()); 
            pushFollow(FOLLOW_2);
            ruleFilter();

            state._fsp--;

             after(grammarAccess.getVideoDescriptionAccess().getFilterFilterParserRuleCall_3_5_1_0()); 

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


    // $ANTLR start "rule__FlipFilter__OrientationAssignment_1"
    // InternalVideoGen.g:2357:1: rule__FlipFilter__OrientationAssignment_1 : ( ( rule__FlipFilter__OrientationAlternatives_1_0 ) ) ;
    public final void rule__FlipFilter__OrientationAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:2361:1: ( ( ( rule__FlipFilter__OrientationAlternatives_1_0 ) ) )
            // InternalVideoGen.g:2362:1: ( ( rule__FlipFilter__OrientationAlternatives_1_0 ) )
            {
            // InternalVideoGen.g:2362:1: ( ( rule__FlipFilter__OrientationAlternatives_1_0 ) )
            // InternalVideoGen.g:2363:1: ( rule__FlipFilter__OrientationAlternatives_1_0 )
            {
             before(grammarAccess.getFlipFilterAccess().getOrientationAlternatives_1_0()); 
            // InternalVideoGen.g:2364:1: ( rule__FlipFilter__OrientationAlternatives_1_0 )
            // InternalVideoGen.g:2364:2: rule__FlipFilter__OrientationAlternatives_1_0
            {
            pushFollow(FOLLOW_2);
            rule__FlipFilter__OrientationAlternatives_1_0();

            state._fsp--;


            }

             after(grammarAccess.getFlipFilterAccess().getOrientationAlternatives_1_0()); 

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
    // $ANTLR end "rule__FlipFilter__OrientationAssignment_1"

    // Delegated rules


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000060000L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000E00000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000E00002L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000180000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000000090L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000001000002L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x00000000000000C0L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x000000003E000020L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x00000001C0000000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x000000000001E000L});

}