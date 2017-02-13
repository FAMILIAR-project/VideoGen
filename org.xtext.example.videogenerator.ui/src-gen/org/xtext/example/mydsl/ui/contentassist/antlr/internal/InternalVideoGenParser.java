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
<<<<<<< HEAD
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_LEFT_BRACKET", "RULE_RIGHT_BRACKET", "RULE_STRING", "RULE_ID", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'TOP'", "'BOTTOM'", "'CENTER'", "'h'", "'horizontal'", "'v'", "'vertical'", "'VideoGen'", "'@author'", "'@version'", "'@creation'", "'mandatory'", "'optional'", "'alternatives'", "'videoseq'", "'duration'", "'probability'", "'textIncrust'", "'size'", "'description'", "'subtitle'", "'text'", "'filter'", "'color'", "'content'", "'position'", "'b&w'", "'negate'", "'flip'"
=======
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_LEFT_BRACKET", "RULE_RIGHT_BRACKET", "RULE_STRING", "RULE_ID", "RULE_FLOAT", "RULE_PERCENTAGE", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'VideoGen'", "'@author'", "'@version'", "'@creation'", "'mandatory'", "'optional'", "'alternatives'", "'videoseq'", "'duration'", "'probability'", "'size'", "'description'"
>>>>>>> e529713dc2ce4273a0bbf2a0634beb68235d51ef
    };
    public static final int RULE_STRING=6;
    public static final int RULE_SL_COMMENT=12;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__37=37;
    public static final int RULE_RIGHT_BRACKET=5;
    public static final int T__16=16;
    public static final int T__38=38;
    public static final int T__17=17;
    public static final int T__39=39;
    public static final int T__18=18;
<<<<<<< HEAD
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__13=13;
    public static final int T__35=35;
    public static final int T__14=14;
    public static final int T__36=36;
=======
>>>>>>> e529713dc2ce4273a0bbf2a0634beb68235d51ef
    public static final int EOF=-1;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int RULE_ID=7;
    public static final int RULE_WS=13;
    public static final int RULE_LEFT_BRACKET=4;
<<<<<<< HEAD
    public static final int RULE_ANY_OTHER=12;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int RULE_INT=8;
    public static final int T__29=29;
=======
    public static final int RULE_ANY_OTHER=14;
    public static final int T__26=26;
    public static final int RULE_PERCENTAGE=9;
    public static final int RULE_INT=10;
>>>>>>> e529713dc2ce4273a0bbf2a0634beb68235d51ef
    public static final int T__22=22;
    public static final int RULE_ML_COMMENT=11;
    public static final int T__23=23;
    public static final int RULE_FLOAT=8;
    public static final int T__24=24;
    public static final int T__25=25;
<<<<<<< HEAD
    public static final int T__40=40;
    public static final int T__41=41;
=======
>>>>>>> e529713dc2ce4273a0bbf2a0634beb68235d51ef
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


    // $ANTLR start "entryRuleSubtitle"
    // InternalVideoGen.g:256:1: entryRuleSubtitle : ruleSubtitle EOF ;
    public final void entryRuleSubtitle() throws RecognitionException {
        try {
            // InternalVideoGen.g:257:1: ( ruleSubtitle EOF )
            // InternalVideoGen.g:258:1: ruleSubtitle EOF
            {
             before(grammarAccess.getSubtitleRule()); 
            pushFollow(FOLLOW_1);
            ruleSubtitle();

            state._fsp--;

             after(grammarAccess.getSubtitleRule()); 
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
    // $ANTLR end "entryRuleSubtitle"


    // $ANTLR start "ruleSubtitle"
    // InternalVideoGen.g:265:1: ruleSubtitle : ( ( rule__Subtitle__Group__0 ) ) ;
    public final void ruleSubtitle() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:269:2: ( ( ( rule__Subtitle__Group__0 ) ) )
            // InternalVideoGen.g:270:1: ( ( rule__Subtitle__Group__0 ) )
            {
            // InternalVideoGen.g:270:1: ( ( rule__Subtitle__Group__0 ) )
            // InternalVideoGen.g:271:1: ( rule__Subtitle__Group__0 )
            {
             before(grammarAccess.getSubtitleAccess().getGroup()); 
            // InternalVideoGen.g:272:1: ( rule__Subtitle__Group__0 )
            // InternalVideoGen.g:272:2: rule__Subtitle__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Subtitle__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getSubtitleAccess().getGroup()); 

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
    // $ANTLR end "ruleSubtitle"


    // $ANTLR start "entryRuleText"
    // InternalVideoGen.g:284:1: entryRuleText : ruleText EOF ;
    public final void entryRuleText() throws RecognitionException {
        try {
            // InternalVideoGen.g:285:1: ( ruleText EOF )
            // InternalVideoGen.g:286:1: ruleText EOF
            {
             before(grammarAccess.getTextRule()); 
            pushFollow(FOLLOW_1);
            ruleText();

            state._fsp--;

             after(grammarAccess.getTextRule()); 
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
    // $ANTLR end "entryRuleText"


    // $ANTLR start "ruleText"
    // InternalVideoGen.g:293:1: ruleText : ( ( rule__Text__Group__0 ) ) ;
    public final void ruleText() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:297:2: ( ( ( rule__Text__Group__0 ) ) )
            // InternalVideoGen.g:298:1: ( ( rule__Text__Group__0 ) )
            {
            // InternalVideoGen.g:298:1: ( ( rule__Text__Group__0 ) )
            // InternalVideoGen.g:299:1: ( rule__Text__Group__0 )
            {
             before(grammarAccess.getTextAccess().getGroup()); 
            // InternalVideoGen.g:300:1: ( rule__Text__Group__0 )
            // InternalVideoGen.g:300:2: rule__Text__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Text__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getTextAccess().getGroup()); 

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
    // $ANTLR end "ruleText"


    // $ANTLR start "entryRulePosition"
    // InternalVideoGen.g:312:1: entryRulePosition : rulePosition EOF ;
    public final void entryRulePosition() throws RecognitionException {
        try {
            // InternalVideoGen.g:313:1: ( rulePosition EOF )
            // InternalVideoGen.g:314:1: rulePosition EOF
            {
             before(grammarAccess.getPositionRule()); 
            pushFollow(FOLLOW_1);
            rulePosition();

            state._fsp--;

             after(grammarAccess.getPositionRule()); 
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
    // $ANTLR end "entryRulePosition"


    // $ANTLR start "rulePosition"
    // InternalVideoGen.g:321:1: rulePosition : ( ( rule__Position__Alternatives ) ) ;
    public final void rulePosition() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:325:2: ( ( ( rule__Position__Alternatives ) ) )
            // InternalVideoGen.g:326:1: ( ( rule__Position__Alternatives ) )
            {
            // InternalVideoGen.g:326:1: ( ( rule__Position__Alternatives ) )
            // InternalVideoGen.g:327:1: ( rule__Position__Alternatives )
            {
             before(grammarAccess.getPositionAccess().getAlternatives()); 
            // InternalVideoGen.g:328:1: ( rule__Position__Alternatives )
            // InternalVideoGen.g:328:2: rule__Position__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__Position__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getPositionAccess().getAlternatives()); 

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
    // $ANTLR end "rulePosition"


    // $ANTLR start "entryRuleFilter"
    // InternalVideoGen.g:340:1: entryRuleFilter : ruleFilter EOF ;
    public final void entryRuleFilter() throws RecognitionException {
        try {
            // InternalVideoGen.g:341:1: ( ruleFilter EOF )
            // InternalVideoGen.g:342:1: ruleFilter EOF
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
    // InternalVideoGen.g:349:1: ruleFilter : ( ( rule__Filter__Alternatives ) ) ;
    public final void ruleFilter() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:353:2: ( ( ( rule__Filter__Alternatives ) ) )
            // InternalVideoGen.g:354:1: ( ( rule__Filter__Alternatives ) )
            {
            // InternalVideoGen.g:354:1: ( ( rule__Filter__Alternatives ) )
            // InternalVideoGen.g:355:1: ( rule__Filter__Alternatives )
            {
             before(grammarAccess.getFilterAccess().getAlternatives()); 
            // InternalVideoGen.g:356:1: ( rule__Filter__Alternatives )
            // InternalVideoGen.g:356:2: rule__Filter__Alternatives
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
    // InternalVideoGen.g:368:1: entryRuleBlackWhiteFilter : ruleBlackWhiteFilter EOF ;
    public final void entryRuleBlackWhiteFilter() throws RecognitionException {
        try {
            // InternalVideoGen.g:369:1: ( ruleBlackWhiteFilter EOF )
            // InternalVideoGen.g:370:1: ruleBlackWhiteFilter EOF
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
    // InternalVideoGen.g:377:1: ruleBlackWhiteFilter : ( ( rule__BlackWhiteFilter__Group__0 ) ) ;
    public final void ruleBlackWhiteFilter() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:381:2: ( ( ( rule__BlackWhiteFilter__Group__0 ) ) )
            // InternalVideoGen.g:382:1: ( ( rule__BlackWhiteFilter__Group__0 ) )
            {
            // InternalVideoGen.g:382:1: ( ( rule__BlackWhiteFilter__Group__0 ) )
            // InternalVideoGen.g:383:1: ( rule__BlackWhiteFilter__Group__0 )
            {
             before(grammarAccess.getBlackWhiteFilterAccess().getGroup()); 
            // InternalVideoGen.g:384:1: ( rule__BlackWhiteFilter__Group__0 )
            // InternalVideoGen.g:384:2: rule__BlackWhiteFilter__Group__0
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
    // InternalVideoGen.g:396:1: entryRuleNegateFilter : ruleNegateFilter EOF ;
    public final void entryRuleNegateFilter() throws RecognitionException {
        try {
            // InternalVideoGen.g:397:1: ( ruleNegateFilter EOF )
            // InternalVideoGen.g:398:1: ruleNegateFilter EOF
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
    // InternalVideoGen.g:405:1: ruleNegateFilter : ( ( rule__NegateFilter__Group__0 ) ) ;
    public final void ruleNegateFilter() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:409:2: ( ( ( rule__NegateFilter__Group__0 ) ) )
            // InternalVideoGen.g:410:1: ( ( rule__NegateFilter__Group__0 ) )
            {
            // InternalVideoGen.g:410:1: ( ( rule__NegateFilter__Group__0 ) )
            // InternalVideoGen.g:411:1: ( rule__NegateFilter__Group__0 )
            {
             before(grammarAccess.getNegateFilterAccess().getGroup()); 
            // InternalVideoGen.g:412:1: ( rule__NegateFilter__Group__0 )
            // InternalVideoGen.g:412:2: rule__NegateFilter__Group__0
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
    // InternalVideoGen.g:424:1: entryRuleFlipFilter : ruleFlipFilter EOF ;
    public final void entryRuleFlipFilter() throws RecognitionException {
        try {
            // InternalVideoGen.g:425:1: ( ruleFlipFilter EOF )
            // InternalVideoGen.g:426:1: ruleFlipFilter EOF
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
    // InternalVideoGen.g:433:1: ruleFlipFilter : ( ( rule__FlipFilter__Group__0 ) ) ;
    public final void ruleFlipFilter() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:437:2: ( ( ( rule__FlipFilter__Group__0 ) ) )
            // InternalVideoGen.g:438:1: ( ( rule__FlipFilter__Group__0 ) )
            {
            // InternalVideoGen.g:438:1: ( ( rule__FlipFilter__Group__0 ) )
            // InternalVideoGen.g:439:1: ( rule__FlipFilter__Group__0 )
            {
             before(grammarAccess.getFlipFilterAccess().getGroup()); 
            // InternalVideoGen.g:440:1: ( rule__FlipFilter__Group__0 )
            // InternalVideoGen.g:440:2: rule__FlipFilter__Group__0
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
    // InternalVideoGen.g:452:1: rule__VideoSeq__Alternatives : ( ( ruleMandatoryVideoSeq ) | ( ruleOptionalVideoSeq ) | ( ruleAlternativeVideoSeq ) );
    public final void rule__VideoSeq__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
<<<<<<< HEAD
            // InternalVideoGen.g:456:1: ( ( ruleMandatoryVideoSeq ) | ( ruleOptionalVideoSeq ) | ( ruleAlternativeVideoSeq ) )
            int alt1=3;
            switch ( input.LA(1) ) {
            case 24:
=======
            // InternalVideoGen.g:260:1: ( ( ruleMandatoryVideoSeq ) | ( ruleOptionalVideoSeq ) | ( ruleAlternativeVideoSeq ) )
            int alt1=3;
            switch ( input.LA(1) ) {
            case 19:
>>>>>>> e529713dc2ce4273a0bbf2a0634beb68235d51ef
                {
                alt1=1;
                }
                break;
<<<<<<< HEAD
            case 25:
=======
            case 20:
>>>>>>> e529713dc2ce4273a0bbf2a0634beb68235d51ef
                {
                alt1=2;
                }
                break;
<<<<<<< HEAD
            case 26:
=======
            case 21:
>>>>>>> e529713dc2ce4273a0bbf2a0634beb68235d51ef
                {
                alt1=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);
<<<<<<< HEAD

                throw nvae;
            }

            switch (alt1) {
                case 1 :
                    // InternalVideoGen.g:457:1: ( ruleMandatoryVideoSeq )
                    {
                    // InternalVideoGen.g:457:1: ( ruleMandatoryVideoSeq )
                    // InternalVideoGen.g:458:1: ruleMandatoryVideoSeq
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
                    // InternalVideoGen.g:463:6: ( ruleOptionalVideoSeq )
                    {
                    // InternalVideoGen.g:463:6: ( ruleOptionalVideoSeq )
                    // InternalVideoGen.g:464:1: ruleOptionalVideoSeq
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
                    // InternalVideoGen.g:469:6: ( ruleAlternativeVideoSeq )
                    {
                    // InternalVideoGen.g:469:6: ( ruleAlternativeVideoSeq )
                    // InternalVideoGen.g:470:1: ruleAlternativeVideoSeq
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


    // $ANTLR start "rule__Position__Alternatives"
    // InternalVideoGen.g:480:1: rule__Position__Alternatives : ( ( 'TOP' ) | ( 'BOTTOM' ) | ( 'CENTER' ) );
    public final void rule__Position__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:484:1: ( ( 'TOP' ) | ( 'BOTTOM' ) | ( 'CENTER' ) )
            int alt2=3;
            switch ( input.LA(1) ) {
            case 13:
                {
                alt2=1;
                }
                break;
            case 14:
                {
                alt2=2;
                }
                break;
            case 15:
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
                    // InternalVideoGen.g:485:1: ( 'TOP' )
                    {
                    // InternalVideoGen.g:485:1: ( 'TOP' )
                    // InternalVideoGen.g:486:1: 'TOP'
                    {
                     before(grammarAccess.getPositionAccess().getTOPKeyword_0()); 
                    match(input,13,FOLLOW_2); 
                     after(grammarAccess.getPositionAccess().getTOPKeyword_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalVideoGen.g:493:6: ( 'BOTTOM' )
                    {
                    // InternalVideoGen.g:493:6: ( 'BOTTOM' )
                    // InternalVideoGen.g:494:1: 'BOTTOM'
                    {
                     before(grammarAccess.getPositionAccess().getBOTTOMKeyword_1()); 
                    match(input,14,FOLLOW_2); 
                     after(grammarAccess.getPositionAccess().getBOTTOMKeyword_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalVideoGen.g:501:6: ( 'CENTER' )
                    {
                    // InternalVideoGen.g:501:6: ( 'CENTER' )
                    // InternalVideoGen.g:502:1: 'CENTER'
                    {
                     before(grammarAccess.getPositionAccess().getCENTERKeyword_2()); 
                    match(input,15,FOLLOW_2); 
                     after(grammarAccess.getPositionAccess().getCENTERKeyword_2()); 

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
    // $ANTLR end "rule__Position__Alternatives"


    // $ANTLR start "rule__Filter__Alternatives"
    // InternalVideoGen.g:514:1: rule__Filter__Alternatives : ( ( ruleFlipFilter ) | ( ruleNegateFilter ) | ( ruleBlackWhiteFilter ) );
    public final void rule__Filter__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:518:1: ( ( ruleFlipFilter ) | ( ruleNegateFilter ) | ( ruleBlackWhiteFilter ) )
            int alt3=3;
            switch ( input.LA(1) ) {
            case 41:
                {
                alt3=1;
                }
                break;
            case 40:
                {
                alt3=2;
                }
                break;
            case 39:
                {
                alt3=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }

            switch (alt3) {
                case 1 :
                    // InternalVideoGen.g:519:1: ( ruleFlipFilter )
                    {
                    // InternalVideoGen.g:519:1: ( ruleFlipFilter )
                    // InternalVideoGen.g:520:1: ruleFlipFilter
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
                    // InternalVideoGen.g:525:6: ( ruleNegateFilter )
                    {
                    // InternalVideoGen.g:525:6: ( ruleNegateFilter )
                    // InternalVideoGen.g:526:1: ruleNegateFilter
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
                    // InternalVideoGen.g:531:6: ( ruleBlackWhiteFilter )
                    {
                    // InternalVideoGen.g:531:6: ( ruleBlackWhiteFilter )
                    // InternalVideoGen.g:532:1: ruleBlackWhiteFilter
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
    // InternalVideoGen.g:542:1: rule__FlipFilter__OrientationAlternatives_1_0 : ( ( 'h' ) | ( 'horizontal' ) | ( 'v' ) | ( 'vertical' ) );
    public final void rule__FlipFilter__OrientationAlternatives_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:546:1: ( ( 'h' ) | ( 'horizontal' ) | ( 'v' ) | ( 'vertical' ) )
            int alt4=4;
            switch ( input.LA(1) ) {
            case 16:
                {
                alt4=1;
                }
                break;
            case 17:
                {
                alt4=2;
                }
                break;
            case 18:
                {
                alt4=3;
                }
                break;
            case 19:
                {
                alt4=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }

            switch (alt4) {
                case 1 :
                    // InternalVideoGen.g:547:1: ( 'h' )
                    {
                    // InternalVideoGen.g:547:1: ( 'h' )
                    // InternalVideoGen.g:548:1: 'h'
                    {
                     before(grammarAccess.getFlipFilterAccess().getOrientationHKeyword_1_0_0()); 
                    match(input,16,FOLLOW_2); 
                     after(grammarAccess.getFlipFilterAccess().getOrientationHKeyword_1_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalVideoGen.g:555:6: ( 'horizontal' )
                    {
                    // InternalVideoGen.g:555:6: ( 'horizontal' )
                    // InternalVideoGen.g:556:1: 'horizontal'
                    {
                     before(grammarAccess.getFlipFilterAccess().getOrientationHorizontalKeyword_1_0_1()); 
                    match(input,17,FOLLOW_2); 
                     after(grammarAccess.getFlipFilterAccess().getOrientationHorizontalKeyword_1_0_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalVideoGen.g:563:6: ( 'v' )
                    {
                    // InternalVideoGen.g:563:6: ( 'v' )
                    // InternalVideoGen.g:564:1: 'v'
                    {
                     before(grammarAccess.getFlipFilterAccess().getOrientationVKeyword_1_0_2()); 
                    match(input,18,FOLLOW_2); 
                     after(grammarAccess.getFlipFilterAccess().getOrientationVKeyword_1_0_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalVideoGen.g:571:6: ( 'vertical' )
                    {
                    // InternalVideoGen.g:571:6: ( 'vertical' )
                    // InternalVideoGen.g:572:1: 'vertical'
                    {
                     before(grammarAccess.getFlipFilterAccess().getOrientationVerticalKeyword_1_0_3()); 
                    match(input,19,FOLLOW_2); 
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
    // InternalVideoGen.g:586:1: rule__VideoGeneratorModel__Group__0 : rule__VideoGeneratorModel__Group__0__Impl rule__VideoGeneratorModel__Group__1 ;
    public final void rule__VideoGeneratorModel__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:590:1: ( rule__VideoGeneratorModel__Group__0__Impl rule__VideoGeneratorModel__Group__1 )
            // InternalVideoGen.g:591:2: rule__VideoGeneratorModel__Group__0__Impl rule__VideoGeneratorModel__Group__1
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
    // InternalVideoGen.g:598:1: rule__VideoGeneratorModel__Group__0__Impl : ( () ) ;
    public final void rule__VideoGeneratorModel__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:602:1: ( ( () ) )
            // InternalVideoGen.g:603:1: ( () )
            {
            // InternalVideoGen.g:603:1: ( () )
            // InternalVideoGen.g:604:1: ()
            {
             before(grammarAccess.getVideoGeneratorModelAccess().getVideoGeneratorModelAction_0()); 
            // InternalVideoGen.g:605:1: ()
            // InternalVideoGen.g:607:1: 
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
    // InternalVideoGen.g:617:1: rule__VideoGeneratorModel__Group__1 : rule__VideoGeneratorModel__Group__1__Impl rule__VideoGeneratorModel__Group__2 ;
    public final void rule__VideoGeneratorModel__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:621:1: ( rule__VideoGeneratorModel__Group__1__Impl rule__VideoGeneratorModel__Group__2 )
            // InternalVideoGen.g:622:2: rule__VideoGeneratorModel__Group__1__Impl rule__VideoGeneratorModel__Group__2
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
    // InternalVideoGen.g:629:1: rule__VideoGeneratorModel__Group__1__Impl : ( ( rule__VideoGeneratorModel__InformationAssignment_1 )? ) ;
    public final void rule__VideoGeneratorModel__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:633:1: ( ( ( rule__VideoGeneratorModel__InformationAssignment_1 )? ) )
            // InternalVideoGen.g:634:1: ( ( rule__VideoGeneratorModel__InformationAssignment_1 )? )
            {
            // InternalVideoGen.g:634:1: ( ( rule__VideoGeneratorModel__InformationAssignment_1 )? )
            // InternalVideoGen.g:635:1: ( rule__VideoGeneratorModel__InformationAssignment_1 )?
            {
             before(grammarAccess.getVideoGeneratorModelAccess().getInformationAssignment_1()); 
            // InternalVideoGen.g:636:1: ( rule__VideoGeneratorModel__InformationAssignment_1 )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==21) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // InternalVideoGen.g:636:2: rule__VideoGeneratorModel__InformationAssignment_1
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
    // InternalVideoGen.g:646:1: rule__VideoGeneratorModel__Group__2 : rule__VideoGeneratorModel__Group__2__Impl rule__VideoGeneratorModel__Group__3 ;
    public final void rule__VideoGeneratorModel__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:650:1: ( rule__VideoGeneratorModel__Group__2__Impl rule__VideoGeneratorModel__Group__3 )
            // InternalVideoGen.g:651:2: rule__VideoGeneratorModel__Group__2__Impl rule__VideoGeneratorModel__Group__3
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
    // InternalVideoGen.g:658:1: rule__VideoGeneratorModel__Group__2__Impl : ( 'VideoGen' ) ;
    public final void rule__VideoGeneratorModel__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:662:1: ( ( 'VideoGen' ) )
            // InternalVideoGen.g:663:1: ( 'VideoGen' )
            {
            // InternalVideoGen.g:663:1: ( 'VideoGen' )
            // InternalVideoGen.g:664:1: 'VideoGen'
            {
             before(grammarAccess.getVideoGeneratorModelAccess().getVideoGenKeyword_2()); 
            match(input,20,FOLLOW_2); 
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
    // InternalVideoGen.g:677:1: rule__VideoGeneratorModel__Group__3 : rule__VideoGeneratorModel__Group__3__Impl rule__VideoGeneratorModel__Group__4 ;
    public final void rule__VideoGeneratorModel__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:681:1: ( rule__VideoGeneratorModel__Group__3__Impl rule__VideoGeneratorModel__Group__4 )
            // InternalVideoGen.g:682:2: rule__VideoGeneratorModel__Group__3__Impl rule__VideoGeneratorModel__Group__4
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
    // InternalVideoGen.g:689:1: rule__VideoGeneratorModel__Group__3__Impl : ( RULE_LEFT_BRACKET ) ;
    public final void rule__VideoGeneratorModel__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:693:1: ( ( RULE_LEFT_BRACKET ) )
            // InternalVideoGen.g:694:1: ( RULE_LEFT_BRACKET )
            {
            // InternalVideoGen.g:694:1: ( RULE_LEFT_BRACKET )
            // InternalVideoGen.g:695:1: RULE_LEFT_BRACKET
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
    // InternalVideoGen.g:706:1: rule__VideoGeneratorModel__Group__4 : rule__VideoGeneratorModel__Group__4__Impl rule__VideoGeneratorModel__Group__5 ;
    public final void rule__VideoGeneratorModel__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:710:1: ( rule__VideoGeneratorModel__Group__4__Impl rule__VideoGeneratorModel__Group__5 )
            // InternalVideoGen.g:711:2: rule__VideoGeneratorModel__Group__4__Impl rule__VideoGeneratorModel__Group__5
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
    // InternalVideoGen.g:718:1: rule__VideoGeneratorModel__Group__4__Impl : ( ( ( rule__VideoGeneratorModel__VideoseqsAssignment_4 ) ) ( ( rule__VideoGeneratorModel__VideoseqsAssignment_4 )* ) ) ;
    public final void rule__VideoGeneratorModel__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:722:1: ( ( ( ( rule__VideoGeneratorModel__VideoseqsAssignment_4 ) ) ( ( rule__VideoGeneratorModel__VideoseqsAssignment_4 )* ) ) )
            // InternalVideoGen.g:723:1: ( ( ( rule__VideoGeneratorModel__VideoseqsAssignment_4 ) ) ( ( rule__VideoGeneratorModel__VideoseqsAssignment_4 )* ) )
            {
            // InternalVideoGen.g:723:1: ( ( ( rule__VideoGeneratorModel__VideoseqsAssignment_4 ) ) ( ( rule__VideoGeneratorModel__VideoseqsAssignment_4 )* ) )
            // InternalVideoGen.g:724:1: ( ( rule__VideoGeneratorModel__VideoseqsAssignment_4 ) ) ( ( rule__VideoGeneratorModel__VideoseqsAssignment_4 )* )
            {
            // InternalVideoGen.g:724:1: ( ( rule__VideoGeneratorModel__VideoseqsAssignment_4 ) )
            // InternalVideoGen.g:725:1: ( rule__VideoGeneratorModel__VideoseqsAssignment_4 )
            {
             before(grammarAccess.getVideoGeneratorModelAccess().getVideoseqsAssignment_4()); 
            // InternalVideoGen.g:726:1: ( rule__VideoGeneratorModel__VideoseqsAssignment_4 )
            // InternalVideoGen.g:726:2: rule__VideoGeneratorModel__VideoseqsAssignment_4
            {
            pushFollow(FOLLOW_7);
            rule__VideoGeneratorModel__VideoseqsAssignment_4();

            state._fsp--;


            }

             after(grammarAccess.getVideoGeneratorModelAccess().getVideoseqsAssignment_4()); 

            }

            // InternalVideoGen.g:729:1: ( ( rule__VideoGeneratorModel__VideoseqsAssignment_4 )* )
            // InternalVideoGen.g:730:1: ( rule__VideoGeneratorModel__VideoseqsAssignment_4 )*
            {
             before(grammarAccess.getVideoGeneratorModelAccess().getVideoseqsAssignment_4()); 
            // InternalVideoGen.g:731:1: ( rule__VideoGeneratorModel__VideoseqsAssignment_4 )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( ((LA6_0>=24 && LA6_0<=26)) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // InternalVideoGen.g:731:2: rule__VideoGeneratorModel__VideoseqsAssignment_4
            	    {
            	    pushFollow(FOLLOW_7);
            	    rule__VideoGeneratorModel__VideoseqsAssignment_4();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop6;
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
    // InternalVideoGen.g:742:1: rule__VideoGeneratorModel__Group__5 : rule__VideoGeneratorModel__Group__5__Impl ;
    public final void rule__VideoGeneratorModel__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:746:1: ( rule__VideoGeneratorModel__Group__5__Impl )
            // InternalVideoGen.g:747:2: rule__VideoGeneratorModel__Group__5__Impl
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
    // InternalVideoGen.g:753:1: rule__VideoGeneratorModel__Group__5__Impl : ( RULE_RIGHT_BRACKET ) ;
    public final void rule__VideoGeneratorModel__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:757:1: ( ( RULE_RIGHT_BRACKET ) )
            // InternalVideoGen.g:758:1: ( RULE_RIGHT_BRACKET )
            {
            // InternalVideoGen.g:758:1: ( RULE_RIGHT_BRACKET )
            // InternalVideoGen.g:759:1: RULE_RIGHT_BRACKET
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
    // InternalVideoGen.g:782:1: rule__VideoGenInformation__Group__0 : rule__VideoGenInformation__Group__0__Impl rule__VideoGenInformation__Group__1 ;
    public final void rule__VideoGenInformation__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:786:1: ( rule__VideoGenInformation__Group__0__Impl rule__VideoGenInformation__Group__1 )
            // InternalVideoGen.g:787:2: rule__VideoGenInformation__Group__0__Impl rule__VideoGenInformation__Group__1
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
    // InternalVideoGen.g:794:1: rule__VideoGenInformation__Group__0__Impl : ( () ) ;
    public final void rule__VideoGenInformation__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:798:1: ( ( () ) )
            // InternalVideoGen.g:799:1: ( () )
            {
            // InternalVideoGen.g:799:1: ( () )
            // InternalVideoGen.g:800:1: ()
            {
             before(grammarAccess.getVideoGenInformationAccess().getVideoGenInformationAction_0()); 
            // InternalVideoGen.g:801:1: ()
            // InternalVideoGen.g:803:1: 
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
    // InternalVideoGen.g:813:1: rule__VideoGenInformation__Group__1 : rule__VideoGenInformation__Group__1__Impl rule__VideoGenInformation__Group__2 ;
    public final void rule__VideoGenInformation__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:817:1: ( rule__VideoGenInformation__Group__1__Impl rule__VideoGenInformation__Group__2 )
            // InternalVideoGen.g:818:2: rule__VideoGenInformation__Group__1__Impl rule__VideoGenInformation__Group__2
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
    // InternalVideoGen.g:825:1: rule__VideoGenInformation__Group__1__Impl : ( ( rule__VideoGenInformation__Group_1__0 ) ) ;
    public final void rule__VideoGenInformation__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:829:1: ( ( ( rule__VideoGenInformation__Group_1__0 ) ) )
            // InternalVideoGen.g:830:1: ( ( rule__VideoGenInformation__Group_1__0 ) )
            {
            // InternalVideoGen.g:830:1: ( ( rule__VideoGenInformation__Group_1__0 ) )
            // InternalVideoGen.g:831:1: ( rule__VideoGenInformation__Group_1__0 )
            {
             before(grammarAccess.getVideoGenInformationAccess().getGroup_1()); 
            // InternalVideoGen.g:832:1: ( rule__VideoGenInformation__Group_1__0 )
            // InternalVideoGen.g:832:2: rule__VideoGenInformation__Group_1__0
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
    // InternalVideoGen.g:842:1: rule__VideoGenInformation__Group__2 : rule__VideoGenInformation__Group__2__Impl rule__VideoGenInformation__Group__3 ;
    public final void rule__VideoGenInformation__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:846:1: ( rule__VideoGenInformation__Group__2__Impl rule__VideoGenInformation__Group__3 )
            // InternalVideoGen.g:847:2: rule__VideoGenInformation__Group__2__Impl rule__VideoGenInformation__Group__3
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
    // InternalVideoGen.g:854:1: rule__VideoGenInformation__Group__2__Impl : ( ( rule__VideoGenInformation__Group_2__0 )? ) ;
    public final void rule__VideoGenInformation__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:858:1: ( ( ( rule__VideoGenInformation__Group_2__0 )? ) )
            // InternalVideoGen.g:859:1: ( ( rule__VideoGenInformation__Group_2__0 )? )
            {
            // InternalVideoGen.g:859:1: ( ( rule__VideoGenInformation__Group_2__0 )? )
            // InternalVideoGen.g:860:1: ( rule__VideoGenInformation__Group_2__0 )?
            {
             before(grammarAccess.getVideoGenInformationAccess().getGroup_2()); 
            // InternalVideoGen.g:861:1: ( rule__VideoGenInformation__Group_2__0 )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==22) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // InternalVideoGen.g:861:2: rule__VideoGenInformation__Group_2__0
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
    // InternalVideoGen.g:871:1: rule__VideoGenInformation__Group__3 : rule__VideoGenInformation__Group__3__Impl ;
    public final void rule__VideoGenInformation__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:875:1: ( rule__VideoGenInformation__Group__3__Impl )
            // InternalVideoGen.g:876:2: rule__VideoGenInformation__Group__3__Impl
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
    // InternalVideoGen.g:882:1: rule__VideoGenInformation__Group__3__Impl : ( ( rule__VideoGenInformation__Group_3__0 )? ) ;
    public final void rule__VideoGenInformation__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:886:1: ( ( ( rule__VideoGenInformation__Group_3__0 )? ) )
            // InternalVideoGen.g:887:1: ( ( rule__VideoGenInformation__Group_3__0 )? )
            {
            // InternalVideoGen.g:887:1: ( ( rule__VideoGenInformation__Group_3__0 )? )
            // InternalVideoGen.g:888:1: ( rule__VideoGenInformation__Group_3__0 )?
            {
             before(grammarAccess.getVideoGenInformationAccess().getGroup_3()); 
            // InternalVideoGen.g:889:1: ( rule__VideoGenInformation__Group_3__0 )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==23) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // InternalVideoGen.g:889:2: rule__VideoGenInformation__Group_3__0
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
    // InternalVideoGen.g:907:1: rule__VideoGenInformation__Group_1__0 : rule__VideoGenInformation__Group_1__0__Impl rule__VideoGenInformation__Group_1__1 ;
    public final void rule__VideoGenInformation__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:911:1: ( rule__VideoGenInformation__Group_1__0__Impl rule__VideoGenInformation__Group_1__1 )
            // InternalVideoGen.g:912:2: rule__VideoGenInformation__Group_1__0__Impl rule__VideoGenInformation__Group_1__1
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
    // InternalVideoGen.g:919:1: rule__VideoGenInformation__Group_1__0__Impl : ( '@author' ) ;
    public final void rule__VideoGenInformation__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:923:1: ( ( '@author' ) )
            // InternalVideoGen.g:924:1: ( '@author' )
            {
            // InternalVideoGen.g:924:1: ( '@author' )
            // InternalVideoGen.g:925:1: '@author'
            {
             before(grammarAccess.getVideoGenInformationAccess().getAuthorKeyword_1_0()); 
            match(input,21,FOLLOW_2); 
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
    // InternalVideoGen.g:938:1: rule__VideoGenInformation__Group_1__1 : rule__VideoGenInformation__Group_1__1__Impl ;
    public final void rule__VideoGenInformation__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:942:1: ( rule__VideoGenInformation__Group_1__1__Impl )
            // InternalVideoGen.g:943:2: rule__VideoGenInformation__Group_1__1__Impl
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
    // InternalVideoGen.g:949:1: rule__VideoGenInformation__Group_1__1__Impl : ( ( rule__VideoGenInformation__AuthorNameAssignment_1_1 ) ) ;
    public final void rule__VideoGenInformation__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:953:1: ( ( ( rule__VideoGenInformation__AuthorNameAssignment_1_1 ) ) )
            // InternalVideoGen.g:954:1: ( ( rule__VideoGenInformation__AuthorNameAssignment_1_1 ) )
            {
            // InternalVideoGen.g:954:1: ( ( rule__VideoGenInformation__AuthorNameAssignment_1_1 ) )
            // InternalVideoGen.g:955:1: ( rule__VideoGenInformation__AuthorNameAssignment_1_1 )
            {
             before(grammarAccess.getVideoGenInformationAccess().getAuthorNameAssignment_1_1()); 
            // InternalVideoGen.g:956:1: ( rule__VideoGenInformation__AuthorNameAssignment_1_1 )
            // InternalVideoGen.g:956:2: rule__VideoGenInformation__AuthorNameAssignment_1_1
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
    // InternalVideoGen.g:970:1: rule__VideoGenInformation__Group_2__0 : rule__VideoGenInformation__Group_2__0__Impl rule__VideoGenInformation__Group_2__1 ;
    public final void rule__VideoGenInformation__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:974:1: ( rule__VideoGenInformation__Group_2__0__Impl rule__VideoGenInformation__Group_2__1 )
            // InternalVideoGen.g:975:2: rule__VideoGenInformation__Group_2__0__Impl rule__VideoGenInformation__Group_2__1
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
    // InternalVideoGen.g:982:1: rule__VideoGenInformation__Group_2__0__Impl : ( '@version' ) ;
    public final void rule__VideoGenInformation__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:986:1: ( ( '@version' ) )
            // InternalVideoGen.g:987:1: ( '@version' )
            {
            // InternalVideoGen.g:987:1: ( '@version' )
            // InternalVideoGen.g:988:1: '@version'
            {
             before(grammarAccess.getVideoGenInformationAccess().getVersionKeyword_2_0()); 
            match(input,22,FOLLOW_2); 
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
    // InternalVideoGen.g:1001:1: rule__VideoGenInformation__Group_2__1 : rule__VideoGenInformation__Group_2__1__Impl ;
    public final void rule__VideoGenInformation__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:1005:1: ( rule__VideoGenInformation__Group_2__1__Impl )
            // InternalVideoGen.g:1006:2: rule__VideoGenInformation__Group_2__1__Impl
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
    // InternalVideoGen.g:1012:1: rule__VideoGenInformation__Group_2__1__Impl : ( ( rule__VideoGenInformation__VersionAssignment_2_1 ) ) ;
    public final void rule__VideoGenInformation__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:1016:1: ( ( ( rule__VideoGenInformation__VersionAssignment_2_1 ) ) )
            // InternalVideoGen.g:1017:1: ( ( rule__VideoGenInformation__VersionAssignment_2_1 ) )
            {
            // InternalVideoGen.g:1017:1: ( ( rule__VideoGenInformation__VersionAssignment_2_1 ) )
            // InternalVideoGen.g:1018:1: ( rule__VideoGenInformation__VersionAssignment_2_1 )
            {
             before(grammarAccess.getVideoGenInformationAccess().getVersionAssignment_2_1()); 
            // InternalVideoGen.g:1019:1: ( rule__VideoGenInformation__VersionAssignment_2_1 )
            // InternalVideoGen.g:1019:2: rule__VideoGenInformation__VersionAssignment_2_1
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
    // InternalVideoGen.g:1033:1: rule__VideoGenInformation__Group_3__0 : rule__VideoGenInformation__Group_3__0__Impl rule__VideoGenInformation__Group_3__1 ;
    public final void rule__VideoGenInformation__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:1037:1: ( rule__VideoGenInformation__Group_3__0__Impl rule__VideoGenInformation__Group_3__1 )
            // InternalVideoGen.g:1038:2: rule__VideoGenInformation__Group_3__0__Impl rule__VideoGenInformation__Group_3__1
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
    // InternalVideoGen.g:1045:1: rule__VideoGenInformation__Group_3__0__Impl : ( '@creation' ) ;
    public final void rule__VideoGenInformation__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:1049:1: ( ( '@creation' ) )
            // InternalVideoGen.g:1050:1: ( '@creation' )
            {
            // InternalVideoGen.g:1050:1: ( '@creation' )
            // InternalVideoGen.g:1051:1: '@creation'
            {
             before(grammarAccess.getVideoGenInformationAccess().getCreationKeyword_3_0()); 
            match(input,23,FOLLOW_2); 
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
    // InternalVideoGen.g:1064:1: rule__VideoGenInformation__Group_3__1 : rule__VideoGenInformation__Group_3__1__Impl ;
    public final void rule__VideoGenInformation__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:1068:1: ( rule__VideoGenInformation__Group_3__1__Impl )
            // InternalVideoGen.g:1069:2: rule__VideoGenInformation__Group_3__1__Impl
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
    // InternalVideoGen.g:1075:1: rule__VideoGenInformation__Group_3__1__Impl : ( ( rule__VideoGenInformation__CreationDateAssignment_3_1 ) ) ;
    public final void rule__VideoGenInformation__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:1079:1: ( ( ( rule__VideoGenInformation__CreationDateAssignment_3_1 ) ) )
            // InternalVideoGen.g:1080:1: ( ( rule__VideoGenInformation__CreationDateAssignment_3_1 ) )
            {
            // InternalVideoGen.g:1080:1: ( ( rule__VideoGenInformation__CreationDateAssignment_3_1 ) )
            // InternalVideoGen.g:1081:1: ( rule__VideoGenInformation__CreationDateAssignment_3_1 )
            {
             before(grammarAccess.getVideoGenInformationAccess().getCreationDateAssignment_3_1()); 
            // InternalVideoGen.g:1082:1: ( rule__VideoGenInformation__CreationDateAssignment_3_1 )
            // InternalVideoGen.g:1082:2: rule__VideoGenInformation__CreationDateAssignment_3_1
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
    // InternalVideoGen.g:1096:1: rule__MandatoryVideoSeq__Group__0 : rule__MandatoryVideoSeq__Group__0__Impl rule__MandatoryVideoSeq__Group__1 ;
    public final void rule__MandatoryVideoSeq__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:1100:1: ( rule__MandatoryVideoSeq__Group__0__Impl rule__MandatoryVideoSeq__Group__1 )
            // InternalVideoGen.g:1101:2: rule__MandatoryVideoSeq__Group__0__Impl rule__MandatoryVideoSeq__Group__1
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
    // InternalVideoGen.g:1108:1: rule__MandatoryVideoSeq__Group__0__Impl : ( 'mandatory' ) ;
    public final void rule__MandatoryVideoSeq__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:1112:1: ( ( 'mandatory' ) )
            // InternalVideoGen.g:1113:1: ( 'mandatory' )
            {
            // InternalVideoGen.g:1113:1: ( 'mandatory' )
            // InternalVideoGen.g:1114:1: 'mandatory'
            {
             before(grammarAccess.getMandatoryVideoSeqAccess().getMandatoryKeyword_0()); 
            match(input,24,FOLLOW_2); 
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
    // InternalVideoGen.g:1127:1: rule__MandatoryVideoSeq__Group__1 : rule__MandatoryVideoSeq__Group__1__Impl ;
    public final void rule__MandatoryVideoSeq__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:1131:1: ( rule__MandatoryVideoSeq__Group__1__Impl )
            // InternalVideoGen.g:1132:2: rule__MandatoryVideoSeq__Group__1__Impl
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
    // InternalVideoGen.g:1138:1: rule__MandatoryVideoSeq__Group__1__Impl : ( ( rule__MandatoryVideoSeq__DescriptionAssignment_1 ) ) ;
    public final void rule__MandatoryVideoSeq__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:1142:1: ( ( ( rule__MandatoryVideoSeq__DescriptionAssignment_1 ) ) )
            // InternalVideoGen.g:1143:1: ( ( rule__MandatoryVideoSeq__DescriptionAssignment_1 ) )
            {
            // InternalVideoGen.g:1143:1: ( ( rule__MandatoryVideoSeq__DescriptionAssignment_1 ) )
            // InternalVideoGen.g:1144:1: ( rule__MandatoryVideoSeq__DescriptionAssignment_1 )
            {
             before(grammarAccess.getMandatoryVideoSeqAccess().getDescriptionAssignment_1()); 
            // InternalVideoGen.g:1145:1: ( rule__MandatoryVideoSeq__DescriptionAssignment_1 )
            // InternalVideoGen.g:1145:2: rule__MandatoryVideoSeq__DescriptionAssignment_1
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
    // InternalVideoGen.g:1159:1: rule__OptionalVideoSeq__Group__0 : rule__OptionalVideoSeq__Group__0__Impl rule__OptionalVideoSeq__Group__1 ;
    public final void rule__OptionalVideoSeq__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:1163:1: ( rule__OptionalVideoSeq__Group__0__Impl rule__OptionalVideoSeq__Group__1 )
            // InternalVideoGen.g:1164:2: rule__OptionalVideoSeq__Group__0__Impl rule__OptionalVideoSeq__Group__1
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
    // InternalVideoGen.g:1171:1: rule__OptionalVideoSeq__Group__0__Impl : ( 'optional' ) ;
    public final void rule__OptionalVideoSeq__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:1175:1: ( ( 'optional' ) )
            // InternalVideoGen.g:1176:1: ( 'optional' )
            {
            // InternalVideoGen.g:1176:1: ( 'optional' )
            // InternalVideoGen.g:1177:1: 'optional'
            {
             before(grammarAccess.getOptionalVideoSeqAccess().getOptionalKeyword_0()); 
            match(input,25,FOLLOW_2); 
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
    // InternalVideoGen.g:1190:1: rule__OptionalVideoSeq__Group__1 : rule__OptionalVideoSeq__Group__1__Impl ;
    public final void rule__OptionalVideoSeq__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:1194:1: ( rule__OptionalVideoSeq__Group__1__Impl )
            // InternalVideoGen.g:1195:2: rule__OptionalVideoSeq__Group__1__Impl
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
    // InternalVideoGen.g:1201:1: rule__OptionalVideoSeq__Group__1__Impl : ( ( rule__OptionalVideoSeq__DescriptionAssignment_1 ) ) ;
    public final void rule__OptionalVideoSeq__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:1205:1: ( ( ( rule__OptionalVideoSeq__DescriptionAssignment_1 ) ) )
            // InternalVideoGen.g:1206:1: ( ( rule__OptionalVideoSeq__DescriptionAssignment_1 ) )
            {
            // InternalVideoGen.g:1206:1: ( ( rule__OptionalVideoSeq__DescriptionAssignment_1 ) )
            // InternalVideoGen.g:1207:1: ( rule__OptionalVideoSeq__DescriptionAssignment_1 )
            {
             before(grammarAccess.getOptionalVideoSeqAccess().getDescriptionAssignment_1()); 
            // InternalVideoGen.g:1208:1: ( rule__OptionalVideoSeq__DescriptionAssignment_1 )
            // InternalVideoGen.g:1208:2: rule__OptionalVideoSeq__DescriptionAssignment_1
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
    // InternalVideoGen.g:1222:1: rule__AlternativeVideoSeq__Group__0 : rule__AlternativeVideoSeq__Group__0__Impl rule__AlternativeVideoSeq__Group__1 ;
    public final void rule__AlternativeVideoSeq__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:1226:1: ( rule__AlternativeVideoSeq__Group__0__Impl rule__AlternativeVideoSeq__Group__1 )
            // InternalVideoGen.g:1227:2: rule__AlternativeVideoSeq__Group__0__Impl rule__AlternativeVideoSeq__Group__1
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
    // InternalVideoGen.g:1234:1: rule__AlternativeVideoSeq__Group__0__Impl : ( 'alternatives' ) ;
    public final void rule__AlternativeVideoSeq__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:1238:1: ( ( 'alternatives' ) )
            // InternalVideoGen.g:1239:1: ( 'alternatives' )
            {
            // InternalVideoGen.g:1239:1: ( 'alternatives' )
            // InternalVideoGen.g:1240:1: 'alternatives'
            {
             before(grammarAccess.getAlternativeVideoSeqAccess().getAlternativesKeyword_0()); 
            match(input,26,FOLLOW_2); 
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
    // InternalVideoGen.g:1253:1: rule__AlternativeVideoSeq__Group__1 : rule__AlternativeVideoSeq__Group__1__Impl rule__AlternativeVideoSeq__Group__2 ;
    public final void rule__AlternativeVideoSeq__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:1257:1: ( rule__AlternativeVideoSeq__Group__1__Impl rule__AlternativeVideoSeq__Group__2 )
            // InternalVideoGen.g:1258:2: rule__AlternativeVideoSeq__Group__1__Impl rule__AlternativeVideoSeq__Group__2
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
    // InternalVideoGen.g:1265:1: rule__AlternativeVideoSeq__Group__1__Impl : ( ( rule__AlternativeVideoSeq__VideoidAssignment_1 )? ) ;
    public final void rule__AlternativeVideoSeq__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:1269:1: ( ( ( rule__AlternativeVideoSeq__VideoidAssignment_1 )? ) )
            // InternalVideoGen.g:1270:1: ( ( rule__AlternativeVideoSeq__VideoidAssignment_1 )? )
            {
            // InternalVideoGen.g:1270:1: ( ( rule__AlternativeVideoSeq__VideoidAssignment_1 )? )
            // InternalVideoGen.g:1271:1: ( rule__AlternativeVideoSeq__VideoidAssignment_1 )?
            {
             before(grammarAccess.getAlternativeVideoSeqAccess().getVideoidAssignment_1()); 
            // InternalVideoGen.g:1272:1: ( rule__AlternativeVideoSeq__VideoidAssignment_1 )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==RULE_ID) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // InternalVideoGen.g:1272:2: rule__AlternativeVideoSeq__VideoidAssignment_1
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
    // InternalVideoGen.g:1282:1: rule__AlternativeVideoSeq__Group__2 : rule__AlternativeVideoSeq__Group__2__Impl rule__AlternativeVideoSeq__Group__3 ;
    public final void rule__AlternativeVideoSeq__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:1286:1: ( rule__AlternativeVideoSeq__Group__2__Impl rule__AlternativeVideoSeq__Group__3 )
            // InternalVideoGen.g:1287:2: rule__AlternativeVideoSeq__Group__2__Impl rule__AlternativeVideoSeq__Group__3
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
    // InternalVideoGen.g:1294:1: rule__AlternativeVideoSeq__Group__2__Impl : ( RULE_LEFT_BRACKET ) ;
    public final void rule__AlternativeVideoSeq__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:1298:1: ( ( RULE_LEFT_BRACKET ) )
            // InternalVideoGen.g:1299:1: ( RULE_LEFT_BRACKET )
            {
            // InternalVideoGen.g:1299:1: ( RULE_LEFT_BRACKET )
            // InternalVideoGen.g:1300:1: RULE_LEFT_BRACKET
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
    // InternalVideoGen.g:1311:1: rule__AlternativeVideoSeq__Group__3 : rule__AlternativeVideoSeq__Group__3__Impl rule__AlternativeVideoSeq__Group__4 ;
    public final void rule__AlternativeVideoSeq__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:1315:1: ( rule__AlternativeVideoSeq__Group__3__Impl rule__AlternativeVideoSeq__Group__4 )
            // InternalVideoGen.g:1316:2: rule__AlternativeVideoSeq__Group__3__Impl rule__AlternativeVideoSeq__Group__4
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
    // InternalVideoGen.g:1323:1: rule__AlternativeVideoSeq__Group__3__Impl : ( ( ( rule__AlternativeVideoSeq__VideodescsAssignment_3 ) ) ( ( rule__AlternativeVideoSeq__VideodescsAssignment_3 )* ) ) ;
    public final void rule__AlternativeVideoSeq__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:1327:1: ( ( ( ( rule__AlternativeVideoSeq__VideodescsAssignment_3 ) ) ( ( rule__AlternativeVideoSeq__VideodescsAssignment_3 )* ) ) )
            // InternalVideoGen.g:1328:1: ( ( ( rule__AlternativeVideoSeq__VideodescsAssignment_3 ) ) ( ( rule__AlternativeVideoSeq__VideodescsAssignment_3 )* ) )
            {
            // InternalVideoGen.g:1328:1: ( ( ( rule__AlternativeVideoSeq__VideodescsAssignment_3 ) ) ( ( rule__AlternativeVideoSeq__VideodescsAssignment_3 )* ) )
            // InternalVideoGen.g:1329:1: ( ( rule__AlternativeVideoSeq__VideodescsAssignment_3 ) ) ( ( rule__AlternativeVideoSeq__VideodescsAssignment_3 )* )
            {
            // InternalVideoGen.g:1329:1: ( ( rule__AlternativeVideoSeq__VideodescsAssignment_3 ) )
            // InternalVideoGen.g:1330:1: ( rule__AlternativeVideoSeq__VideodescsAssignment_3 )
            {
             before(grammarAccess.getAlternativeVideoSeqAccess().getVideodescsAssignment_3()); 
            // InternalVideoGen.g:1331:1: ( rule__AlternativeVideoSeq__VideodescsAssignment_3 )
            // InternalVideoGen.g:1331:2: rule__AlternativeVideoSeq__VideodescsAssignment_3
            {
            pushFollow(FOLLOW_13);
            rule__AlternativeVideoSeq__VideodescsAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getAlternativeVideoSeqAccess().getVideodescsAssignment_3()); 

            }

            // InternalVideoGen.g:1334:1: ( ( rule__AlternativeVideoSeq__VideodescsAssignment_3 )* )
            // InternalVideoGen.g:1335:1: ( rule__AlternativeVideoSeq__VideodescsAssignment_3 )*
            {
             before(grammarAccess.getAlternativeVideoSeqAccess().getVideodescsAssignment_3()); 
            // InternalVideoGen.g:1336:1: ( rule__AlternativeVideoSeq__VideodescsAssignment_3 )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==27) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // InternalVideoGen.g:1336:2: rule__AlternativeVideoSeq__VideodescsAssignment_3
            	    {
            	    pushFollow(FOLLOW_13);
            	    rule__AlternativeVideoSeq__VideodescsAssignment_3();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop10;
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
    // InternalVideoGen.g:1347:1: rule__AlternativeVideoSeq__Group__4 : rule__AlternativeVideoSeq__Group__4__Impl ;
    public final void rule__AlternativeVideoSeq__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:1351:1: ( rule__AlternativeVideoSeq__Group__4__Impl )
            // InternalVideoGen.g:1352:2: rule__AlternativeVideoSeq__Group__4__Impl
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
    // InternalVideoGen.g:1358:1: rule__AlternativeVideoSeq__Group__4__Impl : ( RULE_RIGHT_BRACKET ) ;
    public final void rule__AlternativeVideoSeq__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:1362:1: ( ( RULE_RIGHT_BRACKET ) )
            // InternalVideoGen.g:1363:1: ( RULE_RIGHT_BRACKET )
            {
            // InternalVideoGen.g:1363:1: ( RULE_RIGHT_BRACKET )
            // InternalVideoGen.g:1364:1: RULE_RIGHT_BRACKET
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
    // InternalVideoGen.g:1385:1: rule__VideoDescription__Group__0 : rule__VideoDescription__Group__0__Impl rule__VideoDescription__Group__1 ;
    public final void rule__VideoDescription__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:1389:1: ( rule__VideoDescription__Group__0__Impl rule__VideoDescription__Group__1 )
            // InternalVideoGen.g:1390:2: rule__VideoDescription__Group__0__Impl rule__VideoDescription__Group__1
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
    // InternalVideoGen.g:1397:1: rule__VideoDescription__Group__0__Impl : ( 'videoseq' ) ;
    public final void rule__VideoDescription__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:1401:1: ( ( 'videoseq' ) )
            // InternalVideoGen.g:1402:1: ( 'videoseq' )
            {
            // InternalVideoGen.g:1402:1: ( 'videoseq' )
            // InternalVideoGen.g:1403:1: 'videoseq'
            {
             before(grammarAccess.getVideoDescriptionAccess().getVideoseqKeyword_0()); 
            match(input,27,FOLLOW_2); 
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
    // InternalVideoGen.g:1416:1: rule__VideoDescription__Group__1 : rule__VideoDescription__Group__1__Impl rule__VideoDescription__Group__2 ;
    public final void rule__VideoDescription__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:1420:1: ( rule__VideoDescription__Group__1__Impl rule__VideoDescription__Group__2 )
            // InternalVideoGen.g:1421:2: rule__VideoDescription__Group__1__Impl rule__VideoDescription__Group__2
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
    // InternalVideoGen.g:1428:1: rule__VideoDescription__Group__1__Impl : ( ( rule__VideoDescription__VideoidAssignment_1 )? ) ;
    public final void rule__VideoDescription__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:1432:1: ( ( ( rule__VideoDescription__VideoidAssignment_1 )? ) )
            // InternalVideoGen.g:1433:1: ( ( rule__VideoDescription__VideoidAssignment_1 )? )
            {
            // InternalVideoGen.g:1433:1: ( ( rule__VideoDescription__VideoidAssignment_1 )? )
            // InternalVideoGen.g:1434:1: ( rule__VideoDescription__VideoidAssignment_1 )?
            {
             before(grammarAccess.getVideoDescriptionAccess().getVideoidAssignment_1()); 
            // InternalVideoGen.g:1435:1: ( rule__VideoDescription__VideoidAssignment_1 )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==RULE_ID) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // InternalVideoGen.g:1435:2: rule__VideoDescription__VideoidAssignment_1
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
    // InternalVideoGen.g:1445:1: rule__VideoDescription__Group__2 : rule__VideoDescription__Group__2__Impl rule__VideoDescription__Group__3 ;
    public final void rule__VideoDescription__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:1449:1: ( rule__VideoDescription__Group__2__Impl rule__VideoDescription__Group__3 )
            // InternalVideoGen.g:1450:2: rule__VideoDescription__Group__2__Impl rule__VideoDescription__Group__3
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
    // InternalVideoGen.g:1457:1: rule__VideoDescription__Group__2__Impl : ( ( rule__VideoDescription__LocationAssignment_2 ) ) ;
    public final void rule__VideoDescription__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:1461:1: ( ( ( rule__VideoDescription__LocationAssignment_2 ) ) )
            // InternalVideoGen.g:1462:1: ( ( rule__VideoDescription__LocationAssignment_2 ) )
            {
            // InternalVideoGen.g:1462:1: ( ( rule__VideoDescription__LocationAssignment_2 ) )
            // InternalVideoGen.g:1463:1: ( rule__VideoDescription__LocationAssignment_2 )
            {
             before(grammarAccess.getVideoDescriptionAccess().getLocationAssignment_2()); 
            // InternalVideoGen.g:1464:1: ( rule__VideoDescription__LocationAssignment_2 )
            // InternalVideoGen.g:1464:2: rule__VideoDescription__LocationAssignment_2
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
    // InternalVideoGen.g:1474:1: rule__VideoDescription__Group__3 : rule__VideoDescription__Group__3__Impl ;
    public final void rule__VideoDescription__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:1478:1: ( rule__VideoDescription__Group__3__Impl )
            // InternalVideoGen.g:1479:2: rule__VideoDescription__Group__3__Impl
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
    // InternalVideoGen.g:1485:1: rule__VideoDescription__Group__3__Impl : ( ( rule__VideoDescription__Group_3__0 )? ) ;
    public final void rule__VideoDescription__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:1489:1: ( ( ( rule__VideoDescription__Group_3__0 )? ) )
            // InternalVideoGen.g:1490:1: ( ( rule__VideoDescription__Group_3__0 )? )
            {
            // InternalVideoGen.g:1490:1: ( ( rule__VideoDescription__Group_3__0 )? )
            // InternalVideoGen.g:1491:1: ( rule__VideoDescription__Group_3__0 )?
            {
             before(grammarAccess.getVideoDescriptionAccess().getGroup_3()); 
            // InternalVideoGen.g:1492:1: ( rule__VideoDescription__Group_3__0 )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==RULE_LEFT_BRACKET) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // InternalVideoGen.g:1492:2: rule__VideoDescription__Group_3__0
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
    // InternalVideoGen.g:1510:1: rule__VideoDescription__Group_3__0 : rule__VideoDescription__Group_3__0__Impl rule__VideoDescription__Group_3__1 ;
    public final void rule__VideoDescription__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:1514:1: ( rule__VideoDescription__Group_3__0__Impl rule__VideoDescription__Group_3__1 )
            // InternalVideoGen.g:1515:2: rule__VideoDescription__Group_3__0__Impl rule__VideoDescription__Group_3__1
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
    // InternalVideoGen.g:1522:1: rule__VideoDescription__Group_3__0__Impl : ( RULE_LEFT_BRACKET ) ;
    public final void rule__VideoDescription__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:1526:1: ( ( RULE_LEFT_BRACKET ) )
            // InternalVideoGen.g:1527:1: ( RULE_LEFT_BRACKET )
            {
            // InternalVideoGen.g:1527:1: ( RULE_LEFT_BRACKET )
            // InternalVideoGen.g:1528:1: RULE_LEFT_BRACKET
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
    // InternalVideoGen.g:1539:1: rule__VideoDescription__Group_3__1 : rule__VideoDescription__Group_3__1__Impl rule__VideoDescription__Group_3__2 ;
    public final void rule__VideoDescription__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:1543:1: ( rule__VideoDescription__Group_3__1__Impl rule__VideoDescription__Group_3__2 )
            // InternalVideoGen.g:1544:2: rule__VideoDescription__Group_3__1__Impl rule__VideoDescription__Group_3__2
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
    // InternalVideoGen.g:1551:1: rule__VideoDescription__Group_3__1__Impl : ( ( rule__VideoDescription__Group_3_1__0 )? ) ;
    public final void rule__VideoDescription__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:1555:1: ( ( ( rule__VideoDescription__Group_3_1__0 )? ) )
            // InternalVideoGen.g:1556:1: ( ( rule__VideoDescription__Group_3_1__0 )? )
            {
            // InternalVideoGen.g:1556:1: ( ( rule__VideoDescription__Group_3_1__0 )? )
            // InternalVideoGen.g:1557:1: ( rule__VideoDescription__Group_3_1__0 )?
            {
             before(grammarAccess.getVideoDescriptionAccess().getGroup_3_1()); 
            // InternalVideoGen.g:1558:1: ( rule__VideoDescription__Group_3_1__0 )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==28) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // InternalVideoGen.g:1558:2: rule__VideoDescription__Group_3_1__0
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
    // InternalVideoGen.g:1568:1: rule__VideoDescription__Group_3__2 : rule__VideoDescription__Group_3__2__Impl rule__VideoDescription__Group_3__3 ;
    public final void rule__VideoDescription__Group_3__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:1572:1: ( rule__VideoDescription__Group_3__2__Impl rule__VideoDescription__Group_3__3 )
            // InternalVideoGen.g:1573:2: rule__VideoDescription__Group_3__2__Impl rule__VideoDescription__Group_3__3
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
    // InternalVideoGen.g:1580:1: rule__VideoDescription__Group_3__2__Impl : ( ( rule__VideoDescription__Group_3_2__0 )? ) ;
    public final void rule__VideoDescription__Group_3__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:1584:1: ( ( ( rule__VideoDescription__Group_3_2__0 )? ) )
            // InternalVideoGen.g:1585:1: ( ( rule__VideoDescription__Group_3_2__0 )? )
            {
            // InternalVideoGen.g:1585:1: ( ( rule__VideoDescription__Group_3_2__0 )? )
            // InternalVideoGen.g:1586:1: ( rule__VideoDescription__Group_3_2__0 )?
            {
             before(grammarAccess.getVideoDescriptionAccess().getGroup_3_2()); 
            // InternalVideoGen.g:1587:1: ( rule__VideoDescription__Group_3_2__0 )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==29) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // InternalVideoGen.g:1587:2: rule__VideoDescription__Group_3_2__0
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
    // InternalVideoGen.g:1597:1: rule__VideoDescription__Group_3__3 : rule__VideoDescription__Group_3__3__Impl rule__VideoDescription__Group_3__4 ;
    public final void rule__VideoDescription__Group_3__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:1601:1: ( rule__VideoDescription__Group_3__3__Impl rule__VideoDescription__Group_3__4 )
            // InternalVideoGen.g:1602:2: rule__VideoDescription__Group_3__3__Impl rule__VideoDescription__Group_3__4
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
    // InternalVideoGen.g:1609:1: rule__VideoDescription__Group_3__3__Impl : ( ( rule__VideoDescription__Group_3_3__0 )? ) ;
    public final void rule__VideoDescription__Group_3__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:1613:1: ( ( ( rule__VideoDescription__Group_3_3__0 )? ) )
            // InternalVideoGen.g:1614:1: ( ( rule__VideoDescription__Group_3_3__0 )? )
            {
            // InternalVideoGen.g:1614:1: ( ( rule__VideoDescription__Group_3_3__0 )? )
            // InternalVideoGen.g:1615:1: ( rule__VideoDescription__Group_3_3__0 )?
            {
             before(grammarAccess.getVideoDescriptionAccess().getGroup_3_3()); 
            // InternalVideoGen.g:1616:1: ( rule__VideoDescription__Group_3_3__0 )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==30) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // InternalVideoGen.g:1616:2: rule__VideoDescription__Group_3_3__0
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
    // InternalVideoGen.g:1626:1: rule__VideoDescription__Group_3__4 : rule__VideoDescription__Group_3__4__Impl rule__VideoDescription__Group_3__5 ;
    public final void rule__VideoDescription__Group_3__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:1630:1: ( rule__VideoDescription__Group_3__4__Impl rule__VideoDescription__Group_3__5 )
            // InternalVideoGen.g:1631:2: rule__VideoDescription__Group_3__4__Impl rule__VideoDescription__Group_3__5
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
    // InternalVideoGen.g:1638:1: rule__VideoDescription__Group_3__4__Impl : ( ( rule__VideoDescription__Group_3_4__0 )? ) ;
    public final void rule__VideoDescription__Group_3__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:1642:1: ( ( ( rule__VideoDescription__Group_3_4__0 )? ) )
            // InternalVideoGen.g:1643:1: ( ( rule__VideoDescription__Group_3_4__0 )? )
            {
            // InternalVideoGen.g:1643:1: ( ( rule__VideoDescription__Group_3_4__0 )? )
            // InternalVideoGen.g:1644:1: ( rule__VideoDescription__Group_3_4__0 )?
            {
             before(grammarAccess.getVideoDescriptionAccess().getGroup_3_4()); 
            // InternalVideoGen.g:1645:1: ( rule__VideoDescription__Group_3_4__0 )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==31) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // InternalVideoGen.g:1645:2: rule__VideoDescription__Group_3_4__0
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
    // InternalVideoGen.g:1655:1: rule__VideoDescription__Group_3__5 : rule__VideoDescription__Group_3__5__Impl rule__VideoDescription__Group_3__6 ;
    public final void rule__VideoDescription__Group_3__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:1659:1: ( rule__VideoDescription__Group_3__5__Impl rule__VideoDescription__Group_3__6 )
            // InternalVideoGen.g:1660:2: rule__VideoDescription__Group_3__5__Impl rule__VideoDescription__Group_3__6
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
    // InternalVideoGen.g:1667:1: rule__VideoDescription__Group_3__5__Impl : ( ( rule__VideoDescription__Group_3_5__0 )? ) ;
    public final void rule__VideoDescription__Group_3__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:1671:1: ( ( ( rule__VideoDescription__Group_3_5__0 )? ) )
            // InternalVideoGen.g:1672:1: ( ( rule__VideoDescription__Group_3_5__0 )? )
            {
            // InternalVideoGen.g:1672:1: ( ( rule__VideoDescription__Group_3_5__0 )? )
            // InternalVideoGen.g:1673:1: ( rule__VideoDescription__Group_3_5__0 )?
            {
             before(grammarAccess.getVideoDescriptionAccess().getGroup_3_5()); 
            // InternalVideoGen.g:1674:1: ( rule__VideoDescription__Group_3_5__0 )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==32) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // InternalVideoGen.g:1674:2: rule__VideoDescription__Group_3_5__0
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
    // InternalVideoGen.g:1684:1: rule__VideoDescription__Group_3__6 : rule__VideoDescription__Group_3__6__Impl rule__VideoDescription__Group_3__7 ;
    public final void rule__VideoDescription__Group_3__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:1688:1: ( rule__VideoDescription__Group_3__6__Impl rule__VideoDescription__Group_3__7 )
            // InternalVideoGen.g:1689:2: rule__VideoDescription__Group_3__6__Impl rule__VideoDescription__Group_3__7
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
    // InternalVideoGen.g:1696:1: rule__VideoDescription__Group_3__6__Impl : ( ( rule__VideoDescription__Group_3_6__0 )? ) ;
    public final void rule__VideoDescription__Group_3__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:1700:1: ( ( ( rule__VideoDescription__Group_3_6__0 )? ) )
            // InternalVideoGen.g:1701:1: ( ( rule__VideoDescription__Group_3_6__0 )? )
            {
            // InternalVideoGen.g:1701:1: ( ( rule__VideoDescription__Group_3_6__0 )? )
            // InternalVideoGen.g:1702:1: ( rule__VideoDescription__Group_3_6__0 )?
            {
             before(grammarAccess.getVideoDescriptionAccess().getGroup_3_6()); 
            // InternalVideoGen.g:1703:1: ( rule__VideoDescription__Group_3_6__0 )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==33) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // InternalVideoGen.g:1703:2: rule__VideoDescription__Group_3_6__0
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
    // InternalVideoGen.g:1713:1: rule__VideoDescription__Group_3__7 : rule__VideoDescription__Group_3__7__Impl rule__VideoDescription__Group_3__8 ;
    public final void rule__VideoDescription__Group_3__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:1717:1: ( rule__VideoDescription__Group_3__7__Impl rule__VideoDescription__Group_3__8 )
            // InternalVideoGen.g:1718:2: rule__VideoDescription__Group_3__7__Impl rule__VideoDescription__Group_3__8
            {
            pushFollow(FOLLOW_15);
            rule__VideoDescription__Group_3__7__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__VideoDescription__Group_3__8();

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
    // InternalVideoGen.g:1725:1: rule__VideoDescription__Group_3__7__Impl : ( ( rule__VideoDescription__Group_3_7__0 )? ) ;
    public final void rule__VideoDescription__Group_3__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:1729:1: ( ( ( rule__VideoDescription__Group_3_7__0 )? ) )
            // InternalVideoGen.g:1730:1: ( ( rule__VideoDescription__Group_3_7__0 )? )
            {
            // InternalVideoGen.g:1730:1: ( ( rule__VideoDescription__Group_3_7__0 )? )
            // InternalVideoGen.g:1731:1: ( rule__VideoDescription__Group_3_7__0 )?
            {
             before(grammarAccess.getVideoDescriptionAccess().getGroup_3_7()); 
            // InternalVideoGen.g:1732:1: ( rule__VideoDescription__Group_3_7__0 )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==34) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // InternalVideoGen.g:1732:2: rule__VideoDescription__Group_3_7__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__VideoDescription__Group_3_7__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getVideoDescriptionAccess().getGroup_3_7()); 

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


    // $ANTLR start "rule__VideoDescription__Group_3__8"
    // InternalVideoGen.g:1742:1: rule__VideoDescription__Group_3__8 : rule__VideoDescription__Group_3__8__Impl rule__VideoDescription__Group_3__9 ;
    public final void rule__VideoDescription__Group_3__8() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:1746:1: ( rule__VideoDescription__Group_3__8__Impl rule__VideoDescription__Group_3__9 )
            // InternalVideoGen.g:1747:2: rule__VideoDescription__Group_3__8__Impl rule__VideoDescription__Group_3__9
            {
            pushFollow(FOLLOW_15);
            rule__VideoDescription__Group_3__8__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__VideoDescription__Group_3__9();

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
    // $ANTLR end "rule__VideoDescription__Group_3__8"


    // $ANTLR start "rule__VideoDescription__Group_3__8__Impl"
    // InternalVideoGen.g:1754:1: rule__VideoDescription__Group_3__8__Impl : ( ( rule__VideoDescription__Group_3_8__0 )? ) ;
    public final void rule__VideoDescription__Group_3__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:1758:1: ( ( ( rule__VideoDescription__Group_3_8__0 )? ) )
            // InternalVideoGen.g:1759:1: ( ( rule__VideoDescription__Group_3_8__0 )? )
            {
            // InternalVideoGen.g:1759:1: ( ( rule__VideoDescription__Group_3_8__0 )? )
            // InternalVideoGen.g:1760:1: ( rule__VideoDescription__Group_3_8__0 )?
            {
             before(grammarAccess.getVideoDescriptionAccess().getGroup_3_8()); 
            // InternalVideoGen.g:1761:1: ( rule__VideoDescription__Group_3_8__0 )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==35) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // InternalVideoGen.g:1761:2: rule__VideoDescription__Group_3_8__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__VideoDescription__Group_3_8__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getVideoDescriptionAccess().getGroup_3_8()); 

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
    // $ANTLR end "rule__VideoDescription__Group_3__8__Impl"


    // $ANTLR start "rule__VideoDescription__Group_3__9"
    // InternalVideoGen.g:1771:1: rule__VideoDescription__Group_3__9 : rule__VideoDescription__Group_3__9__Impl ;
    public final void rule__VideoDescription__Group_3__9() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:1775:1: ( rule__VideoDescription__Group_3__9__Impl )
            // InternalVideoGen.g:1776:2: rule__VideoDescription__Group_3__9__Impl
            {
            pushFollow(FOLLOW_2);
            rule__VideoDescription__Group_3__9__Impl();

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
    // $ANTLR end "rule__VideoDescription__Group_3__9"


    // $ANTLR start "rule__VideoDescription__Group_3__9__Impl"
    // InternalVideoGen.g:1782:1: rule__VideoDescription__Group_3__9__Impl : ( RULE_RIGHT_BRACKET ) ;
    public final void rule__VideoDescription__Group_3__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:1786:1: ( ( RULE_RIGHT_BRACKET ) )
            // InternalVideoGen.g:1787:1: ( RULE_RIGHT_BRACKET )
            {
            // InternalVideoGen.g:1787:1: ( RULE_RIGHT_BRACKET )
            // InternalVideoGen.g:1788:1: RULE_RIGHT_BRACKET
            {
             before(grammarAccess.getVideoDescriptionAccess().getRIGHT_BRACKETTerminalRuleCall_3_9()); 
            match(input,RULE_RIGHT_BRACKET,FOLLOW_2); 
             after(grammarAccess.getVideoDescriptionAccess().getRIGHT_BRACKETTerminalRuleCall_3_9()); 
=======
>>>>>>> e529713dc2ce4273a0bbf2a0634beb68235d51ef

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
    // $ANTLR end "rule__VideoDescription__Group_3__9__Impl"


    // $ANTLR start "rule__VideoDescription__Group_3_1__0"
    // InternalVideoGen.g:1819:1: rule__VideoDescription__Group_3_1__0 : rule__VideoDescription__Group_3_1__0__Impl rule__VideoDescription__Group_3_1__1 ;
    public final void rule__VideoDescription__Group_3_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:1823:1: ( rule__VideoDescription__Group_3_1__0__Impl rule__VideoDescription__Group_3_1__1 )
            // InternalVideoGen.g:1824:2: rule__VideoDescription__Group_3_1__0__Impl rule__VideoDescription__Group_3_1__1
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
    // InternalVideoGen.g:1831:1: rule__VideoDescription__Group_3_1__0__Impl : ( 'duration' ) ;
    public final void rule__VideoDescription__Group_3_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:1835:1: ( ( 'duration' ) )
            // InternalVideoGen.g:1836:1: ( 'duration' )
            {
            // InternalVideoGen.g:1836:1: ( 'duration' )
            // InternalVideoGen.g:1837:1: 'duration'
            {
             before(grammarAccess.getVideoDescriptionAccess().getDurationKeyword_3_1_0()); 
            match(input,28,FOLLOW_2); 
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
    // InternalVideoGen.g:1850:1: rule__VideoDescription__Group_3_1__1 : rule__VideoDescription__Group_3_1__1__Impl ;
    public final void rule__VideoDescription__Group_3_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:1854:1: ( rule__VideoDescription__Group_3_1__1__Impl )
            // InternalVideoGen.g:1855:2: rule__VideoDescription__Group_3_1__1__Impl
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
    // InternalVideoGen.g:1861:1: rule__VideoDescription__Group_3_1__1__Impl : ( ( rule__VideoDescription__DurationAssignment_3_1_1 ) ) ;
    public final void rule__VideoDescription__Group_3_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:1865:1: ( ( ( rule__VideoDescription__DurationAssignment_3_1_1 ) ) )
            // InternalVideoGen.g:1866:1: ( ( rule__VideoDescription__DurationAssignment_3_1_1 ) )
            {
            // InternalVideoGen.g:1866:1: ( ( rule__VideoDescription__DurationAssignment_3_1_1 ) )
            // InternalVideoGen.g:1867:1: ( rule__VideoDescription__DurationAssignment_3_1_1 )
            {
             before(grammarAccess.getVideoDescriptionAccess().getDurationAssignment_3_1_1()); 
            // InternalVideoGen.g:1868:1: ( rule__VideoDescription__DurationAssignment_3_1_1 )
            // InternalVideoGen.g:1868:2: rule__VideoDescription__DurationAssignment_3_1_1
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
    // InternalVideoGen.g:1882:1: rule__VideoDescription__Group_3_2__0 : rule__VideoDescription__Group_3_2__0__Impl rule__VideoDescription__Group_3_2__1 ;
    public final void rule__VideoDescription__Group_3_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:1886:1: ( rule__VideoDescription__Group_3_2__0__Impl rule__VideoDescription__Group_3_2__1 )
            // InternalVideoGen.g:1887:2: rule__VideoDescription__Group_3_2__0__Impl rule__VideoDescription__Group_3_2__1
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
    // InternalVideoGen.g:1894:1: rule__VideoDescription__Group_3_2__0__Impl : ( 'probability' ) ;
    public final void rule__VideoDescription__Group_3_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:1898:1: ( ( 'probability' ) )
            // InternalVideoGen.g:1899:1: ( 'probability' )
            {
            // InternalVideoGen.g:1899:1: ( 'probability' )
            // InternalVideoGen.g:1900:1: 'probability'
            {
             before(grammarAccess.getVideoDescriptionAccess().getProbabilityKeyword_3_2_0()); 
            match(input,29,FOLLOW_2); 
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
    // InternalVideoGen.g:1913:1: rule__VideoDescription__Group_3_2__1 : rule__VideoDescription__Group_3_2__1__Impl ;
    public final void rule__VideoDescription__Group_3_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:1917:1: ( rule__VideoDescription__Group_3_2__1__Impl )
            // InternalVideoGen.g:1918:2: rule__VideoDescription__Group_3_2__1__Impl
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
    // InternalVideoGen.g:1924:1: rule__VideoDescription__Group_3_2__1__Impl : ( ( rule__VideoDescription__ProbabilityAssignment_3_2_1 ) ) ;
    public final void rule__VideoDescription__Group_3_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:1928:1: ( ( ( rule__VideoDescription__ProbabilityAssignment_3_2_1 ) ) )
            // InternalVideoGen.g:1929:1: ( ( rule__VideoDescription__ProbabilityAssignment_3_2_1 ) )
            {
            // InternalVideoGen.g:1929:1: ( ( rule__VideoDescription__ProbabilityAssignment_3_2_1 ) )
            // InternalVideoGen.g:1930:1: ( rule__VideoDescription__ProbabilityAssignment_3_2_1 )
            {
             before(grammarAccess.getVideoDescriptionAccess().getProbabilityAssignment_3_2_1()); 
            // InternalVideoGen.g:1931:1: ( rule__VideoDescription__ProbabilityAssignment_3_2_1 )
            // InternalVideoGen.g:1931:2: rule__VideoDescription__ProbabilityAssignment_3_2_1
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
    // InternalVideoGen.g:1945:1: rule__VideoDescription__Group_3_3__0 : rule__VideoDescription__Group_3_3__0__Impl rule__VideoDescription__Group_3_3__1 ;
    public final void rule__VideoDescription__Group_3_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:1949:1: ( rule__VideoDescription__Group_3_3__0__Impl rule__VideoDescription__Group_3_3__1 )
            // InternalVideoGen.g:1950:2: rule__VideoDescription__Group_3_3__0__Impl rule__VideoDescription__Group_3_3__1
            {
            pushFollow(FOLLOW_10);
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
    // InternalVideoGen.g:1957:1: rule__VideoDescription__Group_3_3__0__Impl : ( 'textIncrust' ) ;
    public final void rule__VideoDescription__Group_3_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:1961:1: ( ( 'textIncrust' ) )
            // InternalVideoGen.g:1962:1: ( 'textIncrust' )
            {
            // InternalVideoGen.g:1962:1: ( 'textIncrust' )
            // InternalVideoGen.g:1963:1: 'textIncrust'
            {
             before(grammarAccess.getVideoDescriptionAccess().getTextIncrustKeyword_3_3_0()); 
            match(input,30,FOLLOW_2); 
             after(grammarAccess.getVideoDescriptionAccess().getTextIncrustKeyword_3_3_0()); 

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
    // InternalVideoGen.g:1976:1: rule__VideoDescription__Group_3_3__1 : rule__VideoDescription__Group_3_3__1__Impl ;
    public final void rule__VideoDescription__Group_3_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:1980:1: ( rule__VideoDescription__Group_3_3__1__Impl )
            // InternalVideoGen.g:1981:2: rule__VideoDescription__Group_3_3__1__Impl
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
    // InternalVideoGen.g:1987:1: rule__VideoDescription__Group_3_3__1__Impl : ( ( rule__VideoDescription__TextIncrustAssignment_3_3_1 ) ) ;
    public final void rule__VideoDescription__Group_3_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:1991:1: ( ( ( rule__VideoDescription__TextIncrustAssignment_3_3_1 ) ) )
            // InternalVideoGen.g:1992:1: ( ( rule__VideoDescription__TextIncrustAssignment_3_3_1 ) )
            {
            // InternalVideoGen.g:1992:1: ( ( rule__VideoDescription__TextIncrustAssignment_3_3_1 ) )
            // InternalVideoGen.g:1993:1: ( rule__VideoDescription__TextIncrustAssignment_3_3_1 )
            {
<<<<<<< HEAD
             before(grammarAccess.getVideoDescriptionAccess().getTextIncrustAssignment_3_3_1()); 
            // InternalVideoGen.g:1994:1: ( rule__VideoDescription__TextIncrustAssignment_3_3_1 )
            // InternalVideoGen.g:1994:2: rule__VideoDescription__TextIncrustAssignment_3_3_1
            {
            pushFollow(FOLLOW_2);
            rule__VideoDescription__TextIncrustAssignment_3_3_1();
=======
             before(grammarAccess.getVideoGeneratorModelAccess().getInformationAssignment_1()); 
            // InternalVideoGen.g:336:1: ( rule__VideoGeneratorModel__InformationAssignment_1 )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==16) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // InternalVideoGen.g:336:2: rule__VideoGeneratorModel__InformationAssignment_1
                    {
                    pushFollow(FOLLOW_2);
                    rule__VideoGeneratorModel__InformationAssignment_1();

                    state._fsp--;
>>>>>>> e529713dc2ce4273a0bbf2a0634beb68235d51ef

            state._fsp--;


            }

             after(grammarAccess.getVideoDescriptionAccess().getTextIncrustAssignment_3_3_1()); 

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
    // InternalVideoGen.g:2008:1: rule__VideoDescription__Group_3_4__0 : rule__VideoDescription__Group_3_4__0__Impl rule__VideoDescription__Group_3_4__1 ;
    public final void rule__VideoDescription__Group_3_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:2012:1: ( rule__VideoDescription__Group_3_4__0__Impl rule__VideoDescription__Group_3_4__1 )
            // InternalVideoGen.g:2013:2: rule__VideoDescription__Group_3_4__0__Impl rule__VideoDescription__Group_3_4__1
            {
            pushFollow(FOLLOW_16);
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
    // InternalVideoGen.g:2020:1: rule__VideoDescription__Group_3_4__0__Impl : ( 'size' ) ;
    public final void rule__VideoDescription__Group_3_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:2024:1: ( ( 'size' ) )
            // InternalVideoGen.g:2025:1: ( 'size' )
            {
            // InternalVideoGen.g:2025:1: ( 'size' )
            // InternalVideoGen.g:2026:1: 'size'
            {
<<<<<<< HEAD
             before(grammarAccess.getVideoDescriptionAccess().getSizeKeyword_3_4_0()); 
            match(input,31,FOLLOW_2); 
             after(grammarAccess.getVideoDescriptionAccess().getSizeKeyword_3_4_0()); 
=======
             before(grammarAccess.getVideoGeneratorModelAccess().getVideoGenKeyword_2()); 
            match(input,15,FOLLOW_2); 
             after(grammarAccess.getVideoGeneratorModelAccess().getVideoGenKeyword_2()); 
>>>>>>> e529713dc2ce4273a0bbf2a0634beb68235d51ef

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
    // InternalVideoGen.g:2039:1: rule__VideoDescription__Group_3_4__1 : rule__VideoDescription__Group_3_4__1__Impl ;
    public final void rule__VideoDescription__Group_3_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:2043:1: ( rule__VideoDescription__Group_3_4__1__Impl )
            // InternalVideoGen.g:2044:2: rule__VideoDescription__Group_3_4__1__Impl
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
    // InternalVideoGen.g:2050:1: rule__VideoDescription__Group_3_4__1__Impl : ( ( rule__VideoDescription__SizeAssignment_3_4_1 ) ) ;
    public final void rule__VideoDescription__Group_3_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:2054:1: ( ( ( rule__VideoDescription__SizeAssignment_3_4_1 ) ) )
            // InternalVideoGen.g:2055:1: ( ( rule__VideoDescription__SizeAssignment_3_4_1 ) )
            {
            // InternalVideoGen.g:2055:1: ( ( rule__VideoDescription__SizeAssignment_3_4_1 ) )
            // InternalVideoGen.g:2056:1: ( rule__VideoDescription__SizeAssignment_3_4_1 )
            {
             before(grammarAccess.getVideoDescriptionAccess().getSizeAssignment_3_4_1()); 
            // InternalVideoGen.g:2057:1: ( rule__VideoDescription__SizeAssignment_3_4_1 )
            // InternalVideoGen.g:2057:2: rule__VideoDescription__SizeAssignment_3_4_1
            {
            pushFollow(FOLLOW_2);
            rule__VideoDescription__SizeAssignment_3_4_1();

            state._fsp--;


            }

             after(grammarAccess.getVideoDescriptionAccess().getSizeAssignment_3_4_1()); 

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
    // InternalVideoGen.g:2071:1: rule__VideoDescription__Group_3_5__0 : rule__VideoDescription__Group_3_5__0__Impl rule__VideoDescription__Group_3_5__1 ;
    public final void rule__VideoDescription__Group_3_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:2075:1: ( rule__VideoDescription__Group_3_5__0__Impl rule__VideoDescription__Group_3_5__1 )
            // InternalVideoGen.g:2076:2: rule__VideoDescription__Group_3_5__0__Impl rule__VideoDescription__Group_3_5__1
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
    // InternalVideoGen.g:2083:1: rule__VideoDescription__Group_3_5__0__Impl : ( 'description' ) ;
    public final void rule__VideoDescription__Group_3_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:2087:1: ( ( 'description' ) )
            // InternalVideoGen.g:2088:1: ( 'description' )
            {
            // InternalVideoGen.g:2088:1: ( 'description' )
            // InternalVideoGen.g:2089:1: 'description'
            {
             before(grammarAccess.getVideoDescriptionAccess().getDescriptionKeyword_3_5_0()); 
            match(input,32,FOLLOW_2); 
             after(grammarAccess.getVideoDescriptionAccess().getDescriptionKeyword_3_5_0()); 

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
    // InternalVideoGen.g:2102:1: rule__VideoDescription__Group_3_5__1 : rule__VideoDescription__Group_3_5__1__Impl ;
    public final void rule__VideoDescription__Group_3_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:2106:1: ( rule__VideoDescription__Group_3_5__1__Impl )
            // InternalVideoGen.g:2107:2: rule__VideoDescription__Group_3_5__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__VideoDescription__Group_3_5__1__Impl();

<<<<<<< HEAD
            state._fsp--;
=======
                if ( ((LA3_0>=19 && LA3_0<=21)) ) {
                    alt3=1;
                }
>>>>>>> e529713dc2ce4273a0bbf2a0634beb68235d51ef


            }

        }
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
    // InternalVideoGen.g:2113:1: rule__VideoDescription__Group_3_5__1__Impl : ( ( rule__VideoDescription__DescriptionAssignment_3_5_1 ) ) ;
    public final void rule__VideoDescription__Group_3_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:2117:1: ( ( ( rule__VideoDescription__DescriptionAssignment_3_5_1 ) ) )
            // InternalVideoGen.g:2118:1: ( ( rule__VideoDescription__DescriptionAssignment_3_5_1 ) )
            {
            // InternalVideoGen.g:2118:1: ( ( rule__VideoDescription__DescriptionAssignment_3_5_1 ) )
            // InternalVideoGen.g:2119:1: ( rule__VideoDescription__DescriptionAssignment_3_5_1 )
            {
             before(grammarAccess.getVideoDescriptionAccess().getDescriptionAssignment_3_5_1()); 
            // InternalVideoGen.g:2120:1: ( rule__VideoDescription__DescriptionAssignment_3_5_1 )
            // InternalVideoGen.g:2120:2: rule__VideoDescription__DescriptionAssignment_3_5_1
            {
            pushFollow(FOLLOW_2);
            rule__VideoDescription__DescriptionAssignment_3_5_1();

            state._fsp--;


            }

             after(grammarAccess.getVideoDescriptionAccess().getDescriptionAssignment_3_5_1()); 

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
    // InternalVideoGen.g:2134:1: rule__VideoDescription__Group_3_6__0 : rule__VideoDescription__Group_3_6__0__Impl rule__VideoDescription__Group_3_6__1 ;
    public final void rule__VideoDescription__Group_3_6__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:2138:1: ( rule__VideoDescription__Group_3_6__0__Impl rule__VideoDescription__Group_3_6__1 )
            // InternalVideoGen.g:2139:2: rule__VideoDescription__Group_3_6__0__Impl rule__VideoDescription__Group_3_6__1
            {
            pushFollow(FOLLOW_17);
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
    // InternalVideoGen.g:2146:1: rule__VideoDescription__Group_3_6__0__Impl : ( 'subtitle' ) ;
    public final void rule__VideoDescription__Group_3_6__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:2150:1: ( ( 'subtitle' ) )
            // InternalVideoGen.g:2151:1: ( 'subtitle' )
            {
            // InternalVideoGen.g:2151:1: ( 'subtitle' )
            // InternalVideoGen.g:2152:1: 'subtitle'
            {
             before(grammarAccess.getVideoDescriptionAccess().getSubtitleKeyword_3_6_0()); 
            match(input,33,FOLLOW_2); 
             after(grammarAccess.getVideoDescriptionAccess().getSubtitleKeyword_3_6_0()); 

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
    // InternalVideoGen.g:2165:1: rule__VideoDescription__Group_3_6__1 : rule__VideoDescription__Group_3_6__1__Impl ;
    public final void rule__VideoDescription__Group_3_6__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:2169:1: ( rule__VideoDescription__Group_3_6__1__Impl )
            // InternalVideoGen.g:2170:2: rule__VideoDescription__Group_3_6__1__Impl
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
    // InternalVideoGen.g:2176:1: rule__VideoDescription__Group_3_6__1__Impl : ( ( rule__VideoDescription__SubtitleAssignment_3_6_1 ) ) ;
    public final void rule__VideoDescription__Group_3_6__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:2180:1: ( ( ( rule__VideoDescription__SubtitleAssignment_3_6_1 ) ) )
            // InternalVideoGen.g:2181:1: ( ( rule__VideoDescription__SubtitleAssignment_3_6_1 ) )
            {
            // InternalVideoGen.g:2181:1: ( ( rule__VideoDescription__SubtitleAssignment_3_6_1 ) )
            // InternalVideoGen.g:2182:1: ( rule__VideoDescription__SubtitleAssignment_3_6_1 )
            {
             before(grammarAccess.getVideoDescriptionAccess().getSubtitleAssignment_3_6_1()); 
            // InternalVideoGen.g:2183:1: ( rule__VideoDescription__SubtitleAssignment_3_6_1 )
            // InternalVideoGen.g:2183:2: rule__VideoDescription__SubtitleAssignment_3_6_1
            {
            pushFollow(FOLLOW_2);
            rule__VideoDescription__SubtitleAssignment_3_6_1();

            state._fsp--;


            }

             after(grammarAccess.getVideoDescriptionAccess().getSubtitleAssignment_3_6_1()); 

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


    // $ANTLR start "rule__VideoDescription__Group_3_7__0"
    // InternalVideoGen.g:2197:1: rule__VideoDescription__Group_3_7__0 : rule__VideoDescription__Group_3_7__0__Impl rule__VideoDescription__Group_3_7__1 ;
    public final void rule__VideoDescription__Group_3_7__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:2201:1: ( rule__VideoDescription__Group_3_7__0__Impl rule__VideoDescription__Group_3_7__1 )
            // InternalVideoGen.g:2202:2: rule__VideoDescription__Group_3_7__0__Impl rule__VideoDescription__Group_3_7__1
            {
            pushFollow(FOLLOW_4);
            rule__VideoDescription__Group_3_7__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__VideoDescription__Group_3_7__1();

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
    // $ANTLR end "rule__VideoDescription__Group_3_7__0"


    // $ANTLR start "rule__VideoDescription__Group_3_7__0__Impl"
    // InternalVideoGen.g:2209:1: rule__VideoDescription__Group_3_7__0__Impl : ( 'text' ) ;
    public final void rule__VideoDescription__Group_3_7__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:2213:1: ( ( 'text' ) )
            // InternalVideoGen.g:2214:1: ( 'text' )
            {
            // InternalVideoGen.g:2214:1: ( 'text' )
            // InternalVideoGen.g:2215:1: 'text'
            {
             before(grammarAccess.getVideoDescriptionAccess().getTextKeyword_3_7_0()); 
            match(input,34,FOLLOW_2); 
             after(grammarAccess.getVideoDescriptionAccess().getTextKeyword_3_7_0()); 

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
    // $ANTLR end "rule__VideoDescription__Group_3_7__0__Impl"


    // $ANTLR start "rule__VideoDescription__Group_3_7__1"
    // InternalVideoGen.g:2228:1: rule__VideoDescription__Group_3_7__1 : rule__VideoDescription__Group_3_7__1__Impl ;
    public final void rule__VideoDescription__Group_3_7__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:2232:1: ( rule__VideoDescription__Group_3_7__1__Impl )
            // InternalVideoGen.g:2233:2: rule__VideoDescription__Group_3_7__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__VideoDescription__Group_3_7__1__Impl();

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
    // $ANTLR end "rule__VideoDescription__Group_3_7__1"


    // $ANTLR start "rule__VideoDescription__Group_3_7__1__Impl"
    // InternalVideoGen.g:2239:1: rule__VideoDescription__Group_3_7__1__Impl : ( ( rule__VideoDescription__TextAssignment_3_7_1 ) ) ;
    public final void rule__VideoDescription__Group_3_7__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:2243:1: ( ( ( rule__VideoDescription__TextAssignment_3_7_1 ) ) )
            // InternalVideoGen.g:2244:1: ( ( rule__VideoDescription__TextAssignment_3_7_1 ) )
            {
            // InternalVideoGen.g:2244:1: ( ( rule__VideoDescription__TextAssignment_3_7_1 ) )
            // InternalVideoGen.g:2245:1: ( rule__VideoDescription__TextAssignment_3_7_1 )
            {
<<<<<<< HEAD
             before(grammarAccess.getVideoDescriptionAccess().getTextAssignment_3_7_1()); 
            // InternalVideoGen.g:2246:1: ( rule__VideoDescription__TextAssignment_3_7_1 )
            // InternalVideoGen.g:2246:2: rule__VideoDescription__TextAssignment_3_7_1
            {
            pushFollow(FOLLOW_2);
            rule__VideoDescription__TextAssignment_3_7_1();
=======
             before(grammarAccess.getVideoGenInformationAccess().getGroup_2()); 
            // InternalVideoGen.g:561:1: ( rule__VideoGenInformation__Group_2__0 )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==17) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // InternalVideoGen.g:561:2: rule__VideoGenInformation__Group_2__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__VideoGenInformation__Group_2__0();

                    state._fsp--;
>>>>>>> e529713dc2ce4273a0bbf2a0634beb68235d51ef

            state._fsp--;


            }

             after(grammarAccess.getVideoDescriptionAccess().getTextAssignment_3_7_1()); 

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
    // $ANTLR end "rule__VideoDescription__Group_3_7__1__Impl"


    // $ANTLR start "rule__VideoDescription__Group_3_8__0"
    // InternalVideoGen.g:2260:1: rule__VideoDescription__Group_3_8__0 : rule__VideoDescription__Group_3_8__0__Impl rule__VideoDescription__Group_3_8__1 ;
    public final void rule__VideoDescription__Group_3_8__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:2264:1: ( rule__VideoDescription__Group_3_8__0__Impl rule__VideoDescription__Group_3_8__1 )
            // InternalVideoGen.g:2265:2: rule__VideoDescription__Group_3_8__0__Impl rule__VideoDescription__Group_3_8__1
            {
            pushFollow(FOLLOW_18);
            rule__VideoDescription__Group_3_8__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__VideoDescription__Group_3_8__1();

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
    // $ANTLR end "rule__VideoDescription__Group_3_8__0"


    // $ANTLR start "rule__VideoDescription__Group_3_8__0__Impl"
    // InternalVideoGen.g:2272:1: rule__VideoDescription__Group_3_8__0__Impl : ( 'filter' ) ;
    public final void rule__VideoDescription__Group_3_8__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:2276:1: ( ( 'filter' ) )
            // InternalVideoGen.g:2277:1: ( 'filter' )
            {
            // InternalVideoGen.g:2277:1: ( 'filter' )
            // InternalVideoGen.g:2278:1: 'filter'
            {
<<<<<<< HEAD
             before(grammarAccess.getVideoDescriptionAccess().getFilterKeyword_3_8_0()); 
            match(input,35,FOLLOW_2); 
             after(grammarAccess.getVideoDescriptionAccess().getFilterKeyword_3_8_0()); 
=======
             before(grammarAccess.getVideoGenInformationAccess().getGroup_3()); 
            // InternalVideoGen.g:589:1: ( rule__VideoGenInformation__Group_3__0 )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==18) ) {
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
>>>>>>> e529713dc2ce4273a0bbf2a0634beb68235d51ef

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
    // $ANTLR end "rule__VideoDescription__Group_3_8__0__Impl"


    // $ANTLR start "rule__VideoDescription__Group_3_8__1"
    // InternalVideoGen.g:2291:1: rule__VideoDescription__Group_3_8__1 : rule__VideoDescription__Group_3_8__1__Impl ;
    public final void rule__VideoDescription__Group_3_8__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:2295:1: ( rule__VideoDescription__Group_3_8__1__Impl )
            // InternalVideoGen.g:2296:2: rule__VideoDescription__Group_3_8__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__VideoDescription__Group_3_8__1__Impl();

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
    // $ANTLR end "rule__VideoDescription__Group_3_8__1"


    // $ANTLR start "rule__VideoDescription__Group_3_8__1__Impl"
    // InternalVideoGen.g:2302:1: rule__VideoDescription__Group_3_8__1__Impl : ( ( rule__VideoDescription__FilterAssignment_3_8_1 ) ) ;
    public final void rule__VideoDescription__Group_3_8__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:2306:1: ( ( ( rule__VideoDescription__FilterAssignment_3_8_1 ) ) )
            // InternalVideoGen.g:2307:1: ( ( rule__VideoDescription__FilterAssignment_3_8_1 ) )
            {
            // InternalVideoGen.g:2307:1: ( ( rule__VideoDescription__FilterAssignment_3_8_1 ) )
            // InternalVideoGen.g:2308:1: ( rule__VideoDescription__FilterAssignment_3_8_1 )
            {
<<<<<<< HEAD
             before(grammarAccess.getVideoDescriptionAccess().getFilterAssignment_3_8_1()); 
            // InternalVideoGen.g:2309:1: ( rule__VideoDescription__FilterAssignment_3_8_1 )
            // InternalVideoGen.g:2309:2: rule__VideoDescription__FilterAssignment_3_8_1
            {
            pushFollow(FOLLOW_2);
            rule__VideoDescription__FilterAssignment_3_8_1();

            state._fsp--;


            }

             after(grammarAccess.getVideoDescriptionAccess().getFilterAssignment_3_8_1()); 
=======
             before(grammarAccess.getVideoGenInformationAccess().getAuthorKeyword_1_0()); 
            match(input,16,FOLLOW_2); 
             after(grammarAccess.getVideoGenInformationAccess().getAuthorKeyword_1_0()); 
>>>>>>> e529713dc2ce4273a0bbf2a0634beb68235d51ef

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
    // $ANTLR end "rule__VideoDescription__Group_3_8__1__Impl"


    // $ANTLR start "rule__Subtitle__Group__0"
    // InternalVideoGen.g:2323:1: rule__Subtitle__Group__0 : rule__Subtitle__Group__0__Impl rule__Subtitle__Group__1 ;
    public final void rule__Subtitle__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:2327:1: ( rule__Subtitle__Group__0__Impl rule__Subtitle__Group__1 )
            // InternalVideoGen.g:2328:2: rule__Subtitle__Group__0__Impl rule__Subtitle__Group__1
            {
            pushFollow(FOLLOW_10);
            rule__Subtitle__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Subtitle__Group__1();

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
    // $ANTLR end "rule__Subtitle__Group__0"


    // $ANTLR start "rule__Subtitle__Group__0__Impl"
    // InternalVideoGen.g:2335:1: rule__Subtitle__Group__0__Impl : ( 'subtitle' ) ;
    public final void rule__Subtitle__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:2339:1: ( ( 'subtitle' ) )
            // InternalVideoGen.g:2340:1: ( 'subtitle' )
            {
            // InternalVideoGen.g:2340:1: ( 'subtitle' )
            // InternalVideoGen.g:2341:1: 'subtitle'
            {
             before(grammarAccess.getSubtitleAccess().getSubtitleKeyword_0()); 
            match(input,33,FOLLOW_2); 
             after(grammarAccess.getSubtitleAccess().getSubtitleKeyword_0()); 

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
    // $ANTLR end "rule__Subtitle__Group__0__Impl"


    // $ANTLR start "rule__Subtitle__Group__1"
    // InternalVideoGen.g:2354:1: rule__Subtitle__Group__1 : rule__Subtitle__Group__1__Impl rule__Subtitle__Group__2 ;
    public final void rule__Subtitle__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:2358:1: ( rule__Subtitle__Group__1__Impl rule__Subtitle__Group__2 )
            // InternalVideoGen.g:2359:2: rule__Subtitle__Group__1__Impl rule__Subtitle__Group__2
            {
            pushFollow(FOLLOW_4);
            rule__Subtitle__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Subtitle__Group__2();

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
    // $ANTLR end "rule__Subtitle__Group__1"


    // $ANTLR start "rule__Subtitle__Group__1__Impl"
    // InternalVideoGen.g:2366:1: rule__Subtitle__Group__1__Impl : ( ( rule__Subtitle__TextAssignment_1 ) ) ;
    public final void rule__Subtitle__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:2370:1: ( ( ( rule__Subtitle__TextAssignment_1 ) ) )
            // InternalVideoGen.g:2371:1: ( ( rule__Subtitle__TextAssignment_1 ) )
            {
            // InternalVideoGen.g:2371:1: ( ( rule__Subtitle__TextAssignment_1 ) )
            // InternalVideoGen.g:2372:1: ( rule__Subtitle__TextAssignment_1 )
            {
<<<<<<< HEAD
             before(grammarAccess.getSubtitleAccess().getTextAssignment_1()); 
            // InternalVideoGen.g:2373:1: ( rule__Subtitle__TextAssignment_1 )
            // InternalVideoGen.g:2373:2: rule__Subtitle__TextAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__Subtitle__TextAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getSubtitleAccess().getTextAssignment_1()); 
=======
             before(grammarAccess.getVideoGenInformationAccess().getVersionKeyword_2_0()); 
            match(input,17,FOLLOW_2); 
             after(grammarAccess.getVideoGenInformationAccess().getVersionKeyword_2_0()); 
>>>>>>> e529713dc2ce4273a0bbf2a0634beb68235d51ef

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
    // $ANTLR end "rule__Subtitle__Group__1__Impl"


    // $ANTLR start "rule__Subtitle__Group__2"
    // InternalVideoGen.g:2383:1: rule__Subtitle__Group__2 : rule__Subtitle__Group__2__Impl ;
    public final void rule__Subtitle__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:2387:1: ( rule__Subtitle__Group__2__Impl )
            // InternalVideoGen.g:2388:2: rule__Subtitle__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Subtitle__Group__2__Impl();

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
    // $ANTLR end "rule__Subtitle__Group__2"


    // $ANTLR start "rule__Subtitle__Group__2__Impl"
    // InternalVideoGen.g:2394:1: rule__Subtitle__Group__2__Impl : ( ( rule__Subtitle__Group_2__0 )? ) ;
    public final void rule__Subtitle__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:2398:1: ( ( ( rule__Subtitle__Group_2__0 )? ) )
            // InternalVideoGen.g:2399:1: ( ( rule__Subtitle__Group_2__0 )? )
            {
            // InternalVideoGen.g:2399:1: ( ( rule__Subtitle__Group_2__0 )? )
            // InternalVideoGen.g:2400:1: ( rule__Subtitle__Group_2__0 )?
            {
             before(grammarAccess.getSubtitleAccess().getGroup_2()); 
            // InternalVideoGen.g:2401:1: ( rule__Subtitle__Group_2__0 )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==RULE_LEFT_BRACKET) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // InternalVideoGen.g:2401:2: rule__Subtitle__Group_2__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Subtitle__Group_2__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getSubtitleAccess().getGroup_2()); 

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
    // $ANTLR end "rule__Subtitle__Group__2__Impl"


    // $ANTLR start "rule__Subtitle__Group_2__0"
    // InternalVideoGen.g:2417:1: rule__Subtitle__Group_2__0 : rule__Subtitle__Group_2__0__Impl rule__Subtitle__Group_2__1 ;
    public final void rule__Subtitle__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:2421:1: ( rule__Subtitle__Group_2__0__Impl rule__Subtitle__Group_2__1 )
            // InternalVideoGen.g:2422:2: rule__Subtitle__Group_2__0__Impl rule__Subtitle__Group_2__1
            {
            pushFollow(FOLLOW_19);
            rule__Subtitle__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Subtitle__Group_2__1();

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
    // $ANTLR end "rule__Subtitle__Group_2__0"


    // $ANTLR start "rule__Subtitle__Group_2__0__Impl"
    // InternalVideoGen.g:2429:1: rule__Subtitle__Group_2__0__Impl : ( RULE_LEFT_BRACKET ) ;
    public final void rule__Subtitle__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:2433:1: ( ( RULE_LEFT_BRACKET ) )
            // InternalVideoGen.g:2434:1: ( RULE_LEFT_BRACKET )
            {
            // InternalVideoGen.g:2434:1: ( RULE_LEFT_BRACKET )
            // InternalVideoGen.g:2435:1: RULE_LEFT_BRACKET
            {
<<<<<<< HEAD
             before(grammarAccess.getSubtitleAccess().getLEFT_BRACKETTerminalRuleCall_2_0()); 
            match(input,RULE_LEFT_BRACKET,FOLLOW_2); 
             after(grammarAccess.getSubtitleAccess().getLEFT_BRACKETTerminalRuleCall_2_0()); 
=======
             before(grammarAccess.getVideoGenInformationAccess().getCreationKeyword_3_0()); 
            match(input,18,FOLLOW_2); 
             after(grammarAccess.getVideoGenInformationAccess().getCreationKeyword_3_0()); 
>>>>>>> e529713dc2ce4273a0bbf2a0634beb68235d51ef

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
    // $ANTLR end "rule__Subtitle__Group_2__0__Impl"


    // $ANTLR start "rule__Subtitle__Group_2__1"
    // InternalVideoGen.g:2446:1: rule__Subtitle__Group_2__1 : rule__Subtitle__Group_2__1__Impl rule__Subtitle__Group_2__2 ;
    public final void rule__Subtitle__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:2450:1: ( rule__Subtitle__Group_2__1__Impl rule__Subtitle__Group_2__2 )
            // InternalVideoGen.g:2451:2: rule__Subtitle__Group_2__1__Impl rule__Subtitle__Group_2__2
            {
            pushFollow(FOLLOW_19);
            rule__Subtitle__Group_2__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Subtitle__Group_2__2();

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
    // $ANTLR end "rule__Subtitle__Group_2__1"


    // $ANTLR start "rule__Subtitle__Group_2__1__Impl"
    // InternalVideoGen.g:2458:1: rule__Subtitle__Group_2__1__Impl : ( ( rule__Subtitle__Group_2_1__0 )? ) ;
    public final void rule__Subtitle__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:2462:1: ( ( ( rule__Subtitle__Group_2_1__0 )? ) )
            // InternalVideoGen.g:2463:1: ( ( rule__Subtitle__Group_2_1__0 )? )
            {
            // InternalVideoGen.g:2463:1: ( ( rule__Subtitle__Group_2_1__0 )? )
            // InternalVideoGen.g:2464:1: ( rule__Subtitle__Group_2_1__0 )?
            {
             before(grammarAccess.getSubtitleAccess().getGroup_2_1()); 
            // InternalVideoGen.g:2465:1: ( rule__Subtitle__Group_2_1__0 )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==36) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // InternalVideoGen.g:2465:2: rule__Subtitle__Group_2_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Subtitle__Group_2_1__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getSubtitleAccess().getGroup_2_1()); 

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
    // $ANTLR end "rule__Subtitle__Group_2__1__Impl"


    // $ANTLR start "rule__Subtitle__Group_2__2"
    // InternalVideoGen.g:2475:1: rule__Subtitle__Group_2__2 : rule__Subtitle__Group_2__2__Impl rule__Subtitle__Group_2__3 ;
    public final void rule__Subtitle__Group_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:2479:1: ( rule__Subtitle__Group_2__2__Impl rule__Subtitle__Group_2__3 )
            // InternalVideoGen.g:2480:2: rule__Subtitle__Group_2__2__Impl rule__Subtitle__Group_2__3
            {
            pushFollow(FOLLOW_19);
            rule__Subtitle__Group_2__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Subtitle__Group_2__3();

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
    // $ANTLR end "rule__Subtitle__Group_2__2"


    // $ANTLR start "rule__Subtitle__Group_2__2__Impl"
    // InternalVideoGen.g:2487:1: rule__Subtitle__Group_2__2__Impl : ( ( rule__Subtitle__Group_2_2__0 )? ) ;
    public final void rule__Subtitle__Group_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:2491:1: ( ( ( rule__Subtitle__Group_2_2__0 )? ) )
            // InternalVideoGen.g:2492:1: ( ( rule__Subtitle__Group_2_2__0 )? )
            {
            // InternalVideoGen.g:2492:1: ( ( rule__Subtitle__Group_2_2__0 )? )
            // InternalVideoGen.g:2493:1: ( rule__Subtitle__Group_2_2__0 )?
            {
<<<<<<< HEAD
             before(grammarAccess.getSubtitleAccess().getGroup_2_2()); 
            // InternalVideoGen.g:2494:1: ( rule__Subtitle__Group_2_2__0 )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==31) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // InternalVideoGen.g:2494:2: rule__Subtitle__Group_2_2__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Subtitle__Group_2_2__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getSubtitleAccess().getGroup_2_2()); 
=======
             before(grammarAccess.getMandatoryVideoSeqAccess().getMandatoryKeyword_0()); 
            match(input,19,FOLLOW_2); 
             after(grammarAccess.getMandatoryVideoSeqAccess().getMandatoryKeyword_0()); 
>>>>>>> e529713dc2ce4273a0bbf2a0634beb68235d51ef

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
    // $ANTLR end "rule__Subtitle__Group_2__2__Impl"


    // $ANTLR start "rule__Subtitle__Group_2__3"
    // InternalVideoGen.g:2504:1: rule__Subtitle__Group_2__3 : rule__Subtitle__Group_2__3__Impl ;
    public final void rule__Subtitle__Group_2__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:2508:1: ( rule__Subtitle__Group_2__3__Impl )
            // InternalVideoGen.g:2509:2: rule__Subtitle__Group_2__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Subtitle__Group_2__3__Impl();

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
    // $ANTLR end "rule__Subtitle__Group_2__3"


    // $ANTLR start "rule__Subtitle__Group_2__3__Impl"
    // InternalVideoGen.g:2515:1: rule__Subtitle__Group_2__3__Impl : ( RULE_RIGHT_BRACKET ) ;
    public final void rule__Subtitle__Group_2__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:2519:1: ( ( RULE_RIGHT_BRACKET ) )
            // InternalVideoGen.g:2520:1: ( RULE_RIGHT_BRACKET )
            {
            // InternalVideoGen.g:2520:1: ( RULE_RIGHT_BRACKET )
            // InternalVideoGen.g:2521:1: RULE_RIGHT_BRACKET
            {
             before(grammarAccess.getSubtitleAccess().getRIGHT_BRACKETTerminalRuleCall_2_3()); 
            match(input,RULE_RIGHT_BRACKET,FOLLOW_2); 
             after(grammarAccess.getSubtitleAccess().getRIGHT_BRACKETTerminalRuleCall_2_3()); 

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
    // $ANTLR end "rule__Subtitle__Group_2__3__Impl"


    // $ANTLR start "rule__Subtitle__Group_2_1__0"
    // InternalVideoGen.g:2540:1: rule__Subtitle__Group_2_1__0 : rule__Subtitle__Group_2_1__0__Impl rule__Subtitle__Group_2_1__1 ;
    public final void rule__Subtitle__Group_2_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:2544:1: ( rule__Subtitle__Group_2_1__0__Impl rule__Subtitle__Group_2_1__1 )
            // InternalVideoGen.g:2545:2: rule__Subtitle__Group_2_1__0__Impl rule__Subtitle__Group_2_1__1
            {
            pushFollow(FOLLOW_10);
            rule__Subtitle__Group_2_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Subtitle__Group_2_1__1();

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
    // $ANTLR end "rule__Subtitle__Group_2_1__0"


    // $ANTLR start "rule__Subtitle__Group_2_1__0__Impl"
    // InternalVideoGen.g:2552:1: rule__Subtitle__Group_2_1__0__Impl : ( 'color' ) ;
    public final void rule__Subtitle__Group_2_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:2556:1: ( ( 'color' ) )
            // InternalVideoGen.g:2557:1: ( 'color' )
            {
            // InternalVideoGen.g:2557:1: ( 'color' )
            // InternalVideoGen.g:2558:1: 'color'
            {
<<<<<<< HEAD
             before(grammarAccess.getSubtitleAccess().getColorKeyword_2_1_0()); 
            match(input,36,FOLLOW_2); 
             after(grammarAccess.getSubtitleAccess().getColorKeyword_2_1_0()); 
=======
             before(grammarAccess.getOptionalVideoSeqAccess().getOptionalKeyword_0()); 
            match(input,20,FOLLOW_2); 
             after(grammarAccess.getOptionalVideoSeqAccess().getOptionalKeyword_0()); 
>>>>>>> e529713dc2ce4273a0bbf2a0634beb68235d51ef

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
    // $ANTLR end "rule__Subtitle__Group_2_1__0__Impl"


    // $ANTLR start "rule__Subtitle__Group_2_1__1"
    // InternalVideoGen.g:2571:1: rule__Subtitle__Group_2_1__1 : rule__Subtitle__Group_2_1__1__Impl ;
    public final void rule__Subtitle__Group_2_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:2575:1: ( rule__Subtitle__Group_2_1__1__Impl )
            // InternalVideoGen.g:2576:2: rule__Subtitle__Group_2_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Subtitle__Group_2_1__1__Impl();

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
    // $ANTLR end "rule__Subtitle__Group_2_1__1"


    // $ANTLR start "rule__Subtitle__Group_2_1__1__Impl"
    // InternalVideoGen.g:2582:1: rule__Subtitle__Group_2_1__1__Impl : ( ( rule__Subtitle__ColorfontAssignment_2_1_1 ) ) ;
    public final void rule__Subtitle__Group_2_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:2586:1: ( ( ( rule__Subtitle__ColorfontAssignment_2_1_1 ) ) )
            // InternalVideoGen.g:2587:1: ( ( rule__Subtitle__ColorfontAssignment_2_1_1 ) )
            {
            // InternalVideoGen.g:2587:1: ( ( rule__Subtitle__ColorfontAssignment_2_1_1 ) )
            // InternalVideoGen.g:2588:1: ( rule__Subtitle__ColorfontAssignment_2_1_1 )
            {
             before(grammarAccess.getSubtitleAccess().getColorfontAssignment_2_1_1()); 
            // InternalVideoGen.g:2589:1: ( rule__Subtitle__ColorfontAssignment_2_1_1 )
            // InternalVideoGen.g:2589:2: rule__Subtitle__ColorfontAssignment_2_1_1
            {
            pushFollow(FOLLOW_2);
            rule__Subtitle__ColorfontAssignment_2_1_1();

            state._fsp--;


            }

             after(grammarAccess.getSubtitleAccess().getColorfontAssignment_2_1_1()); 

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
    // $ANTLR end "rule__Subtitle__Group_2_1__1__Impl"


    // $ANTLR start "rule__Subtitle__Group_2_2__0"
    // InternalVideoGen.g:2603:1: rule__Subtitle__Group_2_2__0 : rule__Subtitle__Group_2_2__0__Impl rule__Subtitle__Group_2_2__1 ;
    public final void rule__Subtitle__Group_2_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:2607:1: ( rule__Subtitle__Group_2_2__0__Impl rule__Subtitle__Group_2_2__1 )
            // InternalVideoGen.g:2608:2: rule__Subtitle__Group_2_2__0__Impl rule__Subtitle__Group_2_2__1
            {
            pushFollow(FOLLOW_16);
            rule__Subtitle__Group_2_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Subtitle__Group_2_2__1();

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
    // $ANTLR end "rule__Subtitle__Group_2_2__0"


    // $ANTLR start "rule__Subtitle__Group_2_2__0__Impl"
    // InternalVideoGen.g:2615:1: rule__Subtitle__Group_2_2__0__Impl : ( 'size' ) ;
    public final void rule__Subtitle__Group_2_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:2619:1: ( ( 'size' ) )
            // InternalVideoGen.g:2620:1: ( 'size' )
            {
            // InternalVideoGen.g:2620:1: ( 'size' )
            // InternalVideoGen.g:2621:1: 'size'
            {
<<<<<<< HEAD
             before(grammarAccess.getSubtitleAccess().getSizeKeyword_2_2_0()); 
            match(input,31,FOLLOW_2); 
             after(grammarAccess.getSubtitleAccess().getSizeKeyword_2_2_0()); 
=======
             before(grammarAccess.getAlternativeVideoSeqAccess().getAlternativesKeyword_0()); 
            match(input,21,FOLLOW_2); 
             after(grammarAccess.getAlternativeVideoSeqAccess().getAlternativesKeyword_0()); 
>>>>>>> e529713dc2ce4273a0bbf2a0634beb68235d51ef

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
    // $ANTLR end "rule__Subtitle__Group_2_2__0__Impl"


    // $ANTLR start "rule__Subtitle__Group_2_2__1"
    // InternalVideoGen.g:2634:1: rule__Subtitle__Group_2_2__1 : rule__Subtitle__Group_2_2__1__Impl ;
    public final void rule__Subtitle__Group_2_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:2638:1: ( rule__Subtitle__Group_2_2__1__Impl )
            // InternalVideoGen.g:2639:2: rule__Subtitle__Group_2_2__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Subtitle__Group_2_2__1__Impl();

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
    // $ANTLR end "rule__Subtitle__Group_2_2__1"


    // $ANTLR start "rule__Subtitle__Group_2_2__1__Impl"
    // InternalVideoGen.g:2645:1: rule__Subtitle__Group_2_2__1__Impl : ( ( rule__Subtitle__SizeAssignment_2_2_1 ) ) ;
    public final void rule__Subtitle__Group_2_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:2649:1: ( ( ( rule__Subtitle__SizeAssignment_2_2_1 ) ) )
            // InternalVideoGen.g:2650:1: ( ( rule__Subtitle__SizeAssignment_2_2_1 ) )
            {
            // InternalVideoGen.g:2650:1: ( ( rule__Subtitle__SizeAssignment_2_2_1 ) )
            // InternalVideoGen.g:2651:1: ( rule__Subtitle__SizeAssignment_2_2_1 )
            {
             before(grammarAccess.getSubtitleAccess().getSizeAssignment_2_2_1()); 
            // InternalVideoGen.g:2652:1: ( rule__Subtitle__SizeAssignment_2_2_1 )
            // InternalVideoGen.g:2652:2: rule__Subtitle__SizeAssignment_2_2_1
            {
            pushFollow(FOLLOW_2);
            rule__Subtitle__SizeAssignment_2_2_1();

            state._fsp--;


            }

             after(grammarAccess.getSubtitleAccess().getSizeAssignment_2_2_1()); 

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
    // $ANTLR end "rule__Subtitle__Group_2_2__1__Impl"


    // $ANTLR start "rule__Text__Group__0"
    // InternalVideoGen.g:2666:1: rule__Text__Group__0 : rule__Text__Group__0__Impl rule__Text__Group__1 ;
    public final void rule__Text__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:2670:1: ( rule__Text__Group__0__Impl rule__Text__Group__1 )
            // InternalVideoGen.g:2671:2: rule__Text__Group__0__Impl rule__Text__Group__1
            {
            pushFollow(FOLLOW_20);
            rule__Text__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Text__Group__1();

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
    // $ANTLR end "rule__Text__Group__0"


    // $ANTLR start "rule__Text__Group__0__Impl"
    // InternalVideoGen.g:2678:1: rule__Text__Group__0__Impl : ( RULE_LEFT_BRACKET ) ;
    public final void rule__Text__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:2682:1: ( ( RULE_LEFT_BRACKET ) )
            // InternalVideoGen.g:2683:1: ( RULE_LEFT_BRACKET )
            {
            // InternalVideoGen.g:2683:1: ( RULE_LEFT_BRACKET )
            // InternalVideoGen.g:2684:1: RULE_LEFT_BRACKET
            {
             before(grammarAccess.getTextAccess().getLEFT_BRACKETTerminalRuleCall_0()); 
            match(input,RULE_LEFT_BRACKET,FOLLOW_2); 
             after(grammarAccess.getTextAccess().getLEFT_BRACKETTerminalRuleCall_0()); 

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
    // $ANTLR end "rule__Text__Group__0__Impl"


    // $ANTLR start "rule__Text__Group__1"
    // InternalVideoGen.g:2695:1: rule__Text__Group__1 : rule__Text__Group__1__Impl rule__Text__Group__2 ;
    public final void rule__Text__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:2699:1: ( rule__Text__Group__1__Impl rule__Text__Group__2 )
            // InternalVideoGen.g:2700:2: rule__Text__Group__1__Impl rule__Text__Group__2
            {
            pushFollow(FOLLOW_10);
            rule__Text__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Text__Group__2();

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
    // $ANTLR end "rule__Text__Group__1"


    // $ANTLR start "rule__Text__Group__1__Impl"
    // InternalVideoGen.g:2707:1: rule__Text__Group__1__Impl : ( 'content' ) ;
    public final void rule__Text__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:2711:1: ( ( 'content' ) )
            // InternalVideoGen.g:2712:1: ( 'content' )
            {
            // InternalVideoGen.g:2712:1: ( 'content' )
            // InternalVideoGen.g:2713:1: 'content'
            {
             before(grammarAccess.getTextAccess().getContentKeyword_1()); 
            match(input,37,FOLLOW_2); 
             after(grammarAccess.getTextAccess().getContentKeyword_1()); 

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
    // $ANTLR end "rule__Text__Group__1__Impl"


    // $ANTLR start "rule__Text__Group__2"
    // InternalVideoGen.g:2726:1: rule__Text__Group__2 : rule__Text__Group__2__Impl rule__Text__Group__3 ;
    public final void rule__Text__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:2730:1: ( rule__Text__Group__2__Impl rule__Text__Group__3 )
            // InternalVideoGen.g:2731:2: rule__Text__Group__2__Impl rule__Text__Group__3
            {
            pushFollow(FOLLOW_21);
            rule__Text__Group__2__Impl();

<<<<<<< HEAD
            state._fsp--;
=======
                if ( (LA7_0==22) ) {
                    alt7=1;
                }
>>>>>>> e529713dc2ce4273a0bbf2a0634beb68235d51ef

            pushFollow(FOLLOW_2);
            rule__Text__Group__3();

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
    // $ANTLR end "rule__Text__Group__2"


    // $ANTLR start "rule__Text__Group__2__Impl"
    // InternalVideoGen.g:2738:1: rule__Text__Group__2__Impl : ( ( rule__Text__ContentAssignment_2 ) ) ;
    public final void rule__Text__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:2742:1: ( ( ( rule__Text__ContentAssignment_2 ) ) )
            // InternalVideoGen.g:2743:1: ( ( rule__Text__ContentAssignment_2 ) )
            {
            // InternalVideoGen.g:2743:1: ( ( rule__Text__ContentAssignment_2 ) )
            // InternalVideoGen.g:2744:1: ( rule__Text__ContentAssignment_2 )
            {
             before(grammarAccess.getTextAccess().getContentAssignment_2()); 
            // InternalVideoGen.g:2745:1: ( rule__Text__ContentAssignment_2 )
            // InternalVideoGen.g:2745:2: rule__Text__ContentAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__Text__ContentAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getTextAccess().getContentAssignment_2()); 

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
    // $ANTLR end "rule__Text__Group__2__Impl"


    // $ANTLR start "rule__Text__Group__3"
    // InternalVideoGen.g:2755:1: rule__Text__Group__3 : rule__Text__Group__3__Impl rule__Text__Group__4 ;
    public final void rule__Text__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:2759:1: ( rule__Text__Group__3__Impl rule__Text__Group__4 )
            // InternalVideoGen.g:2760:2: rule__Text__Group__3__Impl rule__Text__Group__4
            {
            pushFollow(FOLLOW_22);
            rule__Text__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Text__Group__4();

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
    // $ANTLR end "rule__Text__Group__3"


    // $ANTLR start "rule__Text__Group__3__Impl"
    // InternalVideoGen.g:2767:1: rule__Text__Group__3__Impl : ( 'position' ) ;
    public final void rule__Text__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:2771:1: ( ( 'position' ) )
            // InternalVideoGen.g:2772:1: ( 'position' )
            {
            // InternalVideoGen.g:2772:1: ( 'position' )
            // InternalVideoGen.g:2773:1: 'position'
            {
             before(grammarAccess.getTextAccess().getPositionKeyword_3()); 
            match(input,38,FOLLOW_2); 
             after(grammarAccess.getTextAccess().getPositionKeyword_3()); 

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
    // $ANTLR end "rule__Text__Group__3__Impl"


    // $ANTLR start "rule__Text__Group__4"
    // InternalVideoGen.g:2786:1: rule__Text__Group__4 : rule__Text__Group__4__Impl rule__Text__Group__5 ;
    public final void rule__Text__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:2790:1: ( rule__Text__Group__4__Impl rule__Text__Group__5 )
            // InternalVideoGen.g:2791:2: rule__Text__Group__4__Impl rule__Text__Group__5
            {
            pushFollow(FOLLOW_23);
            rule__Text__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Text__Group__5();

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
    // $ANTLR end "rule__Text__Group__4"


    // $ANTLR start "rule__Text__Group__4__Impl"
    // InternalVideoGen.g:2798:1: rule__Text__Group__4__Impl : ( ( rule__Text__PositionAssignment_4 ) ) ;
    public final void rule__Text__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:2802:1: ( ( ( rule__Text__PositionAssignment_4 ) ) )
            // InternalVideoGen.g:2803:1: ( ( rule__Text__PositionAssignment_4 ) )
            {
            // InternalVideoGen.g:2803:1: ( ( rule__Text__PositionAssignment_4 ) )
            // InternalVideoGen.g:2804:1: ( rule__Text__PositionAssignment_4 )
            {
<<<<<<< HEAD
             before(grammarAccess.getTextAccess().getPositionAssignment_4()); 
            // InternalVideoGen.g:2805:1: ( rule__Text__PositionAssignment_4 )
            // InternalVideoGen.g:2805:2: rule__Text__PositionAssignment_4
            {
            pushFollow(FOLLOW_2);
            rule__Text__PositionAssignment_4();

            state._fsp--;


            }

             after(grammarAccess.getTextAccess().getPositionAssignment_4()); 
=======
             before(grammarAccess.getVideoDescriptionAccess().getVideoseqKeyword_0()); 
            match(input,22,FOLLOW_2); 
             after(grammarAccess.getVideoDescriptionAccess().getVideoseqKeyword_0()); 
>>>>>>> e529713dc2ce4273a0bbf2a0634beb68235d51ef

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
    // $ANTLR end "rule__Text__Group__4__Impl"


    // $ANTLR start "rule__Text__Group__5"
    // InternalVideoGen.g:2815:1: rule__Text__Group__5 : rule__Text__Group__5__Impl rule__Text__Group__6 ;
    public final void rule__Text__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:2819:1: ( rule__Text__Group__5__Impl rule__Text__Group__6 )
            // InternalVideoGen.g:2820:2: rule__Text__Group__5__Impl rule__Text__Group__6
            {
            pushFollow(FOLLOW_10);
            rule__Text__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Text__Group__6();

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
    // $ANTLR end "rule__Text__Group__5"


    // $ANTLR start "rule__Text__Group__5__Impl"
    // InternalVideoGen.g:2827:1: rule__Text__Group__5__Impl : ( 'color' ) ;
    public final void rule__Text__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:2831:1: ( ( 'color' ) )
            // InternalVideoGen.g:2832:1: ( 'color' )
            {
            // InternalVideoGen.g:2832:1: ( 'color' )
            // InternalVideoGen.g:2833:1: 'color'
            {
             before(grammarAccess.getTextAccess().getColorKeyword_5()); 
            match(input,36,FOLLOW_2); 
             after(grammarAccess.getTextAccess().getColorKeyword_5()); 

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
    // $ANTLR end "rule__Text__Group__5__Impl"


    // $ANTLR start "rule__Text__Group__6"
    // InternalVideoGen.g:2846:1: rule__Text__Group__6 : rule__Text__Group__6__Impl rule__Text__Group__7 ;
    public final void rule__Text__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:2850:1: ( rule__Text__Group__6__Impl rule__Text__Group__7 )
            // InternalVideoGen.g:2851:2: rule__Text__Group__6__Impl rule__Text__Group__7
            {
            pushFollow(FOLLOW_24);
            rule__Text__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Text__Group__7();

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
    // $ANTLR end "rule__Text__Group__6"


    // $ANTLR start "rule__Text__Group__6__Impl"
    // InternalVideoGen.g:2858:1: rule__Text__Group__6__Impl : ( ( rule__Text__ColorAssignment_6 ) ) ;
    public final void rule__Text__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:2862:1: ( ( ( rule__Text__ColorAssignment_6 ) ) )
            // InternalVideoGen.g:2863:1: ( ( rule__Text__ColorAssignment_6 ) )
            {
            // InternalVideoGen.g:2863:1: ( ( rule__Text__ColorAssignment_6 ) )
            // InternalVideoGen.g:2864:1: ( rule__Text__ColorAssignment_6 )
            {
             before(grammarAccess.getTextAccess().getColorAssignment_6()); 
            // InternalVideoGen.g:2865:1: ( rule__Text__ColorAssignment_6 )
            // InternalVideoGen.g:2865:2: rule__Text__ColorAssignment_6
            {
            pushFollow(FOLLOW_2);
            rule__Text__ColorAssignment_6();

            state._fsp--;


            }

             after(grammarAccess.getTextAccess().getColorAssignment_6()); 

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
    // $ANTLR end "rule__Text__Group__6__Impl"


    // $ANTLR start "rule__Text__Group__7"
    // InternalVideoGen.g:2875:1: rule__Text__Group__7 : rule__Text__Group__7__Impl rule__Text__Group__8 ;
    public final void rule__Text__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:2879:1: ( rule__Text__Group__7__Impl rule__Text__Group__8 )
            // InternalVideoGen.g:2880:2: rule__Text__Group__7__Impl rule__Text__Group__8
            {
            pushFollow(FOLLOW_16);
            rule__Text__Group__7__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Text__Group__8();

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
    // $ANTLR end "rule__Text__Group__7"


    // $ANTLR start "rule__Text__Group__7__Impl"
    // InternalVideoGen.g:2887:1: rule__Text__Group__7__Impl : ( 'size' ) ;
    public final void rule__Text__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:2891:1: ( ( 'size' ) )
            // InternalVideoGen.g:2892:1: ( 'size' )
            {
            // InternalVideoGen.g:2892:1: ( 'size' )
            // InternalVideoGen.g:2893:1: 'size'
            {
             before(grammarAccess.getTextAccess().getSizeKeyword_7()); 
            match(input,31,FOLLOW_2); 
             after(grammarAccess.getTextAccess().getSizeKeyword_7()); 

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
    // $ANTLR end "rule__Text__Group__7__Impl"


    // $ANTLR start "rule__Text__Group__8"
    // InternalVideoGen.g:2906:1: rule__Text__Group__8 : rule__Text__Group__8__Impl rule__Text__Group__9 ;
    public final void rule__Text__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:2910:1: ( rule__Text__Group__8__Impl rule__Text__Group__9 )
            // InternalVideoGen.g:2911:2: rule__Text__Group__8__Impl rule__Text__Group__9
            {
            pushFollow(FOLLOW_6);
            rule__Text__Group__8__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Text__Group__9();

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
    // $ANTLR end "rule__Text__Group__8"


    // $ANTLR start "rule__Text__Group__8__Impl"
    // InternalVideoGen.g:2918:1: rule__Text__Group__8__Impl : ( ( rule__Text__SizeAssignment_8 ) ) ;
    public final void rule__Text__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:2922:1: ( ( ( rule__Text__SizeAssignment_8 ) ) )
            // InternalVideoGen.g:2923:1: ( ( rule__Text__SizeAssignment_8 ) )
            {
            // InternalVideoGen.g:2923:1: ( ( rule__Text__SizeAssignment_8 ) )
            // InternalVideoGen.g:2924:1: ( rule__Text__SizeAssignment_8 )
            {
             before(grammarAccess.getTextAccess().getSizeAssignment_8()); 
            // InternalVideoGen.g:2925:1: ( rule__Text__SizeAssignment_8 )
            // InternalVideoGen.g:2925:2: rule__Text__SizeAssignment_8
            {
            pushFollow(FOLLOW_2);
            rule__Text__SizeAssignment_8();

            state._fsp--;


            }

             after(grammarAccess.getTextAccess().getSizeAssignment_8()); 

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
    // $ANTLR end "rule__Text__Group__8__Impl"


    // $ANTLR start "rule__Text__Group__9"
    // InternalVideoGen.g:2935:1: rule__Text__Group__9 : rule__Text__Group__9__Impl ;
    public final void rule__Text__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:2939:1: ( rule__Text__Group__9__Impl )
            // InternalVideoGen.g:2940:2: rule__Text__Group__9__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Text__Group__9__Impl();

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
    // $ANTLR end "rule__Text__Group__9"


    // $ANTLR start "rule__Text__Group__9__Impl"
    // InternalVideoGen.g:2946:1: rule__Text__Group__9__Impl : ( RULE_RIGHT_BRACKET ) ;
    public final void rule__Text__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:2950:1: ( ( RULE_RIGHT_BRACKET ) )
            // InternalVideoGen.g:2951:1: ( RULE_RIGHT_BRACKET )
            {
            // InternalVideoGen.g:2951:1: ( RULE_RIGHT_BRACKET )
            // InternalVideoGen.g:2952:1: RULE_RIGHT_BRACKET
            {
<<<<<<< HEAD
             before(grammarAccess.getTextAccess().getRIGHT_BRACKETTerminalRuleCall_9()); 
            match(input,RULE_RIGHT_BRACKET,FOLLOW_2); 
             after(grammarAccess.getTextAccess().getRIGHT_BRACKETTerminalRuleCall_9()); 
=======
             before(grammarAccess.getVideoDescriptionAccess().getGroup_3_1()); 
            // InternalVideoGen.g:1258:1: ( rule__VideoDescription__Group_3_1__0 )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==23) ) {
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
>>>>>>> e529713dc2ce4273a0bbf2a0634beb68235d51ef

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
    // $ANTLR end "rule__Text__Group__9__Impl"


    // $ANTLR start "rule__BlackWhiteFilter__Group__0"
    // InternalVideoGen.g:2983:1: rule__BlackWhiteFilter__Group__0 : rule__BlackWhiteFilter__Group__0__Impl rule__BlackWhiteFilter__Group__1 ;
    public final void rule__BlackWhiteFilter__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:2987:1: ( rule__BlackWhiteFilter__Group__0__Impl rule__BlackWhiteFilter__Group__1 )
            // InternalVideoGen.g:2988:2: rule__BlackWhiteFilter__Group__0__Impl rule__BlackWhiteFilter__Group__1
            {
            pushFollow(FOLLOW_18);
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
    // InternalVideoGen.g:2995:1: rule__BlackWhiteFilter__Group__0__Impl : ( () ) ;
    public final void rule__BlackWhiteFilter__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:2999:1: ( ( () ) )
            // InternalVideoGen.g:3000:1: ( () )
            {
            // InternalVideoGen.g:3000:1: ( () )
            // InternalVideoGen.g:3001:1: ()
            {
             before(grammarAccess.getBlackWhiteFilterAccess().getBlackWhiteFilterAction_0()); 
            // InternalVideoGen.g:3002:1: ()
            // InternalVideoGen.g:3004:1: 
            {
<<<<<<< HEAD
=======
             before(grammarAccess.getVideoDescriptionAccess().getGroup_3_2()); 
            // InternalVideoGen.g:1287:1: ( rule__VideoDescription__Group_3_2__0 )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==24) ) {
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

>>>>>>> e529713dc2ce4273a0bbf2a0634beb68235d51ef
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
    // InternalVideoGen.g:3014:1: rule__BlackWhiteFilter__Group__1 : rule__BlackWhiteFilter__Group__1__Impl ;
    public final void rule__BlackWhiteFilter__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:3018:1: ( rule__BlackWhiteFilter__Group__1__Impl )
            // InternalVideoGen.g:3019:2: rule__BlackWhiteFilter__Group__1__Impl
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
    // InternalVideoGen.g:3025:1: rule__BlackWhiteFilter__Group__1__Impl : ( 'b&w' ) ;
    public final void rule__BlackWhiteFilter__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:3029:1: ( ( 'b&w' ) )
            // InternalVideoGen.g:3030:1: ( 'b&w' )
            {
            // InternalVideoGen.g:3030:1: ( 'b&w' )
            // InternalVideoGen.g:3031:1: 'b&w'
            {
<<<<<<< HEAD
             before(grammarAccess.getBlackWhiteFilterAccess().getBWKeyword_1()); 
            match(input,39,FOLLOW_2); 
             after(grammarAccess.getBlackWhiteFilterAccess().getBWKeyword_1()); 
=======
             before(grammarAccess.getVideoDescriptionAccess().getGroup_3_3()); 
            // InternalVideoGen.g:1316:1: ( rule__VideoDescription__Group_3_3__0 )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==25) ) {
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
>>>>>>> e529713dc2ce4273a0bbf2a0634beb68235d51ef

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
    // InternalVideoGen.g:3048:1: rule__NegateFilter__Group__0 : rule__NegateFilter__Group__0__Impl rule__NegateFilter__Group__1 ;
    public final void rule__NegateFilter__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:3052:1: ( rule__NegateFilter__Group__0__Impl rule__NegateFilter__Group__1 )
            // InternalVideoGen.g:3053:2: rule__NegateFilter__Group__0__Impl rule__NegateFilter__Group__1
            {
            pushFollow(FOLLOW_25);
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
    // InternalVideoGen.g:3060:1: rule__NegateFilter__Group__0__Impl : ( () ) ;
    public final void rule__NegateFilter__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:3064:1: ( ( () ) )
            // InternalVideoGen.g:3065:1: ( () )
            {
            // InternalVideoGen.g:3065:1: ( () )
            // InternalVideoGen.g:3066:1: ()
            {
             before(grammarAccess.getNegateFilterAccess().getNegateFilterAction_0()); 
            // InternalVideoGen.g:3067:1: ()
            // InternalVideoGen.g:3069:1: 
            {
<<<<<<< HEAD
=======
             before(grammarAccess.getVideoDescriptionAccess().getGroup_3_4()); 
            // InternalVideoGen.g:1345:1: ( rule__VideoDescription__Group_3_4__0 )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==26) ) {
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

>>>>>>> e529713dc2ce4273a0bbf2a0634beb68235d51ef
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
    // InternalVideoGen.g:3079:1: rule__NegateFilter__Group__1 : rule__NegateFilter__Group__1__Impl ;
    public final void rule__NegateFilter__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:3083:1: ( rule__NegateFilter__Group__1__Impl )
            // InternalVideoGen.g:3084:2: rule__NegateFilter__Group__1__Impl
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
    // InternalVideoGen.g:3090:1: rule__NegateFilter__Group__1__Impl : ( 'negate' ) ;
    public final void rule__NegateFilter__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:3094:1: ( ( 'negate' ) )
            // InternalVideoGen.g:3095:1: ( 'negate' )
            {
            // InternalVideoGen.g:3095:1: ( 'negate' )
            // InternalVideoGen.g:3096:1: 'negate'
            {
             before(grammarAccess.getNegateFilterAccess().getNegateKeyword_1()); 
            match(input,40,FOLLOW_2); 
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
    // InternalVideoGen.g:3113:1: rule__FlipFilter__Group__0 : rule__FlipFilter__Group__0__Impl rule__FlipFilter__Group__1 ;
    public final void rule__FlipFilter__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:3117:1: ( rule__FlipFilter__Group__0__Impl rule__FlipFilter__Group__1 )
            // InternalVideoGen.g:3118:2: rule__FlipFilter__Group__0__Impl rule__FlipFilter__Group__1
            {
            pushFollow(FOLLOW_26);
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
    // InternalVideoGen.g:3125:1: rule__FlipFilter__Group__0__Impl : ( 'flip' ) ;
    public final void rule__FlipFilter__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:3129:1: ( ( 'flip' ) )
            // InternalVideoGen.g:3130:1: ( 'flip' )
            {
            // InternalVideoGen.g:3130:1: ( 'flip' )
            // InternalVideoGen.g:3131:1: 'flip'
            {
<<<<<<< HEAD
             before(grammarAccess.getFlipFilterAccess().getFlipKeyword_0()); 
            match(input,41,FOLLOW_2); 
             after(grammarAccess.getFlipFilterAccess().getFlipKeyword_0()); 
=======
             before(grammarAccess.getVideoDescriptionAccess().getDurationKeyword_3_1_0()); 
            match(input,23,FOLLOW_2); 
             after(grammarAccess.getVideoDescriptionAccess().getDurationKeyword_3_1_0()); 
>>>>>>> e529713dc2ce4273a0bbf2a0634beb68235d51ef

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
    // InternalVideoGen.g:3144:1: rule__FlipFilter__Group__1 : rule__FlipFilter__Group__1__Impl ;
    public final void rule__FlipFilter__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:3148:1: ( rule__FlipFilter__Group__1__Impl )
            // InternalVideoGen.g:3149:2: rule__FlipFilter__Group__1__Impl
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
    // InternalVideoGen.g:3155:1: rule__FlipFilter__Group__1__Impl : ( ( rule__FlipFilter__OrientationAssignment_1 ) ) ;
    public final void rule__FlipFilter__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:3159:1: ( ( ( rule__FlipFilter__OrientationAssignment_1 ) ) )
            // InternalVideoGen.g:3160:1: ( ( rule__FlipFilter__OrientationAssignment_1 ) )
            {
            // InternalVideoGen.g:3160:1: ( ( rule__FlipFilter__OrientationAssignment_1 ) )
            // InternalVideoGen.g:3161:1: ( rule__FlipFilter__OrientationAssignment_1 )
            {
             before(grammarAccess.getFlipFilterAccess().getOrientationAssignment_1()); 
            // InternalVideoGen.g:3162:1: ( rule__FlipFilter__OrientationAssignment_1 )
            // InternalVideoGen.g:3162:2: rule__FlipFilter__OrientationAssignment_1
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
    // InternalVideoGen.g:3177:1: rule__VideoGeneratorModel__InformationAssignment_1 : ( ruleVideoGenInformation ) ;
    public final void rule__VideoGeneratorModel__InformationAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:3181:1: ( ( ruleVideoGenInformation ) )
            // InternalVideoGen.g:3182:1: ( ruleVideoGenInformation )
            {
<<<<<<< HEAD
            // InternalVideoGen.g:3182:1: ( ruleVideoGenInformation )
            // InternalVideoGen.g:3183:1: ruleVideoGenInformation
            {
             before(grammarAccess.getVideoGeneratorModelAccess().getInformationVideoGenInformationParserRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleVideoGenInformation();
=======
            pushFollow(FOLLOW_17);
            rule__VideoDescription__Group_3_2__0__Impl();
>>>>>>> e529713dc2ce4273a0bbf2a0634beb68235d51ef

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
    // InternalVideoGen.g:3192:1: rule__VideoGeneratorModel__VideoseqsAssignment_4 : ( ruleVideoSeq ) ;
    public final void rule__VideoGeneratorModel__VideoseqsAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:3196:1: ( ( ruleVideoSeq ) )
            // InternalVideoGen.g:3197:1: ( ruleVideoSeq )
            {
            // InternalVideoGen.g:3197:1: ( ruleVideoSeq )
            // InternalVideoGen.g:3198:1: ruleVideoSeq
            {
<<<<<<< HEAD
             before(grammarAccess.getVideoGeneratorModelAccess().getVideoseqsVideoSeqParserRuleCall_4_0()); 
            pushFollow(FOLLOW_2);
            ruleVideoSeq();

            state._fsp--;

             after(grammarAccess.getVideoGeneratorModelAccess().getVideoseqsVideoSeqParserRuleCall_4_0()); 
=======
             before(grammarAccess.getVideoDescriptionAccess().getProbabilityKeyword_3_2_0()); 
            match(input,24,FOLLOW_2); 
             after(grammarAccess.getVideoDescriptionAccess().getProbabilityKeyword_3_2_0()); 
>>>>>>> e529713dc2ce4273a0bbf2a0634beb68235d51ef

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
    // InternalVideoGen.g:3207:1: rule__VideoGenInformation__AuthorNameAssignment_1_1 : ( RULE_STRING ) ;
    public final void rule__VideoGenInformation__AuthorNameAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:3211:1: ( ( RULE_STRING ) )
            // InternalVideoGen.g:3212:1: ( RULE_STRING )
            {
            // InternalVideoGen.g:3212:1: ( RULE_STRING )
            // InternalVideoGen.g:3213:1: RULE_STRING
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
    // InternalVideoGen.g:3222:1: rule__VideoGenInformation__VersionAssignment_2_1 : ( RULE_STRING ) ;
    public final void rule__VideoGenInformation__VersionAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:3226:1: ( ( RULE_STRING ) )
            // InternalVideoGen.g:3227:1: ( RULE_STRING )
            {
            // InternalVideoGen.g:3227:1: ( RULE_STRING )
            // InternalVideoGen.g:3228:1: RULE_STRING
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
    // InternalVideoGen.g:3237:1: rule__VideoGenInformation__CreationDateAssignment_3_1 : ( RULE_STRING ) ;
    public final void rule__VideoGenInformation__CreationDateAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:3241:1: ( ( RULE_STRING ) )
            // InternalVideoGen.g:3242:1: ( RULE_STRING )
            {
<<<<<<< HEAD
            // InternalVideoGen.g:3242:1: ( RULE_STRING )
            // InternalVideoGen.g:3243:1: RULE_STRING
            {
             before(grammarAccess.getVideoGenInformationAccess().getCreationDateSTRINGTerminalRuleCall_3_1_0()); 
            match(input,RULE_STRING,FOLLOW_2); 
             after(grammarAccess.getVideoGenInformationAccess().getCreationDateSTRINGTerminalRuleCall_3_1_0()); 
=======
            pushFollow(FOLLOW_18);
            rule__VideoDescription__Group_3_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__VideoDescription__Group_3_3__1();
>>>>>>> e529713dc2ce4273a0bbf2a0634beb68235d51ef

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
    // InternalVideoGen.g:3252:1: rule__MandatoryVideoSeq__DescriptionAssignment_1 : ( ruleVideoDescription ) ;
    public final void rule__MandatoryVideoSeq__DescriptionAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:3256:1: ( ( ruleVideoDescription ) )
            // InternalVideoGen.g:3257:1: ( ruleVideoDescription )
            {
            // InternalVideoGen.g:3257:1: ( ruleVideoDescription )
            // InternalVideoGen.g:3258:1: ruleVideoDescription
            {
<<<<<<< HEAD
             before(grammarAccess.getMandatoryVideoSeqAccess().getDescriptionVideoDescriptionParserRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleVideoDescription();

            state._fsp--;

             after(grammarAccess.getMandatoryVideoSeqAccess().getDescriptionVideoDescriptionParserRuleCall_1_0()); 
=======
             before(grammarAccess.getVideoDescriptionAccess().getSizeKeyword_3_3_0()); 
            match(input,25,FOLLOW_2); 
             after(grammarAccess.getVideoDescriptionAccess().getSizeKeyword_3_3_0()); 
>>>>>>> e529713dc2ce4273a0bbf2a0634beb68235d51ef

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
    // InternalVideoGen.g:3267:1: rule__OptionalVideoSeq__DescriptionAssignment_1 : ( ruleVideoDescription ) ;
    public final void rule__OptionalVideoSeq__DescriptionAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:3271:1: ( ( ruleVideoDescription ) )
            // InternalVideoGen.g:3272:1: ( ruleVideoDescription )
            {
            // InternalVideoGen.g:3272:1: ( ruleVideoDescription )
            // InternalVideoGen.g:3273:1: ruleVideoDescription
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
    // InternalVideoGen.g:3282:1: rule__AlternativeVideoSeq__VideoidAssignment_1 : ( RULE_ID ) ;
    public final void rule__AlternativeVideoSeq__VideoidAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:3286:1: ( ( RULE_ID ) )
            // InternalVideoGen.g:3287:1: ( RULE_ID )
            {
            // InternalVideoGen.g:3287:1: ( RULE_ID )
            // InternalVideoGen.g:3288:1: RULE_ID
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
    // InternalVideoGen.g:3297:1: rule__AlternativeVideoSeq__VideodescsAssignment_3 : ( ruleVideoDescription ) ;
    public final void rule__AlternativeVideoSeq__VideodescsAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:3301:1: ( ( ruleVideoDescription ) )
            // InternalVideoGen.g:3302:1: ( ruleVideoDescription )
            {
            // InternalVideoGen.g:3302:1: ( ruleVideoDescription )
            // InternalVideoGen.g:3303:1: ruleVideoDescription
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
    // InternalVideoGen.g:3312:1: rule__VideoDescription__VideoidAssignment_1 : ( RULE_ID ) ;
    public final void rule__VideoDescription__VideoidAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:3316:1: ( ( RULE_ID ) )
            // InternalVideoGen.g:3317:1: ( RULE_ID )
            {
            // InternalVideoGen.g:3317:1: ( RULE_ID )
            // InternalVideoGen.g:3318:1: RULE_ID
            {
<<<<<<< HEAD
             before(grammarAccess.getVideoDescriptionAccess().getVideoidIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getVideoDescriptionAccess().getVideoidIDTerminalRuleCall_1_0()); 
=======
             before(grammarAccess.getVideoDescriptionAccess().getDescriptionKeyword_3_4_0()); 
            match(input,26,FOLLOW_2); 
             after(grammarAccess.getVideoDescriptionAccess().getDescriptionKeyword_3_4_0()); 
>>>>>>> e529713dc2ce4273a0bbf2a0634beb68235d51ef

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
    // InternalVideoGen.g:3327:1: rule__VideoDescription__LocationAssignment_2 : ( RULE_STRING ) ;
    public final void rule__VideoDescription__LocationAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:3331:1: ( ( RULE_STRING ) )
            // InternalVideoGen.g:3332:1: ( RULE_STRING )
            {
            // InternalVideoGen.g:3332:1: ( RULE_STRING )
            // InternalVideoGen.g:3333:1: RULE_STRING
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
    // InternalVideoGen.g:3342:1: rule__VideoDescription__DurationAssignment_3_1_1 : ( RULE_INT ) ;
    public final void rule__VideoDescription__DurationAssignment_3_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:3346:1: ( ( RULE_INT ) )
            // InternalVideoGen.g:3347:1: ( RULE_INT )
            {
            // InternalVideoGen.g:3347:1: ( RULE_INT )
            // InternalVideoGen.g:3348:1: RULE_INT
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
    // InternalVideoGen.g:3357:1: rule__VideoDescription__ProbabilityAssignment_3_2_1 : ( RULE_INT ) ;
    public final void rule__VideoDescription__ProbabilityAssignment_3_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:3361:1: ( ( RULE_INT ) )
            // InternalVideoGen.g:3362:1: ( RULE_INT )
            {
            // InternalVideoGen.g:3362:1: ( RULE_INT )
            // InternalVideoGen.g:3363:1: RULE_INT
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


    // $ANTLR start "rule__VideoDescription__TextIncrustAssignment_3_3_1"
    // InternalVideoGen.g:3372:1: rule__VideoDescription__TextIncrustAssignment_3_3_1 : ( RULE_STRING ) ;
    public final void rule__VideoDescription__TextIncrustAssignment_3_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:3376:1: ( ( RULE_STRING ) )
            // InternalVideoGen.g:3377:1: ( RULE_STRING )
            {
            // InternalVideoGen.g:3377:1: ( RULE_STRING )
            // InternalVideoGen.g:3378:1: RULE_STRING
            {
             before(grammarAccess.getVideoDescriptionAccess().getTextIncrustSTRINGTerminalRuleCall_3_3_1_0()); 
            match(input,RULE_STRING,FOLLOW_2); 
             after(grammarAccess.getVideoDescriptionAccess().getTextIncrustSTRINGTerminalRuleCall_3_3_1_0()); 

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
    // $ANTLR end "rule__VideoDescription__TextIncrustAssignment_3_3_1"


    // $ANTLR start "rule__VideoDescription__SizeAssignment_3_4_1"
    // InternalVideoGen.g:3387:1: rule__VideoDescription__SizeAssignment_3_4_1 : ( RULE_INT ) ;
    public final void rule__VideoDescription__SizeAssignment_3_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:3391:1: ( ( RULE_INT ) )
            // InternalVideoGen.g:3392:1: ( RULE_INT )
            {
            // InternalVideoGen.g:3392:1: ( RULE_INT )
            // InternalVideoGen.g:3393:1: RULE_INT
            {
             before(grammarAccess.getVideoDescriptionAccess().getSizeINTTerminalRuleCall_3_4_1_0()); 
            match(input,RULE_INT,FOLLOW_2); 
             after(grammarAccess.getVideoDescriptionAccess().getSizeINTTerminalRuleCall_3_4_1_0()); 

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
    // $ANTLR end "rule__VideoDescription__SizeAssignment_3_4_1"


    // $ANTLR start "rule__VideoDescription__DescriptionAssignment_3_5_1"
    // InternalVideoGen.g:3402:1: rule__VideoDescription__DescriptionAssignment_3_5_1 : ( RULE_STRING ) ;
    public final void rule__VideoDescription__DescriptionAssignment_3_5_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:3406:1: ( ( RULE_STRING ) )
            // InternalVideoGen.g:3407:1: ( RULE_STRING )
            {
            // InternalVideoGen.g:3407:1: ( RULE_STRING )
            // InternalVideoGen.g:3408:1: RULE_STRING
            {
             before(grammarAccess.getVideoDescriptionAccess().getDescriptionSTRINGTerminalRuleCall_3_5_1_0()); 
            match(input,RULE_STRING,FOLLOW_2); 
             after(grammarAccess.getVideoDescriptionAccess().getDescriptionSTRINGTerminalRuleCall_3_5_1_0()); 

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
    // $ANTLR end "rule__VideoDescription__DescriptionAssignment_3_5_1"


    // $ANTLR start "rule__VideoDescription__SubtitleAssignment_3_6_1"
    // InternalVideoGen.g:3417:1: rule__VideoDescription__SubtitleAssignment_3_6_1 : ( ruleSubtitle ) ;
    public final void rule__VideoDescription__SubtitleAssignment_3_6_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:3421:1: ( ( ruleSubtitle ) )
            // InternalVideoGen.g:3422:1: ( ruleSubtitle )
            {
            // InternalVideoGen.g:3422:1: ( ruleSubtitle )
            // InternalVideoGen.g:3423:1: ruleSubtitle
            {
             before(grammarAccess.getVideoDescriptionAccess().getSubtitleSubtitleParserRuleCall_3_6_1_0()); 
            pushFollow(FOLLOW_2);
            ruleSubtitle();

            state._fsp--;

             after(grammarAccess.getVideoDescriptionAccess().getSubtitleSubtitleParserRuleCall_3_6_1_0()); 

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
    // $ANTLR end "rule__VideoDescription__SubtitleAssignment_3_6_1"


    // $ANTLR start "rule__VideoDescription__TextAssignment_3_7_1"
    // InternalVideoGen.g:3432:1: rule__VideoDescription__TextAssignment_3_7_1 : ( ruleText ) ;
    public final void rule__VideoDescription__TextAssignment_3_7_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:3436:1: ( ( ruleText ) )
            // InternalVideoGen.g:3437:1: ( ruleText )
            {
            // InternalVideoGen.g:3437:1: ( ruleText )
            // InternalVideoGen.g:3438:1: ruleText
            {
             before(grammarAccess.getVideoDescriptionAccess().getTextTextParserRuleCall_3_7_1_0()); 
            pushFollow(FOLLOW_2);
            ruleText();

            state._fsp--;

             after(grammarAccess.getVideoDescriptionAccess().getTextTextParserRuleCall_3_7_1_0()); 

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
    // $ANTLR end "rule__VideoDescription__TextAssignment_3_7_1"


    // $ANTLR start "rule__VideoDescription__FilterAssignment_3_8_1"
    // InternalVideoGen.g:3447:1: rule__VideoDescription__FilterAssignment_3_8_1 : ( ruleFilter ) ;
    public final void rule__VideoDescription__FilterAssignment_3_8_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:3451:1: ( ( ruleFilter ) )
            // InternalVideoGen.g:3452:1: ( ruleFilter )
            {
            // InternalVideoGen.g:3452:1: ( ruleFilter )
            // InternalVideoGen.g:3453:1: ruleFilter
            {
             before(grammarAccess.getVideoDescriptionAccess().getFilterFilterParserRuleCall_3_8_1_0()); 
            pushFollow(FOLLOW_2);
            ruleFilter();

            state._fsp--;

             after(grammarAccess.getVideoDescriptionAccess().getFilterFilterParserRuleCall_3_8_1_0()); 

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
    // $ANTLR end "rule__VideoDescription__FilterAssignment_3_8_1"


    // $ANTLR start "rule__Subtitle__TextAssignment_1"
    // InternalVideoGen.g:3462:1: rule__Subtitle__TextAssignment_1 : ( RULE_STRING ) ;
    public final void rule__Subtitle__TextAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:3466:1: ( ( RULE_STRING ) )
            // InternalVideoGen.g:3467:1: ( RULE_STRING )
            {
            // InternalVideoGen.g:3467:1: ( RULE_STRING )
            // InternalVideoGen.g:3468:1: RULE_STRING
            {
             before(grammarAccess.getSubtitleAccess().getTextSTRINGTerminalRuleCall_1_0()); 
            match(input,RULE_STRING,FOLLOW_2); 
             after(grammarAccess.getSubtitleAccess().getTextSTRINGTerminalRuleCall_1_0()); 

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
    // $ANTLR end "rule__Subtitle__TextAssignment_1"


    // $ANTLR start "rule__Subtitle__ColorfontAssignment_2_1_1"
    // InternalVideoGen.g:3477:1: rule__Subtitle__ColorfontAssignment_2_1_1 : ( RULE_STRING ) ;
    public final void rule__Subtitle__ColorfontAssignment_2_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:3481:1: ( ( RULE_STRING ) )
            // InternalVideoGen.g:3482:1: ( RULE_STRING )
            {
            // InternalVideoGen.g:3482:1: ( RULE_STRING )
            // InternalVideoGen.g:3483:1: RULE_STRING
            {
             before(grammarAccess.getSubtitleAccess().getColorfontSTRINGTerminalRuleCall_2_1_1_0()); 
            match(input,RULE_STRING,FOLLOW_2); 
             after(grammarAccess.getSubtitleAccess().getColorfontSTRINGTerminalRuleCall_2_1_1_0()); 

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
    // $ANTLR end "rule__Subtitle__ColorfontAssignment_2_1_1"


    // $ANTLR start "rule__Subtitle__SizeAssignment_2_2_1"
    // InternalVideoGen.g:3492:1: rule__Subtitle__SizeAssignment_2_2_1 : ( RULE_INT ) ;
    public final void rule__Subtitle__SizeAssignment_2_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:3496:1: ( ( RULE_INT ) )
            // InternalVideoGen.g:3497:1: ( RULE_INT )
            {
            // InternalVideoGen.g:3497:1: ( RULE_INT )
            // InternalVideoGen.g:3498:1: RULE_INT
            {
             before(grammarAccess.getSubtitleAccess().getSizeINTTerminalRuleCall_2_2_1_0()); 
            match(input,RULE_INT,FOLLOW_2); 
             after(grammarAccess.getSubtitleAccess().getSizeINTTerminalRuleCall_2_2_1_0()); 

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
    // $ANTLR end "rule__Subtitle__SizeAssignment_2_2_1"


    // $ANTLR start "rule__Text__ContentAssignment_2"
    // InternalVideoGen.g:3507:1: rule__Text__ContentAssignment_2 : ( RULE_STRING ) ;
    public final void rule__Text__ContentAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:3511:1: ( ( RULE_STRING ) )
            // InternalVideoGen.g:3512:1: ( RULE_STRING )
            {
            // InternalVideoGen.g:3512:1: ( RULE_STRING )
            // InternalVideoGen.g:3513:1: RULE_STRING
            {
             before(grammarAccess.getTextAccess().getContentSTRINGTerminalRuleCall_2_0()); 
            match(input,RULE_STRING,FOLLOW_2); 
             after(grammarAccess.getTextAccess().getContentSTRINGTerminalRuleCall_2_0()); 

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
    // $ANTLR end "rule__Text__ContentAssignment_2"


<<<<<<< HEAD
    // $ANTLR start "rule__Text__PositionAssignment_4"
    // InternalVideoGen.g:3522:1: rule__Text__PositionAssignment_4 : ( rulePosition ) ;
    public final void rule__Text__PositionAssignment_4() throws RecognitionException {
=======
    // $ANTLR start "rule__VideoDescription__DurationAssignment_3_1_1"
    // InternalVideoGen.g:1813:1: rule__VideoDescription__DurationAssignment_3_1_1 : ( RULE_FLOAT ) ;
    public final void rule__VideoDescription__DurationAssignment_3_1_1() throws RecognitionException {
>>>>>>> e529713dc2ce4273a0bbf2a0634beb68235d51ef

        		int stackSize = keepStackSize();
            
        try {
<<<<<<< HEAD
            // InternalVideoGen.g:3526:1: ( ( rulePosition ) )
            // InternalVideoGen.g:3527:1: ( rulePosition )
            {
            // InternalVideoGen.g:3527:1: ( rulePosition )
            // InternalVideoGen.g:3528:1: rulePosition
            {
             before(grammarAccess.getTextAccess().getPositionPositionParserRuleCall_4_0()); 
            pushFollow(FOLLOW_2);
            rulePosition();

            state._fsp--;

             after(grammarAccess.getTextAccess().getPositionPositionParserRuleCall_4_0()); 
=======
            // InternalVideoGen.g:1817:1: ( ( RULE_FLOAT ) )
            // InternalVideoGen.g:1818:1: ( RULE_FLOAT )
            {
            // InternalVideoGen.g:1818:1: ( RULE_FLOAT )
            // InternalVideoGen.g:1819:1: RULE_FLOAT
            {
             before(grammarAccess.getVideoDescriptionAccess().getDurationFLOATTerminalRuleCall_3_1_1_0()); 
            match(input,RULE_FLOAT,FOLLOW_2); 
             after(grammarAccess.getVideoDescriptionAccess().getDurationFLOATTerminalRuleCall_3_1_1_0()); 
>>>>>>> e529713dc2ce4273a0bbf2a0634beb68235d51ef

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
    // $ANTLR end "rule__Text__PositionAssignment_4"


<<<<<<< HEAD
    // $ANTLR start "rule__Text__ColorAssignment_6"
    // InternalVideoGen.g:3537:1: rule__Text__ColorAssignment_6 : ( RULE_STRING ) ;
    public final void rule__Text__ColorAssignment_6() throws RecognitionException {
=======
    // $ANTLR start "rule__VideoDescription__ProbabilityAssignment_3_2_1"
    // InternalVideoGen.g:1828:1: rule__VideoDescription__ProbabilityAssignment_3_2_1 : ( RULE_PERCENTAGE ) ;
    public final void rule__VideoDescription__ProbabilityAssignment_3_2_1() throws RecognitionException {
>>>>>>> e529713dc2ce4273a0bbf2a0634beb68235d51ef

        		int stackSize = keepStackSize();
            
        try {
<<<<<<< HEAD
            // InternalVideoGen.g:3541:1: ( ( RULE_STRING ) )
            // InternalVideoGen.g:3542:1: ( RULE_STRING )
            {
            // InternalVideoGen.g:3542:1: ( RULE_STRING )
            // InternalVideoGen.g:3543:1: RULE_STRING
            {
             before(grammarAccess.getTextAccess().getColorSTRINGTerminalRuleCall_6_0()); 
            match(input,RULE_STRING,FOLLOW_2); 
             after(grammarAccess.getTextAccess().getColorSTRINGTerminalRuleCall_6_0()); 
=======
            // InternalVideoGen.g:1832:1: ( ( RULE_PERCENTAGE ) )
            // InternalVideoGen.g:1833:1: ( RULE_PERCENTAGE )
            {
            // InternalVideoGen.g:1833:1: ( RULE_PERCENTAGE )
            // InternalVideoGen.g:1834:1: RULE_PERCENTAGE
            {
             before(grammarAccess.getVideoDescriptionAccess().getProbabilityPERCENTAGETerminalRuleCall_3_2_1_0()); 
            match(input,RULE_PERCENTAGE,FOLLOW_2); 
             after(grammarAccess.getVideoDescriptionAccess().getProbabilityPERCENTAGETerminalRuleCall_3_2_1_0()); 
>>>>>>> e529713dc2ce4273a0bbf2a0634beb68235d51ef

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
    // $ANTLR end "rule__Text__ColorAssignment_6"


    // $ANTLR start "rule__Text__SizeAssignment_8"
    // InternalVideoGen.g:3552:1: rule__Text__SizeAssignment_8 : ( RULE_INT ) ;
    public final void rule__Text__SizeAssignment_8() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:3556:1: ( ( RULE_INT ) )
            // InternalVideoGen.g:3557:1: ( RULE_INT )
            {
            // InternalVideoGen.g:3557:1: ( RULE_INT )
            // InternalVideoGen.g:3558:1: RULE_INT
            {
             before(grammarAccess.getTextAccess().getSizeINTTerminalRuleCall_8_0()); 
            match(input,RULE_INT,FOLLOW_2); 
             after(grammarAccess.getTextAccess().getSizeINTTerminalRuleCall_8_0()); 

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
    // $ANTLR end "rule__Text__SizeAssignment_8"


    // $ANTLR start "rule__FlipFilter__OrientationAssignment_1"
    // InternalVideoGen.g:3567:1: rule__FlipFilter__OrientationAssignment_1 : ( ( rule__FlipFilter__OrientationAlternatives_1_0 ) ) ;
    public final void rule__FlipFilter__OrientationAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalVideoGen.g:3571:1: ( ( ( rule__FlipFilter__OrientationAlternatives_1_0 ) ) )
            // InternalVideoGen.g:3572:1: ( ( rule__FlipFilter__OrientationAlternatives_1_0 ) )
            {
            // InternalVideoGen.g:3572:1: ( ( rule__FlipFilter__OrientationAlternatives_1_0 ) )
            // InternalVideoGen.g:3573:1: ( rule__FlipFilter__OrientationAlternatives_1_0 )
            {
             before(grammarAccess.getFlipFilterAccess().getOrientationAlternatives_1_0()); 
            // InternalVideoGen.g:3574:1: ( rule__FlipFilter__OrientationAlternatives_1_0 )
            // InternalVideoGen.g:3574:2: rule__FlipFilter__OrientationAlternatives_1_0
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
<<<<<<< HEAD
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000300000L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000007000000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000007000002L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000C00000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000000090L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000008000002L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x00000000000000C0L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000FF0000020L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000038000000000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000001080000020L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x000000000000E000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x00000000000F0000L});
=======
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000018000L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000380000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000380002L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000060000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000000090L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x00000000000000C0L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000007800020L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000000000400L});
>>>>>>> e529713dc2ce4273a0bbf2a0634beb68235d51ef

}